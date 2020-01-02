package com.web.mvc.repository;

import com.web.mvc.entity.DiscountCode;
import com.web.mvc.entity.MicroMarket;
import org.springframework.jdbc.core.RowMapper;

public class RM {

    static RowMapper<DiscountCode> discountCode = (rs, i) -> {
        DiscountCode dc = new DiscountCode();
        dc.setDiscountCode(rs.getString("DISCOUNT_CODE"));
        return dc;
    };
    static RowMapper<MicroMarket> micromarket = (rs, i) -> {
        MicroMarket dc = new MicroMarket();
        dc.setZipCode(rs.getString("ZIP_CODE"));
        return dc;
    };
}
