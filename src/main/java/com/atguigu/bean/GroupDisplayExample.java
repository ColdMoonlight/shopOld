package com.atguigu.bean;

import java.util.ArrayList;
import java.util.List;

public class GroupDisplayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GroupDisplayExample() {
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

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Integer value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Integer value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Integer value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Integer value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Integer> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Integer> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupSourceIsNull() {
            addCriterion("group_source is null");
            return (Criteria) this;
        }

        public Criteria andGroupSourceIsNotNull() {
            addCriterion("group_source is not null");
            return (Criteria) this;
        }

        public Criteria andGroupSourceEqualTo(String value) {
            addCriterion("group_source =", value, "groupSource");
            return (Criteria) this;
        }

        public Criteria andGroupSourceNotEqualTo(String value) {
            addCriterion("group_source <>", value, "groupSource");
            return (Criteria) this;
        }

        public Criteria andGroupSourceGreaterThan(String value) {
            addCriterion("group_source >", value, "groupSource");
            return (Criteria) this;
        }

        public Criteria andGroupSourceGreaterThanOrEqualTo(String value) {
            addCriterion("group_source >=", value, "groupSource");
            return (Criteria) this;
        }

        public Criteria andGroupSourceLessThan(String value) {
            addCriterion("group_source <", value, "groupSource");
            return (Criteria) this;
        }

        public Criteria andGroupSourceLessThanOrEqualTo(String value) {
            addCriterion("group_source <=", value, "groupSource");
            return (Criteria) this;
        }

        public Criteria andGroupSourceLike(String value) {
            addCriterion("group_source like", value, "groupSource");
            return (Criteria) this;
        }

        public Criteria andGroupSourceNotLike(String value) {
            addCriterion("group_source not like", value, "groupSource");
            return (Criteria) this;
        }

        public Criteria andGroupSourceIn(List<String> values) {
            addCriterion("group_source in", values, "groupSource");
            return (Criteria) this;
        }

        public Criteria andGroupSourceNotIn(List<String> values) {
            addCriterion("group_source not in", values, "groupSource");
            return (Criteria) this;
        }

        public Criteria andGroupSourceBetween(String value1, String value2) {
            addCriterion("group_source between", value1, value2, "groupSource");
            return (Criteria) this;
        }

        public Criteria andGroupSourceNotBetween(String value1, String value2) {
            addCriterion("group_source not between", value1, value2, "groupSource");
            return (Criteria) this;
        }

