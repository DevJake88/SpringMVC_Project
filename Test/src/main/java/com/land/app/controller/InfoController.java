package com.land.app.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.land.app.service.NewsService;

@Controller
public class InfoController {
	
	@Inject
	private NewsService newsService;
	
	@RequestMapping(value="/news", method=RequestMethod.GET)
	public String getNews(Model model) {
//		model.addAttribute("newsList", newsService.getNewsList());
//		return "news";
		model.addAttribute("newsList", newsService.getNewsList());
		return "news";
	}
}
