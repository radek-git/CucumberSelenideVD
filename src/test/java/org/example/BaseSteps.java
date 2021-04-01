package org.example;

import com.codeborne.selenide.Configuration;

public class BaseSteps {

    public BaseSteps() {
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;
    }
}
