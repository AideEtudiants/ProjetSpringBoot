package projet.studenity.service;

import projet.studenity.model.Cart;

public interface CartService {
    public boolean addToCart(Cart cart);
    public boolean deleteFromCart(Long id);
    public boolean payCart(Long idUser);
}
