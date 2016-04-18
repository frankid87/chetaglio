import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.chetaglio.service.dto.NegozioDTO;



public class BeanCopyProperty {

	public static <T> copyPropertyExcludeNull(T source, T target){

		return BeanUtils.copyProperties(source, target, ignoreProperties);
	}

	private String[] getNullProperties(Object source) throws IllegalArgumentException, IllegalAccessException{
		List<String> list = new ArrayList();

		NegozioDTO dto = new NegozioDTO();
		Field[] fields = dto.getClass().getDeclaredFields();
		for(Field field: fields){
			field.setAccessible(true);
			if(field.get(dto) == null){
				list.add(field.getName());
			}
		}

		return (String[]) list.toArray();
	}

}
