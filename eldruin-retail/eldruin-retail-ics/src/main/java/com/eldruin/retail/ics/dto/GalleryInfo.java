package com.eldruin.retail.ics.dto;

import java.util.List;

/**
 * @author mbmartinez
 */
public class GalleryInfo {

    private ImageInfo thumbnail;
    private List<ImageInfo> images;

    public ImageInfo getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(ImageInfo thumbnail) {
        this.thumbnail = thumbnail;
    }
    public List<ImageInfo> getImages() {
        return images;
    }
    public void setImages(List<ImageInfo> images) {
        this.images = images;
    }

}
