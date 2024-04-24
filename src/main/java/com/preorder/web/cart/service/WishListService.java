package com.preorder.web.cart.service;

import com.preorder.domain.cart.WishList;
import com.preorder.web.cart.dto.WishListDTO;
import com.preorder.web.cart.repository.WishListRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class WishListService {

    private final WishListRepository wishListRepository;
    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    /**
     * 장바구니에 상품 추가하기
     *  + 업데이트
     * */

    @Transactional
    public void addCart(WishListDTO wishListDTO) {
        int wishId = wishListDTO.getCartId();
        long memberNo = wishListDTO.getMemberNo();
        int optionId = wishListDTO.getOpId();
        int pdCount = wishListDTO.getPdCount();

        WishList wishList = new WishList();
        wishList.setWishId(wishId);

        if(wishListRepository.findById(wishId).isPresent()) {
            wishList = wishListRepository.findById(wishId).get(); // 해당 상품이 위시리스트에 있을경우
            wishList.setPdCount(pdCount + wishList.getPdCount()); // 기존값에 더해주기
        } else {
            wishList.setPdCount(pdCount);
        }

        wishList.setMemberNo(memberNo);
        wishList.setOptionId(optionId);

        wishListRepository.save(wishList);
    }


}
