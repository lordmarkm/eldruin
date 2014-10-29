package com.eldruin.retail.ics.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eldruin.retail.ics.models.RetailProduct;
import com.eldruin.retail.ics.models.RetailStock;
import com.eldruin.retail.ics.services.custom.StockServiceCustom;
import com.tyrael.erp.ics.models.Location;

/**
 * @author mbmartinez
 */
public interface StockService extends StockServiceCustom,
    JpaRepository<RetailStock, Long> {

    List<RetailStock> findByProduct(RetailProduct product);
    List<RetailStock> findByLocation(Location location);

}
