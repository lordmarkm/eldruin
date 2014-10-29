package com.eldruin.retail.ics.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eldruin.retail.ics.models.RetailProduct;

/**
 * @author mbmartinez
 */
public interface RetailProductService extends JpaRepository<RetailProduct, Long> {

}
