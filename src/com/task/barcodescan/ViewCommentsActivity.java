package com.task.barcodescan;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.task.adapter.CommentsAdapter;
import com.task.db.SQLiteHandler;
import com.task.model.Comment;

public class ViewCommentsActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_comments);
		
		ListView commentslv= (ListView)findViewById(R.id.listView1);
		SQLiteHandler db = new SQLiteHandler(ViewCommentsActivity.this);
		
		List<Comment> listData= db.getAllComments();
		
		CommentsAdapter adapter = new CommentsAdapter(ViewCommentsActivity.this, listData);
		
		commentslv.setAdapter(adapter);
	}
}
