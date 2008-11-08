package ${entity.packageName};
// this must be in a gwt translatable package

import java.util.Map;

//This class can be serialized from server to client and back
public class ${entity.classNameWithoutPackage} extends ${entity.prefixClassNameWithoutPackage} {

	public ${entity.classNameWithoutPackage}() {	
		super();
	}
	
	public ${entity.classNameWithoutPackage}(Map map) {	
		super(map);
	}
	  
}
