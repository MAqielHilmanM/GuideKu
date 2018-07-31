package guideku.bisfor.guideku.screen.register;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import guideku.bisfor.guideku.R;
import guideku.bisfor.guideku.screen.login.LoginActivity;
import guideku.bisfor.guideku.screen.main.MainActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText etRegisterUsername,etRegisterEmail,etRegisterPassword,etRegisterFName,etRegisterLName;
    Button btnRegister;
    TextView tvRegisterLogin;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initObject();
        initDummy();
        initAction();
    }

    private void initObject(){
        etRegisterEmail = findViewById(R.id.etRegisterEmail);
        etRegisterFName  = findViewById(R.id.etRegisterFName);
        etRegisterLName = findViewById(R.id.etRegisterLName);
        etRegisterPassword = findViewById(R.id.etRegisterPassword);
        etRegisterUsername = findViewById(R.id.etRegisterUsername);
        btnRegister = findViewById(R.id.btnRegister);
        tvRegisterLogin = findViewById(R.id.tvRegisterLogin);
        context = this;
    }

    private void initDummy(){
        etRegisterUsername.setText("johndoe");
        etRegisterPassword.setText("johndoe");
        etRegisterEmail.setText("johndoe@john.doe");
        etRegisterLName.setText("John");
        etRegisterFName.setText("Doe");
    }

    private void initAction(){
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.startActivity(context,"-");
            }
        });

        tvRegisterLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public static void startActivity(Context context){
        Intent intent = new Intent(context,RegisterActivity.class);
        context.startActivity(intent);
    }
}
