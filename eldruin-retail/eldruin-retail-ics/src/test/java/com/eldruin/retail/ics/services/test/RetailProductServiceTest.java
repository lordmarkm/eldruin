package com.eldruin.retail.ics.services.test;

import static org.junit.Assert.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eldruin.retail.ics.config.EldruinRetailIcsConfig;
import com.eldruin.retail.ics.config.EldruinRetailIcsPersistenceConfig;
import com.eldruin.retail.ics.dto.RetailProductInfo;
import com.eldruin.retail.ics.models.RetailProduct;
import com.eldruin.retail.ics.services.RetailProductService;
import com.tyrael.commons.dto.PageInfo;
import com.tyrael.commons.mapper.config.MapperConfig;

/**
 * @author mbmartinez
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        MapperConfig.class,
        EldruinRetailIcsConfig.class, 
        EldruinRetailIcsPersistenceConfig.class
})
public class RetailProductServiceTest {

    @Autowired
    private RetailProductService service;

    @Before
    public void init() {
        service.deleteAll();
    }

    private RetailProduct saveGeneric() {
        RetailProduct product = new RetailProduct();
        product.setCode(RandomStringUtils.randomAlphanumeric(10));
        product.setDescription("Some desc");
        product.setName("some name");
        product.setUnitOfMeasurement("kg");
        return service.save(product);
    }

    @Test
    public void testFindOneInfo() {
        RetailProduct e = saveGeneric();
        RetailProductInfo d = service.findOneInfo(e.getId());
        assertNotNull(d);
        assertEquals(e.getName(), d.getName());
    }

    @Test
    public void testFindPaginated() {
        saveGeneric();
        saveGeneric();
        saveGeneric();

        int pageSize = 2;

        PageRequest pageReq1  = new PageRequest(0, pageSize);
        PageInfo<RetailProductInfo> page1 = service.pageInfo(pageReq1);
        assertNotNull(page1);
        assertEquals(3, page1.getTotal());
        assertEquals(2, page1.getData().size());

        PageRequest pageReq2  = new PageRequest(1, pageSize);
        PageInfo<RetailProductInfo> page2 = service.pageInfo(pageReq2);
        assertNotNull(page2);
        assertEquals(3, page2.getTotal());
        assertEquals(1, page2.getData().size());
    }
}
