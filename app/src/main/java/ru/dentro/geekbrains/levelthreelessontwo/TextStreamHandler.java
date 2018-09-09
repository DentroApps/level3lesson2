package ru.dentro.geekbrains.levelthreelessontwo;

import io.reactivex.Observable;

public class TextStreamHandler {

    private TextReceiver receiver;

    public TextStreamHandler(TextReceiver receiver){
        this.receiver = receiver;
    }

    public void emitText (Observable<String> obsString){
        obsString.subscribe(text -> receiver.onTextReceived(text));
    }

}
