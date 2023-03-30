package com.land.app.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.land.app.vo.NewsVO;

@Repository
public class NewsDAOImpl implements NewsDAO {
	
	@Inject
	SqlSession sqlSession;

	@Override
	public List<NewsVO> getNewsList() {
		return sqlSession.selectList("news.getList");
	}

	@Override
	public void insertList(List<NewsVO> newsList) {
		sqlSession.insert("news.insertList", newsList);
	}

	@Override
	public List<NewsVO> getAdditionalNewsList(int page) {
		return sqlSession.selectList("news.getAdditionalList", page);
	}
	
}
