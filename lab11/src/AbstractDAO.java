import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAO<T> {
    public abstract void create(T entity) throws SQLException;

    public abstract T read(int id) throws SQLException;

    public abstract List<T> readAll() throws SQLException;

    public abstract void update(T entity) throws SQLException;

    public abstract void delete(int id) throws SQLException;
}
