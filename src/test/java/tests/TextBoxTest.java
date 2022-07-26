package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));
        $("#userName").setValue("Ilia");
        $("#userEmail").setValue("box@mail.com");
        $("#currentAddress").setValue("Adress 1, Country 1");
        $("#permanentAddress").setValue("Adress 2, Country 2");
        $("#submit").click();

        $("#output").shouldHave(text("Ilia"), text("box@mail.com"),
                text("Adress 1, Country 1"), text("Adress 2, Country 2"));

        //варианты использования
        $("#name").shouldHave(text("Ilia"));
        $ ("#currentAddress").shouldHave(text("Adress 1, Country 1")); //wrong
        $("#currentAddress",1).shouldHave(text("Adress 1, Country 1"));
        $("#output").$("#currentAddress").shouldHave(text("Adress 1, Country 1"));
        $("#output #currentAddress").shouldHave(text("Adress 1, Country 1"));

        $("#output").shouldHave(text("Ilia"), text("box@mail.com"),
                text("Adress 1, Country 1"), text("Adress 2, Country 2"));

      }

}
