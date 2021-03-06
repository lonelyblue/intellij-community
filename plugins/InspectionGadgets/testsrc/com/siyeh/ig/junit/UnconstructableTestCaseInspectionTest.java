/*
 * Copyright 2000-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.siyeh.ig.junit;

import com.intellij.codeInspection.InspectionProfileEntry;
import com.siyeh.ig.LightInspectionTestCase;
import junit.framework.TestCase;
import org.jetbrains.annotations.Nullable;

/**
 * @author Bas Leijdekkers
 */
public class UnconstructableTestCaseInspectionTest extends LightInspectionTestCase {

  public void testUnconstructableJUnit4TestCase() { doTest(); }
  public void testUnconstructableTestCase1() { doTest(); }
  public void testUnconstructableTestCase2() { doTest(); }
  public void testUnconstructableTestCase3() { doTest(); }
  public void testUnconstructableTestCase4() { doTest(); }

  @Nullable
  @Override
  protected InspectionProfileEntry getInspection() {
    return new UnconstructableTestCaseInspection();
  }

  @Override
  protected String[] getEnvironmentClasses() {
    return new String[] {
      "package org.junit; " +
      "public @interface Test {\n" +
      "    java.lang.Class<? extends java.lang.Throwable> expected() default org.junit.Test.None.class;" +
      "}",
      "package junit.framework;" +
      "public abstract class TestCase {}"};
  }
}