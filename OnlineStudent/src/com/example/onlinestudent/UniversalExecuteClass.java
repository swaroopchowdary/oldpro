package com.example.onlinestudent;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;
import android.util.Log;

public class UniversalExecuteClass extends AsyncTask<String, Void, String>
{

	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		String url = params[0];
		int number = Integer.parseInt(params[1]);
		String fieldnames = params[2];
		String fieldvalues = params[3];
		try
		{
		ArrayList<NameValuePair> namevaluepair = new ArrayList<NameValuePair>();
		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse httpResponse = null;
		if(number>0)
		{
			
		HttpPost httpPost = new HttpPost(url);
		String arrfieldnames[] = fieldnames.split(",");
		String arrfieldvalues[] = fieldvalues.split(",");
		for(int i=0;i<number;i++)
		{
			
		namevaluepair.add(new BasicNameValuePair(arrfieldnames[i], arrfieldvalues[i]));
		}
		httpPost.setEntity(new UrlEncodedFormEntity(namevaluepair));
		httpResponse = httpClient.execute(httpPost);
		}
		else if(number==0)
		{
			url = url.replace(" ", "%20");
			HttpGet httpGet = new HttpGet(url);
			httpResponse = httpClient.execute(httpGet);
		}
		HttpEntity httpEntity = httpResponse.getEntity();
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String output  = br.readLine();
		String result = br.readLine();

		return result;
		}
		catch(Exception ex)
		{
			Log.i("Exception is universalExecuteQuery", ex.toString());
		}
		return null;
	}
	
}
