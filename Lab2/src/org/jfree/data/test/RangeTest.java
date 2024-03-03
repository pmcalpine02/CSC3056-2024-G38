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
	
	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest1 = new Range(-1,1);
		rangeObjectUnderTest2 = new Range(20,31);
		System.out.println(Range.combine(rangeObjectUnderTest2, rangeObjectUnderTest1).getUpperBound());
	}
	
	@After
	public void tearDown() throws Exception {
		rangeObjectUnderTest1 = null;
		rangeObjectUnderTest2 = null;
		combinedRange = null;
	}
	@Test
	public void test() {
		assertTrue(new Range(-1,31) == new Range(-1,31));
		
	}
	
	// Combine method tests
	
	@Test
	public void testCombineRange1Valid() {
		assertEquals("The combined range of range1 and null should equal range1",
				rangeObjectUnderTest1, Range.combine(rangeObjectUnderTest1, null));
	}
	
	@Test
	public void testCombineRange2Valid() {
		assertEquals("The combined range of null and range2 should equal range2",
				rangeObjectUnderTest1, Range.combine(null, rangeObjectUnderTest1));
	}
	
	@Test
	public void testCombineRange1LowRange2High() {
		try {
			assertEquals("The combined range of Range 1 and 2 should have the lower bound of range 1 and the upper bound of range 2",
					new Range(-1,31), Range.combine(rangeObjectUnderTest1, rangeObjectUnderTest2));
			
		} catch (Exception e) {
			fail("An exception should not have been thrown: " + e.getMessage());
		}
	}
	
	@Test
	public void testCombineRange1HighRange2Low() {
		assertEquals("The combined range of Range 1 and 2 should have the lower bound of range 2 and the upper bound of range 1",
				new Range(-1,31), Range.combine(rangeObjectUnderTest2, rangeObjectUnderTest1));
		
	}
	
	@Test
	public void testCombineOverlappingRanges() {
		Range overlapRange = new Range(5,10);
		try {
			assertEquals("The combined range of Range 1 and 2 should have the lower bound of range 2 and the upper bound of range 1",
					new Range(5,31),Range.combine(overlapRange, rangeObjectUnderTest2));
		} catch (Exception e) {
			fail("An exception should not have been thrown: " + e.getMessage());
		}
		
	}
	
	@Test
	public void testCombineBothNullRanges() {
		assertEquals("The combined range of null and null should equal null",
				null, Range.combine(null, null));
	}
	
	

	@Test
	public void testCentralValueShouldBeZero() {
		
		assertEquals("The central value of -1 and 1 should be 0",
					0, rangeObjectUnderTest1.getCentralValue(), 0.000000001d);
		
	}
	
	

}
