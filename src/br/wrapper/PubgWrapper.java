package br.wrapper;

public class PubgWrapper {
	private String api_key;
	private String plataform;
	
	private PubgConnector pubgConnector;
	
	/**
	 * 
	 * @param key
	 * @param plataformEnum
	 */
	public PubgWrapper(String key, String plataform) {
		this.api_key = key;
		this.plataform = plataform;
	}
	
	public void openConnection() {
		//TODO
	}
}
