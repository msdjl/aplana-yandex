package com.aplana.yandex.pages.market;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class YandexMarketMainPage {

    @FindBy(className = "topmenu__list")
    public TopMenu topMenu;

    @FindBy(className = "catalog-menu")
    public LeftMenu leftMenu;

    @FindBy(id = "header-search")
    public TopSearchInput topSearchInput;

    public static class TopMenu extends ElementsContainer {
        public void selectCategory(String category, String subCategory) {
            $(By.linkText(category)).hover();
            $(By.linkText(subCategory)).click();
        }

        public YandexMarketCatalogPage selectCategoryAndReturnCatalogPage(String category, String subCategory) {
            selectCategory(category, subCategory);
            return page(YandexMarketCatalogPage.class);
        }
    }

    public static class LeftMenu extends ElementsContainer {
        public YandexMarketCatalogPage selectCategory(String category) {
            $(By.linkText(category)).click();
            return Selenide.page(YandexMarketCatalogPage.class);
        }
    }

    public static class TopSearchInput extends ElementsContainer {
        public YandexMarketProductCard searchForProduct(String query) {
            $("#header-search")
                    .val(query)
                    .pressEnter();
            return page(YandexMarketProductCard.class);
        }
    }
}
