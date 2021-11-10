package projet.studenity.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import projet.studenity.model.Product;
import projet.studenity.model.User;
import projet.studenity.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductDao {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getProductCount() {
        return jdbcTemplate.queryForObject("select count(1) from Product", Integer.class);
    }

    public Product findProductById(long id) {
        return this.entityManager.find(Product.class, id);
    }

    public List<Product> findProductByName(String name) {
        return jdbcTemplate.query("select * from Product where name = ?", new ProductDao.ProductRowMapper(), new Object[]{name});
    }

    public List<Product> getAll() {
        return jdbcTemplate.query("select * from Product", new ProductDao.ProductRowMapper());
    }

    public void createProduct(Product product){

    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }

    private final class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setId(rs.getLong("id_product"));
            product.setName(rs.getString("name"));
            product.setDescription(rs.getString("description"));
            product.setCategoryCode(rs.getLong("id_category"));
            product.setStatusCode(rs.getLong("id_status"));
            product.setImage(rs.getString("image"));
            product.setUserCode(rs.getLong("id_user"));
            return product;
        }
    }
}
