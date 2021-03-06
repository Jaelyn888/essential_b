package com.essential.coupon.model.auto;

import java.util.ArrayList;
import java.util.List;

public class CouponUsedAutoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CouponUsedAutoExample() {
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

        public Criteria andCouponUsedIdIsNull() {
            addCriterion("coupon_used_id is null");
            return (Criteria) this;
        }

        public Criteria andCouponUsedIdIsNotNull() {
            addCriterion("coupon_used_id is not null");
            return (Criteria) this;
        }

        public Criteria andCouponUsedIdEqualTo(Long value) {
            addCriterion("coupon_used_id =", value, "couponUsedId");
            return (Criteria) this;
        }

        public Criteria andCouponUsedIdNotEqualTo(Long value) {
            addCriterion("coupon_used_id <>", value, "couponUsedId");
            return (Criteria) this;
        }

        public Criteria andCouponUsedIdGreaterThan(Long value) {
            addCriterion("coupon_used_id >", value, "couponUsedId");
            return (Criteria) this;
        }

        public Criteria andCouponUsedIdGreaterThanOrEqualTo(Long value) {
            addCriterion("coupon_used_id >=", value, "couponUsedId");
            return (Criteria) this;
        }

        public Criteria andCouponUsedIdLessThan(Long value) {
            addCriterion("coupon_used_id <", value, "couponUsedId");
            return (Criteria) this;
        }

        public Criteria andCouponUsedIdLessThanOrEqualTo(Long value) {
            addCriterion("coupon_used_id <=", value, "couponUsedId");
            return (Criteria) this;
        }

        public Criteria andCouponUsedIdIn(List<Long> values) {
            addCriterion("coupon_used_id in", values, "couponUsedId");
            return (Criteria) this;
        }

        public Criteria andCouponUsedIdNotIn(List<Long> values) {
            addCriterion("coupon_used_id not in", values, "couponUsedId");
            return (Criteria) this;
        }

        public Criteria andCouponUsedIdBetween(Long value1, Long value2) {
            addCriterion("coupon_used_id between", value1, value2, "couponUsedId");
            return (Criteria) this;
        }

