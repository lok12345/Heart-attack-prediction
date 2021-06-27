package com.example.inspiron.heartcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by inspiron on 20/04/2018.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "UserManager.db";

    // User table name
    private static final String TABLE_USER = "user";

    // User Table Columns names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";

    private static final String COLUMN_USER_AGE = "user_age";
    private static final String COLUMN_USER_GENDER = "user_gender";
    private static final String COLUMN_USER_CHESTPAINTYPE = "user_chestpaintype";
    private static final String COLUMN_USER_RBP = "user_rbp";
    private static final String COLUMN_USER_CHOLESTEROL = "user_cholesterol";
    private static final String COLUMN_USER_SUGAR = "user_sugar";
    private static final String COLUMN_USER_CARDIOGRAPHIC = "user_cardiographic";
    private static final String COLUMN_USER_HEARTRATE = "user_heartrate";
    private static final String COLUMN_USER_ANGINA = "user_angina";
    private static final String COLUMN_USER_EXERCISE = "user_exercise";
    private static final String COLUMN_USER_PICKEXERCISES = "user_pickexercises";
    private static final String COLUMN_USER_VESSELS = "user_vessels";
    private static final String COLUMN_USER_THAL = "user_thal";



    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT," + COLUMN_USER_AGE + " TEXT,"+ COLUMN_USER_GENDER + " TEXT,"+ COLUMN_USER_CHESTPAINTYPE + " TEXT,"
            + COLUMN_USER_RBP + " TEXT,"+ COLUMN_USER_CHOLESTEROL + " TEXT,"+ COLUMN_USER_SUGAR + " TEXT,"+ COLUMN_USER_CARDIOGRAPHIC + " TEXT,"+ COLUMN_USER_HEARTRATE + " TEXT,"
            + COLUMN_USER_ANGINA + " TEXT,"+ COLUMN_USER_EXERCISE + " TEXT,"+ COLUMN_USER_PICKEXERCISES + " TEXT,"+ COLUMN_USER_VESSELS + " TEXT,"+ COLUMN_USER_THAL + " TEXT )";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    /**
     * Constructor
     *
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);

        // Create tables again
        onCreate(db);

    }

    /**
     * This method is to create user record
     *
     * @param user
     */
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        values.put(COLUMN_USER_AGE, user.getName());
        values.put(COLUMN_USER_GENDER, user.getName());
        values.put(COLUMN_USER_CHESTPAINTYPE, user.getName());
        values.put(COLUMN_USER_RBP, user.getName());
        values.put(COLUMN_USER_CHOLESTEROL, user.getName());
        values.put(COLUMN_USER_SUGAR, user.getName());
        values.put(COLUMN_USER_CARDIOGRAPHIC, user.getName());
        values.put(COLUMN_USER_HEARTRATE, user.getName());
        values.put(COLUMN_USER_ANGINA, user.getName());
        values.put(COLUMN_USER_EXERCISE, user.getName());
        values.put(COLUMN_USER_PICKEXERCISES, user.getName());
        values.put(COLUMN_USER_VESSELS, user.getName());
        values.put(COLUMN_USER_THAL, user.getName());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_EMAIL,
                COLUMN_USER_NAME,
                COLUMN_USER_PASSWORD,
                COLUMN_USER_AGE,
                COLUMN_USER_GENDER,
                COLUMN_USER_CHESTPAINTYPE,
                COLUMN_USER_RBP,
                COLUMN_USER_CHOLESTEROL,
                COLUMN_USER_SUGAR,
                COLUMN_USER_CARDIOGRAPHIC,
                COLUMN_USER_HEARTRATE,
                COLUMN_USER_ANGINA,
                COLUMN_USER_EXERCISE,
                COLUMN_USER_PICKEXERCISES,
                COLUMN_USER_VESSELS,
                COLUMN_USER_THAL
        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));

                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_AGE))));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_GENDER)));
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_CHESTPAINTYPE))));
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_RBP))));
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_CHOLESTEROL))));
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_SUGAR))));
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_CARDIOGRAPHIC))));
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_HEARTRATE))));
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ANGINA))));
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EXERCISE))));
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PICKEXERCISES))));
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_VESSELS))));
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_THAL))));

                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    /**
     * This method to update user record
     *
     * @param user
     */
    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        values.put(COLUMN_USER_AGE, user.getName());
        values.put(COLUMN_USER_GENDER, user.getName());
        values.put(COLUMN_USER_CHESTPAINTYPE, user.getName());
        values.put(COLUMN_USER_RBP, user.getName());
        values.put(COLUMN_USER_CHOLESTEROL, user.getName());
        values.put(COLUMN_USER_SUGAR, user.getName());
        values.put(COLUMN_USER_CARDIOGRAPHIC, user.getName());
        values.put(COLUMN_USER_HEARTRATE, user.getName());
        values.put(COLUMN_USER_ANGINA, user.getName());
        values.put(COLUMN_USER_EXERCISE, user.getName());
        values.put(COLUMN_USER_PICKEXERCISES, user.getName());
        values.put(COLUMN_USER_VESSELS, user.getName());
        values.put(COLUMN_USER_THAL, user.getName());

        // updating row
        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    /**
     * This method is to delete user record
     *
     * @param user
     */
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @return true/false
     */
    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @param password
     * @return true/false
     */
    public boolean checkUser(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
}