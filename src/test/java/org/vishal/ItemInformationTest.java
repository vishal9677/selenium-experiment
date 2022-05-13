package org.vishal;

import org.vishal.model.SortOption;
import org.vishal.pages.HomePage;
import org.vishal.utils.PropertiesHolder;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class, PropertiesHolder.class})
public class ItemInformationTest extends BaseTest{
    @Autowired
    private PropertiesHolder properties;
    @Autowired
    private HomePage homePage;

    @BeforeEach
    void openBrowser(){
        startBrowserAndInitialize(homePage);
    }

    @Test
    void aboutItemTest() {
        homePage.goTo(properties.getAppUrl());
        var isAboutItemPresent = homePage.viewAllTelevisions()
                .selectBrand("Samsung")
                .sortBy(SortOption.PRICE_HIGH_TO_LOW)
                .navigateToResult(2)
                .isAboutItemPresent();
        assertThat("Information about item is not present",isAboutItemPresent, is(equalTo(true)));
        homePage.getInfoAboutItem().and().printItemInfo();
    }

    @AfterEach
    void tearDown(){
        closeBrowser();
    }

}
