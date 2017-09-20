package com.essential.bussiness.order.model.auto;

import java.util.ArrayList;
import java.util.List;

public class OrderProductPromotionAutoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderProductPromotionAutoExample() {
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

        public Criteria andOrderPromotionIdIsNull() {
            addCriterion("order_promotion_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdIsNotNull() {
            addCriterion("order_promotion_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdEqualTo(Long value) {
            addCriterion("order_promotion_id =", value, "orderPromotionId");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdNotEqualTo(Long value) {
            addCriterion("order_promotion_id <>", value, "orderPromotionId");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdGreaterThan(Long value) {
            addCriterion("order_promotion_id >", value, "orderPromotionId");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_promotion_id >=", value, "orderPromotionId");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdLessThan(Long value) {
            addCriterion("order_promotion_id <", value, "orderPromotionId");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdLessThanOrEqualTo(Long value) {
            addCriterion("order_promotion_id <=", value, "orderPromotionId");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdIn(List<Long> values) {
            addCriterion("order_promotion_id in", values, "orderPromotionId");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdNotIn(List<Long> values) {
            addCriterion("order_promotion_id not in", values, "orderPromotionId");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdBetween(Long value1, Long value2) {
            addCriterion("order_promotion_id between", value1, value2, "orderPromotionId");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionIdNotBetween(Long value1, Long value2) {
            addCriterion("order_promotion_id not between", value1, value2, "orderPromotionId");
            return (Criteria) this;
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

        public Criteria andOrderPromotionNameIsNull() {
            addCriterion("order_promotion_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionNameIsNotNull() {
            addCriterion("order_promotion_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionNameEqualTo(String value) {
            addCriterion("order_promotion_name =", value, "orderPromotionName");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionNameNotEqualTo(String value) {
            addCriterion("order_promotion_name <>", value, "orderPromotionName");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionNameGreaterThan(String value) {
            addCriterion("order_promotion_name >", value, "orderPromotionName");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_promotion_name >=", value, "orderPromotionName");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionNameLessThan(String value) {
            addCriterion("order_promotion_name <", value, "orderPromotionName");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionNameLessThanOrEqualTo(String value) {
            addCriterion("order_promotion_name <=", value, "orderPromotionName");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionNameLike(String value) {
            addCriterion("order_promotion_name like", value, "orderPromotionName");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionNameNotLike(String value) {
            addCriterion("order_promotion_name not like", value, "orderPromotionName");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionNameIn(List<String> values) {
            addCriterion("order_promotion_name in", values, "orderPromotionName");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionNameNotIn(List<String> values) {
            addCriterion("order_promotion_name not in", values, "orderPromotionName");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionNameBetween(String value1, String value2) {
            addCriterion("order_promotion_name between", value1, value2, "orderPromotionName");
            return (Criteria) this;
        }

        public Criteria andOrderPromotionNameNotBetween(String value1, String value2) {
            addCriterion("order_promotion_name not between", value1, value2, "orderPromotionName");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyOrDiscountIsNull() {
            addCriterion("promotion_money_or_discount is null");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyOrDiscountIsNotNull() {
            addCriterion("promotion_money_or_discount is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyOrDiscountEqualTo(String value) {
            addCriterion("promotion_money_or_discount =", value, "promotionMoneyOrDiscount");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyOrDiscountNotEqualTo(String value) {
            addCriterion("promotion_money_or_discount <>", value, "promotionMoneyOrDiscount");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyOrDiscountGreaterThan(String value) {
            addCriterion("promotion_money_or_discount >", value, "promotionMoneyOrDiscount");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyOrDiscountGreaterThanOrEqualTo(String value) {
            addCriterion("promotion_money_or_discount >=", value, "promotionMoneyOrDiscount");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyOrDiscountLessThan(String value) {
            addCriterion("promotion_money_or_discount <", value, "promotionMoneyOrDiscount");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyOrDiscountLessThanOrEqualTo(String value) {
            addCriterion("promotion_money_or_discount <=", value, "promotionMoneyOrDiscount");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyOrDiscountLike(String value) {
            addCriterion("promotion_money_or_discount like", value, "promotionMoneyOrDiscount");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyOrDiscountNotLike(String value) {
            addCriterion("promotion_money_or_discount not like", value, "promotionMoneyOrDiscount");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyOrDiscountIn(List<String> values) {
            addCriterion("promotion_money_or_discount in", values, "promotionMoneyOrDiscount");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyOrDiscountNotIn(List<String> values) {
            addCriterion("promotion_money_or_discount not in", values, "promotionMoneyOrDiscount");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyOrDiscountBetween(String value1, String value2) {
            addCriterion("promotion_money_or_discount between", value1, value2, "promotionMoneyOrDiscount");
            return (Criteria) this;
        }

        public Criteria andPromotionMoneyOrDiscountNotBetween(String value1, String value2) {
            addCriterion("promotion_money_or_discount not between", value1, value2, "promotionMoneyOrDiscount");
            return (Criteria) this;
        }

        public Criteria andPromotionTypeIsNull() {
            addCriterion("promotion_type is null");
            return (Criteria) this;
        }

        public Criteria andPromotionTypeIsNotNull() {
            addCriterion("promotion_type is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionTypeEqualTo(Integer value) {
            addCriterion("promotion_type =", value, "promotionType");
            return (Criteria) this;
        }

        public Criteria andPromotionTypeNotEqualTo(Integer value) {
            addCriterion("promotion_type <>", value, "promotionType");
            return (Criteria) this;
        }

        public Criteria andPromotionTypeGreaterThan(Integer value) {
            addCriterion("promotion_type >", value, "promotionType");
            return (Criteria) this;
        }

        public Criteria andPromotionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("promotion_type >=", value, "promotionType");
            return (Criteria) this;
        }

        public Criteria andPromotionTypeLessThan(Integer value) {
            addCriterion("promotion_type <", value, "promotionType");
            return (Criteria) this;
        }

        public Criteria andPromotionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("promotion_type <=", value, "promotionType");
            return (Criteria) this;
        }

        public Criteria andPromotionTypeIn(List<Integer> values) {
            addCriterion("promotion_type in", values, "promotionType");
            return (Criteria) this;
        }

        public Criteria andPromotionTypeNotIn(List<Integer> values) {
            addCriterion("promotion_type not in", values, "promotionType");
            return (Criteria) this;
        }

        public Criteria andPromotionTypeBetween(Integer value1, Integer value2) {
            addCriterion("promotion_type between", value1, value2, "promotionType");
            return (Criteria) this;
        }

        public Criteria andPromotionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("promotion_type not between", value1, value2, "promotionType");
            return (Criteria) this;
        }

        public Criteria andPromotionIdIsNull() {
            addCriterion("promotion_id is null");
            return (Criteria) this;
        }

        public Criteria andPromotionIdIsNotNull() {
            addCriterion("promotion_id is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionIdEqualTo(Long value) {
            addCriterion("promotion_id =", value, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdNotEqualTo(Long value) {
            addCriterion("promotion_id <>", value, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdGreaterThan(Long value) {
            addCriterion("promotion_id >", value, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("promotion_id >=", value, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdLessThan(Long value) {
            addCriterion("promotion_id <", value, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdLessThanOrEqualTo(Long value) {
            addCriterion("promotion_id <=", value, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdIn(List<Long> values) {
            addCriterion("promotion_id in", values, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdNotIn(List<Long> values) {
            addCriterion("promotion_id not in", values, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdBetween(Long value1, Long value2) {
            addCriterion("promotion_id between", value1, value2, "promotionId");
            return (Criteria) this;
        }

        public Criteria andPromotionIdNotBetween(Long value1, Long value2) {
            addCriterion("promotion_id not between", value1, value2, "promotionId");
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