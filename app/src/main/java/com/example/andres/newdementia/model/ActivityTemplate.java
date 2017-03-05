package com.example.andres.newdementia.model;

public class ActivityTemplate {
	private long _id;
	private String name;
	private String description;
	private long creatorId;
	private long patientId;
	private String idealLocation;

	public ActivityTemplate(long _id, String name, String description, long patientId, long creatorId, String idealLocation) {
		this.set_id(_id);
		this.name = name;
		this.description = description;
		this.setPatientId(patientId);
		this.setCreatorId(creatorId);
		this.idealLocation = idealLocation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIdealLocation() {
		return idealLocation;
	}

	public void setIdealLocation(String idealLocation) {
		this.idealLocation = idealLocation;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public void setCreatorId(long creatorId) {
		this.creatorId = creatorId;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public long get_id() {
		return _id;
	}

	public long getCreatorId() {
		return creatorId;
	}

	@Override public String toString() {
		return "ActivityTemplate{" +
				"_id=" + _id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", creatorId=" + creatorId +
				", patientId=" + patientId +
				", idealLocation='" + idealLocation + '\'' +
				'}';
	}
}