        public Criteria andGroupTaskNameIsNull() {
            addCriterion("group_task_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupTaskNameIsNotNull() {
            addCriterion("group_task_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupTaskNameEqualTo(String value) {
            addCriterion("group_task_name =", value, "groupTaskName");
            return (Criteria) this;
        }

        public Criteria andGroupTaskNameNotEqualTo(String value) {
            addCriterion("group_task_name <>", value, "groupTaskName");
            return (Criteria) this;
        }

        public Criteria andGroupTaskNameGreaterThan(String value) {
            addCriterion("group_task_name >", value, "groupTaskName");
            return (Criteria) this;
        }

        public Criteria andGroupTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_task_name >=", value, "groupTaskName");
            return (Criteria) this;
        }

        public Criteria andGroupTaskNameLessThan(String value) {
            addCriterion("group_task_name <", value, "groupTaskName");
            return (Criteria) this;
        }

        public Criteria andGroupTaskNameLessThanOrEqualTo(String value) {
            addCriterion("group_task_name <=", value, "groupTaskName");
            return (Criteria) this;
        }

        public Criteria andGroupTaskNameLike(String value) {
            addCriterion("group_task_name like", value, "groupTaskName");
            return (Criteria) this;
        }

        public Criteria andGroupTaskNameNotLike(String value) {
            addCriterion("group_task_name not like", value, "groupTaskName");
            return (Criteria) this;
        }

        public Criteria andGroupTaskNameIn(List<String> values) {
            addCriterion("group_task_name in", values, "groupTaskName");
            return (Criteria) this;
        }

        public Criteria andGroupTaskNameNotIn(List<String> values) {
            addCriterion("group_task_name not in", values, "groupTaskName");
            return (Criteria) this;
        }

        public Criteria andGroupTaskNameBetween(String value1, String value2) {
            addCriterion("group_task_name between", value1, value2, "groupTaskName");
            return (Criteria) this;
        }

        public Criteria andGroupTaskNameNotBetween(String value1, String value2) {
            addCriterion("group_task_name not between", value1, value2, "groupTaskName");
            return (Criteria) this;
        }

        public Criteria andGroupAllnumIsNull() {
            addCriterion("group_allnum is null");
            return (Criteria) this;
        }

        public Criteria andGroupAllnumIsNotNull() {
            addCriterion("group_allnum is not null");
            return (Criteria) this;
        }

        public Criteria andGroupAllnumEqualTo(Integer value) {
            addCriterion("group_allnum =", value, "groupAllnum");
            return (Criteria) this;
        }

        public Criteria andGroupAllnumNotEqualTo(Integer value) {
            addCriterion("group_allnum <>", value, "groupAllnum");
            return (Criteria) this;
        }

        public Criteria andGroupAllnumGreaterThan(Integer value) {
            addCriterion("group_allnum >", value, "groupAllnum");
            return (Criteria) this;
        }

        public Criteria andGroupAllnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_allnum >=", value, "groupAllnum");
            return (Criteria) this;
        }

        public Criteria andGroupAllnumLessThan(Integer value) {
            addCriterion("group_allnum <", value, "groupAllnum");
            return (Criteria) this;
        }

        public Criteria andGroupAllnumLessThanOrEqualTo(Integer value) {
            addCriterion("group_allnum <=", value, "groupAllnum");
            return (Criteria) this;
        }

        public Criteria andGroupAllnumIn(List<Integer> values) {
            addCriterion("group_allnum in", values, "groupAllnum");
            return (Criteria) this;
        }

        public Criteria andGroupAllnumNotIn(List<Integer> values) {
            addCriterion("group_allnum not in", values, "groupAllnum");
            return (Criteria) this;
        }

        public Criteria andGroupAllnumBetween(Integer value1, Integer value2) {
            addCriterion("group_allnum between", value1, value2, "groupAllnum");
            return (Criteria) this;
        }

        public Criteria andGroupAllnumNotBetween(Integer value1, Integer value2) {
            addCriterion("group_allnum not between", value1, value2, "groupAllnum");
            return (Criteria) this;
        }

        public Criteria andGroupNownumIsNull() {
            addCriterion("group_nownum is null");
            return (Criteria) this;
        }

        public Criteria andGroupNownumIsNotNull() {
            addCriterion("group_nownum is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNownumEqualTo(Integer value) {
            addCriterion("group_nownum =", value, "groupNownum");
            return (Criteria) this;
        }

        public Criteria andGroupNownumNotEqualTo(Integer value) {
            addCriterion("group_nownum <>", value, "groupNownum");
            return (Criteria) this;
        }

        public Criteria andGroupNownumGreaterThan(Integer value) {
            addCriterion("group_nownum >", value, "groupNownum");
            return (Criteria) this;
        }

        public Criteria andGroupNownumGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_nownum >=", value, "groupNownum");
            return (Criteria) this;
        }

        public Criteria andGroupNownumLessThan(Integer value) {
            addCriterion("group_nownum <", value, "groupNownum");
            return (Criteria) this;
        }

        public Criteria andGroupNownumLessThanOrEqualTo(Integer value) {
            addCriterion("group_nownum <=", value, "groupNownum");
            return (Criteria) this;
        }

        public Criteria andGroupNownumIn(List<Integer> values) {
            addCriterion("group_nownum in", values, "groupNownum");
            return (Criteria) this;
        }

