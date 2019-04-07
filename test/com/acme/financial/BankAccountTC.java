package com.acme.financial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankAccountTC {
	
	public void testTransfer() throws Exception {
		BankAccount acct1 = new BankAccount(100);
		BankAccount acct2 = new BankAccount(100);
		
		assertNotNull(acct1);
		assertEquals(100, acct1.getBalance(), "balance should be 100");
		
		assertNotNull(acct2);
		assertEquals(100, acct2.getBalance(), "balance should be 100");
		
		acct1.transfer(25, acct2);
		assertEquals(75, acct1.getBalance(), "balance acct1 should be 75");
		assertEquals(125, acct2.getBalance(), "balance acct2 should be 125");
	}
	
	@Test
	public void testWithdrawException() throws Exception {
		BankAccount acct = new BankAccount(100);
		
		assertNotNull(acct);
		assertEquals(100, acct.getBalance(), "balance should be 100");
		
		// withdraw 150
		
		try {
			acct.withdraw(150);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "insufficient funds");
		}
		
	}
	
	@Test
	public void testWithdraw() throws Exception {
		BankAccount acct = new BankAccount(100);
		
		assertNotNull(acct);
		assertEquals(100, acct.getBalance(), "balance should be 100");
		
		// withdraw 50
		acct.withdraw(50);
		assertEquals(50, acct.getBalance(), "balance should be 50");
	}
	
	@Test
	public void testDeposit() throws Exception {
		BankAccount acct = new BankAccount(0);
		
		assertNotNull(acct);
		assertEquals(0, acct.getBalance(), "balance should be 0");
		
		acct.deposit(100);
		assertEquals(100, acct.getBalance(), "balance should be 100");
	}

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

}
