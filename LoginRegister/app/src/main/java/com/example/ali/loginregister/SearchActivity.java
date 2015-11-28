package com.example.ali.loginregister;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity implements OnClickListener, AdapterView.OnItemSelectedListener {


    private RelativeLayout searchLayout;
    private ListView list;
    private Button search;
    private Button addentry;
    private Button deleteEntry;
    private AutoCompleteTextView autoCompleteTextView;
    private ArrayAdapter arrayAdapter;
    private Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        TextView textView6 = (TextView) findViewById(R.id.textView6);
        b2 = (Button)findViewById(R.id.button2);
        Button add = (Button) findViewById(R.id.button3);
        Button search = (Button) findViewById(R.id.button6);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line);
        arrayAdapter.add("Design and Analysis of Algorithm");
        arrayAdapter.add("Computer Networks");
        arrayAdapter.add("Object Oriented Analysis and Design");
        arrayAdapter.add("World War2");
        arrayAdapter.add("Gang of Four Design Patterns");
        arrayAdapter.add("Natural Language Processing");
        arrayAdapter.add("Database Management");
        autoCompleteTextView.setThreshold(2);
        autoCompleteTextView.setAdapter(arrayAdapter);
        add.setOnClickListener(this);
        b2.setOnClickListener(this);
        search.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Button add = (Button) findViewById(R.id.button3);
        add.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button3) {
            Intent i1 = new Intent(SearchActivity.this, NewPostActivity.class);
            startActivity(i1);
        }
else if(v.getId()==R.id.button2)
        {
            Searchmanager sm = new Searchmanager(autoCompleteTextView.getText().toString());
           sm.searchResult();
            String str = sm.getResult();
            if(str==null)
                Toast.makeText(getApplicationContext(),"Book is out of stock",Toast.LENGTH_SHORT).show();
        else
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("Book",str);
            startActivity(intent);
        }


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),"Press Search Button to search" + arrayAdapter.getItem(position),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


