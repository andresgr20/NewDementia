package com.example.andres.newdementia.database.calls;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.andres.newdementia.database.contracts.UserContract.UserEntry;
import com.example.andres.newdementia.model.User;

public class UserDb extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "User.db";

	public UserDb(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}

	@Override public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE "+ UserEntry.TABLE_NAME + " (" +
		UserEntry._ID + " INTEGER PRIMARY KEY, " +
		UserEntry.COLUMN_NAME_ROLE + " TEXT, " +
		UserEntry.COLUMN_NAME_USERNAME + " TEXT, " +
		UserEntry.COLUMN_NAME_NAME + " TEXT, " +
		UserEntry.COLUMN_NAME_PASSWORD + " TEXT)");
	}

	@Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS "+ UserEntry.TABLE_NAME);
		onCreate(db);
	}

	public long insert(String username, String password, String name, String role) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(UserEntry.COLUMN_NAME_NAME, name);
		values.put(UserEntry.COLUMN_NAME_PASSWORD, password);
		values.put(UserEntry.COLUMN_NAME_USERNAME, username);
		values.put(UserEntry.COLUMN_NAME_ROLE, role);
		long newRowId = db.insert(UserEntry.TABLE_NAME, null, values);
		return newRowId;
	}

	public User getUser(String username) {
		String selection = UserEntry.COLUMN_NAME_USERNAME + " = ?";
		String[] selectionsArgs = { username };
		return getUserFn(selection, selectionsArgs);
	}

	public User getUser(long _id) {
		String selection = UserEntry._ID + " = ?";
		String[] selectionsArgs = { Long.valueOf(_id).toString()};
		return getUserFn(selection, selectionsArgs);
	}

	private User getUserFn(String selection, String[] selectionsArgs) {
		SQLiteDatabase db = this.getReadableDatabase();
		String[] projection = {
				UserEntry._ID,
				UserEntry.COLUMN_NAME_NAME,
				UserEntry.COLUMN_NAME_PASSWORD,
				UserEntry.COLUMN_NAME_USERNAME,
				UserEntry.COLUMN_NAME_ROLE
		};
		Cursor cursor = db.query(
				UserEntry.TABLE_NAME,
				projection,
				selection,
				selectionsArgs,
				null,
				null,
				null
		);
		User user = null;
		while(cursor.moveToNext()) {
			String name = cursor.getString(cursor.getColumnIndexOrThrow(UserEntry.COLUMN_NAME_NAME));
			long _id = cursor.getLong(cursor.getColumnIndexOrThrow(UserEntry._ID));
			String username2 = cursor.getString(cursor.getColumnIndexOrThrow(UserEntry.COLUMN_NAME_USERNAME));
			String role = cursor.getString(cursor.getColumnIndexOrThrow(UserEntry.COLUMN_NAME_ROLE));
			String password = cursor.getString(cursor.getColumnIndexOrThrow(UserEntry.COLUMN_NAME_PASSWORD));
			user = new User(_id, name, username2, password, role);
		}
		cursor.close();
		return user;
	}
}
