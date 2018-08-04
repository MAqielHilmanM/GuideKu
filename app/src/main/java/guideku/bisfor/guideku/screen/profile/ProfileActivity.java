package guideku.bisfor.guideku.screen.profile;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import guideku.bisfor.guideku.R;

public class ProfileActivity extends AppCompatActivity {
    EditText etProfileName,etProfileEmail,etProfilePhone;
    TextView tvProfileSave;
    Context context;
    public static final String EXTRA_ID = "EXTRA_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initObject();

        initDummy();

    }

    private void initDummy() {
        etProfilePhone.setText("081212121212");
        etProfileName.setText("John Doe");
        etProfileEmail.setText("johndoe@gmail.com");
    }

    private void initObject() {
        etProfileName = findViewById(R.id.etProfileName);
        etProfileEmail = findViewById(R.id.etProfileEmail);
        etProfilePhone = findViewById(R.id.etProfilePhoneNumber);
        tvProfileSave = findViewById(R.id.tvProfileSave);
        context = this;
    }

    public static void startActivity(Context context, String id){
        Intent intent = new Intent(context,ProfileActivity.class);
        intent.putExtra(EXTRA_ID,id);
        context.startActivity(intent);
    }
}
