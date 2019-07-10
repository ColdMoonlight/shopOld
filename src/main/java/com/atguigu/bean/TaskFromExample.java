package com.atguigu.bean;

import java.util.ArrayList;
import java.util.List;

public class TaskFromExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskFromExample() {
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

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Integer value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Integer value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Integer value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Integer value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Integer> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Integer> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskSourceIsNull() {
            addCriterion("task_source is null");
            return (Criteria) this;
        }

        public Criteria andTaskSourceIsNotNull() {
            addCriterion("task_source is not null");
            return (Criteria) this;
        }

        public Criteria andTaskSourceEqualTo(String value) {
            addCriterion("task_source =", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceNotEqualTo(String value) {
            addCriterion("task_source <>", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceGreaterThan(String value) {
            addCriterion("task_source >", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceGreaterThanOrEqualTo(String value) {
            addCriterion("task_source >=", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceLessThan(String value) {
            addCriterion("task_source <", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceLessThanOrEqualTo(String value) {
            addCriterion("task_source <=", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceLike(String value) {
            addCriterion("task_source like", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceNotLike(String value) {
            addCriterion("task_source not like", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceIn(List<String> values) {
            addCriterion("task_source in", values, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceNotIn(List<String> values) {
            addCriterion("task_source not in", values, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceBetween(String value1, String value2) {
            addCriterion("task_source between", value1, value2, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceNotBetween(String value1, String value2) {
            addCriterion("task_source not between", value1, value2, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNull() {
            addCriterion("task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskAdIdIsNull() {
            addCriterion("task_ad_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskAdIdIsNotNull() {
            addCriterion("task_ad_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskAdIdEqualTo(String value) {
            addCriterion("task_ad_id =", value, "taskAdId");
            return (Criteria) this;
        }

        public Criteria andTaskAdIdNotEqualTo(String value) {
            addCriterion("task_ad_id <>", value, "taskAdId");
            return (Criteria) this;
        }

        public Criteria andTaskAdIdGreaterThan(String value) {
            addCriterion("task_ad_id >", value, "taskAdId");
            return (Criteria) this;
        }

        public Criteria andTaskAdIdGreaterThanOrEqualTo(String value) {
            addCriterion("task_ad_id >=", value, "taskAdId");
            return (Criteria) this;
        }

        public Criteria andTaskAdIdLessThan(String value) {
            addCriterion("task_ad_id <", value, "taskAdId");
            return (Criteria) this;
        }

        public Criteria andTaskAdIdLessThanOrEqualTo(String value) {
            addCriterion("task_ad_id <=", value, "taskAdId");
            return (Criteria) this;
        }

        public Criteria andTaskAdIdLike(String value) {
            addCriterion("task_ad_id like", value, "taskAdId");
            return (Criteria) this;
        }

        public Criteria andTaskAdIdNotLike(String value) {
            addCriterion("task_ad_id not like", value, "taskAdId");
            return (Criteria) this;
        }

        public Criteria andTaskAdIdIn(List<String> values) {
            addCriterion("task_ad_id in", values, "taskAdId");
            return (Criteria) this;
        }

        public Criteria andTaskAdIdNotIn(List<String> values) {
            addCriterion("task_ad_id not in", values, "taskAdId");
            return (Criteria) this;
        }

        public Criteria andTaskAdIdBetween(String value1, String value2) {
            addCriterion("task_ad_id between", value1, value2, "taskAdId");
            return (Criteria) this;
        }

        public Criteria andTaskAdIdNotBetween(String value1, String value2) {
            addCriterion("task_ad_id not between", value1, value2, "taskAdId");
            return (Criteria) this;
        }

        public Criteria andTaskCreatimeIsNull() {
            addCriterion("task_creatime is null");
            return (Criteria) this;
        }

        public Criteria andTaskCreatimeIsNotNull() {
            addCriterion("task_creatime is not null");
            return (Criteria) this;
        }

        public Criteria andTaskCreatimeEqualTo(String value) {
            addCriterion("task_creatime =", value, "taskCreatime");
            return (Criteria) this;
        }

        public Criteria andTaskCreatimeNotEqualTo(String value) {
            addCriterion("task_creatime <>", value, "taskCreatime");
            return (Criteria) this;
        }

        public Criteria andTaskCreatimeGreaterThan(String value) {
            addCriterion("task_creatime >", value, "taskCreatime");
            return (Criteria) this;
        }

        public Criteria andTaskCreatimeGreaterThanOrEqualTo(String value) {
            addCriterion("task_creatime >=", value, "taskCreatime");
            return (Criteria) this;
        }

        public Criteria andTaskCreatimeLessThan(String value) {
            addCriterion("task_creatime <", value, "taskCreatime");
            return (Criteria) this;
        }

        public Criteria andTaskCreatimeLessThanOrEqualTo(String value) {
            addCriterion("task_creatime <=", value, "taskCreatime");
            return (Criteria) this;
        }

        public Criteria andTaskCreatimeLike(String value) {
            addCriterion("task_creatime like", value, "taskCreatime");
            return (Criteria) this;
        }

        public Criteria andTaskCreatimeNotLike(String value) {
            addCriterion("task_creatime not like", value, "taskCreatime");
            return (Criteria) this;
        }

        public Criteria andTaskCreatimeIn(List<String> values) {
            addCriterion("task_creatime in", values, "taskCreatime");
            return (Criteria) this;
        }

        public Criteria andTaskCreatimeNotIn(List<String> values) {
            addCriterion("task_creatime not in", values, "taskCreatime");
            return (Criteria) this;
        }

        public Criteria andTaskCreatimeBetween(String value1, String value2) {
            addCriterion("task_creatime between", value1, value2, "taskCreatime");
            return (Criteria) this;
        }

        public Criteria andTaskCreatimeNotBetween(String value1, String value2) {
            addCriterion("task_creatime not between", value1, value2, "taskCreatime");
            return (Criteria) this;
        }

        public Criteria andTaskUpdatetimeIsNull() {
            addCriterion("task_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andTaskUpdatetimeIsNotNull() {
            addCriterion("task_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andTaskUpdatetimeEqualTo(String value) {
            addCriterion("task_updatetime =", value, "taskUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTaskUpdatetimeNotEqualTo(String value) {
            addCriterion("task_updatetime <>", value, "taskUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTaskUpdatetimeGreaterThan(String value) {
            addCriterion("task_updatetime >", value, "taskUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTaskUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("task_updatetime >=", value, "taskUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTaskUpdatetimeLessThan(String value) {
            addCriterion("task_updatetime <", value, "taskUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTaskUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("task_updatetime <=", value, "taskUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTaskUpdatetimeLike(String value) {
            addCriterion("task_updatetime like", value, "taskUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTaskUpdatetimeNotLike(String value) {
            addCriterion("task_updatetime not like", value, "taskUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTaskUpdatetimeIn(List<String> values) {
            addCriterion("task_updatetime in", values, "taskUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTaskUpdatetimeNotIn(List<String> values) {
            addCriterion("task_updatetime not in", values, "taskUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTaskUpdatetimeBetween(String value1, String value2) {
            addCriterion("task_updatetime between", value1, value2, "taskUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTaskUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("task_updatetime not between", value1, value2, "taskUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTaskIfonlyIsNull() {
            addCriterion("task_ifonly is null");
            return (Criteria) this;
        }

        public Criteria andTaskIfonlyIsNotNull() {
            addCriterion("task_ifonly is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIfonlyEqualTo(Integer value) {
            addCriterion("task_ifonly =", value, "taskIfonly");
            return (Criteria) this;
        }

        public Criteria andTaskIfonlyNotEqualTo(Integer value) {
            addCriterion("task_ifonly <>", value, "taskIfonly");
            return (Criteria) this;
        }

        public Criteria andTaskIfonlyGreaterThan(Integer value) {
            addCriterion("task_ifonly >", value, "taskIfonly");
            return (Criteria) this;
        }

        public Criteria andTaskIfonlyGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_ifonly >=", value, "taskIfonly");
            return (Criteria) this;
        }

        public Criteria andTaskIfonlyLessThan(Integer value) {
            addCriterion("task_ifonly <", value, "taskIfonly");
            return (Criteria) this;
        }

        public Criteria andTaskIfonlyLessThanOrEqualTo(Integer value) {
            addCriterion("task_ifonly <=", value, "taskIfonly");
            return (Criteria) this;
        }

        public Criteria andTaskIfonlyIn(List<Integer> values) {
            addCriterion("task_ifonly in", values, "taskIfonly");
            return (Criteria) this;
        }

        public Criteria andTaskIfonlyNotIn(List<Integer> values) {
            addCriterion("task_ifonly not in", values, "taskIfonly");
            return (Criteria) this;
        }

        public Criteria andTaskIfonlyBetween(Integer value1, Integer value2) {
            addCriterion("task_ifonly between", value1, value2, "taskIfonly");
            return (Criteria) this;
        }

        public Criteria andTaskIfonlyNotBetween(Integer value1, Integer value2) {
            addCriterion("task_ifonly not between", value1, value2, "taskIfonly");
            return (Criteria) this;
        }

        public Criteria andTaskIfclickIsNull() {
            addCriterion("task_ifclick is null");
            return (Criteria) this;
        }

        public Criteria andTaskIfclickIsNotNull() {
            addCriterion("task_ifclick is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIfclickEqualTo(Integer value) {
            addCriterion("task_ifclick =", value, "taskIfclick");
            return (Criteria) this;
        }

        public Criteria andTaskIfclickNotEqualTo(Integer value) {
            addCriterion("task_ifclick <>", value, "taskIfclick");
            return (Criteria) this;
        }

        public Criteria andTaskIfclickGreaterThan(Integer value) {
            addCriterion("task_ifclick >", value, "taskIfclick");
            return (Criteria) this;
        }

        public Criteria andTaskIfclickGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_ifclick >=", value, "taskIfclick");
            return (Criteria) this;
        }

        public Criteria andTaskIfclickLessThan(Integer value) {
            addCriterion("task_ifclick <", value, "taskIfclick");
            return (Criteria) this;
        }

        public Criteria andTaskIfclickLessThanOrEqualTo(Integer value) {
            addCriterion("task_ifclick <=", value, "taskIfclick");
            return (Criteria) this;
        }

        public Criteria andTaskIfclickIn(List<Integer> values) {
            addCriterion("task_ifclick in", values, "taskIfclick");
            return (Criteria) this;
        }

        public Criteria andTaskIfclickNotIn(List<Integer> values) {
            addCriterion("task_ifclick not in", values, "taskIfclick");
            return (Criteria) this;
        }

        public Criteria andTaskIfclickBetween(Integer value1, Integer value2) {
            addCriterion("task_ifclick between", value1, value2, "taskIfclick");
            return (Criteria) this;
        }

        public Criteria andTaskIfclickNotBetween(Integer value1, Integer value2) {
            addCriterion("task_ifclick not between", value1, value2, "taskIfclick");
            return (Criteria) this;
        }

        public Criteria andTaskIfreportIsNull() {
            addCriterion("task_ifreport is null");
            return (Criteria) this;
        }

        public Criteria andTaskIfreportIsNotNull() {
            addCriterion("task_ifreport is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIfreportEqualTo(Integer value) {
            addCriterion("task_ifreport =", value, "taskIfreport");
            return (Criteria) this;
        }

        public Criteria andTaskIfreportNotEqualTo(Integer value) {
            addCriterion("task_ifreport <>", value, "taskIfreport");
            return (Criteria) this;
        }

        public Criteria andTaskIfreportGreaterThan(Integer value) {
            addCriterion("task_ifreport >", value, "taskIfreport");
            return (Criteria) this;
        }

        public Criteria andTaskIfreportGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_ifreport >=", value, "taskIfreport");
            return (Criteria) this;
        }

        public Criteria andTaskIfreportLessThan(Integer value) {
            addCriterion("task_ifreport <", value, "taskIfreport");
            return (Criteria) this;
        }

        public Criteria andTaskIfreportLessThanOrEqualTo(Integer value) {
            addCriterion("task_ifreport <=", value, "taskIfreport");
            return (Criteria) this;
        }

        public Criteria andTaskIfreportIn(List<Integer> values) {
            addCriterion("task_ifreport in", values, "taskIfreport");
            return (Criteria) this;
        }

        public Criteria andTaskIfreportNotIn(List<Integer> values) {
            addCriterion("task_ifreport not in", values, "taskIfreport");
            return (Criteria) this;
        }

        public Criteria andTaskIfreportBetween(Integer value1, Integer value2) {
            addCriterion("task_ifreport between", value1, value2, "taskIfreport");
            return (Criteria) this;
        }

        public Criteria andTaskIfreportNotBetween(Integer value1, Integer value2) {
            addCriterion("task_ifreport not between", value1, value2, "taskIfreport");
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