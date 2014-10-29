package com.eldruin.retail.ics.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.tyrael.erp.ics.models.Stock;

@Entity(name = "STOCK")
public class RetailStock extends Stock<RetailProduct> {

    @ManyToOne(optional = false)
    @JoinColumn(name = "PRODUCT_ID")
    private RetailProduct product;

    public RetailProduct getProduct() {
        return product;
    }

    public void setProduct(RetailProduct product) {
        this.product = product;
    }
}
