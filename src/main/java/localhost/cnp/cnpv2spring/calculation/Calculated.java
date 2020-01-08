/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localhost.cnp.cnpv2spring.calculation;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import localhost.cnp.cnpv2spring.services.ContractService;

/**
 *
 * @author HardLOLMaster
 */
public class Calculated {

    private String calculationDate;
    private Float prize;

    public Calculated() {
    }

    public Calculated(
            Float area,
            Long sum,
            Integer year,
            PropertyType type,
            Date dateFrom,
            Date dateTo) {

        Coefficient coef = CoefficientReader.getCoefficient();

        Date now = Date.from((LocalDate.now()).atStartOfDay().atZone(ZoneId.of("UTC")).toInstant());

        if (dateControl(dateFrom, dateTo, now)) {

            Long days = (dateTo.getTime() / 1000 - dateFrom.getTime() / 1000) / 60 / 60 / 24;

            prize = (Float.parseFloat(sum.toString()) / Float.parseFloat(days.toString()));

            switch (type) {
                case HOUSE:
                    prize = calculateCoef(prize, coef.getHouse());
                    break;
                case APARTAMENT:
                    prize = calculateCoef(prize, coef.getApartament());
                    break;
                case ROOM:
                    prize = calculateCoef(prize, coef.getRoom());
                    break;
            }

            if (year < coef.getMinYear()) {
                prize = calculateCoef(prize, coef.getCoefLowYears());
            } else if (year > coef.getMaxYear()) {
                prize = calculateCoef(prize, coef.getCoefMaxYears());
            } else {
                prize = calculateCoef(prize, coef.getCoefMiddleYears());
            }

            if (area < coef.getMinArea()) {
                prize = calculateCoef(prize, coef.getCoefLowArea());
            } else if (area > coef.getMaxArea()) {
                prize = calculateCoef(prize, coef.getCoefMaxArea());
            } else {
                prize = calculateCoef(prize, coef.getCoefMiddleArea());
            }
            prize = (Float.parseFloat(Integer.toString(Math.round(prize * 100)))) / 100;
            calculationDate = ContractService.formatDate(now);
        }
    }

    public static Float calculateCoef(Float prize, Float coef) {
        return (prize *= coef);
    }

    public boolean dateControl(Date dateFrom, Date dateTo, Date now) {
        return (dateFrom.before(dateTo) && duration(dateFrom, dateTo) < 365 && todayOrAfter(dateFrom, now));
    }

    private Integer duration(Date dateFrom, Date dateTo) {
        Integer days = Integer.parseInt(
                Long.toString((dateTo.getTime() / 1000 - dateFrom.getTime() / 1000) / 60 / 60 / 24));
        return days;
    }

    public String getCalculationDate() {
        return calculationDate;
    }

    public void setCalculationDate(String calculationDate) {
        this.calculationDate = calculationDate;
    }

    public Float getPrize() {
        return prize;
    }

    public void setPrize(Float prize) {
        this.prize = prize;
    }

    private boolean todayOrAfter(Date date, Date now) {
        if (date.after(now)) {
            return true;
        }
        if (date.getYear() == now.getYear()) {
            if (date.getMonth() == now.getMonth()) {
                if (date.getDay() == now.getDay()) {
                    return true;
                }
            }
        }
        return false;
    }

}
