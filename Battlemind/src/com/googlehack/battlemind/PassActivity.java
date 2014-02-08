package com.googlehack.battlemind;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PassActivity extends Activity {
	private EditText passInput;
	private Button play;
	private Intent i;
	private Intent i2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pass);
		
	}
	
	public void playClicked(View view) {
		
		i = getIntent();
		startActivity(i);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pass, menu);
		return true;
	}
	

}