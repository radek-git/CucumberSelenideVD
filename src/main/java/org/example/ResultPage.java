package org.example;

import com.codeborne.selenide.SelenideElement;
import org.example.model.Flat;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.example.ResultPage.XPATH.*;

public class ResultPage {

    static class XPATH{
        public static final String FLAT_IN_ROW = "//div[@class='table__body']/a";
        public static final String NEXT_PAGE_ACTIVE_BUTTON = "//div[@class='pagination']/ul/li[@class='js-next']";


    }


    public List<Flat> getFlatDetails() throws InterruptedException {

        boolean isNextButtonActive;
        List<Flat> flatList = new ArrayList<>();

        do {
            int numberOfRows = $$x(FLAT_IN_ROW).size();

            for (int i = 1; i <= numberOfRows; i++) {
                SelenideElement flatInRow = $x(FLAT_IN_ROW);
                actions().keyDown(Keys.LEFT_CONTROL).click(flatInRow).keyUp(Keys.LEFT_CONTROL).build().perform();
                switchTo().window(1);

                FlatPage flatPage = new FlatPage();

                Flat flat = flatPage.getFlatDetails();
                flatList.add(flat);
                flatPage.clickAskForPriceButton().completeForm().completeAgreements();

                closeWindow();
                switchTo().window(0);
            }
            isNextButtonActive = $x(NEXT_PAGE_ACTIVE_BUTTON).exists();


        } while (isNextButtonActive);

        return flatList;
    }
}
