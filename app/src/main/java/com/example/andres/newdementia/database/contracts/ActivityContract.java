package com.example.andres.newdementia.database.contracts;

import android.provider.BaseColumns;

public final class ActivityContract {
	private ActivityContract() {}

	public static class ActivityEntry implements BaseColumns {
		public static final String TABLE_NAME = "activity";
		public static final String COLUMN_NAME_USER_ID = "userId";
		public static final String COLUMN_NAME_LOCATION = "location";
		public static final String COLUMN_NAME_ACTIVITY_TEMPLATE_ID = "activityTemplateId";
		public static final String COLUMN_NAME_TIME_STARTED = "timeStarted";
	}
}
