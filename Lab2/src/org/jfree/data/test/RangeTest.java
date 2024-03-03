package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {
	
	private Range rangeObjectUnderTest1;
	private Range rangeObjectUnderTest2;
	private Range combinedRange;
	private Range overlapRange;
	
	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest1 = new Range(-1,1);
		rangeObjectUnderTest2 = new Range(20,31);
		overlapRange = new Range(5,25);
	}
	
	@After
	public void tearDown() throws Exception {
		rangeObjectUnderTest1 = null;
		rangeObjectUnderTest2 = null;
		combinedRange = null;
		overlapRange = null;
	}
	
	// Combine method tests
	@Test
	public void testCombineRange1ValidRange2Null() {
		//exercise
		combinedRange = Range.combine(rangeObjectUnderTest1, null);
		//verify
		assertEquals("The combined range of range1 and null should equal range1",
				rangeObjectUnderTest1, combinedRange);
	}
	
	@Test
	public void testCombineRange1NullRange2Valid() {
		//exercise
		combinedRange = Range.combine(null, rangeObjectUnderTest1);
		//verify
		assertEquals("The combined range of null and range2 should equal range2",
				rangeObjectUnderTest1, combinedRange);
	}
	
	@Test
	public void testCombineLowRange1AndHighRange2() {
		try {
			//exercise
			combinedRange = Range.combine(rangeObjectUnderTest1, rangeObjectUnderTest2);
			//verify
			assertEquals("The combined range of Range 1 and 2 should have the lower bound of range 1 and the upper bound of range 2",
					new Range(-1,31), combinedRange);
			
		} catch (Exception e) {
			fail("An exception should not have been thrown: " + e.getMessage());
		}
	}
	
	@Test
	public void testCombineHighRange1AndLowRange2() {
		//exercise
		combinedRange = Range.combine(rangeObjectUnderTest2, rangeObjectUnderTest1);
		//verify
		assertEquals("The combined range of Range 1 and 2 should have the lower bound of range 2 and the upper bound of range 1",
				new Range(-1,31), combinedRange);
		
	}
	
	@Test
	public void testCombineOverlappingRanges() {
		try {
			//exercise
			combinedRange = Range.combine(overlapRange, rangeObjectUnderTest2);
			//verify
			assertEquals("The combined range of Range 1 and 2 should have the lower bound of range 2 and the upper bound of range 1",
					new Range(5,31),combinedRange);
		} catch (Exception e) {
			fail("An exception should not have been thrown: " + e.getMessage());
		}
		
	}
	
	@Test
	public void testCombineIdenticalRanges() {
		//exercise
		combinedRange = Range.combine(rangeObjectUnderTest1, rangeObjectUnderTest1);
		//verify
		assertEquals("The combined range of 2 identical ranges should return the same range",
				rangeObjectUnderTest1, combinedRange);
		
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
					0, rangeObjectUnderTest1.getCentralValue(), 0.000000001d);
		
	}
}
