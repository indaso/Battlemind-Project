package com.googlehack.battlemind;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.view.Window;
import android.view.WindowManager;

public class BattleActivity extends Activity {

    private static final int NUMERIC = 0,
        ALPHABETIC = 1,
        ALPHANUMERIC = 2;
    
    private String password;

    private HashMap<Integer, ArrayList<String>> alphabet;
	private ArrayList<String> passList;
	private ArtificialIntelligence ai;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_battle);
		
		
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		password = bundle.getString("password");
		int GAMELEVEL = bundle.getInt("GAMELEVEL");
		TextView text = (TextView) findViewById(R.id.helloworld);
		text.setText(password);

		//FileParse.parser();
		//alphabet = FileParse.getAlphabet();
		//passList = alphabet.get(password.length());

        ArrayList<String> passList = new ArrayList<String>();
        passList.add("monk");
        passList.add("been");
        passList.add("bear");
        passList.add("chat");
        passList.add("beat");
        passList.add("meat");
		ai = new ArtificialIntelligence(passList, ALPHABETIC);
		/*
		// ex: pass = "bear"
		String guess = ai.guess(); // ex: guess = "meat"
		String result = getResult(guess, password); // ex: result = "*ea*"
		ai.updatePassword(result);
		//repeat
		
		// */
		
		View relLayout = findViewById(R.id.topLevel);
		if (GAMELEVEL == 0) {
			relLayout.setBackgroundResource(R.drawable.battlemindlevel1);
		} else if (GAMELEVEL == 1) {
			relLayout.setBackgroundResource(R.drawable.battlemindlevel2);
		} else if (GAMELEVEL == 2) {
			relLayout.setBackgroundResource(R.drawable.battlemindlevel3);
		} else if (GAMELEVEL == 3) {
			relLayout.setBackgroundResource(R.drawable.battlemindlevel4);
		} else if (GAMELEVEL == 4) {
			relLayout.setBackgroundResource(R.drawable.battlemindlevel5);
		} else if (GAMELEVEL == 5) {
			relLayout.setBackgroundResource(R.drawable.battlemindlevel6);
		} else if (GAMELEVEL == 6) {
			relLayout.setBackgroundResource(R.drawable.battlemindlevel7);
		}
		
		
		//*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.battle, menu);
		return true;
	}

    public String getResult(String guess, String pass){
        String result = "";
        for (int i = 0; i < guess.length(); i++){
            String passLetter = String.valueOf(pass.charAt(i));
            String guessLetter = String.valueOf(guess.charAt(i));
            if (!passLetter.equals(guessLetter)){
                result += "*";
            } else /* passLetter.equals(guessLetter) */ {
                result += passLetter;
            }
        }
        return result;
    }
    
    public void playGame() {
    	int numLetters = password.length();
		// ex: pass = "bear"
		String guess = ai.guess(); // ex: guess = "meat"
		String result = getResult(guess, password); // ex: result = "*ea*"
		ai.updatePassword(result);
		//repeat */
    }
}
