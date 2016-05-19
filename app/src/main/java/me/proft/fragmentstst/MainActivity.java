package me.proft.fragmentstst;

import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements MovieListFragment.MovieListListener {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creating toolbar and setting it as actionbar for the activity
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(" IMDB");
        toolbar.setLogo(android.R.drawable.ic_dialog_info);
        toolbar.setTitleTextColor(0xFFFFFFFF);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            Movie.generate();

            // set list fragment
            MovieListFragment frg = new MovieListFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.flMovieList, frg).commit();

            // set detail fragment
            if (findViewById(R.id.flMovieDetail) != null) {
                Bundle arguments = new Bundle();
                arguments.putInt(MovieDetailFragment.ARG_ITEM_POS, 0);
                MovieDetailFragment fragment = new MovieDetailFragment();
                fragment.setArguments(arguments);
                getSupportFragmentManager().beginTransaction().add(R.id.flMovieDetail, fragment).commit();
            }
        }
    }

    @Override
    public void itemClicked(int pos) {
        if (findViewById(R.id.flMovieDetail) == null) {
            // start detail activity
            Intent detailIntent = new Intent(this, MovieDetailActivity.class);
            detailIntent.putExtra(MovieDetailFragment.ARG_ITEM_POS, pos);
            startActivity(detailIntent);
        } else {
            // replace detail fragment
            Bundle arguments = new Bundle();
            arguments.putInt(MovieDetailFragment.ARG_ITEM_POS, pos);
            MovieDetailFragment fragment = new MovieDetailFragment();
            fragment.setArguments(arguments);

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMovieDetail, fragment);
            ft.addToBackStack(null);
            ft.commit();
        }
    }

}
