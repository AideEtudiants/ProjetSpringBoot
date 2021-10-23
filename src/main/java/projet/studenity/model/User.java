package projet.studenity.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name="id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String lastName;
	private String firstName;
    private String email;
    private String 	password;
    private Date birthDate;
    private String studyLevel;
    private String establishment;
    private String certificateRegist;
    private String photo;

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
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

	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email
				+ ", password=" + password + ", birthDate=" + birthDate + ", studyLevel=" + studyLevel
				+ ", establishment=" + establishment + ", certificateRegist=" + certificateRegist + ", photo=" + photo
				+ "]";
	}
	
	
    
}