package guideku.bisfor.guideku.screen.register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import guideku.bisfor.guideku.R;
import guideku.bisfor.guideku.screen.main.MainActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText etRegisterUsername, etRegisterEmail, etRegisterPassword, etRegisterFName, etRegisterLName;
    Button btnRegister;
    TextView tvRegisterLogin;
    Context context;

    private FirebaseAuth mAuth;
    public static final String TAG = "REGISTERACT";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initObject();
        initDummy();
        initAction();
    }

    private void initObject() {
        etRegisterEmail = findViewById(R.id.etRegisterEmail);
        etRegisterFName = findViewById(R.id.etRegisterFName);
        etRegisterLName = findViewById(R.id.etRegisterLName);
        etRegisterPassword = findViewById(R.id.etRegisterPassword);
        etRegisterUsername = findViewById(R.id.etRegisterUsername);
        btnRegister = findViewById(R.id.btnRegister);
        tvRegisterLogin = findViewById(R.id.tvRegisterLogin);
        mAuth = FirebaseAuth.getInstance();
        context = this;
    }

    private void initDummy() {
        etRegisterUsername.setText("johndoe");
        etRegisterPassword.setText("johndoe");
        etRegisterEmail.setText("johndoe@john.doe");
        etRegisterLName.setText("John");
        etRegisterFName.setText("Doe");
    }

    private void initAction() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValid()) {
                    mAuth.createUserWithEmailAndPassword(etRegisterEmail.getText().toString(), etRegisterPassword.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "createUserWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        MainActivity.startActivity(context,user.getUid());
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(context, "Register failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }

            }
        });

        tvRegisterLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }

    private boolean isValid() {
        String message = "Please fill all form";

        if (TextUtils.isEmpty(etRegisterFName.getText())) {
            Toast.makeText(context, "Please fill First Name", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(etRegisterLName.getText())) {
            Toast.makeText(context, "Please fill Last Name", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(etRegisterUsername.getText())) {
            Toast.makeText(context, "Please fill Username", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(etRegisterEmail.getText())) {
            Toast.makeText(context, "Please fill Email", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(etRegisterPassword.getText())) {
            Toast.makeText(context, "Please fill Password", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;

    }
}
