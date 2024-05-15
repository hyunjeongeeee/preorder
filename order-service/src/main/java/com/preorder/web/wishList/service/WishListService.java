package com.preorder.web.wishList.service;

import com.preorder.domain.wishList.WishList;
import com.preorder.web.wishList.repository.WishListRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishListService {

    private final WishListRepository wishListRepository;

    // 위시리스트 1개 추가해보기 테스트
//    public int writeBoard(long memberNo, int pdId, WishListDTO.WishRequest request) {
//        // memberId를 어떻게 가져올까?
//        final WishList wishList = new WishList(pdId, memberNo, request.getPdId(), request.getOpId());
//        final WishList result =  wishListRepository.save(wishList);
//        return result.getWishId(); // wishlist id 반환되는지 확인하기
//    }

    /**
     * 위시리스트에 상품 추가하기
     *  + 담겨있는 상품일 경우 수량 업데이트(상품수량 변경)
     * */
    @Transactional
    public void addCartProcess(WishList wishList) {

        int pdId = wishList.getProductId();
        long memberNo = wishList.getMemberId();
        int opId = wishList.getOptionId();
        int pdCount = wishList.getProductCount();

        WishList data = wishListRepository.findByMemberIdAndProductIdAndOptionId(memberNo, pdId, opId);

        if (data != null) {
            int pdTotalCount = data.getProductCount() + pdCount;
            data.setProductCount(pdTotalCount); // 기존 엔티티 수정
        }
            // 새로운 위시리스트 항목을 생성하는 로직 (옵셔널)
            WishList newWishList = new WishList(pdId, memberNo, opId, pdCount);
            wishListRepository.save(newWishList);

    }

    /**
     * 회원정보(PK)로 검색한 위시리스트 전체 목록
     * */
    public List<WishList> getWishList(long memberId) {
        List<WishList> list = wishListRepository.findAllByMemberId(memberId);
        return list;
    }


    /**
     * WishId(PK)로 위시리스트 항목 삭제
     * */
    @Transactional
    public void deleteWishList(int wishId) {
        wishListRepository.deleteByWishId(wishId);
    }




    // 서비스간 요청 내부적인
    // 사용자가 접근하는 url 사용자 요청







}


