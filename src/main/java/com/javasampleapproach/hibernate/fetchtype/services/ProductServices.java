package com.javasampleapproach.hibernate.fetchtype.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javasampleapproach.hibernate.fetchtype.model.EsAccessoriesEntity;
import com.javasampleapproach.hibernate.fetchtype.repository.ProductRepository;

@Service
public class ProductServices {
	@Autowired
    ProductRepository productRepository;
	
	public void save(EsAccessoriesEntity product){
		productRepository.save(product);
	}
	
	@Transactional
	public void showData(){
		System.out.println("=====================Retrieve Products from Database:====================");
		List<EsAccessoriesEntity> productLst = productRepository.findAll();
		System.out.println("=====================Show All Products on console:====================");
        productLst.forEach(System.out::println);
	}
	
	
	public void deleteAll(){
		productRepository.deleteAll();
	}
}
