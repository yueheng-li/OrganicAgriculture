package com.organic.agriculture.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.organic.agriculture.entity.ProductBaseInfo;

public interface ProductBaseInfoMapper {

	List<ProductBaseInfo> selectAll();
	ProductBaseInfo selectByPrimaryKey(@Param("product_no")String product_no);
	List<ProductBaseInfo> selectProductPricesByPno(@Param("product_no")String product_no);
}