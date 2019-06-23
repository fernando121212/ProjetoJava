package br.com.projeto.util;

import java.io.IOException;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class WsProcessamento {
	
	public static Object getWs(String url, Object object) {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
		  .url(url).get().build();
		try {
			Response response = client.newCall(request).execute();
			String responseAsJson = response.body().string();
			Gson gson = new Gson();
			object = gson.fromJson(responseAsJson, object.getClass());
			return object;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
