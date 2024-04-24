package com.preorder.web.member.dto;

import com.preorder.domain.member.Member;
import com.preorder.domain.product.Product;
import lombok.Data;

import java.time.LocalDate;

@Data
public class WishListDTO {

    private Product pdId;  // 상품번호
    private Member memberId;  // 회원 아이디
    private LocalDate wishAddDate;
}
