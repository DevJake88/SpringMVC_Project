package com.land.app.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.land.app.vo.NewsVO;

public class Crawling {
	
	String naverNewsURL = "https://news.naver.com/main/list.naver?mode=LS2D&mid=shm&sid2=260&sid1=101";
	
	public ArrayList<NewsVO> getNewsList() {
		ArrayList<NewsVO> newsList = new ArrayList<NewsVO>();
//		newsList.addAll(getMKNewsList());
		newsList.addAll(getNaverNewsList());
		return newsList;
	}
	
	public ArrayList<NewsVO> getNaverNewsList() {
		ArrayList<NewsVO> list = new ArrayList<NewsVO>();
		HashMap<String, String> hm = new HashMap<String, String>();
		
		String newsDate = "20230327";
		int newsPage = 1;
		try {
			for(int i=newsPage; i<10; i++) {
				Document doc = Jsoup.connect(naverNewsURL + "&date=" + newsDate + "&page=" + i).get();
				Elements ulElement1 = doc.select("ul.type06_headline").select("li");
				Elements ulElement2 = doc.select("ul.type06").select("li");
				
				// ulElement1 + ulElement2
				for(Element element : ulElement2) {
					ulElement1.add(element);
				}
				
				for(Element element : ulElement1) {
					String title = element.select("dt a").text();
					String content = element.select("dd span.lede").text();
					String href = element.select("dt a").attr("href");
					String img = element.select("img").attr("src");
					String writingSource = element.select("dd span.writing").text();
					String date = "2023.03.23";
					NewsVO nv = new NewsVO(1,title, content, date, href, img, writingSource);
					
					// 똑같은 제목의 기사가 있는지 중복 검사
					if(!hm.containsKey(title)) {
						hm.put(title, title);
						list.add(nv);
					}
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/*
	public ArrayList<NewsVO> getMKNewsList() {
		ArrayList<NewsVO> list = new ArrayList<NewsVO>();
		try {
			Document doc = Jsoup.connect("https://www.mk.co.kr/news/realestate/").get();
			Elements ulElement = doc.select("#list_area").select("li");
			for(int i=0; i<12; i++) {
				Element liElement = ulElement.get(i);
				// 중간에 광고가 있는 리스트 체크
				if (liElement.select("li.ad_wrap").isEmpty()) {
					String title = liElement.select("h3.news_ttl").text();
					String content = liElement.select("p.news_desc").text();
					String date = liElement.select("p.time_info").text();
					String href = liElement.select("a").attr("href");
					String img = liElement.select("img").attr("data-src");
					String writingSource = "매일경제";
					
					NewsVO nv = new NewsVO(title, content, date, href, img, writingSource);
					list.add(nv);
					System.out.println("img: " + liElement.select("img"));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	*/
	
}
