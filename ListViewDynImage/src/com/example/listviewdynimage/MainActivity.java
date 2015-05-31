package com.example.listviewdynimage;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements OnItemClickListener{

	ListView lview;
	String [] title;
	String [] descp;
	int [] imgs ={R.drawable.meme1,R.drawable.meme2,R.drawable.meme3,R.drawable.meme4,R.drawable.meme5,
			R.drawable.meme6,R.drawable.meme7,R.drawable.meme8,R.drawable.meme9,R.drawable.meme10,
			R.drawable.meme11,R.drawable.meme12,R.drawable.meme13,R.drawable.meme14,R.drawable.meme15,
			R.drawable.meme16,R.drawable.meme17,R.drawable.meme18,R.drawable.meme19,R.drawable.meme20};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lview = (ListView) findViewById(R.id.listView1);
        title = getResources().getStringArray(R.array.titles);
        descp = getResources().getStringArray(R.array.descriptions);
        DebAdapter myadampter = new DebAdapter(this, title, descp, imgs);
        lview.setAdapter(myadampter);
        lview.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this,DetailActivity.class);
		intent.putExtra("pos", position);
		startActivity(intent);
		Log.d("DEB","Item number "+position+" is clicked");
	}
}

class DebAdapter extends ArrayAdapter<String> {
	Context c;
	int [] imgs;
	String [] title;
	String [] descp;
	DebAdapter (Context c,String [] title,String [] descp, int [] imgs)
	{
		super(c, R.layout.simple_custom_layout, R.id.textView1, title);
		this.c=c;
		this.imgs = imgs;
		this.title = title;
		this.descp = descp;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View row = null;
		DebHolder holder=null;
		row = convertView;
		if (row==null)
		{
			LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.simple_custom_layout, parent,false);
			holder = new DebHolder(row);
			row.setTag(holder);
			Log.d("DEB", "Object is created");
		}
		else
		{
			holder = (DebHolder) row.getTag();
			Log.d("DEB","Object recycled");
		}
		holder.img.setImageResource(imgs[position]);
		holder.tview.setText(title[position]);
		holder.dview.setText(descp[position]);
		return row;
	}
}
class DebHolder {
	ImageView img;
	TextView tview;
	TextView dview;
	DebHolder(View v){
		img = (ImageView) v.findViewById(R.id.imageView1);
		tview = (TextView) v.findViewById(R.id.textView1);
		dview = (TextView) v.findViewById(R.id.textView2);
	}
}