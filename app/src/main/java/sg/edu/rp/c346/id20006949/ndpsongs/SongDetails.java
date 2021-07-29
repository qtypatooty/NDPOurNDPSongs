package sg.edu.rp.c346.id20006949.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class SongDetails extends AppCompatActivity {
    Button update, delete,cancel;
    TextView title,singers,year,stars;
    EditText editsong, editsingers,edityear,editid;
    Song data;
    RatingBar RatingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        cancel = findViewById(R.id.cancel);
        title = findViewById(R.id.title);
        singers = findViewById(R.id.singers);
        year = findViewById(R.id.year);
        stars = findViewById(R.id.stars);
        editid = findViewById(R.id.editid);
        editsong = findViewById(R.id.editsong);
        editsingers = findViewById(R.id.editsingers);
        edityear = findViewById(R.id.edityear);
        RatingBar = findViewById(R.id.RatingBar);
        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");
        editid.setText(data.get_id() + "");
        editsong.setText(data.getTitle());
        editsingers.setText(data.getSingers());
        edityear.setText(data.getYear() + "");

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(SongDetails.this);
                data.setTitle(editsong.getText().toString());
                data.setSingers(editsingers.getText().toString());
                int updateyear = Integer.valueOf(edityear.getText().toString());
                data.setYear(updateyear);
                int result = dbh.updateSong(data);
                if (result > 0) {
                    Toast.makeText(SongDetails.this, "Song Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    Toast.makeText(SongDetails.this, "Song Update fail", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(SongDetails.this);
                dbh.deleteSong(data.get_id());
                Intent intent = new Intent();
                intent.putExtra("key", "value");
                setResult(RESULT_OK, intent);
                finish();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    }
