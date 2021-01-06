package ussrfantom.com.example.yellowworld.gamemenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

import ussrfantom.com.example.yellowworld.R;

public class PastTheGame extends AppCompatActivity {

    private  FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_the_game);
        db = FirebaseFirestore.getInstance();

        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(PastTheGame.this, "Получена", Toast.LENGTH_SHORT).show();
                            QuerySnapshot querySnapshot = task.getResult();
                            if (querySnapshot == null) return;
                            for (QueryDocumentSnapshot documentSnapshot : querySnapshot){
                                  Map<String, Object> user =  documentSnapshot.getData();
                                  Log.i("12312312312312", user.get("name").toString());
                                Log.i("12312312312312", user.get("number").toString());
                            }
                        } else {
                            Toast.makeText(PastTheGame.this, "Ошибка" , Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}