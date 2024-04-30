package com.preorder.web.wishList.controller;

import com.preorder.domain.wishList.WishList;
import com.preorder.web.wishList.service.WishListService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wish")
public class WishListController {

    private final WishListService wishListService;

    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    /**
     *  위시리스트에 상품추가
     * */
    @PostMapping("/products")
    public String addToCart(@RequestBody  WishList wishList) {
        wishListService.addCartProcess(wishList);
        return  "success";
    }
//
//    @GetMapping("/view")
//    public ResponseEntity<?> viewCart(@RequestParam("member") long memberNo) {
//        List<WishListDTO.WishListViewDTO> list =  wishListService.viewWishList(memberNo);
//        System.out.println("memberNo : " + memberNo);
//        return ResponseEntity.ok(list);
//    }




}
