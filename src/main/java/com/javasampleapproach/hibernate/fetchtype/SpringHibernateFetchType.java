package com.javasampleapproach.hibernate.fetchtype;

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
    	System.out.println("=================== Clear DATA =======================");
    	prodService.deleteAll();
        accessService.deleteAll();
    }
    
    private void saveData(){
    	System.out.println("=================== Save DATA =======================");
    	EsAccessoriesEntity iphone7 = new EsAccessoriesEntity("Iphone 7");
        EsAccessoriesEntity iPadPro = new EsAccessoriesEntity("IPadPro");
        
        EsAccessoriesEntity galaxyJ7 = new EsAccessoriesEntity("GalaxyJ7");
        EsAccessoriesEntity galaxyTabA = new EsAccessoriesEntity("GalaxyTabA");
         
        EsProductEntity apple = new EsProductEntity("Apple");
        EsProductEntity samsung = new EsProductEntity("Samsung");
        
        // set product for products
        iphone7.setProdEntity(apple);
        iPadPro.setProdEntity(apple);
        
        galaxyJ7.setProdEntity(samsung);
        galaxyTabA.setProdEntity(samsung);
        
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
    	System.out.println("=================== Show ALL Data =======================");
        prodService.showData();
        accessService.showData();
    }
    
}