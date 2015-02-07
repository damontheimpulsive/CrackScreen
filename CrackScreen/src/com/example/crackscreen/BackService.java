package com.example.crackscreen;


import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.SoundPool;
import android.os.IBinder;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class BackService   extends Service implements SensorEventListener
{
	
	
	
	 static LayoutParams layoutParams;
	 public static WindowManager windowManager;
     static  ImageView imageView_small;
	
	 
	 
	public static  RelativeLayout relativeLayout;

	 Bitmap bitmap;
	 SharedPreferences prefs_check;
	 boolean isView1;
	 boolean isView2;
	 boolean isView3;
	 boolean isSound;
	 boolean isVibrate;
	 Vibrator vibrateOn;
	 SoundPool soundPool;
	 
	 int img_value1;
	 int img_value2;
	 int img_value3;
	  int n1, n2=0;
	 
	 
	 SensorManager sensorManager;
	 float alpha;
     float beta;
     float gamma;

	 float last_x;
     float last_y;
     float last_z;
     long lastUpdate;
	 public static  boolean isShake;
	 static  boolean isCrack;
 
	
     
     ArrayList<Integer> crackId = new ArrayList<Integer>();
     ArrayList<Integer> crackEffectId = new ArrayList<Integer>();
     
     
	   Random random;
	  Timer myTimer;
	  int delayValue;
	
	
	 
	 
	public static NotificationManager notificationManager;

	@Override
	public void onCreate()
	{
		// TODO Auto-generated method stub
		super.onCreate();
		 random=new Random();
		
		 
		 if(CrackActivity.isTouch)
		 {
			 layoutParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
                  	WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                          PixelFormat.TRANSLUCENT);
		 }
		 
		 if(CrackActivity.isDelay)
		 {
			 layoutParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                                                           WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                                                            PixelFormat.TRANSLUCENT);
				            
		 }
		 
		 
		
		 
		/*layoutParams = new WindowManager.LayoutParams(
	               WindowManager.LayoutParams.MATCH_PARENT, 
	               WindowManager.LayoutParams.MATCH_PARENT,
	                WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
	                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
	                |WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
	                |WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
	                 PixelFormat.TRANSLUCENT);*/
		 
		 
	//	layoutParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT, 2007, 8, -3);
		
		    windowManager =(WindowManager) getSystemService(WINDOW_SERVICE);
		    vibrateOn=(Vibrator) getSystemService(VIBRATOR_SERVICE);
		    soundPool=new SoundPool(10,android.media.AudioManager.STREAM_MUSIC,0);
		    notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
	    	showNotification();
	       sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
  	       sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
		  
		 
		  
		    prefs_check = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		    isSound= prefs_check.getBoolean("prefsound", true);
			isVibrate=prefs_check.getBoolean("prefvibrate",true);
			isShake=prefs_check.getBoolean("prefShake", true);
			isCrack=prefs_check.getBoolean("prefCrack", true);
		    img_value1 = prefs_check.getInt("keyValue1", 1);
		    
		    
		    
		    
			   crackEffectId.add(soundPool.load(getApplicationContext(),R.raw.crack_01, 1));
	  	       crackEffectId.add(soundPool.load(getApplicationContext(), R.raw.crack_02, 1));
	  		   crackEffectId.add(soundPool.load(getApplicationContext(), R.raw.crack_03, 1));
	  		   crackEffectId.add(soundPool.load(getApplicationContext(), R.raw.crack_04, 1));
	  		   crackEffectId.add(soundPool.load(getApplicationContext(), R.raw.crack_05, 1));
	  		   crackEffectId.add(soundPool.load(getApplicationContext(), R.raw.crack_06, 1));
	  		   crackEffectId.add(soundPool.load(getApplicationContext(), R.raw.crack_07, 1));
		
	
	
			
			   crackId.add(R.drawable.crack_fs1);
	    	   crackId.add(R.drawable.crack_fs2);
	    	   crackId.add(R.drawable.crack_fs3);
	    	   crackId.add(R.drawable.crack_fs4);
	    	   crackId.add(R.drawable.crack_fs5);
	    	   crackId.add(R.drawable.crack_fs6);
	    	   
	    	  
	    	
	    	  
	    	  relativeLayout = new RelativeLayout(getApplicationContext());
	    	  relativeLayout.setFocusable(true);
	    	  relativeLayout.setFocusableInTouchMode(true);
	    	   windowManager.addView(relativeLayout, layoutParams);
	    	
			  
			if(CrackActivity.isDelay)
		              delayMethod(); 
		    	 
		
				
			 
			  
			  relativeLayout.setOnTouchListener(new View.OnTouchListener() {
				
				@Override
				public boolean onTouch(View v, MotionEvent event) 
				{
					
					
					 Log.d("", "Touch Value in On Touch="+CrackActivity.isTouch);
					 
					 
					if(CrackActivity.isTouch)
					 {
					
					switch (event.getAction()) 
					{
					
					
					case MotionEvent.ACTION_DOWN:
						
						
							
							  layoutParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY, 
									                                                       0,PixelFormat.TRANSLUCENT);
                              windowManager.removeView(relativeLayout);
                              windowManager.addView(relativeLayout, layoutParams);
							  relativeLayout.setBackgroundResource(crackId.get(img_value1-1));
							  
							   if(isVibrate)
								  {
							        	  
									  vibrateOn.vibrate(100);
									  isVibrate=false;
									  
								  }
									  
								  if(isSound)
								  {
									  soundPool.play(crackEffectId.get(random.nextInt(7)), 1 , 1, 0, 0, 1);
									  isSound=false;
								  }
								  
								
						 
						
						
						break;

					case MotionEvent.ACTION_UP:
						
						
						
					CrackActivity.isTouch=false;
					}
					
					
					 }
					// TODO Auto-generated method stub
					return false;
				}
			});
	    	   	  	
	}

	
	
	
	@SuppressWarnings("deprecation")
	private void showNotification() 
	{
		// TODO Auto-generated method stub
		
		/*
		 * A PendingIntent is a token that you give to a foreign application 
		 * (e.g. NotificationManager, AlarmManager, Home Screen AppWidgetManager, or other 3rd party applications), 
		 * which allows the foreign application to use your application's permissions to execute a predefined piece of code
		 */
	        
	        
	        Notification notification = new Notification(R.drawable.crack_fs1, getText(R.string.crackService),System.currentTimeMillis());
	        Intent notificationIntent = new Intent(this,CrackActivity.class);
	        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
	        notification.setLatestEventInfo(this, getText(R.string.crackService),getText(R.string.crackService), pendingIntent);
	        startForeground(R.string.crackService, notification);
		
		
		
	}
	
	public void delayMethod()
	{
		
		
		    myTimer = new Timer();
   	        myTimer.schedule(new TimerTask() 
           {          
   		   
   	 @Override
   	   public void run() 
   	   {
   		   
   		        img_value1 = prefs_check.getInt("keyValue1", 1);
   	            CrackActivity.activity.runOnUiThread(new Runnable() {
						
						@Override
						public void run() 
						{
							// TODO Auto-generated method stub
							
						
							
							switch(img_value1)
							  {
							  	  
							  case 1:
								   if(CrackActivity.isDelay)
								  {		
									   
									  if(relativeLayout!=null)
									  relativeLayout.setBackgroundResource(R.drawable.crack_fs1);
									  
									  Log.d("", "limit 1");
									  
									  
									        if(isVibrate)
										  {
											  vibrateOn.vibrate(100);
											  isVibrate=false;
										  }
											  
										  if(isSound)
										  {
											  soundPool.play(crackEffectId.get(random.nextInt(7)), 1 , 1, 0, 0, 1);
											  isSound=false;
										  }
										  
								  }
								  
								       img_value1=0;
									  
								  break;
								  
							  case 2:
								  
								  if(CrackActivity.isDelay)
								  {
									  
									  
									  if(relativeLayout!=null)
								         relativeLayout.setBackgroundResource(R.drawable.crack_fs2);
									  
									  Log.d("", "limit 2");
									  
									  
									  
								  if(isVibrate)
								  {
									  vibrateOn.vibrate(100);
									  isVibrate=false;
								  }
									  
								  if(isSound)
								  {
									  soundPool.play(  crackEffectId.get(random.nextInt(7)), 1 , 1, 0, 0, 1);
									  isSound=false;
								  }
							  }
								  img_value1=0;
								  
								  break;
								  
								  
							  case 3:
								  
								  if(CrackActivity.isDelay)
								  {
									  
									  if(BackService.relativeLayout!=null)
								          relativeLayout.setBackgroundResource(R.drawable.crack_fs3);	
									  
									  Log.d("", "limit 3");
									  
									  
								  if(isVibrate)
								  {
									  vibrateOn.vibrate(100);
									  isVibrate=false;
								  }
									  
								  if(isSound)
								  {
									  soundPool.play(crackEffectId.get(random.nextInt(7)), 1 , 1, 0, 0, 1);
									  isSound=false;
								  }
							  }
								  img_value1=0;
								  
								  break;
								  
								  
							  case 4:
								  
								  if(CrackActivity.isDelay)
								  {						  
									  
									  if(BackService.relativeLayout!=null)
								        relativeLayout.setBackgroundResource(R.drawable.crack_fs4);	
									  
									  Log.d("", "limit 4");
								  
								  if(isVibrate)
								  {
									  vibrateOn.vibrate(100);
									  isVibrate=false;
								  }
									  
								  if(isSound)
								  {
									  soundPool.play(crackEffectId.get(random.nextInt(7)), 1 , 1, 0, 0, 1);
									  isSound=false;
								  }
								  }
								  img_value1=0;
								  
								  break;
								  
							  case 5:
								  
								  
								  if(CrackActivity.isDelay)
								  {
									  if(BackService.relativeLayout!=null)
								             relativeLayout.setBackgroundResource(R.drawable.crack_fs5);	
									  
									  Log.d("", "limit 5");
									  
									  
								  if(isVibrate)
								  {
									  vibrateOn.vibrate(100);
									  isVibrate=false;
								  }
									  
								  if(isSound)
								  {
									  soundPool.play(crackEffectId.get(random.nextInt(7)), 1 , 1, 0, 0, 1);
									  isSound=false;
								  }
							  }
								  
								  img_value1=0;
								  
								  break;
								  
								  
								  
							  case 6:
								  
								  
								  if(CrackActivity.isDelay)
								  {
									 if(BackService.relativeLayout!=null)
								         relativeLayout.setBackgroundResource(R.drawable.crack_fs6);	
									  
									  Log.d("", "limit 6");
									  
								  if(isVibrate)
								  {
									  vibrateOn.vibrate(100);
									  isVibrate=false;
								  }
									  
								  if(isSound)
								  {
									  soundPool.play(crackEffectId.get(random.nextInt(7)), 1 , 1, 0, 0, 1);
									  isSound=false;
								  }
								  }
								  
								  img_value1=0;
								  
								  
								  
								  
								  
//							  case 7:
//								  
//								  if(CrackActivity.isDelay)
//								  {		
//									  
//									 if(BackService.relativeLayout!=null)
//								            relativeLayout.setBackgroundResource(R.drawable.crack_fs7);	
//									  
//									  Log.d("", "limit 7");
//									  
//									  
//								  if(isVibrate)
//								  {
//									  vibrateOn.vibrate(100);
//									  isVibrate=false;
//								  }
//									  
//								  if(isSound)
//								  {
//									  soundPool.play(crackEffectId.get(random.nextInt(7)), 1 , 1, 0, 0, 1);
//									  isSound=false;
//								  }
//								  
//								  
//								  }
								  
								 
								  
								  
							  }
							
						}
					});
   	            
   	           
   	           
   	   }
   	 
   	   }, CrackActivity.delayCrack*1000); 
   	        
   	     Log.d("", "Delayvalue in Thread="+CrackActivity.delayCrack*1000);
		
	}




	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void onSensorChanged(SensorEvent sensorEvent) 
	{
		// TODO Auto-generated method stub
		n1 = random.nextInt(5);
		if(n1==n2)
		       n1 = (n1==3)?n1-1:n1+1;
	
		n2 = n1;
		 if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) 
		      getAccelerometer(sensorEvent);
		
	}




	@SuppressWarnings("deprecation")
	private void getAccelerometer(SensorEvent sensorEvent)
	{
		// TODO Auto-generated method stub
		long curTime = System.currentTimeMillis();
		 
	  
	 
	    if ((curTime - lastUpdate) > 100) 
	    {
	    	
	      long diffTime = (curTime - lastUpdate);
	      lastUpdate = curTime;

	      alpha = sensorEvent.values[SensorManager.DATA_X];
	      beta  = sensorEvent.values[SensorManager.DATA_Y];
	      gamma = sensorEvent.values[SensorManager.DATA_Z];

	      float speed = Math.abs(alpha+beta+gamma- (last_x+last_y+last_z) )/diffTime*1000;
	    
	        isSound=prefs_check.getBoolean("prefsound", true);
			isVibrate=prefs_check.getBoolean("prefvibrate",true);
	      
	      if (speed > 200 ) 
	      {
	    	 
	    	           if(isVibrate)
			           vibrateOn.vibrate(100);
			            
//	    	               if (relativeLayout != null) 
//			           {
//			        	     windowManager.removeView(relativeLayout);
//			   			    isShake = false;
//			   			    // relativeLayout = null;
//			   			   
//			           }
	    	           
	    	           
	    	           if(CrackActivity.isChange)
	    	           {
	    	        	   relativeLayout.setBackgroundResource(crackId.get(n1));
	    	        	   
	    	        	   
	    	           }
	    	           
	    	           if(CrackActivity.isClear)
	    	           {
	    	        	   
	    	        	   if(relativeLayout!=null)
		    	           {
		    	        	   
		    	        	   
		    	        	   if(!CrackActivity.isDelay)
		    	        	   {
		    	        		   layoutParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
		                                                                         WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
	                                                                               PixelFormat.TRANSLUCENT);
	                                 windowManager.removeView(relativeLayout);
	                                 relativeLayout.setBackgroundResource(0);
	                                   windowManager.addView(relativeLayout, layoutParams);
	                                   CrackActivity.isTouch=true;
	                                   
	                                   
		    	        	   }
		    	        	   
		    	        	  if(CrackActivity.isDelay)
		    	        	   {
		    	        		      windowManager.removeView(relativeLayout);
		    	        		      relativeLayout.setBackgroundResource(0);
		    	        		      relativeLayout=null;
		    	        		   
		    	        	   }
			    	      
		    	           }   
	    	           }
	    	          		
	    		 
	     }
	     
	      last_x = alpha;
	      last_y = beta;
	      last_z = gamma;
	      
	    }
    
		
		
	}




	@Override
	public void onDestroy()
	{
		
		// TODO Auto-generated method stub
		super.onDestroy();
		
		if(relativeLayout!=null)
			windowManager.removeView(relativeLayout);
	}




	
}
