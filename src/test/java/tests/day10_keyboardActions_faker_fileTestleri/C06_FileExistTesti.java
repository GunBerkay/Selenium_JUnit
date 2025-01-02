package tests.day10_keyboardActions_faker_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_FileExistTesti {

    @Test
    public void test01(){


        String dosyaYolu="src/test/java/tests/day10_keyboardActions_faker_fileTestleri/deneme.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));

       String dowloadsDosyayolu="C:/Users/gunbe/Downloads/deneme.txt";

        Assertions.assertTrue(Files.exists(Paths.get(dowloadsDosyayolu)));



    }

}
