package general;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Accessory1 extends Items {

	private static Object jsonText;

	Accessory1() throws MalformedURLException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getBasicContent(String id) throws MalformedURLException,
			IOException, ParseException {
		JSONParser parser = new JSONParser();
		String URL = "https://api.guildwars2.com/v2/items/" + id + "?lang=de";
		InputStream inputStream = new URL(URL).openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				inputStream, Charset.forName("UTF-8")));
		setJsonText(parser.parse(br));

		Items.icon((JSONObject) getJsonText());

		URL url = new URL(icon);
		BufferedImage myPicture = ImageIO.read(url);
		Main.lbl_Ohrring1Icon.setIcon(new ImageIcon(myPicture));
		Main.lbl_Ohrring1Icon.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Items.write((JSONObject) getJsonText());
			}
		});

	}

	public static Object getJsonText() {
		return jsonText;
	}

	public static void setJsonText(Object jsonText) {
		Accessory1.jsonText = jsonText;
	}

}
