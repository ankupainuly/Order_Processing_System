package com.shop.dao;

import java.io.FileNotFoundException;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.shop.model.Product;

public class ProductJson {

	public final int productId;
	public String productName;
	public double price;
	public int productCategory;
	static FileReader reader;
	public int productQuantity;

	public ProductJson(int productId, String productName, double price, int productCategory, int productQuantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}

	
	public ProductJson() {
		this.productId = 0;
		// TODO Auto-generated constructor stub
	}

	// Read JSON file
	public List<Product> readJsonFile() {
		
		//System.out.println("befor json");
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject;
		JSONArray jsonArray;
		List<Product> productList;
		
		//System.out.println("after json");

		try {
			//System.out.println("try");
			
			reader = new FileReader("C:\\Users\\bhavi\\Desktop\\JsonUploads1\\ProductJson.json");
			jsonObject = (JSONObject) jsonParser.parse(reader);
			productList=new ArrayList<Product>();
			//System.out.println(jsonObject.toString());
			jsonArray = (JSONArray) jsonObject.get("product");
			int i=0;
	            while(i<jsonArray.size()) {
	            	JSONObject prod=(JSONObject) jsonArray.get(i);
	               // System.out.println(prod);
	                Product p=getValuesFromJson(prod);
	                productList.add(p);
	                i++;
	            }
	            
	       return productList;
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			System.out.println("parse catch");
			e.printStackTrace();
		}
		return null;
	}
	

	public Product getValuesFromJson(JSONObject product)
	{
		 //Get product ID
		
        String proID = (String) product.get("productID");  
        int productID=Integer.parseInt(proID);
      //  System.out.println(productID);
         
        //Get product name
        String productName = (String) product.get("productName");  
        //System.out.println(productName);
        
        //get product price
        String price=(String) product.get("productPrice");
        //System.out.println(price);
        Double productPrice=Double.parseDouble(price);
         
        //Get product level
        String productLevel = (String) product.get("productLevel"); 
        
        //get product available quantity
        String quantity = (String) product.get("productQuantity"); 
        int productQuantity =Integer.parseInt(quantity);
        //System.out.println(productLevel);
        
        Product prod=new Product(productID,productName,productPrice, productLevel,productQuantity);
        return prod;
	}
	
	
	
}