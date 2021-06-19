package au.edu.jcu.cp3406.assignment1_converterapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
    }



    public void saveClicked(View view) {

        //Check for selected text size and change text size accordingly
        TextView textView = findViewById(R.id.setting_intro);
        androidx.appcompat.widget.AppCompatButton saveLayout = findViewById(R.id.setting_save);
        androidx.appcompat.widget.AppCompatButton backLayout = findViewById(R.id.button_back);
        Spinner spinner = findViewById(R.id.spinner_size);
        String size = spinner.getSelectedItem().toString();

        if (size.equals("Default")) {
            textView.setTextSize(20);
            saveLayout.setTextSize(20);
            backLayout.setTextSize(20);
        }

        if (size.equals("Large")) {
            textView.setTextSize(25);
            saveLayout.setTextSize(25);
            backLayout.setTextSize(25);
        }
    }

    public void onBackPressed(View view) {

        //send intent containing text size selection to main activity and return to main page
        Intent intent = new Intent();
        Spinner spinner = findViewById(R.id.spinner_size);
        String size = spinner.getSelectedItem().toString();

        if (size.equals("Default")) {
            intent.putExtra("Default", "Default");
        }
        if (size.equals("Large")) {
            intent.putExtra("Large", "Large");
        }
        setResult(Activity.RESULT_OK, intent);
        finish();
        super.onStop();
        super.onBackPressed();
    }

}
