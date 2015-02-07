package com.example.crackscreen;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class PrefsActivity extends PreferenceActivity  
{
   
	
	static SharedPreferences prefs_check;
	static boolean isCrack;
	PrefsActivity activity;
    static Preference preference;
	  
	 
	
	@SuppressLint("NewApi")
	@SuppressWarnings("deprecation")
	@Override
    public void onCreate(Bundle savedInstanceState) 
	{
		
          super.onCreate(savedInstanceState);
          
          activity=this;
          
          
           addPreferencesFromResource(R.xml.settings);  
           
           prefs_check  = PreferenceManager.getDefaultSharedPreferences(activity);
           preference   = findPreference("prefCrack");
           
	      preference.setOnPreferenceClickListener(new OnPreferenceClickListener() 
	   {
	    	  
	                      public boolean onPreferenceClick(Preference prefer) 
	                      {
	                    	
	                    		     Intent intent = new Intent(activity, GridViewActivity.class);
			      		             startActivity(intent);
		      		           
			        return false;
	                         
	                      }
	                  });
          
          
			 
          
    
	}
}
