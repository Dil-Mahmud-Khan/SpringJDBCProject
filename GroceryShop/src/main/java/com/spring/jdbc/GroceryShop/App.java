package com.spring.jdbc.GroceryShop;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.GroceryProductDao;
import com.spring.jdbc.model.GroceryProduct;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/GroceryShop/config.xml");
        
        GroceryProductDao groceryProductDao=context.getBean("groceryDao",GroceryProductDao.class);
        
        
        Console.start(groceryProductDao);
        
        //insert
//        GroceryProduct product=new GroceryProduct();
//        product.setId(2);
//        product.setName("Rice");
//        product.setPrice(150.00);
//        product.setQuantity(5);
//        
//        int result=groceryProductDao.insert(product);
//        System.out.println("Product Inserted"+result);
//         
//        ////
//        //same for the update show and delete
//        ////
//        
//       
    	}
    }

