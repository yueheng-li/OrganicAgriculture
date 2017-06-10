package com.organic.agriculture.mapper;

import java.util.List;

import com.organic.agriculture.entity.CrawlerJob;

public interface CrawlerJobMapper {

	List<CrawlerJob> selectAll();

	int insertCrawlerJob(CrawlerJob record);

	List<CrawlerJob> selectByJobType(CrawlerJob record);

	int updateByJobId(CrawlerJob record);
}
