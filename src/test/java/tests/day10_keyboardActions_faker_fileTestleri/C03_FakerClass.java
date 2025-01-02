package tests.day10_keyboardActions_faker_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import utilities.TestBase_Each;

public class C03_FakerClass extends TestBase_Each {

    @Test
    public void test01(){

        Faker faker =new Faker();

        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.name().nameWithMiddle());
        System.out.println(faker.name().fullName());

        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.internet().password());


    }
}
