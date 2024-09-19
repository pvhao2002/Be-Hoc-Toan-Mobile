package eaut.myapp.behoctoan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // Nút quay lại
        ImageView btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> finish());
        // Nut dem hinh
        Button btndemhinh = findViewById(R.id.demhinh);
        btndemhinh.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, Demhinh1.class);
            startActivity(intent);
        });
        // Nút Tính nhẩm
        Button btnTinhNham = findViewById(R.id.btn_tinh_nham);
        btnTinhNham.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, TinhNhamActivity.class);
            startActivity(intent);
        });

        // Nút So sánh
        Button btnSoSanh = findViewById(R.id.btn_so_sanh);
        btnSoSanh.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, SoSanhActivity.class);
            startActivity(intent);
        });
        Button btnKiemtra = findViewById(R.id.kiemtra);
        btnKiemtra.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, kiemtra.class);
            startActivity(intent);
        });

        Button btnKetQua = findViewById(R.id.result);
        btnKetQua.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, ResultActivity.class);
            startActivity(intent);
        });
    }
}