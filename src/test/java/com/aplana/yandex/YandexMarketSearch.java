package com.aplana.yandex;

import com.aplana.yandex.pages.YandexMainPage;
import com.aplana.yandex.pages.market.YandexMarketCatalogPage;
import com.aplana.yandex.pages.market.YandexMarketExtendedSearchPage;
import com.aplana.yandex.pages.market.YandexMarketMainPage;
import com.codeborne.selenide.Condition;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class YandexMarketSearch {
    YandexMarketMainPage market;

    @Before
    public void setUp() throws Exception {
        YandexMainPage yandex = open("http://yandex.ru", YandexMainPage.class);
        market = yandex.openMarket();
    }

    @Test
    public void testTVsSearch() throws Exception {
        YandexMarketCatalogPage catalog = market.topMenu.selectCategoryAndReturnCatalogPage("Электроника", "Телевизоры");
        YandexMarketExtendedSearchPage searchPage = catalog.filterForm.openExtendedSearch();

        searchPage.filterForm
                .setMinPrice(20000)
                .addVendor("LG")
                .addVendor("Samsung")
                .applyFilter();

        searchPage.searchResults.productCards.shouldHaveSize(10);

        String firstItemTitle = searchPage.searchResults.getTitleOfFirstProduct();

        searchPage.topSearchInput.searchForProduct(firstItemTitle)
                .title.shouldHave(Condition.exactTextCaseSensitive(firstItemTitle));
    }

    @Test
    public void testHeadphonesSearch() throws Exception {
        market.topMenu.selectCategory("Электроника", "Плееры и наушники");
        YandexMarketCatalogPage catalog = market.leftMenu.selectCategory("Наушники");
        YandexMarketExtendedSearchPage searchPage = catalog.filterForm.openExtendedSearch();

        searchPage.filterForm
                .setMinPrice(5000)
                .addVendor("Beats")
                .applyFilter();

        searchPage.searchResults.productCards.shouldHaveSize(10);

        String firstItemTitle = searchPage.searchResults.getTitleOfFirstProduct();

        searchPage.topSearchInput.searchForProduct(firstItemTitle)
                .title.shouldHave(Condition.exactTextCaseSensitive(firstItemTitle));
    }
}
