package com.eldruin.retail.ics.services.test;

import static org.junit.Assert.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eldruin.retail.core.config.EldruinRetailCorePersistenceConfig;
import com.eldruin.retail.ics.config.EldruinRetailIcsConfig;
import com.eldruin.retail.ics.dto.RetailStockInfo;
import com.eldruin.retail.ics.models.RetailProduct;
import com.eldruin.retail.ics.models.RetailStock;
import com.eldruin.retail.ics.services.RetailProductService;
import com.eldruin.retail.ics.services.StockService;
import com.tyrael.commons.mapper.config.MapperConfig;

/**
 * @author mbmartinez
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        MapperConfig.class,
        EldruinRetailIcsConfig.class, 
        EldruinRetailCorePersistenceConfig.class
})
public class StockServiceTest {

    @Autowired
    private StockService service;

    @Autowired
    private RetailProductService productService;

    @Before
    public void clean() {
        service.deleteAll();
        productService.deleteAll();
    }

    private RetailProduct saveGenericProduct() {
        RetailProduct product = new RetailProduct();
        product.setCode(RandomStringUtils.randomAlphanumeric(10));
        product.setDescription("Some desc");
        product.setName("some name");
        product.setUnitOfMeasurement("kg");
        return productService.save(product);
    }

    @Test
    public void testFindByProduct() {
        //Generic product
        RetailProduct p = saveGenericProduct();

        //Stock with product p
        RetailStock stock = new RetailStock();
        stock.setProduct(p);
        stock = service.save(stock);

        assertEquals(stock.getId(), service.findByProduct(p).get(0).getId());
    }

    @Test
    public void testFindByProductInfo() {
        //Generic product
        RetailProduct p = saveGenericProduct();

        //Stock with product p
        RetailStock stock = new RetailStock();
        stock.setProduct(p);
        stock = service.save(stock);

        //Dto has the same ID as saved entity
        RetailStockInfo dto = service.findByProductInfo(p).get(0);
        System.out.println(dto);
        assertEquals(stock.getId(), service.findByProductInfo(p).get(0).getId());

        //Product was also mapped and is the same as p
        assertNotNull(dto.getProduct());
        assertEquals(p.getId(), dto.getProduct().getId());
    }
}
