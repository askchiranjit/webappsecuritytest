package com.webappsecurity.test.uitests;

import com.webappsecurity.test.pages.HomePage;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ComponentScan(basePackages = {"com.webappsecurity.test"})
class TabNavigationTests extends BaseTest {

	@Autowired
	HomePage homeTab;

	@BeforeEach
	void setup() {
		navigateTo("http://zero.webappsecurity.com/index.html");
	}

	@Test
	void verifyTabsInLandingPage() {
		assertTrue(homeTab.isHomeTabDisplayed());
		assertTrue(homeTab.isHomeTabActive());
		assertTrue(homeTab.isOnlineBankingTabDisplayed());
		assertTrue(homeTab.isFeedbackTabDisplayed());
	}

	@Test
	void verifyNavigationToOnlineBankingTab() {
		homeTab.navigateToOnlineBanking();
		assertTrue(homeTab.isOnlineBankingTabDisplayed());
		assertTrue(homeTab.isOnlineBankingTabActive());
		assertTrue(homeTab.isHomeTabDisplayed());
		assertTrue(homeTab.isFeedbackTabDisplayed());
	}

	@Test
	void verifyNavigationToFeedbackTab() {
		homeTab.navigateToFeedback();
		assertTrue(homeTab.isFeedbackTabDisplayed());
		assertTrue(homeTab.isFeedbackTabActive());
		assertTrue(homeTab.isHomeTabDisplayed());
		assertTrue(homeTab.isOnlineBankingTabDisplayed());
	}

	@Test
	void verifyTabSwitchingFunctionality() {
		homeTab
				.navigateToOnlineBanking()
				.navigateToHome();
		assertTrue(homeTab.isHomeTabDisplayed());
		assertTrue(homeTab.isHomeTabActive());
		assertTrue(homeTab.isOnlineBankingTabDisplayed());
		assertTrue(homeTab.isFeedbackTabDisplayed());
	}

}
