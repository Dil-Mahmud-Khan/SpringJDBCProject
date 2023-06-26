package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.model.GroceryProduct;

public class RowMapperImpl implements RowMapper<GroceryProduct>{

	public GroceryProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
		GroceryProduct product=new GroceryProduct();
		product.setId(rs.getInt(1));
		product.setName(rs.getString(2));
		product.setPrice(rs.getDouble(3));
		product.setQuantity(rs.getInt(3));
		return product;
	}
	
}
