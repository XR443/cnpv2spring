/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localhost.cnp.cnpv2spring.junit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;
import localhost.cnp.cnpv2spring.calculation.Calculated;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HardLOLMaster
 */
public class CalculatedTest {

    @Test
    public void testCalculatedDateControl() throws ParseException {
        Calculated calc = new Calculated();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setTimeZone(TimeZone.getTimeZone(ZoneId.of("UTC")));

        Date now = formatter.parse("2020-01-08");
        Date from = formatter.parse("2020-01-08");
        Date to = formatter.parse("2020-01-09");

        assertTrue("Wrong with correct dates from==now from<to", calc.dateControl(from, to, now));

        from = formatter.parse("2020-01-09");
        to = formatter.parse("2020-01-10");
        assertTrue("Wrong with correct dates from>now from<to", calc.dateControl(from, to, now));

        from = formatter.parse("2020-01-09");
        to = formatter.parse("2020-01-09");
        assertFalse("Correct with incorrect dates from>now from==to", calc.dateControl(from, to, now));

        from = formatter.parse("2020-01-10");
        to = formatter.parse("2020-01-09");
        assertFalse("Correct with incorrect dates from>now from>to", calc.dateControl(from, to, now));

        from = formatter.parse("2020-01-07");
        to = formatter.parse("2020-01-09");
        assertFalse("Correct with incorrect dates from<now from<to", calc.dateControl(from, to, now));
    }

    @Test
    public void testCalculateCoef() {
        Calculated calc = new Calculated();
        Float f = 1F;
        f = calc.calculateCoef(f, 2F);
        assertEquals("Expected (1 * 2 = 2) receive " + f, 2, f, 0.01);
    }
}
