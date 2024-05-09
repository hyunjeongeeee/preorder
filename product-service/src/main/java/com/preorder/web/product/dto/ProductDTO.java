package com.preorder.web.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private int pdId;
    private String pdName;
    private int pdPrice;
    private int pdStock;
    private String categoryCode;
    private  String pdStatus;

}
