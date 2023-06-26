package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.model.GroceryProduct;

public interface GroceryProductDao {
		 int insert(GroceryProduct product);
		 int update(GroceryProduct product);
		 int delete(int id);
		 List<GroceryProduct> viewGroceryProducts();
		 GroceryProduct searchById(int id);
		
}
