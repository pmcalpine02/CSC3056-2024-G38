package org.jfree.data;

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
	public void testColumnTotalValidData() 
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
	public void testColumnTotalColIndexHigh() 
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
	public void testDataNullColumnTotalDataNull() 
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
	public void testColumnTotalDataValidIndexNegative() 
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
	public void testColumnTotalValidDataLastColumn() 
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
	public void testColumnTotalSingleElement() 
	{ 
		try {
			DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
			values2D = testValues; 
			testValues.addValue(1.0, null, null);
			
			fail("An exception should have been thrown");
			
		} catch (IllegalArgumentException ex){
			assertEquals("Illegal Argument Exception", ex.getMessage());
		}
	}
	
	@Test
	public void testColumnTotalIncludesZero() 
	{
		try {
			DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
			values2D = testValues; 
			testValues.addValue(0, 1, null); 
			testValues.addValue(0, 2, null);
			testValues.addValue(0, 3, null);
			
			fail("An exception should have been thrown");
		} catch (IllegalArgumentException ex) {
			assertEquals("Illegal Argument Exception", ex.getMessage());
		}
	}
	
	@Test
	public void testColumnTotalPositiveNegativeData() 
	{ 
		try {
			DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
			values2D = testValues;
			testValues.addValue(-1, -2, -3); 
			testValues.addValue(4, 5, 6);
			
			
			assertEquals(3.0, DataUtilities.calculateColumnTotal(values2D, 1), 0.0000001d);
		}  catch (IllegalArgumentException ex) {
				fail("An exception has been thrown: " + ex.getMessage());
		}
	}
	
	//Row Total Calculation Test Cases
	@Test
	public void testRowTotalValidDataAndRow() 
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
	public void testRowTotalRowIndexHigh() 
	{ 
		try {
			DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
			values2D = testValues; 
			testValues.addValue(1, 2, 3); 
			testValues.addValue(4, 5, 6);
			
			fail("An exception has been thrown");
			
		}  catch (IllegalArgumentException ex) {
			assertEquals("Illegal Argument Exception", ex.getMessage());
		}
	}
	
	@Test
	public void testRowTotalDataNull() 
	{ 
		try {
			DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
			values2D = testValues;
			testValues = null;
			
			
			assertEquals(0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
		
		}  catch (IllegalArgumentException ex) {
				fail("An exception has been thrown: " + ex.getMessage());
		}
	}
	
	@Test
	public void testRowTotalDataValidIndexNegative() 
	{ 
		try {
			DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
			values2D = testValues;
			testValues.addValue(10, 20, 25); 
			testValues.addValue(30, 40, 45);
			
			fail("An exception has been thrown");
			
		}  catch (IllegalArgumentException ex) {
				
				assertEquals("Illegal Argument Exception", ex.getMessage());
		}
	}
	
	@Test
	public void testRowTotalValidDataLastRow() 
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
	public void testRowTotalSingleElement() 
	{ 
		try {
			DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
			values2D = testValues; 
			testValues.addValue(22.0, null, null);
			
			fail("An exception should have been thrown");
			
		} catch (IllegalArgumentException ex){
			assertEquals("Illegal Argument Exception", ex.getMessage());
		}; 
	}
	
	@Test
	public void testRowTotalIncludesZero() 
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
	public void testRowTotalPositiveNegativeData() 
	{ 
		try {
			DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
			values2D = testValues;
			testValues.addValue(-1, -2, -3); 
			testValues.addValue(4, 5, 6);
			
			
			assertEquals(15.0, DataUtilities.calculateRowTotal(values2D, 1), 0.0000001d);
		}  catch (IllegalArgumentException ex) {
				fail("An exception has been thrown: " + ex.getMessage());
		}
	}
	
	//Create Number Array Test Cases
	@Test
	public void testCreateArrayPositiveValues() {
		
		double[] input = {1.0, 2.0, 3, 5};
	    Number[] expected = {1.0, 2.0, 3.0, 5.0};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should correctly create an array with positive integers.", expected, result);
	}
	
	@Test
	public void testCreateArrayNegativeValues() {
		
		double[] input = {-1.0, -2.0, -3.5};
	    Number[] expected = {-1.0, -2.0, -3.5};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should correctly create an array with negative integers.", expected, result);
	}
	
	@Test
	public void testCreateArrayZerosOnly() {
		
		double[] input = {0.0, 0.0, 0.0};
	    Number[] expected = {0.0, 0.0, 0.0};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should correctly create an array with only zeros as integers.", expected, result);
	}
	
	@Test
	public void testMixCreateArrayPositiveNegative() {
		
		double[] input = {-1.0, 2.0, -3.5, 4.5};
	    Number[] expected = {-1.0, 2.0, -3.5, 4.5};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should correctly create an array with mix of positive & negative integers.", expected, result);
	}
	
	@Test
	public void testCreateArrayEmptyValues() {
		
		double[] input = {};
	    Number[] expected = {};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should create an array that is empty.", expected, result);
	}
	
	@Test
	public void testCreateArraySingleElement() {
		
		double[] input = {28.0};
	    Number[] expected = {28.0};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should correctly create an array with a single element of 28.0.", expected, result);
	}
	
	@Test
	public void testCreateArrayLargeValues() {
		
		double[] input = {Double.MAX_VALUE, -Double.MAX_VALUE};
	    Number[] expected = {1.7976931348623157E308, -1.7976931348623157E308};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should correctly create an array with max -ve & +ve numerical values.", expected, result);
	}
	
	@Test
	public void testCreateArrayMaxMinValues() {
		
		double[] input = {Double.MIN_VALUE, Double.MAX_VALUE};
	    Number[] expected = {4.9E-324, 1.7976931348623157E308};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should correctly create an array with max & min numerical values.", expected, result);
	}
	
	@Test
	public void testCreateArraySmallPositiveNegative() {
		
		double[] input = {Double.MIN_VALUE, -Double.MIN_VALUE};
	    Number[] expected = {4.9E-324, -4.9E-324};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should correctly create an array with very small -ve & +ve numerical values.", expected, result);
	}
	
	@Test
	public void testCreateArrayRepeatingValues() {
		
		double[] input = {2.2, 2.2, 2.2};
	    Number[] expected = {2.2, 2.2, 2.2};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should correctly create an array with repeating numerical values.", expected, result);
	}
	
	@Test
	public void testCreateArraySequentialValues() {
		
		double[] input = {1.0, 2.0, 3.0, 4.0, 5.0};
	    Number[] expected = {1.0, 2.0, 3.0, 4.0, 5.0};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should correctly create an array with sequential numerical values.", expected, result);
	}
	
	@Test(expected = IllegalArgumentException.class)
    public void testCreateNumberArray_NullData() {
        DataUtilities.createNumberArray(null);
    }
	
	@Test
	public void testCreateArrayNullValues() {
		
		try {
			Number[] expected = {null};

			Number[] result = DataUtilities.createNumberArray(null);

			assertArrayEquals("The method should not create an array containing null as the value.", expected, result);
			}  catch (Exception e) {
					fail("An exception has been thrown: " + e.getMessage());
			}
	}
	
	@Test
	public void testCreateArrayRandomValues() {
		
		double[] input = {3.14, -15.9, 2.65, -3.58, 9.79};
	    Number[] expected = {3.14, -15.9, 2.65, -3.58, 9.79};

	    Number[] result = DataUtilities.createNumberArray(input);

	    assertArrayEquals("The method should correctly create an array with random numerical values.", expected, result);
	}
	
	//Create 2D Number Array Test Cases
	@Test
	public void testCreate2DArrayPositiveValues() {
		 	
		double[][] input = {{1.5, 2.5}, {3.5, 4.5}};
	    Number[][] expected = {{1.5, 2.5}, {3.5, 4.5}};

	    Number[][] result = DataUtilities.createNumberArray2D(input);

	    assertArrayEquals("The method should correctly create a 2D array with positive integers.", expected, result);
	}

	@Test
	public void testCreate2DArrayNegativeValues() {
		
		double[][] input = {{-1.5, -2.5}, {-3.5, -4.5}};
	    Number[][] expected = {{-1.5, -2.5}, {-3.5, -4.5}};

	    Number[][] result = DataUtilities.createNumberArray2D(input);

	    assertArrayEquals("The method should correctly create a 2D array with negative integers.", expected, result);
	}
	
	@Test
	public void testCreate2DArrayZerosOnly() {
		
		double[][] input = {{0.0, 0.0}, {0.0, 0.0}} ;
	    Number[][] expected = {{0.0, 0.0}, {0.0, 0.0}} ;

	    Number[][] result = DataUtilities.createNumberArray2D(input);

	    assertArrayEquals("The method should correctly create a 2D array with zero integers only.", expected, result);
	}
	
	@Test
	public void testCreate2DArrayPositiveNegativeMix() {
		
		double[][] input = {{-1.0, 2.0}, {0,0, -3.5}};
	    Number[][] expected = {{-1.0, 2.0}, {0,0, -3.5}};

	    Number[][] result = DataUtilities.createNumberArray2D(input);

	    assertArrayEquals("The method should correctly create a 2D array with positive and negative integers.", expected, result);
	}
	
	@Test
	public void testCreate2DArrayNullValues() {
		
		try {
			Number[][] expected = {null};

			Number[][] result = DataUtilities.createNumberArray2D(null);

			assertArrayEquals("The method should not create a 2D array containing null as the value.", expected, result);
			}  catch (Exception e) {
					fail("An exception has been thrown: " + e.getMessage());
			}
	}
	
	@Test
	public void testCreate2DArrayEmptyValues() {
		
		double[][] input = {{}, {}};
	    Number[][] expected = {{}, {}};

	    Number[][] result = DataUtilities.createNumberArray2D(input);

	    assertArrayEquals("The method should correctly create a 2D array that is empty.", expected, result);
	}
	
	@Test
	public void testCreate2DArraySingleElement() {
		
		double[][] input = {{28.0}};
	    Number[][] expected = {{28}};

	    Number[][] result = DataUtilities.createNumberArray2D(input);

	    assertArrayEquals("The method should correctly create a 2D array that only contains one element.", expected, result);
	}
	
	@Test
	public void testCreate2DArrayMaxMinValues() {
		
		double[][] input = {{Double.MAX_VALUE}, {-Double.MAX_VALUE}};
	    Number[][] expected = {{1.7976931348623157E308}, {-1.7976931348623157E308}};

	    Number[][] result = DataUtilities.createNumberArray2D(input);

	    assertArrayEquals("The method should correctly create a 2D array that contains max and min numeric values.", expected, result);
	}
	
	@Test
	public void testCreate2DArraySmallPositiveNonZero() {
		
		double[][] input = {{Double.MIN_VALUE}};
	    Number[][] expected = {{4.9E-324}};

	    Number[][] result = DataUtilities.createNumberArray2D(input);

	    assertArrayEquals("The method should correctly create a 2D array that contains smallest positive non zero value.", expected, result);
	}
	
	//Calculate Cumulative Percentages Test Cases
	@Test
	public void testGetCumulativePercentagesPositiveValues() {
		
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
	public void testGetCumulativePercentagesIncludeZerosValues() {
		
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
	public void testGetCumulativePercentagesNegativePositiveValues() {
		
		try {
			DefaultKeyedValues inputData = new DefaultKeyedValues();
			keyedValues = inputData;
			
			inputData.addValue("Key1", -5);
	        inputData.addValue("Key2", 15);
	        inputData.addValue("Key3", 6);
	
	        
			KeyedValues CumulativePercentages = DataUtilities.getCumulativePercentages(keyedValues);
	        
	        fail("An exception should have been thrown");
		
		} catch (IllegalArgumentException ex){
			assertEquals("Illegal Argument Exception", ex.getMessage());
		}
	}
	
	@Test
	public void testGetCumulativePercentagesSingleValue() {
		
		DefaultKeyedValues inputData = new DefaultKeyedValues();
		keyedValues = inputData;
		
		inputData.addValue("Key1", 10);

        KeyedValues cumulativePercentages = DataUtilities.getCumulativePercentages(keyedValues);

        assertEquals("The cumulative percentage for Key1 is correct", 1.0, cumulativePercentages.getValue("Key1"));

	}
	
	@Test
	public void testGetCumulativePercentagesLargeValues() {
		
		DefaultKeyedValues inputData = new DefaultKeyedValues();
		keyedValues = inputData;
		
		inputData.addValue("Key1", 100000);
        inputData.addValue("Key2", 900000);

        KeyedValues cumulativePercentages = DataUtilities.getCumulativePercentages(keyedValues);

        assertEquals("The cumulative percentage for Key1 is correct", 0.1, cumulativePercentages.getValue("Key1"));
        assertEquals("The cumulative percentage for Key1 is correct", 1.0, cumulativePercentages.getValue("Key2"));
		
	}
	
	@Test
	public void testGetCumulativePercentagesPrecisionValues() {
		
		DefaultKeyedValues inputData = new DefaultKeyedValues();
		keyedValues = inputData;
		
		inputData.addValue("Key1", 1);
        inputData.addValue("Key2", 1);
        inputData.addValue("Key3", 1);

        KeyedValues cumulativePercentages = DataUtilities.getCumulativePercentages(keyedValues);

        assertEquals("The cumulative percentage for Key1 is correct", 0.3333, cumulativePercentages.getValue("Key1"));
        assertEquals("The cumulative percentage for Key2 is correct", 0.6667, cumulativePercentages.getValue("Key2"));
        assertEquals("The cumulative percentage for Key3 is correct", 1.0, cumulativePercentages.getValue("Key3"));
	}
	
	@Test(expected = IllegalArgumentException.class)
    public void testGetCumulativePercentages_NullData() {
        DataUtilities.getCumulativePercentages(null);
    }
    
    @Test
    public void testGetCumulativePercentages_FirstInstanceNotNull() {
        DefaultKeyedValues inputData = new DefaultKeyedValues();
        keyedValues = inputData;
        
        inputData.addValue("Key1", 10);
        inputData.addValue("Key2", null);
        
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
        
        assertNotNull("Result should not be null", result);
        assertEquals("Result should contain cumulative percentages", 2, result.getItemCount());
        assertEquals("Cumulative percentage of A", 0.5, result.getValue(0).doubleValue(), 0.00001);
        assertEquals("Cumulative percentage of B", 1.0, result.getValue(1).doubleValue(), 0.00001);
    }
    
    @Test
    public void testGetCumulativePercentages_SecondInstanceNotNull() {
        DefaultKeyedValues inputData = new DefaultKeyedValues();
        keyedValues = inputData;
        
        inputData.addValue("A", 10.0);
        inputData.addValue("B", 20.0);
        
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
        
        assertNotNull("Result should not be null", result);
        assertEquals("Result should contain cumulative percentages", 2, result.getItemCount());
        assertEquals("Cumulative percentage of A", 0.3333333333333333, result.getValue(0).doubleValue(), 0.00001);
        assertEquals("Cumulative percentage of B", 1.0, result.getValue(1).doubleValue(), 0.00001);
    }
}
