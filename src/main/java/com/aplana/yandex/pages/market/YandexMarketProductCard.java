package com.aplana.yandex.pages.market;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class YandexMarketProductCard extends YandexMarketMainPage {
    @FindBy(css = ".product-card__header .title")
    public SelenideElement title;
}
