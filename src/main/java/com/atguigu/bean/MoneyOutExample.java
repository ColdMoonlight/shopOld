package com.atguigu.bean;

import java.util.ArrayList;
import java.util.List;

public class MoneyOutExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MoneyOutExample() {
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

        public Criteria andMoneyoutIdIsNull() {
            addCriterion("moneyout_id is null");
            return (Criteria) this;
        }

        public Criteria andMoneyoutIdIsNotNull() {
            addCriterion("moneyout_id is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyoutIdEqualTo(Integer value) {
            addCriterion("moneyout_id =", value, "moneyoutId");
            return (Criteria) this;
        }

        public Criteria andMoneyoutIdNotEqualTo(Integer value) {
            addCriterion("moneyout_id <>", value, "moneyoutId");
            return (Criteria) this;
        }

        public Criteria andMoneyoutIdGreaterThan(Integer value) {
            addCriterion("moneyout_id >", value, "moneyoutId");
            return (Criteria) this;
        }

        public Criteria andMoneyoutIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("moneyout_id >=", value, "moneyoutId");
            return (Criteria) this;
        }

        public Criteria andMoneyoutIdLessThan(Integer value) {
            addCriterion("moneyout_id <", value, "moneyoutId");
            return (Criteria) this;
        }

        public Criteria andMoneyoutIdLessThanOrEqualTo(Integer value) {
            addCriterion("moneyout_id <=", value, "moneyoutId");
            return (Criteria) this;
        }

        public Criteria andMoneyoutIdIn(List<Integer> values) {
            addCriterion("moneyout_id in", values, "moneyoutId");
            return (Criteria) this;
        }

        public Criteria andMoneyoutIdNotIn(List<Integer> values) {
            addCriterion("moneyout_id not in", values, "moneyoutId");
            return (Criteria) this;
        }

        public Criteria andMoneyoutIdBetween(Integer value1, Integer value2) {
            addCriterion("moneyout_id between", value1, value2, "moneyoutId");
            return (Criteria) this;
        }

        public Criteria andMoneyoutIdNotBetween(Integer value1, Integer value2) {
            addCriterion("moneyout_id not between", value1, value2, "moneyoutId");
            return (Criteria) this;
        }

        public Criteria andMoneyoutAccountidIsNull() {
            addCriterion("moneyout_accountid is null");
            return (Criteria) this;
        }

