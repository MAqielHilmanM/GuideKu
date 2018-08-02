package guideku.bisfor.guideku.screen.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import guideku.bisfor.guideku.R;
import guideku.bisfor.guideku.screen.chat.list.ChatListFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FloatingActionButton floatingActionButton;
    Context context;
    static FragmentManager manager;
    public static final String EXTRA_ID = "EXTRA_ID";

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
                                    changeFragment(mainFragment);
                               break;
                            case R.id.actChat:
                                    Fragment chatFragment = new ChatListFragment();
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
        manager = getSupportFragmentManager();

        changeFragment(new MainFragment());
    }

    public static void changeFragment(Fragment fragment){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFrame,fragment).commit();
    }

    public static void startActivity(Context context, String id){
        Intent intent = new Intent(context,MainActivity.class);
        intent.putExtra(EXTRA_ID,id);
        context.startActivity(intent);
        ((Activity)context).finish();
    }
}
