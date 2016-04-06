package com.example.topbar;

import com.example.topbar.Topbar.topbarClickListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Topbar topbar = (Topbar) findViewById(R.id.topbar1);
		topbar.setOnTopbarClickListener(new topbarClickListener()
		{
			
			@Override
			public void rightClick()
			{
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "more", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void leftClick()
			{
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "back", Toast.LENGTH_SHORT).show();
			}
		});
		
		
		
		
	}

	
	
}
