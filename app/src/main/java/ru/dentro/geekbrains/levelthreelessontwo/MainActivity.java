package ru.dentro.geekbrains.levelthreelessontwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextSetter {

    private EditText etTextInput;
    private TextView twTextOutput;
    private TextStreamHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTextInput = findViewById(R.id.etTextInput);
        twTextOutput = findViewById(R.id.twTextOutput);
        etTextInput.addTextChangedListener(inputListener);

        handler = new TextStreamHandler(this);
    }

    private TextWatcher inputListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public void setText(String s) {
        twTextOutput.setText(s);
    }
}
