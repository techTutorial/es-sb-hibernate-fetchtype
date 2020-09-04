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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ES_ACCESSORIES")
//@Data
@NoArgsConstructor
@AllArgsConstructor
public class EsAccessoriesEntity{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_ACCESSORIES")
	private int id;
    
	@Column(name = "NAME_ACCESSORIES")
	private String name;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PRODUCT")
    private EsProductEntity company;
    
    public EsAccessoriesEntity(String name){
    	this.name = name;
    }
    
    public EsAccessoriesEntity(String name, EsProductEntity company){
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
    public void setCompany(EsProductEntity company){
    	this.company = company;
    }
    
    public EsProductEntity getCompany(){
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
