package com.structure.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by android on 26/8/16.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "ClinicApp.db";

    // Table Names
    private static final String TABLE_Register = "RegisterUsers";
    private static final String TABLE_Patient_Record = "PatientRecord";
    private static final String TABLE_Patient_Medicine_data = "MedicineData";

    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_AT = "created_at";


    // Register Table - column nmaes
    private static final String KEY_TYPE = "TYPE";
    private static final String KEY_NAME = "NAME";
    private static final String KEY_PASSWORD = "PASSWORD";
    private static final String KEY_CONFRIRM_PAASWORD = "CONFIRM_PASSWORD";

    // PATIENT RECORD Table - column names
    private static final String KEY_PATIENT_ID = "PATIENT_ID";
    private static final String KEY_TOKEN_NO = "TOKEN_NO";
    private static final String KEY_PHONE_NO = "PHONE_NO";
    private static final String KEY_PATIENT_NAME = "PATIENT_NAME";
    private static final String KEY_GENDER = "GENDER";
    private static final String KEY_AGE = "AGE";
    private static final String KEY_DESCRIPTION = "DESCRIPTION";
    private static final String KEY_DATE = "DATE";
    private static final String KEY_STATUS = "STATUS";
    private static final String KEY_PRICE = "PRICE";
    private static final String KEY_MEDICINE_LIST = "MEDICINES";
    private static final String KEY_SELECTED_DOCTOR= "SELECTED_DOCTOR";


    // PRESCRIBE MEDICINE Table - column names
    private static final String KEY_TODO_ID = "todo_id";
    private static final String KEY_TAG_ID = "tag_id";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String INTEGER_TYPE = " INTEGER";


    // Table Create Statements  ****************************************************************


//    private static final String CREATE_TABLE_REGISTER = "CREATE TABLE "
//            + TABLE_Register + "(" + KEY_ID + " INTEGER PRIMARY KEY autoincrement," + KEY_TYPE
//            + " TEXT," + KEY_NAME + " TEXT," + KEY_PASSWORD + " TEXT,"+KEY_CONFRIRM_PAASWORD+"TEXT"+")";


    //    "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
//    FeedEntry._ID + " INTEGER PRIMARY KEY," +
//    FeedEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
//    FeedEntry.COLUMN_NAME_SUBTITLE + TEXT_TYPE + " )";


    private static final String CREATE_TABLE_PATIENT_RECORD = "CREATE TABLE " + TABLE_Patient_Record + " (" +
            KEY_PATIENT_ID + " INTEGER PRIMARY KEY autoincrement," +
            KEY_TOKEN_NO + TEXT_TYPE + COMMA_SEP +
            KEY_PHONE_NO + TEXT_TYPE + COMMA_SEP +
            KEY_PATIENT_NAME + TEXT_TYPE + COMMA_SEP +
            KEY_GENDER + TEXT_TYPE + COMMA_SEP +
            KEY_AGE + INTEGER_TYPE + COMMA_SEP +
            KEY_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
            KEY_DATE + TEXT_TYPE + COMMA_SEP +
            KEY_STATUS + INTEGER_TYPE + COMMA_SEP +
            KEY_PRICE + INTEGER_TYPE + COMMA_SEP +
            KEY_MEDICINE_LIST + TEXT_TYPE + COMMA_SEP +
            KEY_SELECTED_DOCTOR + TEXT_TYPE +

            " )";



    private static final String CREATE_TABLE_REGISTER = "CREATE TABLE " + TABLE_Register + " (" +
            KEY_ID + " INTEGER PRIMARY KEY," +
            KEY_TYPE + TEXT_TYPE + COMMA_SEP +
            KEY_NAME + TEXT_TYPE + COMMA_SEP +
            KEY_PASSWORD + TEXT_TYPE + COMMA_SEP +
            KEY_CONFRIRM_PAASWORD + TEXT_TYPE +
            " )";


    SQLiteDatabase db_write = this.getWritableDatabase();
    SQLiteDatabase db_read = this.getReadableDatabase();


    public DataBaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables

        db.execSQL(CREATE_TABLE_REGISTER);

        db.execSQL(CREATE_TABLE_PATIENT_RECORD);

//        db.execSQL(CREATE_TABLE_TODO_TAG);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Register);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Patient_Record);

//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO_TAG);

        // create new tables
        onCreate(db);

    }


    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


    // ------------------------ "REGISTER" table methods ----------------//

    /**
     * Creating a Register
     */
   /* public void insertRegister(String userName, String password, String confirm_password, String type) {

        //     SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        // Assign values for each row.
        values.put(KEY_NAME, userName);
        values.put(KEY_PASSWORD, password);
        values.put(KEY_CONFRIRM_PAASWORD, confirm_password);
        values.put(KEY_TYPE, type);

        // insert row
        db_write.insert(TABLE_Register, null, values);

        // Insert the new row, returning the primary key value of the new row
        //long new_row_Id=db.insert(TABLE_Register, null, values);

    }




    *//*
*      getting List of doctors
* *//*
    public ArrayList<String> getListOfDoctors(String type) {

        Log.e("Location", "Get List of doctors************************************");

        ArrayList<String> doctor_list = new ArrayList<String>();

        Cursor cursor = db_read.query(TABLE_Register, null, KEY_TYPE + " =?", new String[]{type}, null, null, null);


        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {


            do {
                Log.e("DoctorName", "DoctorName" + cursor.getString(cursor.getColumnIndexOrThrow(KEY_NAME)));
                doctor_list.add(cursor.getString(cursor.getColumnIndexOrThrow(KEY_NAME)));
            }while(cursor.moveToNext());

            Log.e("List size","List size "+doctor_list.size());


        } else {
            return doctor_list;
        }

        return doctor_list;
    }



    public String deleteRegisterRow(String userName) {

        db_read.delete(TABLE_Register, "NAME =?", new String[]{userName});

        return "Deleted";
    }

    public String updateRegisterRow(String userName, String password, String confirm_password, String type) {

        // New value for one column
        ContentValues values = new ContentValues();
        // Assign values for each row.
        values.put(KEY_NAME, userName);
        values.put(KEY_PASSWORD, password);
        values.put(KEY_CONFRIRM_PAASWORD, confirm_password);
        values.put(KEY_TYPE, type);


        db_read.update(TABLE_Register, values, "NAME =?", new String[]{userName});
        return "Updated";
    }





    */






}
