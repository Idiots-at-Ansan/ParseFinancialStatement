package com.company.ttt.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class HomeDAOImpl implements HomeDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.company.mapper.testMapper";
	@Override
	public void test() throws Exception {
		// TODO Auto-generated method stub
		sqlSession.selectOne(Namespace + ".test");
	}

}
