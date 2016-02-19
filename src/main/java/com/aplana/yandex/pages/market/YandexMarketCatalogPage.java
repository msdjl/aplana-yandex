package com.aplana.yandex.pages.market;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class YandexMarketCatalogPage extends YandexMarketMainPage {
    @FindBy(name = "hand-select")
    public FilterForm filterForm;

    public static class FilterForm extends ElementsContainer {
        @FindBy(css = "td.more a")
        public SelenideElement extendedSearchLink;

        public YandexMarketExtendedSearchPage openExtendedSearch() {
            extendedSearchLink.click();
            return page(YandexMarketExtendedSearchPage.class);
        }
    }
}
