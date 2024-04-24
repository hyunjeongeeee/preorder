package com.preorder.web.member.repository;

import com.preorder.domain.member.WishList;
import com.preorder.web.member.dto.WishListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {

    public void save(WishListDTO wishListDTO);


}
