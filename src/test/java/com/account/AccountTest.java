package com.account;

import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.given;

import static java.util.Arrays.asList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

	private Account account;

	@Mock
	TransactionRepository transactionRepository;
	@Mock
	Printer printer;

	@Before
	public void init() {
		account = new Account(transactionRepository, printer);
	}

	@Test
	public void depositTransaction() throws Exception {
		account.deposit(150);
		verify(transactionRepository).addDeposit(150);
	}

	@Test
	public void withdrawTransaction() throws Exception {
		account.withDraw(100);
		verify(transactionRepository).addWithDraw(100);
	}

	@Test
	public void printTransactions() throws Exception {
		List<Transaction> transactions = asList(new Transaction("17/06/2021", 100, Operation.DEPOSIT));
		given(transactionRepository.getAllTransactions()).willReturn(transactions);
		account.printStatement();
		verify(printer).print(transactions);
	}
}
