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
	private Double prix;
	private String name;
	private String image;
    private String description;
    @Column(name="id_status")
    private Long statusCode;
    @Column(name="id_category")
    private Long categoryCode;
    @Column(name="id_user")
    private Long userCode;
	@Column(name="id_availability")
	private Long availability;
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
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
	public Long getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Long statusCode) {
		this.statusCode = statusCode;
	}
	public Long getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(Long categoryCode) {
		this.categoryCode = categoryCode;
	}
	public Long getUserCode() {
		return userCode;
	}
	public void setUserCode(Long userCode) {
		this.userCode = userCode;
	}

	public Long getAvailability() {
		return availability;
	}

	public void setAvailability(Long availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", image='" + image + '\'' +
				", description='" + description + '\'' +
				", statusCode=" + statusCode +
				", categoryCode=" + categoryCode +
				", userCode=" + userCode +
				", availability='" + availability + '\'' +
				", prix='" + prix + '\'' +
				'}';
	}
}
