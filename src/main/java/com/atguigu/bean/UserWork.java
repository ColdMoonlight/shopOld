package com.atguigu.bean;

public class UserWork {
    private Integer userworkId;

    private Integer userworkGroupdisplayId;

    private String userworkUdid;

    private String userworkIdfa;

    private String userworkCreatetime;

    private String userworkUploadtime;

    private String userworkState;

    private String userworkPrice;

    private Integer userworkSpareone;

    private Integer userworkSparetwo;

    private String userworkStarttime;//开始试玩时间

    private String userworkReceivetime;//领取奖励时间

    public Integer getUserworkId() {
        return userworkId;
    }

    public void setUserworkId(Integer userworkId) {
        this.userworkId = userworkId;
    }

    public Integer getUserworkGroupdisplayId() {
        return userworkGroupdisplayId;
    }

    public void setUserworkGroupdisplayId(Integer userworkGroupdisplayId) {
        this.userworkGroupdisplayId = userworkGroupdisplayId;
    }

    public String getUserworkUdid() {
        return userworkUdid;
    }

    public void setUserworkUdid(String userworkUdid) {
        this.userworkUdid = userworkUdid == null ? null : userworkUdid.trim();
    }

    public String getUserworkIdfa() {
        return userworkIdfa;
    }

    public void setUserworkIdfa(String userworkIdfa) {
        this.userworkIdfa = userworkIdfa == null ? null : userworkIdfa.trim();
    }

    public String getUserworkCreatetime() {
        return userworkCreatetime;
    }

    public void setUserworkCreatetime(String userworkCreatetime) {
        this.userworkCreatetime = userworkCreatetime == null ? null : userworkCreatetime.trim();
    }

    public String getUserworkUploadtime() {
        return userworkUploadtime;
    }

    public void setUserworkUploadtime(String userworkUploadtime) {
        this.userworkUploadtime = userworkUploadtime == null ? null : userworkUploadtime.trim();
    }

    public String getUserworkState() {
        return userworkState;
    }

    public void setUserworkState(String userworkState) {
        this.userworkState = userworkState == null ? null : userworkState.trim();
    }

    public String getUserworkPrice() {
        return userworkPrice;
    }

    public void setUserworkPrice(String userworkPrice) {
        this.userworkPrice = userworkPrice == null ? null : userworkPrice.trim();
    }

    public Integer getUserworkSpareone() {
        return userworkSpareone;
    }

    public void setUserworkSpareone(Integer userworkSpareone) {
        this.userworkSpareone = userworkSpareone;
    }

    public Integer getUserworkSparetwo() {
        return userworkSparetwo;
    }

    public void setUserworkSparetwo(Integer userworkSparetwo) {
        this.userworkSparetwo = userworkSparetwo;
    }

    public String getUserworkStarttime() {
        return userworkStarttime;
    }

    public void setUserworkStarttime(String userworkStarttime) {
        this.userworkStarttime = userworkStarttime == null ? null : userworkStarttime.trim();
    }

    public String getUserworkReceivetime() {
        return userworkReceivetime;
    }

    public void setUserworkReceivetime(String userworkReceivetime) {
        this.userworkReceivetime = userworkReceivetime == null ? null : userworkReceivetime.trim();
    }
}