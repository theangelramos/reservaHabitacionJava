package com.example.reservahabitacionjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText checkinInput;
    private EditText checkoutInput;
    private EditText personasInput;
    private Button reservarButton;

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

        checkinInput = findViewById(R.id.checkinInput);
        checkoutInput = findViewById(R.id.checkoutInput);
        personasInput = findViewById(R.id.personasInput);
        reservarButton = findViewById(R.id.reservarButton);

        reservarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fechaEntrada = checkinInput.getText().toString().trim();
                String fechaSalida = checkoutInput.getText().toString().trim();
                String numPersonas = personasInput.getText().toString().trim();

                if (fechaEntrada.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Por favor ingrese la fecha de entrada",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (fechaSalida.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Por favor ingrese la fecha de salida",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (numPersonas.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Por favor ingrese el número de personas",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                int personas = Integer.parseInt(numPersonas);
                if (personas <= 0 || personas > 4) {
                    Toast.makeText(MainActivity.this,
                            "El número de personas debe estar entre 1 y 4",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                String mensaje = "Reserva registrada:\n" +
                        "Fecha de entrada: " + fechaEntrada + "\n" +
                        "Fecha de salida: " + fechaSalida + "\n" +
                        "Número de personas: " + numPersonas;

                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();

                checkinInput.setText("");
                checkoutInput.setText("");
                personasInput.setText("");
            }
        });
    }
}