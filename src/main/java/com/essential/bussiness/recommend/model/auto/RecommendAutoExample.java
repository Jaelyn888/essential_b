package com.essential.bussiness.recommend.model.auto;

import java.util.ArrayList;
import java.util.List;

public class RecommendAutoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecommendAutoExample() {
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

        public Criteria andRecommendIdIsNull() {
            addCriterion("recommend_id is null");
            return (Criteria) this;
        }

        public Criteria andRecommendIdIsNotNull() {
            addCriterion("recommend_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendIdEqualTo(Long value) {
            addCriterion("recommend_id =", value, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdNotEqualTo(Long value) {
            addCriterion("recommend_id <>", value, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdGreaterThan(Long value) {
            addCriterion("recommend_id >", value, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdGreaterThanOrEqualTo(Long value) {
            addCriterion("recommend_id >=", value, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdLessThan(Long value) {
            addCriterion("recommend_id <", value, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdLessThanOrEqualTo(Long value) {
            addCriterion("recommend_id <=", value, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdIn(List<Long> values) {
            addCriterion("recommend_id in", values, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdNotIn(List<Long> values) {
            addCriterion("recommend_id not in", values, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdBetween(Long value1, Long value2) {
            addCriterion("recommend_id between", value1, value2, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdNotBetween(Long value1, Long value2) {
            addCriterion("recommend_id not between", value1, value2, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendNameIsNull() {
            addCriterion("recommend_name is null");
            return (Criteria) this;
        }

        public Criteria andRecommendNameIsNotNull() {
            addCriterion("recommend_name is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendNameEqualTo(String value) {
            addCriterion("recommend_name =", value, "recommendName");
            return (Criteria) this;
        }

        public Criteria andRecommendNameNotEqualTo(String value) {
            addCriterion("recommend_name <>", value, "recommendName");
            return (Criteria) this;
        }

        public Criteria andRecommendNameGreaterThan(String value) {
            addCriterion("recommend_name >", value, "recommendName");
            return (Criteria) this;
        }

        public Criteria andRecommendNameGreaterThanOrEqualTo(String value) {
            addCriterion("recommend_name >=", value, "recommendName");
            return (Criteria) this;
        }

        public Criteria andRecommendNameLessThan(String value) {
            addCriterion("recommend_name <", value, "recommendName");
            return (Criteria) this;
        }

        public Criteria andRecommendNameLessThanOrEqualTo(String value) {
            addCriterion("recommend_name <=", value, "recommendName");
            return (Criteria) this;
        }

        public Criteria andRecommendNameLike(String value) {
            addCriterion("recommend_name like", value, "recommendName");
            return (Criteria) this;
        }

        public Criteria andRecommendNameNotLike(String value) {
            addCriterion("recommend_name not like", value, "recommendName");
            return (Criteria) this;
        }

        public Criteria andRecommendNameIn(List<String> values) {
            addCriterion("recommend_name in", values, "recommendName");
            return (Criteria) this;
        }

        public Criteria andRecommendNameNotIn(List<String> values) {
            addCriterion("recommend_name not in", values, "recommendName");
            return (Criteria) this;
        }

        public Criteria andRecommendNameBetween(String value1, String value2) {
            addCriterion("recommend_name between", value1, value2, "recommendName");
            return (Criteria) this;
        }

        public Criteria andRecommendNameNotBetween(String value1, String value2) {
            addCriterion("recommend_name not between", value1, value2, "recommendName");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeIsNull() {
            addCriterion("recommend_type is null");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeIsNotNull() {
            addCriterion("recommend_type is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeEqualTo(Integer value) {
            addCriterion("recommend_type =", value, "recommendType");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeNotEqualTo(Integer value) {
            addCriterion("recommend_type <>", value, "recommendType");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeGreaterThan(Integer value) {
            addCriterion("recommend_type >", value, "recommendType");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("recommend_type >=", value, "recommendType");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeLessThan(Integer value) {
            addCriterion("recommend_type <", value, "recommendType");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeLessThanOrEqualTo(Integer value) {
            addCriterion("recommend_type <=", value, "recommendType");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeIn(List<Integer> values) {
            addCriterion("recommend_type in", values, "recommendType");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeNotIn(List<Integer> values) {
            addCriterion("recommend_type not in", values, "recommendType");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeBetween(Integer value1, Integer value2) {
            addCriterion("recommend_type between", value1, value2, "recommendType");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("recommend_type not between", value1, value2, "recommendType");
            return (Criteria) this;
        }

        public Criteria andRecommendIntroductionIsNull() {
            addCriterion("recommend_introduction is null");
            return (Criteria) this;
        }

        public Criteria andRecommendIntroductionIsNotNull() {
            addCriterion("recommend_introduction is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendIntroductionEqualTo(String value) {
            addCriterion("recommend_introduction =", value, "recommendIntroduction");
            return (Criteria) this;
        }

        public Criteria andRecommendIntroductionNotEqualTo(String value) {
            addCriterion("recommend_introduction <>", value, "recommendIntroduction");
            return (Criteria) this;
        }

        public Criteria andRecommendIntroductionGreaterThan(String value) {
            addCriterion("recommend_introduction >", value, "recommendIntroduction");
            return (Criteria) this;
        }

        public Criteria andRecommendIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("recommend_introduction >=", value, "recommendIntroduction");
            return (Criteria) this;
        }

        public Criteria andRecommendIntroductionLessThan(String value) {
            addCriterion("recommend_introduction <", value, "recommendIntroduction");
            return (Criteria) this;
        }

        public Criteria andRecommendIntroductionLessThanOrEqualTo(String value) {
            addCriterion("recommend_introduction <=", value, "recommendIntroduction");
            return (Criteria) this;
        }

        public Criteria andRecommendIntroductionLike(String value) {
            addCriterion("recommend_introduction like", value, "recommendIntroduction");
            return (Criteria) this;
        }

        public Criteria andRecommendIntroductionNotLike(String value) {
            addCriterion("recommend_introduction not like", value, "recommendIntroduction");
            return (Criteria) this;
        }

        public Criteria andRecommendIntroductionIn(List<String> values) {
            addCriterion("recommend_introduction in", values, "recommendIntroduction");
            return (Criteria) this;
        }

        public Criteria andRecommendIntroductionNotIn(List<String> values) {
            addCriterion("recommend_introduction not in", values, "recommendIntroduction");
            return (Criteria) this;
        }

        public Criteria andRecommendIntroductionBetween(String value1, String value2) {
            addCriterion("recommend_introduction between", value1, value2, "recommendIntroduction");
            return (Criteria) this;
        }

        public Criteria andRecommendIntroductionNotBetween(String value1, String value2) {
            addCriterion("recommend_introduction not between", value1, value2, "recommendIntroduction");
            return (Criteria) this;
        }

        public Criteria andRecommendDescriptionIsNull() {
            addCriterion("recommend_description is null");
            return (Criteria) this;
        }

        public Criteria andRecommendDescriptionIsNotNull() {
            addCriterion("recommend_description is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendDescriptionEqualTo(String value) {
            addCriterion("recommend_description =", value, "recommendDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendDescriptionNotEqualTo(String value) {
            addCriterion("recommend_description <>", value, "recommendDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendDescriptionGreaterThan(String value) {
            addCriterion("recommend_description >", value, "recommendDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("recommend_description >=", value, "recommendDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendDescriptionLessThan(String value) {
            addCriterion("recommend_description <", value, "recommendDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendDescriptionLessThanOrEqualTo(String value) {
            addCriterion("recommend_description <=", value, "recommendDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendDescriptionLike(String value) {
            addCriterion("recommend_description like", value, "recommendDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendDescriptionNotLike(String value) {
            addCriterion("recommend_description not like", value, "recommendDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendDescriptionIn(List<String> values) {
            addCriterion("recommend_description in", values, "recommendDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendDescriptionNotIn(List<String> values) {
            addCriterion("recommend_description not in", values, "recommendDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendDescriptionBetween(String value1, String value2) {
            addCriterion("recommend_description between", value1, value2, "recommendDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendDescriptionNotBetween(String value1, String value2) {
            addCriterion("recommend_description not between", value1, value2, "recommendDescription");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleIsNull() {
            addCriterion("recommend_title is null");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleIsNotNull() {
            addCriterion("recommend_title is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleEqualTo(String value) {
            addCriterion("recommend_title =", value, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleNotEqualTo(String value) {
            addCriterion("recommend_title <>", value, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleGreaterThan(String value) {
            addCriterion("recommend_title >", value, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleGreaterThanOrEqualTo(String value) {
            addCriterion("recommend_title >=", value, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleLessThan(String value) {
            addCriterion("recommend_title <", value, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleLessThanOrEqualTo(String value) {
            addCriterion("recommend_title <=", value, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleLike(String value) {
            addCriterion("recommend_title like", value, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleNotLike(String value) {
            addCriterion("recommend_title not like", value, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleIn(List<String> values) {
            addCriterion("recommend_title in", values, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleNotIn(List<String> values) {
            addCriterion("recommend_title not in", values, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleBetween(String value1, String value2) {
            addCriterion("recommend_title between", value1, value2, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendTitleNotBetween(String value1, String value2) {
            addCriterion("recommend_title not between", value1, value2, "recommendTitle");
            return (Criteria) this;
        }

        public Criteria andRecommendNumberIsNull() {
            addCriterion("recommend_number is null");
            return (Criteria) this;
        }

        public Criteria andRecommendNumberIsNotNull() {
            addCriterion("recommend_number is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendNumberEqualTo(String value) {
            addCriterion("recommend_number =", value, "recommendNumber");
            return (Criteria) this;
        }

        public Criteria andRecommendNumberNotEqualTo(String value) {
            addCriterion("recommend_number <>", value, "recommendNumber");
            return (Criteria) this;
        }

        public Criteria andRecommendNumberGreaterThan(String value) {
            addCriterion("recommend_number >", value, "recommendNumber");
            return (Criteria) this;
        }

        public Criteria andRecommendNumberGreaterThanOrEqualTo(String value) {
            addCriterion("recommend_number >=", value, "recommendNumber");
            return (Criteria) this;
        }

        public Criteria andRecommendNumberLessThan(String value) {
            addCriterion("recommend_number <", value, "recommendNumber");
            return (Criteria) this;
        }

        public Criteria andRecommendNumberLessThanOrEqualTo(String value) {
            addCriterion("recommend_number <=", value, "recommendNumber");
            return (Criteria) this;
        }

        public Criteria andRecommendNumberLike(String value) {
            addCriterion("recommend_number like", value, "recommendNumber");
            return (Criteria) this;
        }

        public Criteria andRecommendNumberNotLike(String value) {
            addCriterion("recommend_number not like", value, "recommendNumber");
            return (Criteria) this;
        }

        public Criteria andRecommendNumberIn(List<String> values) {
            addCriterion("recommend_number in", values, "recommendNumber");
            return (Criteria) this;
        }

        public Criteria andRecommendNumberNotIn(List<String> values) {
            addCriterion("recommend_number not in", values, "recommendNumber");
            return (Criteria) this;
        }

        public Criteria andRecommendNumberBetween(String value1, String value2) {
            addCriterion("recommend_number between", value1, value2, "recommendNumber");
            return (Criteria) this;
        }

        public Criteria andRecommendNumberNotBetween(String value1, String value2) {
            addCriterion("recommend_number not between", value1, value2, "recommendNumber");
            return (Criteria) this;
        }

        public Criteria andRecommendSortIsNull() {
            addCriterion("recommend_sort is null");
            return (Criteria) this;
        }

        public Criteria andRecommendSortIsNotNull() {
            addCriterion("recommend_sort is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendSortEqualTo(Integer value) {
            addCriterion("recommend_sort =", value, "recommendSort");
            return (Criteria) this;
        }

        public Criteria andRecommendSortNotEqualTo(Integer value) {
            addCriterion("recommend_sort <>", value, "recommendSort");
            return (Criteria) this;
        }

        public Criteria andRecommendSortGreaterThan(Integer value) {
            addCriterion("recommend_sort >", value, "recommendSort");
            return (Criteria) this;
        }

        public Criteria andRecommendSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("recommend_sort >=", value, "recommendSort");
            return (Criteria) this;
        }

        public Criteria andRecommendSortLessThan(Integer value) {
            addCriterion("recommend_sort <", value, "recommendSort");
            return (Criteria) this;
        }

        public Criteria andRecommendSortLessThanOrEqualTo(Integer value) {
            addCriterion("recommend_sort <=", value, "recommendSort");
            return (Criteria) this;
        }

        public Criteria andRecommendSortIn(List<Integer> values) {
            addCriterion("recommend_sort in", values, "recommendSort");
            return (Criteria) this;
        }

        public Criteria andRecommendSortNotIn(List<Integer> values) {
            addCriterion("recommend_sort not in", values, "recommendSort");
            return (Criteria) this;
        }

        public Criteria andRecommendSortBetween(Integer value1, Integer value2) {
            addCriterion("recommend_sort between", value1, value2, "recommendSort");
            return (Criteria) this;
        }

        public Criteria andRecommendSortNotBetween(Integer value1, Integer value2) {
            addCriterion("recommend_sort not between", value1, value2, "recommendSort");
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

        public Criteria andStatusTimeIsNull() {
            addCriterion("status_time is null");
            return (Criteria) this;
        }

        public Criteria andStatusTimeIsNotNull() {
            addCriterion("status_time is not null");
            return (Criteria) this;
        }

        public Criteria andStatusTimeEqualTo(String value) {
            addCriterion("status_time =", value, "statusTime");
            return (Criteria) this;
        }

        public Criteria andStatusTimeNotEqualTo(String value) {
            addCriterion("status_time <>", value, "statusTime");
            return (Criteria) this;
        }

        public Criteria andStatusTimeGreaterThan(String value) {
            addCriterion("status_time >", value, "statusTime");
            return (Criteria) this;
        }

        public Criteria andStatusTimeGreaterThanOrEqualTo(String value) {
            addCriterion("status_time >=", value, "statusTime");
            return (Criteria) this;
        }

        public Criteria andStatusTimeLessThan(String value) {
            addCriterion("status_time <", value, "statusTime");
            return (Criteria) this;
        }

        public Criteria andStatusTimeLessThanOrEqualTo(String value) {
            addCriterion("status_time <=", value, "statusTime");
            return (Criteria) this;
        }

        public Criteria andStatusTimeLike(String value) {
            addCriterion("status_time like", value, "statusTime");
            return (Criteria) this;
        }

        public Criteria andStatusTimeNotLike(String value) {
            addCriterion("status_time not like", value, "statusTime");
            return (Criteria) this;
        }

        public Criteria andStatusTimeIn(List<String> values) {
            addCriterion("status_time in", values, "statusTime");
            return (Criteria) this;
        }

        public Criteria andStatusTimeNotIn(List<String> values) {
            addCriterion("status_time not in", values, "statusTime");
            return (Criteria) this;
        }

        public Criteria andStatusTimeBetween(String value1, String value2) {
            addCriterion("status_time between", value1, value2, "statusTime");
            return (Criteria) this;
        }

        public Criteria andStatusTimeNotBetween(String value1, String value2) {
            addCriterion("status_time not between", value1, value2, "statusTime");
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

        public Criteria andCreateUserNameIsNull() {
            addCriterion("create_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNotNull() {
            addCriterion("create_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameEqualTo(String value) {
            addCriterion("create_user_name =", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotEqualTo(String value) {
            addCriterion("create_user_name <>", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThan(String value) {
            addCriterion("create_user_name >", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_name >=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThan(String value) {
            addCriterion("create_user_name <", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThanOrEqualTo(String value) {
            addCriterion("create_user_name <=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLike(String value) {
            addCriterion("create_user_name like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotLike(String value) {
            addCriterion("create_user_name not like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIn(List<String> values) {
            addCriterion("create_user_name in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotIn(List<String> values) {
            addCriterion("create_user_name not in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameBetween(String value1, String value2) {
            addCriterion("create_user_name between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotBetween(String value1, String value2) {
            addCriterion("create_user_name not between", value1, value2, "createUserName");
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

        public Criteria andModifyUserNameIsNull() {
            addCriterion("modify_user_name is null");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameIsNotNull() {
            addCriterion("modify_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameEqualTo(String value) {
            addCriterion("modify_user_name =", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameNotEqualTo(String value) {
            addCriterion("modify_user_name <>", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameGreaterThan(String value) {
            addCriterion("modify_user_name >", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("modify_user_name >=", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameLessThan(String value) {
            addCriterion("modify_user_name <", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameLessThanOrEqualTo(String value) {
            addCriterion("modify_user_name <=", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameLike(String value) {
            addCriterion("modify_user_name like", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameNotLike(String value) {
            addCriterion("modify_user_name not like", value, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameIn(List<String> values) {
            addCriterion("modify_user_name in", values, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameNotIn(List<String> values) {
            addCriterion("modify_user_name not in", values, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameBetween(String value1, String value2) {
            addCriterion("modify_user_name between", value1, value2, "modifyUserName");
            return (Criteria) this;
        }

        public Criteria andModifyUserNameNotBetween(String value1, String value2) {
            addCriterion("modify_user_name not between", value1, value2, "modifyUserName");
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

        public Criteria andMainPicPathIsNull() {
            addCriterion("main_pic_path is null");
            return (Criteria) this;
        }

        public Criteria andMainPicPathIsNotNull() {
            addCriterion("main_pic_path is not null");
            return (Criteria) this;
        }

        public Criteria andMainPicPathEqualTo(String value) {
            addCriterion("main_pic_path =", value, "mainPicPath");
            return (Criteria) this;
        }

        public Criteria andMainPicPathNotEqualTo(String value) {
            addCriterion("main_pic_path <>", value, "mainPicPath");
            return (Criteria) this;
        }

        public Criteria andMainPicPathGreaterThan(String value) {
            addCriterion("main_pic_path >", value, "mainPicPath");
            return (Criteria) this;
        }

        public Criteria andMainPicPathGreaterThanOrEqualTo(String value) {
            addCriterion("main_pic_path >=", value, "mainPicPath");
            return (Criteria) this;
        }

        public Criteria andMainPicPathLessThan(String value) {
            addCriterion("main_pic_path <", value, "mainPicPath");
            return (Criteria) this;
        }

        public Criteria andMainPicPathLessThanOrEqualTo(String value) {
            addCriterion("main_pic_path <=", value, "mainPicPath");
            return (Criteria) this;
        }

        public Criteria andMainPicPathLike(String value) {
            addCriterion("main_pic_path like", value, "mainPicPath");
            return (Criteria) this;
        }

        public Criteria andMainPicPathNotLike(String value) {
            addCriterion("main_pic_path not like", value, "mainPicPath");
            return (Criteria) this;
        }

        public Criteria andMainPicPathIn(List<String> values) {
            addCriterion("main_pic_path in", values, "mainPicPath");
            return (Criteria) this;
        }

        public Criteria andMainPicPathNotIn(List<String> values) {
            addCriterion("main_pic_path not in", values, "mainPicPath");
            return (Criteria) this;
        }

        public Criteria andMainPicPathBetween(String value1, String value2) {
            addCriterion("main_pic_path between", value1, value2, "mainPicPath");
            return (Criteria) this;
        }

        public Criteria andMainPicPathNotBetween(String value1, String value2) {
            addCriterion("main_pic_path not between", value1, value2, "mainPicPath");
            return (Criteria) this;
        }

        public Criteria andCoverPicIsNull() {
            addCriterion("cover_pic is null");
            return (Criteria) this;
        }

        public Criteria andCoverPicIsNotNull() {
            addCriterion("cover_pic is not null");
            return (Criteria) this;
        }

        public Criteria andCoverPicEqualTo(String value) {
            addCriterion("cover_pic =", value, "coverPic");
            return (Criteria) this;
        }

        public Criteria andCoverPicNotEqualTo(String value) {
            addCriterion("cover_pic <>", value, "coverPic");
            return (Criteria) this;
        }

        public Criteria andCoverPicGreaterThan(String value) {
            addCriterion("cover_pic >", value, "coverPic");
            return (Criteria) this;
        }

        public Criteria andCoverPicGreaterThanOrEqualTo(String value) {
            addCriterion("cover_pic >=", value, "coverPic");
            return (Criteria) this;
        }

        public Criteria andCoverPicLessThan(String value) {
            addCriterion("cover_pic <", value, "coverPic");
            return (Criteria) this;
        }

        public Criteria andCoverPicLessThanOrEqualTo(String value) {
            addCriterion("cover_pic <=", value, "coverPic");
            return (Criteria) this;
        }

        public Criteria andCoverPicLike(String value) {
            addCriterion("cover_pic like", value, "coverPic");
            return (Criteria) this;
        }

        public Criteria andCoverPicNotLike(String value) {
            addCriterion("cover_pic not like", value, "coverPic");
            return (Criteria) this;
        }

        public Criteria andCoverPicIn(List<String> values) {
            addCriterion("cover_pic in", values, "coverPic");
            return (Criteria) this;
        }

        public Criteria andCoverPicNotIn(List<String> values) {
            addCriterion("cover_pic not in", values, "coverPic");
            return (Criteria) this;
        }

        public Criteria andCoverPicBetween(String value1, String value2) {
            addCriterion("cover_pic between", value1, value2, "coverPic");
            return (Criteria) this;
        }

        public Criteria andCoverPicNotBetween(String value1, String value2) {
            addCriterion("cover_pic not between", value1, value2, "coverPic");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionFlagIsNull() {
            addCriterion("advertising_position_flag is null");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionFlagIsNotNull() {
            addCriterion("advertising_position_flag is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionFlagEqualTo(Integer value) {
            addCriterion("advertising_position_flag =", value, "advertisingPositionFlag");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionFlagNotEqualTo(Integer value) {
            addCriterion("advertising_position_flag <>", value, "advertisingPositionFlag");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionFlagGreaterThan(Integer value) {
            addCriterion("advertising_position_flag >", value, "advertisingPositionFlag");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("advertising_position_flag >=", value, "advertisingPositionFlag");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionFlagLessThan(Integer value) {
            addCriterion("advertising_position_flag <", value, "advertisingPositionFlag");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionFlagLessThanOrEqualTo(Integer value) {
            addCriterion("advertising_position_flag <=", value, "advertisingPositionFlag");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionFlagIn(List<Integer> values) {
            addCriterion("advertising_position_flag in", values, "advertisingPositionFlag");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionFlagNotIn(List<Integer> values) {
            addCriterion("advertising_position_flag not in", values, "advertisingPositionFlag");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionFlagBetween(Integer value1, Integer value2) {
            addCriterion("advertising_position_flag between", value1, value2, "advertisingPositionFlag");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("advertising_position_flag not between", value1, value2, "advertisingPositionFlag");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionSortIsNull() {
            addCriterion("advertising_position_sort is null");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionSortIsNotNull() {
            addCriterion("advertising_position_sort is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionSortEqualTo(Integer value) {
            addCriterion("advertising_position_sort =", value, "advertisingPositionSort");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionSortNotEqualTo(Integer value) {
            addCriterion("advertising_position_sort <>", value, "advertisingPositionSort");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionSortGreaterThan(Integer value) {
            addCriterion("advertising_position_sort >", value, "advertisingPositionSort");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("advertising_position_sort >=", value, "advertisingPositionSort");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionSortLessThan(Integer value) {
            addCriterion("advertising_position_sort <", value, "advertisingPositionSort");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionSortLessThanOrEqualTo(Integer value) {
            addCriterion("advertising_position_sort <=", value, "advertisingPositionSort");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionSortIn(List<Integer> values) {
            addCriterion("advertising_position_sort in", values, "advertisingPositionSort");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionSortNotIn(List<Integer> values) {
            addCriterion("advertising_position_sort not in", values, "advertisingPositionSort");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionSortBetween(Integer value1, Integer value2) {
            addCriterion("advertising_position_sort between", value1, value2, "advertisingPositionSort");
            return (Criteria) this;
        }

        public Criteria andAdvertisingPositionSortNotBetween(Integer value1, Integer value2) {
            addCriterion("advertising_position_sort not between", value1, value2, "advertisingPositionSort");
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