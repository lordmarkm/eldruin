package com.eldruin.retail.ics.dto;

import org.springframework.core.style.ToStringCreator;

import com.tyrael.commons.dto.BaseTyraelNamedDto;

/**
 * @author mbmartinez
 */
public class RetailProductInfo extends BaseTyraelNamedDto {

    private String code;

    protected ToStringCreator toStringCreator() {
        return super.toStringCreator()
            .append("code", code);
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

}
