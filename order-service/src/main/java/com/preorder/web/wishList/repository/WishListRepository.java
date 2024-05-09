package com.preorder.web.wishList.repository;

import com.preorder.domain.wishList.WishList;
import com.preorder.web.wishList.dto.WishListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {
    WishList findByMemberNoAndPdIdAndOpId(long memberNo, int pdId, int opId);

    // 회원정보(PK)로 검색한 위시리스트 전체 목록
    List<WishList> findAllByMemberNo(long memberNo);

    // 위시리스트 내의 항목 *삭제
    void deleteByWishId(int wishId);
}
