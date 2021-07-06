package com.barmej.culturalwords;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {
private TextView mCurrentTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        mCurrentTextView = findViewById(R.id.text_view_answer);
        String answer = getIntent().getStringExtra("answer_name");

        String answerDesc = getIntent().getStringExtra("answer_desc");
        if(answer != null){mCurrentTextView.setText(answer + "\n" + answerDesc);}
    }

    public void back(View view){
        finish();
    }
}