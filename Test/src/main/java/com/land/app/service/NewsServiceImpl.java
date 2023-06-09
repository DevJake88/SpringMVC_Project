package com.land.app.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.land.app.dao.NewsDAO;
import com.land.app.utils.Crawling;
import com.land.app.vo.NewsVO;

@Service
public class NewsServiceImpl implements NewsService {
//	Crawling cw = new Crawling();
	
	@Inject
	NewsDAO newsDao;
	
	public List getNewsList() { 
//		return cw.getNewsList();
		return newsDao.getNewsList();
	}

	@Override
	public void insertList(List<NewsVO> newsList) {
		newsDao.insertList(newsList);
	}

	@Override
	public List getAdditionalNewsList(int page) {
		return newsDao.getAdditionalNewsList(page);
	}
}
