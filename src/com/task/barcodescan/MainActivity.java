package com.task.barcodescan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends Activity {


	private Button scanBtn,viewBtn,addBtn;
	private TextView formatTxt, contentTxt;
	private String result;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//http://chart.apis.google.com/chart?chs=200x200&cht=qr&chld=|1&chl=%7B%22id%22%3A%222345%22%2C%22description%22%3A%22nothing%20yet%22%2C%22date%22%3A%2220-5-2014%22%7D
		//instantiate UI items
		scanBtn = (Button)findViewById(R.id.buttonScan);
		viewBtn = (Button)findViewById(R.id.buttonView);
		addBtn = (Button)findViewById(R.id.buttonAdd);
		formatTxt = (TextView)findViewById(R.id.scan_format);
		contentTxt = (TextView)findViewById(R.id.scan_content);

		scanBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				IntentIntegrator scanIntegrator = new IntentIntegrator(MainActivity.this);
				scanIntegrator.initiateScan();
			}
		});
		
		viewBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getBaseContext(),ViewCommentsActivity.class));
				
			}
		});
		
		addBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getBaseContext(),AddCommentActivity.class));
			}
		});
	}


	public void onActivityResult(int requestCode, int resultCode, Intent intent) {

		IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

		if (scanningResult != null) {

			String scanContent = scanningResult.getContents();
	
			String scanFormat = scanningResult.getFormatName();

			formatTxt.setText("FORMAT: "+scanFormat);
			contentTxt.setText("User Inormation: "+scanContent);
			
			result = scanContent;
			
			
		}
		else{
			Toast toast = Toast.makeText(getApplicationContext(), 
					"No scan data received!", Toast.LENGTH_SHORT);
			toast.show();
		}
	}
	

}

