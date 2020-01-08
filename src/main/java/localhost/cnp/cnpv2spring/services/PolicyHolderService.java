/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localhost.cnp.cnpv2spring.services;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import localhost.cnp.cnpv2spring.database.PolicyHolderDao;
import localhost.cnp.cnpv2spring.entities.PolicyHolder;

/**
 *
 * @author HardLOLMaster
 */
public class PolicyHolderService extends PolicyHolderDao {

    @Override
    public PolicyHolder getById(Long id) {
        return super.getById(id);
    }

    @Override
    public void update(PolicyHolder t) {
        super.update(t);
    }

    @Override
    public void save(PolicyHolder t) {
        super.save(t);
    }

    @Override
    public void delete(PolicyHolder t) {
        super.delete(t);
    }

    public List<PolicyHolder> getAll() {
        return super.getByQuery("FROM PolicyHolder as ph");
    }

    @Override
    public void saveOrUpdate(PolicyHolder t) {
        super.saveOrUpdate(t);
    }

    public boolean verify(
            String lastName,
            String firstName,
            String birthday,
            Integer passportSeries,
            Integer passportNumber) throws ParseException {
        Date now = Date.from((LocalDate.now()).atStartOfDay().atZone(ZoneId.of("UTC")).toInstant());
        try {
            if (!formatDate(birthday).before(now)) {
                return false;
            }
        } catch (NullPointerException e) {
            return false;
        }
        if (passportSeries.toString().length() != 4) {
            return false;
        }
        if (passportNumber.toString().length() != 6) {
            return false;
        }
        return true;
    }

    public static Date formatDate(String dateString) throws ParseException {
        return ContractService.formatDate(dateString);
    }

    public boolean verify(String lastName, String firstName, String birthday) throws ParseException {
        Date now = Date.from((LocalDate.now()).atStartOfDay().atZone(ZoneId.of("UTC")).toInstant());
        try {
            if (!formatDate(birthday).before(now)) {
                return false;
            }
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }
}
