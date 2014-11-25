package com.eldruin.retail.ics.services.custom;

import org.springframework.transaction.annotation.Transactional;

import com.eldruin.retail.ics.dto.RetailProductInfo;
import com.eldruin.retail.ics.models.RetailProduct;
import com.tyrael.commons.data.service.TyraelJpaService;

/**
 * @author mbmartinez
 */
@Transactional
public interface RetailProductServiceCustom extends TyraelJpaService<RetailProduct, RetailProductInfo> {

    RetailProductInfo findByCodeInfo(String code);

}
