package Servlet_jdbc_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class PersonCRUD {

	public Connection getConnnection() throws ClassNotFoundException, SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/person_db?user=root&password=1234");

		return connection;
	}

	public void savePerson(Person person) throws Exception {
		Connection connection = getConnnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PERSON VALUES(?,?,?,?,?)");
		preparedStatement.setInt(1, person.getId());
		preparedStatement.setString(2, person.getName());
		preparedStatement.setLong(3, person.getPhone());
		preparedStatement.setString(4, person.getEmail());
		preparedStatement.setString(5, person.getPassword());

		preparedStatement.execute();
		connection.close();

	}

	public void updatePerson(Person person) throws Exception {
		Connection connection = getConnnection();
		String query = "UPDATE FROM PERSON SETNAME=?,PHONE=?,EMAIL=?,PASSWORD=? WHERE ID=? ";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, person.getName());
		preparedStatement.setLong(2, person.getPhone());
		preparedStatement.setString(3, person.getEmail());
		preparedStatement.setString(4, person.getPassword());
		preparedStatement.setInt(5, person.getId());

		connection.close();
	}

	public void deletePerson(int id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnnection();
		String qurey = "DELETE FROM PERSON WHERE ID=?";

		PreparedStatement preparedStatement = connection.prepareStatement(qurey);
		preparedStatement.setInt(1,id );

		preparedStatement.executeUpdate();

		connection.close();

	}

	public String LoginPerson(String email) throws Exception {

		Connection connection = getConnnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PERSON WHERE EMAIL=?");
		preparedStatement.setString(1, email);

		ResultSet resultSet = preparedStatement.executeQuery();
		String password = null;
		while (resultSet.next()) {
			password = resultSet.getString("password");
		}
		connection.close();
		return password;

	}

	

}
