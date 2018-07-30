package guideku.bisfor.guideku.screen.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import guideku.bisfor.guideku.R;
import guideku.bisfor.guideku.screen.main.MainActivity;
import guideku.bisfor.guideku.screen.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {
    EditText etLoginEmail,etLoginPassword;
    Button btnLogin,btnLoginGoogle;
    Context context;
    TextView tvLoginRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initObject();

        initDummy();

        initAction();
    }

    void initObject(){
        etLoginEmail = findViewById(R.id.etLoginEmail);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLoginGoogle = findViewById(R.id.btnLoginGoogle);
        tvLoginRegister = findViewById(R.id.tvLoginRegister);

        context = this;
    }

    void initDummy(){
        etLoginEmail.setText("johndoe@john.doe");
        etLoginPassword.setText("johndoe");
    }

    void initAction(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etLoginEmail.getText().toString();
                String password = etLoginPassword.getText().toString();

                if(email.equals("johndoe@john.doe") && password.equals("johndoe")){
                    MainActivity.startActivity(context,"-");
                }
            }
        });

        tvLoginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterActivity.startActivity(context);
            }
        });
    }

    public static void startActivity(Context context){
        Intent intent = new Intent(context,LoginActivity.class);
        context.startActivity(intent);
        ((Activity)context).finish();
    }
}
