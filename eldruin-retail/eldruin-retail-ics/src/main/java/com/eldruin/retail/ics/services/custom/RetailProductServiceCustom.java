package com.eldruin.retail.ics.services.custom;

import com.eldruin.retail.ics.dto.RetailProductInfo;
import com.eldruin.retail.ics.models.RetailProduct;
import com.tyrael.commons.data.service.TyraelJpaService;

/**
 * @author mbmartinez
 */
public interface RetailProductServiceCustom extends TyraelJpaService<RetailProduct, RetailProductInfo> {

    RetailProductInfo findByCodeInfo(String code);

}
