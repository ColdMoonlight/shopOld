package com.atguigu.bean;

import java.util.ArrayList;
import java.util.List;

public class MlbackAddOrderViewDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MlbackAddOrderViewDetailExample() {
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

        public Criteria andAddorderviewdetailIdIsNull() {
            addCriterion("addorderViewDetail_id is null");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailIdIsNotNull() {
            addCriterion("addorderViewDetail_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailIdEqualTo(Integer value) {
            addCriterion("addorderViewDetail_id =", value, "addorderviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailIdNotEqualTo(Integer value) {
            addCriterion("addorderViewDetail_id <>", value, "addorderviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailIdGreaterThan(Integer value) {
            addCriterion("addorderViewDetail_id >", value, "addorderviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("addorderViewDetail_id >=", value, "addorderviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailIdLessThan(Integer value) {
            addCriterion("addorderViewDetail_id <", value, "addorderviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("addorderViewDetail_id <=", value, "addorderviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailIdIn(List<Integer> values) {
            addCriterion("addorderViewDetail_id in", values, "addorderviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailIdNotIn(List<Integer> values) {
            addCriterion("addorderViewDetail_id not in", values, "addorderviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailIdBetween(Integer value1, Integer value2) {
            addCriterion("addorderViewDetail_id between", value1, value2, "addorderviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("addorderViewDetail_id not between", value1, value2, "addorderviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSessionidIsNull() {
            addCriterion("addorderViewDetail_sessionid is null");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSessionidIsNotNull() {
            addCriterion("addorderViewDetail_sessionid is not null");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSessionidEqualTo(String value) {
            addCriterion("addorderViewDetail_sessionid =", value, "addorderviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSessionidNotEqualTo(String value) {
            addCriterion("addorderViewDetail_sessionid <>", value, "addorderviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSessionidGreaterThan(String value) {
            addCriterion("addorderViewDetail_sessionid >", value, "addorderviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSessionidGreaterThanOrEqualTo(String value) {
            addCriterion("addorderViewDetail_sessionid >=", value, "addorderviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSessionidLessThan(String value) {
            addCriterion("addorderViewDetail_sessionid <", value, "addorderviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSessionidLessThanOrEqualTo(String value) {
            addCriterion("addorderViewDetail_sessionid <=", value, "addorderviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSessionidLike(String value) {
            addCriterion("addorderViewDetail_sessionid like", value, "addorderviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSessionidNotLike(String value) {
            addCriterion("addorderViewDetail_sessionid not like", value, "addorderviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSessionidIn(List<String> values) {
            addCriterion("addorderViewDetail_sessionid in", values, "addorderviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSessionidNotIn(List<String> values) {
            addCriterion("addorderViewDetail_sessionid not in", values, "addorderviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSessionidBetween(String value1, String value2) {
            addCriterion("addorderViewDetail_sessionid between", value1, value2, "addorderviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSessionidNotBetween(String value1, String value2) {
            addCriterion("addorderViewDetail_sessionid not between", value1, value2, "addorderviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailNameIsNull() {
            addCriterion("addorderViewDetail_name is null");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailNameIsNotNull() {
            addCriterion("addorderViewDetail_name is not null");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailNameEqualTo(String value) {
            addCriterion("addorderViewDetail_name =", value, "addorderviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailNameNotEqualTo(String value) {
            addCriterion("addorderViewDetail_name <>", value, "addorderviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailNameGreaterThan(String value) {
            addCriterion("addorderViewDetail_name >", value, "addorderviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailNameGreaterThanOrEqualTo(String value) {
            addCriterion("addorderViewDetail_name >=", value, "addorderviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailNameLessThan(String value) {
            addCriterion("addorderViewDetail_name <", value, "addorderviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailNameLessThanOrEqualTo(String value) {
            addCriterion("addorderViewDetail_name <=", value, "addorderviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailNameLike(String value) {
            addCriterion("addorderViewDetail_name like", value, "addorderviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailNameNotLike(String value) {
            addCriterion("addorderViewDetail_name not like", value, "addorderviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailNameIn(List<String> values) {
            addCriterion("addorderViewDetail_name in", values, "addorderviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailNameNotIn(List<String> values) {
            addCriterion("addorderViewDetail_name not in", values, "addorderviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailNameBetween(String value1, String value2) {
            addCriterion("addorderViewDetail_name between", value1, value2, "addorderviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailNameNotBetween(String value1, String value2) {
            addCriterion("addorderViewDetail_name not between", value1, value2, "addorderviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailProidIsNull() {
            addCriterion("addorderViewDetail_proid is null");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailProidIsNotNull() {
            addCriterion("addorderViewDetail_proid is not null");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailProidEqualTo(Integer value) {
            addCriterion("addorderViewDetail_proid =", value, "addorderviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailProidNotEqualTo(Integer value) {
            addCriterion("addorderViewDetail_proid <>", value, "addorderviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailProidGreaterThan(Integer value) {
            addCriterion("addorderViewDetail_proid >", value, "addorderviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailProidGreaterThanOrEqualTo(Integer value) {
            addCriterion("addorderViewDetail_proid >=", value, "addorderviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailProidLessThan(Integer value) {
            addCriterion("addorderViewDetail_proid <", value, "addorderviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailProidLessThanOrEqualTo(Integer value) {
            addCriterion("addorderViewDetail_proid <=", value, "addorderviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailProidIn(List<Integer> values) {
            addCriterion("addorderViewDetail_proid in", values, "addorderviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailProidNotIn(List<Integer> values) {
            addCriterion("addorderViewDetail_proid not in", values, "addorderviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailProidBetween(Integer value1, Integer value2) {
            addCriterion("addorderViewDetail_proid between", value1, value2, "addorderviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailProidNotBetween(Integer value1, Integer value2) {
            addCriterion("addorderViewDetail_proid not between", value1, value2, "addorderviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailPronameIsNull() {
            addCriterion("addorderViewDetail_proname is null");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailPronameIsNotNull() {
            addCriterion("addorderViewDetail_proname is not null");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailPronameEqualTo(String value) {
            addCriterion("addorderViewDetail_proname =", value, "addorderviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailPronameNotEqualTo(String value) {
            addCriterion("addorderViewDetail_proname <>", value, "addorderviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailPronameGreaterThan(String value) {
            addCriterion("addorderViewDetail_proname >", value, "addorderviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailPronameGreaterThanOrEqualTo(String value) {
            addCriterion("addorderViewDetail_proname >=", value, "addorderviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailPronameLessThan(String value) {
            addCriterion("addorderViewDetail_proname <", value, "addorderviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailPronameLessThanOrEqualTo(String value) {
            addCriterion("addorderViewDetail_proname <=", value, "addorderviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailPronameLike(String value) {
            addCriterion("addorderViewDetail_proname like", value, "addorderviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailPronameNotLike(String value) {
            addCriterion("addorderViewDetail_proname not like", value, "addorderviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailPronameIn(List<String> values) {
            addCriterion("addorderViewDetail_proname in", values, "addorderviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailPronameNotIn(List<String> values) {
            addCriterion("addorderViewDetail_proname not in", values, "addorderviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailPronameBetween(String value1, String value2) {
            addCriterion("addorderViewDetail_proname between", value1, value2, "addorderviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailPronameNotBetween(String value1, String value2) {
            addCriterion("addorderViewDetail_proname not between", value1, value2, "addorderviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSeonameIsNull() {
            addCriterion("addorderViewDetail_seoname is null");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSeonameIsNotNull() {
            addCriterion("addorderViewDetail_seoname is not null");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSeonameEqualTo(String value) {
            addCriterion("addorderViewDetail_seoname =", value, "addorderviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSeonameNotEqualTo(String value) {
            addCriterion("addorderViewDetail_seoname <>", value, "addorderviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSeonameGreaterThan(String value) {
            addCriterion("addorderViewDetail_seoname >", value, "addorderviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSeonameGreaterThanOrEqualTo(String value) {
            addCriterion("addorderViewDetail_seoname >=", value, "addorderviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSeonameLessThan(String value) {
            addCriterion("addorderViewDetail_seoname <", value, "addorderviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSeonameLessThanOrEqualTo(String value) {
            addCriterion("addorderViewDetail_seoname <=", value, "addorderviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSeonameLike(String value) {
            addCriterion("addorderViewDetail_seoname like", value, "addorderviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSeonameNotLike(String value) {
            addCriterion("addorderViewDetail_seoname not like", value, "addorderviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSeonameIn(List<String> values) {
            addCriterion("addorderViewDetail_seoname in", values, "addorderviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSeonameNotIn(List<String> values) {
            addCriterion("addorderViewDetail_seoname not in", values, "addorderviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSeonameBetween(String value1, String value2) {
            addCriterion("addorderViewDetail_seoname between", value1, value2, "addorderviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailSeonameNotBetween(String value1, String value2) {
            addCriterion("addorderViewDetail_seoname not between", value1, value2, "addorderviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailActnumIsNull() {
            addCriterion("addorderViewDetail_actnum is null");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailActnumIsNotNull() {
            addCriterion("addorderViewDetail_actnum is not null");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailActnumEqualTo(Integer value) {
            addCriterion("addorderViewDetail_actnum =", value, "addorderviewdetailActnum");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailActnumNotEqualTo(Integer value) {
            addCriterion("addorderViewDetail_actnum <>", value, "addorderviewdetailActnum");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailActnumGreaterThan(Integer value) {
            addCriterion("addorderViewDetail_actnum >", value, "addorderviewdetailActnum");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailActnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("addorderViewDetail_actnum >=", value, "addorderviewdetailActnum");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailActnumLessThan(Integer value) {
            addCriterion("addorderViewDetail_actnum <", value, "addorderviewdetailActnum");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailActnumLessThanOrEqualTo(Integer value) {
            addCriterion("addorderViewDetail_actnum <=", value, "addorderviewdetailActnum");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailActnumIn(List<Integer> values) {
            addCriterion("addorderViewDetail_actnum in", values, "addorderviewdetailActnum");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailActnumNotIn(List<Integer> values) {
            addCriterion("addorderViewDetail_actnum not in", values, "addorderviewdetailActnum");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailActnumBetween(Integer value1, Integer value2) {
            addCriterion("addorderViewDetail_actnum between", value1, value2, "addorderviewdetailActnum");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailActnumNotBetween(Integer value1, Integer value2) {
            addCriterion("addorderViewDetail_actnum not between", value1, value2, "addorderviewdetailActnum");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailCreatetimeIsNull() {
            addCriterion("addorderViewDetail_createTime is null");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailCreatetimeIsNotNull() {
            addCriterion("addorderViewDetail_createTime is not null");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailCreatetimeEqualTo(String value) {
            addCriterion("addorderViewDetail_createTime =", value, "addorderviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailCreatetimeNotEqualTo(String value) {
            addCriterion("addorderViewDetail_createTime <>", value, "addorderviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailCreatetimeGreaterThan(String value) {
            addCriterion("addorderViewDetail_createTime >", value, "addorderviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("addorderViewDetail_createTime >=", value, "addorderviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailCreatetimeLessThan(String value) {
            addCriterion("addorderViewDetail_createTime <", value, "addorderviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("addorderViewDetail_createTime <=", value, "addorderviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailCreatetimeLike(String value) {
            addCriterion("addorderViewDetail_createTime like", value, "addorderviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailCreatetimeNotLike(String value) {
            addCriterion("addorderViewDetail_createTime not like", value, "addorderviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailCreatetimeIn(List<String> values) {
            addCriterion("addorderViewDetail_createTime in", values, "addorderviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailCreatetimeNotIn(List<String> values) {
            addCriterion("addorderViewDetail_createTime not in", values, "addorderviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailCreatetimeBetween(String value1, String value2) {
            addCriterion("addorderViewDetail_createTime between", value1, value2, "addorderviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailCreatetimeNotBetween(String value1, String value2) {
            addCriterion("addorderViewDetail_createTime not between", value1, value2, "addorderviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailMotifytimeIsNull() {
            addCriterion("addorderViewDetail_motifyTime is null");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailMotifytimeIsNotNull() {
            addCriterion("addorderViewDetail_motifyTime is not null");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailMotifytimeEqualTo(String value) {
            addCriterion("addorderViewDetail_motifyTime =", value, "addorderviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailMotifytimeNotEqualTo(String value) {
            addCriterion("addorderViewDetail_motifyTime <>", value, "addorderviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailMotifytimeGreaterThan(String value) {
            addCriterion("addorderViewDetail_motifyTime >", value, "addorderviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailMotifytimeGreaterThanOrEqualTo(String value) {
            addCriterion("addorderViewDetail_motifyTime >=", value, "addorderviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailMotifytimeLessThan(String value) {
            addCriterion("addorderViewDetail_motifyTime <", value, "addorderviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailMotifytimeLessThanOrEqualTo(String value) {
            addCriterion("addorderViewDetail_motifyTime <=", value, "addorderviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailMotifytimeLike(String value) {
            addCriterion("addorderViewDetail_motifyTime like", value, "addorderviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailMotifytimeNotLike(String value) {
            addCriterion("addorderViewDetail_motifyTime not like", value, "addorderviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailMotifytimeIn(List<String> values) {
            addCriterion("addorderViewDetail_motifyTime in", values, "addorderviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailMotifytimeNotIn(List<String> values) {
            addCriterion("addorderViewDetail_motifyTime not in", values, "addorderviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailMotifytimeBetween(String value1, String value2) {
            addCriterion("addorderViewDetail_motifyTime between", value1, value2, "addorderviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailMotifytimeNotBetween(String value1, String value2) {
            addCriterion("addorderViewDetail_motifyTime not between", value1, value2, "addorderviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailStarttimeIsNull() {
            addCriterion("addorderViewDetail_starttime is null");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailStarttimeIsNotNull() {
            addCriterion("addorderViewDetail_starttime is not null");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailStarttimeEqualTo(String value) {
            addCriterion("addorderViewDetail_starttime =", value, "addorderviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailStarttimeNotEqualTo(String value) {
            addCriterion("addorderViewDetail_starttime <>", value, "addorderviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailStarttimeGreaterThan(String value) {
            addCriterion("addorderViewDetail_starttime >", value, "addorderviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailStarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("addorderViewDetail_starttime >=", value, "addorderviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailStarttimeLessThan(String value) {
            addCriterion("addorderViewDetail_starttime <", value, "addorderviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailStarttimeLessThanOrEqualTo(String value) {
            addCriterion("addorderViewDetail_starttime <=", value, "addorderviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailStarttimeLike(String value) {
            addCriterion("addorderViewDetail_starttime like", value, "addorderviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailStarttimeNotLike(String value) {
            addCriterion("addorderViewDetail_starttime not like", value, "addorderviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailStarttimeIn(List<String> values) {
            addCriterion("addorderViewDetail_starttime in", values, "addorderviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailStarttimeNotIn(List<String> values) {
            addCriterion("addorderViewDetail_starttime not in", values, "addorderviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailStarttimeBetween(String value1, String value2) {
            addCriterion("addorderViewDetail_starttime between", value1, value2, "addorderviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailStarttimeNotBetween(String value1, String value2) {
            addCriterion("addorderViewDetail_starttime not between", value1, value2, "addorderviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailEndtimeIsNull() {
            addCriterion("addorderViewDetail_endtime is null");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailEndtimeIsNotNull() {
            addCriterion("addorderViewDetail_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailEndtimeEqualTo(String value) {
            addCriterion("addorderViewDetail_endtime =", value, "addorderviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailEndtimeNotEqualTo(String value) {
            addCriterion("addorderViewDetail_endtime <>", value, "addorderviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailEndtimeGreaterThan(String value) {
            addCriterion("addorderViewDetail_endtime >", value, "addorderviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("addorderViewDetail_endtime >=", value, "addorderviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailEndtimeLessThan(String value) {
            addCriterion("addorderViewDetail_endtime <", value, "addorderviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailEndtimeLessThanOrEqualTo(String value) {
            addCriterion("addorderViewDetail_endtime <=", value, "addorderviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailEndtimeLike(String value) {
            addCriterion("addorderViewDetail_endtime like", value, "addorderviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailEndtimeNotLike(String value) {
            addCriterion("addorderViewDetail_endtime not like", value, "addorderviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailEndtimeIn(List<String> values) {
            addCriterion("addorderViewDetail_endtime in", values, "addorderviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailEndtimeNotIn(List<String> values) {
            addCriterion("addorderViewDetail_endtime not in", values, "addorderviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailEndtimeBetween(String value1, String value2) {
            addCriterion("addorderViewDetail_endtime between", value1, value2, "addorderviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddorderviewdetailEndtimeNotBetween(String value1, String value2) {
            addCriterion("addorderViewDetail_endtime not between", value1, value2, "addorderviewdetailEndtime");
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