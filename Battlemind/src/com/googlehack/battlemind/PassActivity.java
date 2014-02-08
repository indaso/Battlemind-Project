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
	private final String GAMELEVEL= "GAMELEVEL";
	private Intent i;
	private Intent i2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pass);
		
	}
	
	public void playClicked(View view) {
		
		i = getIntent();
		i2 = new Intent(this, BattleActivity.class);
		i2.putExtra(GAMELEVEL, i.getIntExtra(MenuActivity.GAMEMODE, 0));
		startActivity(i2);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pass, menu);
		return true;
	}
	

}
