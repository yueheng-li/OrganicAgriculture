package com.organic.agriculture.web.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.organic.agriculture.entity.Product;
import com.organic.agriculture.mapper.ProductMapper;


/**
 * 商品查询，更新用的service
 * @author chunhui.li
 *
 */
@Component
public class ProductService {
    private static Logger logger = LoggerFactory.getLogger(ProductService.class);
    
    @Autowired
    private ProductMapper productMapper;
    

	public List<Product> selectAllProdouct() {
		return productMapper.selectAllProdouct();
	}

}
