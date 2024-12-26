package tests.day06_assertions_testBaseKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C03_AssertionMethodlari {

    String str1="Java candir";
    String s="Java";
    String t="Hava";
    String k="java";

    @Test
    public void test01() {

        Assertions.assertTrue(str1.contains("Java"));

        Assertions.assertFalse(str1.contains("Ali"));

        Assertions.assertEquals("Java",s);

        Assertions.assertNotEquals("t","Tava");

    }

    @Test
    public void test02(){

        Assertions.assertEquals("s","k");


    }

}
