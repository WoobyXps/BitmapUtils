package com.qh.bitmaputils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BitmapDrawable drawable = (BitmapDrawable) getResources().getDrawable(R.drawable.rg);
        bitmap2MD5(drawable);
        drawable = (BitmapDrawable)getResources().getDrawable(R.drawable.rg2);
        bitmap2MD5(drawable);
        drawable = (BitmapDrawable)getResources().getDrawable(R.drawable.rg3);
        bitmap2MD5(drawable);
    }

    private void bitmap2MD5(BitmapDrawable drawable) {
        Bitmap bitmap = drawable.getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        String string = MD5.getMD5Code(baos.toByteArray());
        Log.d("qh", "MD5 string : " + string);
    }

}
