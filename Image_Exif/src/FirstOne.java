import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class FirstOne {
	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			List<String> list = new ArrayList<>();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/header", "root", "piyush123");
			String query = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.columns WHERE table_name = 'photo'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			FileWriter fw = new FileWriter("test.csv");
			for (String column : list) {
				System.out.println("Creating " + column + ".csv");
				String filename = "" + column + ".csv";
				fw = new FileWriter(filename);
				fw.append("ifd0_make#ifd0_model#"+column + "#");
				fw.append("Count\n");
				String theQuery = "SELECT ifd0_make, ifd0_model, "+column+", COUNT(*) as Counts FROM photo Group by ifd0_make, ifd0_model, "+column;
				Statement statement = conn.createStatement();
				ResultSet res = statement.executeQuery(theQuery);
				while (res.next()) {
					fw.append(res.getString(1) + "#");
					fw.append(res.getString(2) + "#");
					fw.append(res.getString(3) + "#");
					fw.append(res.getString(4) + "\n");
				}
				fw.flush();
				fw.close();
			}
			conn.close();
			System.out.println("CSVs File is created successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
