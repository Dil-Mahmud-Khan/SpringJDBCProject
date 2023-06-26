package com.spring.jdbc.GroceryShop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.xml.transform.Source;

import com.spring.jdbc.dao.GroceryProductDao;
import com.spring.jdbc.model.GroceryProduct;

public class Console {
	public static void start(GroceryProductDao dao) throws NumberFormatException, IOException{
		
		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			System.out.println("-----Welcome to Grocery Shop--------\n");
			System.out.println("1.Insert a Product\n"
					+ "2.Update a Product\n"+""
							+ "3.Delete a Product\n"+""
									+ "4.Search a Product\n"+""
											+ "5.Show all Product\n");
			System.out.println("Option: ");
			
			switch (Integer.parseInt(sc.readLine())) {
			case 1:
				String sn;
				double price;
				Integer integer;
				GroceryProduct product=new GroceryProduct();
				System.out.println("----Adding a Product----");
				System.out.println("Enter Name:");
				sn=sc.readLine();
				product.setName(sn);
				
				System.out.println("Enter Price:");
				price=Double.parseDouble(sc.readLine());
				product.setPrice(price);
				
				System.out.println("Quantity:");
				integer=Integer.parseInt(sc.readLine());
				product.setQuantity(integer);
				
				System.out.println(dao.insert(product)>0?"Grocery Inserted":"Product did not insert");
				break;
				
				
				
			case 2:
				product=new GroceryProduct();
				System.out.println("----Update Product----");
				System.out.println("Enter ID:");
				integer=Integer.parseInt(sc.readLine());
				product.setId(integer);
				
				System.out.println("Enter Name:");
				sn=sc.readLine();
				product.setName(sn);
				
				System.out.println("Enter Price");
				price=Double.parseDouble(sc.readLine());
				product.setPrice(price);
				
				System.out.println("Enter Quantity");
				integer=Integer.parseInt(sc.readLine());
				product.setQuantity(integer);
				
				System.out.println(dao.update(product)>0?"Product Updated":"Product can not be updated!!");
				break;
				
				
			case 3:
				product=new GroceryProduct();
				System.out.println("----Delet a Product----");
				System.out.println("Enter Id:");
				integer=Integer.parseInt(sc.readLine());
				System.out.println(dao.delete(integer)>0?"Product Deleted":"Product could not Deleted");
				break;
				
				
			case 4:
				product=new GroceryProduct();
				System.out.println("---Search a Product---");
				integer=Integer.parseInt(sc.readLine());
				System.out.println(dao.searchById(integer));
				break;
				
			case 5:
				System.out.println("----Show All Products");
				List<GroceryProduct> products=dao.viewGroceryProducts();
				System.out.println("All the"+products.size()+"Products are:\n");
				for(GroceryProduct g:products)System.out.println(g.getName());
					
				break;
				
				
			default:
				break;
			}
	
		}
			
		
	}

}