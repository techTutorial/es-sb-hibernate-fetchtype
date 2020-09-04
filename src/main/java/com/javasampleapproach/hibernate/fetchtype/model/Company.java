package com.javasampleapproach.hibernate.fetchtype.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.json.JSONArray;
import org.json.JSONObject;

@Entity
@Table(name="ES_PRODUCT")
public class Company{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_COMPANY")
	private int id;
	
	@Column(name="NAME_COMPANY")
    private String name;
    
	// mappedBy="company" is mandatory regardless of FOREIGN KEY definition in database
	// without mappedBy="company", ConstraintViolationException OR Referential integrity constraint violation
	// illegal mappedBy="Company" OR "COMPANY" OR "COMPANY2"
    @OneToMany(mappedBy="company", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<Product> products;
    
    public Company(){
    }
    
    public Company(String name){
    	this.name = name;
    }
    
    public Company(String name, Set<Product> products){
    	this.name = name;
    	this.products = products;
    }
    
    // name
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    // products
    public void setProducts(Set<Product> products){
    	this.products = products;
    }
    
    public Set<Product> getProducts(){
    	return this.products;
    }
    
    public String toString(){
    	String info = "";
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("name",this.name);
        
        JSONArray productArray = new JSONArray();
        if(this.getProducts() != null){
            this.getProducts().forEach(product->{
                JSONObject subJson = new JSONObject();
                subJson.put("name", product.getName());
                productArray.put(subJson);
            });
        }
        jsonInfo.put("products", productArray);
        info = jsonInfo.toString();
        return info;
    }
}
