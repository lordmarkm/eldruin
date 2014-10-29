package com.eldruin.retail.ics.dto;

import org.springframework.core.style.ToStringCreator;

import com.tyrael.commons.dto.BaseTyraelDto;
import com.tyrael.erp.ics.dto.LocationInfo;

/**
 * @author mbmartinez
 */
public class RetailStockInfo extends BaseTyraelDto {

    protected RetailProductInfo product;
    protected LocationInfo location;

    protected ToStringCreator toStringCreator() {
        return super.toStringCreator()
            .append("product", product)
            .append("location", location);
    }

    public RetailProductInfo getProduct() {
        return product;
    }

    public void setProduct(RetailProductInfo product) {
        this.product = product;
    }

    public LocationInfo getLocation() {
        return location;
    }

    public void setLocation(LocationInfo location) {
        this.location = location;
    }

}