        public Criteria andMoneyoutAccountidIsNotNull() {
            addCriterion("moneyout_accountid is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyoutAccountidEqualTo(Integer value) {
            addCriterion("moneyout_accountid =", value, "moneyoutAccountid");
            return (Criteria) this;
        }

        public Criteria andMoneyoutAccountidNotEqualTo(Integer value) {
            addCriterion("moneyout_accountid <>", value, "moneyoutAccountid");
            return (Criteria) this;
        }

        public Criteria andMoneyoutAccountidGreaterThan(Integer value) {
            addCriterion("moneyout_accountid >", value, "moneyoutAccountid");
            return (Criteria) this;
        }

        public Criteria andMoneyoutAccountidGreaterThanOrEqualTo(Integer value) {
            addCriterion("moneyout_accountid >=", value, "moneyoutAccountid");
            return (Criteria) this;
        }

        public Criteria andMoneyoutAccountidLessThan(Integer value) {
            addCriterion("moneyout_accountid <", value, "moneyoutAccountid");
            return (Criteria) this;
        }

        public Criteria andMoneyoutAccountidLessThanOrEqualTo(Integer value) {
            addCriterion("moneyout_accountid <=", value, "moneyoutAccountid");
            return (Criteria) this;
        }

        public Criteria andMoneyoutAccountidIn(List<Integer> values) {
            addCriterion("moneyout_accountid in", values, "moneyoutAccountid");
            return (Criteria) this;
        }

        public Criteria andMoneyoutAccountidNotIn(List<Integer> values) {
            addCriterion("moneyout_accountid not in", values, "moneyoutAccountid");
            return (Criteria) this;
        }

        public Criteria andMoneyoutAccountidBetween(Integer value1, Integer value2) {
            addCriterion("moneyout_accountid between", value1, value2, "moneyoutAccountid");
            return (Criteria) this;
        }

        public Criteria andMoneyoutAccountidNotBetween(Integer value1, Integer value2) {
            addCriterion("moneyout_accountid not between", value1, value2, "moneyoutAccountid");
            return (Criteria) this;
        }

        public Criteria andMoneyoutUdidIsNull() {
            addCriterion("moneyout_udid is null");
            return (Criteria) this;
        }

        public Criteria andMoneyoutUdidIsNotNull() {
            addCriterion("moneyout_udid is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyoutUdidEqualTo(String value) {
            addCriterion("moneyout_udid =", value, "moneyoutUdid");
            return (Criteria) this;
        }

        public Criteria andMoneyoutUdidNotEqualTo(String value) {
            addCriterion("moneyout_udid <>", value, "moneyoutUdid");
            return (Criteria) this;
        }

        public Criteria andMoneyoutUdidGreaterThan(String value) {
            addCriterion("moneyout_udid >", value, "moneyoutUdid");
            return (Criteria) this;
        }

        public Criteria andMoneyoutUdidGreaterThanOrEqualTo(String value) {
            addCriterion("moneyout_udid >=", value, "moneyoutUdid");
            return (Criteria) this;
        }

        public Criteria andMoneyoutUdidLessThan(String value) {
            addCriterion("moneyout_udid <", value, "moneyoutUdid");
            return (Criteria) this;
        }

        public Criteria andMoneyoutUdidLessThanOrEqualTo(String value) {
            addCriterion("moneyout_udid <=", value, "moneyoutUdid");
            return (Criteria) this;
        }

        public Criteria andMoneyoutUdidLike(String value) {
            addCriterion("moneyout_udid like", value, "moneyoutUdid");
            return (Criteria) this;
        }

        public Criteria andMoneyoutUdidNotLike(String value) {
            addCriterion("moneyout_udid not like", value, "moneyoutUdid");
            return (Criteria) this;
        }

        public Criteria andMoneyoutUdidIn(List<String> values) {
            addCriterion("moneyout_udid in", values, "moneyoutUdid");
            return (Criteria) this;
        }

        public Criteria andMoneyoutUdidNotIn(List<String> values) {
            addCriterion("moneyout_udid not in", values, "moneyoutUdid");
            return (Criteria) this;
        }

        public Criteria andMoneyoutUdidBetween(String value1, String value2) {
            addCriterion("moneyout_udid between", value1, value2, "moneyoutUdid");
            return (Criteria) this;
        }

        public Criteria andMoneyoutUdidNotBetween(String value1, String value2) {
            addCriterion("moneyout_udid not between", value1, value2, "moneyoutUdid");
            return (Criteria) this;
        }

        public Criteria andMoneyoutPriceOnceIsNull() {
            addCriterion("moneyout_price_once is null");
            return (Criteria) this;
        }

        public Criteria andMoneyoutPriceOnceIsNotNull() {
            addCriterion("moneyout_price_once is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyoutPriceOnceEqualTo(String value) {
            addCriterion("moneyout_price_once =", value, "moneyoutPriceOnce");
            return (Criteria) this;
        }

        public Criteria andMoneyoutPriceOnceNotEqualTo(String value) {
            addCriterion("moneyout_price_once <>", value, "moneyoutPriceOnce");
            return (Criteria) this;
        }

        public Criteria andMoneyoutPriceOnceGreaterThan(String value) {
            addCriterion("moneyout_price_once >", value, "moneyoutPriceOnce");
            return (Criteria) this;
        }

        public Criteria andMoneyoutPriceOnceGreaterThanOrEqualTo(String value) {
            addCriterion("moneyout_price_once >=", value, "moneyoutPriceOnce");
            return (Criteria) this;
        }

        public Criteria andMoneyoutPriceOnceLessThan(String value) {
            addCriterion("moneyout_price_once <", value, "moneyoutPriceOnce");
            return (Criteria) this;
        }

        public Criteria andMoneyoutPriceOnceLessThanOrEqualTo(String value) {
            addCriterion("moneyout_price_once <=", value, "moneyoutPriceOnce");
            return (Criteria) this;
        }

        public Criteria andMoneyoutPriceOnceLike(String value) {
            addCriterion("moneyout_price_once like", value, "moneyoutPriceOnce");
            return (Criteria) this;
        }

        public Criteria andMoneyoutPriceOnceNotLike(String value) {
            addCriterion("moneyout_price_once not like", value, "moneyoutPriceOnce");
            return (Criteria) this;
        }

        public Criteria andMoneyoutPriceOnceIn(List<String> values) {
            addCriterion("moneyout_price_once in", values, "moneyoutPriceOnce");
            return (Criteria) this;
        }

        public Criteria andMoneyoutPriceOnceNotIn(List<String> values) {
            addCriterion("moneyout_price_once not in", values, "moneyoutPriceOnce");
            return (Criteria) this;
        }

        public Criteria andMoneyoutPriceOnceBetween(String value1, String value2) {
            addCriterion("moneyout_price_once between", value1, value2, "moneyoutPriceOnce");
            return (Criteria) this;
        }

        public Criteria andMoneyoutPriceOnceNotBetween(String value1, String value2) {
            addCriterion("moneyout_price_once not between", value1, value2, "moneyoutPriceOnce");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplybegintimeIsNull() {
            addCriterion("moneyout_applybegintime is null");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplybegintimeIsNotNull() {
            addCriterion("moneyout_applybegintime is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplybegintimeEqualTo(String value) {
            addCriterion("moneyout_applybegintime =", value, "moneyoutApplybegintime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplybegintimeNotEqualTo(String value) {
            addCriterion("moneyout_applybegintime <>", value, "moneyoutApplybegintime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplybegintimeGreaterThan(String value) {
            addCriterion("moneyout_applybegintime >", value, "moneyoutApplybegintime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplybegintimeGreaterThanOrEqualTo(String value) {
            addCriterion("moneyout_applybegintime >=", value, "moneyoutApplybegintime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplybegintimeLessThan(String value) {
            addCriterion("moneyout_applybegintime <", value, "moneyoutApplybegintime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplybegintimeLessThanOrEqualTo(String value) {
            addCriterion("moneyout_applybegintime <=", value, "moneyoutApplybegintime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplybegintimeLike(String value) {
            addCriterion("moneyout_applybegintime like", value, "moneyoutApplybegintime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplybegintimeNotLike(String value) {
            addCriterion("moneyout_applybegintime not like", value, "moneyoutApplybegintime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplybegintimeIn(List<String> values) {
            addCriterion("moneyout_applybegintime in", values, "moneyoutApplybegintime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplybegintimeNotIn(List<String> values) {
            addCriterion("moneyout_applybegintime not in", values, "moneyoutApplybegintime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplybegintimeBetween(String value1, String value2) {
            addCriterion("moneyout_applybegintime between", value1, value2, "moneyoutApplybegintime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplybegintimeNotBetween(String value1, String value2) {
            addCriterion("moneyout_applybegintime not between", value1, value2, "moneyoutApplybegintime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyendtimeIsNull() {
            addCriterion("moneyout_applyendtime is null");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyendtimeIsNotNull() {
            addCriterion("moneyout_applyendtime is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyendtimeEqualTo(String value) {
            addCriterion("moneyout_applyendtime =", value, "moneyoutApplyendtime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyendtimeNotEqualTo(String value) {
            addCriterion("moneyout_applyendtime <>", value, "moneyoutApplyendtime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyendtimeGreaterThan(String value) {
            addCriterion("moneyout_applyendtime >", value, "moneyoutApplyendtime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyendtimeGreaterThanOrEqualTo(String value) {
            addCriterion("moneyout_applyendtime >=", value, "moneyoutApplyendtime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyendtimeLessThan(String value) {
            addCriterion("moneyout_applyendtime <", value, "moneyoutApplyendtime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyendtimeLessThanOrEqualTo(String value) {
            addCriterion("moneyout_applyendtime <=", value, "moneyoutApplyendtime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyendtimeLike(String value) {
            addCriterion("moneyout_applyendtime like", value, "moneyoutApplyendtime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyendtimeNotLike(String value) {
            addCriterion("moneyout_applyendtime not like", value, "moneyoutApplyendtime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyendtimeIn(List<String> values) {
            addCriterion("moneyout_applyendtime in", values, "moneyoutApplyendtime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyendtimeNotIn(List<String> values) {
            addCriterion("moneyout_applyendtime not in", values, "moneyoutApplyendtime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyendtimeBetween(String value1, String value2) {
            addCriterion("moneyout_applyendtime between", value1, value2, "moneyoutApplyendtime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyendtimeNotBetween(String value1, String value2) {
            addCriterion("moneyout_applyendtime not between", value1, value2, "moneyoutApplyendtime");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyStateIsNull() {
            addCriterion("moneyout_apply_state is null");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyStateIsNotNull() {
            addCriterion("moneyout_apply_state is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyStateEqualTo(String value) {
            addCriterion("moneyout_apply_state =", value, "moneyoutApplyState");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyStateNotEqualTo(String value) {
            addCriterion("moneyout_apply_state <>", value, "moneyoutApplyState");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyStateGreaterThan(String value) {
            addCriterion("moneyout_apply_state >", value, "moneyoutApplyState");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyStateGreaterThanOrEqualTo(String value) {
            addCriterion("moneyout_apply_state >=", value, "moneyoutApplyState");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyStateLessThan(String value) {
            addCriterion("moneyout_apply_state <", value, "moneyoutApplyState");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyStateLessThanOrEqualTo(String value) {
            addCriterion("moneyout_apply_state <=", value, "moneyoutApplyState");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyStateLike(String value) {
            addCriterion("moneyout_apply_state like", value, "moneyoutApplyState");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyStateNotLike(String value) {
            addCriterion("moneyout_apply_state not like", value, "moneyoutApplyState");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyStateIn(List<String> values) {
            addCriterion("moneyout_apply_state in", values, "moneyoutApplyState");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyStateNotIn(List<String> values) {
            addCriterion("moneyout_apply_state not in", values, "moneyoutApplyState");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyStateBetween(String value1, String value2) {
            addCriterion("moneyout_apply_state between", value1, value2, "moneyoutApplyState");
            return (Criteria) this;
        }

        public Criteria andMoneyoutApplyStateNotBetween(String value1, String value2) {
            addCriterion("moneyout_apply_state not between", value1, value2, "moneyoutApplyState");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSpareoneIsNull() {
            addCriterion("moneyout_spareone is null");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSpareoneIsNotNull() {
            addCriterion("moneyout_spareone is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSpareoneEqualTo(Integer value) {
            addCriterion("moneyout_spareone =", value, "moneyoutSpareone");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSpareoneNotEqualTo(Integer value) {
            addCriterion("moneyout_spareone <>", value, "moneyoutSpareone");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSpareoneGreaterThan(Integer value) {
            addCriterion("moneyout_spareone >", value, "moneyoutSpareone");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSpareoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("moneyout_spareone >=", value, "moneyoutSpareone");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSpareoneLessThan(Integer value) {
            addCriterion("moneyout_spareone <", value, "moneyoutSpareone");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSpareoneLessThanOrEqualTo(Integer value) {
            addCriterion("moneyout_spareone <=", value, "moneyoutSpareone");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSpareoneIn(List<Integer> values) {
            addCriterion("moneyout_spareone in", values, "moneyoutSpareone");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSpareoneNotIn(List<Integer> values) {
            addCriterion("moneyout_spareone not in", values, "moneyoutSpareone");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSpareoneBetween(Integer value1, Integer value2) {
            addCriterion("moneyout_spareone between", value1, value2, "moneyoutSpareone");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSpareoneNotBetween(Integer value1, Integer value2) {
            addCriterion("moneyout_spareone not between", value1, value2, "moneyoutSpareone");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparetwoIsNull() {
            addCriterion("moneyout_sparetwo is null");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparetwoIsNotNull() {
            addCriterion("moneyout_sparetwo is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparetwoEqualTo(Integer value) {
            addCriterion("moneyout_sparetwo =", value, "moneyoutSparetwo");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparetwoNotEqualTo(Integer value) {
            addCriterion("moneyout_sparetwo <>", value, "moneyoutSparetwo");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparetwoGreaterThan(Integer value) {
            addCriterion("moneyout_sparetwo >", value, "moneyoutSparetwo");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparetwoGreaterThanOrEqualTo(Integer value) {
            addCriterion("moneyout_sparetwo >=", value, "moneyoutSparetwo");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparetwoLessThan(Integer value) {
            addCriterion("moneyout_sparetwo <", value, "moneyoutSparetwo");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparetwoLessThanOrEqualTo(Integer value) {
            addCriterion("moneyout_sparetwo <=", value, "moneyoutSparetwo");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparetwoIn(List<Integer> values) {
            addCriterion("moneyout_sparetwo in", values, "moneyoutSparetwo");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparetwoNotIn(List<Integer> values) {
            addCriterion("moneyout_sparetwo not in", values, "moneyoutSparetwo");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparetwoBetween(Integer value1, Integer value2) {
            addCriterion("moneyout_sparetwo between", value1, value2, "moneyoutSparetwo");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparetwoNotBetween(Integer value1, Integer value2) {
            addCriterion("moneyout_sparetwo not between", value1, value2, "moneyoutSparetwo");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparethreeIsNull() {
            addCriterion("moneyout_sparethree is null");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparethreeIsNotNull() {
            addCriterion("moneyout_sparethree is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparethreeEqualTo(String value) {
            addCriterion("moneyout_sparethree =", value, "moneyoutSparethree");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparethreeNotEqualTo(String value) {
            addCriterion("moneyout_sparethree <>", value, "moneyoutSparethree");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparethreeGreaterThan(String value) {
            addCriterion("moneyout_sparethree >", value, "moneyoutSparethree");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparethreeGreaterThanOrEqualTo(String value) {
            addCriterion("moneyout_sparethree >=", value, "moneyoutSparethree");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparethreeLessThan(String value) {
            addCriterion("moneyout_sparethree <", value, "moneyoutSparethree");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparethreeLessThanOrEqualTo(String value) {
            addCriterion("moneyout_sparethree <=", value, "moneyoutSparethree");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparethreeLike(String value) {
            addCriterion("moneyout_sparethree like", value, "moneyoutSparethree");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparethreeNotLike(String value) {
            addCriterion("moneyout_sparethree not like", value, "moneyoutSparethree");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparethreeIn(List<String> values) {
            addCriterion("moneyout_sparethree in", values, "moneyoutSparethree");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparethreeNotIn(List<String> values) {
            addCriterion("moneyout_sparethree not in", values, "moneyoutSparethree");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparethreeBetween(String value1, String value2) {
            addCriterion("moneyout_sparethree between", value1, value2, "moneyoutSparethree");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparethreeNotBetween(String value1, String value2) {
            addCriterion("moneyout_sparethree not between", value1, value2, "moneyoutSparethree");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparefourIsNull() {
            addCriterion("moneyout_sparefour is null");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparefourIsNotNull() {
            addCriterion("moneyout_sparefour is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparefourEqualTo(String value) {
            addCriterion("moneyout_sparefour =", value, "moneyoutSparefour");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparefourNotEqualTo(String value) {
            addCriterion("moneyout_sparefour <>", value, "moneyoutSparefour");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparefourGreaterThan(String value) {
            addCriterion("moneyout_sparefour >", value, "moneyoutSparefour");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparefourGreaterThanOrEqualTo(String value) {
            addCriterion("moneyout_sparefour >=", value, "moneyoutSparefour");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparefourLessThan(String value) {
            addCriterion("moneyout_sparefour <", value, "moneyoutSparefour");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparefourLessThanOrEqualTo(String value) {
            addCriterion("moneyout_sparefour <=", value, "moneyoutSparefour");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparefourLike(String value) {
            addCriterion("moneyout_sparefour like", value, "moneyoutSparefour");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparefourNotLike(String value) {
            addCriterion("moneyout_sparefour not like", value, "moneyoutSparefour");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparefourIn(List<String> values) {
            addCriterion("moneyout_sparefour in", values, "moneyoutSparefour");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparefourNotIn(List<String> values) {
            addCriterion("moneyout_sparefour not in", values, "moneyoutSparefour");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparefourBetween(String value1, String value2) {
            addCriterion("moneyout_sparefour between", value1, value2, "moneyoutSparefour");
            return (Criteria) this;
        }

        public Criteria andMoneyoutSparefourNotBetween(String value1, String value2) {
            addCriterion("moneyout_sparefour not between", value1, value2, "moneyoutSparefour");
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