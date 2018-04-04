package br.teste;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import br.pubg.PlataformEnum;
import br.pubg.model.Player;
import br.wrapper.PubgWrapper;

public class Main {
	/*public static void main(String[] args) {
		try {
			URL url = new URL("https://api.playbattlegrounds.com/shards/pc-sa/players?filter[playerNames]=filter%5BplayerNames%5D%3DMiolo,xSalvadori");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIyZTEyZGVkMC0xOGQzLTAxMzYtZTdkMy0wMzMxODI1NzdmN2YiLCJpc3MiOiJnYW1lbG9ja2VyIiwiaWF0IjoxNTIyNjk0NDAzLCJwdWIiOiJibHVlaG9sZSIsInRpdGxlIjoicHViZyIsImFwcCI6InJveWFsZWdyYXBocyIsInNjb3BlIjoiY29tbXVuaXR5IiwibGltaXQiOjEwfQ.sZ2ehHqcoz1kPh1c8h0wqAzDfbUmWIMpNIoPn4ESPeg");
			conn.setRequestProperty("Accept", "application/vnd.api+json");

			InputStream is = conn.getInputStream(); 
			JsonParser jsonParser = new JsonParser();
			JsonObject jsonObject = (JsonObject)jsonParser.parse(new InputStreamReader(is, "UTF-8"));
			
			Gson gson = new Gson();
			List<Player> player = new ArrayList<Player>(0);
			
			Type listType = new TypeToken<ArrayList<Player>>(){}.getType();
			List<Player> yourClassList = new Gson().fromJson(jsonObject.get("data"), listType);
			
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}*/
	
	public static void main(String[] args) {
		PubgWrapper pubgWrapper = new PubgWrapper();
		pubgWrapper.setApi_key("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIyZTEyZGVkMC0xOGQzLTAxMzYtZTdkMy0wMzMxODI1NzdmN2YiLCJpc3MiOiJnYW1lbG9ja2VyIiwiaWF0IjoxNTIyNjk0NDAzLCJwdWIiOiJibHVlaG9sZSIsInRpdGxlIjoicHViZyIsImFwcCI6InJveWFsZWdyYXBocyIsInNjb3BlIjoiY29tbXVuaXR5IiwibGltaXQiOjEwfQ.sZ2ehHqcoz1kPh1c8h0wqAzDfbUmWIMpNIoPn4ESPeg");
		pubgWrapper.setPlataform(PlataformEnum.PC_SA.getDescription());
		
		try {
			List<Player> lista = pubgWrapper.getPlayers("?filter[playerNames]=filter%5BplayerNames%5D%3DMiolo%2CxSalvadori");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
