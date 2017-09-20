package com.essential.bussiness.product.model.auto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductAutoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductAutoExample() {
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

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNull() {
            addCriterion("keyword is null");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNotNull() {
            addCriterion("keyword is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordEqualTo(String value) {
            addCriterion("keyword =", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotEqualTo(String value) {
            addCriterion("keyword <>", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThan(String value) {
            addCriterion("keyword >", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("keyword >=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThan(String value) {
            addCriterion("keyword <", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThanOrEqualTo(String value) {
            addCriterion("keyword <=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLike(String value) {
            addCriterion("keyword like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotLike(String value) {
            addCriterion("keyword not like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordIn(List<String> values) {
            addCriterion("keyword in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotIn(List<String> values) {
            addCriterion("keyword not in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordBetween(String value1, String value2) {
            addCriterion("keyword between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotBetween(String value1, String value2) {
            addCriterion("keyword not between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andProductDescribeIsNull() {
            addCriterion("product_describe is null");
            return (Criteria) this;
        }

        public Criteria andProductDescribeIsNotNull() {
            addCriterion("product_describe is not null");
            return (Criteria) this;
        }

        public Criteria andProductDescribeEqualTo(String value) {
            addCriterion("product_describe =", value, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductDescribeNotEqualTo(String value) {
            addCriterion("product_describe <>", value, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductDescribeGreaterThan(String value) {
            addCriterion("product_describe >", value, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("product_describe >=", value, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductDescribeLessThan(String value) {
            addCriterion("product_describe <", value, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductDescribeLessThanOrEqualTo(String value) {
            addCriterion("product_describe <=", value, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductDescribeLike(String value) {
            addCriterion("product_describe like", value, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductDescribeNotLike(String value) {
            addCriterion("product_describe not like", value, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductDescribeIn(List<String> values) {
            addCriterion("product_describe in", values, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductDescribeNotIn(List<String> values) {
            addCriterion("product_describe not in", values, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductDescribeBetween(String value1, String value2) {
            addCriterion("product_describe between", value1, value2, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductDescribeNotBetween(String value1, String value2) {
            addCriterion("product_describe not between", value1, value2, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductintroIsNull() {
            addCriterion("productIntro is null");
            return (Criteria) this;
        }

        public Criteria andProductintroIsNotNull() {
            addCriterion("productIntro is not null");
            return (Criteria) this;
        }

        public Criteria andProductintroEqualTo(String value) {
            addCriterion("productIntro =", value, "productintro");
            return (Criteria) this;
        }

        public Criteria andProductintroNotEqualTo(String value) {
            addCriterion("productIntro <>", value, "productintro");
            return (Criteria) this;
        }

        public Criteria andProductintroGreaterThan(String value) {
            addCriterion("productIntro >", value, "productintro");
            return (Criteria) this;
        }

        public Criteria andProductintroGreaterThanOrEqualTo(String value) {
            addCriterion("productIntro >=", value, "productintro");
            return (Criteria) this;
        }

        public Criteria andProductintroLessThan(String value) {
            addCriterion("productIntro <", value, "productintro");
            return (Criteria) this;
        }

        public Criteria andProductintroLessThanOrEqualTo(String value) {
            addCriterion("productIntro <=", value, "productintro");
            return (Criteria) this;
        }

        public Criteria andProductintroLike(String value) {
            addCriterion("productIntro like", value, "productintro");
            return (Criteria) this;
        }

        public Criteria andProductintroNotLike(String value) {
            addCriterion("productIntro not like", value, "productintro");
            return (Criteria) this;
        }

        public Criteria andProductintroIn(List<String> values) {
            addCriterion("productIntro in", values, "productintro");
            return (Criteria) this;
        }

        public Criteria andProductintroNotIn(List<String> values) {
            addCriterion("productIntro not in", values, "productintro");
            return (Criteria) this;
        }

        public Criteria andProductintroBetween(String value1, String value2) {
            addCriterion("productIntro between", value1, value2, "productintro");
            return (Criteria) this;
        }

        public Criteria andProductintroNotBetween(String value1, String value2) {
            addCriterion("productIntro not between", value1, value2, "productintro");
            return (Criteria) this;
        }

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(Long value) {
            addCriterion("stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(Long value) {
            addCriterion("stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(Long value) {
            addCriterion("stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(Long value) {
            addCriterion("stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(Long value) {
            addCriterion("stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(Long value) {
            addCriterion("stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<Long> values) {
            addCriterion("stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<Long> values) {
            addCriterion("stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(Long value1, Long value2) {
            addCriterion("stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(Long value1, Long value2) {
            addCriterion("stock not between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andIsRecommdIsNull() {
            addCriterion("is_recommd is null");
            return (Criteria) this;
        }

        public Criteria andIsRecommdIsNotNull() {
            addCriterion("is_recommd is not null");
            return (Criteria) this;
        }

        public Criteria andIsRecommdEqualTo(Integer value) {
            addCriterion("is_recommd =", value, "isRecommd");
            return (Criteria) this;
        }

        public Criteria andIsRecommdNotEqualTo(Integer value) {
            addCriterion("is_recommd <>", value, "isRecommd");
            return (Criteria) this;
        }

        public Criteria andIsRecommdGreaterThan(Integer value) {
            addCriterion("is_recommd >", value, "isRecommd");
            return (Criteria) this;
        }

        public Criteria andIsRecommdGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_recommd >=", value, "isRecommd");
            return (Criteria) this;
        }

        public Criteria andIsRecommdLessThan(Integer value) {
            addCriterion("is_recommd <", value, "isRecommd");
            return (Criteria) this;
        }

        public Criteria andIsRecommdLessThanOrEqualTo(Integer value) {
            addCriterion("is_recommd <=", value, "isRecommd");
            return (Criteria) this;
        }

        public Criteria andIsRecommdIn(List<Integer> values) {
            addCriterion("is_recommd in", values, "isRecommd");
            return (Criteria) this;
        }

        public Criteria andIsRecommdNotIn(List<Integer> values) {
            addCriterion("is_recommd not in", values, "isRecommd");
            return (Criteria) this;
        }

        public Criteria andIsRecommdBetween(Integer value1, Integer value2) {
            addCriterion("is_recommd between", value1, value2, "isRecommd");
            return (Criteria) this;
        }

        public Criteria andIsRecommdNotBetween(Integer value1, Integer value2) {
            addCriterion("is_recommd not between", value1, value2, "isRecommd");
            return (Criteria) this;
        }

        public Criteria andCostPriceIsNull() {
            addCriterion("cost_price is null");
            return (Criteria) this;
        }

        public Criteria andCostPriceIsNotNull() {
            addCriterion("cost_price is not null");
            return (Criteria) this;
        }

        public Criteria andCostPriceEqualTo(BigDecimal value) {
            addCriterion("cost_price =", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceNotEqualTo(BigDecimal value) {
            addCriterion("cost_price <>", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceGreaterThan(BigDecimal value) {
            addCriterion("cost_price >", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_price >=", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceLessThan(BigDecimal value) {
            addCriterion("cost_price <", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_price <=", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceIn(List<BigDecimal> values) {
            addCriterion("cost_price in", values, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceNotIn(List<BigDecimal> values) {
            addCriterion("cost_price not in", values, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_price between", value1, value2, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_price not between", value1, value2, "costPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIsNull() {
            addCriterion("market_price is null");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIsNotNull() {
            addCriterion("market_price is not null");
            return (Criteria) this;
        }

        public Criteria andMarketPriceEqualTo(BigDecimal value) {
            addCriterion("market_price =", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotEqualTo(BigDecimal value) {
            addCriterion("market_price <>", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceGreaterThan(BigDecimal value) {
            addCriterion("market_price >", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("market_price >=", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceLessThan(BigDecimal value) {
            addCriterion("market_price <", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("market_price <=", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIn(List<BigDecimal> values) {
            addCriterion("market_price in", values, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotIn(List<BigDecimal> values) {
            addCriterion("market_price not in", values, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("market_price between", value1, value2, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("market_price not between", value1, value2, "marketPrice");
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

        public Criteria andSalesNameIsNull() {
            addCriterion("sales_name is null");
            return (Criteria) this;
        }

        public Criteria andSalesNameIsNotNull() {
            addCriterion("sales_name is not null");
            return (Criteria) this;
        }

        public Criteria andSalesNameEqualTo(String value) {
            addCriterion("sales_name =", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameNotEqualTo(String value) {
            addCriterion("sales_name <>", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameGreaterThan(String value) {
            addCriterion("sales_name >", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameGreaterThanOrEqualTo(String value) {
            addCriterion("sales_name >=", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameLessThan(String value) {
            addCriterion("sales_name <", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameLessThanOrEqualTo(String value) {
            addCriterion("sales_name <=", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameLike(String value) {
            addCriterion("sales_name like", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameNotLike(String value) {
            addCriterion("sales_name not like", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameIn(List<String> values) {
            addCriterion("sales_name in", values, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameNotIn(List<String> values) {
            addCriterion("sales_name not in", values, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameBetween(String value1, String value2) {
            addCriterion("sales_name between", value1, value2, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameNotBetween(String value1, String value2) {
            addCriterion("sales_name not between", value1, value2, "salesName");
            return (Criteria) this;
        }

        public Criteria andPackingListIsNull() {
            addCriterion("packing_list is null");
            return (Criteria) this;
        }

        public Criteria andPackingListIsNotNull() {
            addCriterion("packing_list is not null");
            return (Criteria) this;
        }

        public Criteria andPackingListEqualTo(String value) {
            addCriterion("packing_list =", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListNotEqualTo(String value) {
            addCriterion("packing_list <>", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListGreaterThan(String value) {
            addCriterion("packing_list >", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListGreaterThanOrEqualTo(String value) {
            addCriterion("packing_list >=", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListLessThan(String value) {
            addCriterion("packing_list <", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListLessThanOrEqualTo(String value) {
            addCriterion("packing_list <=", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListLike(String value) {
            addCriterion("packing_list like", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListNotLike(String value) {
            addCriterion("packing_list not like", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListIn(List<String> values) {
            addCriterion("packing_list in", values, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListNotIn(List<String> values) {
            addCriterion("packing_list not in", values, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListBetween(String value1, String value2) {
            addCriterion("packing_list between", value1, value2, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListNotBetween(String value1, String value2) {
            addCriterion("packing_list not between", value1, value2, "packingList");
            return (Criteria) this;
        }

        public Criteria andAfterServiceIsNull() {
            addCriterion("after_service is null");
            return (Criteria) this;
        }

        public Criteria andAfterServiceIsNotNull() {
            addCriterion("after_service is not null");
            return (Criteria) this;
        }

        public Criteria andAfterServiceEqualTo(String value) {
            addCriterion("after_service =", value, "afterService");
            return (Criteria) this;
        }

        public Criteria andAfterServiceNotEqualTo(String value) {
            addCriterion("after_service <>", value, "afterService");
            return (Criteria) this;
        }

        public Criteria andAfterServiceGreaterThan(String value) {
            addCriterion("after_service >", value, "afterService");
            return (Criteria) this;
        }

        public Criteria andAfterServiceGreaterThanOrEqualTo(String value) {
            addCriterion("after_service >=", value, "afterService");
            return (Criteria) this;
        }

        public Criteria andAfterServiceLessThan(String value) {
            addCriterion("after_service <", value, "afterService");
            return (Criteria) this;
        }

        public Criteria andAfterServiceLessThanOrEqualTo(String value) {
            addCriterion("after_service <=", value, "afterService");
            return (Criteria) this;
        }

        public Criteria andAfterServiceLike(String value) {
            addCriterion("after_service like", value, "afterService");
            return (Criteria) this;
        }

        public Criteria andAfterServiceNotLike(String value) {
            addCriterion("after_service not like", value, "afterService");
            return (Criteria) this;
        }

        public Criteria andAfterServiceIn(List<String> values) {
            addCriterion("after_service in", values, "afterService");
            return (Criteria) this;
        }

        public Criteria andAfterServiceNotIn(List<String> values) {
            addCriterion("after_service not in", values, "afterService");
            return (Criteria) this;
        }

        public Criteria andAfterServiceBetween(String value1, String value2) {
            addCriterion("after_service between", value1, value2, "afterService");
            return (Criteria) this;
        }

        public Criteria andAfterServiceNotBetween(String value1, String value2) {
            addCriterion("after_service not between", value1, value2, "afterService");
            return (Criteria) this;
        }

        public Criteria andSaleNumIsNull() {
            addCriterion("sale_num is null");
            return (Criteria) this;
        }

        public Criteria andSaleNumIsNotNull() {
            addCriterion("sale_num is not null");
            return (Criteria) this;
        }

        public Criteria andSaleNumEqualTo(Long value) {
            addCriterion("sale_num =", value, "saleNum");
            return (Criteria) this;
        }

        public Criteria andSaleNumNotEqualTo(Long value) {
            addCriterion("sale_num <>", value, "saleNum");
            return (Criteria) this;
        }

        public Criteria andSaleNumGreaterThan(Long value) {
            addCriterion("sale_num >", value, "saleNum");
            return (Criteria) this;
        }

        public Criteria andSaleNumGreaterThanOrEqualTo(Long value) {
            addCriterion("sale_num >=", value, "saleNum");
            return (Criteria) this;
        }

        public Criteria andSaleNumLessThan(Long value) {
            addCriterion("sale_num <", value, "saleNum");
            return (Criteria) this;
        }

        public Criteria andSaleNumLessThanOrEqualTo(Long value) {
            addCriterion("sale_num <=", value, "saleNum");
            return (Criteria) this;
        }

        public Criteria andSaleNumIn(List<Long> values) {
            addCriterion("sale_num in", values, "saleNum");
            return (Criteria) this;
        }

        public Criteria andSaleNumNotIn(List<Long> values) {
            addCriterion("sale_num not in", values, "saleNum");
            return (Criteria) this;
        }

        public Criteria andSaleNumBetween(Long value1, Long value2) {
            addCriterion("sale_num between", value1, value2, "saleNum");
            return (Criteria) this;
        }

        public Criteria andSaleNumNotBetween(Long value1, Long value2) {
            addCriterion("sale_num not between", value1, value2, "saleNum");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNull() {
            addCriterion("delivery_time is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNotNull() {
            addCriterion("delivery_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeEqualTo(Date value) {
            addCriterion("delivery_time =", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotEqualTo(Date value) {
            addCriterion("delivery_time <>", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThan(Date value) {
            addCriterion("delivery_time >", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delivery_time >=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThan(Date value) {
            addCriterion("delivery_time <", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThanOrEqualTo(Date value) {
            addCriterion("delivery_time <=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIn(List<Date> values) {
            addCriterion("delivery_time in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotIn(List<Date> values) {
            addCriterion("delivery_time not in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeBetween(Date value1, Date value2) {
            addCriterion("delivery_time between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotBetween(Date value1, Date value2) {
            addCriterion("delivery_time not between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andCheckStatusidIsNull() {
            addCriterion("check_statusId is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusidIsNotNull() {
            addCriterion("check_statusId is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusidEqualTo(Integer value) {
            addCriterion("check_statusId =", value, "checkStatusid");
            return (Criteria) this;
        }

        public Criteria andCheckStatusidNotEqualTo(Integer value) {
            addCriterion("check_statusId <>", value, "checkStatusid");
            return (Criteria) this;
        }

        public Criteria andCheckStatusidGreaterThan(Integer value) {
            addCriterion("check_statusId >", value, "checkStatusid");
            return (Criteria) this;
        }

        public Criteria andCheckStatusidGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_statusId >=", value, "checkStatusid");
            return (Criteria) this;
        }

        public Criteria andCheckStatusidLessThan(Integer value) {
            addCriterion("check_statusId <", value, "checkStatusid");
            return (Criteria) this;
        }

        public Criteria andCheckStatusidLessThanOrEqualTo(Integer value) {
            addCriterion("check_statusId <=", value, "checkStatusid");
            return (Criteria) this;
        }

        public Criteria andCheckStatusidIn(List<Integer> values) {
            addCriterion("check_statusId in", values, "checkStatusid");
            return (Criteria) this;
        }

        public Criteria andCheckStatusidNotIn(List<Integer> values) {
            addCriterion("check_statusId not in", values, "checkStatusid");
            return (Criteria) this;
        }

        public Criteria andCheckStatusidBetween(Integer value1, Integer value2) {
            addCriterion("check_statusId between", value1, value2, "checkStatusid");
            return (Criteria) this;
        }

        public Criteria andCheckStatusidNotBetween(Integer value1, Integer value2) {
            addCriterion("check_statusId not between", value1, value2, "checkStatusid");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionPathIsNull() {
            addCriterion("two_dimension_path is null");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionPathIsNotNull() {
            addCriterion("two_dimension_path is not null");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionPathEqualTo(String value) {
            addCriterion("two_dimension_path =", value, "twoDimensionPath");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionPathNotEqualTo(String value) {
            addCriterion("two_dimension_path <>", value, "twoDimensionPath");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionPathGreaterThan(String value) {
            addCriterion("two_dimension_path >", value, "twoDimensionPath");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionPathGreaterThanOrEqualTo(String value) {
            addCriterion("two_dimension_path >=", value, "twoDimensionPath");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionPathLessThan(String value) {
            addCriterion("two_dimension_path <", value, "twoDimensionPath");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionPathLessThanOrEqualTo(String value) {
            addCriterion("two_dimension_path <=", value, "twoDimensionPath");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionPathLike(String value) {
            addCriterion("two_dimension_path like", value, "twoDimensionPath");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionPathNotLike(String value) {
            addCriterion("two_dimension_path not like", value, "twoDimensionPath");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionPathIn(List<String> values) {
            addCriterion("two_dimension_path in", values, "twoDimensionPath");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionPathNotIn(List<String> values) {
            addCriterion("two_dimension_path not in", values, "twoDimensionPath");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionPathBetween(String value1, String value2) {
            addCriterion("two_dimension_path between", value1, value2, "twoDimensionPath");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionPathNotBetween(String value1, String value2) {
            addCriterion("two_dimension_path not between", value1, value2, "twoDimensionPath");
            return (Criteria) this;
        }

        public Criteria andPncodeIsNull() {
            addCriterion("pncode is null");
            return (Criteria) this;
        }

        public Criteria andPncodeIsNotNull() {
            addCriterion("pncode is not null");
            return (Criteria) this;
        }

        public Criteria andPncodeEqualTo(String value) {
            addCriterion("pncode =", value, "pncode");
            return (Criteria) this;
        }

        public Criteria andPncodeNotEqualTo(String value) {
            addCriterion("pncode <>", value, "pncode");
            return (Criteria) this;
        }

        public Criteria andPncodeGreaterThan(String value) {
            addCriterion("pncode >", value, "pncode");
            return (Criteria) this;
        }

        public Criteria andPncodeGreaterThanOrEqualTo(String value) {
            addCriterion("pncode >=", value, "pncode");
            return (Criteria) this;
        }

        public Criteria andPncodeLessThan(String value) {
            addCriterion("pncode <", value, "pncode");
            return (Criteria) this;
        }

        public Criteria andPncodeLessThanOrEqualTo(String value) {
            addCriterion("pncode <=", value, "pncode");
            return (Criteria) this;
        }

        public Criteria andPncodeLike(String value) {
            addCriterion("pncode like", value, "pncode");
            return (Criteria) this;
        }

        public Criteria andPncodeNotLike(String value) {
            addCriterion("pncode not like", value, "pncode");
            return (Criteria) this;
        }

        public Criteria andPncodeIn(List<String> values) {
            addCriterion("pncode in", values, "pncode");
            return (Criteria) this;
        }

        public Criteria andPncodeNotIn(List<String> values) {
            addCriterion("pncode not in", values, "pncode");
            return (Criteria) this;
        }

        public Criteria andPncodeBetween(String value1, String value2) {
            addCriterion("pncode between", value1, value2, "pncode");
            return (Criteria) this;
        }

        public Criteria andPncodeNotBetween(String value1, String value2) {
            addCriterion("pncode not between", value1, value2, "pncode");
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

        public Criteria andIsLinkProductIsNull() {
            addCriterion("is_link_product is null");
            return (Criteria) this;
        }

        public Criteria andIsLinkProductIsNotNull() {
            addCriterion("is_link_product is not null");
            return (Criteria) this;
        }

        public Criteria andIsLinkProductEqualTo(Integer value) {
            addCriterion("is_link_product =", value, "isLinkProduct");
            return (Criteria) this;
        }

        public Criteria andIsLinkProductNotEqualTo(Integer value) {
            addCriterion("is_link_product <>", value, "isLinkProduct");
            return (Criteria) this;
        }

        public Criteria andIsLinkProductGreaterThan(Integer value) {
            addCriterion("is_link_product >", value, "isLinkProduct");
            return (Criteria) this;
        }

        public Criteria andIsLinkProductGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_link_product >=", value, "isLinkProduct");
            return (Criteria) this;
        }

        public Criteria andIsLinkProductLessThan(Integer value) {
            addCriterion("is_link_product <", value, "isLinkProduct");
            return (Criteria) this;
        }

        public Criteria andIsLinkProductLessThanOrEqualTo(Integer value) {
            addCriterion("is_link_product <=", value, "isLinkProduct");
            return (Criteria) this;
        }

        public Criteria andIsLinkProductIn(List<Integer> values) {
            addCriterion("is_link_product in", values, "isLinkProduct");
            return (Criteria) this;
        }

        public Criteria andIsLinkProductNotIn(List<Integer> values) {
            addCriterion("is_link_product not in", values, "isLinkProduct");
            return (Criteria) this;
        }

        public Criteria andIsLinkProductBetween(Integer value1, Integer value2) {
            addCriterion("is_link_product between", value1, value2, "isLinkProduct");
            return (Criteria) this;
        }

        public Criteria andIsLinkProductNotBetween(Integer value1, Integer value2) {
            addCriterion("is_link_product not between", value1, value2, "isLinkProduct");
            return (Criteria) this;
        }

        public Criteria andLinkUrlIsNull() {
            addCriterion("link_url is null");
            return (Criteria) this;
        }

        public Criteria andLinkUrlIsNotNull() {
            addCriterion("link_url is not null");
            return (Criteria) this;
        }

        public Criteria andLinkUrlEqualTo(String value) {
            addCriterion("link_url =", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotEqualTo(String value) {
            addCriterion("link_url <>", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlGreaterThan(String value) {
            addCriterion("link_url >", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlGreaterThanOrEqualTo(String value) {
            addCriterion("link_url >=", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlLessThan(String value) {
            addCriterion("link_url <", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlLessThanOrEqualTo(String value) {
            addCriterion("link_url <=", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlLike(String value) {
            addCriterion("link_url like", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotLike(String value) {
            addCriterion("link_url not like", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlIn(List<String> values) {
            addCriterion("link_url in", values, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotIn(List<String> values) {
            addCriterion("link_url not in", values, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlBetween(String value1, String value2) {
            addCriterion("link_url between", value1, value2, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotBetween(String value1, String value2) {
            addCriterion("link_url not between", value1, value2, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkFromIsNull() {
            addCriterion("link_from is null");
            return (Criteria) this;
        }

        public Criteria andLinkFromIsNotNull() {
            addCriterion("link_from is not null");
            return (Criteria) this;
        }

        public Criteria andLinkFromEqualTo(String value) {
            addCriterion("link_from =", value, "linkFrom");
            return (Criteria) this;
        }

        public Criteria andLinkFromNotEqualTo(String value) {
            addCriterion("link_from <>", value, "linkFrom");
            return (Criteria) this;
        }

        public Criteria andLinkFromGreaterThan(String value) {
            addCriterion("link_from >", value, "linkFrom");
            return (Criteria) this;
        }

        public Criteria andLinkFromGreaterThanOrEqualTo(String value) {
            addCriterion("link_from >=", value, "linkFrom");
            return (Criteria) this;
        }

        public Criteria andLinkFromLessThan(String value) {
            addCriterion("link_from <", value, "linkFrom");
            return (Criteria) this;
        }

        public Criteria andLinkFromLessThanOrEqualTo(String value) {
            addCriterion("link_from <=", value, "linkFrom");
            return (Criteria) this;
        }

        public Criteria andLinkFromLike(String value) {
            addCriterion("link_from like", value, "linkFrom");
            return (Criteria) this;
        }

        public Criteria andLinkFromNotLike(String value) {
            addCriterion("link_from not like", value, "linkFrom");
            return (Criteria) this;
        }

        public Criteria andLinkFromIn(List<String> values) {
            addCriterion("link_from in", values, "linkFrom");
            return (Criteria) this;
        }

        public Criteria andLinkFromNotIn(List<String> values) {
            addCriterion("link_from not in", values, "linkFrom");
            return (Criteria) this;
        }

        public Criteria andLinkFromBetween(String value1, String value2) {
            addCriterion("link_from between", value1, value2, "linkFrom");
            return (Criteria) this;
        }

        public Criteria andLinkFromNotBetween(String value1, String value2) {
            addCriterion("link_from not between", value1, value2, "linkFrom");
            return (Criteria) this;
        }

        public Criteria andTotalStoreNumIsNull() {
            addCriterion("total_store_num is null");
            return (Criteria) this;
        }

        public Criteria andTotalStoreNumIsNotNull() {
            addCriterion("total_store_num is not null");
            return (Criteria) this;
        }

        public Criteria andTotalStoreNumEqualTo(Long value) {
            addCriterion("total_store_num =", value, "totalStoreNum");
            return (Criteria) this;
        }

        public Criteria andTotalStoreNumNotEqualTo(Long value) {
            addCriterion("total_store_num <>", value, "totalStoreNum");
            return (Criteria) this;
        }

        public Criteria andTotalStoreNumGreaterThan(Long value) {
            addCriterion("total_store_num >", value, "totalStoreNum");
            return (Criteria) this;
        }

        public Criteria andTotalStoreNumGreaterThanOrEqualTo(Long value) {
            addCriterion("total_store_num >=", value, "totalStoreNum");
            return (Criteria) this;
        }

        public Criteria andTotalStoreNumLessThan(Long value) {
            addCriterion("total_store_num <", value, "totalStoreNum");
            return (Criteria) this;
        }

        public Criteria andTotalStoreNumLessThanOrEqualTo(Long value) {
            addCriterion("total_store_num <=", value, "totalStoreNum");
            return (Criteria) this;
        }

        public Criteria andTotalStoreNumIn(List<Long> values) {
            addCriterion("total_store_num in", values, "totalStoreNum");
            return (Criteria) this;
        }

        public Criteria andTotalStoreNumNotIn(List<Long> values) {
            addCriterion("total_store_num not in", values, "totalStoreNum");
            return (Criteria) this;
        }

        public Criteria andTotalStoreNumBetween(Long value1, Long value2) {
            addCriterion("total_store_num between", value1, value2, "totalStoreNum");
            return (Criteria) this;
        }

        public Criteria andTotalStoreNumNotBetween(Long value1, Long value2) {
            addCriterion("total_store_num not between", value1, value2, "totalStoreNum");
            return (Criteria) this;
        }

        public Criteria andBookStoreNumIsNull() {
            addCriterion("book_store_num is null");
            return (Criteria) this;
        }

        public Criteria andBookStoreNumIsNotNull() {
            addCriterion("book_store_num is not null");
            return (Criteria) this;
        }

        public Criteria andBookStoreNumEqualTo(Long value) {
            addCriterion("book_store_num =", value, "bookStoreNum");
            return (Criteria) this;
        }

        public Criteria andBookStoreNumNotEqualTo(Long value) {
            addCriterion("book_store_num <>", value, "bookStoreNum");
            return (Criteria) this;
        }

        public Criteria andBookStoreNumGreaterThan(Long value) {
            addCriterion("book_store_num >", value, "bookStoreNum");
            return (Criteria) this;
        }

        public Criteria andBookStoreNumGreaterThanOrEqualTo(Long value) {
            addCriterion("book_store_num >=", value, "bookStoreNum");
            return (Criteria) this;
        }

        public Criteria andBookStoreNumLessThan(Long value) {
            addCriterion("book_store_num <", value, "bookStoreNum");
            return (Criteria) this;
        }

        public Criteria andBookStoreNumLessThanOrEqualTo(Long value) {
            addCriterion("book_store_num <=", value, "bookStoreNum");
            return (Criteria) this;
        }

        public Criteria andBookStoreNumIn(List<Long> values) {
            addCriterion("book_store_num in", values, "bookStoreNum");
            return (Criteria) this;
        }

        public Criteria andBookStoreNumNotIn(List<Long> values) {
            addCriterion("book_store_num not in", values, "bookStoreNum");
            return (Criteria) this;
        }

        public Criteria andBookStoreNumBetween(Long value1, Long value2) {
            addCriterion("book_store_num between", value1, value2, "bookStoreNum");
            return (Criteria) this;
        }

        public Criteria andBookStoreNumNotBetween(Long value1, Long value2) {
            addCriterion("book_store_num not between", value1, value2, "bookStoreNum");
            return (Criteria) this;
        }

        public Criteria andSaleStatusIsNull() {
            addCriterion("sale_status is null");
            return (Criteria) this;
        }

        public Criteria andSaleStatusIsNotNull() {
            addCriterion("sale_status is not null");
            return (Criteria) this;
        }

        public Criteria andSaleStatusEqualTo(Integer value) {
            addCriterion("sale_status =", value, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusNotEqualTo(Integer value) {
            addCriterion("sale_status <>", value, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusGreaterThan(Integer value) {
            addCriterion("sale_status >", value, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_status >=", value, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusLessThan(Integer value) {
            addCriterion("sale_status <", value, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusLessThanOrEqualTo(Integer value) {
            addCriterion("sale_status <=", value, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusIn(List<Integer> values) {
            addCriterion("sale_status in", values, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusNotIn(List<Integer> values) {
            addCriterion("sale_status not in", values, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusBetween(Integer value1, Integer value2) {
            addCriterion("sale_status between", value1, value2, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andSaleStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_status not between", value1, value2, "saleStatus");
            return (Criteria) this;
        }

        public Criteria andProductDetailPicsIsNull() {
            addCriterion("product_detail_pics is null");
            return (Criteria) this;
        }

        public Criteria andProductDetailPicsIsNotNull() {
            addCriterion("product_detail_pics is not null");
            return (Criteria) this;
        }

        public Criteria andProductDetailPicsEqualTo(String value) {
            addCriterion("product_detail_pics =", value, "productDetailPics");
            return (Criteria) this;
        }

        public Criteria andProductDetailPicsNotEqualTo(String value) {
            addCriterion("product_detail_pics <>", value, "productDetailPics");
            return (Criteria) this;
        }

        public Criteria andProductDetailPicsGreaterThan(String value) {
            addCriterion("product_detail_pics >", value, "productDetailPics");
            return (Criteria) this;
        }

        public Criteria andProductDetailPicsGreaterThanOrEqualTo(String value) {
            addCriterion("product_detail_pics >=", value, "productDetailPics");
            return (Criteria) this;
        }

        public Criteria andProductDetailPicsLessThan(String value) {
            addCriterion("product_detail_pics <", value, "productDetailPics");
            return (Criteria) this;
        }

        public Criteria andProductDetailPicsLessThanOrEqualTo(String value) {
            addCriterion("product_detail_pics <=", value, "productDetailPics");
            return (Criteria) this;
        }

        public Criteria andProductDetailPicsLike(String value) {
            addCriterion("product_detail_pics like", value, "productDetailPics");
            return (Criteria) this;
        }

        public Criteria andProductDetailPicsNotLike(String value) {
            addCriterion("product_detail_pics not like", value, "productDetailPics");
            return (Criteria) this;
        }

        public Criteria andProductDetailPicsIn(List<String> values) {
            addCriterion("product_detail_pics in", values, "productDetailPics");
            return (Criteria) this;
        }

        public Criteria andProductDetailPicsNotIn(List<String> values) {
            addCriterion("product_detail_pics not in", values, "productDetailPics");
            return (Criteria) this;
        }

        public Criteria andProductDetailPicsBetween(String value1, String value2) {
            addCriterion("product_detail_pics between", value1, value2, "productDetailPics");
            return (Criteria) this;
        }

        public Criteria andProductDetailPicsNotBetween(String value1, String value2) {
            addCriterion("product_detail_pics not between", value1, value2, "productDetailPics");
            return (Criteria) this;
        }

        public Criteria andPointIsNull() {
            addCriterion("point is null");
            return (Criteria) this;
        }

        public Criteria andPointIsNotNull() {
            addCriterion("point is not null");
            return (Criteria) this;
        }

        public Criteria andPointEqualTo(String value) {
            addCriterion("point =", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotEqualTo(String value) {
            addCriterion("point <>", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointGreaterThan(String value) {
            addCriterion("point >", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointGreaterThanOrEqualTo(String value) {
            addCriterion("point >=", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLessThan(String value) {
            addCriterion("point <", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLessThanOrEqualTo(String value) {
            addCriterion("point <=", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLike(String value) {
            addCriterion("point like", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotLike(String value) {
            addCriterion("point not like", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointIn(List<String> values) {
            addCriterion("point in", values, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotIn(List<String> values) {
            addCriterion("point not in", values, "point");
            return (Criteria) this;
        }

        public Criteria andPointBetween(String value1, String value2) {
            addCriterion("point between", value1, value2, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotBetween(String value1, String value2) {
            addCriterion("point not between", value1, value2, "point");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainIsNull() {
            addCriterion("return_product_explain is null");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainIsNotNull() {
            addCriterion("return_product_explain is not null");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainEqualTo(String value) {
            addCriterion("return_product_explain =", value, "returnProductExplain");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainNotEqualTo(String value) {
            addCriterion("return_product_explain <>", value, "returnProductExplain");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainGreaterThan(String value) {
            addCriterion("return_product_explain >", value, "returnProductExplain");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainGreaterThanOrEqualTo(String value) {
            addCriterion("return_product_explain >=", value, "returnProductExplain");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainLessThan(String value) {
            addCriterion("return_product_explain <", value, "returnProductExplain");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainLessThanOrEqualTo(String value) {
            addCriterion("return_product_explain <=", value, "returnProductExplain");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainLike(String value) {
            addCriterion("return_product_explain like", value, "returnProductExplain");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainNotLike(String value) {
            addCriterion("return_product_explain not like", value, "returnProductExplain");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainIn(List<String> values) {
            addCriterion("return_product_explain in", values, "returnProductExplain");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainNotIn(List<String> values) {
            addCriterion("return_product_explain not in", values, "returnProductExplain");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainBetween(String value1, String value2) {
            addCriterion("return_product_explain between", value1, value2, "returnProductExplain");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainNotBetween(String value1, String value2) {
            addCriterion("return_product_explain not between", value1, value2, "returnProductExplain");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainPicsIsNull() {
            addCriterion("return_product_explain_pics is null");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainPicsIsNotNull() {
            addCriterion("return_product_explain_pics is not null");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainPicsEqualTo(String value) {
            addCriterion("return_product_explain_pics =", value, "returnProductExplainPics");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainPicsNotEqualTo(String value) {
            addCriterion("return_product_explain_pics <>", value, "returnProductExplainPics");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainPicsGreaterThan(String value) {
            addCriterion("return_product_explain_pics >", value, "returnProductExplainPics");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainPicsGreaterThanOrEqualTo(String value) {
            addCriterion("return_product_explain_pics >=", value, "returnProductExplainPics");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainPicsLessThan(String value) {
            addCriterion("return_product_explain_pics <", value, "returnProductExplainPics");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainPicsLessThanOrEqualTo(String value) {
            addCriterion("return_product_explain_pics <=", value, "returnProductExplainPics");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainPicsLike(String value) {
            addCriterion("return_product_explain_pics like", value, "returnProductExplainPics");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainPicsNotLike(String value) {
            addCriterion("return_product_explain_pics not like", value, "returnProductExplainPics");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainPicsIn(List<String> values) {
            addCriterion("return_product_explain_pics in", values, "returnProductExplainPics");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainPicsNotIn(List<String> values) {
            addCriterion("return_product_explain_pics not in", values, "returnProductExplainPics");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainPicsBetween(String value1, String value2) {
            addCriterion("return_product_explain_pics between", value1, value2, "returnProductExplainPics");
            return (Criteria) this;
        }

        public Criteria andReturnProductExplainPicsNotBetween(String value1, String value2) {
            addCriterion("return_product_explain_pics not between", value1, value2, "returnProductExplainPics");
            return (Criteria) this;
        }

        public Criteria andWordsIsNull() {
            addCriterion("words is null");
            return (Criteria) this;
        }

        public Criteria andWordsIsNotNull() {
            addCriterion("words is not null");
            return (Criteria) this;
        }

        public Criteria andWordsEqualTo(String value) {
            addCriterion("words =", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsNotEqualTo(String value) {
            addCriterion("words <>", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsGreaterThan(String value) {
            addCriterion("words >", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsGreaterThanOrEqualTo(String value) {
            addCriterion("words >=", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsLessThan(String value) {
            addCriterion("words <", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsLessThanOrEqualTo(String value) {
            addCriterion("words <=", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsLike(String value) {
            addCriterion("words like", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsNotLike(String value) {
            addCriterion("words not like", value, "words");
            return (Criteria) this;
        }

        public Criteria andWordsIn(List<String> values) {
            addCriterion("words in", values, "words");
            return (Criteria) this;
        }

        public Criteria andWordsNotIn(List<String> values) {
            addCriterion("words not in", values, "words");
            return (Criteria) this;
        }

        public Criteria andWordsBetween(String value1, String value2) {
            addCriterion("words between", value1, value2, "words");
            return (Criteria) this;
        }

        public Criteria andWordsNotBetween(String value1, String value2) {
            addCriterion("words not between", value1, value2, "words");
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