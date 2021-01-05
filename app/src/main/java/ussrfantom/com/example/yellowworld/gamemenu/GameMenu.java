package ussrfantom.com.example.yellowworld.gamemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import ussrfantom.com.example.yellowworld.Elevator;
import ussrfantom.com.example.yellowworld.R;

public class GameMenu extends AppCompatActivity {

    Button buttonStart;
    Button buttonHints;
    Button buttonPastTheGame;
    Button buttonAssistanceToTheProject;
    Button buttonExit;





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
                Intent intent = new Intent(GameMenu.this, Elevator.class);
                startActivity(intent);
                MyService.player.stop();
                finish();
            }
        });

        buttonHints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.start();
            }
        });

        buttonPastTheGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.start();
            }
        });

        buttonAssistanceToTheProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3.start();
            }
        });

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startService(new Intent(GameMenu.this, MyService2.class));
               mp3.start();
            }
        });


    }




}