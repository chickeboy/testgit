package com.owen.wxtoken;

import java.util.ArrayList;
import java.util.List;

public class Access_TokenExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Access_TokenExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAccessTokenIsNull() {
            addCriterion("access_token is null");
            return (Criteria) this;
        }

        public Criteria andAccessTokenIsNotNull() {
            addCriterion("access_token is not null");
            return (Criteria) this;
        }

        public Criteria andAccessTokenEqualTo(String value) {
            addCriterion("access_token =", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotEqualTo(String value) {
            addCriterion("access_token <>", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenGreaterThan(String value) {
            addCriterion("access_token >", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenGreaterThanOrEqualTo(String value) {
            addCriterion("access_token >=", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenLessThan(String value) {
            addCriterion("access_token <", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenLessThanOrEqualTo(String value) {
            addCriterion("access_token <=", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenLike(String value) {
            addCriterion("access_token like", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotLike(String value) {
            addCriterion("access_token not like", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenIn(List<String> values) {
            addCriterion("access_token in", values, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotIn(List<String> values) {
            addCriterion("access_token not in", values, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenBetween(String value1, String value2) {
            addCriterion("access_token between", value1, value2, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotBetween(String value1, String value2) {
            addCriterion("access_token not between", value1, value2, "accessToken");
            return (Criteria) this;
        }

        public Criteria andExpireInIsNull() {
            addCriterion("expire_in is null");
            return (Criteria) this;
        }

        public Criteria andExpireInIsNotNull() {
            addCriterion("expire_in is not null");
            return (Criteria) this;
        }

        public Criteria andExpireInEqualTo(String value) {
            addCriterion("expire_in =", value, "expireIn");
            return (Criteria) this;
        }

        public Criteria andExpireInNotEqualTo(String value) {
            addCriterion("expire_in <>", value, "expireIn");
            return (Criteria) this;
        }

        public Criteria andExpireInGreaterThan(String value) {
            addCriterion("expire_in >", value, "expireIn");
            return (Criteria) this;
        }

        public Criteria andExpireInGreaterThanOrEqualTo(String value) {
            addCriterion("expire_in >=", value, "expireIn");
            return (Criteria) this;
        }

        public Criteria andExpireInLessThan(String value) {
            addCriterion("expire_in <", value, "expireIn");
            return (Criteria) this;
        }

        public Criteria andExpireInLessThanOrEqualTo(String value) {
            addCriterion("expire_in <=", value, "expireIn");
            return (Criteria) this;
        }

        public Criteria andExpireInLike(String value) {
            addCriterion("expire_in like", value, "expireIn");
            return (Criteria) this;
        }

        public Criteria andExpireInNotLike(String value) {
            addCriterion("expire_in not like", value, "expireIn");
            return (Criteria) this;
        }

        public Criteria andExpireInIn(List<String> values) {
            addCriterion("expire_in in", values, "expireIn");
            return (Criteria) this;
        }

        public Criteria andExpireInNotIn(List<String> values) {
            addCriterion("expire_in not in", values, "expireIn");
            return (Criteria) this;
        }

        public Criteria andExpireInBetween(String value1, String value2) {
            addCriterion("expire_in between", value1, value2, "expireIn");
            return (Criteria) this;
        }

        public Criteria andExpireInNotBetween(String value1, String value2) {
            addCriterion("expire_in not between", value1, value2, "expireIn");
            return (Criteria) this;
        }

        public Criteria andExpireOutIsNull() {
            addCriterion("expire_out is null");
            return (Criteria) this;
        }

        public Criteria andExpireOutIsNotNull() {
            addCriterion("expire_out is not null");
            return (Criteria) this;
        }

        public Criteria andExpireOutEqualTo(String value) {
            addCriterion("expire_out =", value, "expireOut");
            return (Criteria) this;
        }

        public Criteria andExpireOutNotEqualTo(String value) {
            addCriterion("expire_out <>", value, "expireOut");
            return (Criteria) this;
        }

        public Criteria andExpireOutGreaterThan(String value) {
            addCriterion("expire_out >", value, "expireOut");
            return (Criteria) this;
        }

        public Criteria andExpireOutGreaterThanOrEqualTo(String value) {
            addCriterion("expire_out >=", value, "expireOut");
            return (Criteria) this;
        }

        public Criteria andExpireOutLessThan(String value) {
            addCriterion("expire_out <", value, "expireOut");
            return (Criteria) this;
        }

        public Criteria andExpireOutLessThanOrEqualTo(String value) {
            addCriterion("expire_out <=", value, "expireOut");
            return (Criteria) this;
        }

        public Criteria andExpireOutLike(String value) {
            addCriterion("expire_out like", value, "expireOut");
            return (Criteria) this;
        }

        public Criteria andExpireOutNotLike(String value) {
            addCriterion("expire_out not like", value, "expireOut");
            return (Criteria) this;
        }

        public Criteria andExpireOutIn(List<String> values) {
            addCriterion("expire_out in", values, "expireOut");
            return (Criteria) this;
        }

        public Criteria andExpireOutNotIn(List<String> values) {
            addCriterion("expire_out not in", values, "expireOut");
            return (Criteria) this;
        }

        public Criteria andExpireOutBetween(String value1, String value2) {
            addCriterion("expire_out between", value1, value2, "expireOut");
            return (Criteria) this;
        }

        public Criteria andExpireOutNotBetween(String value1, String value2) {
            addCriterion("expire_out not between", value1, value2, "expireOut");
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