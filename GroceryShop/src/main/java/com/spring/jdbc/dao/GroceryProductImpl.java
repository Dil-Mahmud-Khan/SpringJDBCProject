package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.spring.jdbc.model.GroceryProduct;

public class GroceryProductImpl implements GroceryProductDao {

	private JdbcTemplate jdbcTemplate;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public GroceryProductImpl() {
	}

	public GroceryProductImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	

	public int insert(GroceryProduct product) {
		String query="insert into product (id,name,price, quantity) values(?,?,?,?)";
		int r=this.jdbcTemplate.update(query,product.getId(),product.getName(),product.getPrice(),product.getQuantity());
		return r;
	}

	public int update(GroceryProduct product) {
		String query="update product set id=?, name=?,price=? quantity=?";
		int r=this.jdbcTemplate.update(query,product.getId(),product.getName(),product.getPrice(),product.getQuantity());
		return r;
		
	}

	public int delete(int id) {
		String query="delete from product where id=?";
		int r=this.jdbcTemplate.update(query,id);
		return r;
		}

	public List<GroceryProduct> viewGroceryProducts() {
		String query="select * from product";
		List<GroceryProduct> products=this.jdbcTemplate.query(query,new RowMapperImpl());
		return products;
	}

	public GroceryProduct searchById(int id) {
		String query="select * from product where id=?";
		RowMapper<GroceryProduct> rowMapper=new RowMapperImpl();
		GroceryProduct product = this.jdbcTemplate.queryForObject(query, rowMapper,id);
		return product;
	}
	
}
