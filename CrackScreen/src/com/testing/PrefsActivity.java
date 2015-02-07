package com.testing;


import com.example.crackscreen.GridViewActivity;
import com.example.crackscreen.R;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.util.Log;

public class PrefsActivity extends PreferenceActivity  
{
   
	
	static SharedPreferences prefs_check;
	 Editor edit_check;
	static boolean isCrack;
	PrefsActivity activity;
    Preference preferenceTrigger;
	
	
	public static  boolean isTouch;
	public static  boolean isDelay;
	
	  static Preference preference;
	  
	 
	
	@SuppressLint("NewApi")
	@SuppressWarnings("deprecation")
	@Override
    public void onCreate(Bundle savedInstanceState) 
	{
		
          super.onCreate(savedInstanceState);
          
          activity=this;
          
          
           addPreferencesFromResource(R.xml.settings);  
           
           prefs_check  = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
           isCrack      = prefs_check.getBoolean("prefCrack", false);
           preference   = findPreference("prefCrack");
         //  preferenceTrigger=findPreference("prefTrigger");
          

          
          
         
          
         
	      
//          preferenceTrigger.setOnPreferenceClickListener(new OnPreferenceClickListener() {
//			
//			@Override
//			public boolean onPreferenceClick(Preference preference) 
//			{
//				// TODO Auto-generated method stub
//				
//				  Intent intent = new Intent(activity, DelayActivity.class);
//		          startActivity(intent);
//		             
//		             
//				return false;
//			}
//		});

          
	      preference.setOnPreferenceClickListener(new OnPreferenceClickListener() 
	   {
	    	  
	                      public boolean onPreferenceClick(Preference prefer) 
	                      {
	                    	  
	                    	  
	                    		  
//                             		 isCrack=false;
//                    		         edit_check.putBoolean("prefCrack",false);
//		      		                 edit_check.commit() ;
	                    		     Intent intent = new Intent(activity, GridViewActivity.class);
			      		             startActivity(intent);
		      		           
			      		           Log.d("", "Preference manager IF");
                    	        
	                    	  
	                    	  
//	                    	  else
//	                    	  {
//	                    		  Log.d("", "Preference manager Else");
//	                    		  
////                    		      Intent intent = new Intent(activity, CrackViewActivity.class);
////			      		          startActivity(intent);
////	                    		  isCrack=true;
////	                    		  edit_check.putBoolean("prefCrack",true);
////		      		              edit_check.commit();
//	                    		  
//	                    	  }
	                    		 
		      		            
	                    	  
	                    	      
							  return false;
	                         
	                      }
	                  });
          
          
			 
          
    
	}
}
