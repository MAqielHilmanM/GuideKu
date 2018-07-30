package guideku.bisfor.guideku.screen.splash;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import guideku.bisfor.guideku.R;
import guideku.bisfor.guideku.screen.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                LoginActivity.startActivity(context);
            }
        }, 3000L); //3000 L = 3 detik
    }
}
