package dra.com.mvvmpatternstudy.ViewModel;

import android.databinding.ObservableField;

import dra.com.mvvmpatternstudy.Model.SharedInstance;

public class MainViewModel implements BaseViewModel {

    private SharedInstance model;

    public final ObservableField<String> serverState = new ObservableField<>();

    public MainViewModel() {
        model = new SharedInstance();
    }

    @Override
    public void onCreate() {
        serverState.set("Ready");
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }
}
