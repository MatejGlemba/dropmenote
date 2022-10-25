package io.dpm.dropmenote.db.ddlgenerator;

import java.io.File;
import java.net.URISyntaxException;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.PostgreSQL9Dialect;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import io.dpm.dropmenote.db.entity.ConfigurationEntity;

public class DDLGenerator {

    public static void main(String[] args) throws URISyntaxException, ClassNotFoundException {

        String packageName = ConfigurationEntity.class.getPackage().getName();
        File directory = new File(DDLGenerator.class.getClassLoader().getResource(packageName.replace('.', '/')).toURI());
        String[] files = directory.list();
        Configuration configuration = new Configuration();

        for (int i = 0; i < files.length; i = i + 1) {
            if (files[i].endsWith(".class")) {
                // Skip some table
                if (files[i].startsWith("SkipMe")) {
                    continue;
                }

                configuration.addAnnotatedClass(Class.forName(packageName + "." + files[i].substring(0, files[i].length() - 6)));
            }
        }

        // configuration.setNamingStrategy(new OracleNamingStrategy());
        configuration.setProperty(Environment.DIALECT, PostgreSQL9Dialect.class.getName());

        SchemaExport schemaExport = new SchemaExport(configuration);
        schemaExport.setDelimiter(";");
        schemaExport.setFormat(true);
        schemaExport.setHaltOnError(true);
        schemaExport.setOutputFile("src/main/scripts/CREATE_SCRIPT.sql");
        schemaExport.execute(true, false, false, false);
        // schemaExport.drop(true, false);
        // schemaExport.create(true, false);

    }
}
