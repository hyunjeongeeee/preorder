package com.preorder.web.member.Controller;

import com.preorder.domain.member.WishList;
import com.preorder.web.member.dto.WishListDTO;
import com.preorder.web.member.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishListController {

    @Autowired
    private WishListService wishListService;

    @PostMapping("/wish")
    public void addProduct(WishList wishList) {
        wishListService.addProduct(wishList);

    }



}
