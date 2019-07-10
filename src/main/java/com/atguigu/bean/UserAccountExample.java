package com.atguigu.bean;

import java.util.ArrayList;
import java.util.List;

public class UserAccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserAccountExample() {
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

        public Criteria andUserAccountidIsNull() {
            addCriterion("user_accountid is null");
            return (Criteria) this;
        }

        public Criteria andUserAccountidIsNotNull() {
            addCriterion("user_accountid is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccountidEqualTo(Integer value) {
            addCriterion("user_accountid =", value, "userAccountid");
            return (Criteria) this;
        }

        public Criteria andUserAccountidNotEqualTo(Integer value) {
            addCriterion("user_accountid <>", value, "userAccountid");
            return (Criteria) this;
        }

        public Criteria andUserAccountidGreaterThan(Integer value) {
            addCriterion("user_accountid >", value, "userAccountid");
            return (Criteria) this;
        }

        public Criteria andUserAccountidGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_accountid >=", value, "userAccountid");
            return (Criteria) this;
        }

        public Criteria andUserAccountidLessThan(Integer value) {
            addCriterion("user_accountid <", value, "userAccountid");
            return (Criteria) this;
        }

        public Criteria andUserAccountidLessThanOrEqualTo(Integer value) {
            addCriterion("user_accountid <=", value, "userAccountid");
            return (Criteria) this;
        }

        public Criteria andUserAccountidIn(List<Integer> values) {
            addCriterion("user_accountid in", values, "userAccountid");
            return (Criteria) this;
        }

        public Criteria andUserAccountidNotIn(List<Integer> values) {
            addCriterion("user_accountid not in", values, "userAccountid");
            return (Criteria) this;
        }

        public Criteria andUserAccountidBetween(Integer value1, Integer value2) {
            addCriterion("user_accountid between", value1, value2, "userAccountid");
            return (Criteria) this;
        }

        public Criteria andUserAccountidNotBetween(Integer value1, Integer value2) {
            addCriterion("user_accountid not between", value1, value2, "userAccountid");
            return (Criteria) this;
        }

        public Criteria andUserAccountUseridIsNull() {
            addCriterion("user_account_userid is null");
            return (Criteria) this;
        }

