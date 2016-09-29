package edu.gordon.banking;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyTest {

	Money money = new Money(0);
	
	@Test
	public void testAdd() 
	{
		int incremental = 10;
		long expected = money.getCents() + incremental;
		money.add(new Money(0,incremental));		
		assertTrue(money.getCents() == expected);
		
		incremental = 0;
		expected = money.getCents() + incremental;
		money.add(new Money(0,incremental));		
		assertTrue(money.getCents() == expected);
		
		incremental = -10;
		expected = money.getCents() + incremental;
		money.add(new Money(0,incremental));		
		assertTrue(money.getCents() == expected);
	}

	@Test
	public void testSubtract() {
		//test decremental
		int decremental = 10;
		long expected = money.getCents() - decremental;	
		money.subtract(new Money(0, decremental));
		assertTrue(money.getCents() == expected);
		
		//test equal
		decremental = 0;
		expected = money.getCents() - decremental;	
		money.subtract(new Money(0, decremental));
		assertTrue(money.getCents() == expected);
		
		//test incremental
		decremental = -10;
		expected = money.getCents() - decremental;	
		money.subtract(new Money(0, decremental));
		assertTrue(money.getCents() == expected);
		
	}

	@Test
	public void testLessEqual() 
	{
		//Check for smaller value
		Money compareMoney = new Money(100000);
		assertTrue(money.lessEqual(compareMoney));
		
		//Check for greater value
		compareMoney = new Money(-100000);
		assertFalse(money.lessEqual(compareMoney));
		
		//Check for equal value
		compareMoney = money;
		assertTrue(money.lessEqual(compareMoney));
	}

}
