package eaut.myapp.behoctoan.model;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.Date;

public class Result {
    private String name;
    private double score;
    private String testType;
    private int totalQuestions;
    private int correctAnswers;
    private Date date;

    public Result() {
        this("", 0, 0, 0, new Date());
    }

    public Result(Cursor cursor) {
        this.name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        this.score = cursor.getDouble(cursor.getColumnIndexOrThrow("score"));
        this.testType = cursor.getString(cursor.getColumnIndexOrThrow("testType"));
        this.totalQuestions = cursor.getInt(cursor.getColumnIndexOrThrow("totalQuestions"));
        this.correctAnswers = cursor.getInt(cursor.getColumnIndexOrThrow("correctAnswers"));
        this.date = new Date(cursor.getString(cursor.getColumnIndexOrThrow("date")));
    }

    public Result(String name, double score, int totalQuestions, int correctAnswers, Date date) {
        this.name = name;
        this.score = score;
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("score", score);
        values.put("testType", testType);
        values.put("totalQuestions", totalQuestions);
        values.put("correctAnswers", correctAnswers);
        values.put("date", date.toString());
        return values;
    }

    @Override
    public String toString() {
        return "Result{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", testType='" + testType + '\'' +
                ", totalQuestions=" + totalQuestions +
                ", correctAnswers=" + correctAnswers +
                ", date=" + date +
                '}';
    }
}
