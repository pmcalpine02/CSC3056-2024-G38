package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {

	private Range rangeObjectUnderTest;
	private Range negativeRange;
	private Range positiveRange;
	private Range negAndPosRange;
	private Range combinedRange;
	private Range expandedRange;
	private double lowerBound;
	private double upperBound;
	private boolean result;

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
		negativeRange = new Range(-10, -1);
		positiveRange = new Range(20, 31);
		negAndPosRange = new Range(-20, 25);
	}

	@After
	public void tearDown() throws Exception {
		rangeObjectUnderTest = null;
		negativeRange = null;
		positiveRange = null;
		negAndPosRange = null;
		combinedRange = null;
		expandedRange = null;
	}

	/* Combine method tests */
	@Test //TC1
	public void testCombineRangeWithNull() {
		// exercise
		combinedRange = Range.combine(negAndPosRange, null);
		// verify
		assertEquals("The combined range of range1 and null should equal range1", negAndPosRange, combinedRange);
	}
	
	@Test //TC2
	public void testCombineOverlappingRangesWithPositiveRange2() {
		try {
			// exercise
			combinedRange = Range.combine(negAndPosRange, positiveRange);
			// verify
			assertEquals(
					"The combined range of Range 1 and 2 should have the lower bound of range 2 and the upper bound of range 1",
					new Range(-20, 31), combinedRange);
		} catch (Exception e) {
			fail("An exception should not have been thrown: " + e.getMessage());
		}
	}
	
	@Test //TC3
	public void testCombineOverlappingRangesWithNegativeRange2() {
		try {
			// exercise
			combinedRange = Range.combine(negAndPosRange, negativeRange);
			// verify
			assertEquals(
					"The combined range of Range 1 and 2 should have the lower bound of range 1 and the upper bound of range 1",
					new Range(-20, 25), combinedRange);
		} catch (Exception e) {
			fail("An exception should not have been thrown: " + e.getMessage());
		}
	}
	
	@Test //TC4
	public void testCombinePositiveRange1WithNegativeRange2() {
		// exercise
		combinedRange = Range.combine(positiveRange, negativeRange);
		// verify
		assertEquals(
				"The combined range of Range 1 and 2 should have the lower bound of range 2 and the upper bound of range 1",
				new Range(-10, 31), combinedRange);
	}
	
	@Test //TC5
	public void testCombinePositiveRange1WithNegAndPosRange2() {
		// exercise
		combinedRange = Range.combine(positiveRange, negAndPosRange);
		// verify
		assertEquals(
				"The combined range of Range 1 and 2 should have the lower bound of range 2 and the upper bound of range 1",
				new Range(-20, 31), combinedRange);
	}
	
	@Test //TC6
	public void testCombineIdenticalRangesPositive() {
		// exercise
		combinedRange = Range.combine(positiveRange, positiveRange);
		// verify
		assertEquals("The combined range of 2 identical ranges should return the same range", positiveRange,
				combinedRange);
	}

	@Test //TC7
	public void testCombineNegativeRange1WithPositiveRange2() {
		try {
			// exercise
			combinedRange = Range.combine(negativeRange, positiveRange);
			// verify
			assertEquals(
					"The combined range of Range 1 and 2 should take the lower bound from range1 and the upper bound from range2",
					new Range(-10, 31), combinedRange);

		} catch (Exception e) {
			fail("An exception should not have been thrown: " + e.getMessage());
		}
	}
	
	@Test //TC8
	public void testCombineNegativeRange1WithNegAndPosRange() {
		// exercise
		combinedRange = Range.combine(negativeRange, negAndPosRange);
		// verify
		assertEquals("The combined range of Range 1 and 2 should take the lower and upper bound from range 2", negAndPosRange,
				combinedRange);
	}


	@Test //TC9
	public void testCombineIdenticalRangesNegative() {
		// exercise
		combinedRange = Range.combine(negativeRange, negativeRange);
		// verify
		assertEquals("The combined range of 2 identical ranges should return the same range", negativeRange,
				combinedRange);
	}
	
	@Test //TC10
	public void testCombineNullWithRange() {
		// exercise
		combinedRange = Range.combine(null, negativeRange);
		// verify
		assertEquals("The combined range of null and range2 should equal range2", negativeRange, combinedRange);
	}

	@Test //TC11
	public void testCombineBothNullRanges() {
		// exercise
		combinedRange = Range.combine(null, null);
		// verify
		assertNull("The combined range of null and null should equal null", combinedRange);
	}

	/* intersect method tests */
	@Test //TC1
	public void testIntersectsFallingBeforeTheRange() {
		// exercise
		boolean result = negAndPosRange.intersects(-30, -25);
		// verify
		assertFalse("Both values before the range should equal false", result);
	}

	@Test //TC2
	public void testIntersectOneBeforeTheRangeAndOneWithin() {
		// exercise
		boolean result = negAndPosRange.intersects(-30, 10);
		// verify
		assertTrue("One intersect is between the bounds and the other is less, should equal true", result);
	}
	
	@Test //TC3
	public void testIntersectsEngulfingRange() {
		// exercise
		boolean result = negAndPosRange.intersects(-30, 30);
		// verify
		assertTrue("Range is within intersects, should equal true", result);
	}

	@Test //TC4
	public void testIntersectBetweenRangeBounds() {
		// exercise
		boolean result = negAndPosRange.intersects(-10, 10);
		// verify
		assertTrue("Both within bounds should equal true", result);
	}

	@Test //TC5
	public void testIntersectOneBetweenAndOneAboveBounds() {
		// exercise
		boolean result = negAndPosRange.intersects(-10, 30);
		// verify
		assertTrue("One between and the other greater should equal true", result);
	}

	@Test //TC6
	public void testIntersectInvalidLowerIntersectGreaterThanHigherIntersect() {
		try {
			// exercise
			negAndPosRange.intersects(30, -30);
			fail("Error should be thrown");
		} catch (Exception e) {
			// verify
			assertTrue("Wrong exception thrown, should be InvalidParameterException",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test //TC7
	public void testIntersectGreaterThanRange() {
		// exercise
		boolean result = negAndPosRange.intersects(30, 30);
		// verify
		assertFalse("Both intersects greater than upper bound should return false", result);
	}
	
	@Test //TC8
	public void testIntersectLowerBoundaryPlus1Analysis() {
		// exercise
		boolean result = negAndPosRange.intersects(-19, -19);
		// verify
		assertTrue("should equal true as both values are between bounds", result);
	}
	
	@Test //TC9
	public void testIntersectLowerBoundaryMinus1Analysis() {
		// exercise
		boolean result = negAndPosRange.intersects(-21, -21);
		// verify
		assertFalse("should equal false as both values are below the lower bounds", result);
	}
	
	@Test //TC10
	public void testIntersectUpperBoundaryPlus1Analysis() {
		// exercise
		boolean result = negAndPosRange.intersects(26, 26);
		// verify
		assertFalse("should equal false as both values are greater than the upper bounds", result);
	}
	
	@Test //TC11
	public void testIntersectUpperBoundaryMinus1Analysis() {
		// exercise
		boolean result = negAndPosRange.intersects(24, 24);
		// verify
		assertTrue("should equal true as both values are between bounds", result);
	}
	
	@Test //TC12
	public void testIntersectsEqualToLowerBound() {
		// exercise
		boolean result = negAndPosRange.intersects(-20, -20);
		// verify
		assertTrue("Both values on the lower boundary should equal true", result);
	}
	
	@Test //TC13
	public void testIntersectsEqualToUpperBound() {
		// exercise
		boolean result = negAndPosRange.intersects(25, 25);
		// verify
		assertTrue("Both on boundaries should equal true", result);
	}
	
	@Test //TC14
	public void testIntersectLowerEqualToLowerBoundAndUpperEqualToUpperBound() {
		// exercise
		boolean result = negAndPosRange.intersects(-20, 25);
		// verify
		assertTrue("Intersect values the same as the lower and upper bounds should equal true", result);
	}
	
	/* expand method tests */
	@Test //TC1
	public void testExpandbyZeroOnBothMargins() {
		// exercise
		expandedRange = Range.expand(negAndPosRange, 0, 0);
		// verify
		assertEquals("The range should be unchanged", negAndPosRange, expandedRange);
	}

	@Test //TC2
	public void testExpandLowerAndUpperMarginsBetweenZeroAndOne() {
		// exercise

		expandedRange = Range.expand(negAndPosRange, 0.25, 0.75);
		// verify
		assertEquals("Range should expanded by 25% and 75% on both sides respectively", new Range(-31.25, 58.75),
				expandedRange);
	}

	@Test //TC3
	public void testExpandLowerAndUpperMarginsBothEqualOne() {
		// exercise
		expandedRange = Range.expand(negAndPosRange, 1, 1);
		// verify
		assertEquals("Range should have expanded by 100% on both sides ", new Range(-65, 70), expandedRange);
	}

	@Test //TC4
	public void testExpandByLowerMarginZeroAndUpperMarginBetweenZeroAndOne() {
		// exercise
		expandedRange = Range.expand(negAndPosRange, 0, 0.5);
		// verify
		assertEquals("Upper bound of range should increase by 50%", new Range(-20, 47.5), expandedRange);
	}

	@Test //TC5
	public void testExpandByLowerMarginBetweenZeroAndOneAndUpperMarginZero() {
		// exercise
		expandedRange = Range.expand(negAndPosRange, 0.5, 0);
		// verify
		assertEquals("Lower bound of range should increase by 50% ", new Range(-42.5, 25), expandedRange);
	}

	@Test //TC6
	public void testExpandBothMarginsNegative() {

		try {
			// exercise
			expandedRange = Range.expand(negAndPosRange, -0.25, -0.25);
			assertEquals("Range should have reduced by 25% on both sides", new Range(-8.75, 13.75), expandedRange);
		} catch (Exception e) {
			fail("Exception should not be thrown and range should have reduced by 25% on both sides:  " + e.getMessage());
		}

		// verify
		assertEquals("Range should have reduced by 25% on both sides", new Range(-8.75, 13.75), expandedRange);
	}

	@Test //TC7
	public void testExpandByLowerMarginNegativeAndUpperMarginBetweenZeroAndOne() {
		// exercise
		expandedRange = Range.expand(negAndPosRange, -0.25, 0.5);
		// verify
		System.out.println(expandedRange);
		assertEquals("Range should have reduced by 25% on lower margin and increased by 50% on upper margin sides",
				new Range(-8.75, 47.5), expandedRange);
	}

	@Test //TC8
	public void testExpandByLowerMarginBetweenZeroAndOneAndUpperMarginNegative() {
		// exercise
		expandedRange = Range.expand(negAndPosRange, 0.5, -0.25);
		// verify
		assertEquals("Range should be expanded by 50% in the lower margin and then reduced by 25% in the upper",
				new Range(-42.5, 13.75), expandedRange);
	}

	@Test //TC9
	public void testExpandByBothMarginsGreaterThanOne() {
		// exercise
		expandedRange = Range.expand(negAndPosRange, 10, 10);
		// verify
		assertEquals("Range should expanded by 1000% on both sides", new Range(-470, 475), expandedRange);
	}

	@Test //TC10
	public void testExpandNullRange() {
		try {
			// exercise
			expandedRange = Range.expand(null, 0.25, 0.75);
			fail("No error thrown");
		} catch (Exception e) {
			// verify
			System.out.println(e.getClass());
			assertTrue("Wrong exception thrown, should be InvalidParameterException",
					e.getClass().equals(InvalidParameterException.class));
		}
	}
	
	

	/* getLowerBound method tests */
	@Test //TC1
	public void testGetLowerBoundNegative() {
		// exercise
		lowerBound = negativeRange.getLowerBound();
		// verify
		assertEquals("Should equal -10", lowerBound, -10, 0.000001d);
	}

	@Test //TC2
	public void testGetLowerBoundPositive() {
		// exercise
		lowerBound = positiveRange.getLowerBound();
		// verify
		assertEquals("Should equal 20", lowerBound, 20, 0.000001d);
	}

	@Test //TC3
	public void testGetLowerBoundZero() {
		// exercise
		lowerBound = new Range(0, 20).getLowerBound();
		// verify
		assertEquals("Should equal 0", lowerBound, 0, 0.000001d);
	}

	@Test //TC4
	public void testGetLowerBoundVerySmall() {
		// exercise
		lowerBound = new Range(-1.78E+308, 20).getLowerBound();
		// verify
		assertEquals("Should equal -1.78E+308 ", lowerBound, -1.78E+308, 0.000001d);
	}

	@Test //TC5
	public void testGetLowerBoundVeryLarge() {
		// exercise
		lowerBound = new Range(1.78E+308, 1.79E+308).getLowerBound();
		// verify
		assertEquals("Should equal 1.78E+308 ", lowerBound, 1.78E+308, 0.000001d);
	}

	@Test //TC6
	public void testGetLowerBoundWhereBoundsAreEqual() {
		// exercise
		lowerBound = new Range(10, 10).getLowerBound();
		// verify
		assertEquals("Should equal 10", lowerBound, 10, 0.000001d);
	}
	

	/* getUpperBound method tests */
	@Test //TC1
	public void testGetUpperBoundNegative() {
		// exercise
		upperBound = negativeRange.getUpperBound();
		// verify
		assertEquals("Should equal -1", upperBound, -1, 0.000001d);
	}

	@Test //TC2
	public void testGetUpperBoundPositive() {
		// exercise
		upperBound = positiveRange.getUpperBound();
		// verify
		assertEquals("Should equal 31", upperBound, 31, 0.000001d);
	}

	@Test //TC3
	public void testGetUpperBoundZero() {
		// exercise
		upperBound = new Range(-20, 0).getUpperBound();
		// verify
		assertEquals("Should equal 0", upperBound, 0, 0.000001d);
	}

	@Test //TC4
	public void testGetUpperBoundVerySmall() {
		// exercise
		upperBound = new Range(-1.79E+308, -1.78E+308).getUpperBound();
		// verify
		assertEquals("Should equal -1.78E+308 ", upperBound, -1.78E+308, 0.000001d);
	}

	@Test //TC5
	public void testGetUpperBoundVeryLarge() {
		// exercise
		upperBound = new Range(10, 1.78E+308).getUpperBound();
		// verify
		assertEquals("Should equal 1.78E+308 ", upperBound, 1.78E+308, 0.000001d);
	}

	@Test //TC6
	public void testGetUpperBoundWhereBoundsAreEqual() {
		// exercise
		upperBound = new Range(10, 10).getUpperBound();
		// verify
		assertEquals("Should equal 10", upperBound, 10, 0.000001d);
	}

	
	// get central value test
	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0", 0, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}
}
