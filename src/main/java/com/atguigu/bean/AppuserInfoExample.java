package com.atguigu.bean;

import java.util.ArrayList;
import java.util.List;

public class AppuserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppuserInfoExample() {
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

        public Criteria andAppuserIdIsNull() {
            addCriterion("appuser_id is null");
            return (Criteria) this;
        }

        public Criteria andAppuserIdIsNotNull() {
            addCriterion("appuser_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppuserIdEqualTo(Integer value) {
            addCriterion("appuser_id =", value, "appuserId");
            return (Criteria) this;
        }

        public Criteria andAppuserIdNotEqualTo(Integer value) {
            addCriterion("appuser_id <>", value, "appuserId");
            return (Criteria) this;
        }

        public Criteria andAppuserIdGreaterThan(Integer value) {
            addCriterion("appuser_id >", value, "appuserId");
            return (Criteria) this;
        }

        public Criteria andAppuserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("appuser_id >=", value, "appuserId");
            return (Criteria) this;
        }

        public Criteria andAppuserIdLessThan(Integer value) {
            addCriterion("appuser_id <", value, "appuserId");
            return (Criteria) this;
        }

        public Criteria andAppuserIdLessThanOrEqualTo(Integer value) {
            addCriterion("appuser_id <=", value, "appuserId");
            return (Criteria) this;
        }

        public Criteria andAppuserIdIn(List<Integer> values) {
            addCriterion("appuser_id in", values, "appuserId");
            return (Criteria) this;
        }

        public Criteria andAppuserIdNotIn(List<Integer> values) {
            addCriterion("appuser_id not in", values, "appuserId");
            return (Criteria) this;
        }

        public Criteria andAppuserIdBetween(Integer value1, Integer value2) {
            addCriterion("appuser_id between", value1, value2, "appuserId");
            return (Criteria) this;
        }

