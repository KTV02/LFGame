package com.example.lfgame;

import android.content.SharedPreferences;
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
    private Game game;
    private Values values;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String GOLD_AMOUNT = "goldAmount";
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
        values= new Values(this);
        game= new Game(this);
        setContentView(game);
        loadData();
    }
    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(GOLD_AMOUNT, Gold.getAmount());
        //editor.putInt(GOLD_AMOUNT, 123);
        //System.out.println(Gold.getAmount() + "save");
        editor.apply();
        editor.clear().apply();
        game.saveData();
    }
    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        //System.out.println(sharedPreferences.getInt(GOLD_AMOUNT, 100) + "load");
        Gold.setAmount(sharedPreferences.getInt(GOLD_AMOUNT, 200));
        game.loadData();
        //Gold.setAmount(200);
    }

    /**
     * returns value Object to access global variables
     * @return values Object
     */
    public Values getValues(){
        return values;
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
        saveData();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Log.d("Main.Activity.java","Back Button Pressed");
        game.spawnPopup(new ClosePopUp(game.getContext()));
    }

    @Override
    protected void onDestroy() {
        saveData();
        super.onDestroy();
    }

    /**
     * Minimizes the App
     * Gets called on Back Button popup
     * @author Lennart
     * @since 15.02
     */
    public void minimize(){
        this.moveTaskToBack(true);
    }
}

