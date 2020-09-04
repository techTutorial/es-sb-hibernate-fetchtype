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
	EsProductServices companyService;
	
	@Autowired
	EsAccessoriesServices accessoriesService;

 
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
    	companyService.deleteAll();
        accessoriesService.deleteAll();
    }
    
    private void saveData(){
    	System.out.println("=================== Save DATA =======================");
    	EsAccessoriesEntity iphone7 = new EsAccessoriesEntity("Iphone 7");
        EsAccessoriesEntity iPadPro = new EsAccessoriesEntity("IPadPro");
        
        EsAccessoriesEntity galaxyJ7 = new EsAccessoriesEntity("GalaxyJ7");
        EsAccessoriesEntity galaxyTabA = new EsAccessoriesEntity("GalaxyTabA");
         
        EsProductEntity apple = new EsProductEntity("Apple");
        EsProductEntity samsung = new EsProductEntity("Samsung");
        
        // set company for products
        iphone7.setCompany(apple);
        iPadPro.setCompany(apple);
        
        galaxyJ7.setCompany(samsung);
        galaxyTabA.setCompany(samsung);
        
        // save products
        companyService.save(apple);
        companyService.save(samsung);
         
        // save accessories
        accessoriesService.save(iphone7);
        accessoriesService.save(iPadPro);
        
        accessoriesService.save(galaxyJ7);
        accessoriesService.save(galaxyTabA);
    }
    
    private void showData(){
    	System.out.println("=================== Show ALL Data =======================");
        companyService.showData();
        accessoriesService.showData();
    }
    
}