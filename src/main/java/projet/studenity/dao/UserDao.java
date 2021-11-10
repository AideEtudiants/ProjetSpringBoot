package projet.studenity.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
	
//	public User findByName(String firstName) {
//		return this.entityManager.find(User.class, 1, firstName);
//	}

	public User getUserById(long id) {
		return jdbcTemplate.queryForObject("select * from Users where id_user = ?", new UserRowMapper(), new Object[] {id});
	}

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