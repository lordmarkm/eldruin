package com.eldruin.retail.ics.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baldy.commons.models.image.web.WebImage;

/**
 * @author mbmartinez
 */
public interface WebImageService extends JpaRepository<WebImage, Long> {

}
