package br.wrapper;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.pubg.model.Player;

public class PubgWrapper {
	private String api_key;
	private String plataform;
	private HttpURLConnection connection;
	private PubgConnector pubgConnector;
	private static String PLAYER_URL = "https://api.playbattlegrounds.com/shards/PLATAFORM/players/";
	private static String MATCH_URL  = "https://api.playbattlegrounds.com/shards/PLATAFORM/matches/";
	
	public PubgWrapper() {
		this.pubgConnector = new PubgConnector();
	}
	
	/**
	 * Return a List of Players
	 * @return List<Player>
	 * @throws IOException
	 */
	public List<Player> getPlayers(List<String> filter) throws IOException{
		URL url = this.getFormatedURL(PLAYER_URL, mountPlayerFilter(filter));
		this.openConnection(url);
		Type listType = new TypeToken<ArrayList<Player>>(){}.getType();
		return new Gson().fromJson(this.pubgConnector.getResult(this.connection).get("data"), listType);
	}
	
	/**
	 * Get Player by Id 
	 * @return Player
	 * @throws IOException
	 */
	public Player getPlayer(String id) throws IOException{
		URL url = this.getFormatedURL(PLAYER_URL+id, "");
		this.openConnection(url);
		return new Gson().fromJson(this.pubgConnector.getResult(this.connection).get("data"), Player.class);
	}

	/**
	 * Method to open connection with the API
	 * @param url
	 * @throws IOException
	 * @throws ProtocolException
	 */
	private void openConnection(URL url) throws IOException, ProtocolException {
		System.out.println("Connecting... ");
		this.connection = (HttpURLConnection) url.openConnection();
		this.connection.setRequestMethod("GET");
		this.connection.setRequestProperty("Authorization", this.api_key);
		this.connection.setRequestProperty("Accept", "application/vnd.api+json");
		System.out.println("Connected!");
	}
	
	public String mountPlayerFilter(List<String> players) {
		String filter = "";
		for(String name : players) {
			filter = filter.concat(name+"%2C");
		}
		return filter.replace("%2C$", "");
	}

	/**
	 * Choose you plataform
	 * @param plataform
	 */
	public void setPlataform(/** Use PlataformEnum.java to chose you plataform */String plataform) {
		this.plataform = plataform;
	}

	/**
	 * Set you personal APIKEY
	 * @param api_key
	 */
	public void setApi_key(String api_key) {
		this.api_key = api_key;
	}
	
	
	/**
	 * What is name of end-point
	 * Extras is the filter or variation in GET
	 * @param what
	 * @param extras
	 * @return
	 */
	private URL getFormatedURL(String what, String extras) {
		//TODO look for a better way to handle with extras
		String filter = "?filter[playerNames]=filter%5BplayerNames%5D%3D";
		if(what.equals(PLAYER_URL)) {
			try {
				return new URL(PLAYER_URL.replace("PLATAFORM", plataform).concat(extras.length()==0 ? "" : filter+extras));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (what.equals(MATCH_URL)) {
			try {
				return new URL(MATCH_URL.replace("PLATAFORM", plataform).concat(extras.length()==0 ? "" : extras));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			return null;
		}
		return null;
	}
}
