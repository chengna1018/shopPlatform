package com.penghai.shopplatform.dao;


import java.util.List;

import com.penghai.shopplatform.bo.Product;

public interface ProductMapper {
	public List<Product> getAllProduct(String productname);
	
	public List<Product> getProductByPage(String productname, String page);
}
