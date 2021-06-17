package com.account;

import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Printer {
	private static final String STATEMENT_HEADER = "Operation / Transaction date / Transaction amount / Balance";
	private DecimalFormat decimalFormat = new DecimalFormat("#.00");
	private ConsolePrinter console;

	public Printer(ConsolePrinter console) {
		this.console = console;
	}

	public void print(List<Transaction> transactions) {
		console.printALine(STATEMENT_HEADER);
		AtomicInteger balance = new AtomicInteger(0);
		for (Transaction transaction : transactions) {
			console.printALine(statementLine(transaction, balance));
		}
	}

	private String statementLine(Transaction transaction, AtomicInteger balance) {
	// @formatter:off
		return transaction.operation() 
				+ " / " + transaction.date() 
				+ " / " + decimalFormat.format(transaction.amount())
				+ " / " + decimalFormat.format(balance.addAndGet(transaction.amount()));
	}
	// @formatter:on
}
