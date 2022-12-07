package com.webappsecurity.test.uitests;

import com.webappsecurity.test.pages.FeedbackPage;
import com.webappsecurity.test.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class FeedbackFormValidationTests extends BaseTest {

	@Autowired
	HomePage homePage;

	@Autowired
	FeedbackPage feedbackForm;

	@BeforeEach
	void setup() {
		navigateTo("http://zero.webappsecurity.com/index.html");
		homePage.navigateToFeedback();
	}

	@ParameterizedTest
	@CsvSource({"John Carter,john.c@gmail.com,Subject sample,This is a comment"})
	void verifyFormAcceptsValidData(String name, String email, String subject, String comment) {
		feedbackForm
				.typeName(name)
				.typeEmail(email)
				.typeSubject(subject)
				.typeComment(comment)
				.sendMessage();
		assertTrue(feedbackForm.isResponseTextDisplayed());
	}

	@Test
	void verifyFormDoesNotWorkOnEmptyData() {
		feedbackForm
				.sendMessage();
		assertFalse(feedbackForm.isResponseTextDisplayed());
	}

	@ParameterizedTest
	@CsvSource({"243223,not an email,@#233,1122  44  "})
	void verifyFormRejectsInvalidData(String name, String email, String subject, String comment) {
		feedbackForm
				.typeName(name)
				.typeEmail(email)
				.typeSubject(subject)
				.typeComment(comment)
				.sendMessage();
		assertFalse(feedbackForm.isResponseTextDisplayed());
	}

	@Test
	void verifyFormRemovesWhiteSpace() {
		String space = " ";
		feedbackForm
				.typeName(space)
				.typeEmail(space)
				.typeSubject(space)
				.typeComment(space)
				.sendMessage();
		assertFalse(feedbackForm.isResponseTextDisplayed());
	}
}
