package com.testing;

import com.example.crackscreen.R;
import com.example.crackscreen.R.anim;
import com.example.crackscreen.R.id;
import com.example.crackscreen.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class CrackViewActivity extends Activity 
{
	
	
	ImageView imageView1;
	ImageView imageView2;
	ImageView imageView3;
	ImageView imageView4;
	ImageView imageView5;
	ImageView imageView6;
	ImageView imageView7;
   
    
    boolean isImage1;
    boolean isImage2;
    boolean isImage3;
    boolean isImage4;
    boolean isImage5;
    boolean isImage6;
    boolean isImage7;
    
    
	 CrackViewActivity crackActivity;
	 ViewFlipper viewFlipper;

    
	 SharedPreferences prefs_check;
	 Editor edit_check;
	 Button button_selec;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crack_views);
		
		
		  crackActivity=this;
		 prefs_check= PreferenceManager.getDefaultSharedPreferences(crackActivity);
         edit_check = prefs_check.edit();

         
     //   button_select  = (Button) findViewById(R.id.button1);
         
         
        
      
		
		
		 viewFlipper = (ViewFlipper)findViewById(R.id.pager);
		
		 imageView1=(ImageView) findViewById(R.id.image_id1);
		 imageView2=(ImageView) findViewById(R.id.image_id2);
		 imageView3=(ImageView) findViewById(R.id.image_id3);
		 imageView4=(ImageView) findViewById(R.id.image_id4);
		 imageView5=(ImageView) findViewById(R.id.image_id5);
		 imageView6=(ImageView) findViewById(R.id.image_id6);
		 
		
		 
		 
		 imageView1.setOnTouchListener(new OnTouchListener() {
				
				

				
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
			
			
	      imageView2.setOnTouchListener(new OnTouchListener() {
				
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
	             
	             
//	             button_select.setOnClickListener(new View.OnClickListener() {
//	      			
//	      			@Override
//	      			public void onClick(View v) 
//	      			{
//	      				// TODO Auto-generated method stub
//	      			
//	      				Intent intent = new Intent(crackActivity, PrefsActivity.class);
//			            startActivity(intent);
//			            finish();
//	      			
//	      				
//	      			}
//	      		});
	}
		
		
		
		
	


@Override
		public boolean onTouchEvent(MotionEvent event)
        {
	
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
	    	
	    	
	    	viewFlipper.setInAnimation(crackActivity,R.anim.anim_in_from_right);
	    	viewFlipper.setOutAnimation(crackActivity,R.anim.anim_out_to_left);
	    	viewFlipper.showNext();
			
			
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
	    	
	    	viewFlipper.setInAnimation(crackActivity,R.anim.anim_in_from_left);
	    	viewFlipper.setOutAnimation(crackActivity,R.anim.anim_out_to_right);
	    	viewFlipper.showPrevious();
			
			
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







		@Override
		public void onBackPressed() 
		{
			// TODO Auto-generated method stub
			super.onBackPressed();
			
//			PrefsActivity.preference.setChecked(false);
			
			
			
			
			
		}
	
	
	

}
