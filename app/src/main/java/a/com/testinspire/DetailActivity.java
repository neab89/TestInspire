package a.com.testinspire;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {


    private TextView quoteTextView;
    private RelativeLayout relativeLayout;


    private String[] quoteArray;
    static int quoteIndex;
    private int noOfQuotes;
    private int quoteArrayInt;
    private int backGroundImage;
    private int textColor;
    private String quoteCategory;

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setHomeButtonEnabled(true);



        quoteIndex=0;

        pref = getApplicationContext().getSharedPreferences("InspirePref", MODE_PRIVATE);
        quoteCategory=pref.getString("QUOTE_CATEGORY","bible");
        backGroundImage=R.drawable.green_wood_plain;
        textColor=R.color.colorPrimary;
        quoteTextView=(TextView) findViewById(R.id.quote_tv);

        switch (quoteCategory){

            case "bible":

                quoteArrayInt=R.array.bible_quotes;
                break;

            case "gita":

                quoteArrayInt=R.array.gita_quotes;
                break;

            case "quran":

                quoteArrayInt=R.array.quran_quotes;
                break;

            case "buddha":

                quoteArrayInt=R.array.buddha_quotes;
                break;
        }


        quoteArray=getResources().getStringArray(quoteArrayInt);
        noOfQuotes=quoteArray.length;

       relativeLayout=findViewById(R.id.relativelayout_main);
        relativeLayout.setBackgroundResource(backGroundImage);



        quoteTextView.setText(quoteArray[quoteIndex]);
        quoteTextView.setTextColor(textColor);




    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.share:

                shareText();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

    public void shareText() {
        String txt = quoteArray[quoteIndex];
        String mimeType = "text/plain";

        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser();
    }





    public void nextQuote(View view) {


        if(!(quoteIndex==noOfQuotes-1)){
            quoteIndex++;
        }

        quoteTextView.setText(quoteArray[quoteIndex]);

    }

    public void previousQuote(View view) {


        if(!(quoteIndex==0)){
            quoteIndex--;
        }

        quoteTextView.setText(quoteArray[quoteIndex]);

    }
}
