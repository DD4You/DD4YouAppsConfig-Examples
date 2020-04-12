package in.dd4you.yt_p1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import in.dd4you.appsconfig.DD4YouConfig;

public class MainActivity extends AppCompatActivity {

    private DD4YouConfig dd4YouConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dd4YouConfig = new DD4YouConfig(this);
        final TextView textView1 = findViewById(R.id.textView1);
        final TextView textView2 = findViewById(R.id.textView2);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText(dd4YouConfig.generateRandomString(10));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(dd4YouConfig.generateUniqueID(10));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dd4YouConfig.isInternetConnectivity())
                {
                    Toast.makeText(MainActivity.this, "Mobile Data On", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Mobile Data off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
