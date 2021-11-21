package projet.studenity.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import projet.studenity.model.Product;
import projet.studenity.model.User;

@Repository
public class UserDao {
	
	@Autowired
	private EntityManager entityManager;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getUserCount() {
		return jdbcTemplate.queryForObject("select count(1) from Users", Integer.class);
	}
  
	public User findById(long id) {
		return this.entityManager.find(User.class, id);
	}
	
	public List<User> findByFirstName(String firstName) {
		return jdbcTemplate.query("select * from Users where first_name = ?", new UserRowMapper(), new Object[] {firstName});
	}

	@Transactional
	public void createUser(User user){
		entityManager.createNativeQuery("INSERT INTO product (id_user, first_name,last_name,email," +
						"birth_date,study_level, establishment, certificate_regist, photo, password) VALUES (?,?,?,?,?,?,?,?,?,?)")
				.setParameter(1, 5)
				.setParameter(2, user.getFirstName())
				.setParameter(3, user.getLastName())
				.setParameter(4, user.getEmail())
				.setParameter(5, user.getBirthDate())
				.setParameter(6, user.getStudyLevel())
				.setParameter(7, user.getEstablishment())
				.setParameter(8, user.getCertificateRegist())
				.setParameter(9, user.getPhoto())
				.setParameter(10, user.getPassword())
				.executeUpdate();
	}

//	public User getUserById(long id) {
//		return jdbcTemplate.queryForObject("select * from Users where id_user = ?", new UserRowMapper(), new Object[] {id});
//	}

	public List<User> getAll() {
		return jdbcTemplate.query("select * from Users", new UserRowMapper());
	}

	private final class UserRowMapper implements RowMapper<User> {
	@Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
      	User user = new User();
      	user.setId(rs.getLong("id_user"));
      	user.setFirstName(rs.getString("first_name"));
      	user.setLastName(rs.getString("last_name"));
      	user.setEmail(rs.getString("Email"));
      	user.setBirthDate(rs.getDate("birth_date"));
      	user.setStudyLevel(rs.getString("study_level"));
      	user.setEstablishment(rs.getString("establishment"));
      	user.setPassword(rs.getString("password"));
      	user.setPhoto(rs.getString("photo"));
      	user.setCertificateRegist(rs.getString("certificate_regist"));
      	return user;
    }
  }

}