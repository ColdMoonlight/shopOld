package com.atguigu.bean;

public class TaskFrom {
    private Integer taskId;

    private String taskSource;

    private String taskName;
    
    private String taskAppstoreId;

    private String taskAdId;

    private String taskCreatime;

    private String taskUpdatetime;

    private Integer taskIfonly;

    private Integer taskIfclick;

    private Integer taskIfreport;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskSource() {
        return taskSource;
    }

    public void setTaskSource(String taskSource) {
        this.taskSource = taskSource == null ? null : taskSource.trim();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    
    public String getTaskAppstoreId() {
		return taskAppstoreId;
	}

	public void setTaskAppstoreId(String taskAppstoreId) {
		this.taskAppstoreId = taskAppstoreId == null ? null : taskAppstoreId.trim();
	}

	public String getTaskAdId() {
        return taskAdId;
    }

    public void setTaskAdId(String taskAdId) {
        this.taskAdId = taskAdId == null ? null : taskAdId.trim();
    }

    public String getTaskCreatime() {
        return taskCreatime;
    }

    public void setTaskCreatime(String taskCreatime) {
        this.taskCreatime = taskCreatime == null ? null : taskCreatime.trim();
    }

    public String getTaskUpdatetime() {
        return taskUpdatetime;
    }

    public void setTaskUpdatetime(String taskUpdatetime) {
        this.taskUpdatetime = taskUpdatetime == null ? null : taskUpdatetime.trim();
    }

    public Integer getTaskIfonly() {
        return taskIfonly;
    }

    public void setTaskIfonly(Integer taskIfonly) {
        this.taskIfonly = taskIfonly;
    }

    public Integer getTaskIfclick() {
        return taskIfclick;
    }

    public void setTaskIfclick(Integer taskIfclick) {
        this.taskIfclick = taskIfclick;
    }

    public Integer getTaskIfreport() {
        return taskIfreport;
    }

    public void setTaskIfreport(Integer taskIfreport) {
        this.taskIfreport = taskIfreport;
    }


	public TaskFrom(Integer taskId, String taskSource, String taskName, String taskAppstoreId, String taskAdId,
			String taskCreatime, String taskUpdatetime, Integer taskIfonly, Integer taskIfclick, Integer taskIfreport) {
		super();
		this.taskId = taskId;
		this.taskSource = taskSource;
		this.taskName = taskName;
		this.taskAppstoreId = taskAppstoreId;
		this.taskAdId = taskAdId;
		this.taskCreatime = taskCreatime;
		this.taskUpdatetime = taskUpdatetime;
		this.taskIfonly = taskIfonly;
		this.taskIfclick = taskIfclick;
		this.taskIfreport = taskIfreport;
	}

	public TaskFrom() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TaskFrom [taskId=" + taskId + ", taskSource=" + taskSource + ", taskName=" + taskName
				+ ", taskAppstoreId=" + taskAppstoreId + ", taskAdId=" + taskAdId + ", taskCreatime=" + taskCreatime
				+ ", taskUpdatetime=" + taskUpdatetime + ", taskIfonly=" + taskIfonly + ", taskIfclick=" + taskIfclick
				+ ", taskIfreport=" + taskIfreport + "]";
	}
	
}