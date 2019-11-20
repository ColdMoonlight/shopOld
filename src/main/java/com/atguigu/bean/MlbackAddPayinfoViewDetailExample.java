package com.atguigu.bean;

import java.util.ArrayList;
import java.util.List;

public class MlbackAddPayinfoViewDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MlbackAddPayinfoViewDetailExample() {
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

        public Criteria andAddpayinfoviewdetailIdIsNull() {
            addCriterion("addpayinfoViewDetail_id is null");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailIdIsNotNull() {
            addCriterion("addpayinfoViewDetail_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailIdEqualTo(Integer value) {
            addCriterion("addpayinfoViewDetail_id =", value, "addpayinfoviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailIdNotEqualTo(Integer value) {
            addCriterion("addpayinfoViewDetail_id <>", value, "addpayinfoviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailIdGreaterThan(Integer value) {
            addCriterion("addpayinfoViewDetail_id >", value, "addpayinfoviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("addpayinfoViewDetail_id >=", value, "addpayinfoviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailIdLessThan(Integer value) {
            addCriterion("addpayinfoViewDetail_id <", value, "addpayinfoviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("addpayinfoViewDetail_id <=", value, "addpayinfoviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailIdIn(List<Integer> values) {
            addCriterion("addpayinfoViewDetail_id in", values, "addpayinfoviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailIdNotIn(List<Integer> values) {
            addCriterion("addpayinfoViewDetail_id not in", values, "addpayinfoviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailIdBetween(Integer value1, Integer value2) {
            addCriterion("addpayinfoViewDetail_id between", value1, value2, "addpayinfoviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("addpayinfoViewDetail_id not between", value1, value2, "addpayinfoviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailSessionidIsNull() {
            addCriterion("addpayinfoViewDetail_sessionid is null");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailSessionidIsNotNull() {
            addCriterion("addpayinfoViewDetail_sessionid is not null");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailSessionidEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_sessionid =", value, "addpayinfoviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailSessionidNotEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_sessionid <>", value, "addpayinfoviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailSessionidGreaterThan(String value) {
            addCriterion("addpayinfoViewDetail_sessionid >", value, "addpayinfoviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailSessionidGreaterThanOrEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_sessionid >=", value, "addpayinfoviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailSessionidLessThan(String value) {
            addCriterion("addpayinfoViewDetail_sessionid <", value, "addpayinfoviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailSessionidLessThanOrEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_sessionid <=", value, "addpayinfoviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailSessionidLike(String value) {
            addCriterion("addpayinfoViewDetail_sessionid like", value, "addpayinfoviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailSessionidNotLike(String value) {
            addCriterion("addpayinfoViewDetail_sessionid not like", value, "addpayinfoviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailSessionidIn(List<String> values) {
            addCriterion("addpayinfoViewDetail_sessionid in", values, "addpayinfoviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailSessionidNotIn(List<String> values) {
            addCriterion("addpayinfoViewDetail_sessionid not in", values, "addpayinfoviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailSessionidBetween(String value1, String value2) {
            addCriterion("addpayinfoViewDetail_sessionid between", value1, value2, "addpayinfoviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailSessionidNotBetween(String value1, String value2) {
            addCriterion("addpayinfoViewDetail_sessionid not between", value1, value2, "addpayinfoviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoidIsNull() {
            addCriterion("addpayinfoViewDetail_payinfoid is null");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoidIsNotNull() {
            addCriterion("addpayinfoViewDetail_payinfoid is not null");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoidEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_payinfoid =", value, "addpayinfoviewdetailPayinfoid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoidNotEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_payinfoid <>", value, "addpayinfoviewdetailPayinfoid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoidGreaterThan(String value) {
            addCriterion("addpayinfoViewDetail_payinfoid >", value, "addpayinfoviewdetailPayinfoid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoidGreaterThanOrEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_payinfoid >=", value, "addpayinfoviewdetailPayinfoid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoidLessThan(String value) {
            addCriterion("addpayinfoViewDetail_payinfoid <", value, "addpayinfoviewdetailPayinfoid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoidLessThanOrEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_payinfoid <=", value, "addpayinfoviewdetailPayinfoid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoidLike(String value) {
            addCriterion("addpayinfoViewDetail_payinfoid like", value, "addpayinfoviewdetailPayinfoid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoidNotLike(String value) {
            addCriterion("addpayinfoViewDetail_payinfoid not like", value, "addpayinfoviewdetailPayinfoid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoidIn(List<String> values) {
            addCriterion("addpayinfoViewDetail_payinfoid in", values, "addpayinfoviewdetailPayinfoid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoidNotIn(List<String> values) {
            addCriterion("addpayinfoViewDetail_payinfoid not in", values, "addpayinfoviewdetailPayinfoid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoidBetween(String value1, String value2) {
            addCriterion("addpayinfoViewDetail_payinfoid between", value1, value2, "addpayinfoviewdetailPayinfoid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoidNotBetween(String value1, String value2) {
            addCriterion("addpayinfoViewDetail_payinfoid not between", value1, value2, "addpayinfoviewdetailPayinfoid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoshipnumIsNull() {
            addCriterion("addpayinfoViewDetail_payinfoshipnum is null");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoshipnumIsNotNull() {
            addCriterion("addpayinfoViewDetail_payinfoshipnum is not null");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoshipnumEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_payinfoshipnum =", value, "addpayinfoviewdetailPayinfoshipnum");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoshipnumNotEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_payinfoshipnum <>", value, "addpayinfoviewdetailPayinfoshipnum");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoshipnumGreaterThan(String value) {
            addCriterion("addpayinfoViewDetail_payinfoshipnum >", value, "addpayinfoviewdetailPayinfoshipnum");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoshipnumGreaterThanOrEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_payinfoshipnum >=", value, "addpayinfoviewdetailPayinfoshipnum");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoshipnumLessThan(String value) {
            addCriterion("addpayinfoViewDetail_payinfoshipnum <", value, "addpayinfoviewdetailPayinfoshipnum");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoshipnumLessThanOrEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_payinfoshipnum <=", value, "addpayinfoviewdetailPayinfoshipnum");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoshipnumLike(String value) {
            addCriterion("addpayinfoViewDetail_payinfoshipnum like", value, "addpayinfoviewdetailPayinfoshipnum");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoshipnumNotLike(String value) {
            addCriterion("addpayinfoViewDetail_payinfoshipnum not like", value, "addpayinfoviewdetailPayinfoshipnum");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoshipnumIn(List<String> values) {
            addCriterion("addpayinfoViewDetail_payinfoshipnum in", values, "addpayinfoviewdetailPayinfoshipnum");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoshipnumNotIn(List<String> values) {
            addCriterion("addpayinfoViewDetail_payinfoshipnum not in", values, "addpayinfoviewdetailPayinfoshipnum");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoshipnumBetween(String value1, String value2) {
            addCriterion("addpayinfoViewDetail_payinfoshipnum between", value1, value2, "addpayinfoviewdetailPayinfoshipnum");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoshipnumNotBetween(String value1, String value2) {
            addCriterion("addpayinfoViewDetail_payinfoshipnum not between", value1, value2, "addpayinfoviewdetailPayinfoshipnum");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfomoneyIsNull() {
            addCriterion("addpayinfoViewDetail_payinfoMoney is null");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfomoneyIsNotNull() {
            addCriterion("addpayinfoViewDetail_payinfoMoney is not null");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfomoneyEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_payinfoMoney =", value, "addpayinfoviewdetailPayinfomoney");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfomoneyNotEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_payinfoMoney <>", value, "addpayinfoviewdetailPayinfomoney");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfomoneyGreaterThan(String value) {
            addCriterion("addpayinfoViewDetail_payinfoMoney >", value, "addpayinfoviewdetailPayinfomoney");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfomoneyGreaterThanOrEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_payinfoMoney >=", value, "addpayinfoviewdetailPayinfomoney");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfomoneyLessThan(String value) {
            addCriterion("addpayinfoViewDetail_payinfoMoney <", value, "addpayinfoviewdetailPayinfomoney");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfomoneyLessThanOrEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_payinfoMoney <=", value, "addpayinfoviewdetailPayinfomoney");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfomoneyLike(String value) {
            addCriterion("addpayinfoViewDetail_payinfoMoney like", value, "addpayinfoviewdetailPayinfomoney");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfomoneyNotLike(String value) {
            addCriterion("addpayinfoViewDetail_payinfoMoney not like", value, "addpayinfoviewdetailPayinfomoney");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfomoneyIn(List<String> values) {
            addCriterion("addpayinfoViewDetail_payinfoMoney in", values, "addpayinfoviewdetailPayinfomoney");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfomoneyNotIn(List<String> values) {
            addCriterion("addpayinfoViewDetail_payinfoMoney not in", values, "addpayinfoviewdetailPayinfomoney");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfomoneyBetween(String value1, String value2) {
            addCriterion("addpayinfoViewDetail_payinfoMoney between", value1, value2, "addpayinfoviewdetailPayinfomoney");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfomoneyNotBetween(String value1, String value2) {
            addCriterion("addpayinfoViewDetail_payinfoMoney not between", value1, value2, "addpayinfoviewdetailPayinfomoney");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidIsNull() {
            addCriterion("addpayinfoViewDetail_payinfoaddressid is null");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidIsNotNull() {
            addCriterion("addpayinfoViewDetail_payinfoaddressid is not null");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidEqualTo(Integer value) {
            addCriterion("addpayinfoViewDetail_payinfoaddressid =", value, "addpayinfoviewdetailPayinfoaddressid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidNotEqualTo(Integer value) {
            addCriterion("addpayinfoViewDetail_payinfoaddressid <>", value, "addpayinfoviewdetailPayinfoaddressid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidGreaterThan(Integer value) {
            addCriterion("addpayinfoViewDetail_payinfoaddressid >", value, "addpayinfoviewdetailPayinfoaddressid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidGreaterThanOrEqualTo(Integer value) {
            addCriterion("addpayinfoViewDetail_payinfoaddressid >=", value, "addpayinfoviewdetailPayinfoaddressid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidLessThan(Integer value) {
            addCriterion("addpayinfoViewDetail_payinfoaddressid <", value, "addpayinfoviewdetailPayinfoaddressid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidLessThanOrEqualTo(Integer value) {
            addCriterion("addpayinfoViewDetail_payinfoaddressid <=", value, "addpayinfoviewdetailPayinfoaddressid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidIn(List<Integer> values) {
            addCriterion("addpayinfoViewDetail_payinfoaddressid in", values, "addpayinfoviewdetailPayinfoaddressid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidNotIn(List<Integer> values) {
            addCriterion("addpayinfoViewDetail_payinfoaddressid not in", values, "addpayinfoviewdetailPayinfoaddressid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidBetween(Integer value1, Integer value2) {
            addCriterion("addpayinfoViewDetail_payinfoaddressid between", value1, value2, "addpayinfoviewdetailPayinfoaddressid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidNotBetween(Integer value1, Integer value2) {
            addCriterion("addpayinfoViewDetail_payinfoaddressid not between", value1, value2, "addpayinfoviewdetailPayinfoaddressid");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidnameIsNull() {
            addCriterion("addpayinfoViewDetail_payinfoaddressidname is null");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidnameIsNotNull() {
            addCriterion("addpayinfoViewDetail_payinfoaddressidname is not null");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidnameEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_payinfoaddressidname =", value, "addpayinfoviewdetailPayinfoaddressidname");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidnameNotEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_payinfoaddressidname <>", value, "addpayinfoviewdetailPayinfoaddressidname");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidnameGreaterThan(String value) {
            addCriterion("addpayinfoViewDetail_payinfoaddressidname >", value, "addpayinfoviewdetailPayinfoaddressidname");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidnameGreaterThanOrEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_payinfoaddressidname >=", value, "addpayinfoviewdetailPayinfoaddressidname");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidnameLessThan(String value) {
            addCriterion("addpayinfoViewDetail_payinfoaddressidname <", value, "addpayinfoviewdetailPayinfoaddressidname");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidnameLessThanOrEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_payinfoaddressidname <=", value, "addpayinfoviewdetailPayinfoaddressidname");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidnameLike(String value) {
            addCriterion("addpayinfoViewDetail_payinfoaddressidname like", value, "addpayinfoviewdetailPayinfoaddressidname");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidnameNotLike(String value) {
            addCriterion("addpayinfoViewDetail_payinfoaddressidname not like", value, "addpayinfoviewdetailPayinfoaddressidname");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidnameIn(List<String> values) {
            addCriterion("addpayinfoViewDetail_payinfoaddressidname in", values, "addpayinfoviewdetailPayinfoaddressidname");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidnameNotIn(List<String> values) {
            addCriterion("addpayinfoViewDetail_payinfoaddressidname not in", values, "addpayinfoviewdetailPayinfoaddressidname");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidnameBetween(String value1, String value2) {
            addCriterion("addpayinfoViewDetail_payinfoaddressidname between", value1, value2, "addpayinfoviewdetailPayinfoaddressidname");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailPayinfoaddressidnameNotBetween(String value1, String value2) {
            addCriterion("addpayinfoViewDetail_payinfoaddressidname not between", value1, value2, "addpayinfoviewdetailPayinfoaddressidname");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailCreatetimeIsNull() {
            addCriterion("addpayinfoViewDetail_createTime is null");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailCreatetimeIsNotNull() {
            addCriterion("addpayinfoViewDetail_createTime is not null");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailCreatetimeEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_createTime =", value, "addpayinfoviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailCreatetimeNotEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_createTime <>", value, "addpayinfoviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailCreatetimeGreaterThan(String value) {
            addCriterion("addpayinfoViewDetail_createTime >", value, "addpayinfoviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_createTime >=", value, "addpayinfoviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailCreatetimeLessThan(String value) {
            addCriterion("addpayinfoViewDetail_createTime <", value, "addpayinfoviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_createTime <=", value, "addpayinfoviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailCreatetimeLike(String value) {
            addCriterion("addpayinfoViewDetail_createTime like", value, "addpayinfoviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailCreatetimeNotLike(String value) {
            addCriterion("addpayinfoViewDetail_createTime not like", value, "addpayinfoviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailCreatetimeIn(List<String> values) {
            addCriterion("addpayinfoViewDetail_createTime in", values, "addpayinfoviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailCreatetimeNotIn(List<String> values) {
            addCriterion("addpayinfoViewDetail_createTime not in", values, "addpayinfoviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailCreatetimeBetween(String value1, String value2) {
            addCriterion("addpayinfoViewDetail_createTime between", value1, value2, "addpayinfoviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailCreatetimeNotBetween(String value1, String value2) {
            addCriterion("addpayinfoViewDetail_createTime not between", value1, value2, "addpayinfoviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailMotifytimeIsNull() {
            addCriterion("addpayinfoViewDetail_motifyTime is null");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailMotifytimeIsNotNull() {
            addCriterion("addpayinfoViewDetail_motifyTime is not null");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailMotifytimeEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_motifyTime =", value, "addpayinfoviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailMotifytimeNotEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_motifyTime <>", value, "addpayinfoviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailMotifytimeGreaterThan(String value) {
            addCriterion("addpayinfoViewDetail_motifyTime >", value, "addpayinfoviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailMotifytimeGreaterThanOrEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_motifyTime >=", value, "addpayinfoviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailMotifytimeLessThan(String value) {
            addCriterion("addpayinfoViewDetail_motifyTime <", value, "addpayinfoviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailMotifytimeLessThanOrEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_motifyTime <=", value, "addpayinfoviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailMotifytimeLike(String value) {
            addCriterion("addpayinfoViewDetail_motifyTime like", value, "addpayinfoviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailMotifytimeNotLike(String value) {
            addCriterion("addpayinfoViewDetail_motifyTime not like", value, "addpayinfoviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailMotifytimeIn(List<String> values) {
            addCriterion("addpayinfoViewDetail_motifyTime in", values, "addpayinfoviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailMotifytimeNotIn(List<String> values) {
            addCriterion("addpayinfoViewDetail_motifyTime not in", values, "addpayinfoviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailMotifytimeBetween(String value1, String value2) {
            addCriterion("addpayinfoViewDetail_motifyTime between", value1, value2, "addpayinfoviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailMotifytimeNotBetween(String value1, String value2) {
            addCriterion("addpayinfoViewDetail_motifyTime not between", value1, value2, "addpayinfoviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailStarttimeIsNull() {
            addCriterion("addpayinfoViewDetail_starttime is null");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailStarttimeIsNotNull() {
            addCriterion("addpayinfoViewDetail_starttime is not null");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailStarttimeEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_starttime =", value, "addpayinfoviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailStarttimeNotEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_starttime <>", value, "addpayinfoviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailStarttimeGreaterThan(String value) {
            addCriterion("addpayinfoViewDetail_starttime >", value, "addpayinfoviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailStarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_starttime >=", value, "addpayinfoviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailStarttimeLessThan(String value) {
            addCriterion("addpayinfoViewDetail_starttime <", value, "addpayinfoviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailStarttimeLessThanOrEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_starttime <=", value, "addpayinfoviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailStarttimeLike(String value) {
            addCriterion("addpayinfoViewDetail_starttime like", value, "addpayinfoviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailStarttimeNotLike(String value) {
            addCriterion("addpayinfoViewDetail_starttime not like", value, "addpayinfoviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailStarttimeIn(List<String> values) {
            addCriterion("addpayinfoViewDetail_starttime in", values, "addpayinfoviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailStarttimeNotIn(List<String> values) {
            addCriterion("addpayinfoViewDetail_starttime not in", values, "addpayinfoviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailStarttimeBetween(String value1, String value2) {
            addCriterion("addpayinfoViewDetail_starttime between", value1, value2, "addpayinfoviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailStarttimeNotBetween(String value1, String value2) {
            addCriterion("addpayinfoViewDetail_starttime not between", value1, value2, "addpayinfoviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailEndtimeIsNull() {
            addCriterion("addpayinfoViewDetail_endtime is null");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailEndtimeIsNotNull() {
            addCriterion("addpayinfoViewDetail_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailEndtimeEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_endtime =", value, "addpayinfoviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailEndtimeNotEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_endtime <>", value, "addpayinfoviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailEndtimeGreaterThan(String value) {
            addCriterion("addpayinfoViewDetail_endtime >", value, "addpayinfoviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_endtime >=", value, "addpayinfoviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailEndtimeLessThan(String value) {
            addCriterion("addpayinfoViewDetail_endtime <", value, "addpayinfoviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailEndtimeLessThanOrEqualTo(String value) {
            addCriterion("addpayinfoViewDetail_endtime <=", value, "addpayinfoviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailEndtimeLike(String value) {
            addCriterion("addpayinfoViewDetail_endtime like", value, "addpayinfoviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailEndtimeNotLike(String value) {
            addCriterion("addpayinfoViewDetail_endtime not like", value, "addpayinfoviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailEndtimeIn(List<String> values) {
            addCriterion("addpayinfoViewDetail_endtime in", values, "addpayinfoviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailEndtimeNotIn(List<String> values) {
            addCriterion("addpayinfoViewDetail_endtime not in", values, "addpayinfoviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailEndtimeBetween(String value1, String value2) {
            addCriterion("addpayinfoViewDetail_endtime between", value1, value2, "addpayinfoviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddpayinfoviewdetailEndtimeNotBetween(String value1, String value2) {
            addCriterion("addpayinfoViewDetail_endtime not between", value1, value2, "addpayinfoviewdetailEndtime");
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