// This is a generated file. Not intended for manual editing.
package org.elixir_lang.psi;

import com.ericsson.otp.erlang.OtpErlangObject;
import com.intellij.psi.PsiElement;
import org.apache.commons.lang.math.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface ElixirUnmatchedDotCall extends ElixirUnmatchedExpression, DotCall {

  @Nullable
  ElixirDoBlock getDoBlock();

  @NotNull
  ElixirDotInfixOperator getDotInfixOperator();

  @NotNull
  List<ElixirParenthesesArguments> getParenthesesArgumentsList();

  @NotNull
  ElixirUnmatchedExpression getUnmatchedExpression();

  @Nullable
  String functionName();

  @Nullable
  PsiElement functionNameElement();

  boolean isCalling(String resolvedModuleName, String resolvedFunctionName);

  boolean isCalling(String resolvedModuleName, String resolvedFunctionName, int resolvedFinalArity);

  boolean isCallingMacro(String resolvedModuleName, String resolvedFunctionName, int resolvedFinalArity);

  @Nullable
  String moduleName();

  @NotNull
  PsiElement[] primaryArguments();

  @Nullable
  Integer primaryArity();

  @NotNull
  OtpErlangObject quote();

  @NotNull
  int resolvedFinalArity();

  @NotNull
  IntRange resolvedFinalArityRange();

  @Nullable
  String resolvedFunctionName();

  @Nullable
  String resolvedModuleName();

  @Nullable
  Integer resolvedPrimaryArity();

  @Nullable
  Integer resolvedSecondaryArity();

  @Nullable
  PsiElement[] secondaryArguments();

  @Nullable
  Integer secondaryArity();

}
