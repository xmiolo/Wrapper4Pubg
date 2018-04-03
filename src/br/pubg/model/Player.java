package br.pubg.model;
/** 
 * Player representation to /players end-point
 *
 * @author Gregori
 * @since 03/04/2018
 * @version 1.0
 */
public class Player {
	private String type;
	private String id;
	private PlayerAttributes attributes;
	
	public Player() {}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public PlayerAttributes getAttributes() {
		return attributes;
	}

	public void setAttributes(PlayerAttributes attributes) {
		this.attributes = attributes;
	}
}
