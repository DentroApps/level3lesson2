package ru.dentro.geekbrains.levelthreelessontwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class EventBusActivity extends AppCompatActivity{

    private TextView tvFirst, tvSecond;
    private EditText etFirst, etSecond;
    private EventBus bus;
    private Observer<Object> observer, observer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);

        bus = new EventBus();

        initUI();

        bus.toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    private void initUI(){
        observer = new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                if (o.hashCode() == etFirst.getEditableText().hashCode())
                    tvFirst.setText(o.toString());
                else if (o.hashCode() == etSecond.getEditableText().hashCode())
                    tvSecond.setText(o.toString());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        tvFirst = findViewById(R.id.tvFirst);
        tvSecond = findViewById(R.id.tvSecond);
        etFirst = findViewById(R.id.etFirst);
        etSecond = findViewById(R.id.etSecond);
        etFirst.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                bus.send(s);
            }
        });
        etSecond.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                bus.send(s);
            }
        });
    }

}
