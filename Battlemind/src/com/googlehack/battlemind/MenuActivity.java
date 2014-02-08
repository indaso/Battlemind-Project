package com.googlehack.battlemind;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;

public class MenuActivity extends Activity {
	private Button mixed;
	private Button numerical;
	private Button alpha;
	private static final String GAMEMODE = "GameMode";
	//game modes mixed = 0, numerical = 1, alpha = 2
	private int buttontype;
	private Intent i = new Intent(this, BattleActivity.class);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		mixed.findViewById(R.id.mixed_button);
		numerical.findViewById(R.id.numeric_button);
		alpha.findViewById(R.id.alpha_button);
		
	}
	
	public void alphaClicked() {
		buttontype = 0;
		i.putExtra(GAMEMODE, buttontype);
		startActivityForResult(i, 0);
	}
	
	public void numericalClicked() {
		buttontype = 1;
		i.putExtra(GAMEMODE, buttontype);
		startActivityForResult(i, 0);
	}
	
	public void mixedClicked() {
		buttontype = 2;
		i.putExtra(GAMEMODE, buttontype);
		startActivityForResult(i, 0);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

}
