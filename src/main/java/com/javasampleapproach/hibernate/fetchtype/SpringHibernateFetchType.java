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
    	clearData();
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
    	EsAccessoriesEntity iphone7 = new EsAccessoriesEntity("Iphone 7");
        EsAccessoriesEntity iPadPro = new EsAccessoriesEntity("IPadPro");
        
        EsAccessoriesEntity galaxyJ7 = new EsAccessoriesEntity("GalaxyJ7");
        EsAccessoriesEntity galaxyTabA = new EsAccessoriesEntity("GalaxyTabA");
         
        EsProductEntity apple = new EsProductEntity("Apple");
        EsProductEntity samsung = new EsProductEntity("Samsung");
        
        // set product for products
        iphone7.setEsProductEntity(apple);
        iPadPro.setEsProductEntity(apple);
        
        galaxyJ7.setEsProductEntity(samsung);
        galaxyTabA.setEsProductEntity(samsung);
        
        // save products
        prodService.save(apple);
        prodService.save(samsung);
         
        // save accessories
        accessService.save(iphone7);
        accessService.save(iPadPro);
        
        accessService.save(galaxyJ7);
        accessService.save(galaxyTabA);
    }
    
    private void showData(){
    	out.println("\n\n=================== Products =======================");
        prodService.showData();
        out.println("\n\n=================== Accessories =======================");
        accessService.showData();
    }
    
}