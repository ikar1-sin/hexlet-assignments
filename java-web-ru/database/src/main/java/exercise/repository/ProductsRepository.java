package exercise.repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import exercise.model.Product;

import java.sql.SQLException;
import java.sql.Statement;

public class ProductsRepository extends BaseRepository {

    // BEGIN
    public static void save(Product product) throws SQLException{
        String sql = "INSERT INTO products(title, price) VALUES (?,?)";
        try (var connection = dataSource.getConnection();
                var preparedStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            preparedStmt.setString(1, product.getTitle());
            preparedStmt.setInt(2, product.getPrice());
            preparedStmt.executeUpdate();
            var generatedKeys = preparedStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                product.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    public static Optional<Product> find(Long id) throws SQLException{
        String sql = "SELECT * FROM products WHERE id = ?";
        try (var connection = dataSource.getConnection();
                var preparedStmt = connection.prepareStatement(sql)) {
            preparedStmt.setLong(1, id);
            var rs = preparedStmt.executeQuery();
            if (rs.next()) {
                var title = rs.getString("title");
                var price = rs.getInt("price");
                var product = new Product(title, price);
                product.setId(id);
                return Optional.of(product);
            } else {
                return Optional.empty();
            }
        }
    }

    public static List<Product> getEntities() throws SQLException {
        String sql = "SELECT * FROM products";
        try (var connection = dataSource.getConnection();
                var preparedStmt = connection.prepareStatement(sql)) {
            var rs = preparedStmt.executeQuery();
            var entities = new ArrayList<Product>();
            while (rs.next()) {
                var id = rs.getLong("id");
                var title = rs.getString("title");
                var price = rs.getInt("price");
                var product = new Product(title, price);
                product.setId(id);
                entities.add(product);
            }
            return entities;
        }
    }
    // END
}
