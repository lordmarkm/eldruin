package com.eldruin.retail.ics.services.custom.impl;

import java.util.List;

import com.eldruin.retail.ics.dto.RetailStockInfo;
import com.eldruin.retail.ics.models.RetailProduct;
import com.eldruin.retail.ics.models.RetailStock;
import com.eldruin.retail.ics.services.StockService;
import com.eldruin.retail.ics.services.custom.StockServiceCustom;
import com.tyrael.commons.data.service.TyraelJpaServiceCustomImpl;
import com.tyrael.erp.ics.models.Location;

public class StockServiceCustomImpl extends TyraelJpaServiceCustomImpl<RetailStock, RetailStockInfo, StockService>
    implements StockServiceCustom {

    @Override
    public List<RetailStockInfo> findByProductInfo(RetailProduct product) {
        return toDto(repo.findByProduct(product));
    }

    @Override
    public List<RetailStockInfo> findByLocationInfo(Location location) {
        return toDto(repo.findByLocation(location));
    }

}