        public Criteria andGroupNownumNotIn(List<Integer> values) {
            addCriterion("group_nownum not in", values, "groupNownum");
            return (Criteria) this;
        }

        public Criteria andGroupNownumBetween(Integer value1, Integer value2) {
            addCriterion("group_nownum between", value1, value2, "groupNownum");
            return (Criteria) this;
        }

        public Criteria andGroupNownumNotBetween(Integer value1, Integer value2) {
            addCriterion("group_nownum not between", value1, value2, "groupNownum");
            return (Criteria) this;
        }

        public Criteria andGroupAppstoreidIsNull() {
            addCriterion("group_appstoreid is null");
            return (Criteria) this;
        }

        public Criteria andGroupAppstoreidIsNotNull() {
            addCriterion("group_appstoreid is not null");
            return (Criteria) this;
        }

        public Criteria andGroupAppstoreidEqualTo(String value) {
            addCriterion("group_appstoreid =", value, "groupAppstoreid");
            return (Criteria) this;
        }

        public Criteria andGroupAppstoreidNotEqualTo(String value) {
            addCriterion("group_appstoreid <>", value, "groupAppstoreid");
            return (Criteria) this;
        }

        public Criteria andGroupAppstoreidGreaterThan(String value) {
            addCriterion("group_appstoreid >", value, "groupAppstoreid");
            return (Criteria) this;
        }

        public Criteria andGroupAppstoreidGreaterThanOrEqualTo(String value) {
            addCriterion("group_appstoreid >=", value, "groupAppstoreid");
            return (Criteria) this;
        }

        public Criteria andGroupAppstoreidLessThan(String value) {
            addCriterion("group_appstoreid <", value, "groupAppstoreid");
            return (Criteria) this;
        }

        public Criteria andGroupAppstoreidLessThanOrEqualTo(String value) {
            addCriterion("group_appstoreid <=", value, "groupAppstoreid");
            return (Criteria) this;
        }

        public Criteria andGroupAppstoreidLike(String value) {
            addCriterion("group_appstoreid like", value, "groupAppstoreid");
            return (Criteria) this;
        }

        public Criteria andGroupAppstoreidNotLike(String value) {
            addCriterion("group_appstoreid not like", value, "groupAppstoreid");
            return (Criteria) this;
        }

        public Criteria andGroupAppstoreidIn(List<String> values) {
            addCriterion("group_appstoreid in", values, "groupAppstoreid");
            return (Criteria) this;
        }

        public Criteria andGroupAppstoreidNotIn(List<String> values) {
            addCriterion("group_appstoreid not in", values, "groupAppstoreid");
            return (Criteria) this;
        }

        public Criteria andGroupAppstoreidBetween(String value1, String value2) {
            addCriterion("group_appstoreid between", value1, value2, "groupAppstoreid");
            return (Criteria) this;
        }

        public Criteria andGroupAppstoreidNotBetween(String value1, String value2) {
            addCriterion("group_appstoreid not between", value1, value2, "groupAppstoreid");
            return (Criteria) this;
        }

        public Criteria andGroupPimageurlIsNull() {
            addCriterion("group_pimageurl is null");
            return (Criteria) this;
        }

        public Criteria andGroupPimageurlIsNotNull() {
            addCriterion("group_pimageurl is not null");
            return (Criteria) this;
        }

        public Criteria andGroupPimageurlEqualTo(String value) {
            addCriterion("group_pimageurl =", value, "groupPimageurl");
            return (Criteria) this;
        }

        public Criteria andGroupPimageurlNotEqualTo(String value) {
            addCriterion("group_pimageurl <>", value, "groupPimageurl");
            return (Criteria) this;
        }

        public Criteria andGroupPimageurlGreaterThan(String value) {
            addCriterion("group_pimageurl >", value, "groupPimageurl");
            return (Criteria) this;
        }

