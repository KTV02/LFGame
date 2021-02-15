package com.example.lfgame;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This Class (Main Activity ) is the Entry Point of Application
 */

public class MainActivity extends AppCompatActivity {
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //set Window to fullscreen
        Window window = getWindow();
        window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        //content view set to GAME so its objects can be rendered
        game= new Game(this);
        setContentView(game);




    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("MainActivity.java","onPause()");
        game.pause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        game.spawnPopup(new ClosePopUp(game.getContext(),this));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

