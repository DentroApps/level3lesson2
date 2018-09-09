package ru.dentro.geekbrains.levelthreelessontwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class EventBusActivity extends AppCompatActivity {

    private TextView tvFirst, tvSecond;
    private EditText etFirst, etSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);

        tvFirst = findViewById(R.id.tvFirst);
        tvSecond = findViewById(R.id.tvSecond);
        etFirst = findViewById(R.id.etFirst);
        etSecond = findViewById(R.id.etSecond);
    }
}
