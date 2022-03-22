package kr.co.recipetoyou.admin.adsend.adsms;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("smsDAO")		
public class AdSmsDAOImpl implements AdSmsDAO {

	@Autowired
	private SqlSession sqlSession;
	
	
}
