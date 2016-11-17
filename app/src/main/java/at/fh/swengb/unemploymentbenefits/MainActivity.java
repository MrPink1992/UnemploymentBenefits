package at.fh.swengb.unemploymentbenefits;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity  extends AppCompatActivity{

    private EditText editTextIncome;
    private TextView resultView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextIncome = (EditText)findViewById(R.id.editTextIncome);
        resultView= (TextView)findViewById(R.id.textViewResult);

    }


    public void calcBenefit(View view){

        String incomeString = editTextIncome.getText().toString();


        double income=0;

        income = Double.parseDouble(incomeString);
        double result = 0;

        if (income < 4800 && income > 0) {
            try {
                result = (income * 0.55);
                result = Math.round(result);
                resultView.setText("Your unemployment benefit is: " + result + " (Please notice that this calculation does not include family supplements)");

            } catch (NumberFormatException e) {
                e.printStackTrace();
                resultView.setText("Wrong Input !");

            }
        }
        else if(income <= 0){
            resultView.setText("Sorry, your income has to be bigger than 0!");

        }
        else if(income > 4800){
            resultView.setText("Sorry, your avg. income is to big to receive unemployment benefit!");

        }

    }

}
