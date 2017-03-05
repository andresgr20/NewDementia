package com.example.andres.newdementia.database.calls;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.andres.newdementia.database.contracts.ActivityTemplateContract.ActivityTemplateEntry;
import com.example.andres.newdementia.model.ActivityTemplate;

import java.util.ArrayList;
import java.util.List;


public class ActivityTemplateDb extends SQLiteOpenHelper {
	private static final String[] projection = {
			ActivityTemplateEntry._ID,
			ActivityTemplateEntry.COLUMN_NAME_NAME,
			ActivityTemplateEntry.COLUMN_NAME_DESCRIPTION,
			ActivityTemplateEntry.COLUMN_NAME_PATIENT_ID,
			ActivityTemplateEntry.COLUMN_NAME_CREATOR_ID,
			ActivityTemplateEntry.COLUMN_NAME_IDEAL_LOCATION,
	};

	private static final String DATABASE_NAME = "ActivityTemplate.db";
	public ActivityTemplateDb(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}

	@Override public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE "+ ActivityTemplateEntry.TABLE_NAME + " (" +
				ActivityTemplateEntry._ID + " INTEGER PRIMARY KEY, " +
				ActivityTemplateEntry.COLUMN_NAME_NAME + " TEXT, " +
				ActivityTemplateEntry.COLUMN_NAME_DESCRIPTION + " TEXT, " +
				ActivityTemplateEntry.COLUMN_NAME_IDEAL_LOCATION + " TEXT, " +
				ActivityTemplateEntry.COLUMN_NAME_PATIENT_ID + " INTEGER, " +
				ActivityTemplateEntry.COLUMN_NAME_CREATOR_ID + " INTEGER)");
	}

	@Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS "+ ActivityTemplateEntry.TABLE_NAME);
		onCreate(db);
	}

	public long insert(String name, String description, long patientId, long creatorId) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(ActivityTemplateEntry.COLUMN_NAME_CREATOR_ID, Long.valueOf(creatorId).toString());
		values.put(ActivityTemplateEntry.COLUMN_NAME_DESCRIPTION, description);
		values.put(ActivityTemplateEntry.COLUMN_NAME_PATIENT_ID, Long.valueOf(patientId).toString());
		values.put(ActivityTemplateEntry.COLUMN_NAME_NAME, name);
		long newRowId = db.insert(ActivityTemplateEntry.TABLE_NAME, null, values);
		return newRowId;
	}

	public List<ActivityTemplate> getActivityTemplatesByPatient(long patientId) {
		String selection = ActivityTemplateEntry.COLUMN_NAME_PATIENT_ID + " = ?";
		String[] selectionsArgs = { Long.valueOf(patientId).toString() };
		return getActivityTemplates(selection, selectionsArgs);
	}

	public List<ActivityTemplate> getActivityTemplatesByCreator(long creatorId) {
		String selection = ActivityTemplateEntry.COLUMN_NAME_CREATOR_ID + " = ?";
		String[] selectionsArgs = { Long.valueOf(creatorId).toString() };
		return getActivityTemplates(selection, selectionsArgs);
	}

	public ActivityTemplate getActivityTemplateByID(long _id) {
		SQLiteDatabase db = this.getReadableDatabase();
		String selection = ActivityTemplateEntry._ID + " = ?";
		String[] selectionsArgs = { Long.valueOf(_id).toString() };
		Cursor cursor = db.query(
				ActivityTemplateEntry.TABLE_NAME,
				projection,
				selection,
				selectionsArgs,
				null,
				null,
				null
		);
		ActivityTemplate template = null;
		while(cursor.moveToNext()) {
			long _id2 = cursor.getLong(cursor.getColumnIndexOrThrow(ActivityTemplateEntry._ID));
			String name = cursor.getString(cursor.getColumnIndexOrThrow(ActivityTemplateEntry.COLUMN_NAME_NAME));
			String description = cursor.getString(cursor.getColumnIndexOrThrow(ActivityTemplateEntry.COLUMN_NAME_DESCRIPTION));
			long patientId2 = cursor.getLong(cursor.getColumnIndexOrThrow(ActivityTemplateEntry.COLUMN_NAME_PATIENT_ID));
			long createId = cursor.getLong(cursor.getColumnIndexOrThrow(ActivityTemplateEntry.COLUMN_NAME_CREATOR_ID));
			template = new ActivityTemplate(_id2, name, description, patientId2, createId, "");
		}
		cursor.close();
		return template;
	}

	private List<ActivityTemplate> getActivityTemplates(String selection, String[] selectionsArgs) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(
				ActivityTemplateEntry.TABLE_NAME,
				projection,
				selection,
				selectionsArgs,
				null,
				null,
				null
		);
		List<ActivityTemplate> templates = new ArrayList<>();
		while(cursor.moveToNext()) {
			long _id = cursor.getLong(cursor.getColumnIndexOrThrow(ActivityTemplateEntry._ID));
			String name = cursor.getString(cursor.getColumnIndexOrThrow(ActivityTemplateEntry.COLUMN_NAME_NAME));
			String description = cursor.getString(cursor.getColumnIndexOrThrow(ActivityTemplateEntry.COLUMN_NAME_DESCRIPTION));
			long patientId2 = cursor.getLong(cursor.getColumnIndexOrThrow(ActivityTemplateEntry.COLUMN_NAME_PATIENT_ID));
			long createId = cursor.getLong(cursor.getColumnIndexOrThrow(ActivityTemplateEntry.COLUMN_NAME_CREATOR_ID));
			templates.add(new ActivityTemplate(_id, name, description, patientId2, createId, ""));
		}
		cursor.close();
		return templates;
	}
}
