package com.example.midtermproject;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class HomeActivity extends AppCompatActivity {

    private String[] questions = {
            "1. Victoria Gölü kıyısında bulunan, ulaşımı genellikle tekneyle sağlanan bu ülke hangisidir?",
            "2. Dünyaca ünlü Amazon yağmur ormanına ev sahipliği yapan bir ülkedir.",
            "3. İskandinavya Yarımadası üzerinde yer alan  Dünyanın en büyük çölü olarak kabul edilen Atacama Çölü'ne ev sahipliği yapan ülke hangisidir?",
            "4. Hint Okyanusu'nda, Madagaskar'ın doğusunda yer alan ve tamamen resiflerle çevrili olan bu ada ülkesi nedir?",
            "5. Akdeniz kıyısında bulunan ve antik dönemde önemli bir liman şehri olan bu ülke, tarihi ve kültürel zenginlikleriyle bilinir. Hangi ülke?",
            "6. Malay Yarımadası'nın güney ucunda yer alan ve tarihi bir ticaret merkezi olan bu ülke hangisidir?",
            "7. Büyük Okyanus ve Karayip Denizi arasında yer alan bu ülke, tarihi Maya uygarlığına ev sahipliği yapmıştır. Hangi ülke?",
            "8. Karayip Denizi kıyısında yer alan ve ünlü kumsallarıyla bilinen bu ülke hangisidir?",
            "9. Tien Shan Dağları'nın eteklerinde bulunan ve tarihi İpek Yolu'nun geçtiği bu ülke hangisidir?",
            "10. Adriyatik Denizi kıyısında yer alan bu ülke, tarihi şehirleri ve dağlık manzaralarıyla ünlüdür. Hangi ülke?",
    };

    private String[][] options = {
            {"Kenya","Uganda","Tanzanya","Ruanda"},
            {"Brezilya", "Arjantin", "Kosta Rika", "Meksika"},
            {"Norveç", "İsveç", "Finlandiya", "İzlanda"},
            {"Maldivler", "Mauritius", "Seyşeller", "Komorlar"},
            {"Lübnan", "Suriye", "Ürdün", "Mısır"},
            {"Singapur", "Malezya", "Endonezya", "Tayland"},
            {"Guatemala", "Meksika", "Honduras", "Belize"},
            {"Bahamalar", "Jamaika", "Trinidad ve Tobago", "Barbados"},
            {"Kırgızistan", "Özbekistan", "Kazakistan", "Türkmenistan"},
            {"Hırvatistan", "Bosna-Hersek", "Arnavutluk", "Karadağ"},
    };

    private String[] correctAnswers = {"Uganda","Brezilya", "İzlanda", "Seyşeller",
            "Lübnan","Singapur","Guatemala","Jamaika"," Kırgızistan","Karadağ"};

    private String[][] Hint = {
            {"Başkenti Kampala'dır.","Yüz ölçümü 241.038 km²'dir.","Afrika kıtasındadir.","Para birimi Uganda Şilini'dir.","Resmi dili Svahili'dir."},
            {"Başkenti Brasília'dir", "Yüz ölçümü 8.510.000 km²'dir", "Güney Amerika kıtasındadır.", "Para birimi Brezilya reali'dir", "Resmi dili Portekizce'dir"},
            {"Başkenti Reykjavik'dir.", "Yüz ölçümü 103.000 km²'dir", "Avrupa kıtasındadır.", "Para birimi İzlanda Kronu'dur.","Resmi dili İzlandaca'dır."},
            {"Başkenti Victoria'dır.", "Yüz ölçümü 455 km²^dir", "Afrika kıtasındadır.", "Para birimi Seyşeller Rupisi'dir","Resmi dilleri Fransızca,İngilizce,Seyşeller Kreyolu"},
            {"Başkenti Beyrut'dur.", "Yüz ölçümü 10.452 km²'dir", "Asya kıtasındadır", "Para birimi Lübnan Lirası'dır","Resmi dili Arapç'dır."},
            {"Başkenti Singapur'dur", "Yüz ölçümü 734,3 km²'dir.", "Asya kıtasındadır.", "Para birimi Singapur doları'dır.","Resmi dilleri İngilizce, Malayca, Çince, Tamilce'dir."},
            {"Başkenti Guatemala'dır.", "Yüz ölçümü 108.888 km²'dir.", "Kuzey Amerika kıtasındadır.", "Para birimi Guatemala Quetzalı'dır.","Resmi dili İspanyolca'dır."},
            {"Başkenti Kingston'dır.", "Yüz ölçümü 10.991 km²'dir.", "Kuzey Amerika kıtasındadır.", "Para birimi Jamaika Doları'dır.","Resmi dili İngilizce'dir."},
            {"Başkenti Biškek'dir.", "Yüz ölçümü 199.900 km²'dir", "Asya kıtasındadır", "Para birimi Kırgızistan Somu'dur.","Resmi dili Kırgızca'dır."},
            {"Başkenti Podgoritsa'dır.", "Yüz ölçümü 13.812 km²'dır", "Avrupa kıtasındadır.", "Para birimi Euro'dur.","Resmi dili Karadağca'dır."},
    };

    private int currentQuestionIndex = 0;

    private  int score=0;
    private  int wrongAnswer= 3;
    private int hintIndex = 0;
    ImageView exitGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exitGame = findViewById(R.id.exit);

        TextView textViewquestion = findViewById(R.id.textQuestions);
        textViewquestion.setText("Başla");

        Button buttonA = findViewById(R.id.optionA);
        Button buttonB = findViewById(R.id.optionB);
        Button buttonC = findViewById(R.id.optionC);
        Button buttonD = findViewById(R.id.optionD);

        buttonA.setText("A");
        buttonB.setText("B");
        buttonC.setText("C");
        buttonD.setText("D");
    }

    private void updateQuestion() {

        TextView textViewquestion = findViewById(R.id.textQuestions);
        textViewquestion.setText(questions[currentQuestionIndex]);

        Button buttonA = findViewById(R.id.optionA);
        Button buttonB = findViewById(R.id.optionB);
        Button buttonC = findViewById(R.id.optionC);
        Button buttonD = findViewById(R.id.optionD);

        buttonA.setText(options[currentQuestionIndex][0]);
        buttonB.setText(options[currentQuestionIndex][1]);
        buttonC.setText(options[currentQuestionIndex][2]);
        buttonD.setText(options[currentQuestionIndex][3]);

        buttonA.setBackgroundColor(Color.parseColor("#C3287A"));
        buttonB.setBackgroundColor(Color.parseColor("#C3287A"));
        buttonC.setBackgroundColor(Color.parseColor("#C3287A"));
        buttonD.setBackgroundColor(Color.parseColor("#C3287A"));

        TextView gameScore = findViewById(R.id.score);
        gameScore.setText(String.valueOf(score));

        TextView hinttextcontent = findViewById(R.id.hinttextcontent);
        hinttextcontent.setText("?");
        hintIndex = 0;

        setİsClick();

    }

    public void setİsNotClick(){
        Button buttonA = findViewById(R.id.optionA);
        Button buttonB = findViewById(R.id.optionB);
        Button buttonC = findViewById(R.id.optionC);
        Button buttonD = findViewById(R.id.optionD);

        buttonA.setClickable(false);
        buttonB.setClickable(false);
        buttonC.setClickable(false);
        buttonD.setClickable(false);
    }

    public void setİsClick(){
        Button buttonA = findViewById(R.id.optionA);
        Button buttonB = findViewById(R.id.optionB);
        Button buttonC = findViewById(R.id.optionC);
        Button buttonD = findViewById(R.id.optionD);

        buttonA.setClickable(true);
        buttonB.setClickable(true);
        buttonC.setClickable(true);
        buttonD.setClickable(true);
    }



    public  void exitGame(View view){
        exitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //Activity'yi sonlandırmak için kullanılır.
            }
        });
    }


    public void startGame(View view){
        updateQuestion();
    }

    public void nextQuestion(View view){

        currentQuestionIndex++;
        if (currentQuestionIndex < questions.length) {
            updateQuestion();
            }
        else {

        }
    }

    public void  optionA(View view){

        int selectedButtonId = view.getId();
        Button selectedButton = findViewById(selectedButtonId);
        String userAnswer = selectedButton.getText().toString();

        if (userAnswer.equals(correctAnswers[currentQuestionIndex])) {
            incScore();
            selectedButton.setBackgroundColor(Color.parseColor("#008000"));
            updateScore();
            setİsNotClick();

        } else {
            selectedButton.setBackgroundColor(Color.parseColor("#FF0000"));
            decScore();
            checkWrongAnswer(selectedButton);
            updateScore();

        }
    }


    public void updateScore(){
        TextView gameScore = findViewById(R.id.score);
        gameScore.setText(String.valueOf(score));
    }


    public void  optionB(View view){

        int selectedButtonId = view.getId();
        Button selectedButton = findViewById(selectedButtonId);
        String userAnswer = selectedButton.getText().toString();

        if (userAnswer.equals(correctAnswers[currentQuestionIndex])) {
            incScore();
            selectedButton.setBackgroundColor(Color.parseColor("#008000"));
            updateScore();
            setİsNotClick();

        } else {
            selectedButton.setBackgroundColor(Color.parseColor("#FF0000"));
            decScore();
            checkWrongAnswer(selectedButton);
            updateScore();

        }

    }


    public void optionC(View view){

        int selectedButtonId = view.getId();
        Button selectedButton = findViewById(selectedButtonId);
        String userAnswer = selectedButton.getText().toString();

        if (userAnswer.equals(correctAnswers[currentQuestionIndex])) {
            incScore();
            selectedButton.setBackgroundColor(Color.parseColor("#008000"));
            updateScore();
            setİsNotClick();


        } else {
            selectedButton.setBackgroundColor(Color.parseColor("#FF0000"));
            decScore();
            checkWrongAnswer(selectedButton);
            updateScore();


        }
    }


    public void  optionD(View view){

        int selectedButtonId = view.getId();
        Button selectedButton = findViewById(selectedButtonId);
        String userAnswer = selectedButton.getText().toString();

        if (userAnswer.equals(correctAnswers[currentQuestionIndex])) {
            incScore();
            selectedButton.setBackgroundColor(Color.parseColor("#008000"));
            updateScore();


        } else {
            selectedButton.setBackgroundColor(Color.parseColor("#FF0000"));
            decScore();
            checkWrongAnswer(selectedButton);
            updateScore();
        }

    }


    public void incScore(){
        score+=3;
    }

    public void decScoreWithHint(){
        score-=1;
    }
    public void decScore(){
        wrongAnswer-=1;
        score-=1;
    }



    public void getHint(View view){
        TextView hinttextcontent = findViewById(R.id.hinttextcontent);
        if (hintIndex < Hint[currentQuestionIndex].length) {
            hinttextcontent.setText(Hint[currentQuestionIndex][hintIndex]);
            hintIndex++;
            decScoreWithHint();
            updateScore();
        } else {
            hinttextcontent.setText("Başka ipucu yok!");
        }
    }

    public void getScore(View view){


    }



    private void showCustomAlertDialog(String title, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View customLayout = getLayoutInflater().inflate(R.layout.custom_alert_dialog, null);
        builder.setView(customLayout);
        AlertDialog alertDialog = builder.create();

        TextView customTitle = customLayout.findViewById(R.id.customTitle);
        TextView customMessage = customLayout.findViewById(R.id.customMessage);
        Button customPositiveButton = customLayout.findViewById(R.id.customPositiveButton);
        Button customNegativeButton = customLayout.findViewById(R.id.customNegativeButton);

        updateScore();
        customTitle.setText(title);
        customMessage.setText(message);

        customPositiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        customNegativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss(); //dismiss metodu kullanılarak AlertDialog kapatılıyor:

            }
        });

        // Make the background transparent
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
    }

    private void resetGame() {
        currentQuestionIndex = 0;
        score = 0;
        wrongAnswer = 3;
        hintIndex = 0;
        updateQuestion();
    }


    private void checkWrongAnswer(View view) {
            if (wrongAnswer < 0) {
                showCustomAlertDialog("Oyun Bitti", "Toplam Puan: "+ score);
                resetGame();
            }
        }








}
