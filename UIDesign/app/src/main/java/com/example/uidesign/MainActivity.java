package com.example.uidesign;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        final Boolean[] darkMode = {false};
        ImageButton dmButton = findViewById(R.id.dmImageButton);
        dmButton.setOnClickListener(v -> darkMode[0] = changeMode(darkMode[0]));

    }

    public Boolean changeMode(Boolean darkMode){
        ConstraintLayout mainLayout = findViewById(R.id.main);
        ImageButton dmButton = findViewById(R.id.dmImageButton);
        Button resetButton = findViewById(R.id.resetButton);
        Button registerButton = findViewById(R.id.registerButton);
        CheckBox termsNCheckBox = findViewById(R.id.termsNCondCheckBox);
        TextView logoTextView = findViewById(R.id.logoTextView);
        TextView subtitle = findViewById(R.id.subtitleTextView);
        TextView dmTextView = findViewById(R.id.dmTextView);
        ImageButton uploadImgButton = findViewById(R.id.uploadImgImageButton);

        if (darkMode){
            mainLayout.setBackgroundColor(getResources().getColor(R.color.white, null));
            dmButton.setBackgroundColor(getResources().getColor(R.color.white, null));
            resetButton.setBackgroundColor(getResources().getColor(R.color.purple, null));
            resetButton.setTextColor(getResources().getColor(R.color.white, null));
            registerButton.setBackgroundColor(getResources().getColor(R.color.purple, null));
            registerButton.setTextColor(getResources().getColor(R.color.white, null));
            termsNCheckBox.setTextColor(getResources().getColor(R.color.black, null));
            logoTextView.setTextColor(getResources().getColor(R.color.black, null));
            subtitle.setTextColor(getResources().getColor(R.color.black, null));
            dmTextView.setTextColor(getResources().getColor(R.color.black, null));
        } else {
            mainLayout.setBackgroundColor(getResources().getColor(R.color.black, null));
            dmButton.setBackgroundColor(getResources().getColor(R.color.grey, null));
            resetButton.setBackgroundColor(getResources().getColor(R.color.white, null));
            resetButton.setTextColor(getResources().getColor(R.color.black, null));
            registerButton.setBackgroundColor(getResources().getColor(R.color.white, null));
            registerButton.setTextColor(getResources().getColor(R.color.black, null));
            termsNCheckBox.setTextColor(getResources().getColor(R.color.white, null));
            logoTextView.setTextColor(getResources().getColor(R.color.white, null));
            subtitle.setTextColor(getResources().getColor(R.color.white, null));
            dmTextView.setTextColor(getResources().getColor(R.color.white, null));
        }
        return !darkMode;
    }

}