package com.example.abhim.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        button2= (Button)findViewById(R.id.button2);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //Intent for Gallery
            Intent i = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i,101);

        }
    });

     button2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             //Intent for Camera
             Intent u = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
             startActivityForResult(u,102);

         }
     });





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

       if(requestCode==101) {
           ImageView imageView = (ImageView) findViewById(R.id.imageView);
           //Uri is the pat
           Uri u = data.getData();
           imageView.setImageURI(u);
       }

        if (requestCode==102)
        {
            ImageView imageView = (ImageView)findViewById(R.id.imageView);
            Bitmap bit = (Bitmap)data.getExtras().get("data");
            imageView.setImageBitmap(bit);
        }

    }
}
