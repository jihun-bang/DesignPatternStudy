package dra.com.mvvmpatternstudy.ViewModel;

import java.util.Observable;

public class BaseObservable extends Observable {

    public void action (Object obj) {
        setChanged();
        notifyObservers(obj);
    }
}
