package com.prakpapb1.userinteraction;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    EditText editText;
    TextView textView;
    String label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinner_label);
        editText=findViewById(R.id.edit_input);
        textView=findViewById(R.id.textPhone);

        ArrayAdapter<CharSequence> adapter= ArrayAdapter
                .createFromResource(this, R.array.labels,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinner!=null) {
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    label=adapterView.getItemAtPosition(i).toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
    }

    public void showText(View view) {
        String showString="Phone number : "+label+" - "+editText.getText().toString();
        textView.setText(showString);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked=((RadioButton)(view)).isChecked();
        switch (view.getId()) {
            case R.id.radio_p1:
                if (checked)
                    Toast.makeText(this, "Anda memilih Pilihan 1",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_p2:
                if (checked)
                    Toast.makeText(this, "Anda memilih Pilihan 2",
                            Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_p3:
                if (checked)
                    Toast.makeText(this, "Anda memilih Pilihan 3",
                            Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void showAlert(View view) {
        AlertDialog.Builder myAlertBuilder=new AlertDialog.Builder(this);
        myAlertBuilder.setTitle("Alert");
        myAlertBuilder.setMessage("Click Ok to Continue, or Cancel to Stop");
        myAlertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Anda memilih Ok",
                        Toast.LENGTH_SHORT).show();
            }
        });
        myAlertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Anda memilih Cancel",
                        Toast.LENGTH_SHORT).show();
            }
        });
        myAlertBuilder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_menu1:
                Toast.makeText(MainActivity.this, "Anda memilih Menu 1",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_menu2:
                Toast.makeText(MainActivity.this, "Anda memilih Menu 2",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_menu3:
                Toast.makeText(MainActivity.this, "Anda memilih Menu 3",
                        Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
