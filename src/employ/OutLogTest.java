package employ;

import static org.junit.Assert.*;

import org.junit.Test;

public class OutLogTest {

	@Test
	public void testOutLogDmpString() {

		OutLog.outLogDmp("sample:ƒTƒ“ƒvƒ‹");

	}

	@Test
	public void testOutLogDmpInteger() {
		OutLog.outLogDmp("12345");
	}

}
