/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localhost.cnp.cnpv2spring.calculation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author HardLOLMaster
 */
public class CoefficientReader {

    private static final String FILE_NAME = "coefficient.xml";

    private static Coefficient coefficient;

    public static Coefficient getCoefficient() {
        update();
        return coefficient;
    }

    private static void update() {

        File file = new File(FILE_NAME);

        try {
            StringBuilder sb = new StringBuilder();
            Coefficient coef;
            if (file.exists()) {
                String s;
                BufferedReader in = new BufferedReader(new FileReader(FILE_NAME));
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                }
                in.close();
                StringReader reader = new StringReader(sb.toString());
                JAXBContext context = JAXBContext.newInstance(Coefficient.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                coef = (Coefficient) unmarshaller.unmarshal(reader);
            } else {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME)));
                JAXBContext context = JAXBContext.newInstance(Coefficient.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                coef = new Coefficient();
                
                coef.setMaxYear(2015);
                coef.setMinYear(2000);
                
                coef.setMaxArea(100);
                coef.setMinArea(50);
                
                coef.setCoefLowYears(1.3f);
                coef.setCoefMaxYears(2f);
                coef.setCoefMiddleYears(1.6f);
                
                coef.setCoefLowArea(1.3f);
                coef.setCoefMaxArea(2f);
                coef.setCoefMiddleArea(1.6f);
                
                coef.setApartament(1.7f);
                coef.setHouse(1.5f);
                coef.setRoom(1.3f);

                StringWriter writer = new StringWriter();
                marshaller.marshal(coef, writer);
                String s = writer.toString();
                out.println(s);
                out.close();
            }
            coefficient = coef;
        } catch (IOException ex) {
            System.err.println("===ERROR===\n"+ex);
        } catch (JAXBException ex) {
            System.err.println("===ERROR===\n"+ex);
        }
    }
}
