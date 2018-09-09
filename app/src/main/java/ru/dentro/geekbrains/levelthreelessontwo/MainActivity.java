package ru.dentro.geekbrains.levelthreelessontwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements TextReceiver, View.OnClickListener {

    private EditText etTextInput;
    private TextView twTextOutput;
    private TextStreamHandler handler;
    private Observable<String> obsText;
    private Button btnEventbus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTextInput = findViewById(R.id.etTextInput);
        twTextOutput = findViewById(R.id.twTextOutput);
        etTextInput.addTextChangedListener(inputListener);
        btnEventbus = findViewById(R.id.btnEventBus);
        btnEventbus.setOnClickListener(this);

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
            obsText = Observable.just(s.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
            handler.emitText(obsText); // Можно обойтись и без Rx, но не зря же мы его проходим
        }
    };

    @Override
    public void onTextReceived(String s) {
        twTextOutput.setText(s);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, EventBusActivity.class));
    }
}
