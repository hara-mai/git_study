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
	 * insert テスト
	 */
	@Test
	public void testInsert() {

		RegInfDAO dao = new RegInfDAO();
		dao.insert("004", "佐藤路未央", "28");

		/*テーブルの表示*/
		ArrayList<RegistrantInfo> list = dao.getReglist();
		for(RegistrantInfo info :list){
			System.out.println(info.getrId()+":"+info.getrName()+":"+info.getrAge());
		}
		dao.close();
	}
	/*
	 * updateテスト
	 */
	@Test
	public void testUpdate(){
		RegInfDAO dao = new RegInfDAO();
		dao.update("002", "Michael", "29");
		/*テーブルの表示*/
		ArrayList<RegistrantInfo> list = dao.getReglist();
		for(RegistrantInfo info :list){
			System.out.println(info.getrId()+":"+info.getrName()+":"+info.getrAge());
		}
		dao.close();
	}
	/*
	 * delete テスト
	 */
	@Test
	public void testDelete(){
		RegInfDAO dao = new RegInfDAO();
		dao.delete("004");
		/*テーブルの表示*/
		ArrayList<RegistrantInfo> list = dao.getReglist();
		for(RegistrantInfo info :list){
			System.out.println(info.getrId()+":"+info.getrName()+":"+info.getrAge());
		}
	}

	/*
	 * DBに値がないとき
	 */
	@Test
	public void testgetNextId(){
		RegInfDAO dao = new RegInfDAO();
		String test = dao.getNextId();

		assertEquals(test, "001");
	}


}
