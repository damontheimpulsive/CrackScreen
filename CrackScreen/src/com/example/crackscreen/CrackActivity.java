package com.example.crackscreen;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CrackActivity extends Activity {

	Button button_start;
	Button button_option;
	Button button_exit;

	SharedPreferences prefs_check;
	Editor edit_check;
	String string_value;
	String str_value;
	String shake_clear;
	
	public static int delayCrack;

	public static boolean isTouch;
	public static boolean isDelay;
	
	public static boolean isClear;
	public static boolean isChange;

	public static CrackActivity activity;

	ImageView image_start;
	ImageView image_option;
	ImageView image_exit;
	ImageView image_logo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crack);
	

		activity = CrackActivity.this;

	

		image_logo = (ImageView) findViewById(R.id.image_id0);
		image_start = (ImageView) findViewById(R.id.image_id1);
		image_option = (ImageView) findViewById(R.id.image_id2);
		image_exit = (ImageView) findViewById(R.id.image_id3);

		prefs_check = PreferenceManager.getDefaultSharedPreferences(activity);
		edit_check = prefs_check.edit();
//		edit_check.remove("keyValue1");
//		edit_check.commit();

		if (PrefsActivity.prefs_check != null)
			PrefsActivity.isCrack = false;

//		if (BackService.relativeLayout != null)
//		{
//		    
//			BackService.windowManager.removeView(BackService.relativeLayout);
//			BackService.isShake = false;
//			BackService.relativeLayout = null;
//			
//		}

		if (BackService.notificationManager != null)
			BackService.notificationManager.cancel(R.string.crackService);
		

		stopService(new Intent(CrackActivity.this, BackService.class));

		image_start.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub

				if (event.getAction() == MotionEvent.ACTION_DOWN)
					image_start.setImageResource(R.drawable.start_touch);

				if (event.getAction() == MotionEvent.ACTION_UP)
					image_start.setImageResource(R.drawable.start);

				return false;
			}
		});

		image_option.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub

				if (event.getAction() == MotionEvent.ACTION_DOWN)
					image_option.setImageResource(R.drawable.option_touch);

				if (event.getAction() == MotionEvent.ACTION_UP)
					image_option.setImageResource(R.drawable.option);

				return false;
			}
		});

		image_exit.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub

				if (event.getAction() == MotionEvent.ACTION_DOWN)
					image_exit.setImageResource(R.drawable.exit_touch);

				if (event.getAction() == MotionEvent.ACTION_UP)
					image_exit.setImageResource(R.drawable.exit);

				return false;
			}
		});

		image_start.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				string_value =    prefs_check.getString("prefSyncFrequency", "touch");
				str_value    =    prefs_check.getString("prefTimer", "10");
				
				shake_clear  =     prefs_check.getString("prefShaker", "clear");
				

				delayCrack = Integer.parseInt(str_value);
				Log.d("", "DelayCrack="+delayCrack);
				Log.d("", "Shake_value="+shake_clear);
				
				Toast.makeText(getApplicationContext(), "Now you can add the cracks", Toast.LENGTH_LONG).show();
				
				if(shake_clear.equals("clear"))
				{
					isClear=true;
					isChange=false;
					
				}
				
				if(shake_clear.equals("change"))
				{
					
					isChange=true;
					isClear=false;
					
				}
				
				
				if (string_value.equals("touch")) 
				{

					isTouch = true;
					isDelay = false;
		       }

				if (string_value.equals("delay")) 
				{

					isDelay = true;
					isTouch = false;
				

				}
				
				/*
				 Explicit intents designate the target component by its name (the component name field, has a value set). 
				  */

				startService(new Intent(CrackActivity.this, BackService.class));
				finish();

			}
		});

		image_option.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(activity, PrefsActivity.class);
				startActivity(intent);

			}
		});

		image_exit.setOnClickListener(new View.OnClickListener() 
		{

			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(activity);
				 builder.setTitle("Alert");
		         builder.setMessage("Are you sure?");
		         builder.setCancelable(true);
		         
				// Add the buttons
				builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() 
				{
					
				           public void onClick(DialogInterface dialog, int id) 
				           {
				        	   
				               // User clicked OK button
				        	   finish();
				           }
				       });
				
				
				builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() 
				{
					
				           public void onClick(DialogInterface dialog, int id) 
				           {
				        	   
				               // User cancelled the dialog
				        	   
				        	   dialog.cancel();
				           }
				       });
				  
				AlertDialog dialog = builder.create();
				  dialog.setCancelable(false);
		           dialog.setCanceledOnTouchOutside(false);
				dialog.show();
				

			}
		});

	}

	

}
