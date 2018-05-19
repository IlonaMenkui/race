package by.grsu.solomenskay.dataaccess.impl;

import by.grsu.solomenskay.datamodel.Administrator;
import by.grsu.solomenskay.tables.AdministratorTable;

import java.util.List;
import java.util.Optional;

public class AdministratorDao extends AbstractDao<AdministratorTable, Administrator> {

    public AdministratorDao(String rootFolderPath) {
        super(rootFolderPath);
    }

    @Override
    protected Class<AdministratorTable> getTableClass() {
        return AdministratorTable.class;
    }

    @Override
    public Administrator update(Administrator entity) {
        // get existing data
        final AdministratorTable table = deserializeFromXml();
        // find by ID
        for (final Administrator row : table.getRows()) {
            if (row.getId().equals(entity.getId())) {
                // found!!!
                // copy data
                row.setWorkNumber(entity.getWorkNumber());
                row.setAge(entity.getAge());
                row.setName(entity.getName());
                row.setSurname(entity.getSurname());
            }
        }
        // save updated table
        serializeToXml(table);
        return entity;
    }
}
