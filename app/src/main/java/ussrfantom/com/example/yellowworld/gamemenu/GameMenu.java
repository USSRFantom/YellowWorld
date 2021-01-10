package ussrfantom.com.example.yellowworld.gamemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import ussrfantom.com.example.yellowworld.R;

public class GameMenu extends AppCompatActivity {

    Button buttonStart;
    Button buttonHints;
    Button buttonPastTheGame;
    Button buttonAssistanceToTheProject;
    Button buttonExit;
    private long backPressedTime;
    private Toast backToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.kolokol);

        startService(new Intent(this, MyService.class));

        buttonStart = findViewById(R.id.buttonStart);
        buttonHints = findViewById(R.id.buttonHints);
        buttonPastTheGame = findViewById(R.id.buttonPastTheGame);
        buttonAssistanceToTheProject = findViewById(R.id.buttonAssistanceToTheProject);
        buttonExit = findViewById(R.id.buttonExit);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.start();
                Intent intent = new Intent(GameMenu.this, GameWorld.class);
                startActivity(intent);
                finish();
            }
        });

        buttonHints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.start();
            }
        });
        // Кнопка прошедшие игру
        buttonPastTheGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.start();
                Intent intent = new Intent(GameMenu.this, PastTheGame.class);
                startActivity(intent);

            }
        });


        //Кнопка поддержать проект
        buttonAssistanceToTheProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.start();
                MyService.player.stop();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/public200716291"));
                startActivity(intent);
            }

        });

        //Кнопка выход
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.start();
                MyService.player.stop();
                GameMenu.super.onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            MyService.player.stop();
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}