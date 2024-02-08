package tests;

import java.util.Date;
import utils.TestUtils;

import model.Account;

public class AccountTest {
	
	public static void testAccountConstructor() {
		
		String test_account_number = "5495-1234" ;
		String test_user_name = "mike";
		String test_account_type = "Standard";
		Date test_account_open_date = new Date(20/8/2019);
		
		Account testAccount = new Account(test_account_number, test_user_name, test_account_type, test_account_open_date);
		
		System.out.println("Starting the assertions of the test method: testAccountConstructor");
		
		if (testAccount.getAccount_number() == test_account_number) 
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getAccount_number-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getAccount_number-FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		if (testAccount.getUser_name() == test_user_name)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getUser_name-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getUser_name-FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		if (testAccount.getAccount_type() == test_account_type) 
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC3-getAccount_type-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC3-getAccount_type-FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		if (testAccount.getAccount_open_date() == test_account_open_date) 
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC4-getAccount_open_date-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC4-getAccount_open_date-FAILED" + TestUtils.TEXT_COLOR_RESET);

		assert testAccount.getAccount_number() == test_account_number;
		assert testAccount.getUser_name() == test_user_name;
		assert testAccount.getAccount_type() == test_account_type;
		assert testAccount.getAccount_open_date() == test_account_open_date;
		
		System.out.println("All assertions have passed");
		
	}
	
	public static void testAccountSetters() {

		String test_account_number = "";
		String test_user_name = "";
		String test_account_type = "";
		Date test_account_open_date = new Date();
		
		Account testAccount = new Account(test_account_number, test_user_name, test_account_type, test_account_open_date);
		
		System.out.println("Starting the assertions of the test method: testAccountSetters");
		
        // Set values using setters
        testAccount.setAccount_number("5495-1234");
        testAccount.setUser_name("mike");
        testAccount.setAccount_type("Standard");
        testAccount.setAccount_open_date(new Date(20/8/2019));

        // Perform assertions
        assert testAccount.getAccount_number().equals("5495-1234");
        
        if (testAccount.getAccount_number().equals("5495-1234")) {
        	System.out.println("TC1-setAccount_number-PASSED");
        } else {
            System.out.println("TC1-setAccount_number-FAILED");
        }
        
        assert testAccount.getUser_name().equals("mike") : "TC2-getUser_name-PASSED";
        
        if (testAccount.getUser_name().equals("mike")) {
        	System.out.println("TC2-setAccount_number-PASSED");
        } else {
            System.out.println("TC2-setAccount_number-FAILED");
        }
        
        assert testAccount.getAccount_type().equals("Standard") : "TC3-getAccount_type-PASSED";
        
        if (testAccount.getAccount_type().equals("Standard")) {
        	System.out.println("TC3-setAccount_number-PASSED");
        } else {
            System.out.println("TC3-setAccount_number-FAILED");
        }
 
        assert testAccount.getAccount_open_date().equals(new Date(20/8/2019)) : "TC4-getAccount_open_date-PASSED";
        
        if (testAccount.getAccount_open_date().equals(new Date(20/8/2019))) {
        	System.out.println("TC4-setAccount_number-PASSED");
        } else {
            System.out.println("TC4-setAccount_number-FAILED");
        }
        
        System.out.println("All assertions have passed");
	}
	
	public static void main (String[] args) {
		testAccountConstructor();
		testAccountSetters();
	}
}
