package user.parts;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import user.bean.RegistrantInfo;

import com.javaranch.unittest.helper.sql.pool.JNDIUnitTestHelper;

public class RegInfDAOTest {
	@Before
	public void setUp() throws Exception {

		JNDIUnitTestHelper.init("WebContent/WEB-INF/classes/jndi_unit_test_helper.properties");

	}
	/*
	 * insert �e�X�g
	 */
	@Test
	public void testInsert() {

		RegInfDAO dao = new RegInfDAO();
		dao.insert("004", "�����H����", "28");

		/*�e�[�u���̕\��*/
		ArrayList<RegistrantInfo> list = dao.getReglist();
		for(RegistrantInfo info :list){
			System.out.println(info.getrId()+":"+info.getrName()+":"+info.getrAge());
		}
		dao.close();
	}
	/*
	 * update�e�X�g
	 */
	@Test
	public void testUpdate(){
		RegInfDAO dao = new RegInfDAO();
		dao.update("002", "Michael", "29");
		/*�e�[�u���̕\��*/
		ArrayList<RegistrantInfo> list = dao.getReglist();
		for(RegistrantInfo info :list){
			System.out.println(info.getrId()+":"+info.getrName()+":"+info.getrAge());
		}
		dao.close();
	}
	/*
	 * delete �e�X�g
	 */
	@Test
	public void testDelete(){
		RegInfDAO dao = new RegInfDAO();
		dao.delete("004");
		/*�e�[�u���̕\��*/
		ArrayList<RegistrantInfo> list = dao.getReglist();
		for(RegistrantInfo info :list){
			System.out.println(info.getrId()+":"+info.getrName()+":"+info.getrAge());
		}
	}

	/*
	 * DB�ɒl���Ȃ��Ƃ�
	 */
	@Test
	public void testgetNextId(){
		RegInfDAO dao = new RegInfDAO();
		String test = dao.getNextId();

		assertEquals(test, "001");
	}


}
