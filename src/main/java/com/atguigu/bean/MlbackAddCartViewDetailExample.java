package com.atguigu.bean;

import java.util.ArrayList;
import java.util.List;

public class MlbackAddCartViewDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MlbackAddCartViewDetailExample() {
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

        public Criteria andAddcartviewdetailIdIsNull() {
            addCriterion("addcartViewDetail_id is null");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailIdIsNotNull() {
            addCriterion("addcartViewDetail_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailIdEqualTo(Integer value) {
            addCriterion("addcartViewDetail_id =", value, "addcartviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailIdNotEqualTo(Integer value) {
            addCriterion("addcartViewDetail_id <>", value, "addcartviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailIdGreaterThan(Integer value) {
            addCriterion("addcartViewDetail_id >", value, "addcartviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("addcartViewDetail_id >=", value, "addcartviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailIdLessThan(Integer value) {
            addCriterion("addcartViewDetail_id <", value, "addcartviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("addcartViewDetail_id <=", value, "addcartviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailIdIn(List<Integer> values) {
            addCriterion("addcartViewDetail_id in", values, "addcartviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailIdNotIn(List<Integer> values) {
            addCriterion("addcartViewDetail_id not in", values, "addcartviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailIdBetween(Integer value1, Integer value2) {
            addCriterion("addcartViewDetail_id between", value1, value2, "addcartviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("addcartViewDetail_id not between", value1, value2, "addcartviewdetailId");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSessionidIsNull() {
            addCriterion("addcartViewDetail_sessionid is null");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSessionidIsNotNull() {
            addCriterion("addcartViewDetail_sessionid is not null");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSessionidEqualTo(String value) {
            addCriterion("addcartViewDetail_sessionid =", value, "addcartviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSessionidNotEqualTo(String value) {
            addCriterion("addcartViewDetail_sessionid <>", value, "addcartviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSessionidGreaterThan(String value) {
            addCriterion("addcartViewDetail_sessionid >", value, "addcartviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSessionidGreaterThanOrEqualTo(String value) {
            addCriterion("addcartViewDetail_sessionid >=", value, "addcartviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSessionidLessThan(String value) {
            addCriterion("addcartViewDetail_sessionid <", value, "addcartviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSessionidLessThanOrEqualTo(String value) {
            addCriterion("addcartViewDetail_sessionid <=", value, "addcartviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSessionidLike(String value) {
            addCriterion("addcartViewDetail_sessionid like", value, "addcartviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSessionidNotLike(String value) {
            addCriterion("addcartViewDetail_sessionid not like", value, "addcartviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSessionidIn(List<String> values) {
            addCriterion("addcartViewDetail_sessionid in", values, "addcartviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSessionidNotIn(List<String> values) {
            addCriterion("addcartViewDetail_sessionid not in", values, "addcartviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSessionidBetween(String value1, String value2) {
            addCriterion("addcartViewDetail_sessionid between", value1, value2, "addcartviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSessionidNotBetween(String value1, String value2) {
            addCriterion("addcartViewDetail_sessionid not between", value1, value2, "addcartviewdetailSessionid");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailNameIsNull() {
            addCriterion("addcartViewDetail_name is null");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailNameIsNotNull() {
            addCriterion("addcartViewDetail_name is not null");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailNameEqualTo(String value) {
            addCriterion("addcartViewDetail_name =", value, "addcartviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailNameNotEqualTo(String value) {
            addCriterion("addcartViewDetail_name <>", value, "addcartviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailNameGreaterThan(String value) {
            addCriterion("addcartViewDetail_name >", value, "addcartviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailNameGreaterThanOrEqualTo(String value) {
            addCriterion("addcartViewDetail_name >=", value, "addcartviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailNameLessThan(String value) {
            addCriterion("addcartViewDetail_name <", value, "addcartviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailNameLessThanOrEqualTo(String value) {
            addCriterion("addcartViewDetail_name <=", value, "addcartviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailNameLike(String value) {
            addCriterion("addcartViewDetail_name like", value, "addcartviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailNameNotLike(String value) {
            addCriterion("addcartViewDetail_name not like", value, "addcartviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailNameIn(List<String> values) {
            addCriterion("addcartViewDetail_name in", values, "addcartviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailNameNotIn(List<String> values) {
            addCriterion("addcartViewDetail_name not in", values, "addcartviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailNameBetween(String value1, String value2) {
            addCriterion("addcartViewDetail_name between", value1, value2, "addcartviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailNameNotBetween(String value1, String value2) {
            addCriterion("addcartViewDetail_name not between", value1, value2, "addcartviewdetailName");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailProidIsNull() {
            addCriterion("addcartViewDetail_proid is null");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailProidIsNotNull() {
            addCriterion("addcartViewDetail_proid is not null");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailProidEqualTo(Integer value) {
            addCriterion("addcartViewDetail_proid =", value, "addcartviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailProidNotEqualTo(Integer value) {
            addCriterion("addcartViewDetail_proid <>", value, "addcartviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailProidGreaterThan(Integer value) {
            addCriterion("addcartViewDetail_proid >", value, "addcartviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailProidGreaterThanOrEqualTo(Integer value) {
            addCriterion("addcartViewDetail_proid >=", value, "addcartviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailProidLessThan(Integer value) {
            addCriterion("addcartViewDetail_proid <", value, "addcartviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailProidLessThanOrEqualTo(Integer value) {
            addCriterion("addcartViewDetail_proid <=", value, "addcartviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailProidIn(List<Integer> values) {
            addCriterion("addcartViewDetail_proid in", values, "addcartviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailProidNotIn(List<Integer> values) {
            addCriterion("addcartViewDetail_proid not in", values, "addcartviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailProidBetween(Integer value1, Integer value2) {
            addCriterion("addcartViewDetail_proid between", value1, value2, "addcartviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailProidNotBetween(Integer value1, Integer value2) {
            addCriterion("addcartViewDetail_proid not between", value1, value2, "addcartviewdetailProid");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailPronameIsNull() {
            addCriterion("addcartViewDetail_proname is null");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailPronameIsNotNull() {
            addCriterion("addcartViewDetail_proname is not null");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailPronameEqualTo(String value) {
            addCriterion("addcartViewDetail_proname =", value, "addcartviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailPronameNotEqualTo(String value) {
            addCriterion("addcartViewDetail_proname <>", value, "addcartviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailPronameGreaterThan(String value) {
            addCriterion("addcartViewDetail_proname >", value, "addcartviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailPronameGreaterThanOrEqualTo(String value) {
            addCriterion("addcartViewDetail_proname >=", value, "addcartviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailPronameLessThan(String value) {
            addCriterion("addcartViewDetail_proname <", value, "addcartviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailPronameLessThanOrEqualTo(String value) {
            addCriterion("addcartViewDetail_proname <=", value, "addcartviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailPronameLike(String value) {
            addCriterion("addcartViewDetail_proname like", value, "addcartviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailPronameNotLike(String value) {
            addCriterion("addcartViewDetail_proname not like", value, "addcartviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailPronameIn(List<String> values) {
            addCriterion("addcartViewDetail_proname in", values, "addcartviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailPronameNotIn(List<String> values) {
            addCriterion("addcartViewDetail_proname not in", values, "addcartviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailPronameBetween(String value1, String value2) {
            addCriterion("addcartViewDetail_proname between", value1, value2, "addcartviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailPronameNotBetween(String value1, String value2) {
            addCriterion("addcartViewDetail_proname not between", value1, value2, "addcartviewdetailProname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSeonameIsNull() {
            addCriterion("addcartViewDetail_seoname is null");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSeonameIsNotNull() {
            addCriterion("addcartViewDetail_seoname is not null");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSeonameEqualTo(String value) {
            addCriterion("addcartViewDetail_seoname =", value, "addcartviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSeonameNotEqualTo(String value) {
            addCriterion("addcartViewDetail_seoname <>", value, "addcartviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSeonameGreaterThan(String value) {
            addCriterion("addcartViewDetail_seoname >", value, "addcartviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSeonameGreaterThanOrEqualTo(String value) {
            addCriterion("addcartViewDetail_seoname >=", value, "addcartviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSeonameLessThan(String value) {
            addCriterion("addcartViewDetail_seoname <", value, "addcartviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSeonameLessThanOrEqualTo(String value) {
            addCriterion("addcartViewDetail_seoname <=", value, "addcartviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSeonameLike(String value) {
            addCriterion("addcartViewDetail_seoname like", value, "addcartviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSeonameNotLike(String value) {
            addCriterion("addcartViewDetail_seoname not like", value, "addcartviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSeonameIn(List<String> values) {
            addCriterion("addcartViewDetail_seoname in", values, "addcartviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSeonameNotIn(List<String> values) {
            addCriterion("addcartViewDetail_seoname not in", values, "addcartviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSeonameBetween(String value1, String value2) {
            addCriterion("addcartViewDetail_seoname between", value1, value2, "addcartviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailSeonameNotBetween(String value1, String value2) {
            addCriterion("addcartViewDetail_seoname not between", value1, value2, "addcartviewdetailSeoname");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailCreatetimeIsNull() {
            addCriterion("addcartViewDetail_createTime is null");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailCreatetimeIsNotNull() {
            addCriterion("addcartViewDetail_createTime is not null");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailCreatetimeEqualTo(String value) {
            addCriterion("addcartViewDetail_createTime =", value, "addcartviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailCreatetimeNotEqualTo(String value) {
            addCriterion("addcartViewDetail_createTime <>", value, "addcartviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailCreatetimeGreaterThan(String value) {
            addCriterion("addcartViewDetail_createTime >", value, "addcartviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("addcartViewDetail_createTime >=", value, "addcartviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailCreatetimeLessThan(String value) {
            addCriterion("addcartViewDetail_createTime <", value, "addcartviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("addcartViewDetail_createTime <=", value, "addcartviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailCreatetimeLike(String value) {
            addCriterion("addcartViewDetail_createTime like", value, "addcartviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailCreatetimeNotLike(String value) {
            addCriterion("addcartViewDetail_createTime not like", value, "addcartviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailCreatetimeIn(List<String> values) {
            addCriterion("addcartViewDetail_createTime in", values, "addcartviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailCreatetimeNotIn(List<String> values) {
            addCriterion("addcartViewDetail_createTime not in", values, "addcartviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailCreatetimeBetween(String value1, String value2) {
            addCriterion("addcartViewDetail_createTime between", value1, value2, "addcartviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailCreatetimeNotBetween(String value1, String value2) {
            addCriterion("addcartViewDetail_createTime not between", value1, value2, "addcartviewdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailMotifytimeIsNull() {
            addCriterion("addcartViewDetail_motifyTime is null");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailMotifytimeIsNotNull() {
            addCriterion("addcartViewDetail_motifyTime is not null");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailMotifytimeEqualTo(String value) {
            addCriterion("addcartViewDetail_motifyTime =", value, "addcartviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailMotifytimeNotEqualTo(String value) {
            addCriterion("addcartViewDetail_motifyTime <>", value, "addcartviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailMotifytimeGreaterThan(String value) {
            addCriterion("addcartViewDetail_motifyTime >", value, "addcartviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailMotifytimeGreaterThanOrEqualTo(String value) {
            addCriterion("addcartViewDetail_motifyTime >=", value, "addcartviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailMotifytimeLessThan(String value) {
            addCriterion("addcartViewDetail_motifyTime <", value, "addcartviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailMotifytimeLessThanOrEqualTo(String value) {
            addCriterion("addcartViewDetail_motifyTime <=", value, "addcartviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailMotifytimeLike(String value) {
            addCriterion("addcartViewDetail_motifyTime like", value, "addcartviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailMotifytimeNotLike(String value) {
            addCriterion("addcartViewDetail_motifyTime not like", value, "addcartviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailMotifytimeIn(List<String> values) {
            addCriterion("addcartViewDetail_motifyTime in", values, "addcartviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailMotifytimeNotIn(List<String> values) {
            addCriterion("addcartViewDetail_motifyTime not in", values, "addcartviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailMotifytimeBetween(String value1, String value2) {
            addCriterion("addcartViewDetail_motifyTime between", value1, value2, "addcartviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailMotifytimeNotBetween(String value1, String value2) {
            addCriterion("addcartViewDetail_motifyTime not between", value1, value2, "addcartviewdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailStarttimeIsNull() {
            addCriterion("addcartViewDetail_starttime is null");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailStarttimeIsNotNull() {
            addCriterion("addcartViewDetail_starttime is not null");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailStarttimeEqualTo(String value) {
            addCriterion("addcartViewDetail_starttime =", value, "addcartviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailStarttimeNotEqualTo(String value) {
            addCriterion("addcartViewDetail_starttime <>", value, "addcartviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailStarttimeGreaterThan(String value) {
            addCriterion("addcartViewDetail_starttime >", value, "addcartviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailStarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("addcartViewDetail_starttime >=", value, "addcartviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailStarttimeLessThan(String value) {
            addCriterion("addcartViewDetail_starttime <", value, "addcartviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailStarttimeLessThanOrEqualTo(String value) {
            addCriterion("addcartViewDetail_starttime <=", value, "addcartviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailStarttimeLike(String value) {
            addCriterion("addcartViewDetail_starttime like", value, "addcartviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailStarttimeNotLike(String value) {
            addCriterion("addcartViewDetail_starttime not like", value, "addcartviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailStarttimeIn(List<String> values) {
            addCriterion("addcartViewDetail_starttime in", values, "addcartviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailStarttimeNotIn(List<String> values) {
            addCriterion("addcartViewDetail_starttime not in", values, "addcartviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailStarttimeBetween(String value1, String value2) {
            addCriterion("addcartViewDetail_starttime between", value1, value2, "addcartviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailStarttimeNotBetween(String value1, String value2) {
            addCriterion("addcartViewDetail_starttime not between", value1, value2, "addcartviewdetailStarttime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailEndtimeIsNull() {
            addCriterion("addcartViewDetail_endtime is null");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailEndtimeIsNotNull() {
            addCriterion("addcartViewDetail_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailEndtimeEqualTo(String value) {
            addCriterion("addcartViewDetail_endtime =", value, "addcartviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailEndtimeNotEqualTo(String value) {
            addCriterion("addcartViewDetail_endtime <>", value, "addcartviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailEndtimeGreaterThan(String value) {
            addCriterion("addcartViewDetail_endtime >", value, "addcartviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("addcartViewDetail_endtime >=", value, "addcartviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailEndtimeLessThan(String value) {
            addCriterion("addcartViewDetail_endtime <", value, "addcartviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailEndtimeLessThanOrEqualTo(String value) {
            addCriterion("addcartViewDetail_endtime <=", value, "addcartviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailEndtimeLike(String value) {
            addCriterion("addcartViewDetail_endtime like", value, "addcartviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailEndtimeNotLike(String value) {
            addCriterion("addcartViewDetail_endtime not like", value, "addcartviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailEndtimeIn(List<String> values) {
            addCriterion("addcartViewDetail_endtime in", values, "addcartviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailEndtimeNotIn(List<String> values) {
            addCriterion("addcartViewDetail_endtime not in", values, "addcartviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailEndtimeBetween(String value1, String value2) {
            addCriterion("addcartViewDetail_endtime between", value1, value2, "addcartviewdetailEndtime");
            return (Criteria) this;
        }

        public Criteria andAddcartviewdetailEndtimeNotBetween(String value1, String value2) {
            addCriterion("addcartViewDetail_endtime not between", value1, value2, "addcartviewdetailEndtime");
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