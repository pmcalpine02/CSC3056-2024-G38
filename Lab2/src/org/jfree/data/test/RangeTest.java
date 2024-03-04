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
		rangeObjectUnderTest = new Range(-1,1);
		negativeRange = new Range(-10,-1);
		positiveRange = new Range(20,31);
		negAndPosRange = new Range(-20,25);		
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
	
	// Combine method tests
	@Test
	public void testCombineRangeAndNull() {
		//exercise
		combinedRange = Range.combine(negativeRange, null);
		//verify
		assertEquals("The combined range of range1 and null should equal range1",
				negativeRange, combinedRange);
	}
	
	@Test
	public void testCombineNullAndRange() {
		//exercise
		combinedRange = Range.combine(null, negativeRange);
		//verify
		assertEquals("The combined range of null and range2 should equal range2",
				negativeRange, combinedRange);
	}
	
	@Test
	public void testCombineNegativeRange1AndPositiveRange2() {
		try {
			//exercise
			combinedRange = Range.combine(negativeRange, positiveRange);
			//verify
			assertEquals("The combined range of Range 1 and 2 should take the lower bound from range1 and the upper bound from range2",
					new Range(-10,31), combinedRange);
			
		} catch (Exception e) {
			fail("An exception should not have been thrown: " + e.getMessage());
		}
	}
	
	@Test
	public void testCombinePositiveRange1AndNegativeRange2() {
		//exercise
		combinedRange = Range.combine(positiveRange, negativeRange);
		//verify
		assertEquals("The combined range of Range 1 and 2 should have the lower bound of range 2 and the upper bound of range 1",
				new Range(-10,31), combinedRange);
	}
	
	@Test
	public void testCombineOverlappingRanges() {
		try {
			//exercise
			combinedRange = Range.combine(negAndPosRange, positiveRange);
			//verify
			assertEquals("The combined range of Range 1 and 2 should have the lower bound of range 2 and the upper bound of range 1",
					new Range(-20,31),combinedRange);
		} catch (Exception e) {
			fail("An exception should not have been thrown: " + e.getMessage());
		}
	}
	
	@Test
	public void testCombineIdenticalRanges() {
		//exercise
		combinedRange = Range.combine(negativeRange, negativeRange);
		//verify
		assertEquals("The combined range of 2 identical ranges should return the same range",
				negativeRange, combinedRange);
	}
	
	@Test
	public void testCombineBothNullRanges() {
		//exercise
		combinedRange = Range.combine(null, null);
		//verify
		assertNull("The combined range of null and null should equal null", combinedRange);
	}
	
	@Test
	public void testCentralValueShouldBeZero() {		
		assertEquals("The central value of -1 and 1 should be 0",
					0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
	
	// expand tests
	@Test
	public void testExpandbyZeroOnBothMargins() {
		//exercise
		expandedRange = Range.expand(negAndPosRange, 0, 0);
		//verify
		assertEquals("The range should be unchanged",
				negAndPosRange, expandedRange);
	}
	
	@Test
	public void testExpandLowerAndUpperMarginsBetweenZeroAndOne() {
		//exercise
		
		expandedRange = Range.expand(negAndPosRange, 0.25, 0.75);
		//verify
		assertEquals("Range expanded by 25% and 75% on both sides respectively",new Range(-31.25,58.75),expandedRange);
	}
	
	@Test
	public void testExpandLowerAndUpperMarginsBothEqualOne() {
		//exercise
		expandedRange = Range.expand(negAndPosRange, 1, 1);
		//verify
		assertEquals("Range expanded by 100% on both sides ",new Range(-65,70),expandedRange);
	}

	@Test
	public void testExpandByLowerMarginZeroAndUpperMarginBetweenZeroAndOne() {
		//exercise
		expandedRange = Range.expand(negAndPosRange, 0, 0.5);
		//verify
		assertEquals("Upper bound of range should increase by 50%",new Range(-20,47.5),expandedRange);	
	}

	@Test
	public void testExpandByLowerMarginBetweenZeroAndOneAndUpperMarginZero() {
		//exercise
		expandedRange = Range.expand(negAndPosRange, 0.5, 0);
		//verify
		assertEquals("Lower bound of range should increase by 50% ",new Range(-42.5,25),expandedRange);	
	}

	@Test
	public void testExpandBothMarginsNegative() {
		
		try {
			//exercise
			expandedRange = Range.expand(negAndPosRange, -0.25, -0.25);
			assertEquals("Range should have reduced by 25% on both sides",new Range(-8.75,13.75),expandedRange);
		}
		catch (Exception e) {
			fail("Exception should not be thrown and range should have reduced by 25% on both sides");
		}
		
		//verify
		assertEquals("Range should have reduced by 25% on both sides",new Range(-8.75,13.75),expandedRange);
	}

	@Test
	public void testExpandByLowerMarginNegativeAndUpperMarginBetweenZeroAndOne() {
		//exercise
		expandedRange = Range.expand(negAndPosRange, -0.25, 0.5);
		//verify
		System.out.println(expandedRange);
		assertEquals("Range should have reduced by 25% on lower margin and increased by 50% on upper margin sides",new Range(-8.75,47.5),expandedRange);
	}

	@Test
	public void testExpandByLowerMarginBetweenZeroAndOneAndUpperMarginNegative() {
		//exercise
		expandedRange = Range.expand(negAndPosRange, 0.5, -0.25);
		//verify
		assertEquals("Range should be expanded by 50% in the lower margin and then reduced by 25% in the upper",new Range(-42.5,13.75),expandedRange);
	}

	@Test
	public void testExpandByBothMarginsGreaterThanOne() {
		//exercise
		expandedRange = Range.expand(negAndPosRange, 10, 10);
		//verify
		assertEquals("Range should expanded by 1000% on both sides",new Range(-470,475),expandedRange);
	}
	
	@Test
	public void testExpandNullRange() {
		try {
			//exercise
			expandedRange = Range.expand(null, 0.25, 0.75);
			fail("No error thrown");
		}catch(Exception e) {
			//verify
			System.out.println(e.getClass());
			assertTrue("Wrong exception thrown, should be InvalidParameterException", e.getClass().equals(InvalidParameterException.class));	
		}
	}
	
	//intersects
	@Test
	public void testIntersectLowerAndUpperBothBelowLowerBound() {
		//exercise
		boolean result = negAndPosRange.intersects(-21, -21);
		//verify
		assertTrue("Should equal false", !result);
	}
	
	@Test
	public void testIntersectLowerLessThanLowerBoundAndUpperEqualtoLowerBound() {
		//exercise
		boolean result = negAndPosRange.intersects(-21, -20);
		//verify
		assertTrue("Should equal true", result);
	}
	
	@Test
	public void testIntersectLowerLessThanLowerBoundAndUpperBetweenBounds() {
		//exercise
		boolean result = negAndPosRange.intersects(-21, 24);
		//verify
		assertTrue("Should equal true", result);
	}
	
	@Test
	public void testIntersectLowerLessThanLowerBoundAndUpperGreaterThanUpperBound() {
		//exercise
		boolean result = negAndPosRange.intersects(-21, 26);
		//verify
		assertTrue("Should equal true", result);
	}
	
	@Test
	public void testIntersectLowerAndUpperEqualToLowerBound() {
		//exercise
		boolean result = negAndPosRange.intersects(-20, -20);
		//verify
		assertTrue("Should equal true", result);
	}
	
	@Test
	public void testIntersectLowerEqualToLowerBoundAndUpperEqualToUpperBound() {
		//exercise
		boolean result = negAndPosRange.intersects(-20, 25);
		//verify
		assertTrue("Should equal true", result);
	}
	
	
	@Test
	public void testIntersectLowerAndUpperBetweenBounds() {
		//exercise
		boolean result = negAndPosRange.intersects(-19, 24);
		//verify
		assertTrue("Should equal true", result);
	}
	
	@Test
	public void testIntersectLowerBetweenBoundsAndUpperGreaterThanUpperBound() {
		//exercise
		boolean result = negAndPosRange.intersects(-19, 26);
		//verify
		assertTrue("Should equal true", result);
	}
	
	@Test
	public void testIntersectLowerAndUpperEqualToUpperBound() {
		//exercise
		boolean result = negAndPosRange.intersects(19, 25);
		//verify
		assertTrue("Should equal true", result);
	}
	
	@Test
	public void testIntersectLowerAndUpperGreaterThanUpperBound() {
		//exercise
		boolean result = negAndPosRange.intersects(26, 26);
		//verify
		assertTrue("Should equal false", !result);
	}
	
	@Test
	public void testIntersectLowerGreaterThanUpperBoundAndUpperLessThanLowerBound() {
		try {
			//exercise
			boolean result = negAndPosRange.intersects(26, -21);
			fail("Error should be thrown");
		} catch(Exception e){
			//verify
			assertTrue("Wrong exception thrown, should be InvalidParameterException", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	//getLowerBound()
	@Test
	public void testGetLowerBoundNegative() {
		//exercise
		lowerBound = negativeRange.getLowerBound();
		//verify
		assertEquals("Should equal -10", lowerBound, -10, 0.000001d);
	}
	
	@Test
	public void testGetLowerBoundPositive() {
		//exercise
		lowerBound = positiveRange.getLowerBound();
		//verify
		assertEquals("Should equal 20", lowerBound, 20, 0.000001d);
	}
	
	@Test
	public void testGetLowerBoundZero() {
		//exercise
		lowerBound = new Range(0,20).getLowerBound();
		//verify
		assertEquals("Should equal 0", lowerBound, 0, 0.000001d);
	}
	
	@Test
	public void testGetLowerBoundVerySmall() {
		//exercise
		lowerBound = new Range(-1.78E+308,20).getLowerBound();
		//verify
		assertEquals("Should equal -1.78E+308 ", lowerBound, -1.78E+308, 0.000001d );
	}
	
	@Test
	public void testGetLowerBoundVeryLarge() {
		//exercise
		lowerBound = new Range(1.78E+308,1.79E+308).getLowerBound();
		//verify
		assertEquals("Should equal 1.78E+308 ", lowerBound, 1.78E+308, 0.000001d);
	}
	
	@Test
	public void testGetLowerBoundWhereBoundsAreEqual() {
		//exercise
		lowerBound = new Range(10,10).getLowerBound();
		//verify
		assertEquals("Should equal 10", lowerBound, 10, 0.000001d);
	}
	
	

	//getUpperBound()
	@Test
	public void testGetUpperBoundNegative() {
		//exercise
		upperBound = negativeRange.getUpperBound();
		//verify
		assertEquals("Should equal -1", upperBound, -1, 0.000001d);
	}
	
	@Test
	public void testGetUpperBoundPositive() {
		//exercise
		upperBound = positiveRange.getUpperBound();
		//verify
		assertEquals("Should equal 31", upperBound, 31, 0.000001d);
	}
	
	@Test
	public void testGetUpperBoundZero() {
		//exercise
		upperBound = new Range(-20,0).getUpperBound();
		//verify
		assertEquals("Should equal 0", upperBound, 0, 0.000001d);
	}
	
	@Test
	public void testGetUpperBoundVerySmall() {
		//exercise
		upperBound = new Range(-1.79E+308,-1.78E+308).getUpperBound();
		//verify
		assertEquals("Should equal -1.78E+308 ", upperBound, -1.78E+308, 0.000001d );
	}
	
	@Test
	public void testGetUpperBoundVeryLarge() {
		//exercise
		upperBound = new Range(10,1.78E+308).getUpperBound();
		//verify
		assertEquals("Should equal 1.78E+308 ", upperBound, 1.78E+308, 0.000001d);
	}
	
	@Test
	public void testGetUpperBoundWhereBoundsAreEqual() {
		//exercise
		upperBound = new Range(10,10).getUpperBound();
		//verify
		assertEquals("Should equal 10", upperBound, 10, 0.000001d);
	}
	

	
	
}
