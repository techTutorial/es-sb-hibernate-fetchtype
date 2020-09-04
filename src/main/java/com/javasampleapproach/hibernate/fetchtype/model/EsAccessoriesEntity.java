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
	private int accessId;
    
	@Column(name = "NAME_ACCESSORIES")
	private String accessName;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PRODUCT")
    private EsProductEntity prodEntity;
    
    public EsAccessoriesEntity(String name){
    	this.accessName = name;
    }
    
    public EsAccessoriesEntity(String name, EsProductEntity prodEntity){
    	this.accessName = name;
    	this.prodEntity = prodEntity;
    }
    
    // name
    public String getName() {
        return accessName;
    }
    
    public void setName(String name) {
        this.accessName = name;
    }
    
    // products
    public void setCompany(EsProductEntity prodEntity){
    	this.prodEntity = prodEntity;
    }
    
    public EsProductEntity getCompany(){
    	return this.prodEntity;
    }
    
    public String toString(){
    	String info = "";	
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("name",this.accessName);

        if(this.getCompany() != null){
        	JSONObject companyObj = new JSONObject();
            companyObj.put("name", this.getCompany().getProdName());
            jsonInfo.put("company", companyObj);
            info = jsonInfo.toString();
        }
        return info;
    }
    
}
