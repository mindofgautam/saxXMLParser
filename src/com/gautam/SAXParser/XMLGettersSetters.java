package com.gautam.SAXParser;

import java.util.ArrayList;

import android.util.Log;

/**
 * This class contains all getter and setter methods to set and retrieve data.
 * 
 **/
public class XMLGettersSetters {
	String Value1;
	String Value2;
	String Value3;
	StringBuffer b = new StringBuffer();
	public ArrayList<String> title = new ArrayList<String>();
	public ArrayList<String> artist = new ArrayList<String>();

	public ArrayList<String> company = new ArrayList<String>();

	public ArrayList<String> getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company.add(company);
		Value1 = company;
		b.append(Value2 + "NEXT" + Value1 + "NEXT" + Value3 + "END");
		Log.i("This is the company:", company);
	}

	public ArrayList<String> getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title.add(title);
		Value2 = title;
		Log.i("This is the title:", title);
	}

	public ArrayList<String> getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist.add(artist);
		Value3 = artist;
		Log.i("This is the artist:", artist);
	}

}
