
package br.com.projeto.ws.client.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//http://www.jsonschema2pojo.org/
public class User {

	@SerializedName("data")
	@Expose
	private Data data;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

}
