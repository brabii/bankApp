package com.account;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormat {

	public String dateAsString() {
		return now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	protected LocalDate now() {
		return LocalDate.now();
	}

}
