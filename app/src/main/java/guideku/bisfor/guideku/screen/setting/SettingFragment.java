package guideku.bisfor.guideku.screen.setting;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import guideku.bisfor.guideku.R;
import guideku.bisfor.guideku.screen.login.LoginActivity;
import guideku.bisfor.guideku.screen.profile.ProfileActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {
    Button btnSettingLogout,btnSettingEdit;
    private FirebaseAuth mAuth;
    private Context mContext;

    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_setting, container, false);

        initObject(v);

        initAction();

        return v;
    }

    private void initAction() {
        btnSettingEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProfileActivity.startActivity(getContext(),"");
            }
        });

        btnSettingLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                LoginActivity.startActivity(getContext());
            }
        });
    }

    private void initObject(View v) {
        btnSettingEdit = v.findViewById(R.id.btnSettingEditProfile);
        btnSettingLogout = v.findViewById(R.id.btnSettingLogout);
        mAuth = FirebaseAuth.getInstance();
        mContext = getContext();
    }

}
