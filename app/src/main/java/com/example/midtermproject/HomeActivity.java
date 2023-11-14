package com.example.midtermproject;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TextView textViewquestion = findViewById(R.id.textQuestions);
        textViewquestion.setText("Güney Amerika kıtasında yer alan ve dünyaca ünlü Amazon yağmur ormanına ev sahipliği yapan bir ülkedir.");

        Button buttonA = findViewById(R.id.optionA);
        Button buttonB = findViewById(R.id.optionB);
        Button buttonC = findViewById(R.id.optionC);
        Button buttonD = findViewById(R.id.optionD);

        buttonA.setText("Brezilya");
        buttonB.setText("Arjantin");
        buttonC.setText("Kosta Rika");
        buttonD.setText("Meksika");

        TextView hinttextcontent = findViewById(R.id.hinttextcontent);
        hinttextcontent.setText("Dünyanın en büyük kahve üreticilerinden biridir.");

    }



}
