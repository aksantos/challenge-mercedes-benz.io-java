package com.mbio.challenge;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pages.AClassHatchbackPage;
import pages.BasePage;
import utils.BaseUtils;


@SpringBootTest
class ChallengeApplicationTests extends BasePage {

	AClassHatchbackPage aClassConfigurator = new AClassHatchbackPage();
	@Test
	void validateAClassPriceWithChrome() {
		BaseUtils.launchChrome(url());
		agreeAllCookies();
		selectHatchbacksModel();
		hoverOverAClassHatchback();
		selectBuildYourCarAClassHatchBack();
		aClassConfigurator.selectDiesel();
		takeScreenshot(getInsideShadowDOM(aClassConfigurator.carConfiguratorShadowDOM(),aClassConfigurator.fuelFilter()));
		aClassConfigurator.saveHighAndLowerAClassHatchbacksPricesToFile();
		BaseUtils.closeBrowser();
	}
	@Test
	void validateAClassPriceWithEdge() {
		BaseUtils.launchEdge(url());
		agreeAllCookies();
		selectHatchbacksModel();
		hoverOverAClassHatchback();
		selectBuildYourCarAClassHatchBack();
		aClassConfigurator.selectDiesel();
		takeScreenshot(getInsideShadowDOM(aClassConfigurator.carConfiguratorShadowDOM(),aClassConfigurator.fuelFilter()));
		aClassConfigurator.saveHighAndLowerAClassHatchbacksPricesToFile();
		BaseUtils.closeBrowser();
	}
}
