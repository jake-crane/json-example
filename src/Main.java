import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) throws IOException {

		String json = getJSON();
		if (json != null) {
			ObjectMapper mapper = new ObjectMapper();
			Users users = mapper.readValue(json, Users.class);
			for (User user : users.getUserList())
				System.out.println(user.getFirstName() + " " + user.getLastName());

		} else {
			System.out.println("Error getting json");
		}
	}

	public static String getJSON() throws IOException {
		URL obj = new URL("http://jakecrane.com/users.json");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		int responseCode = con.getResponseCode();
		if (responseCode == 200) {

			try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null)
					response.append(inputLine);
				return response.toString();
			}
		}
		return null;
	}
}
