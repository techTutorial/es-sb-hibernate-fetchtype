package com.javasampleapproach.hibernate.fetchtype.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name="ES_ACCESSORIES")
public class Product{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PRODUCT")
	private int id;
    
	@Column(name = "NAME_PRODUCT")
	private String name;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_COMPANY")
    private Company company;
    
    public Product(){
    }
    
    public Product(String name){
    	this.name = name;
    }
    
    public Product(String name, Company company){
    	this.name = name;
    	this.company = company;
    }
    
    // name
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    // products
    public void setCompany(Company company){
    	this.company = company;
    }
    
    public Company getCompany(){
    	return this.company;
    }
    
    public String toString(){
    	String info = "";
    	
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("name",this.name);

        if(this.getCompany() != null){
        	JSONObject companyObj = new JSONObject();
            companyObj.put("name", this.getCompany().getName());
            jsonInfo.put("company", companyObj);
            info = jsonInfo.toString();
        }
        
        return info;
    }
}
