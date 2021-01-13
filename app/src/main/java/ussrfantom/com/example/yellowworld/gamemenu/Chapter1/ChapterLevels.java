package ussrfantom.com.example.yellowworld.gamemenu.Chapter1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import ussrfantom.com.example.yellowworld.R;
import ussrfantom.com.example.yellowworld.gamemenu.GameMenu;
import ussrfantom.com.example.yellowworld.gamemenu.GameWorld;
import ussrfantom.com.example.yellowworld.gamemenu.Winner;
import ussrfantom.com.example.yellowworld.gamemenu.WinnerAdapter;

public class ChapterLevels extends AppCompatActivity {

    private ArrayList<Levels> levels = new ArrayList<>();
    private RecyclerView recyclerViewLevels;
    Button buttonBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_levels);

        recyclerViewLevels = findViewById(R.id.recyclerViewLevels);
        buttonBack = findViewById(R.id.buttonBack);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.kolokol);

        String[] nameLevels = getResources().getStringArray(R.array.nameLevels);

        for (int i = 0; i < nameLevels.length; i++){
            levels.add(new Levels(nameLevels[i]));
        }

        LevelsAdapter levelsAdapter = new LevelsAdapter(levels);
        recyclerViewLevels.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewLevels.setAdapter(levelsAdapter);


        //Кнопка Назад
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.start();
                Intent intent = new Intent(ChapterLevels.this, GameWorld.class);
                startActivity(intent);
                finish();
            }

        });
        //Переходы на уровни
        levelsAdapter.setOnLevelsClickListener(new LevelsAdapter.OnLevelsClickListener() {
            @Override
            public void onLevelsClick(int position) {
                Toast.makeText(ChapterLevels.this, "click" + position, Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0:
                        mp3.start();
                        Intent intent = new Intent(ChapterLevels.this, Chapter1Level1.class);
                        startActivity(intent);
                        finish();
                }
            }
        });

    }

    //Системная кнопка назад
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ChapterLevels.this, GameWorld.class);
        startActivity(intent);
        finish();
    }
}