package com.account;

public class Account {
	private Printer printer;
	private TransactionRepository transactionRepository;

	public Account(TransactionRepository transactionRepository, Printer printer) {
		this.transactionRepository = transactionRepository;
		this.printer = printer;
	}

	public void deposit(int amount) {
		transactionRepository.addDeposit(amount);
	}

	public void withDraw(int amount) {
		transactionRepository.addWithDraw(amount);
	}

	public void printStatement() {
		printer.print(transactionRepository.getAllTransactions());
	}
}
