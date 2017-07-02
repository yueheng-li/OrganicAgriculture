package com.organic.agriculture.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.organic.agriculture.beans.Product;
import com.organic.agriculture.common.message.SpringMessageResourceMessages;
import com.organic.agriculture.service.IndexService;

@Controller
@RequestMapping("/")
public class IndexController {
	private static Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private SpringMessageResourceMessages messageSource;
//
//	@Autowired
//	private IndexService service;

	/**
	 * @param form
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/")
	public String home(Model model) throws Exception {
//		List<Product> list = service.getProducts();
		return "index";
	}

}
