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
    
	// mappedBy="esProductEntity" is mandatory regardless of FOREIGN KEY definition in database
	// without mappedBy="esProductEntity", ConstraintViolationException OR Referential integrity constraint violation
    @OneToMany(mappedBy="prodAccessEntity", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<EsAccessoriesEntity> accessEntity;
    
    //@OneToMany(mappedBy="prodReviewEntity", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    //private Set<EsReviewEntity> reviewEntity = new HashSet();
    
    public EsProductEntity(String name){
    	this.prodName = name;
    }
    
    public String toString(){
    	String info = "";
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("prodName",this.prodName);
        
        JSONArray accessArray = new JSONArray();
        if(this.getAccessEntity() != null){
            this.getAccessEntity().forEach(accessories->{
                JSONObject subJson = new JSONObject();
                subJson.put("accessName", accessories.getAccessName());
                accessArray.put(subJson);
            });
        }
        jsonInfo.put("accessories", accessArray);
        info = jsonInfo.toString();
        return info;
    }
    
}
