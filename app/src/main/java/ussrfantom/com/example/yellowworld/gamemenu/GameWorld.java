package ussrfantom.com.example.yellowworld.gamemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import ussrfantom.com.example.yellowworld.R;

public class GameWorld extends AppCompatActivity {

    Button buttonChapter1;
    Button buttonChapter2;
    Button buttonChapter3;
    Button buttonBack;

    public static int gameWorld = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_world);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.kolokol);

        buttonChapter1 = findViewById(R.id.buttonChapter1);
        buttonChapter2 = findViewById(R.id.buttonChapter2);
        buttonChapter3 = findViewById(R.id.buttonChapter3);
        buttonBack = findViewById(R.id.buttonBack);
        //установка картинок на кнопки
        switch (gameWorld){
            case 1:
                buttonChapter1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.iconmenu1, 0, 0, 0);
                buttonChapter2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.iconmenu7, 0, 0, 0);
                buttonChapter3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.iconmenu7, 0, 0, 0);
                break;
            case 2:
                buttonChapter1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.iconmenu1, 0, 0, 0);
                buttonChapter2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.iconmenu1, 0, 0, 0);
                buttonChapter3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.iconmenu7, 0, 0, 0);
                break;
            case 3:
                buttonChapter1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.iconmenu1, 0, 0, 0);
                buttonChapter2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.iconmenu1, 0, 0, 0);
                buttonChapter3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.iconmenu1, 0, 0, 0);
                break;
        }

        //Глава 1
        buttonChapter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.start();
                MyService.player.stop();
                if (gameWorld == 1){
                    Toast.makeText(GameWorld.this, "Уровень открыт", Toast.LENGTH_SHORT).show();
                }

            }
        });


        //Глава 2
        buttonChapter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.start();
                MyService.player.stop();
                if (gameWorld >= 2){
                    Toast.makeText(GameWorld.this, "Уровень открыт", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(GameWorld.this, "Уровень закрыт", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //глава 3
        buttonChapter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.start();
                MyService.player.stop();
                if (gameWorld == 3){
                    Toast.makeText(GameWorld.this, "Уровень открыт", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(GameWorld.this, "Уровень закрыт", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Кнопка Назад
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.start();
                Intent intent = new Intent(GameWorld.this, GameMenu.class);
                startActivity(intent);
                finish();
            }
        });



    }

    //Системная кнопка назад
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(GameWorld.this, GameMenu.class);
        startActivity(intent);
        finish();
    }

}