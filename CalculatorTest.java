package edu.metrostate.ics240.STP059.p3.calc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testDefaultConstruction() {
		Calculator c = new Calculator();
		assertEquals(true, c.isEmpty());
		assertEquals(0, c.size());
	}

	@Test
	public void testEnter() {
		Towers t = new Towers(numRings);

		assertTrue(t.move(1, 2));
		assertEquals(numRings - 1, t.getRingCount(1));
		assertEquals(1, t.getRingCount(2));
		assertEquals(0, t.getRingCount(3));

		assertEquals(2, t.getTopDiameter(1));
		assertEquals(1, t.getTopDiameter(2));
		assertEquals(0, t.getTopDiameter(3));

		assertTrue(t.move(1, 3));
		assertEquals(numRings - 2, t.getRingCount(1));
		assertEquals(1, t.getRingCount(2));
		assertEquals(1, t.getRingCount(3));

		assertEquals(3, t.getTopDiameter(1));
		assertEquals(1, t.getTopDiameter(2));
		assertEquals(2, t.getTopDiameter(3));
	}

	@Test
	public void testInvalidConstructor(){
		Towers t = null;
		try {
			t = new Towers(0); // illegal value
			fail("Expected exception");
		} catch (IllegalArgumentException iae) {
			// expected
		}
		
		try {
			t = new Towers(MAX_NUM_RINGS + 1); // illegal value
			fail("Expected exception");
		} catch (IllegalArgumentException iae) {
			// expected
		}
	}
	@Test
	public void testPreconditionGetRingCount() {
		Towers t = new Towers();
		try {
			t.getRingCount(0);
			fail("Exception expected");
		} catch (IllegalArgumentException iae) {
			// expected
		}
		try {
			t.getRingCount(4);
			fail("Exception expected");
		} catch (IllegalArgumentException iae) {
			// expected
		}
	}
	
	@Test
	public void testPreconditionTopRing() {
		Towers t = new Towers();
		try {
			t.getTopDiameter(0);
			fail("Exception expected");
		} catch (IllegalArgumentException iae) {
			// expected
		}
		try {
			t.getTopDiameter(4);
			fail("Exception expected");
		} catch (IllegalArgumentException iae) {
			// expected
		}
	}
	
	@Test
	public void testIllegalMoves(){
		Towers t = new Towers();

		t.move(1, 2);
		t.move(1, 3);
		
		assertFalse(t.move(1, 1)); // can't move to itself
		assertFalse(t.move(1, 2)); // moving larger ring to smaller
		assertFalse(t.move(1, 3)); // moving larger ring to smaller
		assertFalse(t.move(3, 2));
	}
}