        public Criteria andAppuserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("appuser_id not between", value1, value2, "appuserId");
            return (Criteria) this;
        }

        public Criteria andAppuserIpIsNull() {
            addCriterion("appuser_ip is null");
            return (Criteria) this;
        }

        public Criteria andAppuserIpIsNotNull() {
            addCriterion("appuser_ip is not null");
            return (Criteria) this;
        }

        public Criteria andAppuserIpEqualTo(String value) {
            addCriterion("appuser_ip =", value, "appuserIp");
            return (Criteria) this;
        }

        public Criteria andAppuserIpNotEqualTo(String value) {
            addCriterion("appuser_ip <>", value, "appuserIp");
            return (Criteria) this;
        }

        public Criteria andAppuserIpGreaterThan(String value) {
            addCriterion("appuser_ip >", value, "appuserIp");
            return (Criteria) this;
        }

        public Criteria andAppuserIpGreaterThanOrEqualTo(String value) {
            addCriterion("appuser_ip >=", value, "appuserIp");
            return (Criteria) this;
        }

        public Criteria andAppuserIpLessThan(String value) {
            addCriterion("appuser_ip <", value, "appuserIp");
            return (Criteria) this;
        }

        public Criteria andAppuserIpLessThanOrEqualTo(String value) {
            addCriterion("appuser_ip <=", value, "appuserIp");
            return (Criteria) this;
        }

        public Criteria andAppuserIpLike(String value) {
            addCriterion("appuser_ip like", value, "appuserIp");
            return (Criteria) this;
        }

        public Criteria andAppuserIpNotLike(String value) {
            addCriterion("appuser_ip not like", value, "appuserIp");
            return (Criteria) this;
        }

        public Criteria andAppuserIpIn(List<String> values) {
            addCriterion("appuser_ip in", values, "appuserIp");
            return (Criteria) this;
        }

        public Criteria andAppuserIpNotIn(List<String> values) {
            addCriterion("appuser_ip not in", values, "appuserIp");
            return (Criteria) this;
        }

        public Criteria andAppuserIpBetween(String value1, String value2) {
            addCriterion("appuser_ip between", value1, value2, "appuserIp");
            return (Criteria) this;
        }

        public Criteria andAppuserIpNotBetween(String value1, String value2) {
            addCriterion("appuser_ip not between", value1, value2, "appuserIp");
            return (Criteria) this;
        }

        public Criteria andAppuserMobileIsNull() {
            addCriterion("appuser_mobile is null");
            return (Criteria) this;
        }

        public Criteria andAppuserMobileIsNotNull() {
            addCriterion("appuser_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andAppuserMobileEqualTo(String value) {
            addCriterion("appuser_mobile =", value, "appuserMobile");
            return (Criteria) this;
        }

        public Criteria andAppuserMobileNotEqualTo(String value) {
            addCriterion("appuser_mobile <>", value, "appuserMobile");
            return (Criteria) this;
        }

        public Criteria andAppuserMobileGreaterThan(String value) {
            addCriterion("appuser_mobile >", value, "appuserMobile");
            return (Criteria) this;
        }

        public Criteria andAppuserMobileGreaterThanOrEqualTo(String value) {
            addCriterion("appuser_mobile >=", value, "appuserMobile");
            return (Criteria) this;
        }

        public Criteria andAppuserMobileLessThan(String value) {
            addCriterion("appuser_mobile <", value, "appuserMobile");
            return (Criteria) this;
        }

        public Criteria andAppuserMobileLessThanOrEqualTo(String value) {
            addCriterion("appuser_mobile <=", value, "appuserMobile");
            return (Criteria) this;
        }

        public Criteria andAppuserMobileLike(String value) {
            addCriterion("appuser_mobile like", value, "appuserMobile");
            return (Criteria) this;
        }

        public Criteria andAppuserMobileNotLike(String value) {
            addCriterion("appuser_mobile not like", value, "appuserMobile");
            return (Criteria) this;
        }

        public Criteria andAppuserMobileIn(List<String> values) {
            addCriterion("appuser_mobile in", values, "appuserMobile");
            return (Criteria) this;
        }

        public Criteria andAppuserMobileNotIn(List<String> values) {
            addCriterion("appuser_mobile not in", values, "appuserMobile");
            return (Criteria) this;
        }

        public Criteria andAppuserMobileBetween(String value1, String value2) {
            addCriterion("appuser_mobile between", value1, value2, "appuserMobile");
            return (Criteria) this;
        }

        public Criteria andAppuserMobileNotBetween(String value1, String value2) {
            addCriterion("appuser_mobile not between", value1, value2, "appuserMobile");
            return (Criteria) this;
        }

        public Criteria andAppuserNameIsNull() {
            addCriterion("appuser_name is null");
            return (Criteria) this;
        }

        public Criteria andAppuserNameIsNotNull() {
            addCriterion("appuser_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppuserNameEqualTo(String value) {
            addCriterion("appuser_name =", value, "appuserName");
            return (Criteria) this;
        }

        public Criteria andAppuserNameNotEqualTo(String value) {
            addCriterion("appuser_name <>", value, "appuserName");
            return (Criteria) this;
        }

        public Criteria andAppuserNameGreaterThan(String value) {
            addCriterion("appuser_name >", value, "appuserName");
            return (Criteria) this;
        }

        public Criteria andAppuserNameGreaterThanOrEqualTo(String value) {
            addCriterion("appuser_name >=", value, "appuserName");
            return (Criteria) this;
        }

        public Criteria andAppuserNameLessThan(String value) {
            addCriterion("appuser_name <", value, "appuserName");
            return (Criteria) this;
        }

        public Criteria andAppuserNameLessThanOrEqualTo(String value) {
            addCriterion("appuser_name <=", value, "appuserName");
            return (Criteria) this;
        }

        public Criteria andAppuserNameLike(String value) {
            addCriterion("appuser_name like", value, "appuserName");
            return (Criteria) this;
        }

        public Criteria andAppuserNameNotLike(String value) {
            addCriterion("appuser_name not like", value, "appuserName");
            return (Criteria) this;
        }

        public Criteria andAppuserNameIn(List<String> values) {
            addCriterion("appuser_name in", values, "appuserName");
            return (Criteria) this;
        }

        public Criteria andAppuserNameNotIn(List<String> values) {
            addCriterion("appuser_name not in", values, "appuserName");
            return (Criteria) this;
        }

        public Criteria andAppuserNameBetween(String value1, String value2) {
            addCriterion("appuser_name between", value1, value2, "appuserName");
            return (Criteria) this;
        }

        public Criteria andAppuserNameNotBetween(String value1, String value2) {
            addCriterion("appuser_name not between", value1, value2, "appuserName");
            return (Criteria) this;
        }

        public Criteria andAppuserUdidIsNull() {
            addCriterion("appuser_udid is null");
            return (Criteria) this;
        }

        public Criteria andAppuserUdidIsNotNull() {
            addCriterion("appuser_udid is not null");
            return (Criteria) this;
        }

        public Criteria andAppuserUdidEqualTo(String value) {
            addCriterion("appuser_udid =", value, "appuserUdid");
            return (Criteria) this;
        }

        public Criteria andAppuserUdidNotEqualTo(String value) {
            addCriterion("appuser_udid <>", value, "appuserUdid");
            return (Criteria) this;
        }

        public Criteria andAppuserUdidGreaterThan(String value) {
            addCriterion("appuser_udid >", value, "appuserUdid");
            return (Criteria) this;
        }

        public Criteria andAppuserUdidGreaterThanOrEqualTo(String value) {
            addCriterion("appuser_udid >=", value, "appuserUdid");
            return (Criteria) this;
        }

        public Criteria andAppuserUdidLessThan(String value) {
            addCriterion("appuser_udid <", value, "appuserUdid");
            return (Criteria) this;
        }

        public Criteria andAppuserUdidLessThanOrEqualTo(String value) {
            addCriterion("appuser_udid <=", value, "appuserUdid");
            return (Criteria) this;
        }

        public Criteria andAppuserUdidLike(String value) {
            addCriterion("appuser_udid like", value, "appuserUdid");
            return (Criteria) this;
        }

        public Criteria andAppuserUdidNotLike(String value) {
            addCriterion("appuser_udid not like", value, "appuserUdid");
            return (Criteria) this;
        }

        public Criteria andAppuserUdidIn(List<String> values) {
            addCriterion("appuser_udid in", values, "appuserUdid");
            return (Criteria) this;
        }

        public Criteria andAppuserUdidNotIn(List<String> values) {
            addCriterion("appuser_udid not in", values, "appuserUdid");
            return (Criteria) this;
        }

        public Criteria andAppuserUdidBetween(String value1, String value2) {
            addCriterion("appuser_udid between", value1, value2, "appuserUdid");
            return (Criteria) this;
        }

        public Criteria andAppuserUdidNotBetween(String value1, String value2) {
            addCriterion("appuser_udid not between", value1, value2, "appuserUdid");
            return (Criteria) this;
        }

        public Criteria andAppuserIdfaIsNull() {
            addCriterion("appuser_idfa is null");
            return (Criteria) this;
        }

        public Criteria andAppuserIdfaIsNotNull() {
            addCriterion("appuser_idfa is not null");
            return (Criteria) this;
        }

        public Criteria andAppuserIdfaEqualTo(String value) {
            addCriterion("appuser_idfa =", value, "appuserIdfa");
            return (Criteria) this;
        }

        public Criteria andAppuserIdfaNotEqualTo(String value) {
            addCriterion("appuser_idfa <>", value, "appuserIdfa");
            return (Criteria) this;
        }

        public Criteria andAppuserIdfaGreaterThan(String value) {
            addCriterion("appuser_idfa >", value, "appuserIdfa");
            return (Criteria) this;
        }

        public Criteria andAppuserIdfaGreaterThanOrEqualTo(String value) {
            addCriterion("appuser_idfa >=", value, "appuserIdfa");
            return (Criteria) this;
        }

        public Criteria andAppuserIdfaLessThan(String value) {
            addCriterion("appuser_idfa <", value, "appuserIdfa");
            return (Criteria) this;
        }

        public Criteria andAppuserIdfaLessThanOrEqualTo(String value) {
            addCriterion("appuser_idfa <=", value, "appuserIdfa");
            return (Criteria) this;
        }

        public Criteria andAppuserIdfaLike(String value) {
            addCriterion("appuser_idfa like", value, "appuserIdfa");
            return (Criteria) this;
        }

        public Criteria andAppuserIdfaNotLike(String value) {
            addCriterion("appuser_idfa not like", value, "appuserIdfa");
            return (Criteria) this;
        }

        public Criteria andAppuserIdfaIn(List<String> values) {
            addCriterion("appuser_idfa in", values, "appuserIdfa");
            return (Criteria) this;
        }

        public Criteria andAppuserIdfaNotIn(List<String> values) {
            addCriterion("appuser_idfa not in", values, "appuserIdfa");
            return (Criteria) this;
        }

        public Criteria andAppuserIdfaBetween(String value1, String value2) {
            addCriterion("appuser_idfa between", value1, value2, "appuserIdfa");
            return (Criteria) this;
        }

        public Criteria andAppuserIdfaNotBetween(String value1, String value2) {
            addCriterion("appuser_idfa not between", value1, value2, "appuserIdfa");
            return (Criteria) this;
        }

        public Criteria andAppuserCreatetimeIsNull() {
            addCriterion("appuser_createtime is null");
            return (Criteria) this;
        }

        public Criteria andAppuserCreatetimeIsNotNull() {
            addCriterion("appuser_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andAppuserCreatetimeEqualTo(String value) {
            addCriterion("appuser_createtime =", value, "appuserCreatetime");
            return (Criteria) this;
        }

        public Criteria andAppuserCreatetimeNotEqualTo(String value) {
            addCriterion("appuser_createtime <>", value, "appuserCreatetime");
            return (Criteria) this;
        }

        public Criteria andAppuserCreatetimeGreaterThan(String value) {
            addCriterion("appuser_createtime >", value, "appuserCreatetime");
            return (Criteria) this;
        }

        public Criteria andAppuserCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("appuser_createtime >=", value, "appuserCreatetime");
            return (Criteria) this;
        }

        public Criteria andAppuserCreatetimeLessThan(String value) {
            addCriterion("appuser_createtime <", value, "appuserCreatetime");
            return (Criteria) this;
        }

        public Criteria andAppuserCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("appuser_createtime <=", value, "appuserCreatetime");
            return (Criteria) this;
        }

        public Criteria andAppuserCreatetimeLike(String value) {
            addCriterion("appuser_createtime like", value, "appuserCreatetime");
            return (Criteria) this;
        }

        public Criteria andAppuserCreatetimeNotLike(String value) {
            addCriterion("appuser_createtime not like", value, "appuserCreatetime");
            return (Criteria) this;
        }

        public Criteria andAppuserCreatetimeIn(List<String> values) {
            addCriterion("appuser_createtime in", values, "appuserCreatetime");
            return (Criteria) this;
        }

        public Criteria andAppuserCreatetimeNotIn(List<String> values) {
            addCriterion("appuser_createtime not in", values, "appuserCreatetime");
            return (Criteria) this;
        }

        public Criteria andAppuserCreatetimeBetween(String value1, String value2) {
            addCriterion("appuser_createtime between", value1, value2, "appuserCreatetime");
            return (Criteria) this;
        }

        public Criteria andAppuserCreatetimeNotBetween(String value1, String value2) {
            addCriterion("appuser_createtime not between", value1, value2, "appuserCreatetime");
            return (Criteria) this;
        }

        public Criteria andAppuserLasttimeIsNull() {
            addCriterion("appuser_lasttime is null");
            return (Criteria) this;
        }

        public Criteria andAppuserLasttimeIsNotNull() {
            addCriterion("appuser_lasttime is not null");
            return (Criteria) this;
        }

        public Criteria andAppuserLasttimeEqualTo(String value) {
            addCriterion("appuser_lasttime =", value, "appuserLasttime");
            return (Criteria) this;
        }

        public Criteria andAppuserLasttimeNotEqualTo(String value) {
            addCriterion("appuser_lasttime <>", value, "appuserLasttime");
            return (Criteria) this;
        }

        public Criteria andAppuserLasttimeGreaterThan(String value) {
            addCriterion("appuser_lasttime >", value, "appuserLasttime");
            return (Criteria) this;
        }

        public Criteria andAppuserLasttimeGreaterThanOrEqualTo(String value) {
            addCriterion("appuser_lasttime >=", value, "appuserLasttime");
            return (Criteria) this;
        }

        public Criteria andAppuserLasttimeLessThan(String value) {
            addCriterion("appuser_lasttime <", value, "appuserLasttime");
            return (Criteria) this;
        }

        public Criteria andAppuserLasttimeLessThanOrEqualTo(String value) {
            addCriterion("appuser_lasttime <=", value, "appuserLasttime");
            return (Criteria) this;
        }

        public Criteria andAppuserLasttimeLike(String value) {
            addCriterion("appuser_lasttime like", value, "appuserLasttime");
            return (Criteria) this;
        }

        public Criteria andAppuserLasttimeNotLike(String value) {
            addCriterion("appuser_lasttime not like", value, "appuserLasttime");
            return (Criteria) this;
        }

        public Criteria andAppuserLasttimeIn(List<String> values) {
            addCriterion("appuser_lasttime in", values, "appuserLasttime");
            return (Criteria) this;
        }

        public Criteria andAppuserLasttimeNotIn(List<String> values) {
            addCriterion("appuser_lasttime not in", values, "appuserLasttime");
            return (Criteria) this;
        }

        public Criteria andAppuserLasttimeBetween(String value1, String value2) {
            addCriterion("appuser_lasttime between", value1, value2, "appuserLasttime");
            return (Criteria) this;
        }

        public Criteria andAppuserLasttimeNotBetween(String value1, String value2) {
            addCriterion("appuser_lasttime not between", value1, value2, "appuserLasttime");
            return (Criteria) this;
        }

        public Criteria andAppuserSpareoneIsNull() {
            addCriterion("appuser_spareone is null");
            return (Criteria) this;
        }

        public Criteria andAppuserSpareoneIsNotNull() {
            addCriterion("appuser_spareone is not null");
            return (Criteria) this;
        }

        public Criteria andAppuserSpareoneEqualTo(Integer value) {
            addCriterion("appuser_spareone =", value, "appuserSpareone");
            return (Criteria) this;
        }

        public Criteria andAppuserSpareoneNotEqualTo(Integer value) {
            addCriterion("appuser_spareone <>", value, "appuserSpareone");
            return (Criteria) this;
        }

        public Criteria andAppuserSpareoneGreaterThan(Integer value) {
            addCriterion("appuser_spareone >", value, "appuserSpareone");
            return (Criteria) this;
        }

        public Criteria andAppuserSpareoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("appuser_spareone >=", value, "appuserSpareone");
            return (Criteria) this;
        }

        public Criteria andAppuserSpareoneLessThan(Integer value) {
            addCriterion("appuser_spareone <", value, "appuserSpareone");
            return (Criteria) this;
        }

        public Criteria andAppuserSpareoneLessThanOrEqualTo(Integer value) {
            addCriterion("appuser_spareone <=", value, "appuserSpareone");
            return (Criteria) this;
        }

        public Criteria andAppuserSpareoneIn(List<Integer> values) {
            addCriterion("appuser_spareone in", values, "appuserSpareone");
            return (Criteria) this;
        }

        public Criteria andAppuserSpareoneNotIn(List<Integer> values) {
            addCriterion("appuser_spareone not in", values, "appuserSpareone");
            return (Criteria) this;
        }

        public Criteria andAppuserSpareoneBetween(Integer value1, Integer value2) {
            addCriterion("appuser_spareone between", value1, value2, "appuserSpareone");
            return (Criteria) this;
        }

        public Criteria andAppuserSpareoneNotBetween(Integer value1, Integer value2) {
            addCriterion("appuser_spareone not between", value1, value2, "appuserSpareone");
            return (Criteria) this;
        }

        public Criteria andAppuserSparetwoIsNull() {
            addCriterion("appuser_sparetwo is null");
            return (Criteria) this;
        }

        public Criteria andAppuserSparetwoIsNotNull() {
            addCriterion("appuser_sparetwo is not null");
            return (Criteria) this;
        }

        public Criteria andAppuserSparetwoEqualTo(Integer value) {
            addCriterion("appuser_sparetwo =", value, "appuserSparetwo");
            return (Criteria) this;
        }

        public Criteria andAppuserSparetwoNotEqualTo(Integer value) {
            addCriterion("appuser_sparetwo <>", value, "appuserSparetwo");
            return (Criteria) this;
        }

        public Criteria andAppuserSparetwoGreaterThan(Integer value) {
            addCriterion("appuser_sparetwo >", value, "appuserSparetwo");
            return (Criteria) this;
        }

        public Criteria andAppuserSparetwoGreaterThanOrEqualTo(Integer value) {
            addCriterion("appuser_sparetwo >=", value, "appuserSparetwo");
            return (Criteria) this;
        }

        public Criteria andAppuserSparetwoLessThan(Integer value) {
            addCriterion("appuser_sparetwo <", value, "appuserSparetwo");
            return (Criteria) this;
        }

        public Criteria andAppuserSparetwoLessThanOrEqualTo(Integer value) {
            addCriterion("appuser_sparetwo <=", value, "appuserSparetwo");
            return (Criteria) this;
        }

        public Criteria andAppuserSparetwoIn(List<Integer> values) {
            addCriterion("appuser_sparetwo in", values, "appuserSparetwo");
            return (Criteria) this;
        }

        public Criteria andAppuserSparetwoNotIn(List<Integer> values) {
            addCriterion("appuser_sparetwo not in", values, "appuserSparetwo");
            return (Criteria) this;
        }

        public Criteria andAppuserSparetwoBetween(Integer value1, Integer value2) {
            addCriterion("appuser_sparetwo between", value1, value2, "appuserSparetwo");
            return (Criteria) this;
        }

        public Criteria andAppuserSparetwoNotBetween(Integer value1, Integer value2) {
            addCriterion("appuser_sparetwo not between", value1, value2, "appuserSparetwo");
            return (Criteria) this;
        }

        public Criteria andAppuserSparethreeIsNull() {
            addCriterion("appuser_sparethree is null");
            return (Criteria) this;
        }

        public Criteria andAppuserSparethreeIsNotNull() {
            addCriterion("appuser_sparethree is not null");
            return (Criteria) this;
        }

        public Criteria andAppuserSparethreeEqualTo(String value) {
            addCriterion("appuser_sparethree =", value, "appuserSparethree");
            return (Criteria) this;
        }

        public Criteria andAppuserSparethreeNotEqualTo(String value) {
            addCriterion("appuser_sparethree <>", value, "appuserSparethree");
            return (Criteria) this;
        }

        public Criteria andAppuserSparethreeGreaterThan(String value) {
            addCriterion("appuser_sparethree >", value, "appuserSparethree");
            return (Criteria) this;
        }

        public Criteria andAppuserSparethreeGreaterThanOrEqualTo(String value) {
            addCriterion("appuser_sparethree >=", value, "appuserSparethree");
            return (Criteria) this;
        }

        public Criteria andAppuserSparethreeLessThan(String value) {
            addCriterion("appuser_sparethree <", value, "appuserSparethree");
            return (Criteria) this;
        }

        public Criteria andAppuserSparethreeLessThanOrEqualTo(String value) {
            addCriterion("appuser_sparethree <=", value, "appuserSparethree");
            return (Criteria) this;
        }

        public Criteria andAppuserSparethreeLike(String value) {
            addCriterion("appuser_sparethree like", value, "appuserSparethree");
            return (Criteria) this;
        }

        public Criteria andAppuserSparethreeNotLike(String value) {
            addCriterion("appuser_sparethree not like", value, "appuserSparethree");
            return (Criteria) this;
        }

        public Criteria andAppuserSparethreeIn(List<String> values) {
            addCriterion("appuser_sparethree in", values, "appuserSparethree");
            return (Criteria) this;
        }

        public Criteria andAppuserSparethreeNotIn(List<String> values) {
            addCriterion("appuser_sparethree not in", values, "appuserSparethree");
            return (Criteria) this;
        }

        public Criteria andAppuserSparethreeBetween(String value1, String value2) {
            addCriterion("appuser_sparethree between", value1, value2, "appuserSparethree");
            return (Criteria) this;
        }

        public Criteria andAppuserSparethreeNotBetween(String value1, String value2) {
            addCriterion("appuser_sparethree not between", value1, value2, "appuserSparethree");
            return (Criteria) this;
        }

        public Criteria andAppuserSparefourIsNull() {
            addCriterion("appuser_sparefour is null");
            return (Criteria) this;
        }

        public Criteria andAppuserSparefourIsNotNull() {
            addCriterion("appuser_sparefour is not null");
            return (Criteria) this;
        }

        public Criteria andAppuserSparefourEqualTo(String value) {
            addCriterion("appuser_sparefour =", value, "appuserSparefour");
            return (Criteria) this;
        }

        public Criteria andAppuserSparefourNotEqualTo(String value) {
            addCriterion("appuser_sparefour <>", value, "appuserSparefour");
            return (Criteria) this;
        }

        public Criteria andAppuserSparefourGreaterThan(String value) {
            addCriterion("appuser_sparefour >", value, "appuserSparefour");
            return (Criteria) this;
        }

        public Criteria andAppuserSparefourGreaterThanOrEqualTo(String value) {
            addCriterion("appuser_sparefour >=", value, "appuserSparefour");
            return (Criteria) this;
        }

        public Criteria andAppuserSparefourLessThan(String value) {
            addCriterion("appuser_sparefour <", value, "appuserSparefour");
            return (Criteria) this;
        }

        public Criteria andAppuserSparefourLessThanOrEqualTo(String value) {
            addCriterion("appuser_sparefour <=", value, "appuserSparefour");
            return (Criteria) this;
        }

        public Criteria andAppuserSparefourLike(String value) {
            addCriterion("appuser_sparefour like", value, "appuserSparefour");
            return (Criteria) this;
        }

        public Criteria andAppuserSparefourNotLike(String value) {
            addCriterion("appuser_sparefour not like", value, "appuserSparefour");
            return (Criteria) this;
        }

        public Criteria andAppuserSparefourIn(List<String> values) {
            addCriterion("appuser_sparefour in", values, "appuserSparefour");
            return (Criteria) this;
        }

        public Criteria andAppuserSparefourNotIn(List<String> values) {
            addCriterion("appuser_sparefour not in", values, "appuserSparefour");
            return (Criteria) this;
        }

        public Criteria andAppuserSparefourBetween(String value1, String value2) {
            addCriterion("appuser_sparefour between", value1, value2, "appuserSparefour");
            return (Criteria) this;
        }

        public Criteria andAppuserSparefourNotBetween(String value1, String value2) {
            addCriterion("appuser_sparefour not between", value1, value2, "appuserSparefour");
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