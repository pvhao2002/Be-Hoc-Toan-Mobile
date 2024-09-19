package eaut.myapp.behoctoan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import eaut.myapp.behoctoan.adapter.ResultAdapter;
import eaut.myapp.behoctoan.model.Result;
import eaut.myapp.behoctoan.sqllite.DatabaseHandler;

public class ResultActivity extends AppCompatActivity {
    ArrayList<Result> results;
    RecyclerView recyclerView;
    ResultAdapter resultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        DatabaseHandler db = new DatabaseHandler(this);
        results = (ArrayList<Result>) db.getAllResults();
        resultAdapter = new ResultAdapter(results);

        recyclerView = findViewById(R.id.recyclevViewResult);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(ResultActivity.this, 1, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(resultAdapter);
    }
}