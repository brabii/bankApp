package com.account;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryTest {
	@Mock
	DateFormat dateFormat;
	private static final String TEST_DATE = "17/06/2021";
	private TransactionRepository transactionRepository;

	@Before
	public void init() {
		this.transactionRepository = new TransactionRepository(dateFormat);
	}

	@Test
	public void shoudCreateAndSaveDepositTransaction() throws Exception {
		given(dateFormat.dateAsString()).willReturn(TEST_DATE);
		transactionRepository.addDeposit(100);
		List<Transaction> transactions = transactionRepository.getAllTransactions();
		assertThat(transactions.size(), is(1));
		assertThat(transactions.get(0), is(transaction(TEST_DATE, 100)));
	}

	@Test
	public void shouldCreateAndSaveWithDrawTransaction() throws Exception {
		given(dateFormat.dateAsString()).willReturn(TEST_DATE);
		transactionRepository.addWithDraw(100);
		List<Transaction> transactions = transactionRepository.getAllTransactions();
		assertThat(transactions.size(), is(1));
		assertThat(transactions.get(0), is(transaction(TEST_DATE, -100)));
	}

	private Transaction transaction(String date, int amount) {
		if (amount >= 0)
			return new Transaction(date, amount, Operation.DEPOSIT);
		return new Transaction(date, amount, Operation.WITHDRAW);
	}

}
