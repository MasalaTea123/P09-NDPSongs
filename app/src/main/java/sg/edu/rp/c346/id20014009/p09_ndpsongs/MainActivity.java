package sg.edu.rp.c346.id20014009.p09_ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etSongTitle, etSingers, etYear;
    RadioGroup rgroup;
    Button btnInsert,btnShowList;
    RadioButton rbOnestars, rbTwostars, rbThreestars, rbFourstars, rbFivestars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSongTitle = findViewById(R.id.etSongTitle);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        rgroup = findViewById(R.id.rgroup);
        btnInsert = findViewById(R.id.btnInsert);
        btnShowList = findViewById(R.id.btnShowList);
        rbOnestars = findViewById(R.id.rbOnestars);
        rbTwostars = findViewById(R.id.rbTwostars);
        rbThreestars = findViewById(R.id.rbThreestars);
        rbFourstars = findViewById(R.id.rbFourstars);
        rbFivestars = findViewById(R.id.rbFivestars);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(MainActivity.this);
//                boolean isChecked = true;
//                if(rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked() || rb5.isChecked()){
//                    isChecked = false;
//                }

                if(etSongTitle.getText().toString().isEmpty() || etSingers.getText().toString().isEmpty() || etYear.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Missing input", Toast.LENGTH_SHORT).show();
                }
                else{
                    String title = etSongTitle.getText().toString();
                    String singers = etSingers.getText().toString();
                    int year = Integer.parseInt(etYear.getText().toString());
                    int selectedId = rgroup.getCheckedRadioButtonId();
                    RadioButton radioButton = (RadioButton) findViewById(selectedId);
                    int stars = Integer.parseInt(radioButton.getText().toString());

                    dbh.insertSong(title, singers, year, stars);
                    Toast.makeText(MainActivity.this, "Successfully inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }

    }
