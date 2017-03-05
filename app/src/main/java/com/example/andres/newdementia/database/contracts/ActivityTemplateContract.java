package com.example.andres.newdementia.database.contracts;

import android.provider.BaseColumns;

public final class ActivityTemplateContract {
	private ActivityTemplateContract() {}

	public static class ActivityTemplateEntry implements BaseColumns {
		public static final String TABLE_NAME = "activityTemplate";
		public static final String COLUMN_NAME_IDEAL_LOCATION = "idealLocation";
		public static final String COLUMN_NAME_NAME = "name";
		public static final String COLUMN_NAME_DESCRIPTION = "description";
		public static final String COLUMN_NAME_CREATOR_ID = "creatorId";
		public static final String COLUMN_NAME_PATIENT_ID = "patientId";
	}
}
