package com.preorder.web.product.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductDTO {

    private int pdId;
    private String pdName;
    private int pdPrice;
    private int pdStock;
    private String pdDescription;
    private LocalDate pdAddDate;
    private LocalDate pdUpdate;
    private String categoryCode;
    private  String pdStatus;

    public ProductDTO findAllProduct(String pdName, int pdPrice, String pdDescription, String pdStatus) {
        this.pdName = pdName;
        this.pdPrice = pdPrice;
        return this;

    }


}
