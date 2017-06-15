package com.microsoft.darksage.enabler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent in = new Intent(this, MyAccessibilityService.class);
        this.startService(in);
        Log.v("In accessibility", "Started Accessibility");
    }
}
