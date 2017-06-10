package com.organic.agriculture.mapper;

import com.organic.agriculture.entity.Product;

public interface ProductMapper {

	int insertProduct(Product record);

	Product selectByKey(Product record);

	int updateProductByKey(Product record);
}
