package com.microsoft.darksage.enabler;

import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * Created by takheman on 6/15/2017.
 */

public class Utilities {
    private static final Utilities ourInstance = new Utilities();

    public static Utilities getInstance() {
        return ourInstance;
    }

    private Utilities() {
    }


    public static void takeScreenShot( Window window)
    {

        Date now = new Date();
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);
        String mPath = "";
        try {
            // image naming and path  to include sd card  appending name you choose for file
            File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File file = new File(path, "test.jpg");

            path.mkdirs();

            // create bitmap screen capture
            View v1 = window.getDecorView().getRootView();
            v1.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
            v1.setDrawingCacheEnabled(false);


            FileOutputStream outputStream = new FileOutputStream(file);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();

            Log.d("Screenshot saved","in function takeScreenShot");


        } catch (Throwable e) {
            // Several error may come out with file handling or OOM
            e.printStackTrace();
            Log.d("Screenshot path", mPath);
            Log.d("Screenshot not saved",e.getMessage());
        }
    }
}
