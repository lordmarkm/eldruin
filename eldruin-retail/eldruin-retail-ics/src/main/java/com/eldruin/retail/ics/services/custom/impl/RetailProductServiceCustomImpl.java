package com.eldruin.retail.ics.services.custom.impl;

import com.eldruin.retail.ics.dto.RetailProductInfo;
import com.eldruin.retail.ics.models.RetailProduct;
import com.eldruin.retail.ics.services.RetailProductService;
import com.eldruin.retail.ics.services.custom.RetailProductServiceCustom;
import com.tyrael.commons.data.service.TyraelJpaServiceCustomImpl;

/**
 * @author mbmartinez
 */
public class RetailProductServiceCustomImpl 
    extends TyraelJpaServiceCustomImpl<RetailProduct, RetailProductInfo, RetailProductService>
    implements RetailProductServiceCustom {

    @Override
    public RetailProductInfo findByCodeInfo(String code) {
        return toDto(repo.findByCode(code));
    }

}
