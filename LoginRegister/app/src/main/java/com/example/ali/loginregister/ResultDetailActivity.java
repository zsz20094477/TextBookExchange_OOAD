package com.example.ali.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ResultDetailActivity extends AppCompatActivity{

    public static Book chosenBook;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_detail);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }


    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_result_detail, container, false);
            Button reserve_button = (Button)rootView.findViewById(R.id.reserve_button);
            Intent intent = getActivity().getIntent();
            final View.OnClickListener Click = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.reserve_button:
                            ReservationManager RM = ReservationManager.getInstance();
                            RM.Reserve(chosenBook);
                            break;
                    }
                }
            };
            if (intent != null && intent.hasExtra("chosenBook")) {
                chosenBook = (Book) intent.getSerializableExtra("chosenBook");
//                String chosenBook = intent.getStringExtra("chosenBook");
                ((TextView) rootView.findViewById(R.id.detail_title)).setText(chosenBook.getTitle());
                ((TextView) rootView.findViewById(R.id.detail_user)).setText("Seller: " + chosenBook.getOwner_name());
                ((TextView) rootView.findViewById(R.id.detail_description)).setText("Description: " + chosenBook.getDescription());
            }
            reserve_button.setOnClickListener(Click);
            return rootView;
        }

    }


}
