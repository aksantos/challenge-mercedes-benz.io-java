package com.mbio.challenge;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pages.BasePage;
import utils.BaseUtils;

import static utils.BaseUtils.driver;


@SpringBootTest
class ChallengeApplicationTests extends BasePage {


	@Test
	void validateAClassPrice() {
		BaseUtils.launchChrome(url());
		agreeAllCookies();
		selectHatchbacksModel();
		BaseUtils.closeBrowser();
	}
}
