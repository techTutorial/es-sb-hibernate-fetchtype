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
    
	// @ManyToOne: mandatory, MappingException is thrown after removing @ManyToOne.
    @ManyToOne(fetch=FetchType.LAZY)
    // @JoinColumn(name="ID_PRODUCT_ACCESSORIES"): optional, without it, NO complain,
    // but accessories details will be empty for both product and accessories object.
    // @JoinColumn has no dependency on FOREIGN KEY defined in database
    @JoinColumn(name="ID_PRODUCT_ACCESSORIES")
    private EsProductEntity prodAccessEntity;
    
    public EsAccessoriesEntity(String name){
    	this.accessName = name;
    }
    
    public String getAccessName() {
        return accessName;
    }
    
    public void setAccessName(String accessName) {
        this.accessName = accessName;
    }
    
    public void setProdAccessEntity(EsProductEntity esProductEntity){
    	this.prodAccessEntity = esProductEntity;
    }
    
    public EsProductEntity getProdAccessEntity(){
    	return this.prodAccessEntity;
    }
    
    public String toString(){
    	String info = "";	
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("accessName",this.accessName);

        if(this.getProdAccessEntity() != null){
        	JSONObject prodJsonObj = new JSONObject();
            prodJsonObj.put("prodName", this.getProdAccessEntity().getProdName());
            jsonInfo.put("product", prodJsonObj);
            info = jsonInfo.toString();
        }
        return info;
    }
    
}
