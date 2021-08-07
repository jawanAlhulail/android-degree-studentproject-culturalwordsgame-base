package com.barmej.culturalwords;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class ShareActivity extends AppCompatActivity {
private int sharedImage;
EditText editText;
    int[] CulturalImages = {
            R.drawable.icon_1,
            R.drawable.icon_2,
            R.drawable.icon_3,
            R.drawable.icon_4,
            R.drawable.icon_5,
            R.drawable.icon_6,
            R.drawable.icon_7,
            R.drawable.icon_8,
            R.drawable.icon_9,
            R.drawable.icon_10,
            R.drawable.icon_11,
            R.drawable.icon_12,
            R.drawable.icon_13
    };
private ImageView culturalView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        editText = findViewById(R.id.edit_text_share_title);
        sharedImage = getIntent().getIntExtra("cultural_image", 0);
        Drawable drawable = ContextCompat.getDrawable(this, CulturalImages[sharedImage]);
        culturalView = findViewById(R.id.image_view_question);
        culturalView.setImageDrawable(drawable);
    }
    public void onShare(View view){
        String questionTitle = editText.getText().toString();

        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
        shareIntent.putExtra(Intent.EXTRA_TEXT, questionTitle);
        shareIntent.putExtra(Intent.EXTRA_TEXT, sharedImage);
        shareIntent.setType("*/*");
        startActivity(shareIntent);

        SharedPreferences sharedPreferences = getSharedPreferences("app_pref" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("share title", questionTitle);
        editor.apply();
    }
    public void back(View view){
        finish();
    }
}