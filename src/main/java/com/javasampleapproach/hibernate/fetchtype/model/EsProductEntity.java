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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ES_PRODUCT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EsProductEntity{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_PRODUCT")
	private int prodId;
	
	@Column(name="NAME_PRODUCT")
    private String prodName;
    
	// mappedBy="prodEntity" is mandatory regardless of FOREIGN KEY definition in database
	// without mappedBy="prodEntity", ConstraintViolationException OR Referential integrity constraint violation
    @OneToMany(mappedBy="prodEntity", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<EsAccessoriesEntity> products;
    
    public EsProductEntity(String name){
    	this.prodName = name;
    }
    
    public EsProductEntity(String name, Set<EsAccessoriesEntity> products){
    	this.prodName = name;
    	this.products = products;
    }
    
    public String toString(){
    	String info = "";
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("prodName",this.prodName);
        
        JSONArray productArray = new JSONArray();
        if(this.getProducts() != null){
            this.getProducts().forEach(accessories->{
                JSONObject subJson = new JSONObject();
                subJson.put("accessName", accessories.getName());
                productArray.put(subJson);
            });
        }
        jsonInfo.put("products", productArray);
        info = jsonInfo.toString();
        return info;
    }
    
}
