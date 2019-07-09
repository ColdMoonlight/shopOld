package com.atguigu.bean;

public class MlfrontReview {
    private Integer reviewId;

    private Integer reviewUid;

    private String reviewUname;

    private Integer reviewPid;

    private String reviewPname;

    private String reviewDetail;

    private Integer reviewStatus;

    private String reviewImgidstr;

    private Integer reviewProstarnum;

    private Integer reviewServicestarnum;

    private Integer reviewLogisticsstarnum;

    private String reviewCreatetime;

    private String reviewMotifytime;

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getReviewUid() {
        return reviewUid;
    }

    public void setReviewUid(Integer reviewUid) {
        this.reviewUid = reviewUid;
    }

    public String getReviewUname() {
        return reviewUname;
    }

    public void setReviewUname(String reviewUname) {
        this.reviewUname = reviewUname == null ? null : reviewUname.trim();
    }

    public Integer getReviewPid() {
        return reviewPid;
    }

    public void setReviewPid(Integer reviewPid) {
        this.reviewPid = reviewPid;
    }

    public String getReviewPname() {
        return reviewPname;
    }

    public void setReviewPname(String reviewPname) {
        this.reviewPname = reviewPname == null ? null : reviewPname.trim();
    }

    public String getReviewDetail() {
        return reviewDetail;
    }

    public void setReviewDetail(String reviewDetail) {
        this.reviewDetail = reviewDetail == null ? null : reviewDetail.trim();
    }

    public Integer getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(Integer reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public String getReviewImgidstr() {
        return reviewImgidstr;
    }

    public void setReviewImgidstr(String reviewImgidstr) {
        this.reviewImgidstr = reviewImgidstr == null ? null : reviewImgidstr.trim();
    }

    public Integer getReviewProstarnum() {
        return reviewProstarnum;
    }

    public void setReviewProstarnum(Integer reviewProstarnum) {
        this.reviewProstarnum = reviewProstarnum;
    }

    public Integer getReviewServicestarnum() {
        return reviewServicestarnum;
    }

    public void setReviewServicestarnum(Integer reviewServicestarnum) {
        this.reviewServicestarnum = reviewServicestarnum;
    }

    public Integer getReviewLogisticsstarnum() {
        return reviewLogisticsstarnum;
    }

    public void setReviewLogisticsstarnum(Integer reviewLogisticsstarnum) {
        this.reviewLogisticsstarnum = reviewLogisticsstarnum;
    }

    public String getReviewCreatetime() {
        return reviewCreatetime;
    }

    public void setReviewCreatetime(String reviewCreatetime) {
        this.reviewCreatetime = reviewCreatetime == null ? null : reviewCreatetime.trim();
    }

    public String getReviewMotifytime() {
        return reviewMotifytime;
    }

    public void setReviewMotifytime(String reviewMotifytime) {
        this.reviewMotifytime = reviewMotifytime == null ? null : reviewMotifytime.trim();
    }
}