package kr.co.recipetoyou.admin.adsend.ademail;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("emailDAO")		
public class AdEmailDAOImpl implements AdEmailDAO {

	@Autowired
	private SqlSession sqlSession;
	
	
}
