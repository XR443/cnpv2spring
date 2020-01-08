/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localhost.cnp.cnpv2spring.database;

import java.sql.Date;
import java.time.LocalDate;
import localhost.cnp.cnpv2spring.calculation.PropertyType;
import localhost.cnp.cnpv2spring.entities.Address;
import localhost.cnp.cnpv2spring.entities.Contract;
import localhost.cnp.cnpv2spring.entities.PolicyHolder;
import localhost.cnp.cnpv2spring.services.AddressService;
import localhost.cnp.cnpv2spring.services.ContractService;
import localhost.cnp.cnpv2spring.services.PolicyHolderService;

/**
 *
 * @author HardLOLMaster
 */
public class DatabaseServicesTest {

    private static final ContractService cs = new ContractService();
    private static final AddressService as = new AddressService();
    private static final PolicyHolderService phs = new PolicyHolderService();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        PolicyHolder ph = new PolicyHolder("last",
                "first",
                Date.valueOf(LocalDate.now()),
                1568,
                156489);

        Address address = new Address();
        address.setApartament(156);
        address.setCountry("country");
        address.setDistrict("district");
        address.setRegion("region");
        address.setCity("city");
        address.setStreet("street");
        address.setType(PropertyType.APARTAMENT);

        Contract contract = new Contract(165,
                Date.valueOf(LocalDate.now()),
                Date.valueOf(LocalDate.now()),
                ph,
                address,
                0.56f,
                59L,
                Date.valueOf(LocalDate.now()),
                Date.valueOf(LocalDate.now()));

        as.save(address);

        contract.setAddress(address);

        phs.save(ph);

        contract.setPolicyholder(ph);

        //ph.addContract(contract);
        cs.save(contract);

        Contract contract2 = cs.getById(1L);
        PolicyHolder ph2 = contract.getPolicyholder();
        Address address2 = contract.getAddress();

        ph2.setMiddleName("middle2");

        phs.update(ph2);

        address.setBuildingCase("case");

        as.saveOrUpdate(address);

        contract2.setComment("COMMENT");

        cs.update(contract2);

        System.out.println("-----------------------------------------\n"
                + cs.getAll() 
                + "\n-----------------------------------------");
    }

}
