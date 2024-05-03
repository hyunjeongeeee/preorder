package com.preorder.web.wishList.service;

import com.preorder.domain.wishList.WishList;
import com.preorder.web.wishList.repository.WishListRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WishListService {

    private final WishListRepository wishListRepository;
    private final MemberClient memberClient;

    public WishListService(WishListRepository wishListRepository, MemberClient memberClient) {
        this.wishListRepository = wishListRepository;
        this.memberClient = memberClient;
    }






    // 위시리스트 1개 추가해보기 테스트
//    public int writeBoard(long memberNo, int pdId, WishListDTO.WishRequest request) {
//        // memberId를 어떻게 가져올까?
//        final WishList wishList = new WishList(pdId, memberNo, request.getPdId(), request.getOpId());
//        final WishList result =  wishListRepository.save(wishList);
//        return result.getWishId(); // wishlist id 반환되는지 확인하기
//    }

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




}


