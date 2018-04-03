package br.wrapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import br.pubg.PlataformEnum;
import br.pubg.model.Player;

public class PubgConnector {
	private URL url;
	private HttpURLConnection connection;
	private String endPoint;
	
	/**
	 * Connect to endPoint without filter
	 * @param plataform
	 * @param endPoint
	 * @param key
	 * @throws IOException 
	 */
	protected PubgConnector(PlataformEnum plataform, String endPoint, String key) throws IOException {
		this.url = new URL("https://api.playbattlegrounds.com/shards/".concat(plataform.getPlataform()).concat(endPoint));
		this.endPoint = endPoint;
		System.out.println("Connecting... ");
		this.connection = (HttpURLConnection) this.url.openConnection();
		this.connection.setRequestMethod("GET");
		this.connection.setRequestProperty("Authorization", key);
		this.connection.setRequestProperty("Accept", "application/vnd.api+json");
	}
	
	/**
	 * Connect to endPoint with filter
	 * @param plataform
	 * @param endPoint
	 * @param key
	 * @param filter
	 * 
	 * Filter Example: ?filter[playerNames]=filter%5BplayerNames%5D%3DplayerId-1,playerId-2,…
	 * @throws IOException 
	 */
	protected PubgConnector(PlataformEnum plataform, String endPoint, String key, String filter) throws IOException {
		this.url = new URL("https://api.playbattlegrounds.com/shards/".concat(plataform.getPlataform()).concat(endPoint).concat(filter));
		System.out.println("Connecting... ");
		this.connection = (HttpURLConnection) this.url.openConnection();
		this.connection.setRequestMethod("GET");
		this.connection.setRequestProperty("Authorization", key);
		this.connection.setRequestProperty("Accept", "application/vnd.api+json");
	}
	
	protected <T> T getResult() throws JsonIOException, JsonSyntaxException, UnsupportedEncodingException, IOException {
		Gson gson = new Gson();
		
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = (JsonObject)jsonParser.parse(new InputStreamReader(connection.getInputStream(), "UTF-8"));
		
		if(this.endPoint.equals("players")) {
			List<Player> player = new ArrayList<Player>(0);
			Type listType = new TypeToken<ArrayList<Player>>(){}.getType();
			return new Gson().fromJson(jsonObject.get("data"), listType);
		} else if (this.endPoint.equals("matches")) {
			//TODO
		}
		//TODO handle exception
		return null;
	}
	
	
}
