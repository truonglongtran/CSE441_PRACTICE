package com.example.prac03;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity2 extends AppCompatActivity {
    private ImageView flagImageView;
    private TextView countryNameTextView, capitalTextView, populationTextView, areaTextView, densityTextView, worldShareTextView;
    private ImageView backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        flagImageView = findViewById(R.id.flagImgView);
        countryNameTextView = findViewById(R.id.countryTextNameView);
        capitalTextView = findViewById(R.id.capitalTextView);
        populationTextView = findViewById(R.id.populationTextView);
        areaTextView = findViewById(R.id.areaTextView);
        densityTextView = findViewById(R.id.densityTextView);
        worldShareTextView = findViewById(R.id.worldShareTextView);
        backButton = findViewById(R.id.backButton);
        Country country = (Country) getIntent().getSerializableExtra("country");

        if (country != null) {
            // Gán dữ liệu lên các View
            ImageView flagImageView = findViewById(R.id.flagImgView);
            TextView countryNameTextView = findViewById(R.id.countryTextNameView);
            TextView capitalTextView = findViewById(R.id.capitalTextView);
            TextView populationTextView = findViewById(R.id.populationTextView);
            TextView areaTextView = findViewById(R.id.areaTextView);
            TextView densityTextView = findViewById(R.id.densityTextView);
            TextView worldShareTextView = findViewById(R.id.worldShareTextView);

            // Gán giá trị cho các TextView
            flagImageView.setImageResource(country.getFlagResId());
            countryNameTextView.setText("Country: " + country.getName());
            capitalTextView.setText("Capital:" + country.getCapital());
            populationTextView.setText("Population: " + country.getPopulation()+" pp");
            areaTextView.setText("Area: " + country.getArea() + " km²");
            densityTextView.setText("Density: " + country.getDensity() + " people/km²");
            worldShareTextView.setText("World Share: " + country.getWorldShare() + "%");
        }

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // Go back to the previous activity
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}