package projet.studenity.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT")
public class Product {
	@Id
    @Column(name="id_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
	private String image;
    private String description;
    @Column(name="id_status")
    private String statusCode;
    @Column(name="id_category")
    private Date categoryCode;
    @Column(name="id_user")
    private String userCode;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public Date getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(Date categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", image=" + image + ", description=" + description
				+ ", statusCode=" + statusCode + ", categoryCode=" + categoryCode + ", userCode=" + userCode + "]";
	}
    
    
}
