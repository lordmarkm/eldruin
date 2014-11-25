package com.eldruin.retail.ics.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.baldy.commons.models.image.web.WebImageGallery;
import com.eldruin.retail.ics.reference.RetailProductStatus;
import com.tyrael.commons.models.Product;
import static javax.persistence.CascadeType.*;

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

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "GALLERY_ID")
    private WebImageGallery gallery;

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

    public WebImageGallery getGallery() {
        if (null == gallery) {
            this.gallery = new WebImageGallery();
        }
        return gallery;
    }

    public void setGallery(WebImageGallery gallery) {
        this.gallery = gallery;
    }

}
