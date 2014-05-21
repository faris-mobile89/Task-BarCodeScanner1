package com.task.barcodescan;

import com.task.db.SQLiteHandler;
import com.task.model.Comment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCommentActivity  extends Activity{
	private EditText txtComment;
	@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.add_commetn_activity);
	
	txtComment = (EditText)findViewById(R.id.editText1);
	Button btnAdd =(Button)findViewById(R.id.buttonAdd);
	
	btnAdd.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			SQLiteHandler db = new SQLiteHandler(AddCommentActivity.this);
			Comment c = new Comment();
			c.setText(txtComment.getText().toString());
			db.addComment(c);
			
			Toast.makeText(getBaseContext(), "Succefuly", Toast.LENGTH_SHORT).show();
			finish();
		}
	});
	
	
}
}
