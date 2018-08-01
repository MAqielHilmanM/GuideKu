package guideku.bisfor.guideku.screen.chat.detail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import guideku.bisfor.guideku.R;

public class ChatDetailActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Toolbar toolbar;
    EditText etChatDetailText;
    ImageButton ibtnChatDetail;

    List<ChatDetailDao> list = new ArrayList<>();
    Context context;
    String chatName = "John Doe";
    String chatId = " ";

    public static final String EXTRA_TITLE = "EXTRA_TITLE";
    public static final String EXTRA_ID = "EXTRA_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_detail);

        initObject();

        initDummy();

        initAction();
    }

    private void initAction() {
        ibtnChatDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(etChatDetailText.getText()))
                    list.add(new ChatDetailDao("",false,etChatDetailText.getText().toString(),"00.00",""));
                adapter.notifyDataSetChanged();
                etChatDetailText.setText("");
                recyclerView.smoothScrollToPosition(list.size()-1);
            }
        });
    }

    private void initDummy() {
        list.clear();
        list.add(new ChatDetailDao("",false,"hai","00.00",""));
        list.add(new ChatDetailDao("",true,"hai juga","00.00",""));
        list.add(new ChatDetailDao("",false,"apa kabar?","00.00",""));
        list.add(new ChatDetailDao("",true,"baik","00.00",""));
        list.add(new ChatDetailDao("",false,"lul","00.00",""));
        adapter.notifyDataSetChanged();
    }

    private void initObject() {
        context = this;
        chatName = getIntent().getStringExtra(EXTRA_TITLE);
        chatId = getIntent().getStringExtra(EXTRA_ID);

        etChatDetailText = findViewById(R.id.etChatDetailText);
        ibtnChatDetail = findViewById(R.id.ibtnChatDetailSend);

        recyclerView = findViewById(R.id.rvChatDetail);
        adapter = new ChatDetailAdapter(list);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        toolbar = findViewById(R.id.toolbarChatDetail);
        setSupportActionBar(toolbar);
        toolbar.setTitle(chatName);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static void startActivity(Context context,String id,String title){
        Intent intent = new Intent(context,ChatDetailActivity.class);
        intent.putExtra(EXTRA_ID,id);
        intent.putExtra(EXTRA_TITLE,title);
        context.startActivity(intent);
    }
}
