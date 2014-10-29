package com.eldruin.retail.ics.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.tyrael.commons.models.Product;

/**
 * @author mbmartinez
 */
@Entity(name = "PRODUCT")
public class RetailProduct extends Product {

    @Column(unique = true)
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
