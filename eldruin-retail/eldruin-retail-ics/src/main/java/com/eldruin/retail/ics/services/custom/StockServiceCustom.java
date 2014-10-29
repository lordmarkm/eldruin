package com.eldruin.retail.ics.services.custom;

import java.util.List;

import com.eldruin.retail.ics.dto.RetailStockInfo;
import com.eldruin.retail.ics.models.RetailProduct;
import com.eldruin.retail.ics.models.RetailStock;
import com.tyrael.commons.data.service.TyraelJpaService;
import com.tyrael.erp.ics.models.Location;

/**
 * @author mbmartinez
 */
public interface StockServiceCustom extends TyraelJpaService<RetailStock, RetailStockInfo> {

    List<RetailStockInfo> findByProductInfo(RetailProduct product);
    List<RetailStockInfo> findByLocationInfo(Location location);

}
