package dra.com.mvvmpatternstudy.ViewModel;

import java.util.Observable;

public class ServerObservable extends Observable {
    public void action (String string) {
        setChanged();
        notifyObservers(string);
    }
}