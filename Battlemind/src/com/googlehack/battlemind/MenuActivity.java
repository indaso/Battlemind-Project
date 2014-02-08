package com.googlehack.battlemind;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity {
//	private Button mixed;
//	private Button numerical;
//	private Button alpha;
	private static final String GAMEMODE = "GameMode";
	//game modes mixed = 0, numerical = 1, alpha = 2
	private int buttontype;
	private Intent i;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		i = new Intent(this, BattleActivity.class);

		
		setContentView(R.layout.activity_menu);
////		
//		mixed.findViewById(R.id.mixed_button);
//		numerical.findViewById(R.id.numeric_button);
//		alpha.findViewById(R.id.alpha_button);
		
	}
	
	public void alphaClicked(View view) {
		buttontype = 0;
		i.putExtra(GAMEMODE, buttontype);
		startActivityForResult(i, 0);
	}
	
	public void numericalClicked(View view) {
		buttontype = 1;
		i.putExtra(GAMEMODE, buttontype);
		startActivityForResult(i, 0);
	}
	
	public void mixedClicked(View view) {
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
