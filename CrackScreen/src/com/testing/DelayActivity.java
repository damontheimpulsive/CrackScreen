package com.testing;

import com.example.crackscreen.R;
import com.example.crackscreen.R.xml;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class DelayActivity extends PreferenceActivity 
{
	
	 DelayActivity delay_Activity;
	SharedPreferences preferenceDelay;
	public static int delayLimit ;
	
	String string_delay;
	 Preference preferenceLimit;
	protected String str_delay;

	 
	 public static int limit;
	 
	@SuppressWarnings("deprecation")
	@Override
    public void onCreate(Bundle savedInstanceState) 
	{
		
          super.onCreate(savedInstanceState);
          
          delay_Activity =  this;
          
          
           addPreferencesFromResource(R.xml.delay); 
           final EditText editText1 = ((EditTextPreference) findPreference("prefDelay")).getEditText();
            editText1.addTextChangedListener(new TextWatcher() {
	
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		try 
		{
			
			
			
			if(s==null || s.equals(" ") || s.equals(""))
				return;
			
			
                int value=Integer.parseInt(s.toString());
                
                
                 if(value > 99)
                    editText1.setText("99");
              
		}
		
		catch (NumberFormatException e) 
		{
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
	}
	
	        @Override
	        public void beforeTextChanged(CharSequence s, int start, int count,int after) 
	{
		
		
		// TODO Auto-generated method stub
		
	}
	
	          @Override
	          public void afterTextChanged(Editable s) 
	       {
		// TODO Auto-generated method stub
		
	}
});
           preferenceDelay = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
           string_delay = preferenceDelay.getString("prefDelay", "");
           delayLimit = Integer.parseInt(string_delay);
           
          
           
           preferenceLimit = findPreference("prefDelay");
           
           preferenceLimit.setOnPreferenceChangeListener(new OnPreferenceChangeListener() 
           {
        	 
			@Override
			public boolean onPreferenceChange(Preference preference, Object newValue) 
			{
				// TODO Auto-generated method stub
				
				
				 str_delay = (String) newValue;
				 limit = Integer.parseInt(str_delay);
				 
				 
				 Log.d("", "limit Change="+limit);
				
				return false;
			}
		});
           
           
           
       
           
           
           
           
           
	}
	

}
