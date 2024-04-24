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
    private int pdDescription;
    private LocalDate pdAddDate;
    private LocalDate pdUpdate;
    private String categoryCode;
    private  String pdStatus;

}
