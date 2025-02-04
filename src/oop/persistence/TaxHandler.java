/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import oop.entities.Entity;
import oop.entities.Tax;
import oop.exceptions.EntityException;
import oop.exceptions.NullPropertyException;
import oop.logs.Logger;

/**
 *
 * @author kucik
 */
class TaxHandler extends EntityHandlerAbstract {

    private static final String create;
    private static final String delete;
    private static final String selectAll;

    static {

        selectAll = "select * from state_sales_tax order by tax_key;";
        create = "call createTaxIfNeed('%s', '%s');";
        delete = "call deleteTax('%s')";
    }

    @Override
    protected List<? extends Entity> getResultFromResultSet(ResultSet resultSet) throws SQLException {
        List<Tax> result = new ArrayList<>();
        Tax temp;
        while (resultSet.next()) {
            temp = createTax(resultSet);
            result.add(temp);
        }
        return result;
    }

    @Override
    public boolean insert(Entity entity) {
        Tax tax = castEntity(entity);
        callExceptionNullIfNeed(tax);
        String text = String.format(Locale.US, create, tax.getId(), tax.getDescription());
        return executeNonQuery(text);
    }

    @Override
    public boolean update(Entity entity) {
        return false;
    }

    @Override
    public boolean delete(Entity entity) {
        Tax tax = castEntity(entity);
        String text = String.format(Locale.US, delete, tax.getId());
        return executeNonQuery(text);
    }

    @Override
    public List<? extends Entity> selectAll() {
        return executeQuery(selectAll);
    }

    private Tax createTax(ResultSet rs) throws SQLException {
        int taxId = Integer.parseInt(rs.getString(1));
        String description = rs.getString(2);
        return new Tax(taxId, description);
    }

    private Tax castEntity(Entity entity) {
        return (Tax) entity;
    }

    private void callExceptionNullIfNeed(Tax tax) {
        if(tax.getDescription() == null){
            Logger.createLogError("Cant contains null property: TaxHandler.callExceptionNullIfNeed");
            throw new NullPropertyException("Call the developer. (Contains error)");
        }
    }

}
