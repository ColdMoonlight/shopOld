package com.atguigu.bean;

import java.util.ArrayList;
import java.util.List;

public class MlfrontReviewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MlfrontReviewExample() {
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

        public Criteria andReviewIdIsNull() {
            addCriterion("review_id is null");
            return (Criteria) this;
        }

        public Criteria andReviewIdIsNotNull() {
            addCriterion("review_id is not null");
            return (Criteria) this;
        }

        public Criteria andReviewIdEqualTo(Integer value) {
            addCriterion("review_id =", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdNotEqualTo(Integer value) {
            addCriterion("review_id <>", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdGreaterThan(Integer value) {
            addCriterion("review_id >", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("review_id >=", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdLessThan(Integer value) {
            addCriterion("review_id <", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdLessThanOrEqualTo(Integer value) {
            addCriterion("review_id <=", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdIn(List<Integer> values) {
            addCriterion("review_id in", values, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdNotIn(List<Integer> values) {
            addCriterion("review_id not in", values, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdBetween(Integer value1, Integer value2) {
            addCriterion("review_id between", value1, value2, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdNotBetween(Integer value1, Integer value2) {
            addCriterion("review_id not between", value1, value2, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewUidIsNull() {
            addCriterion("review_uid is null");
            return (Criteria) this;
        }

        public Criteria andReviewUidIsNotNull() {
            addCriterion("review_uid is not null");
            return (Criteria) this;
        }

        public Criteria andReviewUidEqualTo(Integer value) {
            addCriterion("review_uid =", value, "reviewUid");
            return (Criteria) this;
        }

        public Criteria andReviewUidNotEqualTo(Integer value) {
            addCriterion("review_uid <>", value, "reviewUid");
            return (Criteria) this;
        }

        public Criteria andReviewUidGreaterThan(Integer value) {
            addCriterion("review_uid >", value, "reviewUid");
            return (Criteria) this;
        }

        public Criteria andReviewUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("review_uid >=", value, "reviewUid");
            return (Criteria) this;
        }

        public Criteria andReviewUidLessThan(Integer value) {
            addCriterion("review_uid <", value, "reviewUid");
            return (Criteria) this;
        }

        public Criteria andReviewUidLessThanOrEqualTo(Integer value) {
            addCriterion("review_uid <=", value, "reviewUid");
            return (Criteria) this;
        }

        public Criteria andReviewUidIn(List<Integer> values) {
            addCriterion("review_uid in", values, "reviewUid");
            return (Criteria) this;
        }

        public Criteria andReviewUidNotIn(List<Integer> values) {
            addCriterion("review_uid not in", values, "reviewUid");
            return (Criteria) this;
        }

        public Criteria andReviewUidBetween(Integer value1, Integer value2) {
            addCriterion("review_uid between", value1, value2, "reviewUid");
            return (Criteria) this;
        }

        public Criteria andReviewUidNotBetween(Integer value1, Integer value2) {
            addCriterion("review_uid not between", value1, value2, "reviewUid");
            return (Criteria) this;
        }

        public Criteria andReviewUnameIsNull() {
            addCriterion("review_uname is null");
            return (Criteria) this;
        }

        public Criteria andReviewUnameIsNotNull() {
            addCriterion("review_uname is not null");
            return (Criteria) this;
        }

        public Criteria andReviewUnameEqualTo(String value) {
            addCriterion("review_uname =", value, "reviewUname");
            return (Criteria) this;
        }

        public Criteria andReviewUnameNotEqualTo(String value) {
            addCriterion("review_uname <>", value, "reviewUname");
            return (Criteria) this;
        }

        public Criteria andReviewUnameGreaterThan(String value) {
            addCriterion("review_uname >", value, "reviewUname");
            return (Criteria) this;
        }

        public Criteria andReviewUnameGreaterThanOrEqualTo(String value) {
            addCriterion("review_uname >=", value, "reviewUname");
            return (Criteria) this;
        }

        public Criteria andReviewUnameLessThan(String value) {
            addCriterion("review_uname <", value, "reviewUname");
            return (Criteria) this;
        }

        public Criteria andReviewUnameLessThanOrEqualTo(String value) {
            addCriterion("review_uname <=", value, "reviewUname");
            return (Criteria) this;
        }

        public Criteria andReviewUnameLike(String value) {
            addCriterion("review_uname like", value, "reviewUname");
            return (Criteria) this;
        }

        public Criteria andReviewUnameNotLike(String value) {
            addCriterion("review_uname not like", value, "reviewUname");
            return (Criteria) this;
        }

        public Criteria andReviewUnameIn(List<String> values) {
            addCriterion("review_uname in", values, "reviewUname");
            return (Criteria) this;
        }

        public Criteria andReviewUnameNotIn(List<String> values) {
            addCriterion("review_uname not in", values, "reviewUname");
            return (Criteria) this;
        }

        public Criteria andReviewUnameBetween(String value1, String value2) {
            addCriterion("review_uname between", value1, value2, "reviewUname");
            return (Criteria) this;
        }

        public Criteria andReviewUnameNotBetween(String value1, String value2) {
            addCriterion("review_uname not between", value1, value2, "reviewUname");
            return (Criteria) this;
        }

        public Criteria andReviewPidIsNull() {
            addCriterion("review_pid is null");
            return (Criteria) this;
        }

        public Criteria andReviewPidIsNotNull() {
            addCriterion("review_pid is not null");
            return (Criteria) this;
        }

        public Criteria andReviewPidEqualTo(Integer value) {
            addCriterion("review_pid =", value, "reviewPid");
            return (Criteria) this;
        }

        public Criteria andReviewPidNotEqualTo(Integer value) {
            addCriterion("review_pid <>", value, "reviewPid");
            return (Criteria) this;
        }

        public Criteria andReviewPidGreaterThan(Integer value) {
            addCriterion("review_pid >", value, "reviewPid");
            return (Criteria) this;
        }

        public Criteria andReviewPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("review_pid >=", value, "reviewPid");
            return (Criteria) this;
        }

        public Criteria andReviewPidLessThan(Integer value) {
            addCriterion("review_pid <", value, "reviewPid");
            return (Criteria) this;
        }

        public Criteria andReviewPidLessThanOrEqualTo(Integer value) {
            addCriterion("review_pid <=", value, "reviewPid");
            return (Criteria) this;
        }

        public Criteria andReviewPidIn(List<Integer> values) {
            addCriterion("review_pid in", values, "reviewPid");
            return (Criteria) this;
        }

        public Criteria andReviewPidNotIn(List<Integer> values) {
            addCriterion("review_pid not in", values, "reviewPid");
            return (Criteria) this;
        }

        public Criteria andReviewPidBetween(Integer value1, Integer value2) {
            addCriterion("review_pid between", value1, value2, "reviewPid");
            return (Criteria) this;
        }

        public Criteria andReviewPidNotBetween(Integer value1, Integer value2) {
            addCriterion("review_pid not between", value1, value2, "reviewPid");
            return (Criteria) this;
        }

        public Criteria andReviewPnameIsNull() {
            addCriterion("review_pname is null");
            return (Criteria) this;
        }

        public Criteria andReviewPnameIsNotNull() {
            addCriterion("review_pname is not null");
            return (Criteria) this;
        }

        public Criteria andReviewPnameEqualTo(String value) {
            addCriterion("review_pname =", value, "reviewPname");
            return (Criteria) this;
        }

        public Criteria andReviewPnameNotEqualTo(String value) {
            addCriterion("review_pname <>", value, "reviewPname");
            return (Criteria) this;
        }

        public Criteria andReviewPnameGreaterThan(String value) {
            addCriterion("review_pname >", value, "reviewPname");
            return (Criteria) this;
        }

        public Criteria andReviewPnameGreaterThanOrEqualTo(String value) {
            addCriterion("review_pname >=", value, "reviewPname");
            return (Criteria) this;
        }

        public Criteria andReviewPnameLessThan(String value) {
            addCriterion("review_pname <", value, "reviewPname");
            return (Criteria) this;
        }

        public Criteria andReviewPnameLessThanOrEqualTo(String value) {
            addCriterion("review_pname <=", value, "reviewPname");
            return (Criteria) this;
        }

        public Criteria andReviewPnameLike(String value) {
            addCriterion("review_pname like", value, "reviewPname");
            return (Criteria) this;
        }

        public Criteria andReviewPnameNotLike(String value) {
            addCriterion("review_pname not like", value, "reviewPname");
            return (Criteria) this;
        }

        public Criteria andReviewPnameIn(List<String> values) {
            addCriterion("review_pname in", values, "reviewPname");
            return (Criteria) this;
        }

        public Criteria andReviewPnameNotIn(List<String> values) {
            addCriterion("review_pname not in", values, "reviewPname");
            return (Criteria) this;
        }

        public Criteria andReviewPnameBetween(String value1, String value2) {
            addCriterion("review_pname between", value1, value2, "reviewPname");
            return (Criteria) this;
        }

        public Criteria andReviewPnameNotBetween(String value1, String value2) {
            addCriterion("review_pname not between", value1, value2, "reviewPname");
            return (Criteria) this;
        }

        public Criteria andReviewDetailIsNull() {
            addCriterion("review_detail is null");
            return (Criteria) this;
        }

        public Criteria andReviewDetailIsNotNull() {
            addCriterion("review_detail is not null");
            return (Criteria) this;
        }

        public Criteria andReviewDetailEqualTo(String value) {
            addCriterion("review_detail =", value, "reviewDetail");
            return (Criteria) this;
        }

        public Criteria andReviewDetailNotEqualTo(String value) {
            addCriterion("review_detail <>", value, "reviewDetail");
            return (Criteria) this;
        }

        public Criteria andReviewDetailGreaterThan(String value) {
            addCriterion("review_detail >", value, "reviewDetail");
            return (Criteria) this;
        }

        public Criteria andReviewDetailGreaterThanOrEqualTo(String value) {
            addCriterion("review_detail >=", value, "reviewDetail");
            return (Criteria) this;
        }

        public Criteria andReviewDetailLessThan(String value) {
            addCriterion("review_detail <", value, "reviewDetail");
            return (Criteria) this;
        }

        public Criteria andReviewDetailLessThanOrEqualTo(String value) {
            addCriterion("review_detail <=", value, "reviewDetail");
            return (Criteria) this;
        }

        public Criteria andReviewDetailLike(String value) {
            addCriterion("review_detail like", value, "reviewDetail");
            return (Criteria) this;
        }

        public Criteria andReviewDetailNotLike(String value) {
            addCriterion("review_detail not like", value, "reviewDetail");
            return (Criteria) this;
        }

        public Criteria andReviewDetailIn(List<String> values) {
            addCriterion("review_detail in", values, "reviewDetail");
            return (Criteria) this;
        }

        public Criteria andReviewDetailNotIn(List<String> values) {
            addCriterion("review_detail not in", values, "reviewDetail");
            return (Criteria) this;
        }

        public Criteria andReviewDetailBetween(String value1, String value2) {
            addCriterion("review_detail between", value1, value2, "reviewDetail");
            return (Criteria) this;
        }

        public Criteria andReviewDetailNotBetween(String value1, String value2) {
            addCriterion("review_detail not between", value1, value2, "reviewDetail");
            return (Criteria) this;
        }

        public Criteria andReviewStatusIsNull() {
            addCriterion("review_status is null");
            return (Criteria) this;
        }

        public Criteria andReviewStatusIsNotNull() {
            addCriterion("review_status is not null");
            return (Criteria) this;
        }

        public Criteria andReviewStatusEqualTo(Integer value) {
            addCriterion("review_status =", value, "reviewStatus");
            return (Criteria) this;
        }

        public Criteria andReviewStatusNotEqualTo(Integer value) {
            addCriterion("review_status <>", value, "reviewStatus");
            return (Criteria) this;
        }

        public Criteria andReviewStatusGreaterThan(Integer value) {
            addCriterion("review_status >", value, "reviewStatus");
            return (Criteria) this;
        }

        public Criteria andReviewStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("review_status >=", value, "reviewStatus");
            return (Criteria) this;
        }

        public Criteria andReviewStatusLessThan(Integer value) {
            addCriterion("review_status <", value, "reviewStatus");
            return (Criteria) this;
        }

        public Criteria andReviewStatusLessThanOrEqualTo(Integer value) {
            addCriterion("review_status <=", value, "reviewStatus");
            return (Criteria) this;
        }

        public Criteria andReviewStatusIn(List<Integer> values) {
            addCriterion("review_status in", values, "reviewStatus");
            return (Criteria) this;
        }

        public Criteria andReviewStatusNotIn(List<Integer> values) {
            addCriterion("review_status not in", values, "reviewStatus");
            return (Criteria) this;
        }

        public Criteria andReviewStatusBetween(Integer value1, Integer value2) {
            addCriterion("review_status between", value1, value2, "reviewStatus");
            return (Criteria) this;
        }

        public Criteria andReviewStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("review_status not between", value1, value2, "reviewStatus");
            return (Criteria) this;
        }

        public Criteria andReviewImgidstrIsNull() {
            addCriterion("review_imgIdStr is null");
            return (Criteria) this;
        }

        public Criteria andReviewImgidstrIsNotNull() {
            addCriterion("review_imgIdStr is not null");
            return (Criteria) this;
        }

        public Criteria andReviewImgidstrEqualTo(String value) {
            addCriterion("review_imgIdStr =", value, "reviewImgidstr");
            return (Criteria) this;
        }

        public Criteria andReviewImgidstrNotEqualTo(String value) {
            addCriterion("review_imgIdStr <>", value, "reviewImgidstr");
            return (Criteria) this;
        }

        public Criteria andReviewImgidstrGreaterThan(String value) {
            addCriterion("review_imgIdStr >", value, "reviewImgidstr");
            return (Criteria) this;
        }

        public Criteria andReviewImgidstrGreaterThanOrEqualTo(String value) {
            addCriterion("review_imgIdStr >=", value, "reviewImgidstr");
            return (Criteria) this;
        }

        public Criteria andReviewImgidstrLessThan(String value) {
            addCriterion("review_imgIdStr <", value, "reviewImgidstr");
            return (Criteria) this;
        }

        public Criteria andReviewImgidstrLessThanOrEqualTo(String value) {
            addCriterion("review_imgIdStr <=", value, "reviewImgidstr");
            return (Criteria) this;
        }

        public Criteria andReviewImgidstrLike(String value) {
            addCriterion("review_imgIdStr like", value, "reviewImgidstr");
            return (Criteria) this;
        }

        public Criteria andReviewImgidstrNotLike(String value) {
            addCriterion("review_imgIdStr not like", value, "reviewImgidstr");
            return (Criteria) this;
        }

        public Criteria andReviewImgidstrIn(List<String> values) {
            addCriterion("review_imgIdStr in", values, "reviewImgidstr");
            return (Criteria) this;
        }

        public Criteria andReviewImgidstrNotIn(List<String> values) {
            addCriterion("review_imgIdStr not in", values, "reviewImgidstr");
            return (Criteria) this;
        }

        public Criteria andReviewImgidstrBetween(String value1, String value2) {
            addCriterion("review_imgIdStr between", value1, value2, "reviewImgidstr");
            return (Criteria) this;
        }

        public Criteria andReviewImgidstrNotBetween(String value1, String value2) {
            addCriterion("review_imgIdStr not between", value1, value2, "reviewImgidstr");
            return (Criteria) this;
        }

        public Criteria andReviewProstarnumIsNull() {
            addCriterion("review_proStarNum is null");
            return (Criteria) this;
        }

        public Criteria andReviewProstarnumIsNotNull() {
            addCriterion("review_proStarNum is not null");
            return (Criteria) this;
        }

        public Criteria andReviewProstarnumEqualTo(Integer value) {
            addCriterion("review_proStarNum =", value, "reviewProstarnum");
            return (Criteria) this;
        }

        public Criteria andReviewProstarnumNotEqualTo(Integer value) {
            addCriterion("review_proStarNum <>", value, "reviewProstarnum");
            return (Criteria) this;
        }

        public Criteria andReviewProstarnumGreaterThan(Integer value) {
            addCriterion("review_proStarNum >", value, "reviewProstarnum");
            return (Criteria) this;
        }

        public Criteria andReviewProstarnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("review_proStarNum >=", value, "reviewProstarnum");
            return (Criteria) this;
        }

        public Criteria andReviewProstarnumLessThan(Integer value) {
            addCriterion("review_proStarNum <", value, "reviewProstarnum");
            return (Criteria) this;
        }

        public Criteria andReviewProstarnumLessThanOrEqualTo(Integer value) {
            addCriterion("review_proStarNum <=", value, "reviewProstarnum");
            return (Criteria) this;
        }

        public Criteria andReviewProstarnumIn(List<Integer> values) {
            addCriterion("review_proStarNum in", values, "reviewProstarnum");
            return (Criteria) this;
        }

        public Criteria andReviewProstarnumNotIn(List<Integer> values) {
            addCriterion("review_proStarNum not in", values, "reviewProstarnum");
            return (Criteria) this;
        }

        public Criteria andReviewProstarnumBetween(Integer value1, Integer value2) {
            addCriterion("review_proStarNum between", value1, value2, "reviewProstarnum");
            return (Criteria) this;
        }

        public Criteria andReviewProstarnumNotBetween(Integer value1, Integer value2) {
            addCriterion("review_proStarNum not between", value1, value2, "reviewProstarnum");
            return (Criteria) this;
        }

        public Criteria andReviewServicestarnumIsNull() {
            addCriterion("review_serviceStarNum is null");
            return (Criteria) this;
        }

        public Criteria andReviewServicestarnumIsNotNull() {
            addCriterion("review_serviceStarNum is not null");
            return (Criteria) this;
        }

        public Criteria andReviewServicestarnumEqualTo(Integer value) {
            addCriterion("review_serviceStarNum =", value, "reviewServicestarnum");
            return (Criteria) this;
        }

        public Criteria andReviewServicestarnumNotEqualTo(Integer value) {
            addCriterion("review_serviceStarNum <>", value, "reviewServicestarnum");
            return (Criteria) this;
        }

        public Criteria andReviewServicestarnumGreaterThan(Integer value) {
            addCriterion("review_serviceStarNum >", value, "reviewServicestarnum");
            return (Criteria) this;
        }

        public Criteria andReviewServicestarnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("review_serviceStarNum >=", value, "reviewServicestarnum");
            return (Criteria) this;
        }

        public Criteria andReviewServicestarnumLessThan(Integer value) {
            addCriterion("review_serviceStarNum <", value, "reviewServicestarnum");
            return (Criteria) this;
        }

        public Criteria andReviewServicestarnumLessThanOrEqualTo(Integer value) {
            addCriterion("review_serviceStarNum <=", value, "reviewServicestarnum");
            return (Criteria) this;
        }

        public Criteria andReviewServicestarnumIn(List<Integer> values) {
            addCriterion("review_serviceStarNum in", values, "reviewServicestarnum");
            return (Criteria) this;
        }

        public Criteria andReviewServicestarnumNotIn(List<Integer> values) {
            addCriterion("review_serviceStarNum not in", values, "reviewServicestarnum");
            return (Criteria) this;
        }

        public Criteria andReviewServicestarnumBetween(Integer value1, Integer value2) {
            addCriterion("review_serviceStarNum between", value1, value2, "reviewServicestarnum");
            return (Criteria) this;
        }

        public Criteria andReviewServicestarnumNotBetween(Integer value1, Integer value2) {
            addCriterion("review_serviceStarNum not between", value1, value2, "reviewServicestarnum");
            return (Criteria) this;
        }

        public Criteria andReviewLogisticsstarnumIsNull() {
            addCriterion("review_logisticsStarNum is null");
            return (Criteria) this;
        }

        public Criteria andReviewLogisticsstarnumIsNotNull() {
            addCriterion("review_logisticsStarNum is not null");
            return (Criteria) this;
        }

        public Criteria andReviewLogisticsstarnumEqualTo(Integer value) {
            addCriterion("review_logisticsStarNum =", value, "reviewLogisticsstarnum");
            return (Criteria) this;
        }

        public Criteria andReviewLogisticsstarnumNotEqualTo(Integer value) {
            addCriterion("review_logisticsStarNum <>", value, "reviewLogisticsstarnum");
            return (Criteria) this;
        }

        public Criteria andReviewLogisticsstarnumGreaterThan(Integer value) {
            addCriterion("review_logisticsStarNum >", value, "reviewLogisticsstarnum");
            return (Criteria) this;
        }

        public Criteria andReviewLogisticsstarnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("review_logisticsStarNum >=", value, "reviewLogisticsstarnum");
            return (Criteria) this;
        }

        public Criteria andReviewLogisticsstarnumLessThan(Integer value) {
            addCriterion("review_logisticsStarNum <", value, "reviewLogisticsstarnum");
            return (Criteria) this;
        }

        public Criteria andReviewLogisticsstarnumLessThanOrEqualTo(Integer value) {
            addCriterion("review_logisticsStarNum <=", value, "reviewLogisticsstarnum");
            return (Criteria) this;
        }

        public Criteria andReviewLogisticsstarnumIn(List<Integer> values) {
            addCriterion("review_logisticsStarNum in", values, "reviewLogisticsstarnum");
            return (Criteria) this;
        }

        public Criteria andReviewLogisticsstarnumNotIn(List<Integer> values) {
            addCriterion("review_logisticsStarNum not in", values, "reviewLogisticsstarnum");
            return (Criteria) this;
        }

        public Criteria andReviewLogisticsstarnumBetween(Integer value1, Integer value2) {
            addCriterion("review_logisticsStarNum between", value1, value2, "reviewLogisticsstarnum");
            return (Criteria) this;
        }

        public Criteria andReviewLogisticsstarnumNotBetween(Integer value1, Integer value2) {
            addCriterion("review_logisticsStarNum not between", value1, value2, "reviewLogisticsstarnum");
            return (Criteria) this;
        }

        public Criteria andReviewCreatetimeIsNull() {
            addCriterion("review_createTime is null");
            return (Criteria) this;
        }

        public Criteria andReviewCreatetimeIsNotNull() {
            addCriterion("review_createTime is not null");
            return (Criteria) this;
        }

        public Criteria andReviewCreatetimeEqualTo(String value) {
            addCriterion("review_createTime =", value, "reviewCreatetime");
            return (Criteria) this;
        }

        public Criteria andReviewCreatetimeNotEqualTo(String value) {
            addCriterion("review_createTime <>", value, "reviewCreatetime");
            return (Criteria) this;
        }

        public Criteria andReviewCreatetimeGreaterThan(String value) {
            addCriterion("review_createTime >", value, "reviewCreatetime");
            return (Criteria) this;
        }

        public Criteria andReviewCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("review_createTime >=", value, "reviewCreatetime");
            return (Criteria) this;
        }

        public Criteria andReviewCreatetimeLessThan(String value) {
            addCriterion("review_createTime <", value, "reviewCreatetime");
            return (Criteria) this;
        }

        public Criteria andReviewCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("review_createTime <=", value, "reviewCreatetime");
            return (Criteria) this;
        }

        public Criteria andReviewCreatetimeLike(String value) {
            addCriterion("review_createTime like", value, "reviewCreatetime");
            return (Criteria) this;
        }

        public Criteria andReviewCreatetimeNotLike(String value) {
            addCriterion("review_createTime not like", value, "reviewCreatetime");
            return (Criteria) this;
        }

        public Criteria andReviewCreatetimeIn(List<String> values) {
            addCriterion("review_createTime in", values, "reviewCreatetime");
            return (Criteria) this;
        }

        public Criteria andReviewCreatetimeNotIn(List<String> values) {
            addCriterion("review_createTime not in", values, "reviewCreatetime");
            return (Criteria) this;
        }

        public Criteria andReviewCreatetimeBetween(String value1, String value2) {
            addCriterion("review_createTime between", value1, value2, "reviewCreatetime");
            return (Criteria) this;
        }

        public Criteria andReviewCreatetimeNotBetween(String value1, String value2) {
            addCriterion("review_createTime not between", value1, value2, "reviewCreatetime");
            return (Criteria) this;
        }

        public Criteria andReviewMotifytimeIsNull() {
            addCriterion("review_motifyTime is null");
            return (Criteria) this;
        }

        public Criteria andReviewMotifytimeIsNotNull() {
            addCriterion("review_motifyTime is not null");
            return (Criteria) this;
        }

        public Criteria andReviewMotifytimeEqualTo(String value) {
            addCriterion("review_motifyTime =", value, "reviewMotifytime");
            return (Criteria) this;
        }

        public Criteria andReviewMotifytimeNotEqualTo(String value) {
            addCriterion("review_motifyTime <>", value, "reviewMotifytime");
            return (Criteria) this;
        }

        public Criteria andReviewMotifytimeGreaterThan(String value) {
            addCriterion("review_motifyTime >", value, "reviewMotifytime");
            return (Criteria) this;
        }

        public Criteria andReviewMotifytimeGreaterThanOrEqualTo(String value) {
            addCriterion("review_motifyTime >=", value, "reviewMotifytime");
            return (Criteria) this;
        }

        public Criteria andReviewMotifytimeLessThan(String value) {
            addCriterion("review_motifyTime <", value, "reviewMotifytime");
            return (Criteria) this;
        }

        public Criteria andReviewMotifytimeLessThanOrEqualTo(String value) {
            addCriterion("review_motifyTime <=", value, "reviewMotifytime");
            return (Criteria) this;
        }

        public Criteria andReviewMotifytimeLike(String value) {
            addCriterion("review_motifyTime like", value, "reviewMotifytime");
            return (Criteria) this;
        }

        public Criteria andReviewMotifytimeNotLike(String value) {
            addCriterion("review_motifyTime not like", value, "reviewMotifytime");
            return (Criteria) this;
        }

        public Criteria andReviewMotifytimeIn(List<String> values) {
            addCriterion("review_motifyTime in", values, "reviewMotifytime");
            return (Criteria) this;
        }

        public Criteria andReviewMotifytimeNotIn(List<String> values) {
            addCriterion("review_motifyTime not in", values, "reviewMotifytime");
            return (Criteria) this;
        }

        public Criteria andReviewMotifytimeBetween(String value1, String value2) {
            addCriterion("review_motifyTime between", value1, value2, "reviewMotifytime");
            return (Criteria) this;
        }

        public Criteria andReviewMotifytimeNotBetween(String value1, String value2) {
            addCriterion("review_motifyTime not between", value1, value2, "reviewMotifytime");
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