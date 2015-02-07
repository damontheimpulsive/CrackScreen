package com.testing;








import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.crackscreen.BackService;
import com.example.crackscreen.PrefsActivity;
import com.example.crackscreen.R;


public class CopyOfCrackActivity extends Activity 
{
	
	ImageView imageView1;
	ImageView imageView2;
	ImageView imageView3;
	ImageView imageView4;
	ImageView imageView5;
	ImageView imageView6;
	ImageView imageView7;
	Button button_start;
    Button button_option;
	
	 SharedPreferences prefs_check;
	 Editor edit_check;
     SharedPreferences prefs_settings;
     ViewFlipper page;
    
 
            boolean isImage1;
            boolean isImage2;
            boolean isImage3;
            boolean isImage4;
            boolean isImage5;
            boolean isImage6;
            boolean isImage7;
	 
	 
	 int img_value=0;
	static boolean isCrack;
	 

	
       static  boolean isView1;
       static  boolean isView2;
       static  boolean isView3;
       static CopyOfCrackActivity activity;
	
      
       
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crack);
		
		
		activity= CopyOfCrackActivity.this;
		
		Log.d("", "Copy cat is running");
		
//		  button_start  = (Button) findViewById(R.id.button1);
//		  button_option = (Button) findViewById(R.id.button2);
		  
		 imageView1=(ImageView) findViewById(R.id.image_id1);
		 imageView2=(ImageView) findViewById(R.id.image_id2);
		 imageView3=(ImageView) findViewById(R.id.image_id3);
		 imageView4=(ImageView) findViewById(R.id.image_id4);
		 imageView5=(ImageView) findViewById(R.id.image_id5);
		 imageView6=(ImageView) findViewById(R.id.image_id6);
		
		  page = (ViewFlipper)findViewById(R.id.pager);
		 
		         prefs_check = PreferenceManager.getDefaultSharedPreferences(activity);
		         edit_check  = prefs_check.edit();
		         isCrack     = prefs_check.getBoolean("prefCrack", true);
		         edit_check.remove("keyValue1");
		         edit_check.commit();

		 
		 if(BackService.relativeLayout!=null)
		 {
			 BackService.windowManager.removeView(BackService.relativeLayout);
			 BackService.isShake=false;
			 BackService.relativeLayout=null;
		 }
		 
		 if(BackService.notificationManager!=null)
			 BackService.notificationManager.cancel(R.string.crackService);
			
		
		 
		 
		 stopService(new Intent(CopyOfCrackActivity.this,BackService.class));
		 
		 button_start.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
			
				startService(new Intent(CopyOfCrackActivity.this,BackService.class));
				finish();
				
			}
		});
		 
		 button_option.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				  Intent intent = new Intent(activity, PrefsActivity.class);
		            startActivity(intent);
				
			}
		});
		
		 
		 
		 if(isCrack)
		 {
			  Intent intent = new Intent(activity, CrackViewActivity.class);
	            startActivity(intent);
		 }
			 
		imageView1.setOnTouchListener(new OnTouchListener() 
		{
			
			@Override
			public boolean onTouch(View v, MotionEvent event) 
			{
				
				// TODO Auto-generated method stub
				gestureDetector.onTouchEvent(event);
		
				isImage1=true;
				isImage2=false;
				isImage3=false;
				isImage4=false;
				isImage5=false;
				isImage6=false;
				isImage7=false;
				
			  
				return false;
			}
		});
		
		
      imageView2.setOnTouchListener(new OnTouchListener() 
      {
    	   @Override
			public boolean onTouch(View v, MotionEvent event) 
			{
				
				// TODO Auto-generated method stub
				gestureDetector.onTouchEvent(event);
				
				
		
			isImage1=false;
			isImage2=true;
			isImage3=false;
			isImage4=false;
			isImage5=false;
			isImage6=false;
			isImage7=false;
				
			
				return false;
			}
		});
               
             
               
               imageView3.setOnTouchListener(new OnTouchListener() {
       			
       			@Override
       			public boolean onTouch(View v, MotionEvent event) 
       			{
       				
       				// TODO Auto-generated method stub
       				
       			
    			
    			isImage1=false;
				isImage2=false;
				isImage3=true;
				isImage4=false;
				isImage5=false;
				isImage6=false;
				isImage7=false;
    			      
    			      
       				gestureDetector.onTouchEvent(event);
       				
       				
    
       				return false;
       			}
       		});
               
             imageView4.setOnTouchListener(new View.OnTouchListener() {
				
				@Override
				public boolean onTouch(View v, MotionEvent event) 
				{
					// TODO Auto-generated method stub
					isImage1=false;
					isImage2=false;
					isImage3=false;
					isImage4=true;
					isImage5=false;
					isImage6=false;
					isImage7=false;
					return false;
				}
			});
             
             
             imageView5.setOnTouchListener(new View.OnTouchListener() {
				
				@Override
				public boolean onTouch(View v, MotionEvent event) 
				{
					// TODO Auto-generated method stub
					isImage1=false;
					isImage2=false;
					isImage3=false;
					isImage4=false;
					isImage5=true;
					isImage6=false;
					isImage7=false;
					return false;
				}
			});
             
             imageView6.setOnTouchListener(new View.OnTouchListener() {
				
				@Override
				public boolean onTouch(View v, MotionEvent event) 
				{
					// TODO Auto-generated method stub
					
					isImage1=false;
					isImage2=false;
					isImage3=false;
					isImage4=false;
					isImage5=false;
					isImage6=true;
					isImage7=false;
					return false;
				}
			});
			
             
             imageView7.setOnTouchListener(new View.OnTouchListener() {
 				
 				@Override
 				public boolean onTouch(View v, MotionEvent event) 
 				{
 					// TODO Auto-generated method stub
 					
 					isImage1=false;
 					isImage2=false;
 					isImage3=false;
 					isImage4=false;
 					isImage5=false;
 					isImage6=false;
 					isImage7=true;
 					return false;
 				}
 			});
}
	
	
	
	
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) 
	 {
		 
	        getMenuInflater().inflate(R.menu.settings, menu);
	        return true;
	    
	 
	 }
	 
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        switch (item.getItemId()) {
	 
	        case R.id.menu_settings:
	          
	            break;
	 
	        }
	 
	        return true;
	    }
	 

	    
	    @Override
		public boolean onTouchEvent(MotionEvent event) {
			// TODO Auto-generated method stub
	    	return gestureDetector.onTouchEvent(event);
		}
	
	    
	    SimpleOnGestureListener simpleOnGestureListener  = new SimpleOnGestureListener()
	    {
	    	@Override
			public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,float velocityY) 
	    	{

				float sensitvity = 30;
				
				if((e1.getX() - e2.getX()) > sensitvity)
				      SwipeRight();
				
				
				 if((e2.getX() - e1.getX()) > sensitvity)
				              	SwipeLeft();
				
				
				return true;
			}
	    	
	    	
	    	
	    };
	    
	    @SuppressWarnings("deprecation")
		GestureDetector gestureDetector  = new GestureDetector(simpleOnGestureListener);
	    
	    private void SwipeRight()
	    {
	    	
	    	
	    	page.setInAnimation(activity,R.anim.anim_in_from_right);
			page.setOutAnimation(activity,R.anim.anim_out_to_left);
			page.showNext();
			
			
			if(isImage1)
			{
				 edit_check.putInt("keyValue1", 2);
			       edit_check.commit();
			}
			
			if(isImage2)
			{
				 edit_check.putInt("keyValue1", 3);
			       edit_check.commit();
			}
			
			if(isImage3)
			{
				 edit_check.putInt("keyValue1", 4);
			       edit_check.commit();
			}
			
			if(isImage4)
			{
				 edit_check.putInt("keyValue1", 5);
			       edit_check.commit();
			}
			
			if(isImage5)
			{
				 edit_check.putInt("keyValue1", 6);
			       edit_check.commit();
			}
			
			if(isImage6)
			{
				 edit_check.putInt("keyValue1", 7);
			       edit_check.commit();
			}
			
			if(isImage7)
			{
				 edit_check.putInt("keyValue1", 1);
			       edit_check.commit();
			}
	    }
	    
	    private void SwipeLeft()
	    {
	    	
	    	page.setInAnimation(activity,R.anim.anim_in_from_left);
			page.setOutAnimation(activity,R.anim.anim_out_to_right);
			page.showPrevious();
			
			
			if(isImage1)
			{
				 edit_check.putInt("keyValue1", 7);
			     edit_check.commit();
			}
			
			if(isImage2)
			{
				 edit_check.putInt("keyValue1", 1);
			     edit_check.commit();
			}
			
			if(isImage3)
			{
				 edit_check.putInt("keyValue1", 2);
			     edit_check.commit();
			}
			
			if(isImage4)
			{
				 edit_check.putInt("keyValue1", 3);
			     edit_check.commit();
			}
			
			if(isImage5)
			{
				 edit_check.putInt("keyValue1", 4);
			     edit_check.commit();
			}
			
			if(isImage6)
			{
				 edit_check.putInt("keyValue1", 5);
			     edit_check.commit();
			}
			
			if(isImage7)
			{
				 edit_check.putInt("keyValue1", 6);
			     edit_check.commit();
			}
	    
	    }




		



}
