package projet.studenity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projet.studenity.model.Cart;
import projet.studenity.service.CartService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping(value="/delete")
    public boolean deleteFromCart(@RequestBody Cart cart){
        return cartService.deleteFromCart(cart);
    }

    @PostMapping(value="/create")
    public boolean addToCart(@RequestBody Cart cart){
        return cartService.addToCart(cart);
    }

    @PostMapping(value="/pay")
    public boolean payCart(@RequestBody long idUser){
        return cartService.payCart(idUser);
    }

    @PostMapping(value="/deleteAll")
    public boolean deleteAll(@RequestBody long idUser){return cartService.deleteAllFromCart(idUser);}

    @PostMapping(value="/totalPrice")
    public Double totalPrice(@RequestBody long idUser){
        return cartService.totalPrice(idUser);
    }

    @GetMapping(value="/test/")
    public boolean test() {
        Cart cart = new Cart();
        cart.setIdUser(7L);
        cart.setIdProduct(221L);
        return cartService.addToCart(cart);
    }
}