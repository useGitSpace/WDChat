package com.example.myapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import  android.content.ContentValues
import android.database.Cursor

class DatabaseHelper(context: Context):
    SQLiteOpenHelper(context,
        DATABASE_NAME,null,1) {


     //   val dbHelper = FeedReaderDbHelper(context)




    override fun onCreate(db: SQLiteDatabase) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

            db.execSQL("CREATE TABLE $TABLE_NAME1 (u_name TEXT NOT NULL,ph_number CHAR(10) NOT NULL CHECK(ph_number NOT LIKE '%[^0-9]%'),PRIMARY KEY(u_name));")



//            db.execSQL("CREATE TABLE \"$TABLE_NAME2 \" (\n" +
//                    "\t\"chat_id\"\tTEXT NOT NULL,\n" +
//                    "\t\"msg\"\tTEXT NOT NULL DEFAULT 'GETDATE()',\n" +
//                    "\t\"date_time\"\tDATETIME NOT NULL,\n" +
//                    "\tFOREIGN KEY(\"chat_id\") REFERENCES \"chat_info\"(\"chat_id\")\n" +
//                    ");")
//
//
//
//            db.execSQL("CREATE TABLE \"$TABLE_NAME3 \" (\n" +
//                    "\t\"u_name\"\tTEXT NOT NULL,\n" +
//                    "\t\"ph_number\"\tCHAR(10) NOT NULL CHECK(\"ph_number\" NOT LIKE ('%[^0-9]%')),\n" +
//                    "\t\"needs\"\tTEXT,\n" +
//                    "\t\"location\"\tTEXT NOT NULL,\n" +
//                    "\t\"landmark\"\tTEXT,\n" +
//                    "\tPRIMARY KEY(\"u_name\")\n" +
//                    ");")
//
//
//
//            db.execSQL("CREATE TABLE \"$TABLE_NAME4\" (\n" +
//                    "\t\"u_name\"\tTEXT NOT NULL,\n" +
//                    "\t\"s_name\"\tTEXT NOT NULL,\n" +
//                    "\t\"chat_id\"\tTEXT NOT NULL,\n" +
//                    "\tPRIMARY KEY(\"chat_id\"),\n" +
//                    "\tFOREIGN KEY(\"u_name\") REFERENCES \"user_info\"(\"u_name\")\n" +
//                    ");")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (db != null) {
            db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME1")

            db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME2")
            db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME3")
            db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME4")
            onCreate(db)
        }

    }

    fun insertIntoUserInfo(name:String, phone:String){
        val db=this.writableDatabase
        val contentValues= ContentValues()
        contentValues.put(col_1,name)
        contentValues.put(col_2,phone)
        db.insert(TABLE_NAME1,null,contentValues)


    }

    fun insertIntoGlobalLedger(name:String, phone:String, need:String, location:String, landmark:String){
        val db=this.writableDatabase
        val contentValues= ContentValues()
        contentValues.put(col_1,name)
        contentValues.put(col_2,name)
        contentValues.put(col_3,need)
        contentValues.put(col_4,location)
        contentValues.put(col_5,landmark)

        db.insert(TABLE_NAME3,null,contentValues)

    }

    fun updatedataGlobalLedger(name:String, phone:String, need:String, location:String, landmark:String):
        Boolean {
            val db = this.writableDatabase
            val contentValues = ContentValues()
            contentValues.put(col_1, name)
            contentValues.put(col_2, need)
            contentValues.put(col_3, need)
            contentValues.put(col_4, location)
            contentValues.put(col_5, landmark)

            db.update(TABLE_NAME3, contentValues,"NAME=?", arrayOf(name))
            return true;
        }

    val dataFromGlobalLedger:Cursor
    get(){
        val db=this.writableDatabase
        val res=db.rawQuery("SELECT * FROM"+ TABLE_NAME3.,null)
        return res
    }

    companion object{
        const val DATABASE_NAME="help.db"
        const val TABLE_NAME1="user_info"
        const val TABLE_NAME2="message"
        const val TABLE_NAME3="global_ledger"
        const val TABLE_NAME4="chat_info"
         const val col_1="uname"
         const val col_2="ph_number"
         const val col_3="needs"
         const val col_4="location"
         const val col_5="landmark"
         const val col_6="dateTime"

    }

}
