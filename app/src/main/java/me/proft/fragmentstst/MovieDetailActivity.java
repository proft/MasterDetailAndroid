package me.proft.fragmentstst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail_activity);

        if (savedInstanceState == null) {
            MovieDetailFragment fragment = new MovieDetailFragment();
            Bundle arguments = new Bundle();

            arguments.putInt(MovieDetailFragment.ARG_ITEM_POS, getIntent().getIntExtra(MovieDetailFragment.ARG_ITEM_POS, 0));
            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction().add(R.id.flMovieDetail, fragment).commit();
        }

    }

}
