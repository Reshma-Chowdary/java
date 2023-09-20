package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.json.JSONArray;

public class PassengerDal {
	public void add(String no, String name, String age, String gen) {
		String url = "jdbc:postgresql://LocalHost/postgres?user=postgres&password=PostGres@1";

		try {
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection(url);

			PreparedStatement s = c
					.prepareStatement("INSERT INTO trn_Passenger(sno, name, age, gender) VALUES (?, ?, ?, ?)");
			s.setString(1, no);
			s.setString(2, name);
			s.setString(3, age);
			s.setString(4, gen);
			s.executeUpdate();

			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}