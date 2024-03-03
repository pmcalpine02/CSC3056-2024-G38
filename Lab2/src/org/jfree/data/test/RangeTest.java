package org.jfree.data.test;

import static org.junit.Assert.*;

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
	
	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1,1);
		negativeRange = new Range(-10,-1);
		positiveRange = new Range(20,31);
		negAndPosRange = new Range(-20,25);
		
		System.out.println(negAndPosRange.toString());
	}
	
	@After
	public void tearDown() throws Exception {
		negativeRange = null;
		positiveRange = null;
		combinedRange = null;
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
}
