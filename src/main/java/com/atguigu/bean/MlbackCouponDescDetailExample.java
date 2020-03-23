package com.atguigu.bean;

import java.util.ArrayList;
import java.util.List;

public class MlbackCouponDescDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MlbackCouponDescDetailExample() {
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

        public Criteria andCoupondescdetailIdIsNull() {
            addCriterion("coupondescdetail_id is null");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailIdIsNotNull() {
            addCriterion("coupondescdetail_id is not null");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailIdEqualTo(Integer value) {
            addCriterion("coupondescdetail_id =", value, "coupondescdetailId");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailIdNotEqualTo(Integer value) {
            addCriterion("coupondescdetail_id <>", value, "coupondescdetailId");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailIdGreaterThan(Integer value) {
            addCriterion("coupondescdetail_id >", value, "coupondescdetailId");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupondescdetail_id >=", value, "coupondescdetailId");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailIdLessThan(Integer value) {
            addCriterion("coupondescdetail_id <", value, "coupondescdetailId");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("coupondescdetail_id <=", value, "coupondescdetailId");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailIdIn(List<Integer> values) {
            addCriterion("coupondescdetail_id in", values, "coupondescdetailId");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailIdNotIn(List<Integer> values) {
            addCriterion("coupondescdetail_id not in", values, "coupondescdetailId");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailIdBetween(Integer value1, Integer value2) {
            addCriterion("coupondescdetail_id between", value1, value2, "coupondescdetailId");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("coupondescdetail_id not between", value1, value2, "coupondescdetailId");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailNameIsNull() {
            addCriterion("coupondescdetail_name is null");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailNameIsNotNull() {
            addCriterion("coupondescdetail_name is not null");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailNameEqualTo(String value) {
            addCriterion("coupondescdetail_name =", value, "coupondescdetailName");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailNameNotEqualTo(String value) {
            addCriterion("coupondescdetail_name <>", value, "coupondescdetailName");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailNameGreaterThan(String value) {
            addCriterion("coupondescdetail_name >", value, "coupondescdetailName");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailNameGreaterThanOrEqualTo(String value) {
            addCriterion("coupondescdetail_name >=", value, "coupondescdetailName");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailNameLessThan(String value) {
            addCriterion("coupondescdetail_name <", value, "coupondescdetailName");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailNameLessThanOrEqualTo(String value) {
            addCriterion("coupondescdetail_name <=", value, "coupondescdetailName");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailNameLike(String value) {
            addCriterion("coupondescdetail_name like", value, "coupondescdetailName");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailNameNotLike(String value) {
            addCriterion("coupondescdetail_name not like", value, "coupondescdetailName");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailNameIn(List<String> values) {
            addCriterion("coupondescdetail_name in", values, "coupondescdetailName");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailNameNotIn(List<String> values) {
            addCriterion("coupondescdetail_name not in", values, "coupondescdetailName");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailNameBetween(String value1, String value2) {
            addCriterion("coupondescdetail_name between", value1, value2, "coupondescdetailName");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailNameNotBetween(String value1, String value2) {
            addCriterion("coupondescdetail_name not between", value1, value2, "coupondescdetailName");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthpreIsNull() {
            addCriterion("coupondescdetail_strengthPre is null");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthpreIsNotNull() {
            addCriterion("coupondescdetail_strengthPre is not null");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthpreEqualTo(String value) {
            addCriterion("coupondescdetail_strengthPre =", value, "coupondescdetailStrengthpre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthpreNotEqualTo(String value) {
            addCriterion("coupondescdetail_strengthPre <>", value, "coupondescdetailStrengthpre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthpreGreaterThan(String value) {
            addCriterion("coupondescdetail_strengthPre >", value, "coupondescdetailStrengthpre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthpreGreaterThanOrEqualTo(String value) {
            addCriterion("coupondescdetail_strengthPre >=", value, "coupondescdetailStrengthpre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthpreLessThan(String value) {
            addCriterion("coupondescdetail_strengthPre <", value, "coupondescdetailStrengthpre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthpreLessThanOrEqualTo(String value) {
            addCriterion("coupondescdetail_strengthPre <=", value, "coupondescdetailStrengthpre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthpreLike(String value) {
            addCriterion("coupondescdetail_strengthPre like", value, "coupondescdetailStrengthpre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthpreNotLike(String value) {
            addCriterion("coupondescdetail_strengthPre not like", value, "coupondescdetailStrengthpre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthpreIn(List<String> values) {
            addCriterion("coupondescdetail_strengthPre in", values, "coupondescdetailStrengthpre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthpreNotIn(List<String> values) {
            addCriterion("coupondescdetail_strengthPre not in", values, "coupondescdetailStrengthpre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthpreBetween(String value1, String value2) {
            addCriterion("coupondescdetail_strengthPre between", value1, value2, "coupondescdetailStrengthpre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthpreNotBetween(String value1, String value2) {
            addCriterion("coupondescdetail_strengthPre not between", value1, value2, "coupondescdetailStrengthpre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthIsNull() {
            addCriterion("coupondescdetail_strength is null");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthIsNotNull() {
            addCriterion("coupondescdetail_strength is not null");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthEqualTo(String value) {
            addCriterion("coupondescdetail_strength =", value, "coupondescdetailStrength");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthNotEqualTo(String value) {
            addCriterion("coupondescdetail_strength <>", value, "coupondescdetailStrength");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthGreaterThan(String value) {
            addCriterion("coupondescdetail_strength >", value, "coupondescdetailStrength");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthGreaterThanOrEqualTo(String value) {
            addCriterion("coupondescdetail_strength >=", value, "coupondescdetailStrength");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthLessThan(String value) {
            addCriterion("coupondescdetail_strength <", value, "coupondescdetailStrength");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthLessThanOrEqualTo(String value) {
            addCriterion("coupondescdetail_strength <=", value, "coupondescdetailStrength");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthLike(String value) {
            addCriterion("coupondescdetail_strength like", value, "coupondescdetailStrength");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthNotLike(String value) {
            addCriterion("coupondescdetail_strength not like", value, "coupondescdetailStrength");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthIn(List<String> values) {
            addCriterion("coupondescdetail_strength in", values, "coupondescdetailStrength");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthNotIn(List<String> values) {
            addCriterion("coupondescdetail_strength not in", values, "coupondescdetailStrength");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthBetween(String value1, String value2) {
            addCriterion("coupondescdetail_strength between", value1, value2, "coupondescdetailStrength");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStrengthNotBetween(String value1, String value2) {
            addCriterion("coupondescdetail_strength not between", value1, value2, "coupondescdetailStrength");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodepreIsNull() {
            addCriterion("coupondescdetail_codePre is null");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodepreIsNotNull() {
            addCriterion("coupondescdetail_codePre is not null");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodepreEqualTo(String value) {
            addCriterion("coupondescdetail_codePre =", value, "coupondescdetailCodepre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodepreNotEqualTo(String value) {
            addCriterion("coupondescdetail_codePre <>", value, "coupondescdetailCodepre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodepreGreaterThan(String value) {
            addCriterion("coupondescdetail_codePre >", value, "coupondescdetailCodepre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodepreGreaterThanOrEqualTo(String value) {
            addCriterion("coupondescdetail_codePre >=", value, "coupondescdetailCodepre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodepreLessThan(String value) {
            addCriterion("coupondescdetail_codePre <", value, "coupondescdetailCodepre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodepreLessThanOrEqualTo(String value) {
            addCriterion("coupondescdetail_codePre <=", value, "coupondescdetailCodepre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodepreLike(String value) {
            addCriterion("coupondescdetail_codePre like", value, "coupondescdetailCodepre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodepreNotLike(String value) {
            addCriterion("coupondescdetail_codePre not like", value, "coupondescdetailCodepre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodepreIn(List<String> values) {
            addCriterion("coupondescdetail_codePre in", values, "coupondescdetailCodepre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodepreNotIn(List<String> values) {
            addCriterion("coupondescdetail_codePre not in", values, "coupondescdetailCodepre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodepreBetween(String value1, String value2) {
            addCriterion("coupondescdetail_codePre between", value1, value2, "coupondescdetailCodepre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodepreNotBetween(String value1, String value2) {
            addCriterion("coupondescdetail_codePre not between", value1, value2, "coupondescdetailCodepre");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodeIsNull() {
            addCriterion("coupondescdetail_code is null");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodeIsNotNull() {
            addCriterion("coupondescdetail_code is not null");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodeEqualTo(String value) {
            addCriterion("coupondescdetail_code =", value, "coupondescdetailCode");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodeNotEqualTo(String value) {
            addCriterion("coupondescdetail_code <>", value, "coupondescdetailCode");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodeGreaterThan(String value) {
            addCriterion("coupondescdetail_code >", value, "coupondescdetailCode");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodeGreaterThanOrEqualTo(String value) {
            addCriterion("coupondescdetail_code >=", value, "coupondescdetailCode");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodeLessThan(String value) {
            addCriterion("coupondescdetail_code <", value, "coupondescdetailCode");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodeLessThanOrEqualTo(String value) {
            addCriterion("coupondescdetail_code <=", value, "coupondescdetailCode");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodeLike(String value) {
            addCriterion("coupondescdetail_code like", value, "coupondescdetailCode");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodeNotLike(String value) {
            addCriterion("coupondescdetail_code not like", value, "coupondescdetailCode");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodeIn(List<String> values) {
            addCriterion("coupondescdetail_code in", values, "coupondescdetailCode");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodeNotIn(List<String> values) {
            addCriterion("coupondescdetail_code not in", values, "coupondescdetailCode");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodeBetween(String value1, String value2) {
            addCriterion("coupondescdetail_code between", value1, value2, "coupondescdetailCode");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCodeNotBetween(String value1, String value2) {
            addCriterion("coupondescdetail_code not between", value1, value2, "coupondescdetailCode");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStatusIsNull() {
            addCriterion("coupondescdetail_status is null");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStatusIsNotNull() {
            addCriterion("coupondescdetail_status is not null");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStatusEqualTo(Integer value) {
            addCriterion("coupondescdetail_status =", value, "coupondescdetailStatus");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStatusNotEqualTo(Integer value) {
            addCriterion("coupondescdetail_status <>", value, "coupondescdetailStatus");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStatusGreaterThan(Integer value) {
            addCriterion("coupondescdetail_status >", value, "coupondescdetailStatus");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupondescdetail_status >=", value, "coupondescdetailStatus");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStatusLessThan(Integer value) {
            addCriterion("coupondescdetail_status <", value, "coupondescdetailStatus");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStatusLessThanOrEqualTo(Integer value) {
            addCriterion("coupondescdetail_status <=", value, "coupondescdetailStatus");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStatusIn(List<Integer> values) {
            addCriterion("coupondescdetail_status in", values, "coupondescdetailStatus");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStatusNotIn(List<Integer> values) {
            addCriterion("coupondescdetail_status not in", values, "coupondescdetailStatus");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStatusBetween(Integer value1, Integer value2) {
            addCriterion("coupondescdetail_status between", value1, value2, "coupondescdetailStatus");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("coupondescdetail_status not between", value1, value2, "coupondescdetailStatus");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCreatetimeIsNull() {
            addCriterion("coupondescdetail_createTime is null");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCreatetimeIsNotNull() {
            addCriterion("coupondescdetail_createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCreatetimeEqualTo(String value) {
            addCriterion("coupondescdetail_createTime =", value, "coupondescdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCreatetimeNotEqualTo(String value) {
            addCriterion("coupondescdetail_createTime <>", value, "coupondescdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCreatetimeGreaterThan(String value) {
            addCriterion("coupondescdetail_createTime >", value, "coupondescdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("coupondescdetail_createTime >=", value, "coupondescdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCreatetimeLessThan(String value) {
            addCriterion("coupondescdetail_createTime <", value, "coupondescdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("coupondescdetail_createTime <=", value, "coupondescdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCreatetimeLike(String value) {
            addCriterion("coupondescdetail_createTime like", value, "coupondescdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCreatetimeNotLike(String value) {
            addCriterion("coupondescdetail_createTime not like", value, "coupondescdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCreatetimeIn(List<String> values) {
            addCriterion("coupondescdetail_createTime in", values, "coupondescdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCreatetimeNotIn(List<String> values) {
            addCriterion("coupondescdetail_createTime not in", values, "coupondescdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCreatetimeBetween(String value1, String value2) {
            addCriterion("coupondescdetail_createTime between", value1, value2, "coupondescdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailCreatetimeNotBetween(String value1, String value2) {
            addCriterion("coupondescdetail_createTime not between", value1, value2, "coupondescdetailCreatetime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailMotifytimeIsNull() {
            addCriterion("coupondescdetail_motifyTime is null");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailMotifytimeIsNotNull() {
            addCriterion("coupondescdetail_motifyTime is not null");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailMotifytimeEqualTo(String value) {
            addCriterion("coupondescdetail_motifyTime =", value, "coupondescdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailMotifytimeNotEqualTo(String value) {
            addCriterion("coupondescdetail_motifyTime <>", value, "coupondescdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailMotifytimeGreaterThan(String value) {
            addCriterion("coupondescdetail_motifyTime >", value, "coupondescdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailMotifytimeGreaterThanOrEqualTo(String value) {
            addCriterion("coupondescdetail_motifyTime >=", value, "coupondescdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailMotifytimeLessThan(String value) {
            addCriterion("coupondescdetail_motifyTime <", value, "coupondescdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailMotifytimeLessThanOrEqualTo(String value) {
            addCriterion("coupondescdetail_motifyTime <=", value, "coupondescdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailMotifytimeLike(String value) {
            addCriterion("coupondescdetail_motifyTime like", value, "coupondescdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailMotifytimeNotLike(String value) {
            addCriterion("coupondescdetail_motifyTime not like", value, "coupondescdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailMotifytimeIn(List<String> values) {
            addCriterion("coupondescdetail_motifyTime in", values, "coupondescdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailMotifytimeNotIn(List<String> values) {
            addCriterion("coupondescdetail_motifyTime not in", values, "coupondescdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailMotifytimeBetween(String value1, String value2) {
            addCriterion("coupondescdetail_motifyTime between", value1, value2, "coupondescdetailMotifytime");
            return (Criteria) this;
        }

        public Criteria andCoupondescdetailMotifytimeNotBetween(String value1, String value2) {
            addCriterion("coupondescdetail_motifyTime not between", value1, value2, "coupondescdetailMotifytime");
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