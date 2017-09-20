package com.essential.bussiness.order.model.auto;

import java.util.ArrayList;
import java.util.List;

public class OrderStatusAutoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderStatusAutoExample() {
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

        public Criteria andOrderStatusIdIsNull() {
            addCriterion("order_status_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIdIsNotNull() {
            addCriterion("order_status_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIdEqualTo(Long value) {
            addCriterion("order_status_id =", value, "orderStatusId");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIdNotEqualTo(Long value) {
            addCriterion("order_status_id <>", value, "orderStatusId");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIdGreaterThan(Long value) {
            addCriterion("order_status_id >", value, "orderStatusId");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_status_id >=", value, "orderStatusId");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIdLessThan(Long value) {
            addCriterion("order_status_id <", value, "orderStatusId");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIdLessThanOrEqualTo(Long value) {
            addCriterion("order_status_id <=", value, "orderStatusId");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIdIn(List<Long> values) {
            addCriterion("order_status_id in", values, "orderStatusId");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIdNotIn(List<Long> values) {
            addCriterion("order_status_id not in", values, "orderStatusId");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIdBetween(Long value1, Long value2) {
            addCriterion("order_status_id between", value1, value2, "orderStatusId");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIdNotBetween(Long value1, Long value2) {
            addCriterion("order_status_id not between", value1, value2, "orderStatusId");
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

        public Criteria andOrderStatusTimeIsNull() {
            addCriterion("order_status_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusTimeIsNotNull() {
            addCriterion("order_status_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusTimeEqualTo(String value) {
            addCriterion("order_status_time =", value, "orderStatusTime");
            return (Criteria) this;
        }

        public Criteria andOrderStatusTimeNotEqualTo(String value) {
            addCriterion("order_status_time <>", value, "orderStatusTime");
            return (Criteria) this;
        }

        public Criteria andOrderStatusTimeGreaterThan(String value) {
            addCriterion("order_status_time >", value, "orderStatusTime");
            return (Criteria) this;
        }

        public Criteria andOrderStatusTimeGreaterThanOrEqualTo(String value) {
            addCriterion("order_status_time >=", value, "orderStatusTime");
            return (Criteria) this;
        }

        public Criteria andOrderStatusTimeLessThan(String value) {
            addCriterion("order_status_time <", value, "orderStatusTime");
            return (Criteria) this;
        }

        public Criteria andOrderStatusTimeLessThanOrEqualTo(String value) {
            addCriterion("order_status_time <=", value, "orderStatusTime");
            return (Criteria) this;
        }

        public Criteria andOrderStatusTimeLike(String value) {
            addCriterion("order_status_time like", value, "orderStatusTime");
            return (Criteria) this;
        }

        public Criteria andOrderStatusTimeNotLike(String value) {
            addCriterion("order_status_time not like", value, "orderStatusTime");
            return (Criteria) this;
        }

        public Criteria andOrderStatusTimeIn(List<String> values) {
            addCriterion("order_status_time in", values, "orderStatusTime");
            return (Criteria) this;
        }

        public Criteria andOrderStatusTimeNotIn(List<String> values) {
            addCriterion("order_status_time not in", values, "orderStatusTime");
            return (Criteria) this;
        }

        public Criteria andOrderStatusTimeBetween(String value1, String value2) {
            addCriterion("order_status_time between", value1, value2, "orderStatusTime");
            return (Criteria) this;
        }

        public Criteria andOrderStatusTimeNotBetween(String value1, String value2) {
            addCriterion("order_status_time not between", value1, value2, "orderStatusTime");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(Integer value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(Integer value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(Integer value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(Integer value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(Integer value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<Integer> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<Integer> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(Integer value1, Integer value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(Integer value1, Integer value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemIdIsNull() {
            addCriterion("order_status_item_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemIdIsNotNull() {
            addCriterion("order_status_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemIdEqualTo(Integer value) {
            addCriterion("order_status_item_id =", value, "orderStatusItemId");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemIdNotEqualTo(Integer value) {
            addCriterion("order_status_item_id <>", value, "orderStatusItemId");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemIdGreaterThan(Integer value) {
            addCriterion("order_status_item_id >", value, "orderStatusItemId");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_status_item_id >=", value, "orderStatusItemId");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemIdLessThan(Integer value) {
            addCriterion("order_status_item_id <", value, "orderStatusItemId");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_status_item_id <=", value, "orderStatusItemId");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemIdIn(List<Integer> values) {
            addCriterion("order_status_item_id in", values, "orderStatusItemId");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemIdNotIn(List<Integer> values) {
            addCriterion("order_status_item_id not in", values, "orderStatusItemId");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemIdBetween(Integer value1, Integer value2) {
            addCriterion("order_status_item_id between", value1, value2, "orderStatusItemId");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_status_item_id not between", value1, value2, "orderStatusItemId");
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