package SE401;

import java.util.Scanner;
import java.util.regex.*;

public class LeapYear {

	final public static String[] months = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December", };

	public static void isLeapYear(int year) {
		try {
			if (((year % 4) == 0)) {
				System.out.print(year + " is a leap year");
			} else {
				System.out.print(year + "2018 is not a leap year");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(year + " is not a valid month");
		}
	}

	public static void isValidMonth(String month) {
		if (month instanceof String) {
			if ((month.equalsIgnoreCase(months[0])) || (month.equalsIgnoreCase(months[1]))
					|| (month.equalsIgnoreCase(months[2]))) {
				System.out.print(", " + month + " is a valid month.\n");
			} else {
				System.out.print(", " + month + " is not a valid month.\n");
			}
		} else {
			System.out.println("Not a valid year");
		}
	}

	public static boolean lettersOnly(String input) {
		if (input == null) {
			return false;
		} else if (input.length() > 50) {
			return false;
		} else {
			return Pattern.matches("[a-zA-Z]+", input);
		}
	} 

	public static boolean numsOnly(String input) {
		if (input == null) {
			return false;
		} else if (input.length() > 50) {
			return false;
		} else {
			return Pattern.matches("[0-9]+", input);
		}
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("\nEnter a year");
			String sYear = s.next();
			if (sYear.equals("-1")) {
				break;
			}
			while (!numsOnly(sYear)) {
				System.out.println("Invalid year, use numbers only please");
				sYear = s.next();
			}
			System.out.println("Enter a month");
			String month = s.next();
			if (month.equals("-1")) {
				break;
			}
			while (!lettersOnly(month)) {
				System.out.println("Invalid month, use letters only please");
				month = s.next();
			}

			isLeapYear(Integer.parseInt(sYear));
			isValidMonth(month);
		}

	}

}
