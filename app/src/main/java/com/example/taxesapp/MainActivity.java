package com.example.taxesapp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText surfaceInput = findViewById(R.id.surface_input);
        EditText piecesInput = findViewById(R.id.pieces_input);
        CheckBox poolCheckbox = findViewById(R.id.pool_checkbox);
        TextView taxResult = findViewById(R.id.tax_result);
        Button calculateButton = findViewById(R.id.calculate_button);
        taxResult.setText("");
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int surface = Integer.parseInt(surfaceInput.getText().toString());
                int pieces = Integer.parseInt(piecesInput.getText().toString());
                boolean hasPool = poolCheckbox.isChecked();

                int baseTax = surface * 2;
                int additionalTax = pieces * 50 + (hasPool ? 100 : 0);

                int totalTax = baseTax + additionalTax;

                // Mettre à jour le TextView pour afficher les résultats
                String resultText = "Base Tax : " + baseTax + "\n" +
                        "Additional Tax : " + additionalTax + "\n" +
                        "Total Tax : " + totalTax;

                taxResult.setText(resultText);
            }
        });
    }
}
