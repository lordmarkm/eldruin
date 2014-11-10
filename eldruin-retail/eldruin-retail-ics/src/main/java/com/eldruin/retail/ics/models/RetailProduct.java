package com.eldruin.retail.ics.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.eldruin.retail.ics.reference.RetailProductStatus;
import com.tyrael.commons.models.Product;

/**
 * @author mbmartinez
 */
@Entity(name = "PRODUCT")
public class RetailProduct extends Product {

    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    /**
     * This is the amount that will appear on the base pricelist, but will be overridden by pricelist values.
     */
    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private RetailProductStatus status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public RetailProductStatus getStatus() {
        return status;
    }

    public void setStatus(RetailProductStatus status) {
        this.status = status;
    }

}
