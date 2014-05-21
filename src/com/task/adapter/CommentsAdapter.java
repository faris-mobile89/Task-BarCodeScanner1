package com.task.adapter;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.task.barcodescan.R;
import com.task.model.Comment;

public class CommentsAdapter extends BaseAdapter {

    private Activity activity;
    private List<Comment> comment;
    private static LayoutInflater inflater=null;

    public CommentsAdapter(Activity a, List<Comment> d) {
        activity = a;
        comment=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    
	@Override
	public int getCount() {
        return comment.size();
    }

  
	@Override
	public Object getItem(int position) {
        return position;
    }

	@Override
	public long getItemId(int position) {
        return position;
    }
    
   
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.listview_row_with_text, null);

        TextView title = (TextView)vi.findViewById(R.id.title);

        title.setText(comment.get(position).getText());

        return vi;
    }
}