        public Criteria andGroupPimageurlGreaterThanOrEqualTo(String value) {
            addCriterion("group_pimageurl >=", value, "groupPimageurl");
            return (Criteria) this;
        }

        public Criteria andGroupPimageurlLessThan(String value) {
            addCriterion("group_pimageurl <", value, "groupPimageurl");
            return (Criteria) this;
        }

        public Criteria andGroupPimageurlLessThanOrEqualTo(String value) {
            addCriterion("group_pimageurl <=", value, "groupPimageurl");
            return (Criteria) this;
        }

        public Criteria andGroupPimageurlLike(String value) {
            addCriterion("group_pimageurl like", value, "groupPimageurl");
            return (Criteria) this;
        }

        public Criteria andGroupPimageurlNotLike(String value) {
            addCriterion("group_pimageurl not like", value, "groupPimageurl");
            return (Criteria) this;
        }

        public Criteria andGroupPimageurlIn(List<String> values) {
            addCriterion("group_pimageurl in", values, "groupPimageurl");
            return (Criteria) this;
        }

        public Criteria andGroupPimageurlNotIn(List<String> values) {
            addCriterion("group_pimageurl not in", values, "groupPimageurl");
            return (Criteria) this;
        }

        public Criteria andGroupPimageurlBetween(String value1, String value2) {
            addCriterion("group_pimageurl between", value1, value2, "groupPimageurl");
            return (Criteria) this;
        }

        public Criteria andGroupPimageurlNotBetween(String value1, String value2) {
            addCriterion("group_pimageurl not between", value1, value2, "groupPimageurl");
            return (Criteria) this;
        }

        public Criteria andGroupPriorityIsNull() {
            addCriterion("group_priority is null");
            return (Criteria) this;
        }

        public Criteria andGroupPriorityIsNotNull() {
            addCriterion("group_priority is not null");
            return (Criteria) this;
        }

        public Criteria andGroupPriorityEqualTo(Integer value) {
            addCriterion("group_priority =", value, "groupPriority");
            return (Criteria) this;
        }

        public Criteria andGroupPriorityNotEqualTo(Integer value) {
            addCriterion("group_priority <>", value, "groupPriority");
            return (Criteria) this;
        }

        public Criteria andGroupPriorityGreaterThan(Integer value) {
            addCriterion("group_priority >", value, "groupPriority");
            return (Criteria) this;
        }

