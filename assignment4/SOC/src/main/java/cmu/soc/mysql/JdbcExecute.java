package cmu.soc.mysql;

import cmu.soc.dao.entity.PubAbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Task 1:
 * This query simulates the login process of a user
 * and tests whether your backend system is functioning properly.
 * Your web application will receive a pair of UserName and Password,
 * and you need to check your backend database to see if the
 * UserName and Password is a valid pair.
 * You should construct your response accordingly:
 * <p>
 * If YES, send back the userName and Profile Image URL.
 * If NOT, set userName as "Unauthorized" and Profile Image URL as "#".
 */
public class JdbcExecute {

    /**
     * JDBC driver of MySQL Connector/J.
     */
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    /**
     * Database name.
     */
    private static final String DB_NAME = "soc";

    /**
     * The endpoint of the database.
     * <p>
     * To avoid hardcoding credentials, use environment variables to include
     * the credentials.
     * <p>
     * e.g., before running "mvn clean package exec:java" to start the server
     * run the following commands to set the environment variables.
     * export MYSQL_HOST=...
     * export MYSQL_NAME=...
     * export MYSQL_PWD=...
     */
    private static String mysqlHost = "localhost";
    /**
     * MySQL username.
     */
    private static String mysqlName = "default";
    /**
     * MySQL Password.
     */
    private static String mysqlPwd = "";

    /**
     * The connection (session) with the database.
     * HINT: pay attention to how this is used internally
     */
    private static Connection conn;

    /**
     * MySQL URL.
     */
    private static final String URL = "jdbc:mysql://" + "localhost" + ":3306/"
            + DB_NAME + "?useSSL=false";

    /**
     * Initialize SQL connection. Standard constructor
     *
     * @throws ClassNotFoundException when an application fails to load a class
     * @throws SQLException           on a database access error or other errors
     */
    public JdbcExecute() throws ClassNotFoundException, SQLException {
        conn = getDBConnection();
    }

    /**
     * A special constructor for TDD
     *
     * @param conn The connection to use
     */
    JdbcExecute(Connection conn) {
        JdbcExecute.conn = conn;
    }

    private Connection getDBConnection() throws SQLException {
        Objects.requireNonNull(mysqlHost);
        Objects.requireNonNull(mysqlName);
        Objects.requireNonNull(mysqlPwd);
        return DriverManager.getConnection(URL, mysqlName, mysqlPwd);
    }

    public void insert(PubAbs pubAbs){
        String sql = "insert into pub_abstract(abs, pub_id, title, ee) values (?, ?, ?, ?)";
        execute(sql, pubAbs);
    }

    private void execute(final String sql, PubAbs pubAbs) {
        // retain the first query
        PreparedStatement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pubAbs.getAbstracts());
            stmt.setLong(2, pubAbs.getPubId());
            stmt.setString(3, pubAbs.getTitle());
            stmt.setString(4, pubAbs.getEe());

            boolean rs = stmt.execute();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
