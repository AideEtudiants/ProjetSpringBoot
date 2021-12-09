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
    private Date birthDate;
    @Column(name="study_level")
    private String studyLevel;
    private String establishment;
    @Column(name="certificate_regist")
    private String certificateRegist;
    private String photo;

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
		return "User [id_user=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email
				+ ", password=" + password + ", birthDate=" + birthDate + ", studyLevel=" + studyLevel
				+ ", establishment=" + establishment + ", certificateRegist=" + certificateRegist + ", photo=" + photo
				+ "]";
	}
	
	
    
}