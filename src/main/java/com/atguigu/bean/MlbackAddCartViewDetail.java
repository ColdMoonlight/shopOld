package com.atguigu.bean;

public class MlbackAddCartViewDetail {
    private Integer addcartviewdetailId;

    private String addcartviewdetailSessionid;

    private String addcartviewdetailName;

    private Integer addcartviewdetailProid;

    private String addcartviewdetailProname;

    private String addcartviewdetailSeoname;
    
    private Integer addcartviewdetailActNum;		//用户行为，0纯加购	1点buyNow附带的加购

    private String addcartviewdetailCreatetime;

    private String addcartviewdetailMotifytime;

    private String addcartviewdetailStarttime;

    private String addcartviewdetailEndtime;

    public Integer getAddcartviewdetailId() {
        return addcartviewdetailId;
    }

    public void setAddcartviewdetailId(Integer addcartviewdetailId) {
        this.addcartviewdetailId = addcartviewdetailId;
    }

    public String getAddcartviewdetailSessionid() {
        return addcartviewdetailSessionid;
    }

    public void setAddcartviewdetailSessionid(String addcartviewdetailSessionid) {
        this.addcartviewdetailSessionid = addcartviewdetailSessionid == null ? null : addcartviewdetailSessionid.trim();
    }

    public String getAddcartviewdetailName() {
        return addcartviewdetailName;
    }

    public void setAddcartviewdetailName(String addcartviewdetailName) {
        this.addcartviewdetailName = addcartviewdetailName == null ? null : addcartviewdetailName.trim();
    }

    public Integer getAddcartviewdetailProid() {
        return addcartviewdetailProid;
    }

    public void setAddcartviewdetailProid(Integer addcartviewdetailProid) {
        this.addcartviewdetailProid = addcartviewdetailProid;
    }

    public String getAddcartviewdetailProname() {
        return addcartviewdetailProname;
    }

    public void setAddcartviewdetailProname(String addcartviewdetailProname) {
        this.addcartviewdetailProname = addcartviewdetailProname == null ? null : addcartviewdetailProname.trim();
    }

    public String getAddcartviewdetailSeoname() {
        return addcartviewdetailSeoname;
    }

    public void setAddcartviewdetailSeoname(String addcartviewdetailSeoname) {
        this.addcartviewdetailSeoname = addcartviewdetailSeoname == null ? null : addcartviewdetailSeoname.trim();
    }
    
	public Integer getAddcartviewdetailActNum() {
		return addcartviewdetailActNum;
	}

	public void setAddcartviewdetailActNum(Integer addcartviewdetailActNum) {
		this.addcartviewdetailActNum = addcartviewdetailActNum;
	}

	public String getAddcartviewdetailCreatetime() {
        return addcartviewdetailCreatetime;
    }

    public void setAddcartviewdetailCreatetime(String addcartviewdetailCreatetime) {
        this.addcartviewdetailCreatetime = addcartviewdetailCreatetime == null ? null : addcartviewdetailCreatetime.trim();
    }

    public String getAddcartviewdetailMotifytime() {
        return addcartviewdetailMotifytime;
    }

    public void setAddcartviewdetailMotifytime(String addcartviewdetailMotifytime) {
        this.addcartviewdetailMotifytime = addcartviewdetailMotifytime == null ? null : addcartviewdetailMotifytime.trim();
    }

    public String getAddcartviewdetailStarttime() {
        return addcartviewdetailStarttime;
    }

    public void setAddcartviewdetailStarttime(String addcartviewdetailStarttime) {
        this.addcartviewdetailStarttime = addcartviewdetailStarttime == null ? null : addcartviewdetailStarttime.trim();
    }

    public String getAddcartviewdetailEndtime() {
        return addcartviewdetailEndtime;
    }

    public void setAddcartviewdetailEndtime(String addcartviewdetailEndtime) {
        this.addcartviewdetailEndtime = addcartviewdetailEndtime == null ? null : addcartviewdetailEndtime.trim();
    }

	public MlbackAddCartViewDetail(Integer addcartviewdetailId, String addcartviewdetailSessionid,
			String addcartviewdetailName, Integer addcartviewdetailProid, String addcartviewdetailProname,
			String addcartviewdetailSeoname, Integer addcartviewdetailActNum, String addcartviewdetailCreatetime,
			String addcartviewdetailMotifytime, String addcartviewdetailStarttime, String addcartviewdetailEndtime) {
		super();
		this.addcartviewdetailId = addcartviewdetailId;
		this.addcartviewdetailSessionid = addcartviewdetailSessionid;
		this.addcartviewdetailName = addcartviewdetailName;
		this.addcartviewdetailProid = addcartviewdetailProid;
		this.addcartviewdetailProname = addcartviewdetailProname;
		this.addcartviewdetailSeoname = addcartviewdetailSeoname;
		this.addcartviewdetailActNum = addcartviewdetailActNum;
		this.addcartviewdetailCreatetime = addcartviewdetailCreatetime;
		this.addcartviewdetailMotifytime = addcartviewdetailMotifytime;
		this.addcartviewdetailStarttime = addcartviewdetailStarttime;
		this.addcartviewdetailEndtime = addcartviewdetailEndtime;
	}

	public MlbackAddCartViewDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MlbackAddCartViewDetail [addcartviewdetailId=" + addcartviewdetailId + ", addcartviewdetailSessionid="
				+ addcartviewdetailSessionid + ", addcartviewdetailName=" + addcartviewdetailName
				+ ", addcartviewdetailProid=" + addcartviewdetailProid + ", addcartviewdetailProname="
				+ addcartviewdetailProname + ", addcartviewdetailSeoname=" + addcartviewdetailSeoname
				+ ", addcartviewdetailActNum=" + addcartviewdetailActNum + ", addcartviewdetailCreatetime="
				+ addcartviewdetailCreatetime + ", addcartviewdetailMotifytime=" + addcartviewdetailMotifytime
				+ ", addcartviewdetailStarttime=" + addcartviewdetailStarttime + ", addcartviewdetailEndtime="
				+ addcartviewdetailEndtime + "]";
	}
    
}