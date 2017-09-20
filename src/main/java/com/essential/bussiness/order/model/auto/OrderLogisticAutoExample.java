package com.essential.bussiness.order.model.auto;

import java.util.ArrayList;
import java.util.List;

public class OrderLogisticAutoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderLogisticAutoExample() {
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

        public Criteria andOrderLogisticIdIsNull() {
            addCriterion("order_logistic_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticIdIsNotNull() {
            addCriterion("order_logistic_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticIdEqualTo(Long value) {
            addCriterion("order_logistic_id =", value, "orderLogisticId");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticIdNotEqualTo(Long value) {
            addCriterion("order_logistic_id <>", value, "orderLogisticId");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticIdGreaterThan(Long value) {
            addCriterion("order_logistic_id >", value, "orderLogisticId");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_logistic_id >=", value, "orderLogisticId");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticIdLessThan(Long value) {
            addCriterion("order_logistic_id <", value, "orderLogisticId");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticIdLessThanOrEqualTo(Long value) {
            addCriterion("order_logistic_id <=", value, "orderLogisticId");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticIdIn(List<Long> values) {
            addCriterion("order_logistic_id in", values, "orderLogisticId");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticIdNotIn(List<Long> values) {
            addCriterion("order_logistic_id not in", values, "orderLogisticId");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticIdBetween(Long value1, Long value2) {
            addCriterion("order_logistic_id between", value1, value2, "orderLogisticId");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticIdNotBetween(Long value1, Long value2) {
            addCriterion("order_logistic_id not between", value1, value2, "orderLogisticId");
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

        public Criteria andLogisticsCompanyIsNull() {
            addCriterion("logistics_company is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyIsNotNull() {
            addCriterion("logistics_company is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyEqualTo(String value) {
            addCriterion("logistics_company =", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyNotEqualTo(String value) {
            addCriterion("logistics_company <>", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyGreaterThan(String value) {
            addCriterion("logistics_company >", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_company >=", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyLessThan(String value) {
            addCriterion("logistics_company <", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyLessThanOrEqualTo(String value) {
            addCriterion("logistics_company <=", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyLike(String value) {
            addCriterion("logistics_company like", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyNotLike(String value) {
            addCriterion("logistics_company not like", value, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyIn(List<String> values) {
            addCriterion("logistics_company in", values, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyNotIn(List<String> values) {
            addCriterion("logistics_company not in", values, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyBetween(String value1, String value2) {
            addCriterion("logistics_company between", value1, value2, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andLogisticsCompanyNotBetween(String value1, String value2) {
            addCriterion("logistics_company not between", value1, value2, "logisticsCompany");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticGoodsIsNull() {
            addCriterion("order_logistic_goods is null");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticGoodsIsNotNull() {
            addCriterion("order_logistic_goods is not null");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticGoodsEqualTo(String value) {
            addCriterion("order_logistic_goods =", value, "orderLogisticGoods");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticGoodsNotEqualTo(String value) {
            addCriterion("order_logistic_goods <>", value, "orderLogisticGoods");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticGoodsGreaterThan(String value) {
            addCriterion("order_logistic_goods >", value, "orderLogisticGoods");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticGoodsGreaterThanOrEqualTo(String value) {
            addCriterion("order_logistic_goods >=", value, "orderLogisticGoods");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticGoodsLessThan(String value) {
            addCriterion("order_logistic_goods <", value, "orderLogisticGoods");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticGoodsLessThanOrEqualTo(String value) {
            addCriterion("order_logistic_goods <=", value, "orderLogisticGoods");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticGoodsLike(String value) {
            addCriterion("order_logistic_goods like", value, "orderLogisticGoods");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticGoodsNotLike(String value) {
            addCriterion("order_logistic_goods not like", value, "orderLogisticGoods");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticGoodsIn(List<String> values) {
            addCriterion("order_logistic_goods in", values, "orderLogisticGoods");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticGoodsNotIn(List<String> values) {
            addCriterion("order_logistic_goods not in", values, "orderLogisticGoods");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticGoodsBetween(String value1, String value2) {
            addCriterion("order_logistic_goods between", value1, value2, "orderLogisticGoods");
            return (Criteria) this;
        }

        public Criteria andOrderLogisticGoodsNotBetween(String value1, String value2) {
            addCriterion("order_logistic_goods not between", value1, value2, "orderLogisticGoods");
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