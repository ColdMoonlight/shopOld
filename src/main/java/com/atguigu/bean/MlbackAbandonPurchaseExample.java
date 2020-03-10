package com.atguigu.bean;

import java.util.ArrayList;
import java.util.List;

public class MlbackAbandonPurchaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MlbackAbandonPurchaseExample() {
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

        public Criteria andAbandonpurchaseIdIsNull() {
            addCriterion("abandonPurchase_id is null");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseIdIsNotNull() {
            addCriterion("abandonPurchase_id is not null");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseIdEqualTo(Integer value) {
            addCriterion("abandonPurchase_id =", value, "abandonpurchaseId");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseIdNotEqualTo(Integer value) {
            addCriterion("abandonPurchase_id <>", value, "abandonpurchaseId");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseIdGreaterThan(Integer value) {
            addCriterion("abandonPurchase_id >", value, "abandonpurchaseId");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("abandonPurchase_id >=", value, "abandonpurchaseId");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseIdLessThan(Integer value) {
            addCriterion("abandonPurchase_id <", value, "abandonpurchaseId");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseIdLessThanOrEqualTo(Integer value) {
            addCriterion("abandonPurchase_id <=", value, "abandonpurchaseId");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseIdIn(List<Integer> values) {
            addCriterion("abandonPurchase_id in", values, "abandonpurchaseId");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseIdNotIn(List<Integer> values) {
            addCriterion("abandonPurchase_id not in", values, "abandonpurchaseId");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseIdBetween(Integer value1, Integer value2) {
            addCriterion("abandonPurchase_id between", value1, value2, "abandonpurchaseId");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("abandonPurchase_id not between", value1, value2, "abandonpurchaseId");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseActivedetailIsNull() {
            addCriterion("abandonPurchase_activeDetail is null");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseActivedetailIsNotNull() {
            addCriterion("abandonPurchase_activeDetail is not null");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseActivedetailEqualTo(String value) {
            addCriterion("abandonPurchase_activeDetail =", value, "abandonpurchaseActivedetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseActivedetailNotEqualTo(String value) {
            addCriterion("abandonPurchase_activeDetail <>", value, "abandonpurchaseActivedetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseActivedetailGreaterThan(String value) {
            addCriterion("abandonPurchase_activeDetail >", value, "abandonpurchaseActivedetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseActivedetailGreaterThanOrEqualTo(String value) {
            addCriterion("abandonPurchase_activeDetail >=", value, "abandonpurchaseActivedetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseActivedetailLessThan(String value) {
            addCriterion("abandonPurchase_activeDetail <", value, "abandonpurchaseActivedetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseActivedetailLessThanOrEqualTo(String value) {
            addCriterion("abandonPurchase_activeDetail <=", value, "abandonpurchaseActivedetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseActivedetailLike(String value) {
            addCriterion("abandonPurchase_activeDetail like", value, "abandonpurchaseActivedetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseActivedetailNotLike(String value) {
            addCriterion("abandonPurchase_activeDetail not like", value, "abandonpurchaseActivedetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseActivedetailIn(List<String> values) {
            addCriterion("abandonPurchase_activeDetail in", values, "abandonpurchaseActivedetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseActivedetailNotIn(List<String> values) {
            addCriterion("abandonPurchase_activeDetail not in", values, "abandonpurchaseActivedetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseActivedetailBetween(String value1, String value2) {
            addCriterion("abandonPurchase_activeDetail between", value1, value2, "abandonpurchaseActivedetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseActivedetailNotBetween(String value1, String value2) {
            addCriterion("abandonPurchase_activeDetail not between", value1, value2, "abandonpurchaseActivedetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCoupondetailIsNull() {
            addCriterion("abandonPurchase_couponDetail is null");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCoupondetailIsNotNull() {
            addCriterion("abandonPurchase_couponDetail is not null");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCoupondetailEqualTo(String value) {
            addCriterion("abandonPurchase_couponDetail =", value, "abandonpurchaseCoupondetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCoupondetailNotEqualTo(String value) {
            addCriterion("abandonPurchase_couponDetail <>", value, "abandonpurchaseCoupondetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCoupondetailGreaterThan(String value) {
            addCriterion("abandonPurchase_couponDetail >", value, "abandonpurchaseCoupondetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCoupondetailGreaterThanOrEqualTo(String value) {
            addCriterion("abandonPurchase_couponDetail >=", value, "abandonpurchaseCoupondetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCoupondetailLessThan(String value) {
            addCriterion("abandonPurchase_couponDetail <", value, "abandonpurchaseCoupondetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCoupondetailLessThanOrEqualTo(String value) {
            addCriterion("abandonPurchase_couponDetail <=", value, "abandonpurchaseCoupondetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCoupondetailLike(String value) {
            addCriterion("abandonPurchase_couponDetail like", value, "abandonpurchaseCoupondetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCoupondetailNotLike(String value) {
            addCriterion("abandonPurchase_couponDetail not like", value, "abandonpurchaseCoupondetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCoupondetailIn(List<String> values) {
            addCriterion("abandonPurchase_couponDetail in", values, "abandonpurchaseCoupondetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCoupondetailNotIn(List<String> values) {
            addCriterion("abandonPurchase_couponDetail not in", values, "abandonpurchaseCoupondetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCoupondetailBetween(String value1, String value2) {
            addCriterion("abandonPurchase_couponDetail between", value1, value2, "abandonpurchaseCoupondetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCoupondetailNotBetween(String value1, String value2) {
            addCriterion("abandonPurchase_couponDetail not between", value1, value2, "abandonpurchaseCoupondetail");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseStatusIsNull() {
            addCriterion("abandonPurchase_status is null");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseStatusIsNotNull() {
            addCriterion("abandonPurchase_status is not null");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseStatusEqualTo(Integer value) {
            addCriterion("abandonPurchase_status =", value, "abandonpurchaseStatus");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseStatusNotEqualTo(Integer value) {
            addCriterion("abandonPurchase_status <>", value, "abandonpurchaseStatus");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseStatusGreaterThan(Integer value) {
            addCriterion("abandonPurchase_status >", value, "abandonpurchaseStatus");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("abandonPurchase_status >=", value, "abandonpurchaseStatus");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseStatusLessThan(Integer value) {
            addCriterion("abandonPurchase_status <", value, "abandonpurchaseStatus");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseStatusLessThanOrEqualTo(Integer value) {
            addCriterion("abandonPurchase_status <=", value, "abandonpurchaseStatus");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseStatusIn(List<Integer> values) {
            addCriterion("abandonPurchase_status in", values, "abandonpurchaseStatus");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseStatusNotIn(List<Integer> values) {
            addCriterion("abandonPurchase_status not in", values, "abandonpurchaseStatus");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseStatusBetween(Integer value1, Integer value2) {
            addCriterion("abandonPurchase_status between", value1, value2, "abandonpurchaseStatus");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("abandonPurchase_status not between", value1, value2, "abandonpurchaseStatus");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCreatetimeIsNull() {
            addCriterion("abandonPurchase_createTime is null");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCreatetimeIsNotNull() {
            addCriterion("abandonPurchase_createTime is not null");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCreatetimeEqualTo(String value) {
            addCriterion("abandonPurchase_createTime =", value, "abandonpurchaseCreatetime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCreatetimeNotEqualTo(String value) {
            addCriterion("abandonPurchase_createTime <>", value, "abandonpurchaseCreatetime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCreatetimeGreaterThan(String value) {
            addCriterion("abandonPurchase_createTime >", value, "abandonpurchaseCreatetime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("abandonPurchase_createTime >=", value, "abandonpurchaseCreatetime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCreatetimeLessThan(String value) {
            addCriterion("abandonPurchase_createTime <", value, "abandonpurchaseCreatetime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("abandonPurchase_createTime <=", value, "abandonpurchaseCreatetime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCreatetimeLike(String value) {
            addCriterion("abandonPurchase_createTime like", value, "abandonpurchaseCreatetime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCreatetimeNotLike(String value) {
            addCriterion("abandonPurchase_createTime not like", value, "abandonpurchaseCreatetime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCreatetimeIn(List<String> values) {
            addCriterion("abandonPurchase_createTime in", values, "abandonpurchaseCreatetime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCreatetimeNotIn(List<String> values) {
            addCriterion("abandonPurchase_createTime not in", values, "abandonpurchaseCreatetime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCreatetimeBetween(String value1, String value2) {
            addCriterion("abandonPurchase_createTime between", value1, value2, "abandonpurchaseCreatetime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseCreatetimeNotBetween(String value1, String value2) {
            addCriterion("abandonPurchase_createTime not between", value1, value2, "abandonpurchaseCreatetime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseMotifytimeIsNull() {
            addCriterion("abandonPurchase_motifyTime is null");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseMotifytimeIsNotNull() {
            addCriterion("abandonPurchase_motifyTime is not null");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseMotifytimeEqualTo(String value) {
            addCriterion("abandonPurchase_motifyTime =", value, "abandonpurchaseMotifytime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseMotifytimeNotEqualTo(String value) {
            addCriterion("abandonPurchase_motifyTime <>", value, "abandonpurchaseMotifytime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseMotifytimeGreaterThan(String value) {
            addCriterion("abandonPurchase_motifyTime >", value, "abandonpurchaseMotifytime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseMotifytimeGreaterThanOrEqualTo(String value) {
            addCriterion("abandonPurchase_motifyTime >=", value, "abandonpurchaseMotifytime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseMotifytimeLessThan(String value) {
            addCriterion("abandonPurchase_motifyTime <", value, "abandonpurchaseMotifytime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseMotifytimeLessThanOrEqualTo(String value) {
            addCriterion("abandonPurchase_motifyTime <=", value, "abandonpurchaseMotifytime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseMotifytimeLike(String value) {
            addCriterion("abandonPurchase_motifyTime like", value, "abandonpurchaseMotifytime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseMotifytimeNotLike(String value) {
            addCriterion("abandonPurchase_motifyTime not like", value, "abandonpurchaseMotifytime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseMotifytimeIn(List<String> values) {
            addCriterion("abandonPurchase_motifyTime in", values, "abandonpurchaseMotifytime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseMotifytimeNotIn(List<String> values) {
            addCriterion("abandonPurchase_motifyTime not in", values, "abandonpurchaseMotifytime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseMotifytimeBetween(String value1, String value2) {
            addCriterion("abandonPurchase_motifyTime between", value1, value2, "abandonpurchaseMotifytime");
            return (Criteria) this;
        }

        public Criteria andAbandonpurchaseMotifytimeNotBetween(String value1, String value2) {
            addCriterion("abandonPurchase_motifyTime not between", value1, value2, "abandonpurchaseMotifytime");
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