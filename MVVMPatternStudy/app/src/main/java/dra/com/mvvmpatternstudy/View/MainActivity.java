package dra.com.mvvmpatternstudy.View;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dra.com.mvvmpatternstudy.R;
import dra.com.mvvmpatternstudy.ViewModel.MainViewModel;
import dra.com.mvvmpatternstudy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MainViewModel model = new MainViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setModel(model);

        model.onCreate();
        System.out.println("View 생성");
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

    /*
       SharedInstance.getInstance().setServerState(serverVal); // TODO 노티만 //완료

       //serverTv.setText(SharedInstance.getInstance().getServerStateText()); // TODO MVVM 적용해서 UI 갱신 되도록 // 완료

    */
}
