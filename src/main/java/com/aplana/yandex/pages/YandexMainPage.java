package com.aplana.yandex.pages;

import com.aplana.yandex.pages.market.YandexMarketMainPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class YandexMainPage {
    public YandexMarketMainPage openMarket() {
        $(".home-arrow__tabs").$(By.linkText("Маркет")).click();
        return page(YandexMarketMainPage.class);
    }
}