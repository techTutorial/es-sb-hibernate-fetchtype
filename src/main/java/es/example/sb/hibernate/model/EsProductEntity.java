package es.example.sb.hibernate.model;

import java.util.HashSet;
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
    
	// mappedBy="", NO complain without it but EsProductEntity, @ManyToOne, @JoinColumn are there
	// without mappedBy, accessories details will be empty for ONLY product object.
	// mappedBy="" has dependency on member variable EsProductEntity injected in Accessories bean;
	// mappedBy="" has NO dependency on FOREIGN KEY defined in database
	// For illegal value of mappedBy, ConstraintViolationException OR Referential integrity constraint violation
    @OneToMany(mappedBy="prodAccessEntity", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<EsAccessoriesEntity> accessEntity;
    
    //@OneToMany(mappedBy="prodReviewEntity", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    //private Set<EsReviewEntity> reviewEntity = new HashSet<>();
    
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
        
        /*JSONArray reviewArray = new JSONArray();
        if(this.getReviewEntity() != null){
            this.getReviewEntity().forEach(review -> {
                JSONObject subJson = new JSONObject();
                subJson.put("reviewStar", review.getReviewStar());
                reviewArray.put(subJson);
            });
        }
        jsonInfo.put("reviews", reviewArray);*/
        
        info = jsonInfo.toString();
        return info;
    }
    
}
