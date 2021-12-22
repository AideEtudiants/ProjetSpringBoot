package projet.studenity.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name="id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="last_name")
    private String lastName;
    @Column(name="first_name")
	private String firstName;
    private String email;
    private String 	password;
    @Column(name="birth_date")
    private String birthDate;
    @Column(name="study_level")
    private String studyLevel;
    private String establishment;
    @Column(name="certificate_regist")
    private String certificateRegist;
    private String photo;
	private int point;
	private String address;
	@Column(name="POSTAL_CODE")
	private int postalCode;

	public int getId() {
		return id;
	}

	public void setId(int id_user) {
		this.id = id_user;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getStudyLevel() {
		return studyLevel;
	}

	public void setStudyLevel(String studyLevel) {
		this.studyLevel = studyLevel;
	}

	public String getEstablishment() {
		return establishment;
	}

	public void setEstablishment(String establishment) {
		this.establishment = establishment;
	}

	public String getCertificateRegist() {
		return certificateRegist;
	}

	public void setCertificateRegist(String certificateRegist) {
		this.certificateRegist = certificateRegist;
	}   
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
}