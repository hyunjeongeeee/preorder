package com.preorder.web.wishList.repository;

import com.preorder.domain.wishList.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {

    Optional<WishList> findByMemberNoAndPdId(long MemberNo, int pdId);
}
