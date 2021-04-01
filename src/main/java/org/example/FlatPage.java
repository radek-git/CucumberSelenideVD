package org.example;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.example.model.Flat;

import static com.codeborne.selenide.Selenide.*;
import static org.example.FlatPage.XPATH.*;

public class FlatPage {

    static class XPATH{
        public static final String FLAT_NUMBER_BR = "//div[@class='apartment__info']/h1";
        public static final String NUMBER_OF_ROOMS = "//div[@class='apartment__info-box']/ul/li[contains(text(), 'Pokoje')]/span";
        public static final String FLOOR = "(//div[@class='apartment__info-box']/ul/li/span)[2]";
        public static final String SPACE = "//div[@class='apartment__info-box']/ul/li[contains(text(), 'Metra')]/span";
        public static final String DOWNLOAD_PLAN_BUTTON = "//div[@class='apartment__buttons']/a[@class='download-pdf']";
        public static final String ASK_FOR_PRICE_BUTTON = "//div[@class='apartment__buttons']/div[@class='button--primary']";
        public static final String NAME_INPUT = "//input[@class='contact__input']";
        public static final String PHONE_INPUT = "//input[@id='phone']";
        public static final String EMAIL_INPUT = "//input[@id='email']";
        public static final String CHECKBOX_YES = "//label[@for='form_contact_dyw_vc_yes']";
        public static final String CHECKBOX_AGREEMENT1 = "//label[@for='agreement']";
        public static final String CHECKBOX_AGREEMENT2 = "//label[@for='agreement1']";
        public static final String CHECKBOX_AGREEMENT3 = "//label[@for='agreement33']";
        public static final String SEND_EMAIL_BUTTON = "//button[@type='submit']";


    }

    public int getFlatNumber() {
        String[] strings = $x(FLAT_NUMBER_BR).getText().split(":");

        return Integer.parseInt(strings[1].replaceFirst("\n", "").replaceAll(" ", ""));
    }

    public int getNumberOfRooms() {
        return Integer.parseInt($x(NUMBER_OF_ROOMS).getText().replace(" ", ""));
    }

    public String getFloor() {
        return $x(FLOOR).getText().replaceAll(" ", "");
    }

    public double getSpace() {
        return Double.parseDouble($x(SPACE).getText().replaceAll(" ", "")
                .replace("m", ""));
    }

    public Flat getFlatDetails() {
        return new Flat(getFlatNumber(), getNumberOfRooms(), getFloor(), getSpace());
    }

    public FlatPage downloadFlatPlan() {
        $x(DOWNLOAD_PLAN_BUTTON).click();
        return new FlatPage();
    }

    public FlatPage clickAskForPriceButton() {
        $x(ASK_FOR_PRICE_BUTTON).click();
        return new FlatPage();
    }

    public FlatPage completeAgreements() {
        $x(CHECKBOX_YES).click();
        $x(CHECKBOX_AGREEMENT1).click();
        $x(CHECKBOX_AGREEMENT2).click();
        $x(CHECKBOX_AGREEMENT3).click();
        return new FlatPage();
    }

    public FlatPage completeForm() throws InterruptedException {
        Faker faker = new Faker();

        $x(NAME_INPUT).waitUntil(Condition.visible, 5000).sendKeys(faker.name().firstName() + " " + faker.name().lastName());
        $x(PHONE_INPUT).waitUntil(Condition.visible, 5000).sendKeys(faker.numerify("#########"));
        $x(EMAIL_INPUT).sendKeys("fofavig302@fw025.com");
        completeAgreements();
//        $x(SEND_EMAIL_BUTTON).click();
        Thread.sleep(3000);
        return new FlatPage();
    }



}
