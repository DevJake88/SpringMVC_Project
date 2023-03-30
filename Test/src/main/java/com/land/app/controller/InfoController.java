package com.land.app.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.land.app.service.NewsService;
import com.land.app.utils.Crawling;

@Controller
public class InfoController {
	
	@Inject
	private NewsService newsService;
	Crawling cw = new Crawling();
	
	@RequestMapping(value="/news", method=RequestMethod.GET)
	public String getNews(Model model) {
//		model.addAttribute("newsList", newsService.getNewsList());
//		return "news";
		model.addAttribute("newsList", newsService.getNewsList());
		return "news";
	}
	
	@RequestMapping(value="/newsList", method=RequestMethod.GET)
	public String getNewsList(Model model) {
		model.addAttribute("newsList", newsService.getNewsList());
		return "newsList";
	}
	
	@RequestMapping(value="/newsInit", method=RequestMethod.GET)
	public void initNews() {
		newsService.insertList(cw.getNewsList());
	}
	
	@RequestMapping(value="/newsPlus", method=RequestMethod.GET)
	public ModelAndView getAdditionalNewsList(@RequestParam(value="data") int page) {
		ModelAndView model = new ModelAndView("jsonView");
		model.addObject("list", newsService.getAdditionalNewsList(page));
		System.out.println("page : " + page);
		return model;
	}
}
