package projet.studenity.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.studenity.model.Cart;
import projet.studenity.model.Product;
import projet.studenity.repository.CartRepository;
import projet.studenity.repository.ProductRepository;
import projet.studenity.service.CartService;
import projet.studenity.service.ProductService;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepo;
    @Autowired
    ProductRepository productRepo;
    @Autowired
    ProductService productService;

    @Override
    public boolean addToCart(Cart cart) {
        try{
            cartRepo.save(cart);}
        catch(Exception e){return false;}
        return true;
    }

    @Override
    public boolean deleteFromCart(Cart cart) {
        cartRepo.delete(cart);
        return true;
    }

    @Override
    public boolean payCart(Long idUser){
        List<Cart> listCart = cartRepo.findAll();
        try {
            for (Cart cart : listCart) {
                if (cart.getIdUser() == idUser) {
                    Product product = productService.findProductById(cart.getIdProduct()); //chercher le produit de cette utilisateur
                    product.setAvailability(2L); //Passer la disponibilite a Solde
                    productService.updateProduct(product);
                    cartRepo.delete(cart);
                }
            }
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteAllFromCart(Long idUser) {
        List<Cart> listCart = cartRepo.findAll();
        try {
            for (Cart cart : listCart) {
                if (cart.getIdUser() == idUser) {
                    cartRepo.delete(cart);
                }
            }
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Double totalPrice(Long idUser) {
        List<Cart> listCart = cartRepo.findAll();
        Double price=0.0;
        try {
            for (Cart cart : listCart) {
                if (cart.getIdUser() == idUser) {
                    //chercher le produit de cette utilisateur
                    Product product = productService.findProductById(cart.getIdProduct());
                    price +=product.getPrice();
                }
            }
        }catch(Exception e){
            return null;
        }
        return price;
    }
}
