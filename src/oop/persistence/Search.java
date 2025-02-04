/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.persistence;

import oop.types.EntityHandlerType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import oop.entities.Entity;

/**
 *
 * @author kucik
 */
class Search extends SearchHandlerAbstract {

    private EntityHandler handler;

    @Override
    protected final List<? extends Entity> getResultFromResultSet(ResultSet resultSet) throws SQLException {
        EntityHandlerAbstract handlerAbstract = (EntityHandlerAbstract) handler;
        return handlerAbstract.getResultFromResultSet(resultSet);
    }

    @Override
    protected final List<? extends Entity> selectAll(EntityHandlerType type, String command) {
        handler = EntityHandlerFactory.createEntityHandler(type);

        return executeQuery(command);
    }

}
