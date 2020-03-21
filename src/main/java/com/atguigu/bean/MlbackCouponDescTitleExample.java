package com.atguigu.bean;

import java.util.ArrayList;
import java.util.List;

public class MlbackCouponDescTitleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MlbackCouponDescTitleExample() {
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

        public Criteria andCoupondesctieleIdIsNull() {
            addCriterion("coupondesctiele_id is null");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleIdIsNotNull() {
            addCriterion("coupondesctiele_id is not null");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleIdEqualTo(Integer value) {
            addCriterion("coupondesctiele_id =", value, "coupondesctieleId");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleIdNotEqualTo(Integer value) {
            addCriterion("coupondesctiele_id <>", value, "coupondesctieleId");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleIdGreaterThan(Integer value) {
            addCriterion("coupondesctiele_id >", value, "coupondesctieleId");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupondesctiele_id >=", value, "coupondesctieleId");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleIdLessThan(Integer value) {
            addCriterion("coupondesctiele_id <", value, "coupondesctieleId");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleIdLessThanOrEqualTo(Integer value) {
            addCriterion("coupondesctiele_id <=", value, "coupondesctieleId");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleIdIn(List<Integer> values) {
            addCriterion("coupondesctiele_id in", values, "coupondesctieleId");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleIdNotIn(List<Integer> values) {
            addCriterion("coupondesctiele_id not in", values, "coupondesctieleId");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleIdBetween(Integer value1, Integer value2) {
            addCriterion("coupondesctiele_id between", value1, value2, "coupondesctieleId");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("coupondesctiele_id not between", value1, value2, "coupondesctieleId");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleNameIsNull() {
            addCriterion("coupondesctiele_name is null");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleNameIsNotNull() {
            addCriterion("coupondesctiele_name is not null");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleNameEqualTo(String value) {
            addCriterion("coupondesctiele_name =", value, "coupondesctieleName");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleNameNotEqualTo(String value) {
            addCriterion("coupondesctiele_name <>", value, "coupondesctieleName");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleNameGreaterThan(String value) {
            addCriterion("coupondesctiele_name >", value, "coupondesctieleName");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleNameGreaterThanOrEqualTo(String value) {
            addCriterion("coupondesctiele_name >=", value, "coupondesctieleName");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleNameLessThan(String value) {
            addCriterion("coupondesctiele_name <", value, "coupondesctieleName");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleNameLessThanOrEqualTo(String value) {
            addCriterion("coupondesctiele_name <=", value, "coupondesctieleName");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleNameLike(String value) {
            addCriterion("coupondesctiele_name like", value, "coupondesctieleName");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleNameNotLike(String value) {
            addCriterion("coupondesctiele_name not like", value, "coupondesctieleName");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleNameIn(List<String> values) {
            addCriterion("coupondesctiele_name in", values, "coupondesctieleName");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleNameNotIn(List<String> values) {
            addCriterion("coupondesctiele_name not in", values, "coupondesctieleName");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleNameBetween(String value1, String value2) {
            addCriterion("coupondesctiele_name between", value1, value2, "coupondesctieleName");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleNameNotBetween(String value1, String value2) {
            addCriterion("coupondesctiele_name not between", value1, value2, "coupondesctieleName");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleTieledetailIsNull() {
            addCriterion("coupondesctiele_tieleDetail is null");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleTieledetailIsNotNull() {
            addCriterion("coupondesctiele_tieleDetail is not null");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleTieledetailEqualTo(String value) {
            addCriterion("coupondesctiele_tieleDetail =", value, "coupondesctieleTieledetail");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleTieledetailNotEqualTo(String value) {
            addCriterion("coupondesctiele_tieleDetail <>", value, "coupondesctieleTieledetail");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleTieledetailGreaterThan(String value) {
            addCriterion("coupondesctiele_tieleDetail >", value, "coupondesctieleTieledetail");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleTieledetailGreaterThanOrEqualTo(String value) {
            addCriterion("coupondesctiele_tieleDetail >=", value, "coupondesctieleTieledetail");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleTieledetailLessThan(String value) {
            addCriterion("coupondesctiele_tieleDetail <", value, "coupondesctieleTieledetail");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleTieledetailLessThanOrEqualTo(String value) {
            addCriterion("coupondesctiele_tieleDetail <=", value, "coupondesctieleTieledetail");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleTieledetailLike(String value) {
            addCriterion("coupondesctiele_tieleDetail like", value, "coupondesctieleTieledetail");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleTieledetailNotLike(String value) {
            addCriterion("coupondesctiele_tieleDetail not like", value, "coupondesctieleTieledetail");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleTieledetailIn(List<String> values) {
            addCriterion("coupondesctiele_tieleDetail in", values, "coupondesctieleTieledetail");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleTieledetailNotIn(List<String> values) {
            addCriterion("coupondesctiele_tieleDetail not in", values, "coupondesctieleTieledetail");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleTieledetailBetween(String value1, String value2) {
            addCriterion("coupondesctiele_tieleDetail between", value1, value2, "coupondesctieleTieledetail");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleTieledetailNotBetween(String value1, String value2) {
            addCriterion("coupondesctiele_tieleDetail not between", value1, value2, "coupondesctieleTieledetail");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapstatusIsNull() {
            addCriterion("coupondesctiele_wapstatus is null");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapstatusIsNotNull() {
            addCriterion("coupondesctiele_wapstatus is not null");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapstatusEqualTo(Integer value) {
            addCriterion("coupondesctiele_wapstatus =", value, "coupondesctieleWapstatus");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapstatusNotEqualTo(Integer value) {
            addCriterion("coupondesctiele_wapstatus <>", value, "coupondesctieleWapstatus");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapstatusGreaterThan(Integer value) {
            addCriterion("coupondesctiele_wapstatus >", value, "coupondesctieleWapstatus");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupondesctiele_wapstatus >=", value, "coupondesctieleWapstatus");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapstatusLessThan(Integer value) {
            addCriterion("coupondesctiele_wapstatus <", value, "coupondesctieleWapstatus");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapstatusLessThanOrEqualTo(Integer value) {
            addCriterion("coupondesctiele_wapstatus <=", value, "coupondesctieleWapstatus");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapstatusIn(List<Integer> values) {
            addCriterion("coupondesctiele_wapstatus in", values, "coupondesctieleWapstatus");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapstatusNotIn(List<Integer> values) {
            addCriterion("coupondesctiele_wapstatus not in", values, "coupondesctieleWapstatus");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapstatusBetween(Integer value1, Integer value2) {
            addCriterion("coupondesctiele_wapstatus between", value1, value2, "coupondesctieleWapstatus");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("coupondesctiele_wapstatus not between", value1, value2, "coupondesctieleWapstatus");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapimgurlIsNull() {
            addCriterion("coupondesctiele_wapimgurl is null");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapimgurlIsNotNull() {
            addCriterion("coupondesctiele_wapimgurl is not null");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapimgurlEqualTo(String value) {
            addCriterion("coupondesctiele_wapimgurl =", value, "coupondesctieleWapimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapimgurlNotEqualTo(String value) {
            addCriterion("coupondesctiele_wapimgurl <>", value, "coupondesctieleWapimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapimgurlGreaterThan(String value) {
            addCriterion("coupondesctiele_wapimgurl >", value, "coupondesctieleWapimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapimgurlGreaterThanOrEqualTo(String value) {
            addCriterion("coupondesctiele_wapimgurl >=", value, "coupondesctieleWapimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapimgurlLessThan(String value) {
            addCriterion("coupondesctiele_wapimgurl <", value, "coupondesctieleWapimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapimgurlLessThanOrEqualTo(String value) {
            addCriterion("coupondesctiele_wapimgurl <=", value, "coupondesctieleWapimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapimgurlLike(String value) {
            addCriterion("coupondesctiele_wapimgurl like", value, "coupondesctieleWapimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapimgurlNotLike(String value) {
            addCriterion("coupondesctiele_wapimgurl not like", value, "coupondesctieleWapimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapimgurlIn(List<String> values) {
            addCriterion("coupondesctiele_wapimgurl in", values, "coupondesctieleWapimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapimgurlNotIn(List<String> values) {
            addCriterion("coupondesctiele_wapimgurl not in", values, "coupondesctieleWapimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapimgurlBetween(String value1, String value2) {
            addCriterion("coupondesctiele_wapimgurl between", value1, value2, "coupondesctieleWapimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleWapimgurlNotBetween(String value1, String value2) {
            addCriterion("coupondesctiele_wapimgurl not between", value1, value2, "coupondesctieleWapimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcstatusIsNull() {
            addCriterion("coupondesctiele_pcstatus is null");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcstatusIsNotNull() {
            addCriterion("coupondesctiele_pcstatus is not null");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcstatusEqualTo(Integer value) {
            addCriterion("coupondesctiele_pcstatus =", value, "coupondesctielePcstatus");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcstatusNotEqualTo(Integer value) {
            addCriterion("coupondesctiele_pcstatus <>", value, "coupondesctielePcstatus");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcstatusGreaterThan(Integer value) {
            addCriterion("coupondesctiele_pcstatus >", value, "coupondesctielePcstatus");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupondesctiele_pcstatus >=", value, "coupondesctielePcstatus");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcstatusLessThan(Integer value) {
            addCriterion("coupondesctiele_pcstatus <", value, "coupondesctielePcstatus");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcstatusLessThanOrEqualTo(Integer value) {
            addCriterion("coupondesctiele_pcstatus <=", value, "coupondesctielePcstatus");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcstatusIn(List<Integer> values) {
            addCriterion("coupondesctiele_pcstatus in", values, "coupondesctielePcstatus");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcstatusNotIn(List<Integer> values) {
            addCriterion("coupondesctiele_pcstatus not in", values, "coupondesctielePcstatus");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcstatusBetween(Integer value1, Integer value2) {
            addCriterion("coupondesctiele_pcstatus between", value1, value2, "coupondesctielePcstatus");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("coupondesctiele_pcstatus not between", value1, value2, "coupondesctielePcstatus");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcimgurlIsNull() {
            addCriterion("coupondesctiele_pcimgurl is null");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcimgurlIsNotNull() {
            addCriterion("coupondesctiele_pcimgurl is not null");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcimgurlEqualTo(String value) {
            addCriterion("coupondesctiele_pcimgurl =", value, "coupondesctielePcimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcimgurlNotEqualTo(String value) {
            addCriterion("coupondesctiele_pcimgurl <>", value, "coupondesctielePcimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcimgurlGreaterThan(String value) {
            addCriterion("coupondesctiele_pcimgurl >", value, "coupondesctielePcimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcimgurlGreaterThanOrEqualTo(String value) {
            addCriterion("coupondesctiele_pcimgurl >=", value, "coupondesctielePcimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcimgurlLessThan(String value) {
            addCriterion("coupondesctiele_pcimgurl <", value, "coupondesctielePcimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcimgurlLessThanOrEqualTo(String value) {
            addCriterion("coupondesctiele_pcimgurl <=", value, "coupondesctielePcimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcimgurlLike(String value) {
            addCriterion("coupondesctiele_pcimgurl like", value, "coupondesctielePcimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcimgurlNotLike(String value) {
            addCriterion("coupondesctiele_pcimgurl not like", value, "coupondesctielePcimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcimgurlIn(List<String> values) {
            addCriterion("coupondesctiele_pcimgurl in", values, "coupondesctielePcimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcimgurlNotIn(List<String> values) {
            addCriterion("coupondesctiele_pcimgurl not in", values, "coupondesctielePcimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcimgurlBetween(String value1, String value2) {
            addCriterion("coupondesctiele_pcimgurl between", value1, value2, "coupondesctielePcimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctielePcimgurlNotBetween(String value1, String value2) {
            addCriterion("coupondesctiele_pcimgurl not between", value1, value2, "coupondesctielePcimgurl");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleCreatetimeIsNull() {
            addCriterion("coupondesctiele_createTime is null");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleCreatetimeIsNotNull() {
            addCriterion("coupondesctiele_createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleCreatetimeEqualTo(String value) {
            addCriterion("coupondesctiele_createTime =", value, "coupondesctieleCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleCreatetimeNotEqualTo(String value) {
            addCriterion("coupondesctiele_createTime <>", value, "coupondesctieleCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleCreatetimeGreaterThan(String value) {
            addCriterion("coupondesctiele_createTime >", value, "coupondesctieleCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("coupondesctiele_createTime >=", value, "coupondesctieleCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleCreatetimeLessThan(String value) {
            addCriterion("coupondesctiele_createTime <", value, "coupondesctieleCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("coupondesctiele_createTime <=", value, "coupondesctieleCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleCreatetimeLike(String value) {
            addCriterion("coupondesctiele_createTime like", value, "coupondesctieleCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleCreatetimeNotLike(String value) {
            addCriterion("coupondesctiele_createTime not like", value, "coupondesctieleCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleCreatetimeIn(List<String> values) {
            addCriterion("coupondesctiele_createTime in", values, "coupondesctieleCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleCreatetimeNotIn(List<String> values) {
            addCriterion("coupondesctiele_createTime not in", values, "coupondesctieleCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleCreatetimeBetween(String value1, String value2) {
            addCriterion("coupondesctiele_createTime between", value1, value2, "coupondesctieleCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleCreatetimeNotBetween(String value1, String value2) {
            addCriterion("coupondesctiele_createTime not between", value1, value2, "coupondesctieleCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleMotifytimeIsNull() {
            addCriterion("coupondesctiele_motifyTime is null");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleMotifytimeIsNotNull() {
            addCriterion("coupondesctiele_motifyTime is not null");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleMotifytimeEqualTo(String value) {
            addCriterion("coupondesctiele_motifyTime =", value, "coupondesctieleMotifytime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleMotifytimeNotEqualTo(String value) {
            addCriterion("coupondesctiele_motifyTime <>", value, "coupondesctieleMotifytime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleMotifytimeGreaterThan(String value) {
            addCriterion("coupondesctiele_motifyTime >", value, "coupondesctieleMotifytime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleMotifytimeGreaterThanOrEqualTo(String value) {
            addCriterion("coupondesctiele_motifyTime >=", value, "coupondesctieleMotifytime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleMotifytimeLessThan(String value) {
            addCriterion("coupondesctiele_motifyTime <", value, "coupondesctieleMotifytime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleMotifytimeLessThanOrEqualTo(String value) {
            addCriterion("coupondesctiele_motifyTime <=", value, "coupondesctieleMotifytime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleMotifytimeLike(String value) {
            addCriterion("coupondesctiele_motifyTime like", value, "coupondesctieleMotifytime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleMotifytimeNotLike(String value) {
            addCriterion("coupondesctiele_motifyTime not like", value, "coupondesctieleMotifytime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleMotifytimeIn(List<String> values) {
            addCriterion("coupondesctiele_motifyTime in", values, "coupondesctieleMotifytime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleMotifytimeNotIn(List<String> values) {
            addCriterion("coupondesctiele_motifyTime not in", values, "coupondesctieleMotifytime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleMotifytimeBetween(String value1, String value2) {
            addCriterion("coupondesctiele_motifyTime between", value1, value2, "coupondesctieleMotifytime");
            return (Criteria) this;
        }

        public Criteria andCoupondesctieleMotifytimeNotBetween(String value1, String value2) {
            addCriterion("coupondesctiele_motifyTime not between", value1, value2, "coupondesctieleMotifytime");
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