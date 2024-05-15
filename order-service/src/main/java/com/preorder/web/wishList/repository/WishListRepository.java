package com.preorder.web.wishList.repository;

import com.preorder.domain.wishList.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {
    WishList findByMemberIdAndProductIdAndOptionId(long memberId, int productId, int optionId);

    // 회원정보(PK)로 검색한 위시리스트 전체 목록
    List<WishList> findAllByMemberId(long memberId);

    // 위시리스트 내의 항목 *삭제
    void deleteByWishId(int wishId);
}
