package Servlet_Jdbc_Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductCRUD {

	public int saveProduct(Product product) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/productdb1?user=root&password=1234");
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PRODUCT VALUES(?,?,?,?,?,?)");
		preparedStatement.setInt(1, product.getId());
		preparedStatement.setString(2, product.getName());
		preparedStatement.setString(3, product.getBrand());
		preparedStatement.setDouble(4, product.getPrice());
		preparedStatement.setString(5, product.getManufacture());
		preparedStatement.setString(6, product.getState());

		int count = preparedStatement.executeUpdate();
		connection.close();
		return count;
	}
}