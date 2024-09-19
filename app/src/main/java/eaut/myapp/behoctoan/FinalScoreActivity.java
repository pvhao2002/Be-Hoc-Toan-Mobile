package eaut.myapp.behoctoan;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

import eaut.myapp.behoctoan.model.Result;
import eaut.myapp.behoctoan.sqllite.DatabaseHandler;
import eaut.myapp.behoctoan.util.Constant;

public class FinalScoreActivity extends AppCompatActivity {

    private TextView finalScoreTextView;
    private Button playAgainButton, backButton;
    private EditText editTextName;
    private int score = 0;
    private int totalQuestions = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_score);

        // Initialize views
        // Initialize views from the layout
        finalScoreTextView = findViewById(R.id.FinalScore);
        playAgainButton = findViewById(R.id.ButtonPlayAgain);
        backButton = findViewById(R.id.back);
        editTextName = findViewById(R.id.editTextName);

        // Receive the score and total number of questions from the intent
        Intent intent = getIntent();
        score = intent.getIntExtra(Constant.SCORE, 0);
        totalQuestions = intent.getIntExtra(Constant.TOTAL_QUESTIONS, 0);

        // Display the final score
        finalScoreTextView.setText("Score: " + score + "/" + totalQuestions);

        // Handle the "Play Again" button click event
        playAgainButton.setOnClickListener(v -> {
            // Navigate back to MainActivity to play again
            if(saveData()) {
                Intent intent1 = new Intent(FinalScoreActivity.this, MainActivity2.class);
                startActivity(intent1);
                finish(); // End the current activity to prevent the user from returning to it
            }
        });

        // Handle the "Back to Dashboard" button click event
        backButton.setOnClickListener(v -> {
            // Navigate back to the dashboard activity
            Intent backIntent = new Intent(FinalScoreActivity.this, MainActivity.class);
            startActivity(backIntent);
            finish(); // End the current activity to prevent the user from returning to it
        });
    }

    private boolean saveData() {
        if (editTextName.getText() == null || editTextName.getText().toString().isEmpty()) {
            editTextName.setError("Please enter your name");
            editTextName.requestFocus();
            return false;
        }
        DatabaseHandler db = new DatabaseHandler(FinalScoreActivity.this);
        Result result = new Result();
        result.setName(editTextName.getText().toString());
        result.setScore(score);
        result.setTotalQuestions(totalQuestions);
        result.setDate(new Date());
        result.setCorrectAnswers(score);
        db.addResult(result);
        return true;
    }
}
