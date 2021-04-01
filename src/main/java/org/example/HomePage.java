package org.example;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;
import static org.example.HomePage.XPATH.*;

public class HomePage {

    static class XPATH{
        public static final String COOKIE_TEXT = "//div[@class='cookies__text']";
        public static final String COOKIE_CLOSE_BUTTON = "//div[contains(@class, 'cookies__close')]";

    }

    public HomePage closeCookies() {
        if ($x(COOKIE_TEXT).isDisplayed()) {
            $x(COOKIE_CLOSE_BUTTON).click();
        }
        return new HomePage();
    }

    public HomePage selectCity(String city) {
        $x("//nav/ul/li/a[contains(text(),'" + city + "')]").click();
        return new HomePage();
    }

    public ResultPage clickPropertyName(String property) {
        $x("(//a[contains(@class, 'banner--header')]/div[contains(@class, 'banner__content')]/h2[contains(@class, 'banner__heading') and text()='" + property + "'])[2]").click();
        return new ResultPage();
    }


}
