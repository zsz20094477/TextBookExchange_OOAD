package module2.bookwise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity implements OnClickListener {

    private SearchView searchView;
    private RelativeLayout searchLayout;
    private ListView list;
    private Button search;
    private Button addentry;
    private Button deleteEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        TextView textView6 = (TextView) findViewById(R.id.textView6);
        Button add = (Button) findViewById(R.id.button3);
        Button search = (Button) findViewById(R.id.button6);
        add.setOnClickListener(this);
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
else if(v.getId()==R.id.button6)
        {
            Intent i2 = new Intent(SearchActivity.this,ResultActivity.class);
            startActivity(i2);
        }


    }
}


