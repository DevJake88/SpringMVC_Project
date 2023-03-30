package com.land.app.dao;

import java.util.List;

import com.land.app.vo.NewsVO;

public interface NewsDAO {
	public List<NewsVO> getNewsList();
	public void insertList(List<NewsVO> newsList);
	public List<NewsVO> getAdditionalNewsList(int page);
}