        public Criteria andGroupPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_priority >=", value, "groupPriority");
            return (Criteria) this;
        }

        public Criteria andGroupPriorityLessThan(Integer value) {
            addCriterion("group_priority <", value, "groupPriority");
            return (Criteria) this;
        }

        public Criteria andGroupPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("group_priority <=", value, "groupPriority");
            return (Criteria) this;
        }

        public Criteria andGroupPriorityIn(List<Integer> values) {
            addCriterion("group_priority in", values, "groupPriority");
            return (Criteria) this;
        }

        public Criteria andGroupPriorityNotIn(List<Integer> values) {
            addCriterion("group_priority not in", values, "groupPriority");
            return (Criteria) this;
        }

        public Criteria andGroupPriorityBetween(Integer value1, Integer value2) {
            addCriterion("group_priority between", value1, value2, "groupPriority");
            return (Criteria) this;
        }

        public Criteria andGroupPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("group_priority not between", value1, value2, "groupPriority");
            return (Criteria) this;
        }

        public Criteria andGroupHowdownloadIsNull() {
            addCriterion("group_howdownload is null");
            return (Criteria) this;
        }

        public Criteria andGroupHowdownloadIsNotNull() {
            addCriterion("group_howdownload is not null");
            return (Criteria) this;
        }

        public Criteria andGroupHowdownloadEqualTo(String value) {
            addCriterion("group_howdownload =", value, "groupHowdownload");
            return (Criteria) this;
        }

        public Criteria andGroupHowdownloadNotEqualTo(String value) {
            addCriterion("group_howdownload <>", value, "groupHowdownload");
            return (Criteria) this;
        }

        public Criteria andGroupHowdownloadGreaterThan(String value) {
            addCriterion("group_howdownload >", value, "groupHowdownload");
            return (Criteria) this;
        }

        public Criteria andGroupHowdownloadGreaterThanOrEqualTo(String value) {
            addCriterion("group_howdownload >=", value, "groupHowdownload");
            return (Criteria) this;
        }

        public Criteria andGroupHowdownloadLessThan(String value) {
            addCriterion("group_howdownload <", value, "groupHowdownload");
            return (Criteria) this;
        }

        public Criteria andGroupHowdownloadLessThanOrEqualTo(String value) {
            addCriterion("group_howdownload <=", value, "groupHowdownload");
            return (Criteria) this;
        }

        public Criteria andGroupHowdownloadLike(String value) {
            addCriterion("group_howdownload like", value, "groupHowdownload");
            return (Criteria) this;
        }

        public Criteria andGroupHowdownloadNotLike(String value) {
            addCriterion("group_howdownload not like", value, "groupHowdownload");
            return (Criteria) this;
        }

        public Criteria andGroupHowdownloadIn(List<String> values) {
            addCriterion("group_howdownload in", values, "groupHowdownload");
            return (Criteria) this;
        }

        public Criteria andGroupHowdownloadNotIn(List<String> values) {
            addCriterion("group_howdownload not in", values, "groupHowdownload");
            return (Criteria) this;
        }

        public Criteria andGroupHowdownloadBetween(String value1, String value2) {
            addCriterion("group_howdownload between", value1, value2, "groupHowdownload");
            return (Criteria) this;
        }

        public Criteria andGroupHowdownloadNotBetween(String value1, String value2) {
            addCriterion("group_howdownload not between", value1, value2, "groupHowdownload");
            return (Criteria) this;
        }

        public Criteria andGroupDownloadurlIsNull() {
            addCriterion("group_downloadurl is null");
            return (Criteria) this;
        }

        public Criteria andGroupDownloadurlIsNotNull() {
            addCriterion("group_downloadurl is not null");
            return (Criteria) this;
        }

        public Criteria andGroupDownloadurlEqualTo(String value) {
            addCriterion("group_downloadurl =", value, "groupDownloadurl");
            return (Criteria) this;
        }

        public Criteria andGroupDownloadurlNotEqualTo(String value) {
            addCriterion("group_downloadurl <>", value, "groupDownloadurl");
            return (Criteria) this;
        }

        public Criteria andGroupDownloadurlGreaterThan(String value) {
            addCriterion("group_downloadurl >", value, "groupDownloadurl");
            return (Criteria) this;
        }

        public Criteria andGroupDownloadurlGreaterThanOrEqualTo(String value) {
            addCriterion("group_downloadurl >=", value, "groupDownloadurl");
            return (Criteria) this;
        }

        public Criteria andGroupDownloadurlLessThan(String value) {
            addCriterion("group_downloadurl <", value, "groupDownloadurl");
            return (Criteria) this;
        }

        public Criteria andGroupDownloadurlLessThanOrEqualTo(String value) {
            addCriterion("group_downloadurl <=", value, "groupDownloadurl");
            return (Criteria) this;
        }

        public Criteria andGroupDownloadurlLike(String value) {
            addCriterion("group_downloadurl like", value, "groupDownloadurl");
            return (Criteria) this;
        }

        public Criteria andGroupDownloadurlNotLike(String value) {
            addCriterion("group_downloadurl not like", value, "groupDownloadurl");
            return (Criteria) this;
        }

        public Criteria andGroupDownloadurlIn(List<String> values) {
            addCriterion("group_downloadurl in", values, "groupDownloadurl");
            return (Criteria) this;
        }

        public Criteria andGroupDownloadurlNotIn(List<String> values) {
            addCriterion("group_downloadurl not in", values, "groupDownloadurl");
            return (Criteria) this;
        }

        public Criteria andGroupDownloadurlBetween(String value1, String value2) {
            addCriterion("group_downloadurl between", value1, value2, "groupDownloadurl");
            return (Criteria) this;
        }

        public Criteria andGroupDownloadurlNotBetween(String value1, String value2) {
            addCriterion("group_downloadurl not between", value1, value2, "groupDownloadurl");
            return (Criteria) this;
        }

        public Criteria andGroupCreatetimeIsNull() {
            addCriterion("group_createtime is null");
            return (Criteria) this;
        }

        public Criteria andGroupCreatetimeIsNotNull() {
            addCriterion("group_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andGroupCreatetimeEqualTo(String value) {
            addCriterion("group_createtime =", value, "groupCreatetime");
            return (Criteria) this;
        }

        public Criteria andGroupCreatetimeNotEqualTo(String value) {
            addCriterion("group_createtime <>", value, "groupCreatetime");
            return (Criteria) this;
        }

        public Criteria andGroupCreatetimeGreaterThan(String value) {
            addCriterion("group_createtime >", value, "groupCreatetime");
            return (Criteria) this;
        }

        public Criteria andGroupCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("group_createtime >=", value, "groupCreatetime");
            return (Criteria) this;
        }

        public Criteria andGroupCreatetimeLessThan(String value) {
            addCriterion("group_createtime <", value, "groupCreatetime");
            return (Criteria) this;
        }

        public Criteria andGroupCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("group_createtime <=", value, "groupCreatetime");
            return (Criteria) this;
        }

        public Criteria andGroupCreatetimeLike(String value) {
            addCriterion("group_createtime like", value, "groupCreatetime");
            return (Criteria) this;
        }

        public Criteria andGroupCreatetimeNotLike(String value) {
            addCriterion("group_createtime not like", value, "groupCreatetime");
            return (Criteria) this;
        }

        public Criteria andGroupCreatetimeIn(List<String> values) {
            addCriterion("group_createtime in", values, "groupCreatetime");
            return (Criteria) this;
        }

        public Criteria andGroupCreatetimeNotIn(List<String> values) {
            addCriterion("group_createtime not in", values, "groupCreatetime");
            return (Criteria) this;
        }

        public Criteria andGroupCreatetimeBetween(String value1, String value2) {
            addCriterion("group_createtime between", value1, value2, "groupCreatetime");
            return (Criteria) this;
        }

        public Criteria andGroupCreatetimeNotBetween(String value1, String value2) {
            addCriterion("group_createtime not between", value1, value2, "groupCreatetime");
            return (Criteria) this;
        }

        public Criteria andGroupUpdatetimeIsNull() {
            addCriterion("group_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andGroupUpdatetimeIsNotNull() {
            addCriterion("group_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andGroupUpdatetimeEqualTo(String value) {
            addCriterion("group_updatetime =", value, "groupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andGroupUpdatetimeNotEqualTo(String value) {
            addCriterion("group_updatetime <>", value, "groupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andGroupUpdatetimeGreaterThan(String value) {
            addCriterion("group_updatetime >", value, "groupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andGroupUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("group_updatetime >=", value, "groupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andGroupUpdatetimeLessThan(String value) {
            addCriterion("group_updatetime <", value, "groupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andGroupUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("group_updatetime <=", value, "groupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andGroupUpdatetimeLike(String value) {
            addCriterion("group_updatetime like", value, "groupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andGroupUpdatetimeNotLike(String value) {
            addCriterion("group_updatetime not like", value, "groupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andGroupUpdatetimeIn(List<String> values) {
            addCriterion("group_updatetime in", values, "groupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andGroupUpdatetimeNotIn(List<String> values) {
            addCriterion("group_updatetime not in", values, "groupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andGroupUpdatetimeBetween(String value1, String value2) {
            addCriterion("group_updatetime between", value1, value2, "groupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andGroupUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("group_updatetime not between", value1, value2, "groupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andGroupPeopleIsNull() {
            addCriterion("group_people is null");
            return (Criteria) this;
        }

        public Criteria andGroupPeopleIsNotNull() {
            addCriterion("group_people is not null");
            return (Criteria) this;
        }

        public Criteria andGroupPeopleEqualTo(String value) {
            addCriterion("group_people =", value, "groupPeople");
            return (Criteria) this;
        }

        public Criteria andGroupPeopleNotEqualTo(String value) {
            addCriterion("group_people <>", value, "groupPeople");
            return (Criteria) this;
        }

        public Criteria andGroupPeopleGreaterThan(String value) {
            addCriterion("group_people >", value, "groupPeople");
            return (Criteria) this;
        }

        public Criteria andGroupPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("group_people >=", value, "groupPeople");
            return (Criteria) this;
        }

        public Criteria andGroupPeopleLessThan(String value) {
            addCriterion("group_people <", value, "groupPeople");
            return (Criteria) this;
        }

        public Criteria andGroupPeopleLessThanOrEqualTo(String value) {
            addCriterion("group_people <=", value, "groupPeople");
            return (Criteria) this;
        }

        public Criteria andGroupPeopleLike(String value) {
            addCriterion("group_people like", value, "groupPeople");
            return (Criteria) this;
        }

        public Criteria andGroupPeopleNotLike(String value) {
            addCriterion("group_people not like", value, "groupPeople");
            return (Criteria) this;
        }

        public Criteria andGroupPeopleIn(List<String> values) {
            addCriterion("group_people in", values, "groupPeople");
            return (Criteria) this;
        }

        public Criteria andGroupPeopleNotIn(List<String> values) {
            addCriterion("group_people not in", values, "groupPeople");
            return (Criteria) this;
        }

        public Criteria andGroupPeopleBetween(String value1, String value2) {
            addCriterion("group_people between", value1, value2, "groupPeople");
            return (Criteria) this;
        }

        public Criteria andGroupPeopleNotBetween(String value1, String value2) {
            addCriterion("group_people not between", value1, value2, "groupPeople");
            return (Criteria) this;
        }

        public Criteria andGroupInpriceIsNull() {
            addCriterion("group_inprice is null");
            return (Criteria) this;
        }

        public Criteria andGroupInpriceIsNotNull() {
            addCriterion("group_inprice is not null");
            return (Criteria) this;
        }

        public Criteria andGroupInpriceEqualTo(Integer value) {
            addCriterion("group_inprice =", value, "groupInprice");
            return (Criteria) this;
        }

        public Criteria andGroupInpriceNotEqualTo(Integer value) {
            addCriterion("group_inprice <>", value, "groupInprice");
            return (Criteria) this;
        }

        public Criteria andGroupInpriceGreaterThan(Integer value) {
            addCriterion("group_inprice >", value, "groupInprice");
            return (Criteria) this;
        }

        public Criteria andGroupInpriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_inprice >=", value, "groupInprice");
            return (Criteria) this;
        }

        public Criteria andGroupInpriceLessThan(Integer value) {
            addCriterion("group_inprice <", value, "groupInprice");
            return (Criteria) this;
        }

        public Criteria andGroupInpriceLessThanOrEqualTo(Integer value) {
            addCriterion("group_inprice <=", value, "groupInprice");
            return (Criteria) this;
        }

        public Criteria andGroupInpriceIn(List<Integer> values) {
            addCriterion("group_inprice in", values, "groupInprice");
            return (Criteria) this;
        }

        public Criteria andGroupInpriceNotIn(List<Integer> values) {
            addCriterion("group_inprice not in", values, "groupInprice");
            return (Criteria) this;
        }

        public Criteria andGroupInpriceBetween(Integer value1, Integer value2) {
            addCriterion("group_inprice between", value1, value2, "groupInprice");
            return (Criteria) this;
        }

        public Criteria andGroupInpriceNotBetween(Integer value1, Integer value2) {
            addCriterion("group_inprice not between", value1, value2, "groupInprice");
            return (Criteria) this;
        }

        public Criteria andGroupOutpriceIsNull() {
            addCriterion("group_outprice is null");
            return (Criteria) this;
        }

        public Criteria andGroupOutpriceIsNotNull() {
            addCriterion("group_outprice is not null");
            return (Criteria) this;
        }

        public Criteria andGroupOutpriceEqualTo(Integer value) {
            addCriterion("group_outprice =", value, "groupOutprice");
            return (Criteria) this;
        }

        public Criteria andGroupOutpriceNotEqualTo(Integer value) {
            addCriterion("group_outprice <>", value, "groupOutprice");
            return (Criteria) this;
        }

        public Criteria andGroupOutpriceGreaterThan(Integer value) {
            addCriterion("group_outprice >", value, "groupOutprice");
            return (Criteria) this;
        }

        public Criteria andGroupOutpriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_outprice >=", value, "groupOutprice");
            return (Criteria) this;
        }

        public Criteria andGroupOutpriceLessThan(Integer value) {
            addCriterion("group_outprice <", value, "groupOutprice");
            return (Criteria) this;
        }

        public Criteria andGroupOutpriceLessThanOrEqualTo(Integer value) {
            addCriterion("group_outprice <=", value, "groupOutprice");
            return (Criteria) this;
        }

        public Criteria andGroupOutpriceIn(List<Integer> values) {
            addCriterion("group_outprice in", values, "groupOutprice");
            return (Criteria) this;
        }

        public Criteria andGroupOutpriceNotIn(List<Integer> values) {
            addCriterion("group_outprice not in", values, "groupOutprice");
            return (Criteria) this;
        }

        public Criteria andGroupOutpriceBetween(Integer value1, Integer value2) {
            addCriterion("group_outprice between", value1, value2, "groupOutprice");
            return (Criteria) this;
        }

        public Criteria andGroupOutpriceNotBetween(Integer value1, Integer value2) {
            addCriterion("group_outprice not between", value1, value2, "groupOutprice");
            return (Criteria) this;
        }

        public Criteria andGroupStateIsNull() {
            addCriterion("group_state is null");
            return (Criteria) this;
        }

        public Criteria andGroupStateIsNotNull() {
            addCriterion("group_state is not null");
            return (Criteria) this;
        }

        public Criteria andGroupStateEqualTo(Integer value) {
            addCriterion("group_state =", value, "groupState");
            return (Criteria) this;
        }

        public Criteria andGroupStateNotEqualTo(Integer value) {
            addCriterion("group_state <>", value, "groupState");
            return (Criteria) this;
        }

        public Criteria andGroupStateGreaterThan(Integer value) {
            addCriterion("group_state >", value, "groupState");
            return (Criteria) this;
        }

        public Criteria andGroupStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_state >=", value, "groupState");
            return (Criteria) this;
        }

        public Criteria andGroupStateLessThan(Integer value) {
            addCriterion("group_state <", value, "groupState");
            return (Criteria) this;
        }

        public Criteria andGroupStateLessThanOrEqualTo(Integer value) {
            addCriterion("group_state <=", value, "groupState");
            return (Criteria) this;
        }

        public Criteria andGroupStateIn(List<Integer> values) {
            addCriterion("group_state in", values, "groupState");
            return (Criteria) this;
        }

        public Criteria andGroupStateNotIn(List<Integer> values) {
            addCriterion("group_state not in", values, "groupState");
            return (Criteria) this;
        }

        public Criteria andGroupStateBetween(Integer value1, Integer value2) {
            addCriterion("group_state between", value1, value2, "groupState");
            return (Criteria) this;
        }

        public Criteria andGroupStateNotBetween(Integer value1, Integer value2) {
            addCriterion("group_state not between", value1, value2, "groupState");
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