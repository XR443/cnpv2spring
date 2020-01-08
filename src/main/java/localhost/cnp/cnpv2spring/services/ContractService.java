/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localhost.cnp.cnpv2spring.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import localhost.cnp.cnpv2spring.database.ContractDao;
import localhost.cnp.cnpv2spring.entities.Address;
import localhost.cnp.cnpv2spring.entities.Contract;
import localhost.cnp.cnpv2spring.entities.PolicyHolder;

/**
 *
 * @author HardLOLMaster
 */
public class ContractService extends ContractDao {

    @Override
    public Contract getById(Long id) {
        return super.getById(id);
    }

    @Override
    public void update(Contract t) {
        super.update(t);
    }

    @Override
    public void save(Contract t) {
        super.save(t);
    }

    @Override
    public void delete(Contract t) {
        super.delete(t);
    }

    public List<Contract> getAll() {
        return super.getByQuery("FROM Contract as c");
    }

    @Override
    public void saveOrUpdate(Contract t) {
        super.saveOrUpdate(t); //To change body of generated methods, choose Tools | Templates.
    }

    public static String formatDate(Date date) {
        if (date == null) {
            return null;
        } else {
            Integer year = date.getYear() + 1900;
            Integer day = date.getDate();
            Integer month = date.getMonth() + 1;
            return String.format(
                    "%d-%s-%s",
                    year,
                    month < 10 ? "0" + month : month,
                    day < 10 ? "0" + day : day
            );
        }
    }

    public static String formatFDate(Date date) {
        if (date == null) {
            return null;
        } else {
            Integer year = date.getYear() + 1900;
            Integer day = date.getDate();
            Integer month = date.getMonth() + 1;
            return String.format(
                    "%s.%s.%d",
                    day < 10 ? "0" + day : day,
                    month < 10 ? "0" + month : month,
                    year
            );
        }
    }

    public Contract createContract(
            Integer contractNumber,
            String calculationDateString,
            PolicyHolder ph,
            Address address,
            Float area,
            Float prize,
            Long sum,
            String dateFromString,
            String dateToString,
            String comment) throws ParseException {
        Date now = Date.from((LocalDate.now()).atStartOfDay().atZone(ZoneId.of("UTC")).toInstant());
        Date conclusionDate = now;
        Date calculationDate = formatDate(calculationDateString);
        Date dateFrom = formatDate(dateFromString);
        Date dateTo = formatDate(dateToString);

        if (!dateFrom.before(dateTo)) {
            return null;
        }
        if (contractNumber == null) {
            return null;
        }
        if (contractNumber.toString().length() != 6) {
            return null;
        }

        Contract contract = new Contract();

        contract.setAddress(address);
        contract.setCalculationDate(calculationDate);
        contract.setComment(comment);
        contract.setConclusionDate(conclusionDate);
        contract.setContractNumber(contractNumber);
        contract.setArea(area);
        contract.setDateFrom(dateFrom);
        contract.setDateTo(dateTo);
        contract.setPolicyholder(ph);
        contract.setPrize(prize);
        contract.setSum(sum);

        return contract;
    }

    public static Date formatDate(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setTimeZone(TimeZone.getTimeZone(ZoneId.of("UTC")));
        return formatter.parse(dateString);
    }

    public Contract update(
            Contract contract,
            String calculationDateString,
            Address address,
            PolicyHolder ph,
            Float prize,
            Float area,
            Long sum,
            String dateFromString,
            String dateToString,
            String comment) throws ParseException {

        Date now = Date.from((LocalDate.now()).atStartOfDay().atZone(ZoneId.of("UTC")).toInstant());
        Date conclusionDate = now;
        Date calculationDate = formatDate(calculationDateString);
        Date dateFrom = formatDate(dateFromString);
        Date dateTo = formatDate(dateToString);

        if (!dateFrom.before(dateTo)) {
            return null;
        }

        contract.setAddress(address);
        contract.setCalculationDate(calculationDate);
        contract.setComment(comment);
        contract.setConclusionDate(conclusionDate);
        contract.setArea(area);
        contract.setDateFrom(dateFrom);
        contract.setDateTo(dateTo);
        contract.setPolicyholder(ph);
        contract.setPrize(prize);
        contract.setSum(sum);

        update(contract);

        return contract;
    }
}
