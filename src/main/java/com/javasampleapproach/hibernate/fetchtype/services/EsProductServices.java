package com.javasampleapproach.hibernate.fetchtype.services;

import static java.lang.System.out;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasampleapproach.hibernate.fetchtype.model.EsProductEntity;
import com.javasampleapproach.hibernate.fetchtype.repository.EsProductRepository;


@Service
public class EsProductServices {
	@Autowired
    EsProductRepository prodRepo;

	public void save(EsProductEntity prod){
		prodRepo.save(prod);
	}
	
	@Transactional
	public void showData(){
		out.println("\n=====================Retrieve Products from Database:====================");
		List<EsProductEntity> prodList = prodRepo.findAll();
		out.println("\n=====================Print All Products on console:====================");
		prodList.forEach(System.out::println);;
	}
		
	public void deleteAll(){
		prodRepo.deleteAll();
	}
}
