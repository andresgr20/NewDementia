package com.example.andres.newdementia.model;

import java.util.Date;

public class Activity {
	private long _id;
	private long userId;
	private String location;
	private ActivityTemplate activityTemplate;
	private Date timeStarted;

	public Activity(long _id, long userId, String location, ActivityTemplate activityTemplate, Date timeStarted) {
		this.set_id(_id);
		this.setUserId(userId);
		this.setLocation(location);
		this.setActivityTemplate(activityTemplate);
		this.setTimeStarted(timeStarted);
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public ActivityTemplate getActivityTemplate() {
		return activityTemplate;
	}

	public void setActivityTemplate(ActivityTemplate activityTemplate) {
		this.activityTemplate = activityTemplate;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getTimeStarted() {
		return timeStarted;
	}

	public void setTimeStarted(Date timeStarted) {
		this.timeStarted = timeStarted;
	}

	@Override public String toString() {
		return "Activity{" +
				"_id=" + _id +
				", userId=" + userId +
				", location='" + location + '\'' +
				", activityTemplate=" + activityTemplate +
				", timeStarted=" + timeStarted +
				'}';
	}
}
