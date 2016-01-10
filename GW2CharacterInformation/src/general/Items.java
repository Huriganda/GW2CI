package general;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public abstract class Items {

	static String name;
	static String description;
	static String type;
	static long level;
	static String rarity;
	static long vendor_value;
	static String chat_link;
	static String icon;
	static JSONParser parser = new JSONParser();
	static String URL;
	static long id;
	static String flagstring = null;
	// static InputStream inputStream;
	// static BufferedReader br;
	static Object jsonText;

	Items() throws MalformedURLException, IOException {

	}

	public abstract void getBasicContent(String id)
			throws MalformedURLException, IOException, ParseException;

	public static void write(JSONObject jsonObject) {
		// JSONObject jsonObject = (JSONObject) Helmet.getJsonText();
		flagstring = null;
		name = (String) jsonObject.get("name");
		description = (String) jsonObject.get("description");
		type = (String) jsonObject.get("type");
		level = (long) jsonObject.get("level");
		rarity = (String) jsonObject.get("rarity");
		vendor_value = (long) jsonObject.get("vendor_value");
		String value = Connection.coins(vendor_value);
		chat_link = (String) jsonObject.get("chat_link");
		id = (long) jsonObject.get("id");
		String idString = String.valueOf(id); 
		JSONArray jsonarray = (JSONArray) jsonObject.get("flags");
		String[] flags = new String[jsonarray.size()];
		for (int i = 0; i < flags.length; i++){
			flagstring = flagstring + jsonarray.get(i) + ", ";
		}
		
		flagstring = flagstring.substring(4);
		
		
		if (rarity.equals("Junk")){
			rarity = "Schrott";
		}
		
		if (rarity.equals("Basic")){
			rarity ="Einfach";
		}
		
		if (rarity.equals("Fine")){
			rarity="Edel";
		}
		
		if (rarity.equals("Masterwork")){
			rarity="Meisterwerk";
		}
		
		if (rarity.equals("Rare")){
			rarity="Selten";
		}
		
		if (rarity.equals("Exotic")){
			rarity="Exotisch";
		}
		
		if (rarity.equals("Ascended")){
			rarity="Aufgestiegen";
		}
		
		if (rarity.equals("Legendary")){
			rarity="Legendär";
		}

		String AllTogether = "Name: " + name + "\nBeschreibung: " + description
				+ "\nTyp: " + type + "\nLevel: " + level + "\nRarität: "
				+ rarity + "\nWert: " + value + "\nChat Link: " + chat_link + "\nID: " + idString + "\nFlags:" + flagstring;
		Main.tP_ItemInfo.setText(AllTogether);
	}

	public static void icon(JSONObject jsonObject) {
		icon = (String) jsonObject.get("icon");
	}

}
