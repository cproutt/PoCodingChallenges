import static org.junit.Assert.*;

import org.junit.Test;

public class PoWeek1Test {

	@Test
	public void testIsCardValid() {
		String card = "1234567890123456";
		assertTrue(isCardValid(card));
	}

}
