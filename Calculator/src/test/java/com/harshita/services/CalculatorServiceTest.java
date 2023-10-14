package com.harshita.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorServiceTest {


	
	CalculatorService cs = new CalculatorService();

	@Test
	void test1() {
		int expected=14;
		int actual=cs.add(7, 7);
		assertEquals(expected,actual);
	}
	
	@Test
	void test2() {
		int expected=0;
		int actual=cs.sub(7, 7);
		assertEquals(expected,actual);
	}
	
	@Test
	void test3() {
		int expected=49;
		int actual=cs.multiply(7, 7);
		assertEquals(expected,actual);
	}
	
	@Test
	void test4() {
		int expected=1;
		int actual=cs.divide(7, 7);
		assertEquals(expected,actual);
	}
}
