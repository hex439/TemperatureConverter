package au.edu.jcu.cp3406.assignment1_converterapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View view) {

        Spinner spinner = findViewById(R.id.spinner);
        String unit = spinner.getSelectedItem().toString();

        EditText userInput = findViewById(R.id.input);
        String input = userInput.getText().toString();
        TextView output = findViewById(R.id.output);

        //check for empty input
        if (input.length() == 0) {
            output.setText("");
        }

        try {
            double inputTemp = Double.parseDouble(input);

            //call to fahrenheit method
            if (unit.equals("°C")) {
                double result = Conversion.toFahrenheit(inputTemp);
                String formattedOutput = String.format(Locale.getDefault(), "%.2f", result);
                formattedOutput += "°F";
                output.setText(formattedOutput);
            }

            //call to celsius method
            if (unit.equals("°F")) {
                double result = Conversion.toCelsius(inputTemp);
                String formattedOutput = String.format(Locale.getDefault(), "%.2f", result);
                formattedOutput += "°C";
                output.setText(formattedOutput);
            }

        //display error message for empty input
        } catch (NumberFormatException numberFormatException) {
            Toast.makeText(MainActivity.this, "invalid", Toast.LENGTH_SHORT).show();
        }

        //hide keyboard when button is pressed
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

    //clear previous input and output
    public void clearButton(View view) {
        EditText editText = findViewById(R.id.input);
        editText.setText("");

        TextView textView = findViewById(R.id.output);
        textView.setText("");

        //hide keyboard when button is pressed
        InputMethodManager inputMethodManager =
                (InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    //send to setting page
    public void settingClicked(View view) {
        Intent intent = new Intent(this, SettingActivity.class);
        startActivityForResult(intent, 111);
    }

    //get and apply data from setting page
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        TextView output = findViewById(R.id.output);
        androidx.appcompat.widget.AppCompatButton buttonLayout = findViewById(R.id.button);
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == 111) {
            if (resultCode == Activity.RESULT_OK && intent != null) {

                Bundle result = intent.getExtras();

                Bundle valueDefault = new Bundle();
                valueDefault.putString("Default", "Default");

                Bundle valueLarge = new Bundle();
                valueLarge.putString("Large", "Large");

                if (result.equals(valueDefault)) {
                    output.setTextSize(15);
                    buttonLayout.setTextSize(15);
                }
                if (result.equals(valueLarge)) {
                    output.setTextSize(25);
                    buttonLayout.setTextSize(25);
                }
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}