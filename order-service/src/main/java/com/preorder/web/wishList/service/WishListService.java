package com.preorder.web.wishList.service;

import com.preorder.domain.wishList.WishList;
import com.preorder.web.wishList.repository.WishListRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WishListService {

    private final WishListRepository wishListRepository;

    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    /**
     * 위시리스트에 상품 추가하기
     *  + 담겨있는 상품일 경우 수량 업데이트
     * */
    @Transactional
    public void addCartProcess(WishList wishList) {

        int pdId = wishList.getPdId();
        long memberNo = wishList.getMemberNo();
        int opId = wishList.getOpId();
        int pdCount = wishList.getPdCount();

        Optional<WishList> data = wishListRepository.findByMemberNoAndPdId(memberNo, pdId);

        if (data.isPresent()) {
            WishList existingWishList = data.get();
            int pdTotalCount = existingWishList.getPdCount() + pdCount;
            existingWishList.setPdCount(pdTotalCount); // 기존 엔티티 수정
        } else {
            // 새로운 위시리스트 항목을 생성하는 로직 (옵셔널)
            WishList newWishList = new WishList(pdId, memberNo, opId, pdCount);
            wishListRepository.save(newWishList);
        }
    }

    /**
     * 해당 회원 (memberNo로 검색)
     * 위시리스트에 있는
     * 상품 조회해보기
     * */



}


