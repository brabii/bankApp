package com.account;

import static java.util.Arrays.asList;
import static java.util.Collections.EMPTY_LIST;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.inOrder;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PrinterTest {

	private static final List<Transaction> NO_TRANSACTIONS = EMPTY_LIST;
	private static final String HEADER = "Operation / Transaction date / Transaction amount / Balance";
	private Printer printer;
	@Mock
	ConsolePrinter console;

	@Before
	public void init() {
		printer = new Printer(console);
	}

	@Test
	public void shouldPrintHeader() throws Exception {
		printer.print(NO_TRANSACTIONS);
		verify(console).printALine(HEADER);
	}

	@Test
	public void shouldPrintTransactions() throws Exception {
		// @formatter:off
		List<Transaction> transactions = transactions(
									deposit("17/06/2021", 1000), 
									withdraw("16/06/2021", 100),
									deposit("15/06/2021", 400));
		// @formatter:on
		printer.print(transactions);
		InOrder inOrder = inOrder(console);
		inOrder.verify(console).printALine(HEADER);
		inOrder.verify(console).printALine("DEPOSIT / 17/06/2021 / 1000,00 / 1000,00");
		inOrder.verify(console).printALine("WITHDRAW / 16/06/2021 / -100,00 / 900,00");
		inOrder.verify(console).printALine("DEPOSIT / 15/06/2021 / 400,00 / 1300,00");
	}

	private List<Transaction> transactions(Transaction... transactions) {
		return asList(transactions);
	}

	private Transaction deposit(String date, int amount) {
		return new Transaction(date, amount, Operation.DEPOSIT);
	}

	private Transaction withdraw(String date, int amount) {
		return new Transaction(date, -amount, Operation.WITHDRAW);
	}
}
