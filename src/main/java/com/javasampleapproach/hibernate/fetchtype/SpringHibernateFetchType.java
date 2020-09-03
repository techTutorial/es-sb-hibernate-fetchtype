package com.javasampleapproach.hibernate.fetchtype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javasampleapproach.hibernate.fetchtype.model.Company;
import com.javasampleapproach.hibernate.fetchtype.model.Product;
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
    	Product iphone7 = new Product("Iphone 7");
        Product iPadPro = new Product("IPadPro");
        
        Product galaxyJ7 = new Product("GalaxyJ7");
        Product galaxyTabA = new Product("GalaxyTabA");
         
        Company apple = new Company("Apple");
        Company samsung = new Company("Samsung");
        
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