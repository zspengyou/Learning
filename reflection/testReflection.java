package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;




public class testReflection {
	public static void main(String [] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException{
		Class<Person> personClass = Person.class;
		String[] fields = new String []{"firstName","lastName","age","good"};
		Object[] values = new Object[]{"firstll","lastll",11,true};
		Constructor<Person> constructor = personClass.getConstructor();
		Person person = constructor.newInstance(new Object[0]);
		for(int i=0; i< fields.length; i++){
			String fieldName = fields[i];
			Object value = values[i];
			Field field = personClass.getDeclaredField(fieldName);
			field.setAccessible(true);		
			field.set(person, value);
			try{
				Method method = personClass.getMethod("set"+fieldName, String.class);// set 				
				method.invoke(person, value);		
			}catch(Exception e){}
			//TODO use setter to set the value rather than assign the value directly
		}
		System.out.println(person);

	}

}

