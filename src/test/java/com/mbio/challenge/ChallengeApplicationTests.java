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
	void validateAClassPrice() {
		BaseUtils.launchChrome(url());
		agreeAllCookies();
		selectHatchbacksModel();
		hoverOverAClassHatchback();
		selectBuildYourCarAClassHatchBack();
		aClassConfigurator.waitAClassHatchbackPageFullyLoaded();
		aClassConfigurator.selectDiesel();
		BaseUtils.closeBrowser();
	}
}
