package com.essential.bussiness.specification.model.auto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpecificationleveloneAutoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpecificationleveloneAutoExample() {
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

        public Criteria andSpecificationIdIsNull() {
            addCriterion("specification_id is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationIdIsNotNull() {
            addCriterion("specification_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationIdEqualTo(Long value) {
            addCriterion("specification_id =", value, "specificationId");
            return (Criteria) this;
        }

        public Criteria andSpecificationIdNotEqualTo(Long value) {
            addCriterion("specification_id <>", value, "specificationId");
            return (Criteria) this;
        }

        public Criteria andSpecificationIdGreaterThan(Long value) {
            addCriterion("specification_id >", value, "specificationId");
            return (Criteria) this;
        }

        public Criteria andSpecificationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("specification_id >=", value, "specificationId");
            return (Criteria) this;
        }

        public Criteria andSpecificationIdLessThan(Long value) {
            addCriterion("specification_id <", value, "specificationId");
            return (Criteria) this;
        }

        public Criteria andSpecificationIdLessThanOrEqualTo(Long value) {
            addCriterion("specification_id <=", value, "specificationId");
            return (Criteria) this;
        }

        public Criteria andSpecificationIdIn(List<Long> values) {
            addCriterion("specification_id in", values, "specificationId");
            return (Criteria) this;
        }

        public Criteria andSpecificationIdNotIn(List<Long> values) {
            addCriterion("specification_id not in", values, "specificationId");
            return (Criteria) this;
        }

        public Criteria andSpecificationIdBetween(Long value1, Long value2) {
            addCriterion("specification_id between", value1, value2, "specificationId");
            return (Criteria) this;
        }

        public Criteria andSpecificationIdNotBetween(Long value1, Long value2) {
            addCriterion("specification_id not between", value1, value2, "specificationId");
            return (Criteria) this;
        }

        public Criteria andLevelOneNameIsNull() {
            addCriterion("level_one_name is null");
            return (Criteria) this;
        }

        public Criteria andLevelOneNameIsNotNull() {
            addCriterion("level_one_name is not null");
            return (Criteria) this;
        }

        public Criteria andLevelOneNameEqualTo(String value) {
            addCriterion("level_one_name =", value, "levelOneName");
            return (Criteria) this;
        }

        public Criteria andLevelOneNameNotEqualTo(String value) {
            addCriterion("level_one_name <>", value, "levelOneName");
            return (Criteria) this;
        }

        public Criteria andLevelOneNameGreaterThan(String value) {
            addCriterion("level_one_name >", value, "levelOneName");
            return (Criteria) this;
        }

        public Criteria andLevelOneNameGreaterThanOrEqualTo(String value) {
            addCriterion("level_one_name >=", value, "levelOneName");
            return (Criteria) this;
        }

        public Criteria andLevelOneNameLessThan(String value) {
            addCriterion("level_one_name <", value, "levelOneName");
            return (Criteria) this;
        }

        public Criteria andLevelOneNameLessThanOrEqualTo(String value) {
            addCriterion("level_one_name <=", value, "levelOneName");
            return (Criteria) this;
        }

        public Criteria andLevelOneNameLike(String value) {
            addCriterion("level_one_name like", value, "levelOneName");
            return (Criteria) this;
        }

        public Criteria andLevelOneNameNotLike(String value) {
            addCriterion("level_one_name not like", value, "levelOneName");
            return (Criteria) this;
        }

        public Criteria andLevelOneNameIn(List<String> values) {
            addCriterion("level_one_name in", values, "levelOneName");
            return (Criteria) this;
        }

        public Criteria andLevelOneNameNotIn(List<String> values) {
            addCriterion("level_one_name not in", values, "levelOneName");
            return (Criteria) this;
        }

        public Criteria andLevelOneNameBetween(String value1, String value2) {
            addCriterion("level_one_name between", value1, value2, "levelOneName");
            return (Criteria) this;
        }

        public Criteria andLevelOneNameNotBetween(String value1, String value2) {
            addCriterion("level_one_name not between", value1, value2, "levelOneName");
            return (Criteria) this;
        }

        public Criteria andAliasnameIsNull() {
            addCriterion("aliasname is null");
            return (Criteria) this;
        }

        public Criteria andAliasnameIsNotNull() {
            addCriterion("aliasname is not null");
            return (Criteria) this;
        }

        public Criteria andAliasnameEqualTo(String value) {
            addCriterion("aliasname =", value, "aliasname");
            return (Criteria) this;
        }

        public Criteria andAliasnameNotEqualTo(String value) {
            addCriterion("aliasname <>", value, "aliasname");
            return (Criteria) this;
        }

        public Criteria andAliasnameGreaterThan(String value) {
            addCriterion("aliasname >", value, "aliasname");
            return (Criteria) this;
        }

        public Criteria andAliasnameGreaterThanOrEqualTo(String value) {
            addCriterion("aliasname >=", value, "aliasname");
            return (Criteria) this;
        }

        public Criteria andAliasnameLessThan(String value) {
            addCriterion("aliasname <", value, "aliasname");
            return (Criteria) this;
        }

        public Criteria andAliasnameLessThanOrEqualTo(String value) {
            addCriterion("aliasname <=", value, "aliasname");
            return (Criteria) this;
        }

        public Criteria andAliasnameLike(String value) {
            addCriterion("aliasname like", value, "aliasname");
            return (Criteria) this;
        }

        public Criteria andAliasnameNotLike(String value) {
            addCriterion("aliasname not like", value, "aliasname");
            return (Criteria) this;
        }

        public Criteria andAliasnameIn(List<String> values) {
            addCriterion("aliasname in", values, "aliasname");
            return (Criteria) this;
        }

        public Criteria andAliasnameNotIn(List<String> values) {
            addCriterion("aliasname not in", values, "aliasname");
            return (Criteria) this;
        }

        public Criteria andAliasnameBetween(String value1, String value2) {
            addCriterion("aliasname between", value1, value2, "aliasname");
            return (Criteria) this;
        }

        public Criteria andAliasnameNotBetween(String value1, String value2) {
            addCriterion("aliasname not between", value1, value2, "aliasname");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Integer value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Integer value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Integer value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Integer value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Integer> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Integer> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Integer value1, Integer value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
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

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
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

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIsIsNull() {
            addCriterion("level_two_is is null");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIsIsNotNull() {
            addCriterion("level_two_is is not null");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIsEqualTo(Integer value) {
            addCriterion("level_two_is =", value, "levelTwoIs");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIsNotEqualTo(Integer value) {
            addCriterion("level_two_is <>", value, "levelTwoIs");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIsGreaterThan(Integer value) {
            addCriterion("level_two_is >", value, "levelTwoIs");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIsGreaterThanOrEqualTo(Integer value) {
            addCriterion("level_two_is >=", value, "levelTwoIs");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIsLessThan(Integer value) {
            addCriterion("level_two_is <", value, "levelTwoIs");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIsLessThanOrEqualTo(Integer value) {
            addCriterion("level_two_is <=", value, "levelTwoIs");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIsIn(List<Integer> values) {
            addCriterion("level_two_is in", values, "levelTwoIs");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIsNotIn(List<Integer> values) {
            addCriterion("level_two_is not in", values, "levelTwoIs");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIsBetween(Integer value1, Integer value2) {
            addCriterion("level_two_is between", value1, value2, "levelTwoIs");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIsNotBetween(Integer value1, Integer value2) {
            addCriterion("level_two_is not between", value1, value2, "levelTwoIs");
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