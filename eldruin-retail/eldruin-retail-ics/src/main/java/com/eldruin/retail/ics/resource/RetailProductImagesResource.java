package com.eldruin.retail.ics.resource;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baldy.commons.models.image.web.WebImage;
import com.baldy.commons.models.image.web.WebImageGallery;
import com.baldy.commons.web.controller.GenericController;
import com.eldruin.retail.ics.models.RetailProduct;
import com.eldruin.retail.ics.services.RetailProductService;
import com.eldruin.retail.ics.services.WebImageService;
import com.google.common.base.Preconditions;

@RestController
@RequestMapping("/retailproductimages")
public class RetailProductImagesResource extends GenericController {

    @Autowired
    private RetailProductService service;

    @Autowired
    private WebImageService imageService;

    @Transactional
    @RequestMapping(value = "/thumbnail", method = PUT, params = "url")
    public ResponseEntity<String> setThumbnailFromUrl(@RequestParam String productCode,
            @RequestParam String url,
            @RequestParam boolean addToGallery) {

        WebImage image = new WebImage();
        image.setUrl(url);
        imageService.save(image);

        RetailProduct product = service.findByCode(productCode);
        WebImageGallery gallery = product.getGallery();

        gallery.setThumbnail(image);
        if (addToGallery) {
            gallery.getImages().add(image);
        }

        return new ResponseEntity<>("Ok", ACCEPTED);
    }

    @Transactional
    @RequestMapping(value = "/thumbnail", method = PUT, params = "imageId")
    public ResponseEntity<String> setThumbnailFromExistingImage(@RequestParam String productCode,
            @RequestParam Long imageId) {
        WebImage img = imageService.findOne(imageId);
        Preconditions.checkNotNull(img, "Image not found with id " + imageId);

        RetailProduct product = service.findByCode(productCode);
        Preconditions.checkNotNull(product, "Product not found with code " + productCode);

        product.getGallery().setThumbnail(img);

        return new ResponseEntity<>("Ok", ACCEPTED);
    }
}
