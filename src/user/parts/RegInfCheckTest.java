package user.parts;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * RegIngfCheakテストクラス
 * UT001-001~013
 */
public class RegInfCheckTest {

	@Test
	/*
	 * UT001-01
	 * 半角10桁入力
	 */
	public void testCheckName() {

		RegInfCheck read = new RegInfCheck();
		read.checkName("0123456789");
		String err = read.getErrMsg();
		assertEquals(err, "");

	}
	@Test
	/*
	 * UT001-02
	 * 全角10桁入力
	 */
	public void testCheckName2() {

		RegInfCheck read = new RegInfCheck();
		read.checkName("あいうえおかきくけこ");
		String err = read.getErrMsg();
		assertEquals(err, "");

	}
	@Test
	/*
	 * UT001-03
	 * 半角11桁入力
	 */
	public void testCheckName3() {

		RegInfCheck read = new RegInfCheck();
		read.checkName("01234567890");

		String err = read.getErrMsg();
		assertEquals(err, "名前は10桁以内で入力してください。<br />");
	}
	@Test
	/*
	 * UT001-04
	 * 全角11桁入力
	 */
	public void testCheckName4() {

		RegInfCheck read = new RegInfCheck();
		read.checkName("あいうえおかきくけこさ");
		String err = read.getErrMsg();
		assertEquals(err, "名前は10桁以内で入力してください。<br />");


	}

	@Test
	/*
	 * UT001-05
	 * 半角数字16
	 */
	public void testCheckAge() {
		RegInfCheck read = new RegInfCheck();

		read.checkAge("16");
		String err = read.getErrMsg();
		assertEquals(err, "");

	}
	@Test
	/*
	 * UT001-06
	 * 半角数字60
	 */
	public void testCheckAge6() {
		RegInfCheck read = new RegInfCheck();

		read.checkAge("60");
		String err = read.getErrMsg();
		assertEquals(err, "");

	}

	@Test
	/*
	 * UT001-07
	 * 半角数字15
	 */
	public void testCheckAge7() {
		RegInfCheck read = new RegInfCheck();

		read.checkAge("15");
		String err = read.getErrMsg();
		assertEquals(err, "年齢は(16-60)の範囲で入力してください。<br />");

	}

	@Test
	/*
	 * UT001-08
	 * 半角数字61
	 */
	public void testCheckAge8() {
		RegInfCheck read = new RegInfCheck();

		read.checkAge("61");
		String err = read.getErrMsg();
		assertEquals(err, "年齢は(16-60)の範囲で入力してください。<br />");

	}
	@Test
	/*
	 * UT001-09
	 * 全角数字16
	 */
	public void testCheckAge9() {
		RegInfCheck read = new RegInfCheck();

		read.checkAge("１６");
		String err = read.getErrMsg();
		assertEquals(err, "年齢は数値(半角)で入力してください。<br />");

	}
	@Test
	/*
	 * UT001-010
	 * 全角あいうえお
	 */
	public void testCheckAge10() {
		RegInfCheck read = new RegInfCheck();

		read.checkAge("あいうえお");
		String err = read.getErrMsg();
		assertEquals(err, "年齢は数値(半角)で入力してください。<br />年齢は(16-60)の範囲で入力してください。<br />");

	}
	@Test
	/*
	 * UT001-011
	 * 全角あいうえお+16
	 */
	public void testCheckAge11() {
		RegInfCheck read = new RegInfCheck();

		read.checkAge("16あいうえお");
		String err = read.getErrMsg();
		assertEquals(err, "年齢は数値(半角)で入力してください。<br />年齢は(16-60)の範囲で入力してください。<br />");

	}



	@Test
	/*
	 * UT001-012
	 * 999
	 */
	public void testCheckId() {
		RegInfCheck read = new RegInfCheck();
		read.checkId("999");
		String err = read.getErrMsg();
		assertEquals(err, "");
	}
	@Test
	/*
	 * UT001-013
	 * 999
	 */
	public void testCheckId13() {
		RegInfCheck read = new RegInfCheck();
		read.checkId("1000");
		String err = read.getErrMsg();
		assertEquals(err, "登録可能なID（999）を超えています。管理者に問い合わせてください。<br />");
	}


}
