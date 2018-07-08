package com.example.chalam.imgstrconv;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    TextView txt;
    Button imageToStr;
    Button strToImg;
    private byte[] array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView)findViewById(R.id.textView);
        imageToStr = (Button) findViewById(R.id.img2str);
        strToImg = (Button) findViewById(R.id.str2img);

        imageToStr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.benten);
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
                array = byteArrayOutputStream.toByteArray();
                String str = Base64.encodeToString(array,0);

                txt.setText(str.trim());
            }
        });
        strToImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText("");
                /*array = Base64.decode(array, 0);
                Bitmap decodedImage = BitmapFactory.decodeByteArray(array, 0, array.length);
                img.setImageBitmap(decodedImage);*/
            }
        });

    }
}
