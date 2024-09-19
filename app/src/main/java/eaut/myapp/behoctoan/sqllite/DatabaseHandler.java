package eaut.myapp.behoctoan.sqllite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import eaut.myapp.behoctoan.model.Result;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "schoolManager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_RESULT = "result";
    private static final String CREATE_TABLE_RESULT = "CREATE TABLE "
            + TABLE_RESULT
            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "name TEXT, " +
            "score REAL, " +
            "totalQuestions INTEGER, " +
            "correctAnswers INTEGER," +
            " date TEXT DEFAULT CURRENT_TIMESTAMP)";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_RESULT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TABLE_RESULT);
        db.execSQL(drop_students_table);
        onCreate(db);
    }

    public void addResult(Result result) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_RESULT, null, result.toContentValues());
        db.close();
    }

    public Result getResult(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_RESULT, null, "id = ?", new String[]{String.valueOf(id)}, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            Result result = new Result(cursor);
            db.close();
            return result;
        }
        return null;
    }

    public List<Result> getAllResults() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_RESULT, null, null, null, null, null, "date DESC");
        List<Result> results = new ArrayList<>();
        if (cursor != null) {
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                Result result = new Result(cursor);
                results.add(result);
                cursor.moveToNext();
            }
            db.close();
        }
        return results;
    }
}