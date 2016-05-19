package me.proft.fragmentstst;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MovieDetailFragment extends Fragment {
    public static final String ARG_ITEM_POS = "moviePOS";
    private Movie movie;

    public MovieDetailFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_POS)) {
            movie = Movie.items.get(getArguments().getInt(ARG_ITEM_POS));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.movie_detail_fragment, container, false);

        if (movie != null) {
            TextView tvTitle = (TextView)v.findViewById(R.id.tvTitle);
            tvTitle.setText(movie.getTitle());

            TextView tvYear = (TextView)v.findViewById(R.id.tvYear);
            tvYear.setText(movie.getYear().toString());
        }

        return v;
    }

}
