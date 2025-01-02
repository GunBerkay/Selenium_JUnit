package tests.day10_keyboardActions_faker_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_DosyaYolunuDinamikYapma {

    @Test
    public void test01(){

        String herkesteFarkliOlanKisim=System.getProperty("user.home");
        System.out.println(herkesteFarkliOlanKisim);
        //        C:\Users\gunbe

        String herkestAyniOlanKisim="/Downloads/deneme.txt";

        String dowlandsDenemeDosyaYolu=herkesteFarkliOlanKisim + herkestAyniOlanKisim;
        Assertions.assertTrue(Files.exists(Paths.get(dowlandsDenemeDosyaYolu)));

        String herkesteFarkliOlanProjeDosyasiYolu=System.getProperty("user.dir");

        System.out.println(herkesteFarkliOlanProjeDosyasiYolu);

        String herkesteAyniOlanProjedekiDenemeDosyaYolu="src/test/java/tests/day10_keyboardActions_faker_fileTestleri/deneme.txt";








    }

}
