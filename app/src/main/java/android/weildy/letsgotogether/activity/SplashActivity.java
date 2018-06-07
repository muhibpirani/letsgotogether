package android.weildy.letsgotogether.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.weildy.letsgotogether.R;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private TextView txt_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        txt_name=(TextView)findViewById(R.id.txt_name);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);//Todo: add preference check if user already logged in
                startActivity(intent);
                finish();
            }
        },2000);
    }
}
