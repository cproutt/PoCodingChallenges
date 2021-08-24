import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class POWeek1 {

	/*Create a function that takes a number as an argument and returns true if the number is a valid credit card number, false otherwise.

	Credit card numbers must be between 14-19 digits in length, and pass the Luhn test, described below:

	Remove the last digit (this is the "check digit").
	Reverse the number.
	Double the value of each digit in odd-numbered positions. If the doubled value has more than 1 digit, add the digits together (e.g. 8 x 2 = 16 ➞ 1 + 6 = 7).
	Add all digits.
	Subtract the last digit of the sum (from step 4) from 10. The result should be equal to the check digit from step 1.
	Examples
	validateCard(1234567890123456) --> false

	// Step 1: check digit = 6, num = 123456789012345
	// Step 2: num reversed = 543210987654321
	// Step 3: digit array after selective doubling: [1, 4, 6, 2, 2, 0, 9, 8, 5, 6, 1, 4, 6, 2, 2]
	// Step 4: sum = 58
	// Step 5: 10 - 8 = 2 (not equal to 6) --> false

	validateCard(1234567890123452) --> true*/
	
	public static boolean isCardValid(String card) {
		ArrayList<Integer> cards = new ArrayList<Integer>();
		int len = cards.size();
		int sum = 0;
		
		char[] c_num = card.toCharArray();
		
		for(char j: c_num) {
			cards.add((int) j);
		}
		
		int check = cards.get(len);
		cards.remove(len);
		
		Collections.sort(cards, Collections.reverseOrder());
		
		for(Integer m: cards) {
			if(len - (cards.indexOf(m)) % 2 == 0 ) {
				if(m * 2 >= 10) {
					char[] dou = String.valueOf(m).toCharArray();
					for(char n: dou) {
						m += (int) n;
					}
				} else {
					m = m * 2;
				}
			}
		}
		
		for(Integer l: cards) {
			sum += l;
		}
		
		int lastDigit = sum % 10;
		
		return (10 - lastDigit == check);
	}
}
		
