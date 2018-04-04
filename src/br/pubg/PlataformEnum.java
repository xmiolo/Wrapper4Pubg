package br.pubg;

/** Enum for Plataform/Server selection */
public enum PlataformEnum {
	/** Asian Xbox */
	XBOX_AS("xbox-as"),
	/** European Xbox */
	XBOX_EU("xbox-eu"),
	/** North American Xbox */
	XBOX_NA("xbox-na"),
	/** Oceanic Xbox */
	XBOX_OC("xbox-oc"),
	/** Koran and Japaneses PC */
	PC_KRJP("pc-krjp"),
	/** North American PC */
	PC_NA("pc-na"),
	/** European PC */
	PC_EU("pc-eu"),
	/** Oceanic PC */
	PC_OC("pc-oc"),
	/** South East Asian PC */
	PC_SEA("pc-sea"),
	/** South and Central American PC */
	PC_SA("pc-sa"),
	/** Asian PC */
	PC_AS("pc-as");
	
	private String plataform;

	PlataformEnum(String plataform) {
        this.plataform = plataform;
    }

    public String getDescription() {
        return this.plataform;
    }
}
