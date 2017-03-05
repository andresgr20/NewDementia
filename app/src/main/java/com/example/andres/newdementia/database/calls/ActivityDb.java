package com.example.andres.newdementia.database.calls;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.andres.newdementia.database.contracts.ActivityContract.ActivityEntry;
import com.example.andres.newdementia.model.Activity;
import com.example.andres.newdementia.model.ActivityTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityDb extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "Activity.db";
	private static final String[] projection = {
			ActivityEntry._ID,
			ActivityEntry.COLUMN_NAME_LOCATION,
			ActivityEntry.COLUMN_NAME_TIME_STARTED,
			ActivityEntry.COLUMN_NAME_ACTIVITY_TEMPLATE_ID,
			ActivityEntry.COLUMN_NAME_USER_ID
	};
	private static ActivityTemplateDb activityTemplateDb;

	public ActivityDb(Context context) {
		super(context, DATABASE_NAME, null, 1);
		activityTemplateDb = new ActivityTemplateDb(context);
	}

	@Override public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + ActivityEntry.TABLE_NAME + " (" +
				ActivityEntry._ID + " INTEGER PRIMARY KEY, " +
				ActivityEntry.COLUMN_NAME_ACTIVITY_TEMPLATE_ID + " INTEGER, " +
				ActivityEntry.COLUMN_NAME_TIME_STARTED + " TEXT, " +
				ActivityEntry.COLUMN_NAME_USER_ID + " INTEGER, "+
				ActivityEntry.COLUMN_NAME_LOCATION + " TEXT) ");
	}

	@Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + ActivityEntry.TABLE_NAME);
		onCreate(db);
	}

	public long insert(long userId, long activityTemplateId, String location) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(ActivityEntry.COLUMN_NAME_USER_ID, Long.valueOf(userId).toString());
		values.put(ActivityEntry.COLUMN_NAME_LOCATION, "");
		values.put(ActivityEntry.COLUMN_NAME_TIME_STARTED, new Date().toString());
		values.put(ActivityEntry.COLUMN_NAME_ACTIVITY_TEMPLATE_ID, Long.valueOf(activityTemplateId).toString());
		long newRowId = db.insert(ActivityEntry.TABLE_NAME, null, values);
		return newRowId;
	}

	public List<Activity> getActivies(long userId) throws Exception {
		String selection = ActivityEntry.COLUMN_NAME_USER_ID + " = ?";
		String[] selectionsArgs = { Long.valueOf(userId).toString() };
		return getActivities(selection, selectionsArgs);
	}

	public Activity getActivity(long _id) throws Exception {
		String selection = ActivityEntry._ID + " = ?";
		String[] selectionsArgs = { Long.valueOf(_id).toString() };
		return getActivities(selection, selectionsArgs).get(0);
	}

	private List<Activity> getActivities(String selection, String[] selectionsArgs) throws Exception {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(
				ActivityEntry.TABLE_NAME,
				projection,
				selection,
				selectionsArgs,
				null,
				null,
				null
		);
		List<Activity> templates = new ArrayList<>();
		while (cursor.moveToNext()) {
			long _id = cursor.getLong(cursor.getColumnIndexOrThrow(ActivityEntry._ID));
			long userId = cursor.getLong(cursor.getColumnIndexOrThrow(ActivityEntry.COLUMN_NAME_USER_ID));
			ActivityTemplate template = activityTemplateDb.getActivityTemplateByID(
					cursor.getLong(cursor.getColumnIndexOrThrow(ActivityEntry.COLUMN_NAME_ACTIVITY_TEMPLATE_ID))
			);
			String location = cursor.getString(cursor.getColumnIndexOrThrow(ActivityEntry.COLUMN_NAME_LOCATION));
			SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy");
			Date timeStarted = format.parse(cursor.getString(cursor.getColumnIndexOrThrow(ActivityEntry.COLUMN_NAME_TIME_STARTED)));
			templates.add(new Activity(_id, userId, location, template, timeStarted));
		}
		cursor.close();
		return templates;
	}
}
