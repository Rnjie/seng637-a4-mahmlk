package org.jfree.data.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class SampleTest {
	private double[] oldArray;
	private double[][] old2DArray;
	private java.lang.Number[] newArray;
	private java.lang.Number[][] new2DArray;
	
	// Variables for mocking
	private Mockery mockery;
	private KeyedValues kvalues;
	private Values2D value; // instance of Values2D
	

	@Before
	public void setUp() throws Exception {
		mockery = new Mockery();
		value = mockery.mock(Values2D.class); // all test cases will use this mocked value variable with changed values.
		kvalues = mockery.mock(KeyedValues.class);
		
		ArrayList<Integer> keyList = new ArrayList<Integer>(Arrays.asList(0,1,2));
		
		mockery.checking(new Expectations() {{
			allowing(value).getColumnCount(); will(returnValue(3)); // 3x4 whatever you want
			allowing(value).getRowCount(); will(returnValue(3));
			
			allowing(kvalues).getItemCount(); will(returnValue(3));
			
			allowing(kvalues).getValue(0); will(returnValue(-4));
			allowing(kvalues).getValue(1); will(returnValue(6));
			allowing(kvalues).getValue(2); will(returnValue(12));

			allowing(kvalues).getKey(0); will(returnValue(0));
			allowing(kvalues).getKey(1); will(returnValue(1));
			allowing(kvalues).getKey(2); will(returnValue(2));
			
			allowing(kvalues).getIndex(0); will(returnValue(0));
			allowing(kvalues).getIndex(1); will(returnValue(1));
			allowing(kvalues).getIndex(2); will(returnValue(2));

			allowing(kvalues).getKeys(); will(returnValue(keyList));
		}});
		
		
	}
	
	@Test
	public void test_getCumulativePercentage_negative() {
		double expected = -0.28;
		int a = 0;
		KeyedValues actual = DataUtilities.getCumulativePercentages(kvalues);
		assertEquals(expected, actual.getValue(a).doubleValue(), 0.01d);
	}
}
