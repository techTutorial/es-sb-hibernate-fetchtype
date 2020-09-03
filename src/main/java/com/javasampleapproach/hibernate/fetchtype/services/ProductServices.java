package com.javasampleapproach.hibernate.fetchtype.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javasampleapproach.hibernate.fetchtype.model.Product;
import com.javasampleapproach.hibernate.fetchtype.repository.ProductRepository;

@Service
public class ProductServices {
	@Autowired
    ProductRepository productRepository;
	
	public void save(Product product){
		productRepository.save(product);
	}
	
	@Transactional
	public void showData(){
		System.out.println("=====================Retrieve Products from Database:====================");
		List<Product> productLst = productRepository.findAll();
		System.out.println("=====================Show All Products on console:====================");
        productLst.forEach(System.out::println);
	}
	
	
	public void deleteAll(){
		productRepository.deleteAll();
	}
}
