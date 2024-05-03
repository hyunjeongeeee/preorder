package com.preorder.web.wishList.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WishListDTO {

    private int wishId;
    private int pdId;
    private long memberNo;
    private int opId;
    private int pdCount;


//    @Getter
//    @Setter
//    public class WishRequest{
//        private int pdId;
//        private int opId;
//
//        public WishRequest(int pdId, int opId){
//            this.pdId = pdId;
//            this.opId = opId;
//        }
//    }

}
