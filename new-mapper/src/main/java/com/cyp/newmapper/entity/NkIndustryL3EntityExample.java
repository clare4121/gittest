package com.cyp.newmapper.entity;

import java.util.ArrayList;
import java.util.List;

public class NkIndustryL3EntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Boolean forUpdate;

    public NkIndustryL3EntityExample() {
        oredCriteria = new ArrayList<>();
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

    public void setForUpdate(Boolean forUpdate) {
        this.forUpdate = forUpdate;
    }

    public Boolean getForUpdate() {
        return forUpdate;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andNkIndustryL1IsNull() {
            addCriterion("NK_INDUSTRY_L1 is null");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1IsNotNull() {
            addCriterion("NK_INDUSTRY_L1 is not null");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1EqualTo(String value) {
            addCriterion("NK_INDUSTRY_L1 =", value, "nkIndustryL1");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1NotEqualTo(String value) {
            addCriterion("NK_INDUSTRY_L1 <>", value, "nkIndustryL1");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1GreaterThan(String value) {
            addCriterion("NK_INDUSTRY_L1 >", value, "nkIndustryL1");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1GreaterThanOrEqualTo(String value) {
            addCriterion("NK_INDUSTRY_L1 >=", value, "nkIndustryL1");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1LessThan(String value) {
            addCriterion("NK_INDUSTRY_L1 <", value, "nkIndustryL1");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1LessThanOrEqualTo(String value) {
            addCriterion("NK_INDUSTRY_L1 <=", value, "nkIndustryL1");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1Like(String value) {
            addCriterion("NK_INDUSTRY_L1 like", value, "nkIndustryL1");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1NotLike(String value) {
            addCriterion("NK_INDUSTRY_L1 not like", value, "nkIndustryL1");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1In(List<String> values) {
            addCriterion("NK_INDUSTRY_L1 in", values, "nkIndustryL1");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1NotIn(List<String> values) {
            addCriterion("NK_INDUSTRY_L1 not in", values, "nkIndustryL1");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1Between(String value1, String value2) {
            addCriterion("NK_INDUSTRY_L1 between", value1, value2, "nkIndustryL1");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1NotBetween(String value1, String value2) {
            addCriterion("NK_INDUSTRY_L1 not between", value1, value2, "nkIndustryL1");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2IsNull() {
            addCriterion("NK_INDUSTRY_L2 is null");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2IsNotNull() {
            addCriterion("NK_INDUSTRY_L2 is not null");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2EqualTo(String value) {
            addCriterion("NK_INDUSTRY_L2 =", value, "nkIndustryL2");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2NotEqualTo(String value) {
            addCriterion("NK_INDUSTRY_L2 <>", value, "nkIndustryL2");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2GreaterThan(String value) {
            addCriterion("NK_INDUSTRY_L2 >", value, "nkIndustryL2");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2GreaterThanOrEqualTo(String value) {
            addCriterion("NK_INDUSTRY_L2 >=", value, "nkIndustryL2");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2LessThan(String value) {
            addCriterion("NK_INDUSTRY_L2 <", value, "nkIndustryL2");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2LessThanOrEqualTo(String value) {
            addCriterion("NK_INDUSTRY_L2 <=", value, "nkIndustryL2");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2Like(String value) {
            addCriterion("NK_INDUSTRY_L2 like", value, "nkIndustryL2");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2NotLike(String value) {
            addCriterion("NK_INDUSTRY_L2 not like", value, "nkIndustryL2");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2In(List<String> values) {
            addCriterion("NK_INDUSTRY_L2 in", values, "nkIndustryL2");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2NotIn(List<String> values) {
            addCriterion("NK_INDUSTRY_L2 not in", values, "nkIndustryL2");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2Between(String value1, String value2) {
            addCriterion("NK_INDUSTRY_L2 between", value1, value2, "nkIndustryL2");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2NotBetween(String value1, String value2) {
            addCriterion("NK_INDUSTRY_L2 not between", value1, value2, "nkIndustryL2");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3IsNull() {
            addCriterion("NK_INDUSTRY_L3 is null");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3IsNotNull() {
            addCriterion("NK_INDUSTRY_L3 is not null");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3EqualTo(String value) {
            addCriterion("NK_INDUSTRY_L3 =", value, "nkIndustryL3");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3NotEqualTo(String value) {
            addCriterion("NK_INDUSTRY_L3 <>", value, "nkIndustryL3");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3GreaterThan(String value) {
            addCriterion("NK_INDUSTRY_L3 >", value, "nkIndustryL3");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3GreaterThanOrEqualTo(String value) {
            addCriterion("NK_INDUSTRY_L3 >=", value, "nkIndustryL3");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3LessThan(String value) {
            addCriterion("NK_INDUSTRY_L3 <", value, "nkIndustryL3");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3LessThanOrEqualTo(String value) {
            addCriterion("NK_INDUSTRY_L3 <=", value, "nkIndustryL3");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3Like(String value) {
            addCriterion("NK_INDUSTRY_L3 like", value, "nkIndustryL3");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3NotLike(String value) {
            addCriterion("NK_INDUSTRY_L3 not like", value, "nkIndustryL3");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3In(List<String> values) {
            addCriterion("NK_INDUSTRY_L3 in", values, "nkIndustryL3");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3NotIn(List<String> values) {
            addCriterion("NK_INDUSTRY_L3 not in", values, "nkIndustryL3");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3Between(String value1, String value2) {
            addCriterion("NK_INDUSTRY_L3 between", value1, value2, "nkIndustryL3");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3NotBetween(String value1, String value2) {
            addCriterion("NK_INDUSTRY_L3 not between", value1, value2, "nkIndustryL3");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1NameIsNull() {
            addCriterion("NK_INDUSTRY_L1_NAME is null");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1NameIsNotNull() {
            addCriterion("NK_INDUSTRY_L1_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1NameEqualTo(String value) {
            addCriterion("NK_INDUSTRY_L1_NAME =", value, "nkIndustryL1Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1NameNotEqualTo(String value) {
            addCriterion("NK_INDUSTRY_L1_NAME <>", value, "nkIndustryL1Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1NameGreaterThan(String value) {
            addCriterion("NK_INDUSTRY_L1_NAME >", value, "nkIndustryL1Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1NameGreaterThanOrEqualTo(String value) {
            addCriterion("NK_INDUSTRY_L1_NAME >=", value, "nkIndustryL1Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1NameLessThan(String value) {
            addCriterion("NK_INDUSTRY_L1_NAME <", value, "nkIndustryL1Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1NameLessThanOrEqualTo(String value) {
            addCriterion("NK_INDUSTRY_L1_NAME <=", value, "nkIndustryL1Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1NameLike(String value) {
            addCriterion("NK_INDUSTRY_L1_NAME like", value, "nkIndustryL1Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1NameNotLike(String value) {
            addCriterion("NK_INDUSTRY_L1_NAME not like", value, "nkIndustryL1Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1NameIn(List<String> values) {
            addCriterion("NK_INDUSTRY_L1_NAME in", values, "nkIndustryL1Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1NameNotIn(List<String> values) {
            addCriterion("NK_INDUSTRY_L1_NAME not in", values, "nkIndustryL1Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1NameBetween(String value1, String value2) {
            addCriterion("NK_INDUSTRY_L1_NAME between", value1, value2, "nkIndustryL1Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL1NameNotBetween(String value1, String value2) {
            addCriterion("NK_INDUSTRY_L1_NAME not between", value1, value2, "nkIndustryL1Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2NameIsNull() {
            addCriterion("NK_INDUSTRY_L2_NAME is null");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2NameIsNotNull() {
            addCriterion("NK_INDUSTRY_L2_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2NameEqualTo(String value) {
            addCriterion("NK_INDUSTRY_L2_NAME =", value, "nkIndustryL2Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2NameNotEqualTo(String value) {
            addCriterion("NK_INDUSTRY_L2_NAME <>", value, "nkIndustryL2Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2NameGreaterThan(String value) {
            addCriterion("NK_INDUSTRY_L2_NAME >", value, "nkIndustryL2Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2NameGreaterThanOrEqualTo(String value) {
            addCriterion("NK_INDUSTRY_L2_NAME >=", value, "nkIndustryL2Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2NameLessThan(String value) {
            addCriterion("NK_INDUSTRY_L2_NAME <", value, "nkIndustryL2Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2NameLessThanOrEqualTo(String value) {
            addCriterion("NK_INDUSTRY_L2_NAME <=", value, "nkIndustryL2Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2NameLike(String value) {
            addCriterion("NK_INDUSTRY_L2_NAME like", value, "nkIndustryL2Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2NameNotLike(String value) {
            addCriterion("NK_INDUSTRY_L2_NAME not like", value, "nkIndustryL2Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2NameIn(List<String> values) {
            addCriterion("NK_INDUSTRY_L2_NAME in", values, "nkIndustryL2Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2NameNotIn(List<String> values) {
            addCriterion("NK_INDUSTRY_L2_NAME not in", values, "nkIndustryL2Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2NameBetween(String value1, String value2) {
            addCriterion("NK_INDUSTRY_L2_NAME between", value1, value2, "nkIndustryL2Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL2NameNotBetween(String value1, String value2) {
            addCriterion("NK_INDUSTRY_L2_NAME not between", value1, value2, "nkIndustryL2Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3NameIsNull() {
            addCriterion("NK_INDUSTRY_L3_NAME is null");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3NameIsNotNull() {
            addCriterion("NK_INDUSTRY_L3_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3NameEqualTo(String value) {
            addCriterion("NK_INDUSTRY_L3_NAME =", value, "nkIndustryL3Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3NameNotEqualTo(String value) {
            addCriterion("NK_INDUSTRY_L3_NAME <>", value, "nkIndustryL3Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3NameGreaterThan(String value) {
            addCriterion("NK_INDUSTRY_L3_NAME >", value, "nkIndustryL3Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3NameGreaterThanOrEqualTo(String value) {
            addCriterion("NK_INDUSTRY_L3_NAME >=", value, "nkIndustryL3Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3NameLessThan(String value) {
            addCriterion("NK_INDUSTRY_L3_NAME <", value, "nkIndustryL3Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3NameLessThanOrEqualTo(String value) {
            addCriterion("NK_INDUSTRY_L3_NAME <=", value, "nkIndustryL3Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3NameLike(String value) {
            addCriterion("NK_INDUSTRY_L3_NAME like", value, "nkIndustryL3Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3NameNotLike(String value) {
            addCriterion("NK_INDUSTRY_L3_NAME not like", value, "nkIndustryL3Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3NameIn(List<String> values) {
            addCriterion("NK_INDUSTRY_L3_NAME in", values, "nkIndustryL3Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3NameNotIn(List<String> values) {
            addCriterion("NK_INDUSTRY_L3_NAME not in", values, "nkIndustryL3Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3NameBetween(String value1, String value2) {
            addCriterion("NK_INDUSTRY_L3_NAME between", value1, value2, "nkIndustryL3Name");
            return (Criteria) this;
        }

        public Criteria andNkIndustryL3NameNotBetween(String value1, String value2) {
            addCriterion("NK_INDUSTRY_L3_NAME not between", value1, value2, "nkIndustryL3Name");
            return (Criteria) this;
        }
    }

    /**
     */
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