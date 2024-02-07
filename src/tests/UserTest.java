package tests;

import model.User;
import utils.TestUtils;

public class UserTest {
	public static void testUserConstructor() {
		//User testUser = new User("mike", "my_passwd", "Mike", "Smith", "07771234567");
		
				//System.out.println(testUser);
				
				String test_username = "mike";
				String test_password = "my_passwd";
				String test_first_name = "Mike";
				String test_last_name = "Smith";
				String test_mobile_number = "07771234567";
				
				
				User testUser = new User(test_username, test_password, test_first_name, test_last_name, test_mobile_number);
				
				System.out.println("Starting the assertions of the test method: testUserConstructor");
				
				if (testUser.getUsername() == test_username) 
					System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getUsername-Passed" + TestUtils.TEXT_COLOR_RESET);
				else
					System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getUsername-FAILED" + TestUtils.TEXT_COLOR_RESET);
				
				if (testUser.getPassword() == test_password)
					System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getPassword-Passed" + TestUtils.TEXT_COLOR_RESET);
				else
					System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getPassword-FAILED" + TestUtils.TEXT_COLOR_RESET);
				
				if (testUser.getFirst_name() == test_first_name) 
					System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getFirst_name-Passed" + TestUtils.TEXT_COLOR_RESET);
				else
					System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getFirst_name-FAILED" + TestUtils.TEXT_COLOR_RESET);
				
				if (testUser.getLast_name() == test_last_name) 
					System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getLast_name-Passed" + TestUtils.TEXT_COLOR_RESET);
				else
					System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getLast_name-FAILED" + TestUtils.TEXT_COLOR_RESET);
				
				if (testUser.getMobile_number() == test_mobile_number) 
					System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getMobile_number-Passed" + TestUtils.TEXT_COLOR_RESET);
				else
					System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getMobile_numberPassed-FAILED" + TestUtils.TEXT_COLOR_RESET);
				
	}
	
	public static void main (String[] args) {
		
	}

}
