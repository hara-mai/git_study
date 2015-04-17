package user.parts;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * RegIngfCheak�e�X�g�N���X
 * UT001-001~013
 */
public class RegInfCheckTest {

	@Test
	/*
	 * UT001-01
	 * ���p10������
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
	 * �S�p10������
	 */
	public void testCheckName2() {

		RegInfCheck read = new RegInfCheck();
		read.checkName("��������������������");
		String err = read.getErrMsg();
		assertEquals(err, "");

	}
	@Test
	/*
	 * UT001-03
	 * ���p11������
	 */
	public void testCheckName3() {

		RegInfCheck read = new RegInfCheck();
		read.checkName("01234567890");

		String err = read.getErrMsg();
		assertEquals(err, "���O��10���ȓ��œ��͂��Ă��������B<br />");
	}
	@Test
	/*
	 * UT001-04
	 * �S�p11������
	 */
	public void testCheckName4() {

		RegInfCheck read = new RegInfCheck();
		read.checkName("����������������������");
		String err = read.getErrMsg();
		assertEquals(err, "���O��10���ȓ��œ��͂��Ă��������B<br />");


	}

	@Test
	/*
	 * UT001-05
	 * ���p����16
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
	 * ���p����60
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
	 * ���p����15
	 */
	public void testCheckAge7() {
		RegInfCheck read = new RegInfCheck();

		read.checkAge("15");
		String err = read.getErrMsg();
		assertEquals(err, "�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />");

	}

	@Test
	/*
	 * UT001-08
	 * ���p����61
	 */
	public void testCheckAge8() {
		RegInfCheck read = new RegInfCheck();

		read.checkAge("61");
		String err = read.getErrMsg();
		assertEquals(err, "�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />");

	}
	@Test
	/*
	 * UT001-09
	 * �S�p����16
	 */
	public void testCheckAge9() {
		RegInfCheck read = new RegInfCheck();

		read.checkAge("�P�U");
		String err = read.getErrMsg();
		assertEquals(err, "�N��͐��l(���p)�œ��͂��Ă��������B<br />");

	}
	@Test
	/*
	 * UT001-010
	 * �S�p����������
	 */
	public void testCheckAge10() {
		RegInfCheck read = new RegInfCheck();

		read.checkAge("����������");
		String err = read.getErrMsg();
		assertEquals(err, "�N��͐��l(���p)�œ��͂��Ă��������B<br />�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />");

	}
	@Test
	/*
	 * UT001-011
	 * �S�p����������+16
	 */
	public void testCheckAge11() {
		RegInfCheck read = new RegInfCheck();

		read.checkAge("16����������");
		String err = read.getErrMsg();
		assertEquals(err, "�N��͐��l(���p)�œ��͂��Ă��������B<br />�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />");

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
		assertEquals(err, "�o�^�\��ID�i999�j�𒴂��Ă��܂��B�Ǘ��҂ɖ₢���킹�Ă��������B<br />");
	}


}
