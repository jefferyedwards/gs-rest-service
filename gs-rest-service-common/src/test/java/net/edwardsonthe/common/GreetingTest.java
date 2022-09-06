package net.edwardsonthe.common;

import static org.junit.Assert.*;

import org.junit.Test;

public class GreetingTest {

	@Test
	public void testGreeting() {
		Greeting greeting = new Greeting(1, "test");
		assertEquals(1, greeting.getId());
		assertEquals("test", greeting.getContent());
	}

}
