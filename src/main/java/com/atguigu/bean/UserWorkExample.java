package com.atguigu.bean;

import java.util.ArrayList;
import java.util.List;

public class UserWorkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserWorkExample() {
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

        public Criteria andUserworkIdIsNull() {
            addCriterion("userwork_id is null");
            return (Criteria) this;
        }

        public Criteria andUserworkIdIsNotNull() {
            addCriterion("userwork_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserworkIdEqualTo(Integer value) {
            addCriterion("userwork_id =", value, "userworkId");
            return (Criteria) this;
        }

        public Criteria andUserworkIdNotEqualTo(Integer value) {
            addCriterion("userwork_id <>", value, "userworkId");
            return (Criteria) this;
        }

        public Criteria andUserworkIdGreaterThan(Integer value) {
            addCriterion("userwork_id >", value, "userworkId");
            return (Criteria) this;
        }

        public Criteria andUserworkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("userwork_id >=", value, "userworkId");
            return (Criteria) this;
        }

        public Criteria andUserworkIdLessThan(Integer value) {
            addCriterion("userwork_id <", value, "userworkId");
            return (Criteria) this;
        }

        public Criteria andUserworkIdLessThanOrEqualTo(Integer value) {
            addCriterion("userwork_id <=", value, "userworkId");
            return (Criteria) this;
        }

        public Criteria andUserworkIdIn(List<Integer> values) {
            addCriterion("userwork_id in", values, "userworkId");
            return (Criteria) this;
        }

        public Criteria andUserworkIdNotIn(List<Integer> values) {
            addCriterion("userwork_id not in", values, "userworkId");
            return (Criteria) this;
        }

        public Criteria andUserworkIdBetween(Integer value1, Integer value2) {
            addCriterion("userwork_id between", value1, value2, "userworkId");
            return (Criteria) this;
        }

