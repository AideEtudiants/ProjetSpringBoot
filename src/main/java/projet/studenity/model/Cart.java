package projet.studenity.model;

import javax.persistence.*;

@Entity
@Table(name="CART")
public class Cart {
    @Id
    @Column(name="id_Cart")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="id_User")
    private Long idUser;
    @Column(name="id_Product")
    private Long idProduct;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }
}
