package com.revature.driver;

import java.util.List;

import com.revature.models.Checking;
import com.revature.models.DummyOtherClass;
import com.revature.util.ColumnField;
import com.revature.util.Configuration;
import com.revature.util.ForeignKeyField;
import com.revature.util.MetaModel;
import com.revature.util.PrimaryKeyField;


public class Driver {
	
	public static void main(String[] args) {
	
		Configuration cfg = new Configuration();
		
		cfg.addAnnotatedClass(DummyOtherClass.class);
		cfg.addAnnotatedClass(Checking.class);
		
		try {
			cfg.getConnection();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
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
		DummyOtherClass a = new DummyOtherClass(0, "Bobby", "B", "Martial", 1, 586, "658759863", "BobbyB32", "iloveM&Ms", true);
		DummyOtherClass b = new DummyOtherClass(0, "Tiffany", "L", "Dessert", 1, 632, "546989698", "tiffs4us", "kidsalwayshome", false);
		DummyOtherClass c = new DummyOtherClass(0, "Loraine", "U", "Wings", 1, 745, "235468123", "sewingmyjeans", "fivedifferentneedles", true);
		DummyOtherClass d = new DummyOtherClass(0, "Thomas", "E", "Smith", 2, 765, "165874598", "Thomas22", "forthepeople", true);
		DummyOtherClass e = new DummyOtherClass(0, "Zoba", "Y", "Bobyah", 3, 800, "348758546", "AfricanTiger", "safarijungle", true);
		
		cfg.makeTable(MetaModel.of(a.getClass()));
		cfg.insertObject(c);
		cfg.deleteObject(b);
		cfg.findObject(a, "last_name", "Martial");
		cfg.getIdObject(d);
		cfg.updateObject(e);
		
	}

	
}