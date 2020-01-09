
package com.web.mvc.repository;

import com.web.mvc.entity.ProductCode;
import com.web.mvc.entity.PurchaseOrder;
import com.web.mvc.repository.spec.PurchaseOrderDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository(value = "purchaseOrderDao")
public class PurchaseOrderDaoImpl implements PurchaseOrderDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<PurchaseOrder> queryPurchaseOrder() {
        String sql = "SELECT * FROM PURCHASE_ORDER";
        return jdbcTemplate.query(sql, RM.purchaseOrderMapper);
    }

    @Override
    public PurchaseOrder getPurchaseOrder(Integer num) {
        String sql = "SELECT * FROM PURCHASE_ORDER WHERE ORDER_NUM = ?";
        PurchaseOrder pu = jdbcTemplate.queryForObject(sql, new Object[]{num}, RM.purchaseOrderMapper);
        return pu;
    }

    @Override
    public void savePurchaseOrder(PurchaseOrder po) {
        String sql = "INSERT INTO PURCHASE_ORDER(ORDER_NUM,CUSTOMER_ID,PRODUCT_ID,QUANTITY,SHIPPING_COST,SALES_DATE,SHIPPING_DATE,FREIGHT_COMPANY) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, po.getOrderNum(), po.getCustomerId(), po.getProductId(), po.getQuantity(),po.getShippingCost()
                                , po.getSalesDate(), po.getShippingDate(), po.getFreightCompany());
    }

    @Override
    public void updatePurchaseOrder(PurchaseOrder purchaseOrder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePurchaseOrder(Integer num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
