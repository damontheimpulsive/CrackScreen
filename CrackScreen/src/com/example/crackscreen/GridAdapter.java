package com.example.crackscreen;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridAdapter  extends BaseAdapter
{
	Context context;
	
	Integer gridId[]=
{
			
			R.drawable.crack_fs1,
			R.drawable.crack_fs2,
			R.drawable.crack_fs3,
			R.drawable.crack_fs4,
			R.drawable.crack_fs5,
			R.drawable.crack_fs6,
			
					
			
	};
	
	 Drawable drawableArray[]= new Drawable[2];  
	 LayerDrawable layerDrawable;

	private int img_value1;
	
	public GridAdapter(Context ctx)
	{
		context=ctx;
		img_value1 =   PreferenceManager.getDefaultSharedPreferences(context).getInt("keyValue1", 1);
	
		
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return gridId.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return gridId[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		// TODO Auto-generated method stub
		
		ImageView imageView =new ImageView(context);
		imageView.setBackgroundColor(Color.parseColor("#20ffffff"));
		imageView.setAdjustViewBounds(true);
		imageView.setImageResource(gridId[position]);
		 imageView.setScaleType(ImageView.ScaleType.FIT_XY);
		 
		 
		 if(position==img_value1-1)
		 {
			 drawableArray[0]=context.getResources().getDrawable(gridId[position]);
		    drawableArray[1]=context.getResources().getDrawable(R.drawable.tick_ok);
		  
		 layerDrawable  = new LayerDrawable(drawableArray);
		 imageView.setImageDrawable(layerDrawable);
			 
		 }
		 
		 
	       
		
		
		return imageView;
	}

}
