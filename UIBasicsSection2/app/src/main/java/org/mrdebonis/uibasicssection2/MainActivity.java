package org.mrdebonis.uibasicssection2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtTxtName;
    private TextView txtHello;

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnHello) {
            Toast.makeText(this, "Hello Button Clicked", Toast.LENGTH_SHORT).show();
            txtHello.setText("Hello " + edtTxtName.getText().toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHello = findViewById(R.id.btnHello);
        btnHello.setOnClickListener(this);

        edtTxtName = findViewById(R.id.edtTxtName);
        txtHello = findViewById(R.id.txtHello);

        txtHello.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this,"Hello there", Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }
}