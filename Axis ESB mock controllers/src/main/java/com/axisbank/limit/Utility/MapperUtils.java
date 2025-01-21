package com.axisbank.limit.Utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.stream.Collectors;

import org.apache.commons.collections4.MapUtils;
import org.modelmapper.ModelMapper;

import lombok.extern.java.Log;

@Log
public class MapperUtils {

	private static final ModelMapper modelMapper;
	static {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true).setSkipNullEnabled(false);
	}

	public static <T> T convert(Object entity, Class<T> destinationType) {
		return modelMapper.map(entity, destinationType);
	}

	public static void objectMap(Object source, Object destination) {
		modelMapper.map(source, destination);
	}

	public static <T> List<T> convert(List<Object> entities, Class<T> destinationType) {
		return entities.stream().map(e -> {
			return convert(e, destinationType);
		}).collect(Collectors.toList());
	}


	@SuppressWarnings("unchecked")
	public static <T> T convertFromMap(Map<String, String> map, Class<T> destinationType) {
		try {
			if (MapUtils.isNotEmpty(map)) {
				Method[] methods = destinationType.getDeclaredMethods();
				Constructor<?> constructor = destinationType.getConstructor();
				Object object = constructor.newInstance();
				for (Method method : methods) {
					String methodName = method.getName();
					if (methodName.startsWith("set")) {
						String fieldName = methodName.substring(3);
						method.invoke(object, map.get(fieldName));
					}
				}
				return (T) object;
			}
		} catch (Exception e) {
			log.log(Level.SEVERE, "Error while creating object in MapperUtils:convertFromMap", e);
		}
		return null;
	}


}
