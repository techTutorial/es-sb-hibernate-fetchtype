package com.javasampleapproach.hibernate.fetchtype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javasampleapproach.hibernate.fetchtype.model.EsProductEntity;
import com.javasampleapproach.hibernate.fetchtype.model.EsAccessoriesEntity;
import com.javasampleapproach.hibernate.fetchtype.services.CompanyServices;
import com.javasampleapproach.hibernate.fetchtype.services.ProductServices;


@SpringBootApplication
public class SpringHibernateFetchType implements CommandLineRunner{
	@Autowired
	CompanyServices companyService;
	
	@Autowired
	ProductServices productService;

 
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
        productService.deleteAll();
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
        
        // save companies
        companyService.save(apple);
        companyService.save(samsung);
         
        // save products
        productService.save(iphone7);
        productService.save(iPadPro);
        
        productService.save(galaxyJ7);
        productService.save(galaxyTabA);
    }
    
    private void showData(){
    	System.out.println("=================== Show ALL Data =======================");
        companyService.showData();
        productService.showData();
    }
    
}