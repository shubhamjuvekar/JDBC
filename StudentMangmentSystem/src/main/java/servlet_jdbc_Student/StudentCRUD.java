package servlet_jdbc_Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentCRUD {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root&password=1234");
		return connection;
	}

	public int saveStudent(Student student) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, student.getId());
		preparedStatement.setString(2, student.getS_name());
		preparedStatement.setString(3, student.getF_name());
		preparedStatement.setString(4, student.getM_name());
		preparedStatement.setLong(5, student.getAge());
		preparedStatement.setLong(6, student.getPhone());
		preparedStatement.setString(7, student.getEmail());
		preparedStatement.setString(8, student.getPassword());
		preparedStatement.setString(9, student.getSchool());
		preparedStatement.setLong(10, student.getFees());

		int count = preparedStatement.executeUpdate();
		connection.close();
		return count;

	}

	public Student getStudentInfo(String email) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM STUDENT WHERE EMAIL=?");
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();

		Student student = new Student();
		while (resultSet.next()) {
			student.setPassword(resultSet.getString("password"));
			student.setSchool(resultSet.getNString("school"));
		}
		connection.close();
		return student;
	}

}
