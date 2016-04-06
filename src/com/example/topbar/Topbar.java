package com.example.topbar;

import java.security.PublicKey;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Topbar extends RelativeLayout
{
	private Button leftButton,rightButton;
	private TextView tvTitle; 
	
	private int leftcolor;
	private Drawable leftbackground;
	private String leftText;
	
	private int rightcolor;
	private Drawable rightbackground;
	private String rightText;
	
	private int titletextcolor;
	private String Title;
	private float titleSize;
	
	private LayoutParams leftParams,rightParams,titleParams;
	private topbarClickListener listener;
	
	public interface topbarClickListener
	{
		public void leftClick();
		public void rightClick();
	}
	
	public void setOnTopbarClickListener(topbarClickListener listener)
	{
		this.listener = listener;
	}

	public Topbar(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		// TODO Auto-generated constructor stub 
	
		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Topbar);
		leftcolor = ta.getColor(R.styleable.Topbar_leftTextColor, 0);
		leftbackground = ta.getDrawable(R.styleable.Topbar_leftBackground);
		leftText = ta.getString(R.styleable.Topbar_leftText);
		
		rightcolor = ta.getColor(R.styleable.Topbar_rightTextColor, 0);
		rightbackground = ta.getDrawable(R.styleable.Topbar_rightBackground);
		rightText = ta.getString(R.styleable.Topbar_rightText);
		
		titletextcolor = ta.getColor(R.styleable.Topbar_titleTextColor, 0);
		Title = ta.getString(R.styleable.Topbar_title);	
		titleSize = ta.getDimension(R.styleable.Topbar_titleTextSize, 0);
		
		ta.recycle();
		
		leftButton = new Button(context);
		rightButton = new Button(context);
		tvTitle = new TextView(context);
		
		leftButton.setTextColor(leftcolor);
		leftButton.setBackground(leftbackground);
		leftButton.setText(leftText); 
		
		rightButton.setTextColor(rightcolor);
		rightButton.setBackground(rightbackground);
		rightButton.setText(rightText); 
		
		tvTitle.setTextColor(titletextcolor);
		tvTitle.setTextSize(titleSize);
		tvTitle.setText(Title);
		tvTitle.setGravity(Gravity.CENTER);
		
		setBackgroundColor(0xFFF59563);
		
		leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT , LayoutParams.WRAP_CONTENT);
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT , TRUE);
		addView(leftButton , leftParams);
		
		rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT , LayoutParams.WRAP_CONTENT);
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT , TRUE);
		addView(rightButton , rightParams);
		
		titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT , LayoutParams.WRAP_CONTENT);
		titleParams.addRule(RelativeLayout.CENTER_IN_PARENT , TRUE);
		addView(tvTitle ,titleParams);
		
		
		leftButton.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				listener.leftClick();
				
			}
		});
		
		rightButton.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				listener.rightClick();
				
			}
		});
		
		
	}
	
	public void setLeftIsvisable(boolean flag)
	{
		if (flag)
		{
			leftButton.setVisibility(View.VISIBLE);
		}
		else {
			leftButton.setVisibility(View.GONE);
		}
	}

}
