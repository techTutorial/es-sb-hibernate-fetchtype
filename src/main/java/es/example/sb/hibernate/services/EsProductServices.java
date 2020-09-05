package es.example.sb.hibernate.services;

import static java.lang.System.out;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.example.sb.hibernate.model.EsProductEntity;
import es.example.sb.hibernate.repository.EsProductRepository;


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
		prodList.forEach(out::println);;
	}
		
	public void deleteAll(){
		prodRepo.deleteAll();
	}
}
