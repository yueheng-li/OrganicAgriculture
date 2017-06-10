package com.organic.agriculture.mapper;

import java.util.List;

import com.organic.agriculture.entity.CrawlerProductJob;

public interface CrawlerProductJobMapper {

	List<CrawlerProductJob> selectAll();

	List<CrawlerProductJob> selectByJobKey(CrawlerProductJob record);

	int insertCrawlerProductJob(CrawlerProductJob record);

	int updateByKey(CrawlerProductJob record);
	int updateByKeyToEnable(CrawlerProductJob record);
	
}
