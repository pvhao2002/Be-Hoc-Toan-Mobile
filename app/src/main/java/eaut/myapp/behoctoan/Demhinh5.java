package eaut.myapp.behoctoan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import eaut.myapp.behoctoan.util.Constant;

public class Demhinh5 extends AppCompatActivity {
    private Button button1, button2, button3, button4;
    private final int correctButtonId = R.id.button1; // Định nghĩa button đúng
    private int score = 0; // Điểm số
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demhinh5);

        score = getIntent().getIntExtra(Constant.SCORE, 0); // Lấy điểm số từ Intent

        // Ánh xạ các thành phần giao diện
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        // Điều chỉnh padding dựa trên systemBars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Đặt sự kiện onClick cho mỗi button
        View.OnClickListener buttonClickListener = v -> {
            Button clickedButton = (Button) v;
            MediaPlayer mediaPlayer;

            if (clickedButton.getId() == correctButtonId) {
                // Nếu đúng button, hiển thị dấu tích (check)
                clickedButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.correct_tick, 0);
                mediaPlayer = MediaPlayer.create(Demhinh5.this, R.raw.correct_sound); // Âm thanh đúng
                score++; // Tăng điểm số
            } else {
                // Nếu sai button, hiển thị dấu X (cross)
                clickedButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.incorrect_cross, 0);
                mediaPlayer = MediaPlayer.create(Demhinh5.this, R.raw.wrong_sound); // Âm thanh sai
            }

            mediaPlayer.start(); // Phát âm thanh

            // Giải phóng MediaPlayer sau khi phát xong
            mediaPlayer.setOnCompletionListener(mp -> mp.release());

            // Vô hiệu hóa tất cả các button sau khi người dùng chọn
            disableButtons();
        };

        // Gán sự kiện cho các button
        button1.setOnClickListener(buttonClickListener);
        button2.setOnClickListener(buttonClickListener);
        button3.setOnClickListener(buttonClickListener);
        button4.setOnClickListener(buttonClickListener);
    }

    // Phương thức vô hiệu hóa tất cả các button sau khi người dùng đã chọn
    private void disableButtons() {
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);

        // Chuyển sang MainActivity sau khi vô hiệu hóa các nút, với một khoảng thời gian chờ
        button1.postDelayed(this::moveToNextActivity, 1000); // Chờ 1 giây trước khi chuyển
    }

    // Phương thức chuyển sang MainActivity
    private void moveToNextActivity() {
        Intent intent = new Intent(Demhinh5.this, FinalScoreActivity.class);
        intent.putExtra(Constant.SCORE, score); // Truyền điểm số qua Intent
        intent.putExtra(Constant.TOTAL_QUESTIONS, 5); // Truyền tổng số câu hỏi qua Intent
        intent.putExtra(Constant.TEST_TYPE, "Đếm hình"); // Truyền tên activity hiện tại qua Intent
        startActivity(intent);
    }
}
