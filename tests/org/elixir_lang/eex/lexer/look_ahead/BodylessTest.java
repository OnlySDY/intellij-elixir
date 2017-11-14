package org.elixir_lang.eex.lexer.look_ahead;

import com.intellij.psi.tree.IElementType;
import org.apache.commons.lang.ArrayUtils;
import org.elixir_lang.eex.lexer.Flex;
import org.elixir_lang.eex.psi.Types;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(Parameterized.class)
public class BodylessTest extends Test {
    private static final Lex[][] PREFIXES = new Lex[][]{
            {new Lex("<%#", Types.OPENING_COMMENT, Flex.COMMENT)},
            {new Lex("<%%", Types.OPENING_QUOTATION, Flex.QUOTATION)},
            {new Lex("<%", Types.OPENING, Flex.MARKER_MAYBE), new Lex("/", Types.FORWARD_SLASH_MARKER, Flex.ELIXIR)},
            {new Lex("<%", Types.OPENING, Flex.MARKER_MAYBE), new Lex("=", Types.EQUALS_MARKER, Flex.ELIXIR)},
            {new Lex("<%", Types.OPENING, Flex.MARKER_MAYBE), new Lex("|", Types.PIPE_MARKER, Flex.ELIXIR)}
    };
    private static final Lex[] SUFFIX = new Lex[]{
            new Lex("%>", Types.CLOSING, Flex.YYINITIAL)
    };

    public BodylessTest(@NotNull Sequence sequence) {
        super(sequence);
    }

    @Contract(pure = true)
    @NotNull
    @Parameterized.Parameters(name = "#{index} {0}")
    public static Iterable<Object> parameters() {
        return Arrays.stream(PREFIXES).<Object>map(prefix -> {
            Lex[] lexes = new Lex[prefix.length + SUFFIX.length];
            System.arraycopy(prefix, 0, lexes, 0, prefix.length);
            System.arraycopy(SUFFIX, 0, lexes, prefix.length, SUFFIX.length);

            return new Sequence(lexes);
        })::iterator;
    }

    @Override
    protected void start(@NotNull CharSequence charSequence) {
        super.start(charSequence + "%>");
    }

    @org.junit.Test
    public void bodyless() {
        assertSequence();
    }
}
