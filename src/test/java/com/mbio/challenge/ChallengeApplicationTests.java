package com.mbio.challenge;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pages.AClassHatchbackPage;
import pages.BasePage;
import utils.BaseUtils;


@SpringBootTest
class ChallengeApplicationTests extends BasePage {

	AClassHatchbackPage aClassHatchback = new AClassHatchbackPage();
	@Test
	void validateAClassPriceWithChrome() {
		BaseUtils.launchChrome(url());
		agreeAllCookies();
		selectHatchbacksModel();
		hoverOverAClassHatchback();
		selectBuildYourCarAClassHatchBack();
		aClassHatchback.validatePageTitle();
		aClassHatchback.selectDiesel();
		aClassHatchback.takeCarsScreenshot();
		aClassHatchback.validatePrices(15000, 60000);
		aClassHatchback.saveHighAndLowerPricesToFile();
		BaseUtils.closeBrowser();
	}
	@Test
	void validateAClassPriceWithEdge() {
		BaseUtils.launchEdge(url());
		agreeAllCookies();
		selectHatchbacksModel();
		hoverOverAClassHatchback();
		selectBuildYourCarAClassHatchBack();
		aClassHatchback.validatePageTitle();
		aClassHatchback.selectDiesel();
		aClassHatchback.takeCarsScreenshot();
		aClassHatchback.validatePrices(15000, 60000);
		aClassHatchback.saveHighAndLowerPricesToFile();
		BaseUtils.closeBrowser();
	}
}
