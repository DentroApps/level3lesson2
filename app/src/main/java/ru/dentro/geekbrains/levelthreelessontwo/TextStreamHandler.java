package ru.dentro.geekbrains.levelthreelessontwo;

import android.util.Log;

import io.reactivex.Observable;

public class TextStreamHandler {

    private TextReceiver receiver;

    public TextStreamHandler(TextReceiver receiver){
        this.receiver = receiver;
    }

    public void emitText (Observable<String> obsString){
        obsString
                .doOnError(e -> Log.d("ERROR", e.getMessage()))
                .subscribe(text -> receiver.onTextReceived(text));
    }

}