        public Criteria andUserAccountUseridIsNotNull() {
            addCriterion("user_account_userid is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccountUseridEqualTo(String value) {
            addCriterion("user_account_userid =", value, "userAccountUserid");
            return (Criteria) this;
        }

        public Criteria andUserAccountUseridNotEqualTo(String value) {
            addCriterion("user_account_userid <>", value, "userAccountUserid");
            return (Criteria) this;
        }

        public Criteria andUserAccountUseridGreaterThan(String value) {
            addCriterion("user_account_userid >", value, "userAccountUserid");
            return (Criteria) this;
        }

        public Criteria andUserAccountUseridGreaterThanOrEqualTo(String value) {
            addCriterion("user_account_userid >=", value, "userAccountUserid");
            return (Criteria) this;
        }

        public Criteria andUserAccountUseridLessThan(String value) {
            addCriterion("user_account_userid <", value, "userAccountUserid");
            return (Criteria) this;
        }

        public Criteria andUserAccountUseridLessThanOrEqualTo(String value) {
            addCriterion("user_account_userid <=", value, "userAccountUserid");
            return (Criteria) this;
        }

        public Criteria andUserAccountUseridLike(String value) {
            addCriterion("user_account_userid like", value, "userAccountUserid");
            return (Criteria) this;
        }

        public Criteria andUserAccountUseridNotLike(String value) {
            addCriterion("user_account_userid not like", value, "userAccountUserid");
            return (Criteria) this;
        }

        public Criteria andUserAccountUseridIn(List<String> values) {
            addCriterion("user_account_userid in", values, "userAccountUserid");
            return (Criteria) this;
        }

        public Criteria andUserAccountUseridNotIn(List<String> values) {
            addCriterion("user_account_userid not in", values, "userAccountUserid");
            return (Criteria) this;
        }

        public Criteria andUserAccountUseridBetween(String value1, String value2) {
            addCriterion("user_account_userid between", value1, value2, "userAccountUserid");
            return (Criteria) this;
        }

        public Criteria andUserAccountUseridNotBetween(String value1, String value2) {
            addCriterion("user_account_userid not between", value1, value2, "userAccountUserid");
            return (Criteria) this;
        }

        public Criteria andUserAccountUsernameIsNull() {
            addCriterion("user_account_username is null");
            return (Criteria) this;
        }

        public Criteria andUserAccountUsernameIsNotNull() {
            addCriterion("user_account_username is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccountUsernameEqualTo(String value) {
            addCriterion("user_account_username =", value, "userAccountUsername");
            return (Criteria) this;
        }

        public Criteria andUserAccountUsernameNotEqualTo(String value) {
            addCriterion("user_account_username <>", value, "userAccountUsername");
            return (Criteria) this;
        }

        public Criteria andUserAccountUsernameGreaterThan(String value) {
            addCriterion("user_account_username >", value, "userAccountUsername");
            return (Criteria) this;
        }

        public Criteria andUserAccountUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("user_account_username >=", value, "userAccountUsername");
            return (Criteria) this;
        }

        public Criteria andUserAccountUsernameLessThan(String value) {
            addCriterion("user_account_username <", value, "userAccountUsername");
            return (Criteria) this;
        }

        public Criteria andUserAccountUsernameLessThanOrEqualTo(String value) {
            addCriterion("user_account_username <=", value, "userAccountUsername");
            return (Criteria) this;
        }

        public Criteria andUserAccountUsernameLike(String value) {
            addCriterion("user_account_username like", value, "userAccountUsername");
            return (Criteria) this;
        }

        public Criteria andUserAccountUsernameNotLike(String value) {
            addCriterion("user_account_username not like", value, "userAccountUsername");
            return (Criteria) this;
        }

        public Criteria andUserAccountUsernameIn(List<String> values) {
            addCriterion("user_account_username in", values, "userAccountUsername");
            return (Criteria) this;
        }

        public Criteria andUserAccountUsernameNotIn(List<String> values) {
            addCriterion("user_account_username not in", values, "userAccountUsername");
            return (Criteria) this;
        }

        public Criteria andUserAccountUsernameBetween(String value1, String value2) {
            addCriterion("user_account_username between", value1, value2, "userAccountUsername");
            return (Criteria) this;
        }

        public Criteria andUserAccountUsernameNotBetween(String value1, String value2) {
            addCriterion("user_account_username not between", value1, value2, "userAccountUsername");
            return (Criteria) this;
        }

        public Criteria andUserAccNowmoneyIsNull() {
            addCriterion("user_acc_nowmoney is null");
            return (Criteria) this;
        }

        public Criteria andUserAccNowmoneyIsNotNull() {
            addCriterion("user_acc_nowmoney is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccNowmoneyEqualTo(String value) {
            addCriterion("user_acc_nowmoney =", value, "userAccNowmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccNowmoneyNotEqualTo(String value) {
            addCriterion("user_acc_nowmoney <>", value, "userAccNowmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccNowmoneyGreaterThan(String value) {
            addCriterion("user_acc_nowmoney >", value, "userAccNowmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccNowmoneyGreaterThanOrEqualTo(String value) {
            addCriterion("user_acc_nowmoney >=", value, "userAccNowmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccNowmoneyLessThan(String value) {
            addCriterion("user_acc_nowmoney <", value, "userAccNowmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccNowmoneyLessThanOrEqualTo(String value) {
            addCriterion("user_acc_nowmoney <=", value, "userAccNowmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccNowmoneyLike(String value) {
            addCriterion("user_acc_nowmoney like", value, "userAccNowmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccNowmoneyNotLike(String value) {
            addCriterion("user_acc_nowmoney not like", value, "userAccNowmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccNowmoneyIn(List<String> values) {
            addCriterion("user_acc_nowmoney in", values, "userAccNowmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccNowmoneyNotIn(List<String> values) {
            addCriterion("user_acc_nowmoney not in", values, "userAccNowmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccNowmoneyBetween(String value1, String value2) {
            addCriterion("user_acc_nowmoney between", value1, value2, "userAccNowmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccNowmoneyNotBetween(String value1, String value2) {
            addCriterion("user_acc_nowmoney not between", value1, value2, "userAccNowmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccAllmoneyIsNull() {
            addCriterion("user_acc_allmoney is null");
            return (Criteria) this;
        }

        public Criteria andUserAccAllmoneyIsNotNull() {
            addCriterion("user_acc_allmoney is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccAllmoneyEqualTo(String value) {
            addCriterion("user_acc_allmoney =", value, "userAccAllmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccAllmoneyNotEqualTo(String value) {
            addCriterion("user_acc_allmoney <>", value, "userAccAllmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccAllmoneyGreaterThan(String value) {
            addCriterion("user_acc_allmoney >", value, "userAccAllmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccAllmoneyGreaterThanOrEqualTo(String value) {
            addCriterion("user_acc_allmoney >=", value, "userAccAllmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccAllmoneyLessThan(String value) {
            addCriterion("user_acc_allmoney <", value, "userAccAllmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccAllmoneyLessThanOrEqualTo(String value) {
            addCriterion("user_acc_allmoney <=", value, "userAccAllmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccAllmoneyLike(String value) {
            addCriterion("user_acc_allmoney like", value, "userAccAllmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccAllmoneyNotLike(String value) {
            addCriterion("user_acc_allmoney not like", value, "userAccAllmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccAllmoneyIn(List<String> values) {
            addCriterion("user_acc_allmoney in", values, "userAccAllmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccAllmoneyNotIn(List<String> values) {
            addCriterion("user_acc_allmoney not in", values, "userAccAllmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccAllmoneyBetween(String value1, String value2) {
            addCriterion("user_acc_allmoney between", value1, value2, "userAccAllmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccAllmoneyNotBetween(String value1, String value2) {
            addCriterion("user_acc_allmoney not between", value1, value2, "userAccAllmoney");
            return (Criteria) this;
        }

        public Criteria andUserAccTodayinIsNull() {
            addCriterion("user_acc_todayIn is null");
            return (Criteria) this;
        }

        public Criteria andUserAccTodayinIsNotNull() {
            addCriterion("user_acc_todayIn is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccTodayinEqualTo(String value) {
            addCriterion("user_acc_todayIn =", value, "userAccTodayin");
            return (Criteria) this;
        }

        public Criteria andUserAccTodayinNotEqualTo(String value) {
            addCriterion("user_acc_todayIn <>", value, "userAccTodayin");
            return (Criteria) this;
        }

        public Criteria andUserAccTodayinGreaterThan(String value) {
            addCriterion("user_acc_todayIn >", value, "userAccTodayin");
            return (Criteria) this;
        }

        public Criteria andUserAccTodayinGreaterThanOrEqualTo(String value) {
            addCriterion("user_acc_todayIn >=", value, "userAccTodayin");
            return (Criteria) this;
        }

        public Criteria andUserAccTodayinLessThan(String value) {
            addCriterion("user_acc_todayIn <", value, "userAccTodayin");
            return (Criteria) this;
        }

        public Criteria andUserAccTodayinLessThanOrEqualTo(String value) {
            addCriterion("user_acc_todayIn <=", value, "userAccTodayin");
            return (Criteria) this;
        }

        public Criteria andUserAccTodayinLike(String value) {
            addCriterion("user_acc_todayIn like", value, "userAccTodayin");
            return (Criteria) this;
        }

        public Criteria andUserAccTodayinNotLike(String value) {
            addCriterion("user_acc_todayIn not like", value, "userAccTodayin");
            return (Criteria) this;
        }

        public Criteria andUserAccTodayinIn(List<String> values) {
            addCriterion("user_acc_todayIn in", values, "userAccTodayin");
            return (Criteria) this;
        }

        public Criteria andUserAccTodayinNotIn(List<String> values) {
            addCriterion("user_acc_todayIn not in", values, "userAccTodayin");
            return (Criteria) this;
        }

        public Criteria andUserAccTodayinBetween(String value1, String value2) {
            addCriterion("user_acc_todayIn between", value1, value2, "userAccTodayin");
            return (Criteria) this;
        }

        public Criteria andUserAccTodayinNotBetween(String value1, String value2) {
            addCriterion("user_acc_todayIn not between", value1, value2, "userAccTodayin");
            return (Criteria) this;
        }

        public Criteria andUserAccAlloutIsNull() {
            addCriterion("user_acc_allout is null");
            return (Criteria) this;
        }

        public Criteria andUserAccAlloutIsNotNull() {
            addCriterion("user_acc_allout is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccAlloutEqualTo(String value) {
            addCriterion("user_acc_allout =", value, "userAccAllout");
            return (Criteria) this;
        }

        public Criteria andUserAccAlloutNotEqualTo(String value) {
            addCriterion("user_acc_allout <>", value, "userAccAllout");
            return (Criteria) this;
        }

        public Criteria andUserAccAlloutGreaterThan(String value) {
            addCriterion("user_acc_allout >", value, "userAccAllout");
            return (Criteria) this;
        }

        public Criteria andUserAccAlloutGreaterThanOrEqualTo(String value) {
            addCriterion("user_acc_allout >=", value, "userAccAllout");
            return (Criteria) this;
        }

        public Criteria andUserAccAlloutLessThan(String value) {
            addCriterion("user_acc_allout <", value, "userAccAllout");
            return (Criteria) this;
        }

        public Criteria andUserAccAlloutLessThanOrEqualTo(String value) {
            addCriterion("user_acc_allout <=", value, "userAccAllout");
            return (Criteria) this;
        }

        public Criteria andUserAccAlloutLike(String value) {
            addCriterion("user_acc_allout like", value, "userAccAllout");
            return (Criteria) this;
        }

        public Criteria andUserAccAlloutNotLike(String value) {
            addCriterion("user_acc_allout not like", value, "userAccAllout");
            return (Criteria) this;
        }

        public Criteria andUserAccAlloutIn(List<String> values) {
            addCriterion("user_acc_allout in", values, "userAccAllout");
            return (Criteria) this;
        }

        public Criteria andUserAccAlloutNotIn(List<String> values) {
            addCriterion("user_acc_allout not in", values, "userAccAllout");
            return (Criteria) this;
        }

        public Criteria andUserAccAlloutBetween(String value1, String value2) {
            addCriterion("user_acc_allout between", value1, value2, "userAccAllout");
            return (Criteria) this;
        }

        public Criteria andUserAccAlloutNotBetween(String value1, String value2) {
            addCriterion("user_acc_allout not between", value1, value2, "userAccAllout");
            return (Criteria) this;
        }

        public Criteria andUserAccIfalipayIsNull() {
            addCriterion("user_acc_ifalipay is null");
            return (Criteria) this;
        }

        public Criteria andUserAccIfalipayIsNotNull() {
            addCriterion("user_acc_ifalipay is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccIfalipayEqualTo(String value) {
            addCriterion("user_acc_ifalipay =", value, "userAccIfalipay");
            return (Criteria) this;
        }

        public Criteria andUserAccIfalipayNotEqualTo(String value) {
            addCriterion("user_acc_ifalipay <>", value, "userAccIfalipay");
            return (Criteria) this;
        }

        public Criteria andUserAccIfalipayGreaterThan(String value) {
            addCriterion("user_acc_ifalipay >", value, "userAccIfalipay");
            return (Criteria) this;
        }

        public Criteria andUserAccIfalipayGreaterThanOrEqualTo(String value) {
            addCriterion("user_acc_ifalipay >=", value, "userAccIfalipay");
            return (Criteria) this;
        }

        public Criteria andUserAccIfalipayLessThan(String value) {
            addCriterion("user_acc_ifalipay <", value, "userAccIfalipay");
            return (Criteria) this;
        }

        public Criteria andUserAccIfalipayLessThanOrEqualTo(String value) {
            addCriterion("user_acc_ifalipay <=", value, "userAccIfalipay");
            return (Criteria) this;
        }

        public Criteria andUserAccIfalipayLike(String value) {
            addCriterion("user_acc_ifalipay like", value, "userAccIfalipay");
            return (Criteria) this;
        }

        public Criteria andUserAccIfalipayNotLike(String value) {
            addCriterion("user_acc_ifalipay not like", value, "userAccIfalipay");
            return (Criteria) this;
        }

        public Criteria andUserAccIfalipayIn(List<String> values) {
            addCriterion("user_acc_ifalipay in", values, "userAccIfalipay");
            return (Criteria) this;
        }

        public Criteria andUserAccIfalipayNotIn(List<String> values) {
            addCriterion("user_acc_ifalipay not in", values, "userAccIfalipay");
            return (Criteria) this;
        }

        public Criteria andUserAccIfalipayBetween(String value1, String value2) {
            addCriterion("user_acc_ifalipay between", value1, value2, "userAccIfalipay");
            return (Criteria) this;
        }

        public Criteria andUserAccIfalipayNotBetween(String value1, String value2) {
            addCriterion("user_acc_ifalipay not between", value1, value2, "userAccIfalipay");
            return (Criteria) this;
        }

        public Criteria andUserAlipaynameIsNull() {
            addCriterion("user_alipayname is null");
            return (Criteria) this;
        }

        public Criteria andUserAlipaynameIsNotNull() {
            addCriterion("user_alipayname is not null");
            return (Criteria) this;
        }

        public Criteria andUserAlipaynameEqualTo(String value) {
            addCriterion("user_alipayname =", value, "userAlipayname");
            return (Criteria) this;
        }

        public Criteria andUserAlipaynameNotEqualTo(String value) {
            addCriterion("user_alipayname <>", value, "userAlipayname");
            return (Criteria) this;
        }

        public Criteria andUserAlipaynameGreaterThan(String value) {
            addCriterion("user_alipayname >", value, "userAlipayname");
            return (Criteria) this;
        }

        public Criteria andUserAlipaynameGreaterThanOrEqualTo(String value) {
            addCriterion("user_alipayname >=", value, "userAlipayname");
            return (Criteria) this;
        }

        public Criteria andUserAlipaynameLessThan(String value) {
            addCriterion("user_alipayname <", value, "userAlipayname");
            return (Criteria) this;
        }

        public Criteria andUserAlipaynameLessThanOrEqualTo(String value) {
            addCriterion("user_alipayname <=", value, "userAlipayname");
            return (Criteria) this;
        }

        public Criteria andUserAlipaynameLike(String value) {
            addCriterion("user_alipayname like", value, "userAlipayname");
            return (Criteria) this;
        }

        public Criteria andUserAlipaynameNotLike(String value) {
            addCriterion("user_alipayname not like", value, "userAlipayname");
            return (Criteria) this;
        }

        public Criteria andUserAlipaynameIn(List<String> values) {
            addCriterion("user_alipayname in", values, "userAlipayname");
            return (Criteria) this;
        }

        public Criteria andUserAlipaynameNotIn(List<String> values) {
            addCriterion("user_alipayname not in", values, "userAlipayname");
            return (Criteria) this;
        }

        public Criteria andUserAlipaynameBetween(String value1, String value2) {
            addCriterion("user_alipayname between", value1, value2, "userAlipayname");
            return (Criteria) this;
        }

        public Criteria andUserAlipaynameNotBetween(String value1, String value2) {
            addCriterion("user_alipayname not between", value1, value2, "userAlipayname");
            return (Criteria) this;
        }

        public Criteria andUserAlipaypeopleIsNull() {
            addCriterion("user_alipaypeople is null");
            return (Criteria) this;
        }

        public Criteria andUserAlipaypeopleIsNotNull() {
            addCriterion("user_alipaypeople is not null");
            return (Criteria) this;
        }

        public Criteria andUserAlipaypeopleEqualTo(String value) {
            addCriterion("user_alipaypeople =", value, "userAlipaypeople");
            return (Criteria) this;
        }

        public Criteria andUserAlipaypeopleNotEqualTo(String value) {
            addCriterion("user_alipaypeople <>", value, "userAlipaypeople");
            return (Criteria) this;
        }

        public Criteria andUserAlipaypeopleGreaterThan(String value) {
            addCriterion("user_alipaypeople >", value, "userAlipaypeople");
            return (Criteria) this;
        }

        public Criteria andUserAlipaypeopleGreaterThanOrEqualTo(String value) {
            addCriterion("user_alipaypeople >=", value, "userAlipaypeople");
            return (Criteria) this;
        }

        public Criteria andUserAlipaypeopleLessThan(String value) {
            addCriterion("user_alipaypeople <", value, "userAlipaypeople");
            return (Criteria) this;
        }

        public Criteria andUserAlipaypeopleLessThanOrEqualTo(String value) {
            addCriterion("user_alipaypeople <=", value, "userAlipaypeople");
            return (Criteria) this;
        }

        public Criteria andUserAlipaypeopleLike(String value) {
            addCriterion("user_alipaypeople like", value, "userAlipaypeople");
            return (Criteria) this;
        }

        public Criteria andUserAlipaypeopleNotLike(String value) {
            addCriterion("user_alipaypeople not like", value, "userAlipaypeople");
            return (Criteria) this;
        }

        public Criteria andUserAlipaypeopleIn(List<String> values) {
            addCriterion("user_alipaypeople in", values, "userAlipaypeople");
            return (Criteria) this;
        }

        public Criteria andUserAlipaypeopleNotIn(List<String> values) {
            addCriterion("user_alipaypeople not in", values, "userAlipaypeople");
            return (Criteria) this;
        }

        public Criteria andUserAlipaypeopleBetween(String value1, String value2) {
            addCriterion("user_alipaypeople between", value1, value2, "userAlipaypeople");
            return (Criteria) this;
        }

        public Criteria andUserAlipaypeopleNotBetween(String value1, String value2) {
            addCriterion("user_alipaypeople not between", value1, value2, "userAlipaypeople");
            return (Criteria) this;
        }

        public Criteria andUserAccSpareoneIsNull() {
            addCriterion("user_acc_spareone is null");
            return (Criteria) this;
        }

        public Criteria andUserAccSpareoneIsNotNull() {
            addCriterion("user_acc_spareone is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccSpareoneEqualTo(Integer value) {
            addCriterion("user_acc_spareone =", value, "userAccSpareone");
            return (Criteria) this;
        }

        public Criteria andUserAccSpareoneNotEqualTo(Integer value) {
            addCriterion("user_acc_spareone <>", value, "userAccSpareone");
            return (Criteria) this;
        }

        public Criteria andUserAccSpareoneGreaterThan(Integer value) {
            addCriterion("user_acc_spareone >", value, "userAccSpareone");
            return (Criteria) this;
        }

        public Criteria andUserAccSpareoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_acc_spareone >=", value, "userAccSpareone");
            return (Criteria) this;
        }

        public Criteria andUserAccSpareoneLessThan(Integer value) {
            addCriterion("user_acc_spareone <", value, "userAccSpareone");
            return (Criteria) this;
        }

        public Criteria andUserAccSpareoneLessThanOrEqualTo(Integer value) {
            addCriterion("user_acc_spareone <=", value, "userAccSpareone");
            return (Criteria) this;
        }

        public Criteria andUserAccSpareoneIn(List<Integer> values) {
            addCriterion("user_acc_spareone in", values, "userAccSpareone");
            return (Criteria) this;
        }

        public Criteria andUserAccSpareoneNotIn(List<Integer> values) {
            addCriterion("user_acc_spareone not in", values, "userAccSpareone");
            return (Criteria) this;
        }

        public Criteria andUserAccSpareoneBetween(Integer value1, Integer value2) {
            addCriterion("user_acc_spareone between", value1, value2, "userAccSpareone");
            return (Criteria) this;
        }

        public Criteria andUserAccSpareoneNotBetween(Integer value1, Integer value2) {
            addCriterion("user_acc_spareone not between", value1, value2, "userAccSpareone");
            return (Criteria) this;
        }

        public Criteria andUserAccSparetwoIsNull() {
            addCriterion("user_acc_sparetwo is null");
            return (Criteria) this;
        }

        public Criteria andUserAccSparetwoIsNotNull() {
            addCriterion("user_acc_sparetwo is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccSparetwoEqualTo(Integer value) {
            addCriterion("user_acc_sparetwo =", value, "userAccSparetwo");
            return (Criteria) this;
        }

        public Criteria andUserAccSparetwoNotEqualTo(Integer value) {
            addCriterion("user_acc_sparetwo <>", value, "userAccSparetwo");
            return (Criteria) this;
        }

        public Criteria andUserAccSparetwoGreaterThan(Integer value) {
            addCriterion("user_acc_sparetwo >", value, "userAccSparetwo");
            return (Criteria) this;
        }

        public Criteria andUserAccSparetwoGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_acc_sparetwo >=", value, "userAccSparetwo");
            return (Criteria) this;
        }

        public Criteria andUserAccSparetwoLessThan(Integer value) {
            addCriterion("user_acc_sparetwo <", value, "userAccSparetwo");
            return (Criteria) this;
        }

        public Criteria andUserAccSparetwoLessThanOrEqualTo(Integer value) {
            addCriterion("user_acc_sparetwo <=", value, "userAccSparetwo");
            return (Criteria) this;
        }

        public Criteria andUserAccSparetwoIn(List<Integer> values) {
            addCriterion("user_acc_sparetwo in", values, "userAccSparetwo");
            return (Criteria) this;
        }

        public Criteria andUserAccSparetwoNotIn(List<Integer> values) {
            addCriterion("user_acc_sparetwo not in", values, "userAccSparetwo");
            return (Criteria) this;
        }

        public Criteria andUserAccSparetwoBetween(Integer value1, Integer value2) {
            addCriterion("user_acc_sparetwo between", value1, value2, "userAccSparetwo");
            return (Criteria) this;
        }

        public Criteria andUserAccSparetwoNotBetween(Integer value1, Integer value2) {
            addCriterion("user_acc_sparetwo not between", value1, value2, "userAccSparetwo");
            return (Criteria) this;
        }

        public Criteria andUserAccSparethreeIsNull() {
            addCriterion("user_acc_sparethree is null");
            return (Criteria) this;
        }

        public Criteria andUserAccSparethreeIsNotNull() {
            addCriterion("user_acc_sparethree is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccSparethreeEqualTo(String value) {
            addCriterion("user_acc_sparethree =", value, "userAccSparethree");
            return (Criteria) this;
        }

        public Criteria andUserAccSparethreeNotEqualTo(String value) {
            addCriterion("user_acc_sparethree <>", value, "userAccSparethree");
            return (Criteria) this;
        }

        public Criteria andUserAccSparethreeGreaterThan(String value) {
            addCriterion("user_acc_sparethree >", value, "userAccSparethree");
            return (Criteria) this;
        }

        public Criteria andUserAccSparethreeGreaterThanOrEqualTo(String value) {
            addCriterion("user_acc_sparethree >=", value, "userAccSparethree");
            return (Criteria) this;
        }

        public Criteria andUserAccSparethreeLessThan(String value) {
            addCriterion("user_acc_sparethree <", value, "userAccSparethree");
            return (Criteria) this;
        }

        public Criteria andUserAccSparethreeLessThanOrEqualTo(String value) {
            addCriterion("user_acc_sparethree <=", value, "userAccSparethree");
            return (Criteria) this;
        }

        public Criteria andUserAccSparethreeLike(String value) {
            addCriterion("user_acc_sparethree like", value, "userAccSparethree");
            return (Criteria) this;
        }

        public Criteria andUserAccSparethreeNotLike(String value) {
            addCriterion("user_acc_sparethree not like", value, "userAccSparethree");
            return (Criteria) this;
        }

        public Criteria andUserAccSparethreeIn(List<String> values) {
            addCriterion("user_acc_sparethree in", values, "userAccSparethree");
            return (Criteria) this;
        }

        public Criteria andUserAccSparethreeNotIn(List<String> values) {
            addCriterion("user_acc_sparethree not in", values, "userAccSparethree");
            return (Criteria) this;
        }

        public Criteria andUserAccSparethreeBetween(String value1, String value2) {
            addCriterion("user_acc_sparethree between", value1, value2, "userAccSparethree");
            return (Criteria) this;
        }

        public Criteria andUserAccSparethreeNotBetween(String value1, String value2) {
            addCriterion("user_acc_sparethree not between", value1, value2, "userAccSparethree");
            return (Criteria) this;
        }

        public Criteria andUserAccSparefourIsNull() {
            addCriterion("user_acc_sparefour is null");
            return (Criteria) this;
        }

        public Criteria andUserAccSparefourIsNotNull() {
            addCriterion("user_acc_sparefour is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccSparefourEqualTo(String value) {
            addCriterion("user_acc_sparefour =", value, "userAccSparefour");
            return (Criteria) this;
        }

        public Criteria andUserAccSparefourNotEqualTo(String value) {
            addCriterion("user_acc_sparefour <>", value, "userAccSparefour");
            return (Criteria) this;
        }

        public Criteria andUserAccSparefourGreaterThan(String value) {
            addCriterion("user_acc_sparefour >", value, "userAccSparefour");
            return (Criteria) this;
        }

        public Criteria andUserAccSparefourGreaterThanOrEqualTo(String value) {
            addCriterion("user_acc_sparefour >=", value, "userAccSparefour");
            return (Criteria) this;
        }

        public Criteria andUserAccSparefourLessThan(String value) {
            addCriterion("user_acc_sparefour <", value, "userAccSparefour");
            return (Criteria) this;
        }

        public Criteria andUserAccSparefourLessThanOrEqualTo(String value) {
            addCriterion("user_acc_sparefour <=", value, "userAccSparefour");
            return (Criteria) this;
        }

        public Criteria andUserAccSparefourLike(String value) {
            addCriterion("user_acc_sparefour like", value, "userAccSparefour");
            return (Criteria) this;
        }

        public Criteria andUserAccSparefourNotLike(String value) {
            addCriterion("user_acc_sparefour not like", value, "userAccSparefour");
            return (Criteria) this;
        }

        public Criteria andUserAccSparefourIn(List<String> values) {
            addCriterion("user_acc_sparefour in", values, "userAccSparefour");
            return (Criteria) this;
        }

        public Criteria andUserAccSparefourNotIn(List<String> values) {
            addCriterion("user_acc_sparefour not in", values, "userAccSparefour");
            return (Criteria) this;
        }

        public Criteria andUserAccSparefourBetween(String value1, String value2) {
            addCriterion("user_acc_sparefour between", value1, value2, "userAccSparefour");
            return (Criteria) this;
        }

        public Criteria andUserAccSparefourNotBetween(String value1, String value2) {
            addCriterion("user_acc_sparefour not between", value1, value2, "userAccSparefour");
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