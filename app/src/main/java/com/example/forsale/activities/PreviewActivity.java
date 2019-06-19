package com.example.forsale.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.forsale.R;

public class PreviewActivity extends AppCompatActivity {

    private ImageView pre_img;
    private TextView pre_title;
    private TextView pre_desc;
    private TextView pre_val;

    private Button btn_back_pesquisa;
    private Button btn_maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        pre_img = (ImageView) findViewById(R.id.imageViewPreImg);
        pre_title =  findViewById(R.id.textViewPreNome);
        pre_desc = findViewById(R.id.textViewPreDesc);
        pre_val = findViewById(R.id.textViewPreVal);

        btn_back_pesquisa = findViewById(R.id.buttonPreBack);
        btn_maps = findViewById(R.id.buttonMap);

        Intent pre_intent = getIntent();
        Bundle bundle = getIntent().getExtras();

        if (pre_intent != null) {
            int temp = bundle.getInt("img");

            pre_title.setText(pre_intent.getStringExtra("title"));
            pre_desc.setText(pre_intent.getStringExtra("desc"));
            pre_val.setText(pre_intent.getStringExtra("val"));
            pre_img.setImageResource(temp);
        }

        btn_back_pesquisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call_back();
            }
        });
        btn_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call_maps();
            }
        });
    }

    public void call_back() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void call_maps() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("google.navigation:q=-22.906903,-43.177486"));
        startActivity(intent);
    }
}
