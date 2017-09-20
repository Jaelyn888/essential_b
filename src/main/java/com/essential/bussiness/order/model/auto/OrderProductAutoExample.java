package com.essential.bussiness.order.model.auto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.essential.bussiness.order.model.auto.OrderAutoExample.Criteria;

public class OrderProductAutoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderProductAutoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOrderProductIdIsNull() {
            addCriterion("order_product_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdIsNotNull() {
            addCriterion("order_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdEqualTo(Long value) {
            addCriterion("order_product_id =", value, "orderProductId");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdNotEqualTo(Long value) {
            addCriterion("order_product_id <>", value, "orderProductId");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdGreaterThan(Long value) {
            addCriterion("order_product_id >", value, "orderProductId");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_product_id >=", value, "orderProductId");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdLessThan(Long value) {
            addCriterion("order_product_id <", value, "orderProductId");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdLessThanOrEqualTo(Long value) {
            addCriterion("order_product_id <=", value, "orderProductId");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdIn(List<Long> values) {
            addCriterion("order_product_id in", values, "orderProductId");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdNotIn(List<Long> values) {
            addCriterion("order_product_id not in", values, "orderProductId");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdBetween(Long value1, Long value2) {
            addCriterion("order_product_id between", value1, value2, "orderProductId");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdNotBetween(Long value1, Long value2) {
            addCriterion("order_product_id not between", value1, value2, "orderProductId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andProductCountIsNull() {
            addCriterion("product_count is null");
            return (Criteria) this;
        }

        public Criteria andProductCountIsNotNull() {
            addCriterion("product_count is not null");
            return (Criteria) this;
        }

        public Criteria andProductCountEqualTo(Integer value) {
            addCriterion("product_count =", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountNotEqualTo(Integer value) {
            addCriterion("product_count <>", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountGreaterThan(Integer value) {
            addCriterion("product_count >", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_count >=", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountLessThan(Integer value) {
            addCriterion("product_count <", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountLessThanOrEqualTo(Integer value) {
            addCriterion("product_count <=", value, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountIn(List<Integer> values) {
            addCriterion("product_count in", values, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountNotIn(List<Integer> values) {
            addCriterion("product_count not in", values, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountBetween(Integer value1, Integer value2) {
            addCriterion("product_count between", value1, value2, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductCountNotBetween(Integer value1, Integer value2) {
            addCriterion("product_count not between", value1, value2, "productCount");
            return (Criteria) this;
        }

        public Criteria andProductPriceIsNull() {
            addCriterion("product_price is null");
            return (Criteria) this;
        }

        public Criteria andProductPriceIsNotNull() {
            addCriterion("product_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductPriceEqualTo(BigDecimal value) {
            addCriterion("product_price =", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotEqualTo(BigDecimal value) {
            addCriterion("product_price <>", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThan(BigDecimal value) {
            addCriterion("product_price >", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_price >=", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThan(BigDecimal value) {
            addCriterion("product_price <", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_price <=", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceIn(List<BigDecimal> values) {
            addCriterion("product_price in", values, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotIn(List<BigDecimal> values) {
            addCriterion("product_price not in", values, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_price between", value1, value2, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_price not between", value1, value2, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductPicIsNull() {
            addCriterion("product_pic is null");
            return (Criteria) this;
        }

        public Criteria andProductPicIsNotNull() {
            addCriterion("product_pic is not null");
            return (Criteria) this;
        }

        public Criteria andProductPicEqualTo(String value) {
            addCriterion("product_pic =", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicNotEqualTo(String value) {
            addCriterion("product_pic <>", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicGreaterThan(String value) {
            addCriterion("product_pic >", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicGreaterThanOrEqualTo(String value) {
            addCriterion("product_pic >=", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicLessThan(String value) {
            addCriterion("product_pic <", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicLessThanOrEqualTo(String value) {
            addCriterion("product_pic <=", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicLike(String value) {
            addCriterion("product_pic like", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicNotLike(String value) {
            addCriterion("product_pic not like", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicIn(List<String> values) {
            addCriterion("product_pic in", values, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicNotIn(List<String> values) {
            addCriterion("product_pic not in", values, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicBetween(String value1, String value2) {
            addCriterion("product_pic between", value1, value2, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicNotBetween(String value1, String value2) {
            addCriterion("product_pic not between", value1, value2, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Long value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Long value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Long value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Long value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Long value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Long> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Long> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Long value1, Long value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Long value1, Long value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }
        
        public Criteria andProductskuIdIsNull() {
            addCriterion("productsku_id is null");
            return (Criteria) this;
        }

        public Criteria andProductskuIdIsNotNull() {
            addCriterion("productsku_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductskuIdEqualTo(Long value) {
            addCriterion("productsku_id =", value, "productskuId");
            return (Criteria) this;
        }

        public Criteria andProductskuIdNotEqualTo(Long value) {
            addCriterion("productsku_id <>", value, "productskuId");
            return (Criteria) this;
        }

        public Criteria andProductskuIdGreaterThan(Long value) {
            addCriterion("productsku_id >", value, "productskuId");
            return (Criteria) this;
        }

        public Criteria andProductskuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("productsku_id >=", value, "productskuId");
            return (Criteria) this;
        }

        public Criteria andProductskuIdLessThan(Long value) {
            addCriterion("productsku_id <", value, "productskuId");
            return (Criteria) this;
        }

        public Criteria andProductskuIdLessThanOrEqualTo(Long value) {
            addCriterion("productsku_id <=", value, "productskuId");
            return (Criteria) this;
        }

        public Criteria andProductskuIdIn(List<Long> values) {
            addCriterion("productsku_id in", values, "productskuId");
            return (Criteria) this;
        }

        public Criteria andProductskuIdNotIn(List<Long> values) {
            addCriterion("productsku_id not in", values, "productskuId");
            return (Criteria) this;
        }

        public Criteria andProductskuIdBetween(Long value1, Long value2) {
            addCriterion("productsku_id between", value1, value2, "productskuId");
            return (Criteria) this;
        }

        public Criteria andProductskuIdNotBetween(Long value1, Long value2) {
            addCriterion("productsku_id not between", value1, value2, "productskuId");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdIsNull() {
            addCriterion("order_promotion_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdIsNotNull() {
            addCriterion("order_promotion_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdEqualTo(Integer value) {
            addCriterion("order_promotion_id =", value, "orderPromotionId");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdNotEqualTo(Integer value) {
            addCriterion("order_promotion_id <>", value, "orderPromotionId");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdGreaterThan(Integer value) {
            addCriterion("order_promotion_id >", value, "orderPromotionId");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_promotion_id >=", value, "orderPromotionId");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdLessThan(Integer value) {
            addCriterion("order_promotion_id <", value, "orderPromotionId");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_promotion_id <=", value, "orderPromotionId");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdIn(List<Integer> values) {
            addCriterion("order_promotion_id in", values, "orderPromotionId");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdNotIn(List<Integer> values) {
            addCriterion("order_promotion_id not in", values, "orderPromotionId");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdBetween(Integer value1, Integer value2) {
            addCriterion("order_promotion_id between", value1, value2, "orderPromotionId");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_promotion_id not between", value1, value2, "orderPromotionId");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationIsNull() {
            addCriterion("product_specification is null");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationIsNotNull() {
            addCriterion("product_specification is not null");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationEqualTo(String value) {
            addCriterion("product_specification =", value, "productSpecification");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationNotEqualTo(String value) {
            addCriterion("product_specification <>", value, "productSpecification");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationGreaterThan(String value) {
            addCriterion("product_specification >", value, "productSpecification");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationGreaterThanOrEqualTo(String value) {
            addCriterion("product_specification >=", value, "productSpecification");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationLessThan(String value) {
            addCriterion("product_specification <", value, "productSpecification");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationLessThanOrEqualTo(String value) {
            addCriterion("product_specification <=", value, "productSpecification");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationLike(String value) {
            addCriterion("product_specification like", value, "productSpecification");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationNotLike(String value) {
            addCriterion("product_specification not like", value, "productSpecification");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationIn(List<String> values) {
            addCriterion("product_specification in", values, "productSpecification");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationNotIn(List<String> values) {
            addCriterion("product_specification not in", values, "productSpecification");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationBetween(String value1, String value2) {
            addCriterion("product_specification between", value1, value2, "productSpecification");
            return (Criteria) this;
        }

        public Criteria andProductSpecificationNotBetween(String value1, String value2) {
            addCriterion("product_specification not between", value1, value2, "productSpecification");
            return (Criteria) this;
        }

        public Criteria andUserConponIdIsNull() {
            addCriterion("user_conpon_id is null");
            return (Criteria) this;
        }

        public Criteria andUserConponIdIsNotNull() {
            addCriterion("user_conpon_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserConponIdEqualTo(Long value) {
            addCriterion("user_conpon_id =", value, "userConponId");
            return (Criteria) this;
        }

        public Criteria andUserConponIdNotEqualTo(Long value) {
            addCriterion("user_conpon_id <>", value, "userConponId");
            return (Criteria) this;
        }

        public Criteria andUserConponIdGreaterThan(Long value) {
            addCriterion("user_conpon_id >", value, "userConponId");
            return (Criteria) this;
        }

        public Criteria andUserConponIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_conpon_id >=", value, "userConponId");
            return (Criteria) this;
        }

        public Criteria andUserConponIdLessThan(Long value) {
            addCriterion("user_conpon_id <", value, "userConponId");
            return (Criteria) this;
        }

        public Criteria andUserConponIdLessThanOrEqualTo(Long value) {
            addCriterion("user_conpon_id <=", value, "userConponId");
            return (Criteria) this;
        }

        public Criteria andUserConponIdIn(List<Long> values) {
            addCriterion("user_conpon_id in", values, "userConponId");
            return (Criteria) this;
        }

        public Criteria andUserConponIdNotIn(List<Long> values) {
            addCriterion("user_conpon_id not in", values, "userConponId");
            return (Criteria) this;
        }

        public Criteria andUserConponIdBetween(Long value1, Long value2) {
            addCriterion("user_conpon_id between", value1, value2, "userConponId");
            return (Criteria) this;
        }

        public Criteria andUserConponIdNotBetween(Long value1, Long value2) {
            addCriterion("user_conpon_id not between", value1, value2, "userConponId");
            return (Criteria) this;
        }
        
        public Criteria andReturnRefundStatusIsNull() {
            addCriterion("return_refund_status is null");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusIsNotNull() {
            addCriterion("return_refund_status is not null");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusEqualTo(Integer value) {
            addCriterion("return_refund_status =", value, "returnRefundStatus");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusNotEqualTo(Integer value) {
            addCriterion("return_refund_status <>", value, "returnRefundStatus");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusGreaterThan(Integer value) {
            addCriterion("return_refund_status >", value, "returnRefundStatus");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_refund_status >=", value, "returnRefundStatus");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusLessThan(Integer value) {
            addCriterion("return_refund_status <", value, "returnRefundStatus");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusLessThanOrEqualTo(Integer value) {
            addCriterion("return_refund_status <=", value, "returnRefundStatus");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusIn(List<Integer> values) {
            addCriterion("return_refund_status in", values, "returnRefundStatus");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusNotIn(List<Integer> values) {
            addCriterion("return_refund_status not in", values, "returnRefundStatus");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusBetween(Integer value1, Integer value2) {
            addCriterion("return_refund_status between", value1, value2, "returnRefundStatus");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("return_refund_status not between", value1, value2, "returnRefundStatus");
            return (Criteria) this;
        }
        
        public Criteria andArticleNumberIsNull() {
            addCriterion("article_number is null");
            return (Criteria) this;
        }

        public Criteria andArticleNumberIsNotNull() {
            addCriterion("article_number is not null");
            return (Criteria) this;
        }

        public Criteria andArticleNumberEqualTo(String value) {
            addCriterion("article_number =", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberNotEqualTo(String value) {
            addCriterion("article_number <>", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberGreaterThan(String value) {
            addCriterion("article_number >", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberGreaterThanOrEqualTo(String value) {
            addCriterion("article_number >=", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberLessThan(String value) {
            addCriterion("article_number <", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberLessThanOrEqualTo(String value) {
            addCriterion("article_number <=", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberLike(String value) {
            addCriterion("article_number like", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberNotLike(String value) {
            addCriterion("article_number not like", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberIn(List<String> values) {
            addCriterion("article_number in", values, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberNotIn(List<String> values) {
            addCriterion("article_number not in", values, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberBetween(String value1, String value2) {
            addCriterion("article_number between", value1, value2, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberNotBetween(String value1, String value2) {
            addCriterion("article_number not between", value1, value2, "articleNumber");
            return (Criteria) this;
        }
        
        public Criteria andAttr1IsNull() {
            addCriterion("attr1 is null");
            return (Criteria) this;
        }

        public Criteria andAttr1IsNotNull() {
            addCriterion("attr1 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr1EqualTo(String value) {
            addCriterion("attr1 =", value, "attr1");
            return (Criteria) this;
        }

        public Criteria andAttr1NotEqualTo(String value) {
            addCriterion("attr1 <>", value, "attr1");
            return (Criteria) this;
        }

        public Criteria andAttr1GreaterThan(String value) {
            addCriterion("attr1 >", value, "attr1");
            return (Criteria) this;
        }

        public Criteria andAttr1GreaterThanOrEqualTo(String value) {
            addCriterion("attr1 >=", value, "attr1");
            return (Criteria) this;
        }

        public Criteria andAttr1LessThan(String value) {
            addCriterion("attr1 <", value, "attr1");
            return (Criteria) this;
        }

        public Criteria andAttr1LessThanOrEqualTo(String value) {
            addCriterion("attr1 <=", value, "attr1");
            return (Criteria) this;
        }

        public Criteria andAttr1Like(String value) {
            addCriterion("attr1 like", value, "attr1");
            return (Criteria) this;
        }

        public Criteria andAttr1NotLike(String value) {
            addCriterion("attr1 not like", value, "attr1");
            return (Criteria) this;
        }

        public Criteria andAttr1In(List<String> values) {
            addCriterion("attr1 in", values, "attr1");
            return (Criteria) this;
        }

        public Criteria andAttr1NotIn(List<String> values) {
            addCriterion("attr1 not in", values, "attr1");
            return (Criteria) this;
        }

        public Criteria andAttr1Between(String value1, String value2) {
            addCriterion("attr1 between", value1, value2, "attr1");
            return (Criteria) this;
        }

        public Criteria andAttr1NotBetween(String value1, String value2) {
            addCriterion("attr1 not between", value1, value2, "attr1");
            return (Criteria) this;
        }
        
        public Criteria andAttr2IsNull() {
            addCriterion("attr2 is null");
            return (Criteria) this;
        }

        public Criteria andAttr2IsNotNull() {
            addCriterion("attr2 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr2EqualTo(String value) {
            addCriterion("attr2 =", value, "attr2");
            return (Criteria) this;
        }

        public Criteria andAttr2NotEqualTo(String value) {
            addCriterion("attr2 <>", value, "attr2");
            return (Criteria) this;
        }

        public Criteria andAttr2GreaterThan(String value) {
            addCriterion("attr2 >", value, "attr2");
            return (Criteria) this;
        }

        public Criteria andAttr2GreaterThanOrEqualTo(String value) {
            addCriterion("attr2 >=", value, "attr2");
            return (Criteria) this;
        }

        public Criteria andAttr2LessThan(String value) {
            addCriterion("attr2 <", value, "attr2");
            return (Criteria) this;
        }

        public Criteria andAttr2LessThanOrEqualTo(String value) {
            addCriterion("attr2 <=", value, "attr2");
            return (Criteria) this;
        }

        public Criteria andAttr2Like(String value) {
            addCriterion("attr2 like", value, "attr2");
            return (Criteria) this;
        }

        public Criteria andAttr2NotLike(String value) {
            addCriterion("attr2 not like", value, "attr2");
            return (Criteria) this;
        }

        public Criteria andAttr2In(List<String> values) {
            addCriterion("attr2 in", values, "attr2");
            return (Criteria) this;
        }

        public Criteria andAttr2NotIn(List<String> values) {
            addCriterion("attr2 not in", values, "attr2");
            return (Criteria) this;
        }

        public Criteria andAttr2Between(String value1, String value2) {
            addCriterion("attr2 between", value1, value2, "attr2");
            return (Criteria) this;
        }

        public Criteria andAttr2NotBetween(String value1, String value2) {
            addCriterion("attr2 not between", value1, value2, "attr2");
            return (Criteria) this;
        }
        
        public Criteria andAttr3IsNull() {
            addCriterion("attr3 is null");
            return (Criteria) this;
        }

        public Criteria andAttr3IsNotNull() {
            addCriterion("attr3 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr3EqualTo(String value) {
            addCriterion("attr3 =", value, "attr3");
            return (Criteria) this;
        }

        public Criteria andAttr3NotEqualTo(String value) {
            addCriterion("attr3 <>", value, "attr3");
            return (Criteria) this;
        }

        public Criteria andAttr3GreaterThan(String value) {
            addCriterion("attr3 >", value, "attr3");
            return (Criteria) this;
        }

        public Criteria andAttr3GreaterThanOrEqualTo(String value) {
            addCriterion("attr3 >=", value, "attr3");
            return (Criteria) this;
        }

        public Criteria andAttr3LessThan(String value) {
            addCriterion("attr3 <", value, "attr3");
            return (Criteria) this;
        }

        public Criteria andAttr3LessThanOrEqualTo(String value) {
            addCriterion("attr3 <=", value, "attr3");
            return (Criteria) this;
        }

        public Criteria andAttr3Like(String value) {
            addCriterion("attr3 like", value, "attr3");
            return (Criteria) this;
        }

        public Criteria andAttr3NotLike(String value) {
            addCriterion("attr3 not like", value, "attr3");
            return (Criteria) this;
        }

        public Criteria andAttr3In(List<String> values) {
            addCriterion("attr3 in", values, "attr3");
            return (Criteria) this;
        }

        public Criteria andAttr3NotIn(List<String> values) {
            addCriterion("attr3 not in", values, "attr3");
            return (Criteria) this;
        }

        public Criteria andAttr3Between(String value1, String value2) {
            addCriterion("attr3 between", value1, value2, "attr3");
            return (Criteria) this;
        }

        public Criteria andAttr3NotBetween(String value1, String value2) {
            addCriterion("attr3 not between", value1, value2, "attr3");
            return (Criteria) this;
        }
        
        public Criteria andAttr4IsNull() {
            addCriterion("attr4 is null");
            return (Criteria) this;
        }

        public Criteria andAttr4IsNotNull() {
            addCriterion("attr4 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr4EqualTo(String value) {
            addCriterion("attr4 =", value, "attr4");
            return (Criteria) this;
        }

        public Criteria andAttr4NotEqualTo(String value) {
            addCriterion("attr4 <>", value, "attr4");
            return (Criteria) this;
        }

        public Criteria andAttr4GreaterThan(String value) {
            addCriterion("attr4 >", value, "attr4");
            return (Criteria) this;
        }

        public Criteria andAttr4GreaterThanOrEqualTo(String value) {
            addCriterion("attr4 >=", value, "attr4");
            return (Criteria) this;
        }

        public Criteria andAttr4LessThan(String value) {
            addCriterion("attr4 <", value, "attr4");
            return (Criteria) this;
        }

        public Criteria andAttr4LessThanOrEqualTo(String value) {
            addCriterion("attr4 <=", value, "attr4");
            return (Criteria) this;
        }

        public Criteria andAttr4Like(String value) {
            addCriterion("attr4 like", value, "attr4");
            return (Criteria) this;
        }

        public Criteria andAttr4NotLike(String value) {
            addCriterion("attr4 not like", value, "attr4");
            return (Criteria) this;
        }

        public Criteria andAttr4In(List<String> values) {
            addCriterion("attr4 in", values, "attr4");
            return (Criteria) this;
        }

        public Criteria andAttr4NotIn(List<String> values) {
            addCriterion("attr4 not in", values, "attr4");
            return (Criteria) this;
        }

        public Criteria andAttr4Between(String value1, String value2) {
            addCriterion("attr4 between", value1, value2, "attr4");
            return (Criteria) this;
        }

        public Criteria andAttr4NotBetween(String value1, String value2) {
            addCriterion("attr4 not between", value1, value2, "attr4");
            return (Criteria) this;
        }
        
        public Criteria andProductActivityPriceIsNull() {
            addCriterion("product_activity_price is null");
            return (Criteria) this;
        }

        public Criteria andProductActivityPriceIsNotNull() {
            addCriterion("product_activity_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductActivityPriceEqualTo(BigDecimal value) {
            addCriterion("product_activity_price =", value, "productActivityPrice");
            return (Criteria) this;
        }

        public Criteria andProductActivityPriceNotEqualTo(BigDecimal value) {
            addCriterion("product_activity_price <>", value, "productActivityPrice");
            return (Criteria) this;
        }

        public Criteria andProductActivityPriceGreaterThan(BigDecimal value) {
            addCriterion("product_activity_price >", value, "productActivityPrice");
            return (Criteria) this;
        }

        public Criteria andProductActivityPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_activity_price >=", value, "productActivityPrice");
            return (Criteria) this;
        }

        public Criteria andProductActivityPriceLessThan(BigDecimal value) {
            addCriterion("product_activity_price <", value, "productActivityPrice");
            return (Criteria) this;
        }

        public Criteria andProductActivityPriceThanOrEqualTo(BigDecimal value) {
            addCriterion("product_activity_price <=", value, "productActivityPrice");
            return (Criteria) this;
        }

        public Criteria andProductActivityPriceIn(List<BigDecimal> values) {
            addCriterion("product_activity_price in", values, "productActivityPrice");
            return (Criteria) this;
        }

        public Criteria andProductActivityPriceNotIn(List<BigDecimal> values) {
            addCriterion("product_activity_price not in", values, "productActivityPrice");
            return (Criteria) this;
        }

        public Criteria andProductActivityPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_activity_price between", value1, value2, "productActivityPrice");
            return (Criteria) this;
        }

        public Criteria andProductActivityPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_activity_price not between", value1, value2, "productActivityPrice");
            return (Criteria) this;
        }
        
        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Long value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Long value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Long value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Long value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Long value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Long> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Long> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Long value1, Long value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Long value1, Long value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }
        
        public Criteria andCategoryNameIsNull() {
            addCriterion("category_name is null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNotNull() {
            addCriterion("category_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameEqualTo(String value) {
            addCriterion("category_name =", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotEqualTo(String value) {
            addCriterion("category_name <>", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThan(String value) {
            addCriterion("category_name >", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("category_name >=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThan(String value) {
            addCriterion("category_name <", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("category_name <=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLike(String value) {
            addCriterion("category_name like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotLike(String value) {
            addCriterion("category_name not like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIn(List<String> values) {
            addCriterion("category_name in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotIn(List<String> values) {
            addCriterion("category_name not in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameBetween(String value1, String value2) {
            addCriterion("category_name between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotBetween(String value1, String value2) {
            addCriterion("category_name not between", value1, value2, "categoryName");
            return (Criteria) this;
        }
        
        public Criteria andProductTypeIdIsNull() {
            addCriterion("product_type_id is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdIsNotNull() {
            addCriterion("product_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdEqualTo(Long value) {
            addCriterion("product_type_id =", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdNotEqualTo(Long value) {
            addCriterion("product_type_id <>", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdGreaterThan(Long value) {
            addCriterion("product_type_id >", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_type_id >=", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdLessThan(Long value) {
            addCriterion("product_type_id <", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("product_type_id <=", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdIn(List<Long> values) {
            addCriterion("product_type_id in", values, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdNotIn(List<Long> values) {
            addCriterion("product_type_id not in", values, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdBetween(Long value1, Long value2) {
            addCriterion("product_type_id between", value1, value2, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("product_type_id not between", value1, value2, "productTypeId");
            return (Criteria) this;
        }
        
        public Criteria andProductTypeNameIsNull() {
            addCriterion("product_type_name is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameIsNotNull() {
            addCriterion("product_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameEqualTo(String value) {
            addCriterion("product_type_name =", value, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameNotEqualTo(String value) {
            addCriterion("product_type_name <>", value, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameGreaterThan(String value) {
            addCriterion("product_type_name >", value, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_type_name >=", value, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameLessThan(String value) {
            addCriterion("product_type_name <", value, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameLessThanOrEqualTo(String value) {
            addCriterion("product_type_name <=", value, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameLike(String value) {
            addCriterion("product_type_name like", value, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameNotLike(String value) {
            addCriterion("product_type_name not like", value, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameIn(List<String> values) {
            addCriterion("product_type_name in", values, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameNotIn(List<String> values) {
            addCriterion("product_type_name not in", values, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameBetween(String value1, String value2) {
            addCriterion("product_type_name between", value1, value2, "productTypeName");
            return (Criteria) this;
        }

        public Criteria andProductTypeNameNotBetween(String value1, String value2) {
            addCriterion("product_type_name not between", value1, value2, "productTypeName");
            return (Criteria) this;
        }
        
        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Long value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Long value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Long value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Long value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Long value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Long value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Long> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Long> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Long value1, Long value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Long value1, Long value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
            return (Criteria) this;
        }
        
        public Criteria andBrandNameIsNull() {
            addCriterion("brand_name is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNotNull() {
            addCriterion("brand_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEqualTo(String value) {
            addCriterion("brand_name =", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotEqualTo(String value) {
            addCriterion("brand_name <>", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThan(String value) {
            addCriterion("brand_name >", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_name >=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThan(String value) {
            addCriterion("brand_name <", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThanOrEqualTo(String value) {
            addCriterion("brand_name <=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLike(String value) {
            addCriterion("brand_name like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotLike(String value) {
            addCriterion("brand_name not like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIn(List<String> values) {
            addCriterion("brand_name in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotIn(List<String> values) {
            addCriterion("brand_name not in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameBetween(String value1, String value2) {
            addCriterion("brand_name between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotBetween(String value1, String value2) {
            addCriterion("brand_name not between", value1, value2, "brandName");
            return (Criteria) this;
        }
        
        public Criteria andProductRefundPriceIsNull() {
            addCriterion("product_refund_price is null");
            return (Criteria) this;
        }

        public Criteria andProductRefundPriceIsNotNull() {
            addCriterion("product_refund_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductRefundPriceEqualTo(BigDecimal value) {
            addCriterion("product_refund_price =", value, "productRefundPrice");
            return (Criteria) this;
        }

        public Criteria andProductRefundPriceNotEqualTo(BigDecimal value) {
            addCriterion("product_refund_price <>", value, "productRefundPrice");
            return (Criteria) this;
        }

        public Criteria andProductRefundPriceGreaterThan(BigDecimal value) {
            addCriterion("product_refund_price >", value, "productRefundPrice");
            return (Criteria) this;
        }

        public Criteria andProductRefundPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_refund_price >=", value, "productRefundPrice");
            return (Criteria) this;
        }

        public Criteria andProductRefundPriceLessThan(BigDecimal value) {
            addCriterion("product_refund_price <", value, "productRefundPrice");
            return (Criteria) this;
        }

        public Criteria andProductRefundPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_refund_price <=", value, "productRefundPrice");
            return (Criteria) this;
        }

        public Criteria andProductRefundPriceIn(List<BigDecimal> values) {
            addCriterion("product_refund_price in", values, "productRefundPrice");
            return (Criteria) this;
        }

        public Criteria andProductRefundPriceNotIn(List<BigDecimal> values) {
            addCriterion("product_refund_price not in", values, "productRefundPrice");
            return (Criteria) this;
        }

        public Criteria andProductRefundPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_refund_price between", value1, value2, "productRefundPrice");
            return (Criteria) this;
        }

        public Criteria andProductRefundPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_refund_price not between", value1, value2, "productRefundPrice");
            return (Criteria) this;
        }
        
        public Criteria andCouponFlagIsNull() {
            addCriterion("coupon_flag is null");
            return (Criteria) this;
        }

        public Criteria andCouponFlagIsNotNull() {
            addCriterion("coupon_flag is not null");
            return (Criteria) this;
        }

        public Criteria andCouponFlagEqualTo(Integer value) {
            addCriterion("coupon_flag =", value, "couponFlag");
            return (Criteria) this;
        }

        public Criteria andCouponFlagNotEqualTo(Integer value) {
            addCriterion("coupon_flag <>", value, "couponFlag");
            return (Criteria) this;
        }

        public Criteria andCouponFlagGreaterThan(Integer value) {
            addCriterion("coupon_flag >", value, "couponFlag");
            return (Criteria) this;
        }

        public Criteria andCouponFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_flag >=", value, "couponFlag");
            return (Criteria) this;
        }

        public Criteria andCouponFlagLessThan(Integer value) {
            addCriterion("coupon_flag <", value, "couponFlag");
            return (Criteria) this;
        }

        public Criteria andCouponFlagLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_flag <=", value, "couponFlag");
            return (Criteria) this;
        }

        public Criteria andCouponFlagIn(List<Integer> values) {
            addCriterion("coupon_flag in", values, "couponFlag");
            return (Criteria) this;
        }

        public Criteria andCouponFlagNotIn(List<Integer> values) {
            addCriterion("coupon_flag not in", values, "couponFlag");
            return (Criteria) this;
        }

        public Criteria andCouponFlagBetween(Integer value1, Integer value2) {
            addCriterion("coupon_flag between", value1, value2, "couponFlag");
            return (Criteria) this;
        }

        public Criteria andCouponFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_flag not between", value1, value2, "couponFlag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}