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
import oop.entities.Entity;
import oop.exceptions.EntityException;
import oop.exceptions.SQLExceptionCatchable;
import oop.logs.Logger;
import oop.utils.Util;

/**
 *
 * @author kucik
 */
abstract class EntityHandlerAbstract implements EntityHandler {

    private static SqlConnection sqlConnection;

    protected final boolean executeNonQuery(String sqlCommand) {
        boolean result = false;
        try (Statement statement = sqlConnection.getConnection().
                createStatement()) {
            result = statement.execute(sqlCommand);
        } catch (SQLException ex) {
            Logger.createLogError("'"+sqlCommand+"' cant finished: EntityHandlerAbstract.executeNonQuery");
            throw new SQLExceptionCatchable("Call the developer. (SQL Error)");
        }
        return result;
    }

    protected final List<? extends Entity> executeQuery(String queryString) {
        List<Entity> result = null;
        try (Statement statement = sqlConnection.getConnection().
                createStatement();
                ResultSet resultSet = statement.executeQuery(queryString)) {
            result = (List<Entity>) getResultFromResultSet(resultSet);
        } catch (SQLException ex) {
            Logger.createLogError("'"+queryString+"' cant finished: EntityHandlerAbstract.executeQuery");
            throw new SQLExceptionCatchable("Call the developer. (SQL Error)");
        }
        return result;
    }

    protected abstract List<? extends Entity> getResultFromResultSet(
            ResultSet resultSet) throws SQLException;
}
