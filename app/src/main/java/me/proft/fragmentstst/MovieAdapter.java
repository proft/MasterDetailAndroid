package me.proft.fragmentstst;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return movies.indexOf(getItem(position));
    }

    private class ViewHolder{
        TextView tvTitle;
        TextView tvYear;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        Movie movie = movies.get(position);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.movie_list_item, null);

            holder = new ViewHolder();
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            holder.tvYear = (TextView) convertView.findViewById(R.id.tvYear);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvTitle.setText(movie.getTitle());
        holder.tvYear.setText(movie.getYear().toString());

        return convertView;
    }
}