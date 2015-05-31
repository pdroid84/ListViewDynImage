package com.example.listviewdynimage;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends ActionBarActivity {
	String [] title;
	String [] descp;
	int [] imgs ={R.drawable.meme1,R.drawable.meme2,R.drawable.meme3,R.drawable.meme4,R.drawable.meme5,
			R.drawable.meme6,R.drawable.meme7,R.drawable.meme8,R.drawable.meme9,R.drawable.meme10,
			R.drawable.meme11,R.drawable.meme12,R.drawable.meme13,R.drawable.meme14,R.drawable.meme15,
			R.drawable.meme16,R.drawable.meme17,R.drawable.meme18,R.drawable.meme19,R.drawable.meme20};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		Intent intent = getIntent();
		int index = intent.getIntExtra("pos", 0);
		title = getResources().getStringArray(R.array.titles);
		descp = getResources().getStringArray(R.array.descriptions);
		TextView tv = (TextView) findViewById(R.id.textViewDetailTitle);
		TextView dv = (TextView) findViewById(R.id.textViewDetailDescp);
		ImageView imgv = (ImageView) findViewById(R.id.imageViewDetail);
		tv.setText(title[index]);
		dv.setText(descp[index]);
		imgv.setImageResource(imgs[index]);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
