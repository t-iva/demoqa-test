package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void AutomationPracticeFormTest() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Ilya");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ilya@company.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("9279000259");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1987");
        $(".react-datepicker__month-select").selectOptionContainingText("August");
        $(".react-datepicker__day--004").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("History").pressEnter();
        $(byText("Sports")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resourses/picture1.jpg"));
        $("#currentAddress").setValue("1st Street");
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#react-select-4-input").setValue("Jaipur").pressEnter();
        $(byText("Submit")).click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Ilya Ivanov"));
        $(".table-responsive").shouldHave(text("ilya@company.com"));
        $(".table-responsive").shouldHave(text("9279000259"));
        $(".table-responsive").shouldHave(text("9279000259"));
        $(".table-responsive").shouldHave(text("Maths, History"));
        $(".table-responsive").shouldHave(text("Sports, Music"));
        $(".table-responsive").shouldHave(text("picture1.jpg"));
        $(".table-responsive").shouldHave(text("1st Street"));
        $(".table-responsive").shouldHave(text("Rajasthan Jaipur"));
        $(byText("Close")).click();

    }
}

