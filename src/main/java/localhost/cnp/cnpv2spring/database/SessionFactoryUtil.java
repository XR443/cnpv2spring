/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localhost.cnp.cnpv2spring.database;

import java.util.EnumSet;
import localhost.cnp.cnpv2spring.entities.Address;
import localhost.cnp.cnpv2spring.entities.Contract;
import localhost.cnp.cnpv2spring.entities.PolicyHolder;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

/**
 *
 * @author HardLOLMaster
 */
public class SessionFactoryUtil {

    private static final String CONFIG_FILE_NAME = "hibernate.cfg.xml";
    private static SessionFactory instance;

    static {
        ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                        .configure(CONFIG_FILE_NAME)
                        .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .getMetadataBuilder()
                .build();

        SchemaExport export = new SchemaExport();
        export.setDelimiter(";");
        export.setHaltOnError(false);
        export.execute(EnumSet.of(TargetType.DATABASE), SchemaExport.Action.CREATE, metadata);
    }

    public static synchronized SessionFactory getInstance() {
        if (instance == null) {
            Configuration configuration = new Configuration().configure(CONFIG_FILE_NAME);
            configuration.addAnnotatedClass(Contract.class);
            configuration.addAnnotatedClass(Address.class);
            configuration.addAnnotatedClass(PolicyHolder.class);
            StandardServiceRegistryBuilder builder 
                    = new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties());
            instance = configuration.buildSessionFactory(builder.build());
        }
        return instance;
    }

}
