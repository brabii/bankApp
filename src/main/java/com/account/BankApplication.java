package com.account;

public class BankApplication {

	public static void main(String[] args) {
		DateFormat dateFormat = new DateFormat();
		TransactionRepository transactionRepository = new TransactionRepository(dateFormat);
		ConsolePrinter console = new ConsolePrinter();
		Printer printer = new Printer(console);
		Account account = new Account(transactionRepository, printer);
		account.deposit(1000);
		account.withDraw(400);
		account.deposit(100);
		account.printStatement();
	}
}
