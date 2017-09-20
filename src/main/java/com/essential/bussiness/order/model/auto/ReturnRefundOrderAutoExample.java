package com.essential.bussiness.order.model.auto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ReturnRefundOrderAutoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReturnRefundOrderAutoExample() {
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

        public Criteria andReturnRefundOrderIdIsNull() {
            addCriterion("return_refund_order_id is null");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderIdIsNotNull() {
            addCriterion("return_refund_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderIdEqualTo(Long value) {
            addCriterion("return_refund_order_id =", value, "returnRefundOrderId");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderIdNotEqualTo(Long value) {
            addCriterion("return_refund_order_id <>", value, "returnRefundOrderId");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderIdGreaterThan(Long value) {
            addCriterion("return_refund_order_id >", value, "returnRefundOrderId");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("return_refund_order_id >=", value, "returnRefundOrderId");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderIdLessThan(Long value) {
            addCriterion("return_refund_order_id <", value, "returnRefundOrderId");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("return_refund_order_id <=", value, "returnRefundOrderId");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderIdIn(List<Long> values) {
            addCriterion("return_refund_order_id in", values, "returnRefundOrderId");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderIdNotIn(List<Long> values) {
            addCriterion("return_refund_order_id not in", values, "returnRefundOrderId");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderIdBetween(Long value1, Long value2) {
            addCriterion("return_refund_order_id between", value1, value2, "returnRefundOrderId");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("return_refund_order_id not between", value1, value2, "returnRefundOrderId");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderNumberIsNull() {
            addCriterion("return_refund_order_number is null");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderNumberIsNotNull() {
            addCriterion("return_refund_order_number is not null");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderNumberEqualTo(String value) {
            addCriterion("return_refund_order_number =", value, "returnRefundOrderNumber");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderNumberNotEqualTo(String value) {
            addCriterion("return_refund_order_number <>", value, "returnRefundOrderNumber");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderNumberGreaterThan(String value) {
            addCriterion("return_refund_order_number >", value, "returnRefundOrderNumber");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("return_refund_order_number >=", value, "returnRefundOrderNumber");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderNumberLessThan(String value) {
            addCriterion("return_refund_order_number <", value, "returnRefundOrderNumber");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("return_refund_order_number <=", value, "returnRefundOrderNumber");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderNumberLike(String value) {
            addCriterion("return_refund_order_number like", value, "returnRefundOrderNumber");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderNumberNotLike(String value) {
            addCriterion("return_refund_order_number not like", value, "returnRefundOrderNumber");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderNumberIn(List<String> values) {
            addCriterion("return_refund_order_number in", values, "returnRefundOrderNumber");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderNumberNotIn(List<String> values) {
            addCriterion("return_refund_order_number not in", values, "returnRefundOrderNumber");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderNumberBetween(String value1, String value2) {
            addCriterion("return_refund_order_number between", value1, value2, "returnRefundOrderNumber");
            return (Criteria) this;
        }

        public Criteria andReturnRefundOrderNumberNotBetween(String value1, String value2) {
            addCriterion("return_refund_order_number not between", value1, value2, "returnRefundOrderNumber");
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

        public Criteria andReturnRefundLatestStatusIsNull() {
            addCriterion("return_refund_latest_status is null");
            return (Criteria) this;
        }

        public Criteria andReturnRefundLatestStatusIsNotNull() {
            addCriterion("return_refund_latest_status is not null");
            return (Criteria) this;
        }

        public Criteria andReturnRefundLatestStatusEqualTo(Integer value) {
            addCriterion("return_refund_latest_status =", value, "returnRefundLatestStatus");
            return (Criteria) this;
        }

        public Criteria andReturnRefundLatestStatusNotEqualTo(Integer value) {
            addCriterion("return_refund_latest_status <>", value, "returnRefundLatestStatus");
            return (Criteria) this;
        }

        public Criteria andReturnRefundLatestStatusGreaterThan(Integer value) {
            addCriterion("return_refund_latest_status >", value, "returnRefundLatestStatus");
            return (Criteria) this;
        }

        public Criteria andReturnRefundLatestStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_refund_latest_status >=", value, "returnRefundLatestStatus");
            return (Criteria) this;
        }

        public Criteria andReturnRefundLatestStatusLessThan(Integer value) {
            addCriterion("return_refund_latest_status <", value, "returnRefundLatestStatus");
            return (Criteria) this;
        }

        public Criteria andReturnRefundLatestStatusLessThanOrEqualTo(Integer value) {
            addCriterion("return_refund_latest_status <=", value, "returnRefundLatestStatus");
            return (Criteria) this;
        }

        public Criteria andReturnRefundLatestStatusIn(List<Integer> values) {
            addCriterion("return_refund_latest_status in", values, "returnRefundLatestStatus");
            return (Criteria) this;
        }

        public Criteria andReturnRefundLatestStatusNotIn(List<Integer> values) {
            addCriterion("return_refund_latest_status not in", values, "returnRefundLatestStatus");
            return (Criteria) this;
        }

        public Criteria andReturnRefundLatestStatusBetween(Integer value1, Integer value2) {
            addCriterion("return_refund_latest_status between", value1, value2, "returnRefundLatestStatus");
            return (Criteria) this;
        }

        public Criteria andReturnRefundLatestStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("return_refund_latest_status not between", value1, value2, "returnRefundLatestStatus");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andLogisticIsNull() {
            addCriterion("logistic is null");
            return (Criteria) this;
        }

        public Criteria andLogisticIsNotNull() {
            addCriterion("logistic is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticEqualTo(String value) {
            addCriterion("logistic =", value, "logistic");
            return (Criteria) this;
        }

        public Criteria andLogisticNotEqualTo(String value) {
            addCriterion("logistic <>", value, "logistic");
            return (Criteria) this;
        }

        public Criteria andLogisticGreaterThan(String value) {
            addCriterion("logistic >", value, "logistic");
            return (Criteria) this;
        }

        public Criteria andLogisticGreaterThanOrEqualTo(String value) {
            addCriterion("logistic >=", value, "logistic");
            return (Criteria) this;
        }

        public Criteria andLogisticLessThan(String value) {
            addCriterion("logistic <", value, "logistic");
            return (Criteria) this;
        }

        public Criteria andLogisticLessThanOrEqualTo(String value) {
            addCriterion("logistic <=", value, "logistic");
            return (Criteria) this;
        }

        public Criteria andLogisticLike(String value) {
            addCriterion("logistic like", value, "logistic");
            return (Criteria) this;
        }

        public Criteria andLogisticNotLike(String value) {
            addCriterion("logistic not like", value, "logistic");
            return (Criteria) this;
        }

        public Criteria andLogisticIn(List<String> values) {
            addCriterion("logistic in", values, "logistic");
            return (Criteria) this;
        }

        public Criteria andLogisticNotIn(List<String> values) {
            addCriterion("logistic not in", values, "logistic");
            return (Criteria) this;
        }

        public Criteria andLogisticBetween(String value1, String value2) {
            addCriterion("logistic between", value1, value2, "logistic");
            return (Criteria) this;
        }

        public Criteria andLogisticNotBetween(String value1, String value2) {
            addCriterion("logistic not between", value1, value2, "logistic");
            return (Criteria) this;
        }

        public Criteria andLogisticNumberIsNull() {
            addCriterion("logistic_number is null");
            return (Criteria) this;
        }

        public Criteria andLogisticNumberIsNotNull() {
            addCriterion("logistic_number is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticNumberEqualTo(String value) {
            addCriterion("logistic_number =", value, "logisticNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticNumberNotEqualTo(String value) {
            addCriterion("logistic_number <>", value, "logisticNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticNumberGreaterThan(String value) {
            addCriterion("logistic_number >", value, "logisticNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticNumberGreaterThanOrEqualTo(String value) {
            addCriterion("logistic_number >=", value, "logisticNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticNumberLessThan(String value) {
            addCriterion("logistic_number <", value, "logisticNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticNumberLessThanOrEqualTo(String value) {
            addCriterion("logistic_number <=", value, "logisticNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticNumberLike(String value) {
            addCriterion("logistic_number like", value, "logisticNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticNumberNotLike(String value) {
            addCriterion("logistic_number not like", value, "logisticNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticNumberIn(List<String> values) {
            addCriterion("logistic_number in", values, "logisticNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticNumberNotIn(List<String> values) {
            addCriterion("logistic_number not in", values, "logisticNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticNumberBetween(String value1, String value2) {
            addCriterion("logistic_number between", value1, value2, "logisticNumber");
            return (Criteria) this;
        }

        public Criteria andLogisticNumberNotBetween(String value1, String value2) {
            addCriterion("logistic_number not between", value1, value2, "logisticNumber");
            return (Criteria) this;
        }

        public Criteria andReturnPicIsNull() {
            addCriterion("return_pic is null");
            return (Criteria) this;
        }

        public Criteria andReturnPicIsNotNull() {
            addCriterion("return_pic is not null");
            return (Criteria) this;
        }

        public Criteria andReturnPicEqualTo(String value) {
            addCriterion("return_pic =", value, "returnPic");
            return (Criteria) this;
        }

        public Criteria andReturnPicNotEqualTo(String value) {
            addCriterion("return_pic <>", value, "returnPic");
            return (Criteria) this;
        }

        public Criteria andReturnPicGreaterThan(String value) {
            addCriterion("return_pic >", value, "returnPic");
            return (Criteria) this;
        }

        public Criteria andReturnPicGreaterThanOrEqualTo(String value) {
            addCriterion("return_pic >=", value, "returnPic");
            return (Criteria) this;
        }

        public Criteria andReturnPicLessThan(String value) {
            addCriterion("return_pic <", value, "returnPic");
            return (Criteria) this;
        }

        public Criteria andReturnPicLessThanOrEqualTo(String value) {
            addCriterion("return_pic <=", value, "returnPic");
            return (Criteria) this;
        }

        public Criteria andReturnPicLike(String value) {
            addCriterion("return_pic like", value, "returnPic");
            return (Criteria) this;
        }

        public Criteria andReturnPicNotLike(String value) {
            addCriterion("return_pic not like", value, "returnPic");
            return (Criteria) this;
        }

        public Criteria andReturnPicIn(List<String> values) {
            addCriterion("return_pic in", values, "returnPic");
            return (Criteria) this;
        }

        public Criteria andReturnPicNotIn(List<String> values) {
            addCriterion("return_pic not in", values, "returnPic");
            return (Criteria) this;
        }

        public Criteria andReturnPicBetween(String value1, String value2) {
            addCriterion("return_pic between", value1, value2, "returnPic");
            return (Criteria) this;
        }

        public Criteria andReturnPicNotBetween(String value1, String value2) {
            addCriterion("return_pic not between", value1, value2, "returnPic");
            return (Criteria) this;
        }

        public Criteria andReturnRefundReasonIsNull() {
            addCriterion("return_refund_reason is null");
            return (Criteria) this;
        }

        public Criteria andReturnRefundReasonIsNotNull() {
            addCriterion("return_refund_reason is not null");
            return (Criteria) this;
        }

        public Criteria andReturnRefundReasonEqualTo(String value) {
            addCriterion("return_refund_reason =", value, "returnRefundReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundReasonNotEqualTo(String value) {
            addCriterion("return_refund_reason <>", value, "returnRefundReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundReasonGreaterThan(String value) {
            addCriterion("return_refund_reason >", value, "returnRefundReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundReasonGreaterThanOrEqualTo(String value) {
            addCriterion("return_refund_reason >=", value, "returnRefundReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundReasonLessThan(String value) {
            addCriterion("return_refund_reason <", value, "returnRefundReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundReasonLessThanOrEqualTo(String value) {
            addCriterion("return_refund_reason <=", value, "returnRefundReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundReasonLike(String value) {
            addCriterion("return_refund_reason like", value, "returnRefundReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundReasonNotLike(String value) {
            addCriterion("return_refund_reason not like", value, "returnRefundReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundReasonIn(List<String> values) {
            addCriterion("return_refund_reason in", values, "returnRefundReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundReasonNotIn(List<String> values) {
            addCriterion("return_refund_reason not in", values, "returnRefundReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundReasonBetween(String value1, String value2) {
            addCriterion("return_refund_reason between", value1, value2, "returnRefundReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundReasonNotBetween(String value1, String value2) {
            addCriterion("return_refund_reason not between", value1, value2, "returnRefundReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundRejectReasonIsNull() {
            addCriterion("return_refund_reject_reason is null");
            return (Criteria) this;
        }

        public Criteria andReturnRefundRejectReasonIsNotNull() {
            addCriterion("return_refund_reject_reason is not null");
            return (Criteria) this;
        }

        public Criteria andReturnRefundRejectReasonEqualTo(String value) {
            addCriterion("return_refund_reject_reason =", value, "returnRefundRejectReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundRejectReasonNotEqualTo(String value) {
            addCriterion("return_refund_reject_reason <>", value, "returnRefundRejectReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundRejectReasonGreaterThan(String value) {
            addCriterion("return_refund_reject_reason >", value, "returnRefundRejectReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundRejectReasonGreaterThanOrEqualTo(String value) {
            addCriterion("return_refund_reject_reason >=", value, "returnRefundRejectReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundRejectReasonLessThan(String value) {
            addCriterion("return_refund_reject_reason <", value, "returnRefundRejectReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundRejectReasonLessThanOrEqualTo(String value) {
            addCriterion("return_refund_reject_reason <=", value, "returnRefundRejectReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundRejectReasonLike(String value) {
            addCriterion("return_refund_reject_reason like", value, "returnRefundRejectReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundRejectReasonNotLike(String value) {
            addCriterion("return_refund_reject_reason not like", value, "returnRefundRejectReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundRejectReasonIn(List<String> values) {
            addCriterion("return_refund_reject_reason in", values, "returnRefundRejectReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundRejectReasonNotIn(List<String> values) {
            addCriterion("return_refund_reject_reason not in", values, "returnRefundRejectReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundRejectReasonBetween(String value1, String value2) {
            addCriterion("return_refund_reject_reason between", value1, value2, "returnRefundRejectReason");
            return (Criteria) this;
        }

        public Criteria andReturnRefundRejectReasonNotBetween(String value1, String value2) {
            addCriterion("return_refund_reject_reason not between", value1, value2, "returnRefundRejectReason");
            return (Criteria) this;
        }

        public Criteria andReturnGoodsIsNull() {
            addCriterion("return_goods is null");
            return (Criteria) this;
        }

        public Criteria andReturnGoodsIsNotNull() {
            addCriterion("return_goods is not null");
            return (Criteria) this;
        }

        public Criteria andReturnGoodsEqualTo(String value) {
            addCriterion("return_goods =", value, "returnGoods");
            return (Criteria) this;
        }

        public Criteria andReturnGoodsNotEqualTo(String value) {
            addCriterion("return_goods <>", value, "returnGoods");
            return (Criteria) this;
        }

        public Criteria andReturnGoodsGreaterThan(String value) {
            addCriterion("return_goods >", value, "returnGoods");
            return (Criteria) this;
        }

        public Criteria andReturnGoodsGreaterThanOrEqualTo(String value) {
            addCriterion("return_goods >=", value, "returnGoods");
            return (Criteria) this;
        }

        public Criteria andReturnGoodsLessThan(String value) {
            addCriterion("return_goods <", value, "returnGoods");
            return (Criteria) this;
        }

        public Criteria andReturnGoodsLessThanOrEqualTo(String value) {
            addCriterion("return_goods <=", value, "returnGoods");
            return (Criteria) this;
        }

        public Criteria andReturnGoodsLike(String value) {
            addCriterion("return_goods like", value, "returnGoods");
            return (Criteria) this;
        }

        public Criteria andReturnGoodsNotLike(String value) {
            addCriterion("return_goods not like", value, "returnGoods");
            return (Criteria) this;
        }

        public Criteria andReturnGoodsIn(List<String> values) {
            addCriterion("return_goods in", values, "returnGoods");
            return (Criteria) this;
        }

        public Criteria andReturnGoodsNotIn(List<String> values) {
            addCriterion("return_goods not in", values, "returnGoods");
            return (Criteria) this;
        }

        public Criteria andReturnGoodsBetween(String value1, String value2) {
            addCriterion("return_goods between", value1, value2, "returnGoods");
            return (Criteria) this;
        }

        public Criteria andReturnGoodsNotBetween(String value1, String value2) {
            addCriterion("return_goods not between", value1, value2, "returnGoods");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(String value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(String value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(String value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(String value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(String value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(String value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLike(String value) {
            addCriterion("modify_time like", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotLike(String value) {
            addCriterion("modify_time not like", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<String> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<String> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(String value1, String value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(String value1, String value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(Long value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(Long value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(Long value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(Long value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(Long value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<Long> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<Long> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(Long value1, Long value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(Long value1, Long value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andMofifyUserIsNull() {
            addCriterion("mofify_user is null");
            return (Criteria) this;
        }

        public Criteria andMofifyUserIsNotNull() {
            addCriterion("mofify_user is not null");
            return (Criteria) this;
        }

        public Criteria andMofifyUserEqualTo(Long value) {
            addCriterion("mofify_user =", value, "mofifyUser");
            return (Criteria) this;
        }

        public Criteria andMofifyUserNotEqualTo(Long value) {
            addCriterion("mofify_user <>", value, "mofifyUser");
            return (Criteria) this;
        }

        public Criteria andMofifyUserGreaterThan(Long value) {
            addCriterion("mofify_user >", value, "mofifyUser");
            return (Criteria) this;
        }

        public Criteria andMofifyUserGreaterThanOrEqualTo(Long value) {
            addCriterion("mofify_user >=", value, "mofifyUser");
            return (Criteria) this;
        }

        public Criteria andMofifyUserLessThan(Long value) {
            addCriterion("mofify_user <", value, "mofifyUser");
            return (Criteria) this;
        }

        public Criteria andMofifyUserLessThanOrEqualTo(Long value) {
            addCriterion("mofify_user <=", value, "mofifyUser");
            return (Criteria) this;
        }

        public Criteria andMofifyUserIn(List<Long> values) {
            addCriterion("mofify_user in", values, "mofifyUser");
            return (Criteria) this;
        }

        public Criteria andMofifyUserNotIn(List<Long> values) {
            addCriterion("mofify_user not in", values, "mofifyUser");
            return (Criteria) this;
        }

        public Criteria andMofifyUserBetween(Long value1, Long value2) {
            addCriterion("mofify_user between", value1, value2, "mofifyUser");
            return (Criteria) this;
        }

        public Criteria andMofifyUserNotBetween(Long value1, Long value2) {
            addCriterion("mofify_user not between", value1, value2, "mofifyUser");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andDesiredResultIsNull() {
            addCriterion("desired_result is null");
            return (Criteria) this;
        }

        public Criteria andDesiredResultIsNotNull() {
            addCriterion("desired_result is not null");
            return (Criteria) this;
        }

        public Criteria andDesiredResultEqualTo(String value) {
            addCriterion("desired_result =", value, "desiredResult");
            return (Criteria) this;
        }

        public Criteria andDesiredResultNotEqualTo(String value) {
            addCriterion("desired_result <>", value, "desiredResult");
            return (Criteria) this;
        }

        public Criteria andDesiredResultGreaterThan(String value) {
            addCriterion("desired_result >", value, "desiredResult");
            return (Criteria) this;
        }

        public Criteria andDesiredResultGreaterThanOrEqualTo(String value) {
            addCriterion("desired_result >=", value, "desiredResult");
            return (Criteria) this;
        }

        public Criteria andDesiredResultLessThan(String value) {
            addCriterion("desired_result <", value, "desiredResult");
            return (Criteria) this;
        }

        public Criteria andDesiredResultLessThanOrEqualTo(String value) {
            addCriterion("desired_result <=", value, "desiredResult");
            return (Criteria) this;
        }

        public Criteria andDesiredResultLike(String value) {
            addCriterion("desired_result like", value, "desiredResult");
            return (Criteria) this;
        }

        public Criteria andDesiredResultNotLike(String value) {
            addCriterion("desired_result not like", value, "desiredResult");
            return (Criteria) this;
        }

        public Criteria andDesiredResultIn(List<String> values) {
            addCriterion("desired_result in", values, "desiredResult");
            return (Criteria) this;
        }

        public Criteria andDesiredResultNotIn(List<String> values) {
            addCriterion("desired_result not in", values, "desiredResult");
            return (Criteria) this;
        }

        public Criteria andDesiredResultBetween(String value1, String value2) {
            addCriterion("desired_result between", value1, value2, "desiredResult");
            return (Criteria) this;
        }

        public Criteria andDesiredResultNotBetween(String value1, String value2) {
            addCriterion("desired_result not between", value1, value2, "desiredResult");
            return (Criteria) this;
        }

        public Criteria andRefundInstructionsIsNull() {
            addCriterion("refund_instructions is null");
            return (Criteria) this;
        }

        public Criteria andRefundInstructionsIsNotNull() {
            addCriterion("refund_instructions is not null");
            return (Criteria) this;
        }

        public Criteria andRefundInstructionsEqualTo(String value) {
            addCriterion("refund_instructions =", value, "refundInstructions");
            return (Criteria) this;
        }

        public Criteria andRefundInstructionsNotEqualTo(String value) {
            addCriterion("refund_instructions <>", value, "refundInstructions");
            return (Criteria) this;
        }

        public Criteria andRefundInstructionsGreaterThan(String value) {
            addCriterion("refund_instructions >", value, "refundInstructions");
            return (Criteria) this;
        }

        public Criteria andRefundInstructionsGreaterThanOrEqualTo(String value) {
            addCriterion("refund_instructions >=", value, "refundInstructions");
            return (Criteria) this;
        }

        public Criteria andRefundInstructionsLessThan(String value) {
            addCriterion("refund_instructions <", value, "refundInstructions");
            return (Criteria) this;
        }

        public Criteria andRefundInstructionsLessThanOrEqualTo(String value) {
            addCriterion("refund_instructions <=", value, "refundInstructions");
            return (Criteria) this;
        }

        public Criteria andRefundInstructionsLike(String value) {
            addCriterion("refund_instructions like", value, "refundInstructions");
            return (Criteria) this;
        }

        public Criteria andRefundInstructionsNotLike(String value) {
            addCriterion("refund_instructions not like", value, "refundInstructions");
            return (Criteria) this;
        }

        public Criteria andRefundInstructionsIn(List<String> values) {
            addCriterion("refund_instructions in", values, "refundInstructions");
            return (Criteria) this;
        }

        public Criteria andRefundInstructionsNotIn(List<String> values) {
            addCriterion("refund_instructions not in", values, "refundInstructions");
            return (Criteria) this;
        }

        public Criteria andRefundInstructionsBetween(String value1, String value2) {
            addCriterion("refund_instructions between", value1, value2, "refundInstructions");
            return (Criteria) this;
        }

        public Criteria andRefundInstructionsNotBetween(String value1, String value2) {
            addCriterion("refund_instructions not between", value1, value2, "refundInstructions");
            return (Criteria) this;
        }

        public Criteria andPicIdentityIsNull() {
            addCriterion("pic_identity is null");
            return (Criteria) this;
        }

        public Criteria andPicIdentityIsNotNull() {
            addCriterion("pic_identity is not null");
            return (Criteria) this;
        }

        public Criteria andPicIdentityEqualTo(Integer value) {
            addCriterion("pic_identity =", value, "picIdentity");
            return (Criteria) this;
        }

        public Criteria andPicIdentityNotEqualTo(Integer value) {
            addCriterion("pic_identity <>", value, "picIdentity");
            return (Criteria) this;
        }

        public Criteria andPicIdentityGreaterThan(Integer value) {
            addCriterion("pic_identity >", value, "picIdentity");
            return (Criteria) this;
        }

        public Criteria andPicIdentityGreaterThanOrEqualTo(Integer value) {
            addCriterion("pic_identity >=", value, "picIdentity");
            return (Criteria) this;
        }

        public Criteria andPicIdentityLessThan(Integer value) {
            addCriterion("pic_identity <", value, "picIdentity");
            return (Criteria) this;
        }

        public Criteria andPicIdentityLessThanOrEqualTo(Integer value) {
            addCriterion("pic_identity <=", value, "picIdentity");
            return (Criteria) this;
        }

        public Criteria andPicIdentityIn(List<Integer> values) {
            addCriterion("pic_identity in", values, "picIdentity");
            return (Criteria) this;
        }

        public Criteria andPicIdentityNotIn(List<Integer> values) {
            addCriterion("pic_identity not in", values, "picIdentity");
            return (Criteria) this;
        }

        public Criteria andPicIdentityBetween(Integer value1, Integer value2) {
            addCriterion("pic_identity between", value1, value2, "picIdentity");
            return (Criteria) this;
        }

        public Criteria andPicIdentityNotBetween(Integer value1, Integer value2) {
            addCriterion("pic_identity not between", value1, value2, "picIdentity");
            return (Criteria) this;
        }

        public Criteria andRefundSerialNumberIsNull() {
            addCriterion("refund_serial_number is null");
            return (Criteria) this;
        }

        public Criteria andRefundSerialNumberIsNotNull() {
            addCriterion("refund_serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andRefundSerialNumberEqualTo(String value) {
            addCriterion("refund_serial_number =", value, "refundSerialNumber");
            return (Criteria) this;
        }

        public Criteria andRefundSerialNumberNotEqualTo(String value) {
            addCriterion("refund_serial_number <>", value, "refundSerialNumber");
            return (Criteria) this;
        }

        public Criteria andRefundSerialNumberGreaterThan(String value) {
            addCriterion("refund_serial_number >", value, "refundSerialNumber");
            return (Criteria) this;
        }

        public Criteria andRefundSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("refund_serial_number >=", value, "refundSerialNumber");
            return (Criteria) this;
        }

        public Criteria andRefundSerialNumberLessThan(String value) {
            addCriterion("refund_serial_number <", value, "refundSerialNumber");
            return (Criteria) this;
        }

        public Criteria andRefundSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("refund_serial_number <=", value, "refundSerialNumber");
            return (Criteria) this;
        }

        public Criteria andRefundSerialNumberLike(String value) {
            addCriterion("refund_serial_number like", value, "refundSerialNumber");
            return (Criteria) this;
        }

        public Criteria andRefundSerialNumberNotLike(String value) {
            addCriterion("refund_serial_number not like", value, "refundSerialNumber");
            return (Criteria) this;
        }

        public Criteria andRefundSerialNumberIn(List<String> values) {
            addCriterion("refund_serial_number in", values, "refundSerialNumber");
            return (Criteria) this;
        }

        public Criteria andRefundSerialNumberNotIn(List<String> values) {
            addCriterion("refund_serial_number not in", values, "refundSerialNumber");
            return (Criteria) this;
        }

        public Criteria andRefundSerialNumberBetween(String value1, String value2) {
            addCriterion("refund_serial_number between", value1, value2, "refundSerialNumber");
            return (Criteria) this;
        }

        public Criteria andRefundSerialNumberNotBetween(String value1, String value2) {
            addCriterion("refund_serial_number not between", value1, value2, "refundSerialNumber");
            return (Criteria) this;
        }

        public Criteria andRefundAccountIsNull() {
            addCriterion("refund_account is null");
            return (Criteria) this;
        }

        public Criteria andRefundAccountIsNotNull() {
            addCriterion("refund_account is not null");
            return (Criteria) this;
        }

        public Criteria andRefundAccountEqualTo(String value) {
            addCriterion("refund_account =", value, "refundAccount");
            return (Criteria) this;
        }

        public Criteria andRefundAccountNotEqualTo(String value) {
            addCriterion("refund_account <>", value, "refundAccount");
            return (Criteria) this;
        }

        public Criteria andRefundAccountGreaterThan(String value) {
            addCriterion("refund_account >", value, "refundAccount");
            return (Criteria) this;
        }

        public Criteria andRefundAccountGreaterThanOrEqualTo(String value) {
            addCriterion("refund_account >=", value, "refundAccount");
            return (Criteria) this;
        }

        public Criteria andRefundAccountLessThan(String value) {
            addCriterion("refund_account <", value, "refundAccount");
            return (Criteria) this;
        }

        public Criteria andRefundAccountLessThanOrEqualTo(String value) {
            addCriterion("refund_account <=", value, "refundAccount");
            return (Criteria) this;
        }

        public Criteria andRefundAccountLike(String value) {
            addCriterion("refund_account like", value, "refundAccount");
            return (Criteria) this;
        }

        public Criteria andRefundAccountNotLike(String value) {
            addCriterion("refund_account not like", value, "refundAccount");
            return (Criteria) this;
        }

        public Criteria andRefundAccountIn(List<String> values) {
            addCriterion("refund_account in", values, "refundAccount");
            return (Criteria) this;
        }

        public Criteria andRefundAccountNotIn(List<String> values) {
            addCriterion("refund_account not in", values, "refundAccount");
            return (Criteria) this;
        }

        public Criteria andRefundAccountBetween(String value1, String value2) {
            addCriterion("refund_account between", value1, value2, "refundAccount");
            return (Criteria) this;
        }

        public Criteria andRefundAccountNotBetween(String value1, String value2) {
            addCriterion("refund_account not between", value1, value2, "refundAccount");
            return (Criteria) this;
        }

        public Criteria andRefundBankIsNull() {
            addCriterion("refund_bank is null");
            return (Criteria) this;
        }

        public Criteria andRefundBankIsNotNull() {
            addCriterion("refund_bank is not null");
            return (Criteria) this;
        }

        public Criteria andRefundBankEqualTo(String value) {
            addCriterion("refund_bank =", value, "refundBank");
            return (Criteria) this;
        }

        public Criteria andRefundBankNotEqualTo(String value) {
            addCriterion("refund_bank <>", value, "refundBank");
            return (Criteria) this;
        }

        public Criteria andRefundBankGreaterThan(String value) {
            addCriterion("refund_bank >", value, "refundBank");
            return (Criteria) this;
        }

        public Criteria andRefundBankGreaterThanOrEqualTo(String value) {
            addCriterion("refund_bank >=", value, "refundBank");
            return (Criteria) this;
        }

        public Criteria andRefundBankLessThan(String value) {
            addCriterion("refund_bank <", value, "refundBank");
            return (Criteria) this;
        }

        public Criteria andRefundBankLessThanOrEqualTo(String value) {
            addCriterion("refund_bank <=", value, "refundBank");
            return (Criteria) this;
        }

        public Criteria andRefundBankLike(String value) {
            addCriterion("refund_bank like", value, "refundBank");
            return (Criteria) this;
        }

        public Criteria andRefundBankNotLike(String value) {
            addCriterion("refund_bank not like", value, "refundBank");
            return (Criteria) this;
        }

        public Criteria andRefundBankIn(List<String> values) {
            addCriterion("refund_bank in", values, "refundBank");
            return (Criteria) this;
        }

        public Criteria andRefundBankNotIn(List<String> values) {
            addCriterion("refund_bank not in", values, "refundBank");
            return (Criteria) this;
        }

        public Criteria andRefundBankBetween(String value1, String value2) {
            addCriterion("refund_bank between", value1, value2, "refundBank");
            return (Criteria) this;
        }

        public Criteria andRefundBankNotBetween(String value1, String value2) {
            addCriterion("refund_bank not between", value1, value2, "refundBank");
            return (Criteria) this;
        }

        public Criteria andRefundUserIsNull() {
            addCriterion("refund_user is null");
            return (Criteria) this;
        }

        public Criteria andRefundUserIsNotNull() {
            addCriterion("refund_user is not null");
            return (Criteria) this;
        }

        public Criteria andRefundUserEqualTo(String value) {
            addCriterion("refund_user =", value, "refundUser");
            return (Criteria) this;
        }

        public Criteria andRefundUserNotEqualTo(String value) {
            addCriterion("refund_user <>", value, "refundUser");
            return (Criteria) this;
        }

        public Criteria andRefundUserGreaterThan(String value) {
            addCriterion("refund_user >", value, "refundUser");
            return (Criteria) this;
        }

        public Criteria andRefundUserGreaterThanOrEqualTo(String value) {
            addCriterion("refund_user >=", value, "refundUser");
            return (Criteria) this;
        }

        public Criteria andRefundUserLessThan(String value) {
            addCriterion("refund_user <", value, "refundUser");
            return (Criteria) this;
        }

        public Criteria andRefundUserLessThanOrEqualTo(String value) {
            addCriterion("refund_user <=", value, "refundUser");
            return (Criteria) this;
        }

        public Criteria andRefundUserLike(String value) {
            addCriterion("refund_user like", value, "refundUser");
            return (Criteria) this;
        }

        public Criteria andRefundUserNotLike(String value) {
            addCriterion("refund_user not like", value, "refundUser");
            return (Criteria) this;
        }

        public Criteria andRefundUserIn(List<String> values) {
            addCriterion("refund_user in", values, "refundUser");
            return (Criteria) this;
        }

        public Criteria andRefundUserNotIn(List<String> values) {
            addCriterion("refund_user not in", values, "refundUser");
            return (Criteria) this;
        }

        public Criteria andRefundUserBetween(String value1, String value2) {
            addCriterion("refund_user between", value1, value2, "refundUser");
            return (Criteria) this;
        }

        public Criteria andRefundUserNotBetween(String value1, String value2) {
            addCriterion("refund_user not between", value1, value2, "refundUser");
            return (Criteria) this;
        }

        public Criteria andRefundTotalMoneyIsNull() {
            addCriterion("refund_total_money is null");
            return (Criteria) this;
        }

        public Criteria andRefundTotalMoneyIsNotNull() {
            addCriterion("refund_total_money is not null");
            return (Criteria) this;
        }

        public Criteria andRefundTotalMoneyEqualTo(BigDecimal value) {
            addCriterion("refund_total_money =", value, "refundTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRefundTotalMoneyNotEqualTo(BigDecimal value) {
            addCriterion("refund_total_money <>", value, "refundTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRefundTotalMoneyGreaterThan(BigDecimal value) {
            addCriterion("refund_total_money >", value, "refundTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRefundTotalMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_total_money >=", value, "refundTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRefundTotalMoneyLessThan(BigDecimal value) {
            addCriterion("refund_total_money <", value, "refundTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRefundTotalMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_total_money <=", value, "refundTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRefundTotalMoneyIn(List<BigDecimal> values) {
            addCriterion("refund_total_money in", values, "refundTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRefundTotalMoneyNotIn(List<BigDecimal> values) {
            addCriterion("refund_total_money not in", values, "refundTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRefundTotalMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_total_money between", value1, value2, "refundTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRefundTotalMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_total_money not between", value1, value2, "refundTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRefundFinalMoneyIsNull() {
            addCriterion("refund_final_money is null");
            return (Criteria) this;
        }

        public Criteria andRefundFinalMoneyIsNotNull() {
            addCriterion("refund_final_money is not null");
            return (Criteria) this;
        }

        public Criteria andRefundFinalMoneyEqualTo(BigDecimal value) {
            addCriterion("refund_final_money =", value, "refundFinalMoney");
            return (Criteria) this;
        }

        public Criteria andRefundFinalMoneyNotEqualTo(BigDecimal value) {
            addCriterion("refund_final_money <>", value, "refundFinalMoney");
            return (Criteria) this;
        }

        public Criteria andRefundFinalMoneyGreaterThan(BigDecimal value) {
            addCriterion("refund_final_money >", value, "refundFinalMoney");
            return (Criteria) this;
        }

        public Criteria andRefundFinalMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_final_money >=", value, "refundFinalMoney");
            return (Criteria) this;
        }

        public Criteria andRefundFinalMoneyLessThan(BigDecimal value) {
            addCriterion("refund_final_money <", value, "refundFinalMoney");
            return (Criteria) this;
        }

        public Criteria andRefundFinalMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_final_money <=", value, "refundFinalMoney");
            return (Criteria) this;
        }

        public Criteria andRefundFinalMoneyIn(List<BigDecimal> values) {
            addCriterion("refund_final_money in", values, "refundFinalMoney");
            return (Criteria) this;
        }

        public Criteria andRefundFinalMoneyNotIn(List<BigDecimal> values) {
            addCriterion("refund_final_money not in", values, "refundFinalMoney");
            return (Criteria) this;
        }

        public Criteria andRefundFinalMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_final_money between", value1, value2, "refundFinalMoney");
            return (Criteria) this;
        }

        public Criteria andRefundFinalMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_final_money not between", value1, value2, "refundFinalMoney");
            return (Criteria) this;
        }

        public Criteria andReturnOrderProductCountIsNull() {
            addCriterion("return_order_product_count is null");
            return (Criteria) this;
        }

        public Criteria andReturnOrderProductCountIsNotNull() {
            addCriterion("return_order_product_count is not null");
            return (Criteria) this;
        }

        public Criteria andReturnOrderProductCountEqualTo(Integer value) {
            addCriterion("return_order_product_count =", value, "returnOrderProductCount");
            return (Criteria) this;
        }

        public Criteria andReturnOrderProductCountNotEqualTo(Integer value) {
            addCriterion("return_order_product_count <>", value, "returnOrderProductCount");
            return (Criteria) this;
        }

        public Criteria andReturnOrderProductCountGreaterThan(Integer value) {
            addCriterion("return_order_product_count >", value, "returnOrderProductCount");
            return (Criteria) this;
        }

        public Criteria andReturnOrderProductCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_order_product_count >=", value, "returnOrderProductCount");
            return (Criteria) this;
        }

        public Criteria andReturnOrderProductCountLessThan(Integer value) {
            addCriterion("return_order_product_count <", value, "returnOrderProductCount");
            return (Criteria) this;
        }

        public Criteria andReturnOrderProductCountLessThanOrEqualTo(Integer value) {
            addCriterion("return_order_product_count <=", value, "returnOrderProductCount");
            return (Criteria) this;
        }

        public Criteria andReturnOrderProductCountIn(List<Integer> values) {
            addCriterion("return_order_product_count in", values, "returnOrderProductCount");
            return (Criteria) this;
        }

        public Criteria andReturnOrderProductCountNotIn(List<Integer> values) {
            addCriterion("return_order_product_count not in", values, "returnOrderProductCount");
            return (Criteria) this;
        }

        public Criteria andReturnOrderProductCountBetween(Integer value1, Integer value2) {
            addCriterion("return_order_product_count between", value1, value2, "returnOrderProductCount");
            return (Criteria) this;
        }

        public Criteria andReturnOrderProductCountNotBetween(Integer value1, Integer value2) {
            addCriterion("return_order_product_count not between", value1, value2, "returnOrderProductCount");
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

        public Criteria andReturnRefundTypeIsNull() {
            addCriterion("return_refund_type is null");
            return (Criteria) this;
        }

        public Criteria andReturnRefundTypeIsNotNull() {
            addCriterion("return_refund_type is not null");
            return (Criteria) this;
        }

        public Criteria andReturnRefundTypeEqualTo(Integer value) {
            addCriterion("return_refund_type =", value, "returnRefundType");
            return (Criteria) this;
        }

        public Criteria andReturnRefundTypeNotEqualTo(Integer value) {
            addCriterion("return_refund_type <>", value, "returnRefundType");
            return (Criteria) this;
        }

        public Criteria andReturnRefundTypeGreaterThan(Integer value) {
            addCriterion("return_refund_type >", value, "returnRefundType");
            return (Criteria) this;
        }

        public Criteria andReturnRefundTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_refund_type >=", value, "returnRefundType");
            return (Criteria) this;
        }

        public Criteria andReturnRefundTypeLessThan(Integer value) {
            addCriterion("return_refund_type <", value, "returnRefundType");
            return (Criteria) this;
        }

        public Criteria andReturnRefundTypeLessThanOrEqualTo(Integer value) {
            addCriterion("return_refund_type <=", value, "returnRefundType");
            return (Criteria) this;
        }

        public Criteria andReturnRefundTypeIn(List<Integer> values) {
            addCriterion("return_refund_type in", values, "returnRefundType");
            return (Criteria) this;
        }

        public Criteria andReturnRefundTypeNotIn(List<Integer> values) {
            addCriterion("return_refund_type not in", values, "returnRefundType");
            return (Criteria) this;
        }

        public Criteria andReturnRefundTypeBetween(Integer value1, Integer value2) {
            addCriterion("return_refund_type between", value1, value2, "returnRefundType");
            return (Criteria) this;
        }

        public Criteria andReturnRefundTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("return_refund_type not between", value1, value2, "returnRefundType");
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

        public Criteria andAttr5IsNull() {
            addCriterion("attr5 is null");
            return (Criteria) this;
        }

        public Criteria andAttr5IsNotNull() {
            addCriterion("attr5 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr5EqualTo(String value) {
            addCriterion("attr5 =", value, "attr5");
            return (Criteria) this;
        }

        public Criteria andAttr5NotEqualTo(String value) {
            addCriterion("attr5 <>", value, "attr5");
            return (Criteria) this;
        }

        public Criteria andAttr5GreaterThan(String value) {
            addCriterion("attr5 >", value, "attr5");
            return (Criteria) this;
        }

        public Criteria andAttr5GreaterThanOrEqualTo(String value) {
            addCriterion("attr5 >=", value, "attr5");
            return (Criteria) this;
        }

        public Criteria andAttr5LessThan(String value) {
            addCriterion("attr5 <", value, "attr5");
            return (Criteria) this;
        }

        public Criteria andAttr5LessThanOrEqualTo(String value) {
            addCriterion("attr5 <=", value, "attr5");
            return (Criteria) this;
        }

        public Criteria andAttr5Like(String value) {
            addCriterion("attr5 like", value, "attr5");
            return (Criteria) this;
        }

        public Criteria andAttr5NotLike(String value) {
            addCriterion("attr5 not like", value, "attr5");
            return (Criteria) this;
        }

        public Criteria andAttr5In(List<String> values) {
            addCriterion("attr5 in", values, "attr5");
            return (Criteria) this;
        }

        public Criteria andAttr5NotIn(List<String> values) {
            addCriterion("attr5 not in", values, "attr5");
            return (Criteria) this;
        }

        public Criteria andAttr5Between(String value1, String value2) {
            addCriterion("attr5 between", value1, value2, "attr5");
            return (Criteria) this;
        }

        public Criteria andAttr5NotBetween(String value1, String value2) {
            addCriterion("attr5 not between", value1, value2, "attr5");
            return (Criteria) this;
        }

        public Criteria andAttr6IsNull() {
            addCriterion("attr6 is null");
            return (Criteria) this;
        }

        public Criteria andAttr6IsNotNull() {
            addCriterion("attr6 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr6EqualTo(String value) {
            addCriterion("attr6 =", value, "attr6");
            return (Criteria) this;
        }

        public Criteria andAttr6NotEqualTo(String value) {
            addCriterion("attr6 <>", value, "attr6");
            return (Criteria) this;
        }

        public Criteria andAttr6GreaterThan(String value) {
            addCriterion("attr6 >", value, "attr6");
            return (Criteria) this;
        }

        public Criteria andAttr6GreaterThanOrEqualTo(String value) {
            addCriterion("attr6 >=", value, "attr6");
            return (Criteria) this;
        }

        public Criteria andAttr6LessThan(String value) {
            addCriterion("attr6 <", value, "attr6");
            return (Criteria) this;
        }

        public Criteria andAttr6LessThanOrEqualTo(String value) {
            addCriterion("attr6 <=", value, "attr6");
            return (Criteria) this;
        }

        public Criteria andAttr6Like(String value) {
            addCriterion("attr6 like", value, "attr6");
            return (Criteria) this;
        }

        public Criteria andAttr6NotLike(String value) {
            addCriterion("attr6 not like", value, "attr6");
            return (Criteria) this;
        }

        public Criteria andAttr6In(List<String> values) {
            addCriterion("attr6 in", values, "attr6");
            return (Criteria) this;
        }

        public Criteria andAttr6NotIn(List<String> values) {
            addCriterion("attr6 not in", values, "attr6");
            return (Criteria) this;
        }

        public Criteria andAttr6Between(String value1, String value2) {
            addCriterion("attr6 between", value1, value2, "attr6");
            return (Criteria) this;
        }

        public Criteria andAttr6NotBetween(String value1, String value2) {
            addCriterion("attr6 not between", value1, value2, "attr6");
            return (Criteria) this;
        }
        
        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Long value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Long value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Long value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Long value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Long value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Long> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Long> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Long value1, Long value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Long value1, Long value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }
        
        


        
        
        
        
        
        
        
        public Criteria andReturnAddressIsNull() {
            addCriterion("return_address is null");
            return (Criteria) this;
        }

        public Criteria andReturnAddressIsNotNull() {
            addCriterion("return_address is not null");
            return (Criteria) this;
        }

        public Criteria andReturnAddressEqualTo(String value) {
            addCriterion("return_address =", value, "returnAddress");
            return (Criteria) this;
        }

        public Criteria andReturnAddressNotEqualTo(String value) {
            addCriterion("return_address <>", value, "returnAddress");
            return (Criteria) this;
        }

        public Criteria andReturnAddressGreaterThan(String value) {
            addCriterion("return_address >", value, "returnAddress");
            return (Criteria) this;
        }

        public Criteria andReturnAddressGreaterThanOrEqualTo(String value) {
            addCriterion("return_address >=", value, "returnAddress");
            return (Criteria) this;
        }

        public Criteria andReturnAddressLessThan(String value) {
            addCriterion("return_address <", value, "returnAddress");
            return (Criteria) this;
        }

        public Criteria andReturnAddressLessThanOrEqualTo(String value) {
            addCriterion("return_address <=", value, "returnAddress");
            return (Criteria) this;
        }

        public Criteria andReturnAddressIn(List<String> values) {
            addCriterion("return_address in", values, "returnAddress");
            return (Criteria) this;
        }

        public Criteria andReturnAddressNotIn(List<String> values) {
            addCriterion("return_address not in", values, "returnAddress");
            return (Criteria) this;
        }

        public Criteria andReturnAddressBetween(String value1, String value2) {
            addCriterion("return_address between", value1, value2, "returnAddress");
            return (Criteria) this;
        }

        public Criteria andReturnAddressNotBetween(String value1, String value2) {
            addCriterion("return_address not between", value1, value2, "returnAddress");
            return (Criteria) this;
        }
        
        public Criteria andContactPersonIsNull() {
            addCriterion("contact_person is null");
            return (Criteria) this;
        }

        public Criteria andContactPersonIsNotNull() {
            addCriterion("contact_person is not null");
            return (Criteria) this;
        }

        public Criteria andContactPersonEqualTo(String value) {
            addCriterion("contact_person =", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonNotEqualTo(String value) {
            addCriterion("contact_person <>", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonGreaterThan(String value) {
            addCriterion("contact_person >", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonGreaterThanOrEqualTo(String value) {
            addCriterion("contact_person >=", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonLessThan(String value) {
            addCriterion("contact_person <", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonLessThanOrEqualTo(String value) {
            addCriterion("contact_person <=", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonIn(List<String> values) {
            addCriterion("contact_person in", values, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonNotIn(List<String> values) {
            addCriterion("contact_person not in", values, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonBetween(String value1, String value2) {
            addCriterion("contact_person between", value1, value2, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonNotBetween(String value1, String value2) {
            addCriterion("contact_person not between", value1, value2, "contactPerson");
            return (Criteria) this;
        }
        
        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
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