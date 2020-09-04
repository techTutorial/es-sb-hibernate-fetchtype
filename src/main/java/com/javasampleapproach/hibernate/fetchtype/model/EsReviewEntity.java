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
@Table(name="ES_REVIEW")
//@Data
@NoArgsConstructor
@AllArgsConstructor
public class EsReviewEntity{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_REVIEW")
	private int reviewId;
    
	@Column(name = "STAR_REVIEW")
	private String reviewStar;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PRODUCT_REVIEW")
    private EsProductEntity esProductEntity;
    
    public EsReviewEntity(String name){
    	this.reviewStar = name;
    }
    
    public String getReviewStar() {
        return reviewStar;
    }
    
    public void setReviewStar(String reviewStar) {
        this.reviewStar = reviewStar;
    }
    
    public void setEsProductEntity(EsProductEntity esProductEntity){
    	this.esProductEntity = esProductEntity;
    }
    
    public EsProductEntity getEsProductEntity(){
    	return this.esProductEntity;
    }
    
    public String toString(){
    	String info = "";	
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("reviewStar", this.reviewStar);

        if(this.getEsProductEntity() != null){
        	JSONObject prodJsonObj = new JSONObject();
            prodJsonObj.put("prodName", this.getEsProductEntity().getProdName());
            jsonInfo.put("product", prodJsonObj);
            info = jsonInfo.toString();
        }
        return info;
    }
    
}
