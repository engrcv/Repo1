package java4_msAccessWithJDBC;

import java.sql.*;

//This program is to read/write to a Microsoft Access database.

public class JdbcAccess {

	public static void main(String[] args) {

		String databaseURL = "jdbc:ucanaccess:////C://Users//User//Documents//Contacts.accdb";

		try (Connection connection = DriverManager.getConnection(databaseURL)) {

			String sql = "INSERT INTO Contacts (EMPLOYEEID, FIRST, EMAIL, MOBILE) VALUES (5,?, ?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "Sunidhi Gena ");
			preparedStatement.setString(2, "sunidhig@gmail.com");
			preparedStatement.setString(3, "09199669998");

			int row = preparedStatement.executeUpdate();

			if (row > 0) {
				System.out.println("A row has been inserted successfully.");
			}

			sql = "SELECT * FROM Contacts";

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				int id = result.getInt("EMPLOYEEID");
				String fullname = result.getString("FIRST");
				String email = result.getString("EMAIL");
				String phone = result.getString("MOBILE");

				System.out.println(id + ", " + fullname + ", " + email + ", " + phone);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}

