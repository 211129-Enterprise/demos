package com.revature.ormdemo;

import java.util.List;

import com.revature.demomodels.DummyOtherClass;
import com.revature.demomodels.DummyUser;
import com.revature.util.ColumnField;
import com.revature.util.Configuration;
import com.revature.util.ForeignKeyField;
import com.revature.util.MetaModel;
import com.revature.util.PrimaryKeyField;

// We will pretend that this class is the class of some dev's project in which 
// they have incorporated our ORM as a dependency
public class Driver {
	
	public static void main(String[] args) {
		
		// We need to "load" the classes of our project into the ORM 
		// we need to convert them to meta models
		// we also need to establish a connection to the DB by feeding our
		// DB credentials to the ORM
		
		// Hibernate reads from a hibernate.cfg.xml file
		// You can also set db creds programatically like so 
		
		// The user might read the documentation and know to instantiate a Configuration object
		
		
		// Step 1 of operations with the Configuration Object is adding the annotated classes
		Configuration cfg = new Configuration();
		
		cfg.addAnnotatedClass(DummyUser.class);
		
		// Step 2 of operations with the Configuration Object is adding the DB creds and connecting
		cfg.getConnection("someUrl", "dbUsername", "dbPassword");
		
		// iterate over each class that has been added to the configuration object and print info about it
		
		for (MetaModel<?> metamodel : cfg.getMetaModels()) {
			
			System.out.printf("Printing MetaModel for class: %s\n", metamodel.getClassName());
			PrimaryKeyField pk = metamodel.getPrimaryKey();
			List<ColumnField> columns = metamodel.getColumns();
			List<ForeignKeyField> foreignKeyFields = metamodel.getForeignKeys();
			
			System.out.printf("\t Found a primary key field named %s, of type %s, which maps to the column with name: %s\n", 
					pk.getName(), pk.getType(), pk.getColumnName());
			
			for (ColumnField column : columns) {
				System.out.printf("\t Found a column field named %s, of type %s, which maps to the column with name: %s\n", 
						column.getName(), column.getType(), column.getColumnName());
			}
			
			for (ForeignKeyField foreignKey : foreignKeyFields) {
				System.out.printf("\t Found a foreign key field named %s, of type %s, which maps to the column with name: %s\n", 
						foreignKey.getName(), foreignKey.getType(), foreignKey.getColumnName());
			}		
		}
	}
}