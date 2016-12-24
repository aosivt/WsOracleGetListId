package ServiceSoap;

import Entity.Banks;
import XmlGetter.StructureXml;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import util.HibernateUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by oshchepkovayu on 20.12.16.
 */

@SpringBootApplication
public class UseHiber {
    public static void main(String args[])
    {

        Locale.setDefault(Locale.ENGLISH);
//        for (int i =0 ; i<20;i++) {
            fieldingDB(createXmlString());
//        }
        SpringApplication.run(UseHiber.class, args);
    }
    private static String createXmlString()
    {
        String error_exception = "";
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(StructureXml.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            StructureXml xml =new StructureXml();

            xml.setNameBank("NameBank" + new Date().toString());
            xml.setCity("Kemerovo" + new Date().toString());
            xml.setAddress("street");
            xml.setTime("16:00 до 17:00");

            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(xml, sw);
            String xmlString = sw.toString();
            return xmlString;
        }catch (Exception e)
        {
            error_exception = e.getLocalizedMessage();
            System.out.print("Exception message:" + e.getLocalizedMessage());
        }
        return error_exception;
    }
    private static void fieldingDB(String _input_string)
    {
        Session session = null;

        try {
            session  = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();


            System.out.println("Inserting Record");
            Banks banks = new Banks();
            banks.setContent(_input_string);
            session.save(banks);
            transaction.commit();
            session.clear();
            session.close();
            System.out.println("Done");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
    protected static List<Banks> getListXml()
    {

        System.out.println("Select List StructureXml");


        List<Banks> resultlist = null;
        Session session = null;

        try {
            session  = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            Query q = session.createQuery("From Banks");
            resultlist = q.list();
            session.clear();
            session.close();
            System.out.println("Done");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return  resultlist;
    }
}
