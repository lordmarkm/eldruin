package com.eldruin.retail.ics.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eldruin.retail.ics.models.RetailProduct;
import com.eldruin.retail.ics.services.custom.RetailProductServiceCustom;

/**
 * @author mbmartinez
 */
public interface RetailProductService extends RetailProductServiceCustom,
    JpaRepository<RetailProduct, Long> {

    RetailProduct findByCode(String code);

}
