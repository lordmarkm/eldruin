package com.eldruin.retail.ics.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baldy.commons.web.controller.GenericController;
import com.eldruin.retail.ics.dto.RetailProductInfo;
import com.eldruin.retail.ics.models.RetailProduct;
import com.eldruin.retail.ics.services.RetailProductService;
import com.tyrael.commons.dto.PageInfo;

@RestController
@RequestMapping("/retailproduct")
public class RetailProductResource extends GenericController {

    private static Logger LOG = LoggerFactory.getLogger(RetailProductResource.class);

    @Autowired
    private RetailProductService service;

    @RequestMapping(method = GET)
    public ResponseEntity<PageInfo<RetailProductInfo>> page(Principal principal,
            @RequestParam int page, @RequestParam int count) {
        PageRequest pageReq = new PageRequest(page - 1, count, Direction.ASC, "name");
        return new ResponseEntity<>(service.pageInfo(pageReq), OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<RetailProductInfo> save(Principal principal,
            @RequestBody RetailProductInfo retailProductInfo) {
        LOG.debug("Save request. user={}, product={}", name(principal), retailProductInfo);
        return new ResponseEntity<>(service.saveInfo(retailProductInfo), OK);
    }

    @RequestMapping(value = "/{code}", method = GET)
    public ResponseEntity<RetailProductInfo> findByCode(Principal principal, String code) {
        LOG.debug("findByCode request. user={}, code={}", name(principal), code);
        return new ResponseEntity<>(service.findByCodeInfo(code), OK);
    }

    @RequestMapping(value = "/{code}", method = DELETE)
    public ResponseEntity<RetailProductInfo> deleteByCode(Principal principal, String code) {
        LOG.debug("Delete request. user={}, code={}", name(principal), code);
        RetailProduct product = service.findByCode(code);
        return new ResponseEntity<>(service.softDelete(product.getId()), OK);
    }
}
