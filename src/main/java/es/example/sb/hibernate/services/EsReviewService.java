package es.example.sb.hibernate.services;

import static java.lang.System.out;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.example.sb.hibernate.model.EsReviewEntity;
import es.example.sb.hibernate.repository.EsReviewRepository;

@Service
public class EsReviewService {
	
	@Autowired
    EsReviewRepository reviewRepo;
	
	public void save(EsReviewEntity review){
		reviewRepo.save(review);
	}
	
	@Transactional
	public void showData(){
		out.println("\n=====================Retrieve Review from Database:====================");
		List<EsReviewEntity> accessList = reviewRepo.findAll();
		
		out.println("\n=====================Print All Review on console:====================");
        accessList.forEach(out::println);
	}
	
	public void deleteAll(){
		reviewRepo.deleteAll();
	}
	
}
