package com.organic.agriculture.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.organic.agriculture.entity.CrawlerProductJob;
import com.organic.agriculture.mapper.CrawlerProductJobMapper;

@Component
public class ProductSearchService {
    private static Logger logger = LoggerFactory.getLogger(ProductSearchService.class);
    @Autowired
    private CrawlerProductJobMapper crawlerProductJobMapper;
    
    public void importCsvFileToDB(List<CrawlerProductJob> records) {
        
    	for (CrawlerProductJob crawlerProductJob : records) {
    		List<CrawlerProductJob> list = crawlerProductJobMapper.selectByJobKey(crawlerProductJob);
    		if (list.size() > 0) {
            	crawlerProductJobMapper.updateByKeyToEnable(crawlerProductJob);
    		} else {
            	crawlerProductJobMapper.insertCrawlerProductJob(crawlerProductJob);
    		}
			
		}
    }

}
