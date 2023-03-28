package com.land.app.service;

import java.util.List;

import com.land.app.vo.NewsVO;

public interface NewsService {
	public List getNewsList();
	public void insertList(List<NewsVO> newsList);
}
