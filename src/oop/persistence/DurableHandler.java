/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.persistence;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import oop.entities.Durable;
import oop.entities.Entity;
import oop.exceptions.NullPropertyException;
import oop.logs.Logger;

/**
 *
 * @author kucik
 */
class DurableHandler extends EntityHandlerAbstract {

    private static final String insertInto;
    private static final String update;
    private static final String delete;
    private static final String selectAll;

    static {
        insertInto
                = "call createDurableProduct('%s', '%s', '%s', '%s', %d, '%d', '%d', '%d', '%d', '%.1f', '%s');";
        selectAll = "select * from durable_product order by article_number;";
        update = "call updateDurableProduct('%s', '%s', '%s', '%s', %d, '%d', '%d', '%d', '%d', '%.1f', '%s');";
        delete = "call deleteDurableProduct('%s')";
    }

    @Override
    public boolean insert(Entity entity) {
        Durable durable = castEntity(entity);
        callExceptionNullIfNeed(durable);
        String text = String.format(Locale.US, insertInto, durable.getId(), durable.getName(), durable.getBrand(),
                durable.getFamily(), durable.getNettoPrice(), durable.getTaxId(),
                durable.getQuantity(), durable.getCriticalQuantity(), durable.getWarantyPeriod(), durable.getGrossWeight(),
                durable.getAmountUnits());
        return executeNonQuery(text);

    }

    @Override
    public boolean update(Entity entity) {
        Durable durable = castEntity(entity);
        callExceptionNullIfNeed(durable);
        String text = String.format(Locale.US, update, durable.getId(), durable.getName(), durable.getBrand(),
                durable.getFamily(), durable.getNettoPrice(), durable.getTaxId(),
                durable.getQuantity(), durable.getCriticalQuantity(), durable.getWarantyPeriod(), durable.getGrossWeight(),
                durable.getAmountUnits());
        return executeNonQuery(text);
    }

    @Override
    public boolean delete(Entity entity) {
        Durable durable = castEntity(entity);
        String text = String.format(delete, durable.getId());
        return executeNonQuery(text);
    }

    @Override
    public List<? extends Entity> selectAll() {
        return executeQuery(selectAll);
    }

    @Override
    protected List<? extends Entity> getResultFromResultSet(ResultSet resultSet)
            throws SQLException {
        List<Durable> result = new ArrayList<>();
        Durable temp;
        while (resultSet.next()) {
            temp = createDurable(resultSet);
            result.add(temp);
        }

        return result;
    }

    private Durable createDurable(ResultSet rs) throws SQLException {
        String articleNumber = rs.getString(1);
        String name = rs.getString(2);
        String brand = rs.getString(3);
        String family = rs.getString(4);
        int nettoPrice = Integer.parseInt(rs.getString(5));
        int taxId = Integer.parseInt(rs.getString(6));
        int quantity = Integer.parseInt(rs.getString(7));
        int criticalQuantity = Integer.parseInt(rs.getString(8));
        int warantyPeriod = Integer.parseInt(rs.getString(9));
        double grossWeightDouble = Double.parseDouble(rs.getString(10));
        BigDecimal grossWeight = BigDecimal.valueOf(grossWeightDouble);
        String amountUnits = rs.getString(11);

        return new Durable(articleNumber, name, brand, family, nettoPrice, taxId, quantity, criticalQuantity, amountUnits, warantyPeriod, grossWeight);

    }

    private Durable castEntity(Entity entity) {
        return (Durable) entity;

    }

    private void callExceptionNullIfNeed(Durable durable) {

        if (durable.getId() == null
                || durable.getName() == null
                || durable.getFamily() == null
                || durable.getBrand() == null
                || durable.getId() == null
                || durable.getAmountUnits() == null
                || durable.getGrossWeight() == null) {
            Logger.createLogError("Cant contains null property: DurableHandler.callExceptionNullIfNeed");
            throw new NullPropertyException("Call the developer. (Contains error)");
        }
    }
}
