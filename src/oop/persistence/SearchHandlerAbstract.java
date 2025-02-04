/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oop.entities.Entity;
import oop.types.EntityHandlerType;

/**
 *
 * @author kucik
 */
abstract class SearchHandlerAbstract {

    private static SqlConnection sqlConnection;

    protected final void executeNonQuery(String sqlCommand) {
        try (Statement statement = sqlConnection.getConnection().
                createStatement()) {
            statement.execute(sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(EntityHandlerAbstract.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    protected final List<? extends Entity> executeQuery(String queryString) {
        List<Entity> result = null;
        try (Statement statement = sqlConnection.getConnection().
                createStatement(); ResultSet resultSet = statement.executeQuery(queryString)) {
            result = (List<Entity>) getResultFromResultSet(resultSet);
        } catch (SQLException ex) {
            Logger.getLogger(EntityHandlerAbstract.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return result;
    }

    protected abstract List<? extends Entity> getResultFromResultSet(
            ResultSet resultSet) throws SQLException;

    protected abstract List<? extends Entity> selectAll(EntityHandlerType type, String command);
}
