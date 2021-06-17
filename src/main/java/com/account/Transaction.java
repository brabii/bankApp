package com.account;

public class Transaction {
	private String date;
	private int amount;
	private Operation operation;

	public Transaction(String date, int amount, Operation operation) {
		this.date = date;
		this.amount = amount;
		this.operation = operation;
	}

	public String date() {
		return date;
	}

	public int amount() {
		return amount;
	}

	public Operation operation() {
		return operation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (amount != other.amount)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (operation != other.operation)
			return false;
		return true;
	}

}
