package sg.edu.rp.c346.id20006949.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RatingBar;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button insert, show;
    TextView title,singers,year,stars;
    EditText editsong, editsingers,edityear;
    RatingBar RatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert = findViewById(R.id.update);
        show = findViewById(R.id.show);
        title = findViewById(R.id.title);
        singers = findViewById(R.id.singers);
        year = findViewById(R.id.year);
        stars = findViewById(R.id.stars);
        editsong= findViewById(R.id.editsong);
        editsingers = findViewById(R.id.editsingers);
        edityear = findViewById(R.id.edityear);
        RatingBar = findViewById(R.id.RatingBar);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                if (TextUtils.isEmpty(editsong.getText().toString()) || (TextUtils.isEmpty(editsingers.getText().toString()) || (TextUtils.isEmpty(edityear.getText().toString())))){
                    Toast.makeText(MainActivity.this, "Empty field not allowed !",
                            Toast.LENGTH_SHORT).show();
                }else{
                    String songname = editsong.getText().toString();
                    String singersname = editsingers.getText().toString();
                    String yearsint = edityear.getText().toString();
                    int rating = (int) RatingBar.getRating();
                    editsong.setText("");
                    editsingers.setText("");
                    edityear.setText("");
                    Toast.makeText(MainActivity.this,
                            "Insert successful",
                            Toast.LENGTH_SHORT).show();
                    long result = db.insertSong(songname, singersname, yearsint, rating);


                }
            }
        });
        show.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SongList.class);
                startActivity(intent);
            }
        });


    }


}