package com.aplana.yandex.pages.market;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.ElementsContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class YandexMarketExtendedSearchPage extends YandexMarketMainPage {
    @FindBy(className = "filter-panel-aside__content")
    public FilterForm filterForm;

    @FindAll(@FindBy(css = ".filter-applied-results"))
    public SearchResults searchResults;

    public static class FilterForm extends ElementsContainer {
        public FilterForm setMinPrice(int price) {
            $("#gf-pricefrom-var").val(Integer.toString(price));
            return this;
        }

        public FilterForm addVendor(String vendor) {
            $(".filter-block__list_type_vendor")
                    .$(By.xpath(".//label[text() = '" + vendor + "']")).click();
            return this;
        }

        public FilterForm applyFilter() {
            $(".button_action_filter-apply").click();
            $(".filter-applied-results_state_loading")
                    .should(Condition.appear)
                    .should(Condition.disappear);
            return this;
        }
    }

    public static class SearchResults extends ElementsContainer {
        @FindAll(@FindBy(css = ".filter-applied-results .snippet-card"))
        public ElementsCollection productCards;

        public String getTitleOfFirstProduct() {
            return productCards.get(0).$(".snippet-card__header-text").text();
        }
    }
}
