package br.inatel.cdg.annotation.reading;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//Nessa classe você deverá implementar a sua solução
//Adicionalmente você também deverá criar
//a anotação NumberToSum como parte da solução

public class AnnotationReader<T> {

	private Class<?> clazz;
	private List<Integer> val;
	int soma = 0;
	
	public AnnotationReader(Class<?> clazz) {
		this.clazz = clazz;
		val  = new ArrayList<Integer>();
	}

	public void readAnnotations(){
		
		for(Field field: clazz.getDeclaredFields()) {
			if(field.isAnnotationPresent(NumberToSum.class)) {			
				val.add(field.getAnnotation(NumberToSum.class).value());
			}
		}
		for(Method  method : clazz.getDeclaredMethods()){
			if (method.isAnnotationPresent(NumberToSum.class)) {
				val.add(method.getAnnotation(NumberToSum.class).value());
	        }
		}
		
	}
	
	public int getTotalSum() {
		for (int i = 0; i < val.size(); i++) {
			soma = soma + val.get(i);
		}
		return soma;  
	}

}