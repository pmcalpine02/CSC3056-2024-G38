package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest {
	

	private Values2D values2D;
	private KeyedValues keyedValues;
	
	
	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
		values2D = null;
	}
	
	//Column Total Calculation Test Cases
	@Test
	public void testValidDataAndColumnTotal() 
	{ 
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
		values2D = testValues; 
		testValues.addValue(1, 2, 3); 
		testValues.addValue(4, 5, 6);
		testValues.addValue(7, 8, 9);
		
		assertEquals("Wrong sum returned. It should be 15.0", 
					15.0, DataUtilities.calculateColumnTotal(values2D, 1), 0.0000001d); 
	}
	
	@Test
	public void testColIndexHighColumnTotal() 
	{ 
		try {
			DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
			values2D = testValues; 
			testValues.addValue(1, 2, 3); 
			testValues.addValue(4, 5, 6);
			
			assertEquals(15.0, DataUtilities.calculateColumnTotal(values2D, 3), 0.0000001d);
		}  catch (Exception e) {
			fail("An exception has been thrown: " + e.getMessage());
		}
	}
	
	@Test
	public void testDataNullColumnTotal() 
	{ 
		try {
			DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
			values2D = testValues;
			testValues = null;
			
			
			assertEquals(0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
		
		}  catch (Exception e) {
				fail("An exception has been thrown: " + e.getMessage());
		}
	}
	
	@Test
	public void testDataValidIndexNegativeColumnTotal() 
	{ 
		try {
			DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
			values2D = testValues;
			testValues.addValue(10, 20, 25); 
			testValues.addValue(30, 40, 45);
			
			
			assertEquals(15.0, DataUtilities.calculateColumnTotal(values2D, -1), 0.0000001d);
		}  catch (Exception e) {
				fail("An exception has been thrown: " + e.getMessage());
		}
	}
	
	@Test
	public void testValidDataLastColumnTotal() 
	{ 
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
		values2D = testValues; 
		testValues.addValue(1, 2, 3); 
		testValues.addValue(4, 5, 6);
		testValues.addValue(7, 8, 9);
		
		assertEquals("Wrong sum returned. It should be 18.0", 
					18.0, DataUtilities.calculateColumnTotal(values2D, 2), 0.0000001d); 
	}
	
	@Test
	public void testSingleElementColumnTotal() 
	{ 
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
		values2D = testValues; 
		testValues.addValue(1.0, null, null); 
		
		assertEquals("Wrong sum returned. It should be 1.0", 
					1.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d); 
	}
	
	@Test
	public void testIncludesZeroColumnTotal() 
	{ 
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
		values2D = testValues; 
		testValues.addValue(0, 1, null); 
		testValues.addValue(0, 2, null);
		testValues.addValue(0, 3, null);
		
		assertEquals("Wrong sum returned. It should be 6.0", 
					6.0, DataUtilities.calculateColumnTotal(values2D, 1), 0.0000001d); 
	}
	
	@Test
	public void testPositiveNegativeDataColumnTotal() 
	{ 
		try {
			DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
			values2D = testValues;
			testValues.addValue(-1, -2, -3); 
			testValues.addValue(4, 5, 6);
			
			
			assertEquals(3.0, DataUtilities.calculateColumnTotal(values2D, 1), 0.0000001d);
		}  catch (Exception e) {
				fail("An exception has been thrown: " + e.getMessage());
		}
	}
	
	//Row Total Calculation Test Cases
	@Test
	public void testValidDataAndRowTotal() 
	{ 
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
		values2D = testValues; 
		testValues.addValue(1, 2, 3); 
		testValues.addValue(4, 5, 6);
		testValues.addValue(7, 8, 9);
		
		assertEquals("Wrong sum returned. It should be 15.0", 
					15.0, DataUtilities.calculateRowTotal(values2D, 1), 0.0000001d); 
	}
	
	@Test
	public void testRowIndexHighRowTotal() 
	{ 
		try {
			DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
			values2D = testValues; 
			testValues.addValue(1, 2, 3); 
			testValues.addValue(4, 5, 6);
			
			assertEquals(15.0, DataUtilities.calculateRowTotal(values2D, 3), 0.0000001d);
		}  catch (Exception e) {
			fail("An exception has been thrown: " + e.getMessage());
		}
	}
	
	@Test
	public void testDataNullRowTotal() 
	{ 
		try {
			DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
			values2D = testValues;
			testValues = null;
			
			
			assertEquals(0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
		
		}  catch (Exception e) {
				fail("An exception has been thrown: " + e.getMessage());
		}
	}
	
	@Test
	public void testDataValidIndexNegativeRowTotal() 
	{ 
		try {
			DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
			values2D = testValues;
			testValues.addValue(10, 20, 25); 
			testValues.addValue(30, 40, 45);
			
			
			assertEquals(15.0, DataUtilities.calculateRowTotal(values2D, -1), 0.0000001d);
		}  catch (Exception e) {
				fail("An exception has been thrown: " + e.getMessage());
		}
	}
	
	@Test
	public void testValidDataLastRowTotal() 
	{ 
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
		values2D = testValues; 
		testValues.addValue(1, 2, 3); 
		testValues.addValue(4, 5, 6);
		testValues.addValue(7, 8, 9);
		
		assertEquals("Wrong sum returned. It should be 24.0", 
					24.0, DataUtilities.calculateRowTotal(values2D, 2), 0.0000001d); 
	}
	
	@Test
	public void testSingleElementRowTotal() 
	{ 
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
		values2D = testValues; 
		testValues.addValue(22.0, null, null); 
		
		assertEquals("Wrong sum returned. It should be 22.0", 
					22.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d); 
	}
	
	@Test
	public void testIncludesZeroRowTotal() 
	{ 
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
		values2D = testValues; 
		testValues.addValue(0, 1, 2); 
		testValues.addValue(0, 0, 0);
		testValues.addValue(3, 4, 5);
		
		assertEquals("Wrong sum returned. It should be 0.0", 
					0.0, DataUtilities.calculateRowTotal(values2D, 1), 0.0000001d); 
	}
	
	@Test
	public void testPositiveNegativeDataRowTotal() 
	{ 
		try {
			DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
			values2D = testValues;
			testValues.addValue(-1, -2, -3); 
			testValues.addValue(4, 5, 6);
			
			
			assertEquals(15.0, DataUtilities.calculateRowTotal(values2D, 1), 0.0000001d);
		}  catch (Exception e) {
				fail("An exception has been thrown: " + e.getMessage());
		}
	}
	
	//Create Number Array Test Cases
	@Test
	public void testPositiveValuesCreateArray() {
		
		double[] input = {1.0, 2.0, 3, 5};
	    Number[] expected = {1.0, 2.0, 3, 5};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should correctly create an array with positive integers.", expected, result);
	}
	
	@Test
	public void testNegativeValuesCreateArray() {
		
		double[] input = {-1.0, -2.0, -3.5};
	    Number[] expected = {-1.0, -2.0, -3.5};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should correctly create an array with negative integers.", expected, result);
	}
	
	@Test
	public void testZerosOnlyCreateArray() {
		
		double[] input = {0.0, 0.0, 0.0};
	    Number[] expected = {0.0, 0.0, 0.0};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should correctly create an array with only zeros as integers.", expected, result);
	}
	
	@Test
	public void testPositiveNegativeMixCreateArray() {
		
		double[] input = {-1.0, 2.0, -3.5, 4.5};
	    Number[] expected = {-1.0, 2.0, -3.5, 4.5};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should correctly create an array with mix of positive & negative integers.", expected, result);
	}
	
	@Test
	public void testNullValuesCreateArray() {
		
		try {
			double[] input = {(Double) null};
			Number[] expected = {null};

			Number[] result = DataUtilities.createNumberArray(input);

			assertArrayEquals("The method should not create a array containing null as the value.", expected, result);
			}  catch (Exception e) {
					fail("An exception has been thrown: " + e.getMessage());
			}
	}
	
	@Test
	public void testEmptyValuesCreateArray() {
		
		double[] input = {};
	    Number[] expected = {};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should create an array that is empty.", expected, result);
	}
	
	@Test
	public void testSingleElementCreateArray() {
		
		double[] input = {28.0};
	    Number[] expected = {28.0};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should correctly create an array with a single element of 28.0.", expected, result);
	}
	
	@Test
	public void testLargeValuesCreateArray() {
		
		double[] input = {Double.MAX_VALUE, -Double.MAX_VALUE};
	    Number[] expected = {1.7976931348623157E308, -1.7976931348623157E308};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should correctly create an array with max -ve & +ve numerical values.", expected, result);
	}
	
	@Test
	public void testMaxMinValuesCreateArray() {
		
		double[] input = {Double.MIN_VALUE, Double.MAX_VALUE};
	    Number[] expected = {4.9E-324, 1.7976931348623157E308};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should correctly create an array with max & min numerical values.", expected, result);
	}
	
	@Test
	public void testSmallPositiveNegativeCreateArray() {
		
		double[] input = {Double.MIN_VALUE, -Double.MIN_VALUE};
	    Number[] expected = {4.9E-324, -4.9E-324};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should correctly create an array with very small -ve & +ve numerical values.", expected, result);
	}
	
	@Test
	public void testRepeatingValuesCreateArray() {
		
		double[] input = {2.2, 2.2, 2.2};
	    Number[] expected = {2.2, 2.2, 2.2};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should correctly create an array with repeating numerical values.", expected, result);
	}
	
	@Test
	public void testSequentialValuesCreateArray() {
		
		double[] input = {1.0, 2.0, 3.0, 4.0, 5.0};
	    Number[] expected = {1.0, 2.0, 3.0, 4.0, 5.0};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should correctly create an array with sequential numerical values.", expected, result);
	}
	
	@Test
	public void testRandomValuesCreateArray() {
		
		double[] input = {3.14, -15.9, 2.65, -3.58, 9.79};
	    Number[] expected = {3.14, -15.9, 2.65, -3.58, 9.79};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should correctly create an array with random numerical values.", expected, result);
	}
	
	//Create 2D Number Array Test Cases
	@Test
	public void testPositiveValuesCreate2DArray() {
		 	
		double[][] input = {{1.5, 2.5}, {3.5, 4.5}};
	    Number[][] expected = {{1.5, 2.5}, {3.5, 4.5}};

	    Number[][] result = DataUtilities.createNumberArray2D(input);

	    assertArrayEquals("The method should correctly create a 2D array with positive integers.", expected, result);
	}

	@Test
	public void testNegativeValuesCreate2DArray() {
		
		double[][] input = {{-1.5, -2.5}, {-3.5, -4.5}};
	    Number[][] expected = {{-1.5, -2.5}, {-3.5, -4.5}};

	    Number[][] result = DataUtilities.createNumberArray2D(input);

	    assertArrayEquals("The method should correctly create a 2D array with negative integers.", expected, result);
	}
	
	@Test
	public void testZerosOnlyCreate2DArray() {
		
		double[][] input = {{0.0, 0.0}, {0.0, 0.0}} ;
	    Number[][] expected = {{0.0, 0.0}, {0.0, 0.0}} ;

	    Number[][] result = DataUtilities.createNumberArray2D(input);

	    assertArrayEquals("The method should correctly create a 2D array with zero integers only.", expected, result);
	}
	
	@Test
	public void testPositiveNegativeMixCreate2DArray() {
		
		double[][] input = {{-1.0, 2.0}, {0,0, -3.5}};
	    Number[][] expected = {{-1.0, 2.0}, {0,0, -3.5}};

	    Number[][] result = DataUtilities.createNumberArray2D(input);

	    assertArrayEquals("The method should correctly create a 2D array with positive and negative integers.", expected, result);
	}
	
	@Test
	public void testNullValuesCreate2DArray() {
		
		try {
			double[][] input = {null};
			Number[][] expected = {null};

			Number[][] result = DataUtilities.createNumberArray2D(input);

			assertArrayEquals("The method should not create a 2D array containing null as the value.", expected, result);
			}  catch (Exception e) {
					fail("An exception has been thrown: " + e.getMessage());
			}
	}
	
	@Test
	public void testEmptyValuesCreate2DArray() {
		
		double[][] input = {{}, {}};
	    Number[][] expected = {{}, {}};

	    Number[][] result = DataUtilities.createNumberArray2D(input);

	    assertArrayEquals("The method should correctly create a 2D array that is empty.", expected, result);
	}
	
	@Test
	public void testSingleElementCreate2DArray() {
		
		double[][] input = {{28.0}};
	    Number[][] expected = {{28}};

	    Number[][] result = DataUtilities.createNumberArray2D(input);

	    assertArrayEquals("The method should correctly create a 2D array that only contains one element.", expected, result);
	}
	
	@Test
	public void testMaxMinValuesCreate2DArray() {
		
		double[][] input = {{Double.MAX_VALUE}, {-Double.MAX_VALUE}};
	    Number[][] expected = {{1.7976931348623157E308}, {-1.7976931348623157E308}};

	    Number[][] result = DataUtilities.createNumberArray2D(input);

	    assertArrayEquals("The method should correctly create a 2D array that contains max and min numeric values.", expected, result);
	}
	
	@Test
	public void testSmallPositiveNonZeroCreate2DArray() {
		
		double[][] input = {{Double.MIN_VALUE}};
	    Number[][] expected = {{4.9E-324}};

	    Number[][] result = DataUtilities.createNumberArray2D(input);

	    assertArrayEquals("The method should correctly create a 2D array that contains smallest positive non zero value.", expected, result);
	}
	
	//Calculate Cumulative Percentages Test Cases
	@Test
	public void testPositiveValuesGetCumulativePercentages() {
		
		DefaultKeyedValues inputData = new DefaultKeyedValues();
		keyedValues = inputData;
		
		inputData.addValue("Key1", 5);
        inputData.addValue("Key2", 9);
        inputData.addValue("Key3", 2);

        KeyedValues cumulativePercentages = DataUtilities.getCumulativePercentages(keyedValues);

        assertEquals("The cumulative percentage for Key1 is correct", 0.3125, cumulativePercentages.getValue("Key1"));
        assertEquals("The cumulative percentage for Key2 is correct", 0.875, cumulativePercentages.getValue("Key2"));
        assertEquals("The cumulative percentage for Key1 is correct", 1.0, cumulativePercentages.getValue("Key3"));
	}
	
	@Test
	public void testIncludeZerosValuesGetCumulativePercentages() {
		
		DefaultKeyedValues inputData = new DefaultKeyedValues();
		keyedValues = inputData;
		
		inputData.addValue("Key1", 0);
        inputData.addValue("Key2", 10);
        inputData.addValue("Key3", 5);

        KeyedValues cumulativePercentages = DataUtilities.getCumulativePercentages(keyedValues);

        assertEquals("The cumulative percentage for Key1 is correct", 0.0, cumulativePercentages.getValue("Key1"));
        assertEquals("The cumulative percentage for Key2 is correct", 0.6667, cumulativePercentages.getValue("Key2"));
        assertEquals("The cumulative percentage for Key3 is correct", 1.0, cumulativePercentages.getValue("Key3"));
	}
	
	@Test
	public void testNegativePositiveValuesGetCumulativePercentages() {
		DefaultKeyedValues inputData = new DefaultKeyedValues();
		keyedValues = inputData;
		
		inputData.addValue("Key1", -5);
        inputData.addValue("Key2", 15);
        inputData.addValue("Key3", 6);

        KeyedValues cumulativePercentages = DataUtilities.getCumulativePercentages(keyedValues);

        assertEquals("The cumulative percentage for Key1 is incorrect", 0.3125, cumulativePercentages.getValue("Key1"));
        assertEquals("The cumulative percentage for Key2 is correct", 0.875, cumulativePercentages.getValue("Key2"));
        assertEquals("The cumulative percentage for Key3 is correct", 1.0, cumulativePercentages.getValue("Key3"));
        
        //should throw exception!!!
	}
	
	@Test
	public void testSingleValueGetCumulativePercentages() {
		
		DefaultKeyedValues inputData = new DefaultKeyedValues();
		keyedValues = inputData;
		
		inputData.addValue("Key1", 10);

        KeyedValues cumulativePercentages = DataUtilities.getCumulativePercentages(keyedValues);

        assertEquals("The cumulative percentage for Key1 is correct", 1.0, cumulativePercentages.getValue("Key1"));

	}
	
	@Test
	public void testLargeValuesGetCumulativePercentages() {
		
		DefaultKeyedValues inputData = new DefaultKeyedValues();
		keyedValues = inputData;
		
		inputData.addValue("Key1", 100000);
        inputData.addValue("Key2", 900000);

        KeyedValues cumulativePercentages = DataUtilities.getCumulativePercentages(keyedValues);

        assertEquals("The cumulative percentage for Key1 is correct", 0.1, cumulativePercentages.getValue("Key1"));
        assertEquals("The cumulative percentage for Key1 is correct", 1.0, cumulativePercentages.getValue("Key2"));
		
	}
	
	@Test
	public void testEmptyValuesGetCumulativePercentages() {
		
		DefaultKeyedValues inputData = new DefaultKeyedValues();
		keyedValues = inputData;

        KeyedValues cumulativePercentages = DataUtilities.getCumulativePercentages(keyedValues);

        assertEquals("The cumulative percentage for Key1 is incorrect", 0.3125, cumulativePercentages.getValue("Key1"));
	}
	
	@Test
	public void testPrecisionValuesGetCumulativePercentages() {
		
		DefaultKeyedValues inputData = new DefaultKeyedValues();
		keyedValues = inputData;
		
		inputData.addValue("Key1", 1);
        inputData.addValue("Key2", 1);
        inputData.addValue("Key3", 1);

        KeyedValues cumulativePercentages = DataUtilities.getCumulativePercentages(keyedValues);

        assertEquals("The cumulative percentage for Key1 is correct", 0.3333, cumulativePercentages.getValue("Key1"));
        assertEquals("The cumulative percentage for Key1 is correct", 0.6667, cumulativePercentages.getValue("Key2"));
        assertEquals("The cumulative percentage for Key1 is correct", 1.0, cumulativePercentages.getValue("Key3"));
	}
	

}
