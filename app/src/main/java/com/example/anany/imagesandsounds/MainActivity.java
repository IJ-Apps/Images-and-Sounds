package com.example.anany.imagesandsounds;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    Button btn;
    boolean image1Displaying = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "Press the image to change the image.", Toast.LENGTH_LONG).show();

        btn = findViewById(R.id.btn);
        img = findViewById(R.id.img);

        //Play the mp3 when the button is pressed
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.bell);
                mp.start();
            }
        });

        //Change the image when the imageView is touched
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(image1Displaying){
                    img.setImageResource(R.drawable.helmet);
                    image1Displaying = false;
                }else{
                    img.setImageResource(R.drawable.shield);
                    image1Displaying = true;
                }
                return false;
            }
        });

    }
}
