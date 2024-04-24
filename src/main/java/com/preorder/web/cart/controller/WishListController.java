package com.preorder.web.cart.controller;

import com.preorder.web.cart.dto.WishListDTO;
import com.preorder.web.cart.service.WishListService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishListController {

    private final WishListService wishListService;

    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    /**
     *  위시리스트
     * */

    @PostMapping("/add-wish")
    public String addToCart(WishListDTO wishListDTO) {
        wishListService.addCart(wishListDTO);
        return  "success";
    }




}
