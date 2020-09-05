package es.example.sb.hibernate;

import static java.lang.System.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.example.sb.hibernate.model.EsAccessoriesEntity;
import es.example.sb.hibernate.model.EsProductEntity;
import es.example.sb.hibernate.services.EsAccessoriesServices;
import es.example.sb.hibernate.services.EsProductServices;
import es.example.sb.hibernate.services.EsReviewService;


@SpringBootApplication
public class SpringHibernateFetchType implements CommandLineRunner{
	
	@Autowired
	EsProductServices prodService;
	
	@Autowired
	EsAccessoriesServices accessService;

	@Autowired
	EsReviewService reviewService;

	
    public static void main(String[] args) {
    	SpringApplication.run(SpringHibernateFetchType.class, args);
    }
 
    
    @Override
    public void run(String... arg0) throws Exception {
    	//clearData(); // not working after enabling it
    	saveData();
    	showData();
    }
    
    private void clearData(){
    	out.println("\n\n=================== Clear DATA =======================");
    	prodService.deleteAll();
        accessService.deleteAll();
    }
    
    // Shift into repository class using static initialization block > Pending
    private void saveData(){
    	out.println("\n\n=================== Save DATA =======================");
    	EsAccessoriesEntity access11 = new EsAccessoriesEntity("ACCESS-11");
        EsAccessoriesEntity access12 = new EsAccessoriesEntity("ACCESS-12");
        
        EsAccessoriesEntity access21 = new EsAccessoriesEntity("ACCESS-21");
        EsAccessoriesEntity access22 = new EsAccessoriesEntity("ACCESS-22");
         
        EsProductEntity prod11 = new EsProductEntity("PROD-11");
        EsProductEntity prod21 = new EsProductEntity("PROD-21");
        
        // set product for accessories
        access11.setProdAccessEntity(prod11);
        access12.setProdAccessEntity(prod11);
        
        access21.setProdAccessEntity(prod21);
        access22.setProdAccessEntity(prod21);
        
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
        
        out.println("\n\n=================== Reviews =======================");
        reviewService.showData();
    }
    
}