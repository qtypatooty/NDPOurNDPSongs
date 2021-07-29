package sg.edu.rp.c346.id20006949.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class SongList extends AppCompatActivity {
    Button button;
    ArrayList<Song> al;
    ListView lv;
    Spinner spinnerYear;
    ArrayAdapter<Song> aa;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        ArrayList<String> spinList = new ArrayList<>();
        spinList.add("None Selected");
        spinnerYear = findViewById(R.id.spinnerYear);
        ArrayAdapter<String> ab = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,spinList);
        ab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(ab);
        lv = findViewById(R.id.lv);
        al = new ArrayList<Song>();
        button = findViewById(R.id.button);
        adapter = new CustomAdapter(this, R.layout.row, al);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song data = al.get(position);
                Intent i = new Intent(SongList.this,
                        SongDetails.class);
                i.putExtra("data", data);
                startActivity(i);
            }
        });
        spinnerYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                boolean check = false;
                for (int i = 0; i < al.size(); i++) {
                    for (int x = 0; x < al.size(); x++) {
                        if (spinList.contains(al.get(i))) {
                            check = true;
                        } else {
                            check = false;
                        }
                    }
                    if (check == true) {
                        spinList.add(al.get(i).getYear() + "");
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Song> stars = new ArrayList<>();
                for (Song x : al) {
                    if (x.getStar() == 5) {
                        stars.add(x);
                    } else {
                        Toast.makeText(SongList.this, "The stars is not 5 stars", Toast.LENGTH_SHORT).show();
                    }
                    aa = new CustomAdapter(SongList.this, R.layout.row, stars);
                }
                lv.setAdapter(aa);
            }
        });
    }

        @Override
        protected void onResume() {
            super.onResume();
            ArrayList<Song> al2;
            DBHelper db = new DBHelper(SongList.this);
            al2 = db.getAllSong();
            al.clear();
            al.addAll(al2);
            adapter.notifyDataSetChanged();
        }
    }