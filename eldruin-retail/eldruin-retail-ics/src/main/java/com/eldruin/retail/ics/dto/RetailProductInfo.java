package com.eldruin.retail.ics.dto;

import java.math.BigDecimal;

import org.springframework.core.style.ToStringCreator;

import com.eldruin.retail.ics.reference.RetailProductStatus;
import com.tyrael.commons.dto.BaseTyraelNamedDto;

/**
 * @author mbmartinez
 */
public class RetailProductInfo extends BaseTyraelNamedDto {

    private String code;
    private BigDecimal price;
    private RetailProductStatus status;
    private GalleryInfo gallery;

    protected ToStringCreator toStringCreator() {
        return super.toStringCreator()
            .append("code", code)
            .append("price", price)
            .append("status", status);
    }

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

    public GalleryInfo getGallery() {
        return gallery;
    }

    public void setGallery(GalleryInfo gallery) {
        this.gallery = gallery;
    }

}
