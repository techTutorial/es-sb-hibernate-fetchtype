package com.javasampleapproach.hibernate.fetchtype.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javasampleapproach.hibernate.fetchtype.model.EsAccessoriesEntity;
import com.javasampleapproach.hibernate.fetchtype.repository.EsAccessoriesRepository;

@Service
public class EsAccessoriesServices {
	@Autowired
    EsAccessoriesRepository productRepository;
	
	public void save(EsAccessoriesEntity accessories){
		productRepository.save(accessories);
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
