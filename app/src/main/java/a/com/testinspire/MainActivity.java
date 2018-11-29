package a.com.testinspire;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bibleButton;
    Button gitaButton;
    Button quranButton;
    Button buddhaButton;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = getApplicationContext().getSharedPreferences("InspirePref", MODE_PRIVATE);
        editor = pref.edit();

        bibleButton=findViewById(R.id.bible_btn);
        gitaButton=findViewById(R.id.gita_btn);
        quranButton=findViewById(R.id.quran_btn);
        buddhaButton=findViewById(R.id.buddha_btn);

        bibleButton.setOnClickListener(this);
        gitaButton.setOnClickListener(this);
        quranButton.setOnClickListener(this);
        buddhaButton.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.bible_btn:

                editor.putString("QUOTE_CATEGORY","bible");
                editor.commit();
                break;

            case R.id.gita_btn:

                editor.putString("QUOTE_CATEGORY","gita");
                editor.commit();
                break;

            case R.id.quran_btn:

                editor.putString("QUOTE_CATEGORY","quran");
                editor.commit();
                break;

            case R.id.buddha_btn:

                editor.putString("QUOTE_CATEGORY","buddha");
                editor.commit();
                break;
        }

        Intent intent=new Intent(this,DetailActivity.class);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

}
