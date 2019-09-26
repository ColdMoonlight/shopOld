package com.atguigu.bean;

import java.util.ArrayList;
import java.util.List;

public class MlbackAddCheakoutViewDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MlbackAddCheakoutViewDetailExample() {
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

        public Criteria andAddcheakoutviewdetailIdIsNull() {
            addCriterion("addcheakoutviewDetail_id is null");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailIdIsNotNull() {
            addCriterion("addcheakoutviewDetail_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailIdEqualTo(Integer value) {
            addCriterion("addcheakoutviewDetail_id =", value, "addcheakoutviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailIdNotEqualTo(Integer value) {
            addCriterion("addcheakoutviewDetail_id <>", value, "addcheakoutviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailIdGreaterThan(Integer value) {
            addCriterion("addcheakoutviewDetail_id >", value, "addcheakoutviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("addcheakoutviewDetail_id >=", value, "addcheakoutviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailIdLessThan(Integer value) {
            addCriterion("addcheakoutviewDetail_id <", value, "addcheakoutviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("addcheakoutviewDetail_id <=", value, "addcheakoutviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailIdIn(List<Integer> values) {
            addCriterion("addcheakoutviewDetail_id in", values, "addcheakoutviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailIdNotIn(List<Integer> values) {
            addCriterion("addcheakoutviewDetail_id not in", values, "addcheakoutviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailIdBetween(Integer value1, Integer value2) {
            addCriterion("addcheakoutviewDetail_id between", value1, value2, "addcheakoutviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("addcheakoutviewDetail_id not between", value1, value2, "addcheakoutviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSessionidIsNull() {
            addCriterion("addcheakoutviewDetail_sessionid is null");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSessionidIsNotNull() {
            addCriterion("addcheakoutviewDetail_sessionid is not null");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSessionidEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_sessionid =", value, "addcheakoutviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSessionidNotEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_sessionid <>", value, "addcheakoutviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSessionidGreaterThan(String value) {
            addCriterion("addcheakoutviewDetail_sessionid >", value, "addcheakoutviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSessionidGreaterThanOrEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_sessionid >=", value, "addcheakoutviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSessionidLessThan(String value) {
            addCriterion("addcheakoutviewDetail_sessionid <", value, "addcheakoutviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSessionidLessThanOrEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_sessionid <=", value, "addcheakoutviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSessionidLike(String value) {
            addCriterion("addcheakoutviewDetail_sessionid like", value, "addcheakoutviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSessionidNotLike(String value) {
            addCriterion("addcheakoutviewDetail_sessionid not like", value, "addcheakoutviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSessionidIn(List<String> values) {
            addCriterion("addcheakoutviewDetail_sessionid in", values, "addcheakoutviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSessionidNotIn(List<String> values) {
            addCriterion("addcheakoutviewDetail_sessionid not in", values, "addcheakoutviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSessionidBetween(String value1, String value2) {
            addCriterion("addcheakoutviewDetail_sessionid between", value1, value2, "addcheakoutviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSessionidNotBetween(String value1, String value2) {
            addCriterion("addcheakoutviewDetail_sessionid not between", value1, value2, "addcheakoutviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailNameIsNull() {
            addCriterion("addcheakoutviewDetail_name is null");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailNameIsNotNull() {
            addCriterion("addcheakoutviewDetail_name is not null");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailNameEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_name =", value, "addcheakoutviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailNameNotEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_name <>", value, "addcheakoutviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailNameGreaterThan(String value) {
            addCriterion("addcheakoutviewDetail_name >", value, "addcheakoutviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailNameGreaterThanOrEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_name >=", value, "addcheakoutviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailNameLessThan(String value) {
            addCriterion("addcheakoutviewDetail_name <", value, "addcheakoutviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailNameLessThanOrEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_name <=", value, "addcheakoutviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailNameLike(String value) {
            addCriterion("addcheakoutviewDetail_name like", value, "addcheakoutviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailNameNotLike(String value) {
            addCriterion("addcheakoutviewDetail_name not like", value, "addcheakoutviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailNameIn(List<String> values) {
            addCriterion("addcheakoutviewDetail_name in", values, "addcheakoutviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailNameNotIn(List<String> values) {
            addCriterion("addcheakoutviewDetail_name not in", values, "addcheakoutviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailNameBetween(String value1, String value2) {
            addCriterion("addcheakoutviewDetail_name between", value1, value2, "addcheakoutviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailNameNotBetween(String value1, String value2) {
            addCriterion("addcheakoutviewDetail_name not between", value1, value2, "addcheakoutviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailProidIsNull() {
            addCriterion("addcheakoutviewDetail_proid is null");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailProidIsNotNull() {
            addCriterion("addcheakoutviewDetail_proid is not null");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailProidEqualTo(Integer value) {
            addCriterion("addcheakoutviewDetail_proid =", value, "addcheakoutviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailProidNotEqualTo(Integer value) {
            addCriterion("addcheakoutviewDetail_proid <>", value, "addcheakoutviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailProidGreaterThan(Integer value) {
            addCriterion("addcheakoutviewDetail_proid >", value, "addcheakoutviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailProidGreaterThanOrEqualTo(Integer value) {
            addCriterion("addcheakoutviewDetail_proid >=", value, "addcheakoutviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailProidLessThan(Integer value) {
            addCriterion("addcheakoutviewDetail_proid <", value, "addcheakoutviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailProidLessThanOrEqualTo(Integer value) {
            addCriterion("addcheakoutviewDetail_proid <=", value, "addcheakoutviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailProidIn(List<Integer> values) {
            addCriterion("addcheakoutviewDetail_proid in", values, "addcheakoutviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailProidNotIn(List<Integer> values) {
            addCriterion("addcheakoutviewDetail_proid not in", values, "addcheakoutviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailProidBetween(Integer value1, Integer value2) {
            addCriterion("addcheakoutviewDetail_proid between", value1, value2, "addcheakoutviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailProidNotBetween(Integer value1, Integer value2) {
            addCriterion("addcheakoutviewDetail_proid not between", value1, value2, "addcheakoutviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailPronameIsNull() {
            addCriterion("addcheakoutviewDetail_proname is null");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailPronameIsNotNull() {
            addCriterion("addcheakoutviewDetail_proname is not null");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailPronameEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_proname =", value, "addcheakoutviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailPronameNotEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_proname <>", value, "addcheakoutviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailPronameGreaterThan(String value) {
            addCriterion("addcheakoutviewDetail_proname >", value, "addcheakoutviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailPronameGreaterThanOrEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_proname >=", value, "addcheakoutviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailPronameLessThan(String value) {
            addCriterion("addcheakoutviewDetail_proname <", value, "addcheakoutviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailPronameLessThanOrEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_proname <=", value, "addcheakoutviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailPronameLike(String value) {
            addCriterion("addcheakoutviewDetail_proname like", value, "addcheakoutviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailPronameNotLike(String value) {
            addCriterion("addcheakoutviewDetail_proname not like", value, "addcheakoutviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailPronameIn(List<String> values) {
            addCriterion("addcheakoutviewDetail_proname in", values, "addcheakoutviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailPronameNotIn(List<String> values) {
            addCriterion("addcheakoutviewDetail_proname not in", values, "addcheakoutviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailPronameBetween(String value1, String value2) {
            addCriterion("addcheakoutviewDetail_proname between", value1, value2, "addcheakoutviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailPronameNotBetween(String value1, String value2) {
            addCriterion("addcheakoutviewDetail_proname not between", value1, value2, "addcheakoutviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSeonameIsNull() {
            addCriterion("addcheakoutviewDetail_seoname is null");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSeonameIsNotNull() {
            addCriterion("addcheakoutviewDetail_seoname is not null");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSeonameEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_seoname =", value, "addcheakoutviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSeonameNotEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_seoname <>", value, "addcheakoutviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSeonameGreaterThan(String value) {
            addCriterion("addcheakoutviewDetail_seoname >", value, "addcheakoutviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSeonameGreaterThanOrEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_seoname >=", value, "addcheakoutviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSeonameLessThan(String value) {
            addCriterion("addcheakoutviewDetail_seoname <", value, "addcheakoutviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSeonameLessThanOrEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_seoname <=", value, "addcheakoutviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSeonameLike(String value) {
            addCriterion("addcheakoutviewDetail_seoname like", value, "addcheakoutviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSeonameNotLike(String value) {
            addCriterion("addcheakoutviewDetail_seoname not like", value, "addcheakoutviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSeonameIn(List<String> values) {
            addCriterion("addcheakoutviewDetail_seoname in", values, "addcheakoutviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSeonameNotIn(List<String> values) {
            addCriterion("addcheakoutviewDetail_seoname not in", values, "addcheakoutviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSeonameBetween(String value1, String value2) {
            addCriterion("addcheakoutviewDetail_seoname between", value1, value2, "addcheakoutviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailSeonameNotBetween(String value1, String value2) {
            addCriterion("addcheakoutviewDetail_seoname not between", value1, value2, "addcheakoutviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailActnumIsNull() {
            addCriterion("addcheakoutviewDetail_actnum is null");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailActnumIsNotNull() {
            addCriterion("addcheakoutviewDetail_actnum is not null");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailActnumEqualTo(Integer value) {
            addCriterion("addcheakoutviewDetail_actnum =", value, "addcheakoutviewdetailActnum");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailActnumNotEqualTo(Integer value) {
            addCriterion("addcheakoutviewDetail_actnum <>", value, "addcheakoutviewdetailActnum");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailActnumGreaterThan(Integer value) {
            addCriterion("addcheakoutviewDetail_actnum >", value, "addcheakoutviewdetailActnum");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailActnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("addcheakoutviewDetail_actnum >=", value, "addcheakoutviewdetailActnum");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailActnumLessThan(Integer value) {
            addCriterion("addcheakoutviewDetail_actnum <", value, "addcheakoutviewdetailActnum");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailActnumLessThanOrEqualTo(Integer value) {
            addCriterion("addcheakoutviewDetail_actnum <=", value, "addcheakoutviewdetailActnum");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailActnumIn(List<Integer> values) {
            addCriterion("addcheakoutviewDetail_actnum in", values, "addcheakoutviewdetailActnum");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailActnumNotIn(List<Integer> values) {
            addCriterion("addcheakoutviewDetail_actnum not in", values, "addcheakoutviewdetailActnum");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailActnumBetween(Integer value1, Integer value2) {
            addCriterion("addcheakoutviewDetail_actnum between", value1, value2, "addcheakoutviewdetailActnum");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailActnumNotBetween(Integer value1, Integer value2) {
            addCriterion("addcheakoutviewDetail_actnum not between", value1, value2, "addcheakoutviewdetailActnum");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailCreatetimeIsNull() {
            addCriterion("addcheakoutviewDetail_createTime is null");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailCreatetimeIsNotNull() {
            addCriterion("addcheakoutviewDetail_createTime is not null");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailCreatetimeEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_createTime =", value, "addcheakoutviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailCreatetimeNotEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_createTime <>", value, "addcheakoutviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailCreatetimeGreaterThan(String value) {
            addCriterion("addcheakoutviewDetail_createTime >", value, "addcheakoutviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_createTime >=", value, "addcheakoutviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailCreatetimeLessThan(String value) {
            addCriterion("addcheakoutviewDetail_createTime <", value, "addcheakoutviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_createTime <=", value, "addcheakoutviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailCreatetimeLike(String value) {
            addCriterion("addcheakoutviewDetail_createTime like", value, "addcheakoutviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailCreatetimeNotLike(String value) {
            addCriterion("addcheakoutviewDetail_createTime not like", value, "addcheakoutviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailCreatetimeIn(List<String> values) {
            addCriterion("addcheakoutviewDetail_createTime in", values, "addcheakoutviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailCreatetimeNotIn(List<String> values) {
            addCriterion("addcheakoutviewDetail_createTime not in", values, "addcheakoutviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailCreatetimeBetween(String value1, String value2) {
            addCriterion("addcheakoutviewDetail_createTime between", value1, value2, "addcheakoutviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailCreatetimeNotBetween(String value1, String value2) {
            addCriterion("addcheakoutviewDetail_createTime not between", value1, value2, "addcheakoutviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailMotifytimeIsNull() {
            addCriterion("addcheakoutviewDetail_motifyTime is null");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailMotifytimeIsNotNull() {
            addCriterion("addcheakoutviewDetail_motifyTime is not null");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailMotifytimeEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_motifyTime =", value, "addcheakoutviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailMotifytimeNotEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_motifyTime <>", value, "addcheakoutviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailMotifytimeGreaterThan(String value) {
            addCriterion("addcheakoutviewDetail_motifyTime >", value, "addcheakoutviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailMotifytimeGreaterThanOrEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_motifyTime >=", value, "addcheakoutviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailMotifytimeLessThan(String value) {
            addCriterion("addcheakoutviewDetail_motifyTime <", value, "addcheakoutviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailMotifytimeLessThanOrEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_motifyTime <=", value, "addcheakoutviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailMotifytimeLike(String value) {
            addCriterion("addcheakoutviewDetail_motifyTime like", value, "addcheakoutviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailMotifytimeNotLike(String value) {
            addCriterion("addcheakoutviewDetail_motifyTime not like", value, "addcheakoutviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailMotifytimeIn(List<String> values) {
            addCriterion("addcheakoutviewDetail_motifyTime in", values, "addcheakoutviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailMotifytimeNotIn(List<String> values) {
            addCriterion("addcheakoutviewDetail_motifyTime not in", values, "addcheakoutviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailMotifytimeBetween(String value1, String value2) {
            addCriterion("addcheakoutviewDetail_motifyTime between", value1, value2, "addcheakoutviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailMotifytimeNotBetween(String value1, String value2) {
            addCriterion("addcheakoutviewDetail_motifyTime not between", value1, value2, "addcheakoutviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailStarttimeIsNull() {
            addCriterion("addcheakoutviewDetail_starttime is null");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailStarttimeIsNotNull() {
            addCriterion("addcheakoutviewDetail_starttime is not null");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailStarttimeEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_starttime =", value, "addcheakoutviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailStarttimeNotEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_starttime <>", value, "addcheakoutviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailStarttimeGreaterThan(String value) {
            addCriterion("addcheakoutviewDetail_starttime >", value, "addcheakoutviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailStarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_starttime >=", value, "addcheakoutviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailStarttimeLessThan(String value) {
            addCriterion("addcheakoutviewDetail_starttime <", value, "addcheakoutviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailStarttimeLessThanOrEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_starttime <=", value, "addcheakoutviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailStarttimeLike(String value) {
            addCriterion("addcheakoutviewDetail_starttime like", value, "addcheakoutviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailStarttimeNotLike(String value) {
            addCriterion("addcheakoutviewDetail_starttime not like", value, "addcheakoutviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailStarttimeIn(List<String> values) {
            addCriterion("addcheakoutviewDetail_starttime in", values, "addcheakoutviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailStarttimeNotIn(List<String> values) {
            addCriterion("addcheakoutviewDetail_starttime not in", values, "addcheakoutviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailStarttimeBetween(String value1, String value2) {
            addCriterion("addcheakoutviewDetail_starttime between", value1, value2, "addcheakoutviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailStarttimeNotBetween(String value1, String value2) {
            addCriterion("addcheakoutviewDetail_starttime not between", value1, value2, "addcheakoutviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailEndtimeIsNull() {
            addCriterion("addcheakoutviewDetail_endtime is null");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailEndtimeIsNotNull() {
            addCriterion("addcheakoutviewDetail_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailEndtimeEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_endtime =", value, "addcheakoutviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailEndtimeNotEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_endtime <>", value, "addcheakoutviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailEndtimeGreaterThan(String value) {
            addCriterion("addcheakoutviewDetail_endtime >", value, "addcheakoutviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_endtime >=", value, "addcheakoutviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailEndtimeLessThan(String value) {
            addCriterion("addcheakoutviewDetail_endtime <", value, "addcheakoutviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailEndtimeLessThanOrEqualTo(String value) {
            addCriterion("addcheakoutviewDetail_endtime <=", value, "addcheakoutviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailEndtimeLike(String value) {
            addCriterion("addcheakoutviewDetail_endtime like", value, "addcheakoutviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailEndtimeNotLike(String value) {
            addCriterion("addcheakoutviewDetail_endtime not like", value, "addcheakoutviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailEndtimeIn(List<String> values) {
            addCriterion("addcheakoutviewDetail_endtime in", values, "addcheakoutviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailEndtimeNotIn(List<String> values) {
            addCriterion("addcheakoutviewDetail_endtime not in", values, "addcheakoutviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailEndtimeBetween(String value1, String value2) {
            addCriterion("addcheakoutviewDetail_endtime between", value1, value2, "addcheakoutviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddcheakoutviewdetailEndtimeNotBetween(String value1, String value2) {
            addCriterion("addcheakoutviewDetail_endtime not between", value1, value2, "addcheakoutviewdetailEndtime");
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