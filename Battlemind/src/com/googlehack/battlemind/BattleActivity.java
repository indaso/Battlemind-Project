package com.googlehack.battlemind;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.Window;
import android.view.WindowManager;
import android.content.Context;

public class BattleActivity extends Activity {

    private static final int NUMERIC = 0,
        ALPHABETIC = 1,
        ALPHANUMERIC = 2;
    
    private String password;
    
    private Context ctxt;
    
    private int currTextView;
    
    private boolean stopGuessing;

    private HashMap<Integer, ArrayList<String>> alphabet;
	private ArrayList<String> passList;
	private ArtificialIntelligence ai;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		stopGuessing = false;
		FileParse parse = new FileParse();
		super.onCreate(savedInstanceState);
		ctxt = (Context) this;
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_battle);
		
		currTextView = 1;
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		password = bundle.getString("password");
		int GAMELEVEL = bundle.getInt("GAMELEVEL");
		TextView text = getTextView(currTextView);
		currTextView++;
		text.setText(spaceWord(password));
/*
		parse.parser();
		alphabet = parse.getAlphabet();
		passList = alphabet.get(password.length());
//*/
        ArrayList<String> passList = new ArrayList<String>();
        passList.add("fuck");//1
        passList.add("test");//2
        passList.add("pass");//3
        passList.add("love");//4
        passList.add("sexy");
        passList.add("mike");
        passList.add("john");//5
        passList.add("porn");
        passList.add("blue");
        passList.add("asdf");
        passList.add("jack");
        passList.add("golf");
        passList.add("bear");
        passList.add("fred");
        //*/
		ai = new ArtificialIntelligence(passList, ALPHABETIC);
		
		// ex: pass = "bear"
		/*String guess = ai.guess(); // ex: guess = "meat"
		String result = getResult(guess, password); // ex: result = "*ea*"
		ai.updatePassword(result);*/
		//repeat
		
		// 
		
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
		int count = 0;
		while(!stopGuessing){
			if (count > 6) break;
			playGame();
			count++;
		}
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
    
    @SuppressLint("NewApi")
	public void playGame() {
		//int numLetters = password.length();
		// ex: pass = "bear"
		String guess = ai.guess(); // ex: guess = "meat"
		TextView text = getTextView(currTextView++);
		text.setText(spaceWord(guess));
		// draw guess here
		//ViewGroup layout = (ViewGroup) findViewById(R.id.topLevel);
		/*TextView tv = new TextView(this);
		tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		tv.setText(guess);
		layout.addView(tv);*/
		System.out.println("guess=" + guess + " ; pass=" + password);
		stopGuessing = (password.equals(guess));
		String result = getResult(guess, password); // ex: result = "*ea*"
		ai.updatePassword(result);
		/*EditText et = new EditText(this);
		et.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));*/
		
    }
    
    public String spaceWord(String s){
    	String spaced = "";
    	for (int i = 0; i < s.length() - 1; i++){
    		String sLetter = String.valueOf(s.charAt(i));
    		spaced += sLetter + " ";
    	}
    	spaced += String.valueOf(s.charAt(s.length() - 1));
    	return spaced;
    }
    
    public TextView getTextView(int idx){
    	TextView text = null;
    	if (idx == 1){
    		System.out.println("idx==1");
    		text = (TextView) findViewById(R.id.helloworld);
    	} else if (idx == 2){
    		System.out.println("idx==2");
    		text = (TextView) findViewById(R.id.helloworld2);
    	} else if (idx == 3){
    		text = (TextView) findViewById(R.id.helloworld3);
    	} else if (idx == 4){
    		text = (TextView) findViewById(R.id.helloworld4);
    	} else if (idx == 5){
    		text = (TextView) findViewById(R.id.helloworld5);
    	} else if (idx == 6){
    		text = (TextView) findViewById(R.id.helloworld6);
    	} else if (idx == 7){
    		text = (TextView) findViewById(R.id.helloworld7);
    	} else if (idx == 8){
    		text = (TextView) findViewById(R.id.helloworld8);
    	} else if (idx == 9){
    		text = (TextView) findViewById(R.id.helloworld9);
    	} else if (idx == 10){
    		text = (TextView) findViewById(R.id.helloworld10);
    	} else if (idx == 11){
    		text = (TextView) findViewById(R.id.helloworld11);
    	} else if (idx == 12){
    		text = (TextView) findViewById(R.id.helloworld12);
    	} else if (idx == 13){
    		text = (TextView) findViewById(R.id.helloworld13);
    	} else if (idx == 14){
    		text = (TextView) findViewById(R.id.helloworld14);
    	} else if (idx == 15){
    		text = (TextView) findViewById(R.id.helloworld15);
    	} else if (idx == 16){
    		text = (TextView) findViewById(R.id.helloworld16);
    	}  
    	return text;
    }
        
    public Context getThisContext(){
    	return ctxt;
    }
}
