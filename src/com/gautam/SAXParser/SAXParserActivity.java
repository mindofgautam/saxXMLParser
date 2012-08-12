package com.gautam.SAXParser;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class SAXParserActivity extends Activity {

	private XMLGettersSetters data;
	private ListView news;
	private ProgressDialog progress;
	private String[] item;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/**
		 * Layout for Main activity
		 **/
		setContentView(R.layout.main);
		progress = new ProgressDialog(this);
		progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progress.setCancelable(true);
		progress.setTitle("Just Wait");
		progress.setMessage("Loading");
		progress.show();
		news = (ListView) findViewById(R.id.listView1);
		news.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				TextView url = (TextView) arg1.findViewById(R.id.rowText2);

				Intent intent = new Intent(SAXParserActivity.this,
						ViewAndroid.class);
				intent.putExtra("address", url.getText().toString());
				startActivity(intent);
			}
		});
		asyncTask asyncThread = new asyncTask();
		asyncThread.execute();
	}

	private void downloadUrl() {

		try {

			/**
			 * Create a new instance of the SAX parser
			 **/
			SAXParserFactory saxPF = SAXParserFactory.newInstance();
			SAXParser saxP = saxPF.newSAXParser();
			XMLReader xmlR = saxP.getXMLReader();
			/**
			 * URL of the Feeds
			 **/
			URL url = new URL("http://feeds.bbci.co.uk/news/technology/rss.xml");

			/**
			 * Create the Handler to handle each of the XML tags.
			 **/
			XMLHandler myXMLHandler = new XMLHandler();
			xmlR.setContentHandler(myXMLHandler);
			xmlR.parse(new InputSource(url.openStream()));
			data = XMLHandler.data;
			Log.v("count", "Total Values are:" + data.getTitle().size());
			/**
			 * Splitting each news
			 **/
			item = data.b.toString().split("END");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * AsyncTask loading thedata in background
	 * 
	 * @author cynogn
	 * 
	 */
	class asyncTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPostExecute(Void result) {
			news.setAdapter(new CustomAdapter(SAXParserActivity.this, item));
			progress.dismiss();
			super.onPostExecute(result);
		}

		@Override
		protected Void doInBackground(Void... params) {
			downloadUrl();
			return null;
		}
	}
}
