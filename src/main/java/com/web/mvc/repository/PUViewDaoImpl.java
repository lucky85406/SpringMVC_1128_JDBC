package com.web.mvc.repository;

import com.web.mvc.entity.DiscountCode;
import com.web.mvc.entity.PUView;
import com.web.mvc.repository.spec.PUViewDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository(value = "puviewDao")
public class PUViewDaoImpl implements PUViewDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

        @Override
    public List<PUView> queryPUView() {
        String sql = "SELECT * FROM PU_VIEW";
        List<PUView> list = jdbcTemplate.query(sql, RM.puviewMapper);
        return list;
    }

    @Override
    public List<PUView> queryPUViewByProductCodeName(String productCodeName) {
        String sql = "SELECT * FROM PU_VIEW WHERE PRODUCT_CODE_NAME = ?";
        List<PUView> list = jdbcTemplate.query(sql, new Object[]{productCodeName}, RM.puviewMapper);
        return list;
    }

    
    
    

}
