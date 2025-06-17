package com.example.mojezadanie9;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SeekBar valueSeekBar;
    private ListView settingsListView;
    private ArrayAdapter<String> listViewAdapter;
    private ArrayList<String> settingNames;
    private ArrayList<Integer> settingValues;
    private ArrayList<String> settingUnits;
    private ArrayList<String> displayItemsForListView;
    private TextView editingLabelTextView;
    private TextView seekBarValueTextView;
    int selectedItemPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedItemPosition = -1;

        settingNames = new ArrayList<>();
        settingValues = new ArrayList<>();
        settingUnits = new ArrayList<>();
        displayItemsForListView = new ArrayList<>();

        valueSeekBar = findViewById(R.id.valueSeekBar);
        settingsListView = findViewById(R.id.settingsListView);
        seekBarValueTextView = findViewById(R.id.seekBarValueTextView);
        editingLabelTextView = findViewById(R.id.editingLabelTextView);
        valueSeekBar.setEnabled(true);
        seekBarValueTextView.setText("Wybierz opcję");
        editingLabelTextView.setText("Wybierz opcję");

        settingNames.add("Jasność ekranu");
        settingNames.add("Głośność dźwięków");
        settingNames.add("Czas automatycznej blokady");

        settingValues.add(50);
        settingValues.add(80);
        settingValues.add(30);

        settingUnits.add("%");
        settingUnits.add("%");
        settingUnits.add("s");

        for(int i=0;i<settingNames.size();i++){
            displayItemsForListView.add(settingNames.get(i) + ": " + settingValues.get(i) + settingUnits.get(i));
        }

        listViewAdapter = new ArrayAdapter<>(this, R.layout.list_item_setting, R.id.itemTextView, displayItemsForListView);

        settingsListView.setAdapter(listViewAdapter);

        settingsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItemPosition = i;
                editingLabelTextView.setText("Edytujesz: " + settingNames.get(i));
                valueSeekBar.setEnabled(true);
                valueSeekBar.setProgress(settingValues.get(i));
                seekBarValueTextView.setText("Wartość: " + settingValues.get(i));
            }
        });

        valueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b && selectedItemPosition!=-1){
                    seekBarValueTextView.setText("Wartość: " + i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(selectedItemPosition!=-1){
                    settingValues.set(selectedItemPosition, seekBar.getProgress());
                    displayItemsForListView.set(selectedItemPosition, settingNames.get(selectedItemPosition)+": "+settingValues.get(selectedItemPosition)+settingUnits.get(selectedItemPosition));
                    listViewAdapter.notifyDataSetChanged();
                }
            }
        });

    }
}