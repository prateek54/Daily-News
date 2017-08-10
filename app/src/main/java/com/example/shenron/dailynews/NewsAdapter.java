package com.example.shenron.dailynews;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

public class NewsAdapter extends ArrayAdapter<News>{

    public NewsAdapter(Context context, List<News> news)
    {
        super(context,0,news);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);
        }

        //Find current news at a given position in the list item
        News currentNews = getItem(position);

        TextView headingView = (TextView)listItemView.findViewById(R.id.heading_text_view);
        headingView.setText(currentNews.getTitle());

        TextView authorView = (TextView)listItemView.findViewById(R.id.author_text_view);
        authorView.setText(currentNews.getAuthor());

        TextView categoryView = (TextView)listItemView.findViewById(R.id.categories_text_view);
        categoryView.setText(currentNews.getCategory());


        TextView dateView = (TextView)listItemView.findViewById(R.id.date_text_view);

        String date = currentNews.getDate().substring(0,10);
        // Rearrange the date to the format as follows: dd-mm-yy
        String formattedDate = date.substring(8, 9) + date.substring(4, 8) + date.substring(0, 4);
        dateView.setText(formattedDate);

        TextView timeView = (TextView)listItemView.findViewById(R.id.time_text_view);
        String time = currentNews.getDate().substring(11,15);
        // Rearrange the time to the format as follows: hh:mm
        String formattedTime = time;
        timeView.setText(formattedTime);

        // Return the list item view that is now showing the appropriate data
        return listItemView;

    }
}
