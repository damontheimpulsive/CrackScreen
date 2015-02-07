package com.example.crackscreen;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class GridViewActivity extends Activity {

	SharedPreferences prefs_check;
	Editor edit_check;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid);
		prefs_check = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		edit_check = prefs_check.edit();

		GridView gridView = (GridView) findViewById(R.id.grid_view);
		gridView.setAdapter(new GridAdapter(this));

		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) 
			{
				
				
		
				
				edit_check.putInt("keyValue1", position + 1);
				edit_check.commit();
				finish();

				// TODO Auto-generated method stub

			}

		});

	}

}
