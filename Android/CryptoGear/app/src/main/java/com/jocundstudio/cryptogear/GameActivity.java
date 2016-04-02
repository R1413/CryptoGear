package com.jocundstudio.cryptogear;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by josecanizares on 3/25/16.
 */
public class GameActivity extends Activity {

    GameView v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        v = new GameView(GameActivity.this);
        setContentView(v);

    }




}
