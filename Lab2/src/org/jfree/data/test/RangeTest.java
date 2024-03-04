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
	
	
	
}
