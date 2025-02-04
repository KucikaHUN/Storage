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
import oop.entities.Perishable;
import oop.exceptions.NullPropertyException;
import oop.logs.Logger;
import oop.utils.Util;

/**
 *
 * @author kucik
 */
class PerishableHandler extends EntityHandlerAbstract {

    private static final String insertInto;
    private static final String update;
    private static final String delete;
    private static final String selectAll;

    static {
        insertInto
                = "call createPerishableProduct('%s', '%s', '%s', '%s', %d, '%d', '%d', '%s', '%d', '%s', '%s');";
        selectAll = "select * from perishable_product order by article_number;";
        update = "call updatePerishableProduct('%s', '%s', '%s', '%s', %d, '%d', '%d', '%s', '%d', '%s', '%s');";
        delete = "call deletePerishableProduct('%s')";
    }

    @Override
    public boolean insert(Entity entity) {
        Perishable perishable = castEntity(entity);
        callExceptionNullIfNeed(perishable);
        String text = String.format(Locale.US, insertInto, perishable.getId(), perishable.getName(), perishable.getBrand(),
                perishable.getFamily(), perishable.getNettoPrice(), perishable.getTaxId(),
                perishable.getQuantity(), perishable.getAmountUnits(), perishable.getCriticalQuantity(),
                Util.dateToString(perishable.getExpirationDate()),
                Util.dateToString(perishable.getProductionDate()));
        return executeNonQuery(text);

    }

    @Override
    public boolean update(Entity entity) {
        Perishable perishable = castEntity(entity);
        callExceptionNullIfNeed(perishable);
        String text = String.format(Locale.US, update, perishable.getId(), perishable.getName(), perishable.getBrand(),
                perishable.getFamily(), perishable.getNettoPrice(), perishable.getTaxId(),
                perishable.getQuantity(), perishable.getAmountUnits(), perishable.getCriticalQuantity(), Util.dateToString(perishable.getExpirationDate()),
                Util.dateToString(perishable.getProductionDate()));
        return executeNonQuery(text);
    }

    @Override
    public boolean delete(Entity entity) {
        Perishable perishable = castEntity(entity);
        String text = String.format(delete, perishable.getId());
        return executeNonQuery(text);
    }

    @Override
    public List<? extends Entity> selectAll() {
        return executeQuery(selectAll);
    }

    @Override
    protected List<? extends Entity> getResultFromResultSet(ResultSet resultSet)
            throws SQLException {
        List<Perishable> result = new ArrayList<>();
        Perishable temp;
        while (resultSet.next()) {
            temp = createPerishable(resultSet);
            result.add(temp);
        }
        return result;
    }

    private Perishable createPerishable(ResultSet rs) throws SQLException {

        String articleNumber = rs.getString(1);
        String name = rs.getString(2);
        String brand = rs.getString(3);
        String family = rs.getString(4);
        int nettoPrice = Integer.parseInt(rs.getString(5));
        int taxId = Integer.parseInt(rs.getString(6));
        int quantity = Integer.parseInt(rs.getString(7));
        String amountUnits = rs.getString(8);
        int criticalQuantity = Integer.parseInt(rs.getString(9));
        LocalDate expirationDate = Util.textToDate(rs.getString(10));
        LocalDate productionDate = Util.textToDate(rs.getString(11));

        return new Perishable(articleNumber, name, brand, family, nettoPrice, taxId, quantity, criticalQuantity, amountUnits, expirationDate, productionDate);

    }

    private Perishable castEntity(Entity entity) {
        return (Perishable) entity;

    }

    private void callExceptionNullIfNeed(Perishable perishable) {
        if (perishable.getId() == null
                || perishable.getName() == null
                || perishable.getFamily() == null
                || perishable.getBrand() == null
                || perishable.getId() == null
                || perishable.getAmountUnits() == null
                || perishable.getExpirationDate() == null
                || perishable.getProductionDate() == null) {
            Logger.createLogError("Cant contains null property: PerishableHandler.callExceptionNullIfNeed");
            throw new NullPropertyException("Call the developer. (Contains error)");
        }
    }
}
