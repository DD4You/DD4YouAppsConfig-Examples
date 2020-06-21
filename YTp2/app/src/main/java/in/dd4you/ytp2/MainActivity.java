package in.dd4you.ytp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;

import in.dd4you.appsconfig.DD4YouNetReceiver;

public class MainActivity extends AppCompatActivity {
    private DD4YouNetReceiver dd4YouNetReceiver;
    private ViewGroup myRootView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get Root View Current Activity
        myRootView = findViewById(R.id.myRootView);

        registerBroadcastReceiver();
    }

    private void registerBroadcastReceiver() {
        if (dd4YouNetReceiver == null)
            dd4YouNetReceiver = new DD4YouNetReceiver(myRootView,1000);
        dd4YouNetReceiver.register(this.getApplicationContext());
    }
    private void unregisterBroadcastReceiver() {
        if (dd4YouNetReceiver != null)
        {
            dd4YouNetReceiver.unregister(this.getApplicationContext());
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        unregisterBroadcastReceiver();
    }
    @Override
    protected void onResume() {
        super.onResume();
        registerBroadcastReceiver();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterBroadcastReceiver();
    }
}
