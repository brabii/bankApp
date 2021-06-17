package com.account;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.junit.Test;

public class DateFormatTest {

	@Test
	public void shouldReturnDateInDD_MM_YYYY_Format() throws Exception {
		DateFormat dateFormat = new TestDateFormat();
		String date = dateFormat.dateAsString();
		assertThat(date, is("17/06/2021"));
	}

	private class TestDateFormat extends DateFormat {
		@Override
		protected LocalDate now() {
			return LocalDate.of(2021, 06, 17);
		}
	}
}
