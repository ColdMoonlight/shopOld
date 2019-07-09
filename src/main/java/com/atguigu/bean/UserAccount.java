package com.atguigu.bean;

public class UserAccount {
    private Integer userAccountid;

    private String userAccountUserid;

    private String userAccountUsername;

    private String userAccNowmoney;

    private String userAccAllmoney;

    private String userAccTodayin;

    private String userAccAllout;

    private String userAccIfalipay;

    private String userAlipayname;

    private String userAlipaypeople;

    private Integer userAccOutTimes;

    private Integer userAccOutTodayIf;

    private String userAccOuting;

    private String userAccSparefour;

    public Integer getUserAccountid() {
        return userAccountid;
    }

    public void setUserAccountid(Integer userAccountid) {
        this.userAccountid = userAccountid;
    }

    public String getUserAccountUserid() {
        return userAccountUserid;
    }

    public void setUserAccountUserid(String userAccountUserid) {
        this.userAccountUserid = userAccountUserid == null ? null : userAccountUserid.trim();
    }

    public String getUserAccountUsername() {
        return userAccountUsername;
    }

    public void setUserAccountUsername(String userAccountUsername) {
        this.userAccountUsername = userAccountUsername == null ? null : userAccountUsername.trim();
    }

    public String getUserAccNowmoney() {
        return userAccNowmoney;
    }

    public void setUserAccNowmoney(String userAccNowmoney) {
        this.userAccNowmoney = userAccNowmoney == null ? null : userAccNowmoney.trim();
    }

    public String getUserAccAllmoney() {
        return userAccAllmoney;
    }

    public void setUserAccAllmoney(String userAccAllmoney) {
        this.userAccAllmoney = userAccAllmoney == null ? null : userAccAllmoney.trim();
    }

    public String getUserAccTodayin() {
        return userAccTodayin;
    }

    public void setUserAccTodayin(String userAccTodayin) {
        this.userAccTodayin = userAccTodayin == null ? null : userAccTodayin.trim();
    }

    public String getUserAccAllout() {
        return userAccAllout;
    }

    public void setUserAccAllout(String userAccAllout) {
        this.userAccAllout = userAccAllout == null ? null : userAccAllout.trim();
    }

    public String getUserAccIfalipay() {
        return userAccIfalipay;
    }

    public void setUserAccIfalipay(String userAccIfalipay) {
        this.userAccIfalipay = userAccIfalipay == null ? null : userAccIfalipay.trim();
    }

    public String getUserAlipayname() {
        return userAlipayname;
    }

    public void setUserAlipayname(String userAlipayname) {
        this.userAlipayname = userAlipayname == null ? null : userAlipayname.trim();
    }

    public String getUserAlipaypeople() {
        return userAlipaypeople;
    }

    public void setUserAlipaypeople(String userAlipaypeople) {
        this.userAlipaypeople = userAlipaypeople == null ? null : userAlipaypeople.trim();
    }

    public Integer getUserAccOutTimes() {
        return userAccOutTimes;
    }

    public void setUserAccOutTimes(Integer userAccOutTimes) {
        this.userAccOutTimes = userAccOutTimes;
    }

    public Integer getUserAccOutTodayIf() {
        return userAccOutTodayIf;
    }

    public void setUserAccOutTodayIf(Integer userAccOutTodayIf) {
        this.userAccOutTodayIf = userAccOutTodayIf;
    }

    public String getUserAccOuting() {
        return userAccOuting;
    }

    public void setUserAccOuting(String userAccOuting) {
        this.userAccOuting = userAccOuting == null ? null : userAccOuting.trim();
    }

	public String getUserAccSparefour() {
        return userAccSparefour;
    }

    public void setUserAccSparefour(String userAccSparefour) {
        this.userAccSparefour = userAccSparefour == null ? null : userAccSparefour.trim();
    }
}