/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localhost.cnp.cnpv2spring.services;

import java.util.List;
import localhost.cnp.cnpv2spring.calculation.PropertyType;
import localhost.cnp.cnpv2spring.database.AddressDao;
import localhost.cnp.cnpv2spring.entities.Address;

/**
 *
 * @author HardLOLMaster
 */
public class AddressService extends AddressDao {

    @Override
    public Address getById(Long id) {
        return super.getById(id);
    }

    @Override
    public void update(Address t) {
        super.update(t);
    }

    @Override
    public void save(Address t) {
        super.save(t);
    }

    @Override
    public void delete(Address t) {
        super.delete(t);
    }

    @Override
    public void saveOrUpdate(Address t) {
        super.saveOrUpdate(t);
    }

    public List<Address> getAll() {
        return super.getByQuery("FROM Address as a");
    }

    public Address createAddress(
            Integer year,
            String index,
            String country,
            String district,
            String region,
            String city,
            String street,
            Integer building,
            String corpus,
            String buildingCase,
            Integer apartament,
            String t) {

        PropertyType type = PropertyType.valueOf(t);

        return new Address(
                year,
                index,
                country,
                district,
                region,
                city,
                street,
                building,
                corpus,
                buildingCase,
                apartament,
                type);
    }
}
