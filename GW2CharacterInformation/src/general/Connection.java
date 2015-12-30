package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Connection {

	static HelmAquatic helmAquatic;
	static Backpack backpack;
	static Coat coat;
	static Boots boots;
	static Gloves gloves;
	static Helmet helmet;
	static Leggins leggins;
	static Shoulders shoulders;
	static Accessory1 accessory1;
	static Accessory2 accessory2;
	static Ring1 ring1;
	static Ring2 ring2;
	static Amulet amulet;
	static WeaponAquaticA weaponAquaticA;
	static WeaponAquaticB weaponAquaticB;
	static WeaponA1 waffe1a;
	static WeaponA2 waffe2a;
	static WeaponB1 weapon1b;
	static WeaponB2 weapon2b;
	static Sickle sickle;
	static Axe axe;
	static Pick pick;

	Connection() throws MalformedURLException, IOException, ParseException {
		helmAquatic = new HelmAquatic();
		backpack = new Backpack();
		coat = new Coat();
		boots = new Boots();
		gloves = new Gloves();
		helmet = new Helmet();
		leggins = new Leggins();
		shoulders = new Shoulders();
		accessory1 = new Accessory1();
		accessory2 = new Accessory2();
		ring1 = new Ring1();
		ring2 = new Ring2();
		amulet = new Amulet();
		weaponAquaticA = new WeaponAquaticA();
		weaponAquaticB = new WeaponAquaticB();
		waffe1a = new WeaponA1();
		waffe2a = new WeaponA2();
		weapon1b = new WeaponB1();
		weapon2b = new WeaponB2();
		sickle = new Sickle();
		axe = new Axe();
		pick = new Pick();
	}

	public static JSONObject jsonObject;
	public static String array[][] = new String[22][6];
	private boolean alreadyIn = false;
	static ImageIcon WaechterIcon = new ImageIcon(
			Main.class.getResource("/images/Guardian_icon.png"));
	static ImageIcon nothingIcon = new ImageIcon(Main.class.getResource("/images/nothing.png"));

	public void getCharNames(String APIAccesToken)
			throws MalformedURLException, IOException, ParseException {
		setAlreadyIn(true);
		JSONParser parser = new JSONParser();
		String URL = "https://api.guildwars2.com/v2/characters?access_token="
				+ APIAccesToken;
		InputStream inputStream = new URL(URL).openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				inputStream, Charset.forName("UTF-8")));
		Object jsonText = parser.parse(br);

		jsonText = jsonText.toString();
		String withoutbrackets = ((String) jsonText).substring(1);
		withoutbrackets = withoutbrackets.substring(0,
				withoutbrackets.length() - 1);
		String[] chars = withoutbrackets.split(",");

		// jsonObject = (JSONObject) jsonText;

		general.Main.cB_CharNames.addItem(" ");

		for (int i = 0; i < chars.length; i++) {
			chars[i] = chars[i].substring(1);
			chars[i] = chars[i].substring(0, chars[i].length() - 1);
			general.Main.cB_CharNames.addItem(chars[i]);
		}

	}

	public static void getConnection(String name) throws MalformedURLException,
			IOException, ParseException, InterruptedException {
		name = name.replace(" ", "%20");
		JSONParser parser = new JSONParser();
		String URL = "https://api.guildwars2.com/v2/characters/" + name
				+ "?access_token=" + Main.tF_APIToken.getText().toString();
		InputStream inputStream = new URL(URL).openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				inputStream, Charset.forName("UTF-8")));
		Object jsonText = parser.parse(br);
		jsonObject = (JSONObject) jsonText;
		getCharacterInformation();
		getEquipment();

		if (!(array[0][0] == null)) {
			helmAquatic.getBasicContent(array[0][0]);
		} else {
			Main.lbl_AtemmaskeIcon.setIcon(nothingIcon);
		}

		if (!(array[1][0] == null)) {
			backpack.getBasicContent(array[1][0]);
		} else {
			Main.lbl_RueckenIcon.setIcon(nothingIcon);
		}

		if (!(array[2][0] == null)) {
			coat.getBasicContent(array[2][0]);
		} else {
			Main.lbl_BrustIcon.setIcon(nothingIcon);
		}
		
		if (!(array[3][0] == null)) {
			boots.getBasicContent(array[3][0]);
		} else {
			Main.lbl_SchuhIcon.setIcon(nothingIcon);
		}

		if (!(array[4][0] == null)) {
			gloves.getBasicContent(array[4][0]);
		} else {
			Main.lbl_HandschuhIcon.setIcon(nothingIcon);
		}

		if (!(array[5][0] == null)) {
			helmet.getBasicContent(array[5][0]);
		} else {
			Main.lbl_KopfIcon.setIcon(nothingIcon);
		}

		if (!(array[6][0] == null)) {
			leggins.getBasicContent(array[6][0]);
		} else {
			Main.lbl_HoseIcon.setIcon(nothingIcon);
		}

		if (!(array[7][0] == null)) {
			shoulders.getBasicContent(array[7][0]);
		} else {
			Main.lbl_SchulterIcon.setIcon(nothingIcon);
		}

		if (!(array[8][0] == null)) {
			accessory1.getBasicContent(array[8][0]);
		} else {
			Main.lbl_Ohrring1Icon.setIcon(nothingIcon);
		}

		if (!(array[9][0] == null)) {
			accessory2.getBasicContent(array[9][0]);
		} else {
			Main.lbl_Ohrring2Icon.setIcon(nothingIcon);
		}

		if (!(array[10][0] == null)) {
			ring1.getBasicContent(array[10][0]);
		} else {
			Main.lbl_Ring1Icon.setIcon(nothingIcon);
		}

		if (!(array[11][0] == null)) {
			ring2.getBasicContent(array[11][0]);
		} else {
			Main.lbl_Ring2Icon.setIcon(nothingIcon);
		}

		if (!(array[12][0] == null)) {
			amulet.getBasicContent(array[12][0]);
		} else {
			Main.lbl_AmulettIcon.setIcon(nothingIcon);
		}

		if (!(array[13][0] == null)) {
			weaponAquaticA.getBasicContent(array[13][0]);
		} else {
			Main.lbl_Unterwasserwaffe1Icon.setIcon(nothingIcon);
		}

		if (!(array[14][0] == null)) {
			weaponAquaticB.getBasicContent(array[14][0]);
		} else {
			Main.lbl_Unterwasserwaffe2Icon.setIcon(nothingIcon);
		}

		if (!(array[15][0] == null)) {
			waffe1a.getBasicContent(array[15][0]);
		} else {
			Main.lbl_Waffe1AIcon.setIcon(nothingIcon);
		}

		if (!(array[16][0] == null)) {
			waffe2a.getBasicContent(array[16][0]);
		} else {
			Main.lbl_Waffe2AIcon.setIcon(nothingIcon);
		}

		if (!(array[17][0] == null)) {
			weapon1b.getBasicContent(array[17][0]);
		} else {
			Main.lbl_Waffe1BIcon.setIcon(nothingIcon);
		}

		if (!(array[18][0] == null)) {
			weapon2b.getBasicContent(array[18][0]);
		} else {
			Main.lbl_Waffe2BIcon.setIcon(nothingIcon);
		}

		if (!(array[19][0] == null)) {
			sickle.getBasicContent(array[19][0]);
		} else {
			Main.lbl_ErntesichelIcon.setIcon(nothingIcon);
		}

		if (!(array[20][0] == null)) {
			axe.getBasicContent(array[20][0]);
		} else {
			Main.lbl_HolzaxtIcon.setIcon(nothingIcon);
		}

		if (!(array[21][0] == null)) {
			pick.getBasicContent(array[21][0]);
		} else {
			Main.lbl_SpitzhackeIcon.setIcon(nothingIcon);
		}

		br.close();
		inputStream.close();
	}

	public static void getCharacterInformation() {
		String charname = (String) jsonObject.get("name");
		String race = (String) jsonObject.get("race");
		if (race.equals("Human")) {
			race = "Mensch";
		}
		String gender = (String) jsonObject.get("gender");
		if (gender.equals("Male")) {
			gender = "Männlich";
		} else {
			gender = "Weiblich";
		}
		String profession = (String) jsonObject.get("profession");
		if (profession.equals("Guardian")) {
			profession = "Wächter";
			Main.lbl_KlasseIcon.setIcon(new ImageIcon(Main.class
					.getResource("/images/Guardian_icon.png")));
		} else if (profession.equals("Warrior")) {
			profession = "Krieger";
			Main.lbl_KlasseIcon.setIcon(new ImageIcon(Main.class
					.getResource("/images/Warrior_icon.png")));
		} else if (profession.equals("Engineer")) {
			profession = "Ingenieur";
			Main.lbl_KlasseIcon.setIcon(new ImageIcon(Main.class
					.getResource("/images/Engineer_icon.png")));
		} else if (profession.equals("Ranger")) {
			profession = "Waldläufer";
			Main.lbl_KlasseIcon.setIcon(new ImageIcon(Main.class
					.getResource("/images/Ranger_icon.png")));
		} else if (profession.equals("Thief")) {
			profession = "Dieb";
			Main.lbl_KlasseIcon.setIcon(new ImageIcon(Main.class
					.getResource("/images/Thief_icon.png")));
		} else if (profession.equals("Elementalist")) {
			profession = "Elementarmagier";
			Main.lbl_KlasseIcon.setIcon(new ImageIcon(Main.class
					.getResource("/images/Elementalist_icon.png")));
		} else if (profession.equals("Necromancer")) {
			profession = "Nekromant";
			Main.lbl_KlasseIcon.setIcon(new ImageIcon(Main.class
					.getResource("/images/Necromancer_icon.png")));
		} else if (profession.equalsIgnoreCase("Revenant")) {
			profession = "Widergänger";
			Main.lbl_KlasseIcon.setIcon(new ImageIcon(Main.class
					.getResource("/images/Revenant_icon.png")));
		} else if (profession.equalsIgnoreCase("Mesmer")) {
			profession = "Mesmer";
			Main.lbl_KlasseIcon.setIcon(new ImageIcon(Main.class
					.getResource("/images/Mesmer_icon.png")));
		}
		long level = (long) jsonObject.get("level");
		String levelString = String.valueOf(level);
		String guild = (String) jsonObject.get("guild");
		long age = (long) jsonObject.get("age");

		String ageString = age(age);
		String created = (String) jsonObject.get("created");
		created = created(created);
		long deaths = (long) jsonObject.get("deaths");
		String deathsString = String.valueOf(deaths);

		Main.textPane.setText("Name: " + charname + "\nRasse: " + race
				+ "\nGeschlecht: " + gender + "\nKlasse: " + profession
				+ "\nLevel: " + levelString + "\nGilde: " + guild + "\nAlter: "
				+ ageString + "\nErstellt: " + created + "\nTode: "
				+ deathsString);

		/*
		 * String ar[] = new String[9]; ar[0] = charname; ar[1] = race; ar[2] =
		 * gender; ar[3] = profession; ar[4] = levelString; ar[5] = guild; ar[6]
		 * = ageString; ar[7] = created; ar[8] = deathsString;
		 */
	}

	public static String[][] getEquipment() {

		String HelmAquatic = "HelmAquatic";
		array[0][0] = HelmAquatic;
		String Backpack = "Backpack";
		array[1][0] = Backpack;
		String Coat = "Coat";
		array[2][0] = Coat;
		String Boots = "Boots";
		array[3][0] = Boots;
		String Gloves = "Gloves";
		array[4][0] = Gloves;
		String Helm = "Helm";
		array[5][0] = Helm;
		String Leggings = "Leggings";
		array[6][0] = Leggings;
		String Shoulders = "Shoulders";
		array[7][0] = Shoulders;
		String Accessory1 = "Accessory1";
		array[8][0] = Accessory1;
		String Accessory2 = "Accessory2";
		array[9][0] = Accessory2;
		String Ring1 = "Ring1";
		array[10][0] = Ring1;
		String Ring2 = "Ring2";
		array[11][0] = Ring2;
		String Amulet = "Amulet";
		array[12][0] = Amulet;
		String WeaponAquaticA = "WeaponAquaticA";
		array[13][0] = WeaponAquaticA;
		String WeaponAquaticB = "WeaponAquaticB";
		array[14][0] = WeaponAquaticB;
		String WeaponA1 = "WeaponA1";
		array[15][0] = WeaponA1;
		String WeaponA2 = "WeaponA2";
		array[16][0] = WeaponA2;
		String WeaponB1 = "WeaponB1";
		array[17][0] = WeaponB1;
		String WeaponB2 = "WeaponB2";
		array[18][0] = WeaponB2;
		String Sickle = "Sickle";
		array[19][0] = Sickle;
		String Axe = "Axe";
		array[20][0] = Axe;
		String Pick = "Pick";
		array[21][0] = Pick;

		JSONArray equipment = (JSONArray) jsonObject.get("equipment");
		JSONObject id = null;
		int zaehler = 0;

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (j == 0) {
					if (zaehler < equipment.size()) {
						id = (JSONObject) equipment.get(zaehler);
						long idnumber = (long) id.get("id");
						String slot = (String) id.get("slot");
						if (slot.equals(array[i][j])) {
							array[i][j] = String.valueOf(idnumber);
							zaehler++;
						} else {
							array[i][j] = null;
						}
					} else {
						array[i][j] = null;
					}
				}
				if (j == 1) {
					if (array[i][0] == null) {
						array[i][j] = null;
					} else {
						JSONArray upgrades = (JSONArray) id.get("upgrades");
						if (upgrades == null) {
							array[i][j] = null;
						} else {
							for (int l = 0; l < upgrades.size(); l++) {
								long upgradesid = (long) upgrades.get(l);
								if (l == 1) {
									j++;
									array[i][j] = String.valueOf(upgradesid);
								} else {
									array[i][j] = String.valueOf(upgradesid);
								}
							}
						}
					}
				}
				if (j == 3) {
					if (array[i][0] == null) {
						array[i][j] = null;
					} else {
						JSONArray infusions = (JSONArray) id.get("infusions");
						if (infusions == null) {
							array[i][j] = null;
						} else {
							for (int l = 0; l < infusions.size(); l++) {
								long infusionid = (long) infusions.get(l);
								if (l == 1) {
									j++;
									array[i][j] = String.valueOf(infusionid);
								} else {
									array[i][j] = String.valueOf(infusionid);
								}
							}
						}
					}
				}
				if (j == 5) {
					if (array[i][0] == null) {
						array[i][j] = null;
					} else {
						id = (JSONObject) equipment.get(zaehler - 1);
						try {
							long idnumberskin = (long) id.get("skin");
							array[i][j] = String.valueOf(idnumberskin);
						} catch (NullPointerException e) {
							array[i][j] = null;
						}
					}
				}
				// System.out.println(array[i][j]);
			}
		}
		return array;
	}
	
	public static void getWallet(String apitoken) throws MalformedURLException, IOException, ParseException{
		JSONParser parser = new JSONParser();
		String URL = "https://api.guildwars2.com/v2/account/wallet?access_token=" + apitoken;
		InputStream inputStream = new URL(URL).openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				inputStream, Charset.forName("UTF-8")));
		Object jsonText = parser.parse(br);
		JSONArray jsonarray = (JSONArray) jsonText;
		String[] walletarray = new String[jsonarray.size()];
		String idchain = null;
		for (int i = 0; i < walletarray.length; i++){
			JSONObject index = (JSONObject) jsonarray.get(i);
			long id = (long) index.get("id");
			walletarray[i] = String.valueOf(id);
			long value = (long) index.get("value");
			System.out.println(id + ": " + value);
			idchain = idchain + String.valueOf(id) + ",";
		}
		idchain = idchain.substring(4);
		idchain = idchain.substring(0, idchain.length()-1);
		String CurrencieURL = "https://api.guildwars2.com/v2/currencies?ids=" + idchain;
		InputStream iSCurrency = new URL(CurrencieURL).openStream();
		BufferedReader bRCurrency = new BufferedReader(new InputStreamReader(iSCurrency, Charset.forName("UTF-8")));
		Object jTCurrency = parser.parse(bRCurrency);
		JSONArray arrayCurrency = (JSONArray) jTCurrency;
		System.out.println(CurrencieURL);
		//System.out.println(jsonarray);
	}

	public static String age(long age) {
		double realage = age /= 60;
		double hours = realage/60;
		DecimalFormat df = new DecimalFormat();
		df.setRoundingMode(RoundingMode.DOWN);
		String roundedhours = df.format(hours);
		String ageString = realage + " Minuten = " + roundedhours + " Stunden";
		return ageString;
	}
	
	public static String created(String created){
		String year = created.substring(0, 4);
		String month = created.substring(5, 7);
		String day = created.substring(8, 10);
		String time = created.substring(11, 19);
		created = day + "." + month + "." + year + ", um " + time + " Uhr";
		return created;
	}
	
	public static String coins(long vendor_value){
		int kupfer = (int) (vendor_value % 100);
		vendor_value /= 100;
		int silber = (int) vendor_value % 100;
		vendor_value /= 100;
		int gold = (int) vendor_value % 100;
		String value = gold + " Gold, " + silber + " Silber, " + kupfer + " Kupfer";
		return value;		
	}

	public void getItemData(int id) {

	}

	public boolean isAlreadyIn() {
		return alreadyIn;
	}

	public void setAlreadyIn(boolean alreadyIn) {
		this.alreadyIn = alreadyIn;
	}
}
