package com.preorder.web.member.service;

import com.preorder.domain.member.WishList;
import com.preorder.domain.product.Product;
import com.preorder.web.member.dto.WishListDTO;
import com.preorder.web.member.repository.WishListRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishListService {

    @Autowired
    private WishListRepository wishListRepository;


    public void addProduct(WishList wishList) {
        WishListDTO wishListDTO  = new WishListDTO();
        wishListDTO.setMemberId(wishList.getMemberId());
        wishListDTO.setPdId(wishList.getPdId());
//        wishListDTO.setWishAddDate(wishList.getWishAddDate()); // null 값을 넣으면 현재시간으로 자동 등록
       wishListRepository.save(wishListDTO);
    }

}
