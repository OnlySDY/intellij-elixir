// This is a generated file. Not intended for manual editing.
package org.elixir_lang.eex;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.elixir_lang.eex.psi.Types.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class Parser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == COMMENT_TAG) {
      r = commentTag(b, 0);
    }
    else if (t == ELIXIR_TAG) {
      r = elixirTag(b, 0);
    }
    else if (t == MARKER) {
      r = marker(b, 0);
    }
    else if (t == QUOTATION_TAG) {
      r = quotationTag(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return eexFile(b, l + 1);
  }

  /* ********************************************************** */
  // OPENING_COMMENT COMMENT? CLOSING
  public static boolean commentTag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commentTag")) return false;
    if (!nextTokenIs(b, OPENING_COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPENING_COMMENT);
    r = r && commentTag_1(b, l + 1);
    r = r && consumeToken(b, CLOSING);
    exit_section_(b, m, COMMENT_TAG, r);
    return r;
  }

  // COMMENT?
  private static boolean commentTag_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commentTag_1")) return false;
    consumeToken(b, COMMENT);
    return true;
  }

  /* ********************************************************** */
  // DATA? (tags DATA?)?
  static boolean eexFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eexFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eexFile_0(b, l + 1);
    r = r && eexFile_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DATA?
  private static boolean eexFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eexFile_0")) return false;
    consumeToken(b, DATA);
    return true;
  }

  // (tags DATA?)?
  private static boolean eexFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eexFile_1")) return false;
    eexFile_1_0(b, l + 1);
    return true;
  }

  // tags DATA?
  private static boolean eexFile_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eexFile_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tags(b, l + 1);
    r = r && eexFile_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DATA?
  private static boolean eexFile_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eexFile_1_0_1")) return false;
    consumeToken(b, DATA);
    return true;
  }

  /* ********************************************************** */
  // OPENING marker? ELIXIR? CLOSING
  public static boolean elixirTag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elixirTag")) return false;
    if (!nextTokenIs(b, OPENING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPENING);
    r = r && elixirTag_1(b, l + 1);
    r = r && elixirTag_2(b, l + 1);
    r = r && consumeToken(b, CLOSING);
    exit_section_(b, m, ELIXIR_TAG, r);
    return r;
  }

  // marker?
  private static boolean elixirTag_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elixirTag_1")) return false;
    marker(b, l + 1);
    return true;
  }

  // ELIXIR?
  private static boolean elixirTag_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elixirTag_2")) return false;
    consumeToken(b, ELIXIR);
    return true;
  }

  /* ********************************************************** */
  // EQUALS_MARKER | FORWARD_SLASH_MARKER | PIPE_MARKER
  public static boolean marker(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "marker")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MARKER, "<marker>");
    r = consumeToken(b, EQUALS_MARKER);
    if (!r) r = consumeToken(b, FORWARD_SLASH_MARKER);
    if (!r) r = consumeToken(b, PIPE_MARKER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OPENING_QUOTATION QUOTATION? CLOSING
  public static boolean quotationTag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quotationTag")) return false;
    if (!nextTokenIs(b, OPENING_QUOTATION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPENING_QUOTATION);
    r = r && quotationTag_1(b, l + 1);
    r = r && consumeToken(b, CLOSING);
    exit_section_(b, m, QUOTATION_TAG, r);
    return r;
  }

  // QUOTATION?
  private static boolean quotationTag_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quotationTag_1")) return false;
    consumeToken(b, QUOTATION);
    return true;
  }

  /* ********************************************************** */
  // elixirTag | commentTag | quotationTag
  static boolean tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elixirTag(b, l + 1);
    if (!r) r = commentTag(b, l + 1);
    if (!r) r = quotationTag(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // tag (DATA? tag)*
  static boolean tags(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tags")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tag(b, l + 1);
    r = r && tags_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (DATA? tag)*
  private static boolean tags_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tags_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!tags_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tags_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // DATA? tag
  private static boolean tags_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tags_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tags_1_0_0(b, l + 1);
    r = r && tag(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DATA?
  private static boolean tags_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tags_1_0_0")) return false;
    consumeToken(b, DATA);
    return true;
  }

}
