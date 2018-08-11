package guideku.bisfor.guideku.screen.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import guideku.bisfor.guideku.R;
import guideku.bisfor.guideku.screen.chat.list.ChatListFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FloatingActionButton floatingActionButton;
    Context context;
    static FragmentManager manager;
    private String mName, mId;
    private Bundle mBundle;

    public static final String EXTRA_ID = "EXTRA_ID";
    public static final String EXTRA_NAME = "EXTRA_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initObject();

        initAction();
    }

    private void initAction() {
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.actHome:
                                Fragment mainFragment = new MainFragment();
                                mBundle.putString(EXTRA_ID, mId);
                                mBundle.putString(EXTRA_NAME, mName);
                                mainFragment.setArguments(mBundle);
                                changeFragment(mainFragment);
                                break;
                            case R.id.actChat:
                                Fragment chatFragment = new ChatListFragment();
                                mBundle.putString(EXTRA_ID, mId);
                                mBundle.putString(EXTRA_NAME, mName);
                                chatFragment.setArguments(mBundle);
                                changeFragment(chatFragment);
                                break;
                        }
                        return false;
                    }
                });
    }

    private void initObject() {
        bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bnvMain);
        floatingActionButton = findViewById(R.id.fabMain);
        context = this;
        mBundle = new Bundle();
        manager = getSupportFragmentManager();
        mName = getIntent().getStringExtra(EXTRA_NAME);
        mId = getIntent().getStringExtra(EXTRA_ID);


        Fragment mainFragment = new MainFragment();
        mBundle.putString(EXTRA_ID, mId);
        mBundle.putString(EXTRA_NAME, mName);
        mainFragment.setArguments(mBundle);
        changeFragment(mainFragment);
    }

    public static void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFrame, fragment).commit();
    }

    public static void startActivity(Context context, String id, String name) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(EXTRA_ID, id);
        intent.putExtra(EXTRA_NAME, name);
        context.startActivity(intent);
        ((Activity) context).finish();
    }
}
