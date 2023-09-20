package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

public class StationDAL {
	public JSONArray getStations() {
		JSONArray ja = new JSONArray();
		try {
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection(
					"jdbc:postgresql://LocalHost/postgres?user=postgres&password=PostGres@1");
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select trn_start,trn_end from MadhuStations");
			while (rs.next()) {
				JSONObject jo = new JSONObject();
				jo.put("from", rs.getString(1));
				jo.put("to", rs.getString(2));
				ja.put(jo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ja;
	}

	public JSONArray getTrains(String from, String to) {
		JSONArray ja = new JSONArray();
		try {
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection(
					"jdbc:postgresql://LocalHost/postgres?user=postgres&password=PostGres@1");
			PreparedStatement s = c
					.prepareStatement("select trn_name from MadhuStations where trn_start=? and trn_end=?");
			s.setString(1, from);
			s.setString(2, to);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				JSONObject jo = new JSONObject();
				jo.put("train", rs.getString(1));
				ja.put(jo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ja;
	}
}