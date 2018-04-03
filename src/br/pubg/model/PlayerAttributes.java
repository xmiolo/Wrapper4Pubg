package br.pubg.model;

/** 
 * PlayerAttributes representation to /players end-point
 *
 * @author Gregori
 * @since 03/04/2018
 * @version 1.0
 */
public class PlayerAttributes {
	private String name;
	private String shardId;
	private String createdAt;
	private String patchVersion;
	private String titleId;
	
	public PlayerAttributes() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		name = name;
	}
	public String getShardId() {
		return shardId;
	}
	public void setShardId(String shardId) {
		this.shardId = shardId;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getPatchVersion() {
		return patchVersion;
	}
	public void setPatchVersion(String patchVersion) {
		this.patchVersion = patchVersion;
	}
	public String getTitleId() {
		return titleId;
	}
	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}
}
