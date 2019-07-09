package com.atguigu.bean;

public class AppuserInfo {
	
	/**
	 *用户IDappuser_id	INT(16) NOT NULL
	 *用户IPappuser_ip	VARCHAR(64)
	 *用户手机号appuser_mobile	VARCHAR(64)
	 *用户昵称appuser_name	VARCHAR(64) NOT NULL
	 *用户设备唯一标示appuser_udid		VARCHAR(128)
	 *用户设备机型appuser_idfa		VARCHAR(128) NOT NULL
	 *激活时间appuser_createtime		VARCHAR(128) NOT NULL
	 *最后登陆时间appuser_lasttime	VARCHAR(128) NOT NULL
	 *备用字段1appuser_spareone		INT(16)
	 *备用字段2appuser_sparetwo		INT(16)
	 *备用字段3appuser_sparethree		VARCHAR(128)
	 *备用字段4appuser_sparefour		VARCHAR(128)
	 * */
    private Integer appuserId;			//用户ID

    private String appuserIp;			//用户IPappuser_ip	VARCHAR(64)

    private String appuserMobile;		//用户手机号appuser_mobile	VARCHAR(64)

    private String appuserName;			//用户昵称appuser_name	VARCHAR(64) NOT NULL

    private String appuserUdid;			//用户设备唯一标示appuser_udid		VARCHAR(128)

    private String appuserIdfa;			//用户设备机型appuser_idfa		VARCHAR(128) NOT NULL

    private String appuserCreatetime;	//激活时间appuser_createtime		VARCHAR(128) NOT NULL

    private String appuserLasttime;		//最后登陆时间appuser_lasttime	VARCHAR(128) NOT NULL

    private Integer appuserSpareone;

    private Integer appuserSparetwo;

    private String appuserSparethree;

    private String appuserSparefour;

    public Integer getAppuserId() {
        return appuserId;
    }

    public void setAppuserId(Integer appuserId) {
        this.appuserId = appuserId;
    }

    public String getAppuserIp() {
        return appuserIp;
    }

    public void setAppuserIp(String appuserIp) {
        this.appuserIp = appuserIp == null ? null : appuserIp.trim();
    }

    public String getAppuserMobile() {
        return appuserMobile;
    }

    public void setAppuserMobile(String appuserMobile) {
        this.appuserMobile = appuserMobile == null ? null : appuserMobile.trim();
    }

    public String getAppuserName() {
        return appuserName;
    }

    public void setAppuserName(String appuserName) {
        this.appuserName = appuserName == null ? null : appuserName.trim();
    }

    public String getAppuserUdid() {
        return appuserUdid;
    }

    public void setAppuserUdid(String appuserUdid) {
        this.appuserUdid = appuserUdid == null ? null : appuserUdid.trim();
    }

    public String getAppuserIdfa() {
        return appuserIdfa;
    }

    public void setAppuserIdfa(String appuserIdfa) {
        this.appuserIdfa = appuserIdfa == null ? null : appuserIdfa.trim();
    }

    public String getAppuserCreatetime() {
        return appuserCreatetime;
    }

    public void setAppuserCreatetime(String appuserCreatetime) {
        this.appuserCreatetime = appuserCreatetime == null ? null : appuserCreatetime.trim();
    }

    public String getAppuserLasttime() {
        return appuserLasttime;
    }

    public void setAppuserLasttime(String appuserLasttime) {
        this.appuserLasttime = appuserLasttime == null ? null : appuserLasttime.trim();
    }

    public Integer getAppuserSpareone() {
        return appuserSpareone;
    }

    public void setAppuserSpareone(Integer appuserSpareone) {
        this.appuserSpareone = appuserSpareone;
    }

    public Integer getAppuserSparetwo() {
        return appuserSparetwo;
    }

    public void setAppuserSparetwo(Integer appuserSparetwo) {
        this.appuserSparetwo = appuserSparetwo;
    }

    public String getAppuserSparethree() {
        return appuserSparethree;
    }

    public void setAppuserSparethree(String appuserSparethree) {
        this.appuserSparethree = appuserSparethree == null ? null : appuserSparethree.trim();
    }

    public String getAppuserSparefour() {
        return appuserSparefour;
    }

    public void setAppuserSparefour(String appuserSparefour) {
        this.appuserSparefour = appuserSparefour == null ? null : appuserSparefour.trim();
    }
}