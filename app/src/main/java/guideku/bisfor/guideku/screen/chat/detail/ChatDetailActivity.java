package guideku.bisfor.guideku.screen.chat.detail;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import guideku.bisfor.guideku.R;
import guideku.bisfor.guideku.api.BaseFirebase;
import guideku.bisfor.guideku.api.model.MessageModel;
import guideku.bisfor.guideku.utils.Tools;

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
    String chatImage = "";
    String chatUserId = "";

    public static final String EXTRA_TITLE = "EXTRA_TITLE";
    public static final String EXTRA_ID = "EXTRA_ID";
    public static final String TAG = "CHATDETAIL";
    public static final String EXTRA_URL = "EXTRA_URL";
    public static final String EXTRA_USERID = "EXTRA_USERID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_detail);

        initObject();

        initAction();

        callData(chatUserId,chatId,chatImage);
    }

    private void initAction() {
        ibtnChatDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(etChatDetailText.getText())) callAddData(chatId,chatUserId,etChatDetailText.getText().toString());
//                    list.add(new ChatDetailDao("",false,etChatDetailText.getText().toString(),"00.00",""));
//                adapter.notifyDataSetChanged();
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
        chatImage = getIntent().getStringExtra(EXTRA_URL);
        chatUserId = getIntent().getStringExtra(EXTRA_USERID);

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

    public static void startActivity(Context context, String id, String title, String urlImage, String userId){
        Intent intent = new Intent(context,ChatDetailActivity.class);
        intent.putExtra(EXTRA_ID,id);
        intent.putExtra(EXTRA_USERID,userId);
        intent.putExtra(EXTRA_TITLE,title);
        intent.putExtra(EXTRA_URL,urlImage);
        context.startActivity(intent);
    }

    private void callData(final String userId, String chatId, final String pic){
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        firestore.collection(BaseFirebase.KEY_CHAT).document(chatId).addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.w(TAG, "Listen failed.", e);
                    return;
                }

                if (documentSnapshot != null && documentSnapshot.exists()) {
                    Log.d(TAG, "Current data: " + documentSnapshot.getData());

                    documentSnapshot.getReference().collection(BaseFirebase.KEY_CHAT_MESSAGE).orderBy(BaseFirebase.KEY_CHAT_MESSAGE_DATE, Query.Direction.ASCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
                        @Override
                        public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                            if (e != null) {
                                Log.w(TAG, "Listen failed.", e);
                                return;
                            }
                            list.clear();
                            for (DocumentSnapshot doc : queryDocumentSnapshots.getDocuments()){
                                MessageModel model = doc.toObject(MessageModel.class);
                                list.add(new ChatDetailDao(doc.getId(),model.getBy() == userId ? false : true,model.getMessage(), Tools.dateTimeToTimeFormat(model.getDate()),pic));
                                recyclerView.smoothScrollToPosition(list.size()-1);
                            }
                            adapter.notifyDataSetChanged();
                        }
                    });
                } else {
                    Log.d(TAG, "Current data: null");
                }
            }
        });
    }

    private void callAddData(String chatId,String chatUserId,String message){
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        MessageModel messageModel = new MessageModel(chatUserId, new Date(),message,"sent");
        firestore.collection(BaseFirebase.KEY_CHAT).document(chatId).collection(BaseFirebase.KEY_CHAT_MESSAGE).document().set(messageModel);
    }
}
