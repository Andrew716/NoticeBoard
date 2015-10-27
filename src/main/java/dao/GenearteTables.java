package dao;

import entities.Announcement;
import entities.Person;
import entities.Rubric;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import java.util.logging.Logger;

/**
 * Created by Andrii on 10/27/2015.
 */
public class GenearteTables {
    private static Logger LOGGER = Logger.getLogger("Info logging");
    public static void main(String[] args){
        LOGGER.info("aaaaaaaaaaaaaaaaaaaaaa");
        AnnotationConfiguration config = new AnnotationConfiguration();
        LOGGER.info("bbbbbbbbbbbbbbbbbbbbbbbbb");
        config.addAnnotatedClass(Announcement.class);
        config.addAnnotatedClass(Person.class);
        config.addAnnotatedClass(Rubric.class);
        LOGGER.info("ddddddddddddddddddddddddddddddd");
        config.configure("hibernate.cfg.xml");
        LOGGER.info("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        new SchemaExport(config).create(true, true);
        LOGGER.info("ssssssssssssssssssssssssssssssssss");

    }
}
