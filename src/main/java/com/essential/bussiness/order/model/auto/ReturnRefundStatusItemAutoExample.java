package com.essential.bussiness.order.model.auto;

import java.util.ArrayList;
import java.util.List;

public class ReturnRefundStatusItemAutoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReturnRefundStatusItemAutoExample() {
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

        public Criteria andReturnRefundStatusItemIdIsNull() {
            addCriterion("return_refund_status_item_id is null");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemIdIsNotNull() {
            addCriterion("return_refund_status_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemIdEqualTo(Integer value) {
            addCriterion("return_refund_status_item_id =", value, "returnRefundStatusItemId");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemIdNotEqualTo(Integer value) {
            addCriterion("return_refund_status_item_id <>", value, "returnRefundStatusItemId");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemIdGreaterThan(Integer value) {
            addCriterion("return_refund_status_item_id >", value, "returnRefundStatusItemId");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_refund_status_item_id >=", value, "returnRefundStatusItemId");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemIdLessThan(Integer value) {
            addCriterion("return_refund_status_item_id <", value, "returnRefundStatusItemId");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("return_refund_status_item_id <=", value, "returnRefundStatusItemId");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemIdIn(List<Integer> values) {
            addCriterion("return_refund_status_item_id in", values, "returnRefundStatusItemId");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemIdNotIn(List<Integer> values) {
            addCriterion("return_refund_status_item_id not in", values, "returnRefundStatusItemId");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemIdBetween(Integer value1, Integer value2) {
            addCriterion("return_refund_status_item_id between", value1, value2, "returnRefundStatusItemId");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("return_refund_status_item_id not between", value1, value2, "returnRefundStatusItemId");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemNameIsNull() {
            addCriterion("return_refund_status_item_name is null");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemNameIsNotNull() {
            addCriterion("return_refund_status_item_name is not null");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemNameEqualTo(String value) {
            addCriterion("return_refund_status_item_name =", value, "returnRefundStatusItemName");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemNameNotEqualTo(String value) {
            addCriterion("return_refund_status_item_name <>", value, "returnRefundStatusItemName");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemNameGreaterThan(String value) {
            addCriterion("return_refund_status_item_name >", value, "returnRefundStatusItemName");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("return_refund_status_item_name >=", value, "returnRefundStatusItemName");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemNameLessThan(String value) {
            addCriterion("return_refund_status_item_name <", value, "returnRefundStatusItemName");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemNameLessThanOrEqualTo(String value) {
            addCriterion("return_refund_status_item_name <=", value, "returnRefundStatusItemName");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemNameLike(String value) {
            addCriterion("return_refund_status_item_name like", value, "returnRefundStatusItemName");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemNameNotLike(String value) {
            addCriterion("return_refund_status_item_name not like", value, "returnRefundStatusItemName");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemNameIn(List<String> values) {
            addCriterion("return_refund_status_item_name in", values, "returnRefundStatusItemName");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemNameNotIn(List<String> values) {
            addCriterion("return_refund_status_item_name not in", values, "returnRefundStatusItemName");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemNameBetween(String value1, String value2) {
            addCriterion("return_refund_status_item_name between", value1, value2, "returnRefundStatusItemName");
            return (Criteria) this;
        }

        public Criteria andReturnRefundStatusItemNameNotBetween(String value1, String value2) {
            addCriterion("return_refund_status_item_name not between", value1, value2, "returnRefundStatusItemName");
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