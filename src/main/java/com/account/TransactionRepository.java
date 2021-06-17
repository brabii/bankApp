package com.account;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
	private final DateFormat dateFormat;
	private List<Transaction> transactions = new ArrayList<>();

	public TransactionRepository(DateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	public void addDeposit(int amount) {
		Transaction DepositTransaction = new Transaction(dateFormat.dateAsString(), amount, Operation.DEPOSIT);
		transactions.add(DepositTransaction);
	}

	public void addWithDraw(int amount) {
		Transaction withDrawTransaction = new Transaction(dateFormat.dateAsString(), -amount, Operation.WITHDRAW);
		transactions.add(withDrawTransaction);
	}

	public List<Transaction> getAllTransactions() {
		return transactions;
	}
}
