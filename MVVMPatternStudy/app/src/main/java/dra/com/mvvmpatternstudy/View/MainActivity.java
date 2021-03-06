package dra.com.mvvmpatternstudy.View;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Observer;

import dra.com.mvvmpatternstudy.R;
import dra.com.mvvmpatternstudy.ViewModel.MainViewModel;
import dra.com.mvvmpatternstudy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Observable observable;

    private MainViewModel model = new MainViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setModel(model);

        model.onCreate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        model.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        model.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        model.onDestroy();
    }


    @Override
    public void onClick(View view) {

        switch ( view.getId() ) {
            case R.id.btn_server_change :
                serverStateChange(SharedInstance.getInstance().getServerState());
        }
    }
    /*

    public void serverStateChange(int serverVal) {
        if (serverVal == 0) {
            serverVal = 1;
        }
        else {
            serverVal = 0;
        }

        SharedInstance.getInstance().setServerState(serverVal); // TODO 노티만

        //serverTv.setText(SharedInstance.getInstance().getServerStateText()); // TODO MVVM 적용해서 UI 갱신 되도록
    }
    */
}
