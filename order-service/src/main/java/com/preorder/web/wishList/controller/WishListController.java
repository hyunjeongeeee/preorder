package com.preorder.web.wishList.controller;

import com.preorder.domain.wishList.WishList;
import com.preorder.web.wishList.service.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/wishList")
public class WishListController {

    private final WishListService wishListService;

    /**
     *  위시리스트에 상품추가
     * */
    @PostMapping("/add")
    public String addToCart(@RequestBody  WishList wishList) {
        wishListService.addCartProcess(wishList);
        return  "success";
    }

    /**
     * 내가 등록한 상품에 대한 정보 보여주기
     * 상세 페이지 이동
     * 회원정보(PK)로 검색한 위시리스트 전체 목록
     * */
    @GetMapping("/{memberId}")
    public ResponseEntity<List<WishList>> wishList(@PathVariable("memberId") long memberId) {
        List<WishList> list = wishListService.getWishList(memberId);
        return ResponseEntity.ok(list);
    }


    /**
     * 위시리스트 내의 항목 수정
     * 수정, 삭제, 추가?,
     * */

//    @GetMapping("/delete/{wishId}")
//    public String deleteWishList(@PathVariable("wishId") int wishId) {
//        wishListService.deleteWishList(wishId);
//        return "success";
//    }
    @GetMapping("/delete/{wishId}")
    public String deleteWishList(@PathVariable("wishId") int wishId) {
        wishListService.deleteWishList(wishId);
        return "success";
    }





}
