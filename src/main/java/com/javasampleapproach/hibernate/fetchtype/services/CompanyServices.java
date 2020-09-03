package com.javasampleapproach.hibernate.fetchtype.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasampleapproach.hibernate.fetchtype.model.Company;
import com.javasampleapproach.hibernate.fetchtype.repository.CompanyRepository;


@Service
public class CompanyServices {
	@Autowired
    CompanyRepository companyRepository;

	public void save(Company company){
		companyRepository.save(company);
	}
	
	@Transactional
	public void showData(){
		System.out.println("=====================Retrieve Companies from Database:====================");
		List<Company> companyLst = companyRepository.findAll();
		System.out.println("=====================Show All Companies on console:====================");
		companyLst.forEach(System.out::println);;
	}
		
	public void deleteAll(){
		companyRepository.deleteAll();
	}
}