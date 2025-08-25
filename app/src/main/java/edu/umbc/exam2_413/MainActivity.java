//Nathaniel Adu Ankomah ip87330@umbc.edu
//Here in this project I create an app that calculates the amount of tax paid in 3 different countries
package edu.umbc.exam2_413;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // Tax rates for each country
    private final double GERMANY_RATE = 34.25;
    private final double SWEDEN_RATE = 19.25;
    private final double NZ_RATE = 12.50;

    // Java variables
    private double incomeEntered;
    private double taxAmount;
    private DecimalFormat df;

    // UI Components
    private TextInputEditText inputTextIncome;
    private RadioButton rbGermany;
    private RadioButton rbSweden;
    private RadioButton rbNewZealand;
    private Button btnCalculate;
    private TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Connect the XML components to Java
        inputTextIncome = findViewById(R.id.inputTextIncome);
        rbGermany = findViewById(R.id.rbGermany);
        rbSweden = findViewById(R.id.rbSweden);
        rbNewZealand = findViewById(R.id.rbNewZealand);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        df = new DecimalFormat("####.00");

        //Event for when button is clicked
        btnCalculate.setOnClickListener(e ->{
            incomeEntered = Double.parseDouble(String.valueOf(inputTextIncome.getEditableText()));
            if (rbGermany.isChecked()) {
                taxAmount = incomeEntered * (GERMANY_RATE / 100.0); // Calculate when germany is clicked
            } else if (rbSweden.isChecked()) {
                taxAmount = incomeEntered * (SWEDEN_RATE / 100.0); // Calculate when germany is clicked
            } else if (rbNewZealand.isChecked()) {
                taxAmount = incomeEntered * (NZ_RATE / 100.0); // Calculate when new zealand is clicked
            } else {
                tvResult.setText("");
                return;
            }
// Show the amount of tax owed
            String result = "Tax: $" + df.format(taxAmount);
            tvResult.setText(result);
            tvResult.setVisibility(TextView.VISIBLE);

        });

    }
}