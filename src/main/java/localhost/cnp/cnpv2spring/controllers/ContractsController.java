/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localhost.cnp.cnpv2spring.controllers;

import java.text.ParseException;
import java.util.List;
import localhost.cnp.cnpv2spring.calculation.Calculated;
import localhost.cnp.cnpv2spring.calculation.PropertyType;
import localhost.cnp.cnpv2spring.entities.Address;
import localhost.cnp.cnpv2spring.entities.Contract;
import localhost.cnp.cnpv2spring.entities.PolicyHolder;
import localhost.cnp.cnpv2spring.services.AddressService;
import localhost.cnp.cnpv2spring.services.ContractService;
import localhost.cnp.cnpv2spring.services.PolicyHolderService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HardLOLMaster
 */
@RestController
public class ContractsController {

    private final ContractService contractService = new ContractService();
    private final PolicyHolderService phService = new PolicyHolderService();
    private final AddressService addressService = new AddressService();

    @RequestMapping("/contracts")
    public List<Contract> contracts() {
        List<Contract> list = contractService.getAll();
        return list;
    }

    @RequestMapping(path = "/contract")
    public Contract contract(
            @RequestParam(name = "create", defaultValue = "false") Boolean create,
            @RequestParam(name = "contractNumber", required = false) Integer contractNumber,
            @RequestParam(name = "calculationDate", required = false) String calculationDate,
            @RequestParam(name = "address", required = false) Long addressId,
            @RequestParam(name = "policyholder", required = false) Long phId,
            @RequestParam(name = "prize", required = false) Float prize,
            @RequestParam(name = "area", required = false) Float area,
            @RequestParam(name = "sum", required = false) Long sum,
            @RequestParam(name = "dateFrom", required = false) String dateFrom,
            @RequestParam(name = "dateTo", required = false) String dateTo,
            @RequestParam(name = "comment", required = false) String comment) throws ParseException {

        Contract contract = null;
        PolicyHolder ph = phService.getById(phId);
        Address address = addressService.getById(addressId);
        if (create) {
            try {

                contract = contractService.getByQuery("FROM Contract as c "
                        + "WHERE contract_number=" + contractNumber).get(0);
                System.out.println("FIND CONTRACT=" + contract);
                contractService.update(
                        contract,
                        calculationDate,
                        address,
                        ph,
                        prize,
                        area,
                        sum,
                        dateFrom,
                        dateTo,
                        comment);

            } catch (IndexOutOfBoundsException e) {
                try {
                    contract = contractService.createContract(
                            contractNumber,
                            calculationDate,
                            ph,
                            address,
                            area,
                            prize,
                            sum,
                            dateFrom,
                            dateTo,
                            comment);
                    contractService.save(contract);
                } catch (IllegalArgumentException ex) {
                    return null;
                }
            }
        }

        /*return contractService.getByQuery("FROM Contract as c "
                + "WHERE contract_number=" + contractNumber).get(0);*/
        return contract;
    }

    @RequestMapping(path = "/client/getbypassport")
    public PolicyHolder clients(
            @RequestParam(name = "passportSeries") Integer passportSeries,
            @RequestParam(name = "passportNumber") Integer passportNumber) {
        return phService.getByQuery("FROM PolicyHolder as ph "
                + "WHERE "
                + "passport_series='" + passportSeries + '\''
                + "and passport_number='" + passportNumber + '\'').get(0);
    }

    @RequestMapping(path = "/client/get")
    public List<PolicyHolder> clients(
            @RequestParam(name = "lastName") String lastName,
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "middleName", required = false) String middleName) {
        return phService.getByQuery("FROM PolicyHolder as ph "
                + "WHERE "
                + "last_name='" + lastName + '\''
                + "and first_name='" + firstName + '\''
                + ((middleName == null || middleName == "") ? "" : "and middle_name='" + middleName + '\''));
    }

    @RequestMapping(path = "/client/save")
    public Boolean client(
            @RequestParam(name = "lastName") String lastName,
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "birthday") String birthday,
            @RequestParam(name = "middleName", required = false) String middleName) throws ParseException {

        if (phService.verify(
                lastName,
                firstName,
                birthday)) {
            PolicyHolder ph = new PolicyHolder(lastName, firstName, phService.formatDate(birthday));
            ph.setMiddleName(middleName);
            phService.save(ph);
        }
        return true;
    }

    @RequestMapping(path = "/client/update")
    public PolicyHolder client(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "lastName") String lastName,
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "middleName", required = false) String middleName,
            @RequestParam(name = "birthday") String birthday,
            @RequestParam(name = "passportSeries") Integer passportSeries,
            @RequestParam(name = "passportNumber") Integer passportNumber) throws ParseException {

        PolicyHolder ph = phService.getById(id);
        /*try {
            phService.getByQuery("FROM PolicyHolder as ph "
                    + "WHERE "
                    + "last_name='" + lastName + '\''
                    + "and first_name='" + firstName + '\''
                    + ((middleName == null) ? "" : "and middle_name='" + middleName + '\'')).get(0);
        } catch (IndexOutOfBoundsException e) {
            ph = null;
        }*/
        if (phService.verify(
                lastName,
                firstName,
                birthday,
                passportSeries,
                passportNumber)) {
            try {
                ph.setLastName(lastName);
                ph.setFirstName(firstName);
                ph.setPassportSeries(passportSeries);
                ph.setPassportNumber(passportNumber);
                ph.setBirthday(phService.formatDate(birthday));
            } catch (NullPointerException e) {
                return null;
            } finally {
                ph.setMiddleName(middleName);
                phService.update(ph);
            }

            /*ph = phService.getByQuery("FROM PolicyHolder as ph "
                    + "WHERE "
                    + "passportNumber=" + passportNumber
                    + "and passportSeries=" + passportSeries).get(0);*/
        }
        return ph;
    }

    @RequestMapping(path = "/address")
    public Address address(
            @RequestParam(name = "country", required = true) String country,
            @RequestParam(name = "region", required = true) String region,
            @RequestParam(name = "city", required = true) String city,
            @RequestParam(name = "apartament", required = true) Integer apartament,
            @RequestParam(name = "street", required = true) String street,
            ///*******************************************************\\\
            @RequestParam(name = "year", required = false) Integer year,
            @RequestParam(name = "index", required = false) String index,
            @RequestParam(name = "district", required = false) String district,
            @RequestParam(name = "building", required = false) Integer building,
            @RequestParam(name = "corpus", required = false) String corpus,
            @RequestParam(name = "buildingCase", required = false) String buildingCase,
            @RequestParam(name = "type", required = false) String type) {
        Address address = null;
        address = addressService.createAddress(
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
        addressService.save(address);
        return address;
    }

    @RequestMapping(path = "/calc")
    public Calculated calc(
            @RequestParam(name = "area", required = false) Float area,
            @RequestParam(name = "sum", required = false) Long sum,
            @RequestParam(name = "year", required = false) String year,
            @RequestParam(name = "dateFrom", required = false) String dateFrom,
            @RequestParam(name = "dateTo", required = false) String dateTo,
            @RequestParam(name = "type", required = false) String t) throws ParseException {

        if (area == null
                && sum == null
                && year == null
                && dateFrom == null
                && dateTo == null
                && t == null) {
            return null;
        }
        PropertyType type = PropertyType.valueOf(t);

        return new Calculated(
                area,
                sum,
                Integer.parseInt(year),
                type,
                ContractService.formatDate(dateFrom),
                ContractService.formatDate(dateTo));
    }
}