        public Criteria andCouponUsedIdNotBetween(Long value1, Long value2) {
            addCriterion("coupon_used_id not between", value1, value2, "couponUsedId");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNull() {
            addCriterion("coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNotNull() {
            addCriterion("coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andCouponIdEqualTo(Long value) {
            addCriterion("coupon_id =", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotEqualTo(Long value) {
            addCriterion("coupon_id <>", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThan(Long value) {
            addCriterion("coupon_id >", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThanOrEqualTo(Long value) {
            addCriterion("coupon_id >=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThan(Long value) {
            addCriterion("coupon_id <", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThanOrEqualTo(Long value) {
            addCriterion("coupon_id <=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdIn(List<Long> values) {
            addCriterion("coupon_id in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotIn(List<Long> values) {
            addCriterion("coupon_id not in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdBetween(Long value1, Long value2) {
            addCriterion("coupon_id between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotBetween(Long value1, Long value2) {
            addCriterion("coupon_id not between", value1, value2, "couponId");
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

        public Criteria andModifyUserIsNull() {
            addCriterion("modify_user is null");
            return (Criteria) this;
        }

        public Criteria andModifyUserIsNotNull() {
            addCriterion("modify_user is not null");
            return (Criteria) this;
        }

        public Criteria andModifyUserEqualTo(Long value) {
            addCriterion("modify_user =", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotEqualTo(Long value) {
            addCriterion("modify_user <>", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserGreaterThan(Long value) {
            addCriterion("modify_user >", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserGreaterThanOrEqualTo(Long value) {
            addCriterion("modify_user >=", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLessThan(Long value) {
            addCriterion("modify_user <", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLessThanOrEqualTo(Long value) {
            addCriterion("modify_user <=", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserIn(List<Long> values) {
            addCriterion("modify_user in", values, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotIn(List<Long> values) {
            addCriterion("modify_user not in", values, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserBetween(Long value1, Long value2) {
            addCriterion("modify_user between", value1, value2, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotBetween(Long value1, Long value2) {
            addCriterion("modify_user not between", value1, value2, "modifyUser");
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

        public Criteria andExternalOrderNumberIsNull() {
            addCriterion("external_order_number is null");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNumberIsNotNull() {
            addCriterion("external_order_number is not null");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNumberEqualTo(String value) {
            addCriterion("external_order_number =", value, "externalOrderNumber");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNumberNotEqualTo(String value) {
            addCriterion("external_order_number <>", value, "externalOrderNumber");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNumberGreaterThan(String value) {
            addCriterion("external_order_number >", value, "externalOrderNumber");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("external_order_number >=", value, "externalOrderNumber");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNumberLessThan(String value) {
            addCriterion("external_order_number <", value, "externalOrderNumber");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("external_order_number <=", value, "externalOrderNumber");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNumberLike(String value) {
            addCriterion("external_order_number like", value, "externalOrderNumber");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNumberNotLike(String value) {
            addCriterion("external_order_number not like", value, "externalOrderNumber");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNumberIn(List<String> values) {
            addCriterion("external_order_number in", values, "externalOrderNumber");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNumberNotIn(List<String> values) {
            addCriterion("external_order_number not in", values, "externalOrderNumber");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNumberBetween(String value1, String value2) {
            addCriterion("external_order_number between", value1, value2, "externalOrderNumber");
            return (Criteria) this;
        }

        public Criteria andExternalOrderNumberNotBetween(String value1, String value2) {
            addCriterion("external_order_number not between", value1, value2, "externalOrderNumber");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andAttr7IsNull() {
            addCriterion("attr7 is null");
            return (Criteria) this;
        }

        public Criteria andAttr7IsNotNull() {
            addCriterion("attr7 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr7EqualTo(String value) {
            addCriterion("attr7 =", value, "attr7");
            return (Criteria) this;
        }

        public Criteria andAttr7NotEqualTo(String value) {
            addCriterion("attr7 <>", value, "attr7");
            return (Criteria) this;
        }

        public Criteria andAttr7GreaterThan(String value) {
            addCriterion("attr7 >", value, "attr7");
            return (Criteria) this;
        }

        public Criteria andAttr7GreaterThanOrEqualTo(String value) {
            addCriterion("attr7 >=", value, "attr7");
            return (Criteria) this;
        }

        public Criteria andAttr7LessThan(String value) {
            addCriterion("attr7 <", value, "attr7");
            return (Criteria) this;
        }

        public Criteria andAttr7LessThanOrEqualTo(String value) {
            addCriterion("attr7 <=", value, "attr7");
            return (Criteria) this;
        }

        public Criteria andAttr7Like(String value) {
            addCriterion("attr7 like", value, "attr7");
            return (Criteria) this;
        }

        public Criteria andAttr7NotLike(String value) {
            addCriterion("attr7 not like", value, "attr7");
            return (Criteria) this;
        }

        public Criteria andAttr7In(List<String> values) {
            addCriterion("attr7 in", values, "attr7");
            return (Criteria) this;
        }

        public Criteria andAttr7NotIn(List<String> values) {
            addCriterion("attr7 not in", values, "attr7");
            return (Criteria) this;
        }

        public Criteria andAttr7Between(String value1, String value2) {
            addCriterion("attr7 between", value1, value2, "attr7");
            return (Criteria) this;
        }

        public Criteria andAttr7NotBetween(String value1, String value2) {
            addCriterion("attr7 not between", value1, value2, "attr7");
            return (Criteria) this;
        }

        public Criteria andAttr8IsNull() {
            addCriterion("attr8 is null");
            return (Criteria) this;
        }

        public Criteria andAttr8IsNotNull() {
            addCriterion("attr8 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr8EqualTo(String value) {
            addCriterion("attr8 =", value, "attr8");
            return (Criteria) this;
        }

        public Criteria andAttr8NotEqualTo(String value) {
            addCriterion("attr8 <>", value, "attr8");
            return (Criteria) this;
        }

        public Criteria andAttr8GreaterThan(String value) {
            addCriterion("attr8 >", value, "attr8");
            return (Criteria) this;
        }

        public Criteria andAttr8GreaterThanOrEqualTo(String value) {
            addCriterion("attr8 >=", value, "attr8");
            return (Criteria) this;
        }

        public Criteria andAttr8LessThan(String value) {
            addCriterion("attr8 <", value, "attr8");
            return (Criteria) this;
        }

        public Criteria andAttr8LessThanOrEqualTo(String value) {
            addCriterion("attr8 <=", value, "attr8");
            return (Criteria) this;
        }

        public Criteria andAttr8Like(String value) {
            addCriterion("attr8 like", value, "attr8");
            return (Criteria) this;
        }

        public Criteria andAttr8NotLike(String value) {
            addCriterion("attr8 not like", value, "attr8");
            return (Criteria) this;
        }

        public Criteria andAttr8In(List<String> values) {
            addCriterion("attr8 in", values, "attr8");
            return (Criteria) this;
        }

        public Criteria andAttr8NotIn(List<String> values) {
            addCriterion("attr8 not in", values, "attr8");
            return (Criteria) this;
        }

        public Criteria andAttr8Between(String value1, String value2) {
            addCriterion("attr8 between", value1, value2, "attr8");
            return (Criteria) this;
        }

        public Criteria andAttr8NotBetween(String value1, String value2) {
            addCriterion("attr8 not between", value1, value2, "attr8");
            return (Criteria) this;
        }

        public Criteria andAttr9IsNull() {
            addCriterion("attr9 is null");
            return (Criteria) this;
        }

        public Criteria andAttr9IsNotNull() {
            addCriterion("attr9 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr9EqualTo(String value) {
            addCriterion("attr9 =", value, "attr9");
            return (Criteria) this;
        }

        public Criteria andAttr9NotEqualTo(String value) {
            addCriterion("attr9 <>", value, "attr9");
            return (Criteria) this;
        }

        public Criteria andAttr9GreaterThan(String value) {
            addCriterion("attr9 >", value, "attr9");
            return (Criteria) this;
        }

        public Criteria andAttr9GreaterThanOrEqualTo(String value) {
            addCriterion("attr9 >=", value, "attr9");
            return (Criteria) this;
        }

        public Criteria andAttr9LessThan(String value) {
            addCriterion("attr9 <", value, "attr9");
            return (Criteria) this;
        }

        public Criteria andAttr9LessThanOrEqualTo(String value) {
            addCriterion("attr9 <=", value, "attr9");
            return (Criteria) this;
        }

        public Criteria andAttr9Like(String value) {
            addCriterion("attr9 like", value, "attr9");
            return (Criteria) this;
        }

        public Criteria andAttr9NotLike(String value) {
            addCriterion("attr9 not like", value, "attr9");
            return (Criteria) this;
        }

        public Criteria andAttr9In(List<String> values) {
            addCriterion("attr9 in", values, "attr9");
            return (Criteria) this;
        }

        public Criteria andAttr9NotIn(List<String> values) {
            addCriterion("attr9 not in", values, "attr9");
            return (Criteria) this;
        }

        public Criteria andAttr9Between(String value1, String value2) {
            addCriterion("attr9 between", value1, value2, "attr9");
            return (Criteria) this;
        }

        public Criteria andAttr9NotBetween(String value1, String value2) {
            addCriterion("attr9 not between", value1, value2, "attr9");
            return (Criteria) this;
        }

        public Criteria andAttr10IsNull() {
            addCriterion("attr10 is null");
            return (Criteria) this;
        }

        public Criteria andAttr10IsNotNull() {
            addCriterion("attr10 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr10EqualTo(String value) {
            addCriterion("attr10 =", value, "attr10");
            return (Criteria) this;
        }

        public Criteria andAttr10NotEqualTo(String value) {
            addCriterion("attr10 <>", value, "attr10");
            return (Criteria) this;
        }

        public Criteria andAttr10GreaterThan(String value) {
            addCriterion("attr10 >", value, "attr10");
            return (Criteria) this;
        }

        public Criteria andAttr10GreaterThanOrEqualTo(String value) {
            addCriterion("attr10 >=", value, "attr10");
            return (Criteria) this;
        }

        public Criteria andAttr10LessThan(String value) {
            addCriterion("attr10 <", value, "attr10");
            return (Criteria) this;
        }

        public Criteria andAttr10LessThanOrEqualTo(String value) {
            addCriterion("attr10 <=", value, "attr10");
            return (Criteria) this;
        }

        public Criteria andAttr10Like(String value) {
            addCriterion("attr10 like", value, "attr10");
            return (Criteria) this;
        }

        public Criteria andAttr10NotLike(String value) {
            addCriterion("attr10 not like", value, "attr10");
            return (Criteria) this;
        }

        public Criteria andAttr10In(List<String> values) {
            addCriterion("attr10 in", values, "attr10");
            return (Criteria) this;
        }

        public Criteria andAttr10NotIn(List<String> values) {
            addCriterion("attr10 not in", values, "attr10");
            return (Criteria) this;
        }

        public Criteria andAttr10Between(String value1, String value2) {
            addCriterion("attr10 between", value1, value2, "attr10");
            return (Criteria) this;
        }

        public Criteria andAttr10NotBetween(String value1, String value2) {
            addCriterion("attr10 not between", value1, value2, "attr10");
            return (Criteria) this;
        }

        public Criteria andAttr11IsNull() {
            addCriterion("attr11 is null");
            return (Criteria) this;
        }

        public Criteria andAttr11IsNotNull() {
            addCriterion("attr11 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr11EqualTo(String value) {
            addCriterion("attr11 =", value, "attr11");
            return (Criteria) this;
        }

        public Criteria andAttr11NotEqualTo(String value) {
            addCriterion("attr11 <>", value, "attr11");
            return (Criteria) this;
        }

        public Criteria andAttr11GreaterThan(String value) {
            addCriterion("attr11 >", value, "attr11");
            return (Criteria) this;
        }

        public Criteria andAttr11GreaterThanOrEqualTo(String value) {
            addCriterion("attr11 >=", value, "attr11");
            return (Criteria) this;
        }

        public Criteria andAttr11LessThan(String value) {
            addCriterion("attr11 <", value, "attr11");
            return (Criteria) this;
        }

        public Criteria andAttr11LessThanOrEqualTo(String value) {
            addCriterion("attr11 <=", value, "attr11");
            return (Criteria) this;
        }

        public Criteria andAttr11Like(String value) {
            addCriterion("attr11 like", value, "attr11");
            return (Criteria) this;
        }

        public Criteria andAttr11NotLike(String value) {
            addCriterion("attr11 not like", value, "attr11");
            return (Criteria) this;
        }

        public Criteria andAttr11In(List<String> values) {
            addCriterion("attr11 in", values, "attr11");
            return (Criteria) this;
        }

        public Criteria andAttr11NotIn(List<String> values) {
            addCriterion("attr11 not in", values, "attr11");
            return (Criteria) this;
        }

        public Criteria andAttr11Between(String value1, String value2) {
            addCriterion("attr11 between", value1, value2, "attr11");
            return (Criteria) this;
        }

        public Criteria andAttr11NotBetween(String value1, String value2) {
            addCriterion("attr11 not between", value1, value2, "attr11");
            return (Criteria) this;
        }

        public Criteria andAttr12IsNull() {
            addCriterion("attr12 is null");
            return (Criteria) this;
        }

        public Criteria andAttr12IsNotNull() {
            addCriterion("attr12 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr12EqualTo(String value) {
            addCriterion("attr12 =", value, "attr12");
            return (Criteria) this;
        }

        public Criteria andAttr12NotEqualTo(String value) {
            addCriterion("attr12 <>", value, "attr12");
            return (Criteria) this;
        }

        public Criteria andAttr12GreaterThan(String value) {
            addCriterion("attr12 >", value, "attr12");
            return (Criteria) this;
        }

        public Criteria andAttr12GreaterThanOrEqualTo(String value) {
            addCriterion("attr12 >=", value, "attr12");
            return (Criteria) this;
        }

        public Criteria andAttr12LessThan(String value) {
            addCriterion("attr12 <", value, "attr12");
            return (Criteria) this;
        }

        public Criteria andAttr12LessThanOrEqualTo(String value) {
            addCriterion("attr12 <=", value, "attr12");
            return (Criteria) this;
        }

        public Criteria andAttr12Like(String value) {
            addCriterion("attr12 like", value, "attr12");
            return (Criteria) this;
        }

        public Criteria andAttr12NotLike(String value) {
            addCriterion("attr12 not like", value, "attr12");
            return (Criteria) this;
        }

        public Criteria andAttr12In(List<String> values) {
            addCriterion("attr12 in", values, "attr12");
            return (Criteria) this;
        }

        public Criteria andAttr12NotIn(List<String> values) {
            addCriterion("attr12 not in", values, "attr12");
            return (Criteria) this;
        }

        public Criteria andAttr12Between(String value1, String value2) {
            addCriterion("attr12 between", value1, value2, "attr12");
            return (Criteria) this;
        }

        public Criteria andAttr12NotBetween(String value1, String value2) {
            addCriterion("attr12 not between", value1, value2, "attr12");
            return (Criteria) this;
        }

        public Criteria andAttr13IsNull() {
            addCriterion("attr13 is null");
            return (Criteria) this;
        }

        public Criteria andAttr13IsNotNull() {
            addCriterion("attr13 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr13EqualTo(String value) {
            addCriterion("attr13 =", value, "attr13");
            return (Criteria) this;
        }

        public Criteria andAttr13NotEqualTo(String value) {
            addCriterion("attr13 <>", value, "attr13");
            return (Criteria) this;
        }

        public Criteria andAttr13GreaterThan(String value) {
            addCriterion("attr13 >", value, "attr13");
            return (Criteria) this;
        }

        public Criteria andAttr13GreaterThanOrEqualTo(String value) {
            addCriterion("attr13 >=", value, "attr13");
            return (Criteria) this;
        }

        public Criteria andAttr13LessThan(String value) {
            addCriterion("attr13 <", value, "attr13");
            return (Criteria) this;
        }

        public Criteria andAttr13LessThanOrEqualTo(String value) {
            addCriterion("attr13 <=", value, "attr13");
            return (Criteria) this;
        }

        public Criteria andAttr13Like(String value) {
            addCriterion("attr13 like", value, "attr13");
            return (Criteria) this;
        }

        public Criteria andAttr13NotLike(String value) {
            addCriterion("attr13 not like", value, "attr13");
            return (Criteria) this;
        }

        public Criteria andAttr13In(List<String> values) {
            addCriterion("attr13 in", values, "attr13");
            return (Criteria) this;
        }

        public Criteria andAttr13NotIn(List<String> values) {
            addCriterion("attr13 not in", values, "attr13");
            return (Criteria) this;
        }

        public Criteria andAttr13Between(String value1, String value2) {
            addCriterion("attr13 between", value1, value2, "attr13");
            return (Criteria) this;
        }

        public Criteria andAttr13NotBetween(String value1, String value2) {
            addCriterion("attr13 not between", value1, value2, "attr13");
            return (Criteria) this;
        }

        public Criteria andAttr14IsNull() {
            addCriterion("attr14 is null");
            return (Criteria) this;
        }

        public Criteria andAttr14IsNotNull() {
            addCriterion("attr14 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr14EqualTo(String value) {
            addCriterion("attr14 =", value, "attr14");
            return (Criteria) this;
        }

        public Criteria andAttr14NotEqualTo(String value) {
            addCriterion("attr14 <>", value, "attr14");
            return (Criteria) this;
        }

        public Criteria andAttr14GreaterThan(String value) {
            addCriterion("attr14 >", value, "attr14");
            return (Criteria) this;
        }

        public Criteria andAttr14GreaterThanOrEqualTo(String value) {
            addCriterion("attr14 >=", value, "attr14");
            return (Criteria) this;
        }

        public Criteria andAttr14LessThan(String value) {
            addCriterion("attr14 <", value, "attr14");
            return (Criteria) this;
        }

        public Criteria andAttr14LessThanOrEqualTo(String value) {
            addCriterion("attr14 <=", value, "attr14");
            return (Criteria) this;
        }

        public Criteria andAttr14Like(String value) {
            addCriterion("attr14 like", value, "attr14");
            return (Criteria) this;
        }

        public Criteria andAttr14NotLike(String value) {
            addCriterion("attr14 not like", value, "attr14");
            return (Criteria) this;
        }

        public Criteria andAttr14In(List<String> values) {
            addCriterion("attr14 in", values, "attr14");
            return (Criteria) this;
        }

        public Criteria andAttr14NotIn(List<String> values) {
            addCriterion("attr14 not in", values, "attr14");
            return (Criteria) this;
        }

        public Criteria andAttr14Between(String value1, String value2) {
            addCriterion("attr14 between", value1, value2, "attr14");
            return (Criteria) this;
        }

        public Criteria andAttr14NotBetween(String value1, String value2) {
            addCriterion("attr14 not between", value1, value2, "attr14");
            return (Criteria) this;
        }

        public Criteria andAttr15IsNull() {
            addCriterion("attr15 is null");
            return (Criteria) this;
        }

        public Criteria andAttr15IsNotNull() {
            addCriterion("attr15 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr15EqualTo(String value) {
            addCriterion("attr15 =", value, "attr15");
            return (Criteria) this;
        }

        public Criteria andAttr15NotEqualTo(String value) {
            addCriterion("attr15 <>", value, "attr15");
            return (Criteria) this;
        }

        public Criteria andAttr15GreaterThan(String value) {
            addCriterion("attr15 >", value, "attr15");
            return (Criteria) this;
        }

        public Criteria andAttr15GreaterThanOrEqualTo(String value) {
            addCriterion("attr15 >=", value, "attr15");
            return (Criteria) this;
        }

        public Criteria andAttr15LessThan(String value) {
            addCriterion("attr15 <", value, "attr15");
            return (Criteria) this;
        }

        public Criteria andAttr15LessThanOrEqualTo(String value) {
            addCriterion("attr15 <=", value, "attr15");
            return (Criteria) this;
        }

        public Criteria andAttr15Like(String value) {
            addCriterion("attr15 like", value, "attr15");
            return (Criteria) this;
        }

        public Criteria andAttr15NotLike(String value) {
            addCriterion("attr15 not like", value, "attr15");
            return (Criteria) this;
        }

        public Criteria andAttr15In(List<String> values) {
            addCriterion("attr15 in", values, "attr15");
            return (Criteria) this;
        }

        public Criteria andAttr15NotIn(List<String> values) {
            addCriterion("attr15 not in", values, "attr15");
            return (Criteria) this;
        }

        public Criteria andAttr15Between(String value1, String value2) {
            addCriterion("attr15 between", value1, value2, "attr15");
            return (Criteria) this;
        }

        public Criteria andAttr15NotBetween(String value1, String value2) {
            addCriterion("attr15 not between", value1, value2, "attr15");
            return (Criteria) this;
        }

        public Criteria andAttr16IsNull() {
            addCriterion("attr16 is null");
            return (Criteria) this;
        }

        public Criteria andAttr16IsNotNull() {
            addCriterion("attr16 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr16EqualTo(String value) {
            addCriterion("attr16 =", value, "attr16");
            return (Criteria) this;
        }

        public Criteria andAttr16NotEqualTo(String value) {
            addCriterion("attr16 <>", value, "attr16");
            return (Criteria) this;
        }

        public Criteria andAttr16GreaterThan(String value) {
            addCriterion("attr16 >", value, "attr16");
            return (Criteria) this;
        }

        public Criteria andAttr16GreaterThanOrEqualTo(String value) {
            addCriterion("attr16 >=", value, "attr16");
            return (Criteria) this;
        }

        public Criteria andAttr16LessThan(String value) {
            addCriterion("attr16 <", value, "attr16");
            return (Criteria) this;
        }

        public Criteria andAttr16LessThanOrEqualTo(String value) {
            addCriterion("attr16 <=", value, "attr16");
            return (Criteria) this;
        }

        public Criteria andAttr16Like(String value) {
            addCriterion("attr16 like", value, "attr16");
            return (Criteria) this;
        }

        public Criteria andAttr16NotLike(String value) {
            addCriterion("attr16 not like", value, "attr16");
            return (Criteria) this;
        }

        public Criteria andAttr16In(List<String> values) {
            addCriterion("attr16 in", values, "attr16");
            return (Criteria) this;
        }

        public Criteria andAttr16NotIn(List<String> values) {
            addCriterion("attr16 not in", values, "attr16");
            return (Criteria) this;
        }

        public Criteria andAttr16Between(String value1, String value2) {
            addCriterion("attr16 between", value1, value2, "attr16");
            return (Criteria) this;
        }

        public Criteria andAttr16NotBetween(String value1, String value2) {
            addCriterion("attr16 not between", value1, value2, "attr16");
            return (Criteria) this;
        }

        public Criteria andAttr17IsNull() {
            addCriterion("attr17 is null");
            return (Criteria) this;
        }

        public Criteria andAttr17IsNotNull() {
            addCriterion("attr17 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr17EqualTo(String value) {
            addCriterion("attr17 =", value, "attr17");
            return (Criteria) this;
        }

        public Criteria andAttr17NotEqualTo(String value) {
            addCriterion("attr17 <>", value, "attr17");
            return (Criteria) this;
        }

        public Criteria andAttr17GreaterThan(String value) {
            addCriterion("attr17 >", value, "attr17");
            return (Criteria) this;
        }

        public Criteria andAttr17GreaterThanOrEqualTo(String value) {
            addCriterion("attr17 >=", value, "attr17");
            return (Criteria) this;
        }

        public Criteria andAttr17LessThan(String value) {
            addCriterion("attr17 <", value, "attr17");
            return (Criteria) this;
        }

        public Criteria andAttr17LessThanOrEqualTo(String value) {
            addCriterion("attr17 <=", value, "attr17");
            return (Criteria) this;
        }

        public Criteria andAttr17Like(String value) {
            addCriterion("attr17 like", value, "attr17");
            return (Criteria) this;
        }

        public Criteria andAttr17NotLike(String value) {
            addCriterion("attr17 not like", value, "attr17");
            return (Criteria) this;
        }

        public Criteria andAttr17In(List<String> values) {
            addCriterion("attr17 in", values, "attr17");
            return (Criteria) this;
        }

        public Criteria andAttr17NotIn(List<String> values) {
            addCriterion("attr17 not in", values, "attr17");
            return (Criteria) this;
        }

        public Criteria andAttr17Between(String value1, String value2) {
            addCriterion("attr17 between", value1, value2, "attr17");
            return (Criteria) this;
        }

        public Criteria andAttr17NotBetween(String value1, String value2) {
            addCriterion("attr17 not between", value1, value2, "attr17");
            return (Criteria) this;
        }

        public Criteria andAttr18IsNull() {
            addCriterion("attr18 is null");
            return (Criteria) this;
        }

        public Criteria andAttr18IsNotNull() {
            addCriterion("attr18 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr18EqualTo(String value) {
            addCriterion("attr18 =", value, "attr18");
            return (Criteria) this;
        }

        public Criteria andAttr18NotEqualTo(String value) {
            addCriterion("attr18 <>", value, "attr18");
            return (Criteria) this;
        }

        public Criteria andAttr18GreaterThan(String value) {
            addCriterion("attr18 >", value, "attr18");
            return (Criteria) this;
        }

        public Criteria andAttr18GreaterThanOrEqualTo(String value) {
            addCriterion("attr18 >=", value, "attr18");
            return (Criteria) this;
        }

        public Criteria andAttr18LessThan(String value) {
            addCriterion("attr18 <", value, "attr18");
            return (Criteria) this;
        }

        public Criteria andAttr18LessThanOrEqualTo(String value) {
            addCriterion("attr18 <=", value, "attr18");
            return (Criteria) this;
        }

        public Criteria andAttr18Like(String value) {
            addCriterion("attr18 like", value, "attr18");
            return (Criteria) this;
        }

        public Criteria andAttr18NotLike(String value) {
            addCriterion("attr18 not like", value, "attr18");
            return (Criteria) this;
        }

        public Criteria andAttr18In(List<String> values) {
            addCriterion("attr18 in", values, "attr18");
            return (Criteria) this;
        }

        public Criteria andAttr18NotIn(List<String> values) {
            addCriterion("attr18 not in", values, "attr18");
            return (Criteria) this;
        }

        public Criteria andAttr18Between(String value1, String value2) {
            addCriterion("attr18 between", value1, value2, "attr18");
            return (Criteria) this;
        }

        public Criteria andAttr18NotBetween(String value1, String value2) {
            addCriterion("attr18 not between", value1, value2, "attr18");
            return (Criteria) this;
        }

        public Criteria andAttr19IsNull() {
            addCriterion("attr19 is null");
            return (Criteria) this;
        }

        public Criteria andAttr19IsNotNull() {
            addCriterion("attr19 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr19EqualTo(String value) {
            addCriterion("attr19 =", value, "attr19");
            return (Criteria) this;
        }

        public Criteria andAttr19NotEqualTo(String value) {
            addCriterion("attr19 <>", value, "attr19");
            return (Criteria) this;
        }

        public Criteria andAttr19GreaterThan(String value) {
            addCriterion("attr19 >", value, "attr19");
            return (Criteria) this;
        }

        public Criteria andAttr19GreaterThanOrEqualTo(String value) {
            addCriterion("attr19 >=", value, "attr19");
            return (Criteria) this;
        }

        public Criteria andAttr19LessThan(String value) {
            addCriterion("attr19 <", value, "attr19");
            return (Criteria) this;
        }

        public Criteria andAttr19LessThanOrEqualTo(String value) {
            addCriterion("attr19 <=", value, "attr19");
            return (Criteria) this;
        }

        public Criteria andAttr19Like(String value) {
            addCriterion("attr19 like", value, "attr19");
            return (Criteria) this;
        }

        public Criteria andAttr19NotLike(String value) {
            addCriterion("attr19 not like", value, "attr19");
            return (Criteria) this;
        }

        public Criteria andAttr19In(List<String> values) {
            addCriterion("attr19 in", values, "attr19");
            return (Criteria) this;
        }

        public Criteria andAttr19NotIn(List<String> values) {
            addCriterion("attr19 not in", values, "attr19");
            return (Criteria) this;
        }

        public Criteria andAttr19Between(String value1, String value2) {
            addCriterion("attr19 between", value1, value2, "attr19");
            return (Criteria) this;
        }

        public Criteria andAttr19NotBetween(String value1, String value2) {
            addCriterion("attr19 not between", value1, value2, "attr19");
            return (Criteria) this;
        }

        public Criteria andAttr20IsNull() {
            addCriterion("attr20 is null");
            return (Criteria) this;
        }

        public Criteria andAttr20IsNotNull() {
            addCriterion("attr20 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr20EqualTo(String value) {
            addCriterion("attr20 =", value, "attr20");
            return (Criteria) this;
        }

        public Criteria andAttr20NotEqualTo(String value) {
            addCriterion("attr20 <>", value, "attr20");
            return (Criteria) this;
        }

        public Criteria andAttr20GreaterThan(String value) {
            addCriterion("attr20 >", value, "attr20");
            return (Criteria) this;
        }

        public Criteria andAttr20GreaterThanOrEqualTo(String value) {
            addCriterion("attr20 >=", value, "attr20");
            return (Criteria) this;
        }

        public Criteria andAttr20LessThan(String value) {
            addCriterion("attr20 <", value, "attr20");
            return (Criteria) this;
        }

        public Criteria andAttr20LessThanOrEqualTo(String value) {
            addCriterion("attr20 <=", value, "attr20");
            return (Criteria) this;
        }

        public Criteria andAttr20Like(String value) {
            addCriterion("attr20 like", value, "attr20");
            return (Criteria) this;
        }

        public Criteria andAttr20NotLike(String value) {
            addCriterion("attr20 not like", value, "attr20");
            return (Criteria) this;
        }

        public Criteria andAttr20In(List<String> values) {
            addCriterion("attr20 in", values, "attr20");
            return (Criteria) this;
        }

        public Criteria andAttr20NotIn(List<String> values) {
            addCriterion("attr20 not in", values, "attr20");
            return (Criteria) this;
        }

        public Criteria andAttr20Between(String value1, String value2) {
            addCriterion("attr20 between", value1, value2, "attr20");
            return (Criteria) this;
        }

        public Criteria andAttr20NotBetween(String value1, String value2) {
            addCriterion("attr20 not between", value1, value2, "attr20");
            return (Criteria) this;
        }

        public Criteria andAttr21IsNull() {
            addCriterion("attr21 is null");
            return (Criteria) this;
        }

        public Criteria andAttr21IsNotNull() {
            addCriterion("attr21 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr21EqualTo(String value) {
            addCriterion("attr21 =", value, "attr21");
            return (Criteria) this;
        }

        public Criteria andAttr21NotEqualTo(String value) {
            addCriterion("attr21 <>", value, "attr21");
            return (Criteria) this;
        }

        public Criteria andAttr21GreaterThan(String value) {
            addCriterion("attr21 >", value, "attr21");
            return (Criteria) this;
        }

        public Criteria andAttr21GreaterThanOrEqualTo(String value) {
            addCriterion("attr21 >=", value, "attr21");
            return (Criteria) this;
        }

        public Criteria andAttr21LessThan(String value) {
            addCriterion("attr21 <", value, "attr21");
            return (Criteria) this;
        }

        public Criteria andAttr21LessThanOrEqualTo(String value) {
            addCriterion("attr21 <=", value, "attr21");
            return (Criteria) this;
        }

        public Criteria andAttr21Like(String value) {
            addCriterion("attr21 like", value, "attr21");
            return (Criteria) this;
        }

        public Criteria andAttr21NotLike(String value) {
            addCriterion("attr21 not like", value, "attr21");
            return (Criteria) this;
        }

        public Criteria andAttr21In(List<String> values) {
            addCriterion("attr21 in", values, "attr21");
            return (Criteria) this;
        }

        public Criteria andAttr21NotIn(List<String> values) {
            addCriterion("attr21 not in", values, "attr21");
            return (Criteria) this;
        }

        public Criteria andAttr21Between(String value1, String value2) {
            addCriterion("attr21 between", value1, value2, "attr21");
            return (Criteria) this;
        }

        public Criteria andAttr21NotBetween(String value1, String value2) {
            addCriterion("attr21 not between", value1, value2, "attr21");
            return (Criteria) this;
        }

        public Criteria andAttr22IsNull() {
            addCriterion("attr22 is null");
            return (Criteria) this;
        }

        public Criteria andAttr22IsNotNull() {
            addCriterion("attr22 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr22EqualTo(String value) {
            addCriterion("attr22 =", value, "attr22");
            return (Criteria) this;
        }

        public Criteria andAttr22NotEqualTo(String value) {
            addCriterion("attr22 <>", value, "attr22");
            return (Criteria) this;
        }

        public Criteria andAttr22GreaterThan(String value) {
            addCriterion("attr22 >", value, "attr22");
            return (Criteria) this;
        }

        public Criteria andAttr22GreaterThanOrEqualTo(String value) {
            addCriterion("attr22 >=", value, "attr22");
            return (Criteria) this;
        }

        public Criteria andAttr22LessThan(String value) {
            addCriterion("attr22 <", value, "attr22");
            return (Criteria) this;
        }

        public Criteria andAttr22LessThanOrEqualTo(String value) {
            addCriterion("attr22 <=", value, "attr22");
            return (Criteria) this;
        }

        public Criteria andAttr22Like(String value) {
            addCriterion("attr22 like", value, "attr22");
            return (Criteria) this;
        }

        public Criteria andAttr22NotLike(String value) {
            addCriterion("attr22 not like", value, "attr22");
            return (Criteria) this;
        }

        public Criteria andAttr22In(List<String> values) {
            addCriterion("attr22 in", values, "attr22");
            return (Criteria) this;
        }

        public Criteria andAttr22NotIn(List<String> values) {
            addCriterion("attr22 not in", values, "attr22");
            return (Criteria) this;
        }

        public Criteria andAttr22Between(String value1, String value2) {
            addCriterion("attr22 between", value1, value2, "attr22");
            return (Criteria) this;
        }

        public Criteria andAttr22NotBetween(String value1, String value2) {
            addCriterion("attr22 not between", value1, value2, "attr22");
            return (Criteria) this;
        }

        public Criteria andAttr23IsNull() {
            addCriterion("attr23 is null");
            return (Criteria) this;
        }

        public Criteria andAttr23IsNotNull() {
            addCriterion("attr23 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr23EqualTo(String value) {
            addCriterion("attr23 =", value, "attr23");
            return (Criteria) this;
        }

        public Criteria andAttr23NotEqualTo(String value) {
            addCriterion("attr23 <>", value, "attr23");
            return (Criteria) this;
        }

        public Criteria andAttr23GreaterThan(String value) {
            addCriterion("attr23 >", value, "attr23");
            return (Criteria) this;
        }

        public Criteria andAttr23GreaterThanOrEqualTo(String value) {
            addCriterion("attr23 >=", value, "attr23");
            return (Criteria) this;
        }

        public Criteria andAttr23LessThan(String value) {
            addCriterion("attr23 <", value, "attr23");
            return (Criteria) this;
        }

        public Criteria andAttr23LessThanOrEqualTo(String value) {
            addCriterion("attr23 <=", value, "attr23");
            return (Criteria) this;
        }

        public Criteria andAttr23Like(String value) {
            addCriterion("attr23 like", value, "attr23");
            return (Criteria) this;
        }

        public Criteria andAttr23NotLike(String value) {
            addCriterion("attr23 not like", value, "attr23");
            return (Criteria) this;
        }

        public Criteria andAttr23In(List<String> values) {
            addCriterion("attr23 in", values, "attr23");
            return (Criteria) this;
        }

        public Criteria andAttr23NotIn(List<String> values) {
            addCriterion("attr23 not in", values, "attr23");
            return (Criteria) this;
        }

        public Criteria andAttr23Between(String value1, String value2) {
            addCriterion("attr23 between", value1, value2, "attr23");
            return (Criteria) this;
        }

        public Criteria andAttr23NotBetween(String value1, String value2) {
            addCriterion("attr23 not between", value1, value2, "attr23");
            return (Criteria) this;
        }

        public Criteria andAttr24IsNull() {
            addCriterion("attr24 is null");
            return (Criteria) this;
        }

        public Criteria andAttr24IsNotNull() {
            addCriterion("attr24 is not null");
            return (Criteria) this;
        }

        public Criteria andAttr24EqualTo(String value) {
            addCriterion("attr24 =", value, "attr24");
            return (Criteria) this;
        }

        public Criteria andAttr24NotEqualTo(String value) {
            addCriterion("attr24 <>", value, "attr24");
            return (Criteria) this;
        }

        public Criteria andAttr24GreaterThan(String value) {
            addCriterion("attr24 >", value, "attr24");
            return (Criteria) this;
        }

        public Criteria andAttr24GreaterThanOrEqualTo(String value) {
            addCriterion("attr24 >=", value, "attr24");
            return (Criteria) this;
        }

        public Criteria andAttr24LessThan(String value) {
            addCriterion("attr24 <", value, "attr24");
            return (Criteria) this;
        }

        public Criteria andAttr24LessThanOrEqualTo(String value) {
            addCriterion("attr24 <=", value, "attr24");
            return (Criteria) this;
        }

        public Criteria andAttr24Like(String value) {
            addCriterion("attr24 like", value, "attr24");
            return (Criteria) this;
        }

        public Criteria andAttr24NotLike(String value) {
            addCriterion("attr24 not like", value, "attr24");
            return (Criteria) this;
        }

        public Criteria andAttr24In(List<String> values) {
            addCriterion("attr24 in", values, "attr24");
            return (Criteria) this;
        }

        public Criteria andAttr24NotIn(List<String> values) {
            addCriterion("attr24 not in", values, "attr24");
            return (Criteria) this;
        }

        public Criteria andAttr24Between(String value1, String value2) {
            addCriterion("attr24 between", value1, value2, "attr24");
            return (Criteria) this;
        }

        public Criteria andAttr24NotBetween(String value1, String value2) {
            addCriterion("attr24 not between", value1, value2, "attr24");
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