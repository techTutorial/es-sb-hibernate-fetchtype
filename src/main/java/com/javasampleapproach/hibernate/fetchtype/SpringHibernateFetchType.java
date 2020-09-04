package com.javasampleapproach.hibernate.fetchtype;

import static java.lang.System.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javasampleapproach.hibernate.fetchtype.model.EsProductEntity;
import com.javasampleapproach.hibernate.fetchtype.model.EsAccessoriesEntity;
import com.javasampleapproach.hibernate.fetchtype.services.EsProductServices;
import com.javasampleapproach.hibernate.fetchtype.services.EsAccessoriesServices;


@SpringBootApplication
public class SpringHibernateFetchType implements CommandLineRunner{
	
	@Autowired
	EsProductServices prodService;
	
	@Autowired
	EsAccessoriesServices accessService;

 
    public static void main(String[] args) {
    	SpringApplication.run(SpringHibernateFetchType.class, args);
    }
 
    
    @Override
    public void run(String... arg0) throws Exception {
    	//clearData();
    	saveData();
    	showData();
    }
    
    private void clearData(){
    	out.println("\n\n=================== Clear DATA =======================");
    	prodService.deleteAll();
        accessService.deleteAll();
    }
    
    private void saveData(){
    	out.println("\n\n=================== Save DATA =======================");
    	EsAccessoriesEntity access11 = new EsAccessoriesEntity("ACCESS-11");
        EsAccessoriesEntity access12 = new EsAccessoriesEntity("ACCESS-12");
        
        EsAccessoriesEntity access21 = new EsAccessoriesEntity("ACCESS-21");
        EsAccessoriesEntity access22 = new EsAccessoriesEntity("ACCESS-22");
         
        EsProductEntity prod11 = new EsProductEntity("PROD-11");
        EsProductEntity prod21 = new EsProductEntity("PROD-21");
        
        // set product for products
        access11.setEsProductEntity(prod11);
        access12.setEsProductEntity(prod11);
        
        access21.setEsProductEntity(prod21);
        access22.setEsProductEntity(prod21);
        
        // save products
        prodService.save(prod11);
        prodService.save(prod21);
         
        // save accessories
        accessService.save(access11);
        accessService.save(access12);
        
        accessService.save(access21);
        accessService.save(access22);
    }
    
    private void showData(){
    	out.println("\n\n=================== Products =======================");
        prodService.showData();
        
        out.println("\n\n=================== Accessories =======================");
        accessService.showData();
    }
    
}