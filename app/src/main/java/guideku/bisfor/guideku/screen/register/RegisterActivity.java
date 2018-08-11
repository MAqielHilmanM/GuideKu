package guideku.bisfor.guideku.screen.register;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.GeoPoint;

import java.util.ArrayList;
import java.util.Date;

import guideku.bisfor.guideku.R;
import guideku.bisfor.guideku.api.BaseFirebase;
import guideku.bisfor.guideku.api.model.UserModel;
import guideku.bisfor.guideku.screen.main.MainActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText etRegisterUsername, etRegisterEmail, etRegisterPassword, etRegisterFName, etRegisterLName;
    Button btnRegister;
    TextView tvRegisterLogin;
    Context context;
    private Location mLocation;
    private FusedLocationProviderClient mFusedLocationClient;
    private FirebaseFirestore mFirestore;

    private FirebaseAuth mAuth;
    public static final String TAG = "REGISTERACT";
    public static final int REQUEST_CODE_LOCATION = 99;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initObject();
        initDummy();
        initAction();
        getLastKnowLocation();
    }

    private void getLastKnowLocation() {
        if (checkPermission())
            mFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // Got last known location. In some rare situations this can be null.
                            if (location != null) {
                                // Logic to handle location object
                                mLocation = location;
                            }
                        }
                    });
    }

    private boolean checkPermission() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED;
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
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mLocation = new Location("");
        mFirestore = FirebaseFirestore.getInstance();
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
                                        sendRegister(user.getUid());
                                        MainActivity.startActivity(context, user.getUid(),user.getDisplayName());
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

    private void sendRegister(String uId) {
        UserModel userModel = new UserModel(
                new Date(),
                etRegisterEmail.getText().toString(),
                "-",
                0,
                new GeoPoint(mLocation.getLatitude(), mLocation.getLongitude()),
                0,
                etRegisterFName.getText().toString() + " " + etRegisterLName.getText().toString(),
                "",
                0,
                new ArrayList<String>(),
                "",
                etRegisterUsername.getText().toString());
        mFirestore.collection(BaseFirebase.KEY_USER).document(uId).set(userModel);
    }

    private void requestPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        REQUEST_CODE_LOCATION);
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    getLastKnowLocation();
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }
}