        public Criteria andUserworkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("userwork_id not between", value1, value2, "userworkId");
            return (Criteria) this;
        }

        public Criteria andUserworkGroupdisplayIdIsNull() {
            addCriterion("userwork_groupdisplay_id is null");
            return (Criteria) this;
        }

        public Criteria andUserworkGroupdisplayIdIsNotNull() {
            addCriterion("userwork_groupdisplay_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserworkGroupdisplayIdEqualTo(Integer value) {
            addCriterion("userwork_groupdisplay_id =", value, "userworkGroupdisplayId");
            return (Criteria) this;
        }

        public Criteria andUserworkGroupdisplayIdNotEqualTo(Integer value) {
            addCriterion("userwork_groupdisplay_id <>", value, "userworkGroupdisplayId");
            return (Criteria) this;
        }

        public Criteria andUserworkGroupdisplayIdGreaterThan(Integer value) {
            addCriterion("userwork_groupdisplay_id >", value, "userworkGroupdisplayId");
            return (Criteria) this;
        }

        public Criteria andUserworkGroupdisplayIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("userwork_groupdisplay_id >=", value, "userworkGroupdisplayId");
            return (Criteria) this;
        }

        public Criteria andUserworkGroupdisplayIdLessThan(Integer value) {
            addCriterion("userwork_groupdisplay_id <", value, "userworkGroupdisplayId");
            return (Criteria) this;
        }

        public Criteria andUserworkGroupdisplayIdLessThanOrEqualTo(Integer value) {
            addCriterion("userwork_groupdisplay_id <=", value, "userworkGroupdisplayId");
            return (Criteria) this;
        }

        public Criteria andUserworkGroupdisplayIdIn(List<Integer> values) {
            addCriterion("userwork_groupdisplay_id in", values, "userworkGroupdisplayId");
            return (Criteria) this;
        }

        public Criteria andUserworkGroupdisplayIdNotIn(List<Integer> values) {
            addCriterion("userwork_groupdisplay_id not in", values, "userworkGroupdisplayId");
            return (Criteria) this;
        }

        public Criteria andUserworkGroupdisplayIdBetween(Integer value1, Integer value2) {
            addCriterion("userwork_groupdisplay_id between", value1, value2, "userworkGroupdisplayId");
            return (Criteria) this;
        }

        public Criteria andUserworkGroupdisplayIdNotBetween(Integer value1, Integer value2) {
            addCriterion("userwork_groupdisplay_id not between", value1, value2, "userworkGroupdisplayId");
            return (Criteria) this;
        }

        public Criteria andUserworkUdidIsNull() {
            addCriterion("userwork_udid is null");
            return (Criteria) this;
        }

        public Criteria andUserworkUdidIsNotNull() {
            addCriterion("userwork_udid is not null");
            return (Criteria) this;
        }

        public Criteria andUserworkUdidEqualTo(String value) {
            addCriterion("userwork_udid =", value, "userworkUdid");
            return (Criteria) this;
        }

        public Criteria andUserworkUdidNotEqualTo(String value) {
            addCriterion("userwork_udid <>", value, "userworkUdid");
            return (Criteria) this;
        }

        public Criteria andUserworkUdidGreaterThan(String value) {
            addCriterion("userwork_udid >", value, "userworkUdid");
            return (Criteria) this;
        }

        public Criteria andUserworkUdidGreaterThanOrEqualTo(String value) {
            addCriterion("userwork_udid >=", value, "userworkUdid");
            return (Criteria) this;
        }

        public Criteria andUserworkUdidLessThan(String value) {
            addCriterion("userwork_udid <", value, "userworkUdid");
            return (Criteria) this;
        }

        public Criteria andUserworkUdidLessThanOrEqualTo(String value) {
            addCriterion("userwork_udid <=", value, "userworkUdid");
            return (Criteria) this;
        }

        public Criteria andUserworkUdidLike(String value) {
            addCriterion("userwork_udid like", value, "userworkUdid");
            return (Criteria) this;
        }

        public Criteria andUserworkUdidNotLike(String value) {
            addCriterion("userwork_udid not like", value, "userworkUdid");
            return (Criteria) this;
        }

        public Criteria andUserworkUdidIn(List<String> values) {
            addCriterion("userwork_udid in", values, "userworkUdid");
            return (Criteria) this;
        }

        public Criteria andUserworkUdidNotIn(List<String> values) {
            addCriterion("userwork_udid not in", values, "userworkUdid");
            return (Criteria) this;
        }

        public Criteria andUserworkUdidBetween(String value1, String value2) {
            addCriterion("userwork_udid between", value1, value2, "userworkUdid");
            return (Criteria) this;
        }

        public Criteria andUserworkUdidNotBetween(String value1, String value2) {
            addCriterion("userwork_udid not between", value1, value2, "userworkUdid");
            return (Criteria) this;
        }

        public Criteria andUserworkIdfaIsNull() {
            addCriterion("userwork_idfa is null");
            return (Criteria) this;
        }

        public Criteria andUserworkIdfaIsNotNull() {
            addCriterion("userwork_idfa is not null");
            return (Criteria) this;
        }

        public Criteria andUserworkIdfaEqualTo(String value) {
            addCriterion("userwork_idfa =", value, "userworkIdfa");
            return (Criteria) this;
        }

        public Criteria andUserworkIdfaNotEqualTo(String value) {
            addCriterion("userwork_idfa <>", value, "userworkIdfa");
            return (Criteria) this;
        }

        public Criteria andUserworkIdfaGreaterThan(String value) {
            addCriterion("userwork_idfa >", value, "userworkIdfa");
            return (Criteria) this;
        }

        public Criteria andUserworkIdfaGreaterThanOrEqualTo(String value) {
            addCriterion("userwork_idfa >=", value, "userworkIdfa");
            return (Criteria) this;
        }

        public Criteria andUserworkIdfaLessThan(String value) {
            addCriterion("userwork_idfa <", value, "userworkIdfa");
            return (Criteria) this;
        }

        public Criteria andUserworkIdfaLessThanOrEqualTo(String value) {
            addCriterion("userwork_idfa <=", value, "userworkIdfa");
            return (Criteria) this;
        }

        public Criteria andUserworkIdfaLike(String value) {
            addCriterion("userwork_idfa like", value, "userworkIdfa");
            return (Criteria) this;
        }

        public Criteria andUserworkIdfaNotLike(String value) {
            addCriterion("userwork_idfa not like", value, "userworkIdfa");
            return (Criteria) this;
        }

        public Criteria andUserworkIdfaIn(List<String> values) {
            addCriterion("userwork_idfa in", values, "userworkIdfa");
            return (Criteria) this;
        }

        public Criteria andUserworkIdfaNotIn(List<String> values) {
            addCriterion("userwork_idfa not in", values, "userworkIdfa");
            return (Criteria) this;
        }

        public Criteria andUserworkIdfaBetween(String value1, String value2) {
            addCriterion("userwork_idfa between", value1, value2, "userworkIdfa");
            return (Criteria) this;
        }

        public Criteria andUserworkIdfaNotBetween(String value1, String value2) {
            addCriterion("userwork_idfa not between", value1, value2, "userworkIdfa");
            return (Criteria) this;
        }

        public Criteria andUserworkCreatetimeIsNull() {
            addCriterion("userwork_createtime is null");
            return (Criteria) this;
        }

        public Criteria andUserworkCreatetimeIsNotNull() {
            addCriterion("userwork_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andUserworkCreatetimeEqualTo(String value) {
            addCriterion("userwork_createtime =", value, "userworkCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserworkCreatetimeNotEqualTo(String value) {
            addCriterion("userwork_createtime <>", value, "userworkCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserworkCreatetimeGreaterThan(String value) {
            addCriterion("userwork_createtime >", value, "userworkCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserworkCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("userwork_createtime >=", value, "userworkCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserworkCreatetimeLessThan(String value) {
            addCriterion("userwork_createtime <", value, "userworkCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserworkCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("userwork_createtime <=", value, "userworkCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserworkCreatetimeLike(String value) {
            addCriterion("userwork_createtime like", value, "userworkCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserworkCreatetimeNotLike(String value) {
            addCriterion("userwork_createtime not like", value, "userworkCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserworkCreatetimeIn(List<String> values) {
            addCriterion("userwork_createtime in", values, "userworkCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserworkCreatetimeNotIn(List<String> values) {
            addCriterion("userwork_createtime not in", values, "userworkCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserworkCreatetimeBetween(String value1, String value2) {
            addCriterion("userwork_createtime between", value1, value2, "userworkCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserworkCreatetimeNotBetween(String value1, String value2) {
            addCriterion("userwork_createtime not between", value1, value2, "userworkCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserworkUploadtimeIsNull() {
            addCriterion("userwork_uploadtime is null");
            return (Criteria) this;
        }

        public Criteria andUserworkUploadtimeIsNotNull() {
            addCriterion("userwork_uploadtime is not null");
            return (Criteria) this;
        }

        public Criteria andUserworkUploadtimeEqualTo(String value) {
            addCriterion("userwork_uploadtime =", value, "userworkUploadtime");
            return (Criteria) this;
        }

        public Criteria andUserworkUploadtimeNotEqualTo(String value) {
            addCriterion("userwork_uploadtime <>", value, "userworkUploadtime");
            return (Criteria) this;
        }

        public Criteria andUserworkUploadtimeGreaterThan(String value) {
            addCriterion("userwork_uploadtime >", value, "userworkUploadtime");
            return (Criteria) this;
        }

        public Criteria andUserworkUploadtimeGreaterThanOrEqualTo(String value) {
            addCriterion("userwork_uploadtime >=", value, "userworkUploadtime");
            return (Criteria) this;
        }

        public Criteria andUserworkUploadtimeLessThan(String value) {
            addCriterion("userwork_uploadtime <", value, "userworkUploadtime");
            return (Criteria) this;
        }

        public Criteria andUserworkUploadtimeLessThanOrEqualTo(String value) {
            addCriterion("userwork_uploadtime <=", value, "userworkUploadtime");
            return (Criteria) this;
        }

        public Criteria andUserworkUploadtimeLike(String value) {
            addCriterion("userwork_uploadtime like", value, "userworkUploadtime");
            return (Criteria) this;
        }

        public Criteria andUserworkUploadtimeNotLike(String value) {
            addCriterion("userwork_uploadtime not like", value, "userworkUploadtime");
            return (Criteria) this;
        }

        public Criteria andUserworkUploadtimeIn(List<String> values) {
            addCriterion("userwork_uploadtime in", values, "userworkUploadtime");
            return (Criteria) this;
        }

        public Criteria andUserworkUploadtimeNotIn(List<String> values) {
            addCriterion("userwork_uploadtime not in", values, "userworkUploadtime");
            return (Criteria) this;
        }

        public Criteria andUserworkUploadtimeBetween(String value1, String value2) {
            addCriterion("userwork_uploadtime between", value1, value2, "userworkUploadtime");
            return (Criteria) this;
        }

        public Criteria andUserworkUploadtimeNotBetween(String value1, String value2) {
            addCriterion("userwork_uploadtime not between", value1, value2, "userworkUploadtime");
            return (Criteria) this;
        }

        public Criteria andUserworkStateIsNull() {
            addCriterion("userwork_state is null");
            return (Criteria) this;
        }

        public Criteria andUserworkStateIsNotNull() {
            addCriterion("userwork_state is not null");
            return (Criteria) this;
        }

        public Criteria andUserworkStateEqualTo(String value) {
            addCriterion("userwork_state =", value, "userworkState");
            return (Criteria) this;
        }

        public Criteria andUserworkStateNotEqualTo(String value) {
            addCriterion("userwork_state <>", value, "userworkState");
            return (Criteria) this;
        }

        public Criteria andUserworkStateGreaterThan(String value) {
            addCriterion("userwork_state >", value, "userworkState");
            return (Criteria) this;
        }

        public Criteria andUserworkStateGreaterThanOrEqualTo(String value) {
            addCriterion("userwork_state >=", value, "userworkState");
            return (Criteria) this;
        }

        public Criteria andUserworkStateLessThan(String value) {
            addCriterion("userwork_state <", value, "userworkState");
            return (Criteria) this;
        }

        public Criteria andUserworkStateLessThanOrEqualTo(String value) {
            addCriterion("userwork_state <=", value, "userworkState");
            return (Criteria) this;
        }

        public Criteria andUserworkStateLike(String value) {
            addCriterion("userwork_state like", value, "userworkState");
            return (Criteria) this;
        }

        public Criteria andUserworkStateNotLike(String value) {
            addCriterion("userwork_state not like", value, "userworkState");
            return (Criteria) this;
        }

        public Criteria andUserworkStateIn(List<String> values) {
            addCriterion("userwork_state in", values, "userworkState");
            return (Criteria) this;
        }

        public Criteria andUserworkStateNotIn(List<String> values) {
            addCriterion("userwork_state not in", values, "userworkState");
            return (Criteria) this;
        }

        public Criteria andUserworkStateBetween(String value1, String value2) {
            addCriterion("userwork_state between", value1, value2, "userworkState");
            return (Criteria) this;
        }

        public Criteria andUserworkStateNotBetween(String value1, String value2) {
            addCriterion("userwork_state not between", value1, value2, "userworkState");
            return (Criteria) this;
        }

        public Criteria andUserworkPriceIsNull() {
            addCriterion("userwork_price is null");
            return (Criteria) this;
        }

        public Criteria andUserworkPriceIsNotNull() {
            addCriterion("userwork_price is not null");
            return (Criteria) this;
        }

        public Criteria andUserworkPriceEqualTo(String value) {
            addCriterion("userwork_price =", value, "userworkPrice");
            return (Criteria) this;
        }

        public Criteria andUserworkPriceNotEqualTo(String value) {
            addCriterion("userwork_price <>", value, "userworkPrice");
            return (Criteria) this;
        }

        public Criteria andUserworkPriceGreaterThan(String value) {
            addCriterion("userwork_price >", value, "userworkPrice");
            return (Criteria) this;
        }

        public Criteria andUserworkPriceGreaterThanOrEqualTo(String value) {
            addCriterion("userwork_price >=", value, "userworkPrice");
            return (Criteria) this;
        }

        public Criteria andUserworkPriceLessThan(String value) {
            addCriterion("userwork_price <", value, "userworkPrice");
            return (Criteria) this;
        }

        public Criteria andUserworkPriceLessThanOrEqualTo(String value) {
            addCriterion("userwork_price <=", value, "userworkPrice");
            return (Criteria) this;
        }

        public Criteria andUserworkPriceLike(String value) {
            addCriterion("userwork_price like", value, "userworkPrice");
            return (Criteria) this;
        }

        public Criteria andUserworkPriceNotLike(String value) {
            addCriterion("userwork_price not like", value, "userworkPrice");
            return (Criteria) this;
        }

        public Criteria andUserworkPriceIn(List<String> values) {
            addCriterion("userwork_price in", values, "userworkPrice");
            return (Criteria) this;
        }

        public Criteria andUserworkPriceNotIn(List<String> values) {
            addCriterion("userwork_price not in", values, "userworkPrice");
            return (Criteria) this;
        }

        public Criteria andUserworkPriceBetween(String value1, String value2) {
            addCriterion("userwork_price between", value1, value2, "userworkPrice");
            return (Criteria) this;
        }

        public Criteria andUserworkPriceNotBetween(String value1, String value2) {
            addCriterion("userwork_price not between", value1, value2, "userworkPrice");
            return (Criteria) this;
        }

        public Criteria andUserworkSpareoneIsNull() {
            addCriterion("userwork_spareone is null");
            return (Criteria) this;
        }

        public Criteria andUserworkSpareoneIsNotNull() {
            addCriterion("userwork_spareone is not null");
            return (Criteria) this;
        }

        public Criteria andUserworkSpareoneEqualTo(Integer value) {
            addCriterion("userwork_spareone =", value, "userworkSpareone");
            return (Criteria) this;
        }

        public Criteria andUserworkSpareoneNotEqualTo(Integer value) {
            addCriterion("userwork_spareone <>", value, "userworkSpareone");
            return (Criteria) this;
        }

        public Criteria andUserworkSpareoneGreaterThan(Integer value) {
            addCriterion("userwork_spareone >", value, "userworkSpareone");
            return (Criteria) this;
        }

        public Criteria andUserworkSpareoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("userwork_spareone >=", value, "userworkSpareone");
            return (Criteria) this;
        }

        public Criteria andUserworkSpareoneLessThan(Integer value) {
            addCriterion("userwork_spareone <", value, "userworkSpareone");
            return (Criteria) this;
        }

        public Criteria andUserworkSpareoneLessThanOrEqualTo(Integer value) {
            addCriterion("userwork_spareone <=", value, "userworkSpareone");
            return (Criteria) this;
        }

        public Criteria andUserworkSpareoneIn(List<Integer> values) {
            addCriterion("userwork_spareone in", values, "userworkSpareone");
            return (Criteria) this;
        }

        public Criteria andUserworkSpareoneNotIn(List<Integer> values) {
            addCriterion("userwork_spareone not in", values, "userworkSpareone");
            return (Criteria) this;
        }

        public Criteria andUserworkSpareoneBetween(Integer value1, Integer value2) {
            addCriterion("userwork_spareone between", value1, value2, "userworkSpareone");
            return (Criteria) this;
        }

        public Criteria andUserworkSpareoneNotBetween(Integer value1, Integer value2) {
            addCriterion("userwork_spareone not between", value1, value2, "userworkSpareone");
            return (Criteria) this;
        }

        public Criteria andUserworkSparetwoIsNull() {
            addCriterion("userwork_sparetwo is null");
            return (Criteria) this;
        }

        public Criteria andUserworkSparetwoIsNotNull() {
            addCriterion("userwork_sparetwo is not null");
            return (Criteria) this;
        }

        public Criteria andUserworkSparetwoEqualTo(Integer value) {
            addCriterion("userwork_sparetwo =", value, "userworkSparetwo");
            return (Criteria) this;
        }

        public Criteria andUserworkSparetwoNotEqualTo(Integer value) {
            addCriterion("userwork_sparetwo <>", value, "userworkSparetwo");
            return (Criteria) this;
        }

        public Criteria andUserworkSparetwoGreaterThan(Integer value) {
            addCriterion("userwork_sparetwo >", value, "userworkSparetwo");
            return (Criteria) this;
        }

        public Criteria andUserworkSparetwoGreaterThanOrEqualTo(Integer value) {
            addCriterion("userwork_sparetwo >=", value, "userworkSparetwo");
            return (Criteria) this;
        }

        public Criteria andUserworkSparetwoLessThan(Integer value) {
            addCriterion("userwork_sparetwo <", value, "userworkSparetwo");
            return (Criteria) this;
        }

        public Criteria andUserworkSparetwoLessThanOrEqualTo(Integer value) {
            addCriterion("userwork_sparetwo <=", value, "userworkSparetwo");
            return (Criteria) this;
        }

        public Criteria andUserworkSparetwoIn(List<Integer> values) {
            addCriterion("userwork_sparetwo in", values, "userworkSparetwo");
            return (Criteria) this;
        }

        public Criteria andUserworkSparetwoNotIn(List<Integer> values) {
            addCriterion("userwork_sparetwo not in", values, "userworkSparetwo");
            return (Criteria) this;
        }

        public Criteria andUserworkSparetwoBetween(Integer value1, Integer value2) {
            addCriterion("userwork_sparetwo between", value1, value2, "userworkSparetwo");
            return (Criteria) this;
        }

        public Criteria andUserworkSparetwoNotBetween(Integer value1, Integer value2) {
            addCriterion("userwork_sparetwo not between", value1, value2, "userworkSparetwo");
            return (Criteria) this;
        }

        public Criteria andUserworkSparethreeIsNull() {
            addCriterion("userwork_sparethree is null");
            return (Criteria) this;
        }

        public Criteria andUserworkSparethreeIsNotNull() {
            addCriterion("userwork_sparethree is not null");
            return (Criteria) this;
        }

        public Criteria andUserworkSparethreeEqualTo(String value) {
            addCriterion("userwork_sparethree =", value, "userworkSparethree");
            return (Criteria) this;
        }

        public Criteria andUserworkSparethreeNotEqualTo(String value) {
            addCriterion("userwork_sparethree <>", value, "userworkSparethree");
            return (Criteria) this;
        }

        public Criteria andUserworkSparethreeGreaterThan(String value) {
            addCriterion("userwork_sparethree >", value, "userworkSparethree");
            return (Criteria) this;
        }

        public Criteria andUserworkSparethreeGreaterThanOrEqualTo(String value) {
            addCriterion("userwork_sparethree >=", value, "userworkSparethree");
            return (Criteria) this;
        }

        public Criteria andUserworkSparethreeLessThan(String value) {
            addCriterion("userwork_sparethree <", value, "userworkSparethree");
            return (Criteria) this;
        }

        public Criteria andUserworkSparethreeLessThanOrEqualTo(String value) {
            addCriterion("userwork_sparethree <=", value, "userworkSparethree");
            return (Criteria) this;
        }

        public Criteria andUserworkSparethreeLike(String value) {
            addCriterion("userwork_sparethree like", value, "userworkSparethree");
            return (Criteria) this;
        }

        public Criteria andUserworkSparethreeNotLike(String value) {
            addCriterion("userwork_sparethree not like", value, "userworkSparethree");
            return (Criteria) this;
        }

        public Criteria andUserworkSparethreeIn(List<String> values) {
            addCriterion("userwork_sparethree in", values, "userworkSparethree");
            return (Criteria) this;
        }

        public Criteria andUserworkSparethreeNotIn(List<String> values) {
            addCriterion("userwork_sparethree not in", values, "userworkSparethree");
            return (Criteria) this;
        }

        public Criteria andUserworkSparethreeBetween(String value1, String value2) {
            addCriterion("userwork_sparethree between", value1, value2, "userworkSparethree");
            return (Criteria) this;
        }

        public Criteria andUserworkSparethreeNotBetween(String value1, String value2) {
            addCriterion("userwork_sparethree not between", value1, value2, "userworkSparethree");
            return (Criteria) this;
        }

        public Criteria andUserworkSparefourIsNull() {
            addCriterion("userwork_sparefour is null");
            return (Criteria) this;
        }

        public Criteria andUserworkSparefourIsNotNull() {
            addCriterion("userwork_sparefour is not null");
            return (Criteria) this;
        }

        public Criteria andUserworkSparefourEqualTo(String value) {
            addCriterion("userwork_sparefour =", value, "userworkSparefour");
            return (Criteria) this;
        }

        public Criteria andUserworkSparefourNotEqualTo(String value) {
            addCriterion("userwork_sparefour <>", value, "userworkSparefour");
            return (Criteria) this;
        }

        public Criteria andUserworkSparefourGreaterThan(String value) {
            addCriterion("userwork_sparefour >", value, "userworkSparefour");
            return (Criteria) this;
        }

        public Criteria andUserworkSparefourGreaterThanOrEqualTo(String value) {
            addCriterion("userwork_sparefour >=", value, "userworkSparefour");
            return (Criteria) this;
        }

        public Criteria andUserworkSparefourLessThan(String value) {
            addCriterion("userwork_sparefour <", value, "userworkSparefour");
            return (Criteria) this;
        }

        public Criteria andUserworkSparefourLessThanOrEqualTo(String value) {
            addCriterion("userwork_sparefour <=", value, "userworkSparefour");
            return (Criteria) this;
        }

        public Criteria andUserworkSparefourLike(String value) {
            addCriterion("userwork_sparefour like", value, "userworkSparefour");
            return (Criteria) this;
        }

        public Criteria andUserworkSparefourNotLike(String value) {
            addCriterion("userwork_sparefour not like", value, "userworkSparefour");
            return (Criteria) this;
        }

        public Criteria andUserworkSparefourIn(List<String> values) {
            addCriterion("userwork_sparefour in", values, "userworkSparefour");
            return (Criteria) this;
        }

        public Criteria andUserworkSparefourNotIn(List<String> values) {
            addCriterion("userwork_sparefour not in", values, "userworkSparefour");
            return (Criteria) this;
        }

        public Criteria andUserworkSparefourBetween(String value1, String value2) {
            addCriterion("userwork_sparefour between", value1, value2, "userworkSparefour");
            return (Criteria) this;
        }

        public Criteria andUserworkSparefourNotBetween(String value1, String value2) {
            addCriterion("userwork_sparefour not between", value1, value2, "userworkSparefour");
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