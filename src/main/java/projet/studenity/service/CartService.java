package projet.studenity.service;

import projet.studenity.model.Cart;

public interface CartService {
    public boolean addToCart(Cart cart);
    public boolean deleteFromCart(Cart cart);
    public boolean payCart(Long idUser);
    public boolean deleteAllFromCart(Long idUser);
    public Double totalPrice(Long idUser);
}
