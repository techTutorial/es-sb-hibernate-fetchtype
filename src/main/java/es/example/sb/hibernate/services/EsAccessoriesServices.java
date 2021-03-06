package es.example.sb.hibernate.services;

import static java.lang.System.out;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.example.sb.hibernate.model.EsAccessoriesEntity;
import es.example.sb.hibernate.repository.EsAccessoriesRepository;

@Service
public class EsAccessoriesServices {
	
	@Autowired
    EsAccessoriesRepository accessRepo;
	
	public void save(EsAccessoriesEntity accessories){
		accessRepo.save(accessories);
	}
	
	@Transactional
	public void showData(){
		out.println("\n=====================Retrieve Accessories from Database:====================");
		List<EsAccessoriesEntity> accessList = accessRepo.findAll();
		out.println("\n=====================Print All Accessories on console:====================");
        accessList.forEach(out::println);
	}
	
	
	public void deleteAll(){
		accessRepo.deleteAll();
	}
	
}
