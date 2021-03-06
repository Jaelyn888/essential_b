package com.essential.bussiness.order.model.auto;

import java.util.ArrayList;
import java.util.List;

public class OrderStatusItemAutoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderStatusItemAutoExample() {
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

        public Criteria andOrderStatusItemNameIsNull() {
            addCriterion("order_status_item_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemNameIsNotNull() {
            addCriterion("order_status_item_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemNameEqualTo(String value) {
            addCriterion("order_status_item_name =", value, "orderStatusItemName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemNameNotEqualTo(String value) {
            addCriterion("order_status_item_name <>", value, "orderStatusItemName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemNameGreaterThan(String value) {
            addCriterion("order_status_item_name >", value, "orderStatusItemName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_status_item_name >=", value, "orderStatusItemName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemNameLessThan(String value) {
            addCriterion("order_status_item_name <", value, "orderStatusItemName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemNameLessThanOrEqualTo(String value) {
            addCriterion("order_status_item_name <=", value, "orderStatusItemName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemNameLike(String value) {
            addCriterion("order_status_item_name like", value, "orderStatusItemName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemNameNotLike(String value) {
            addCriterion("order_status_item_name not like", value, "orderStatusItemName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemNameIn(List<String> values) {
            addCriterion("order_status_item_name in", values, "orderStatusItemName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemNameNotIn(List<String> values) {
            addCriterion("order_status_item_name not in", values, "orderStatusItemName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemNameBetween(String value1, String value2) {
            addCriterion("order_status_item_name between", value1, value2, "orderStatusItemName");
            return (Criteria) this;
        }

        public Criteria andOrderStatusItemNameNotBetween(String value1, String value2) {
            addCriterion("order_status_item_name not between", value1, value2, "orderStatusItemName");
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