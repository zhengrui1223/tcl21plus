/*
 * Copyright (C) 2014 Epic Games, Inc. All Rights Reserved.
 */
package com.movit.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

public class JSONUtil
{

	private static ObjectMapper objectMapper;

	public static synchronized ObjectMapper defaultObjectMapper()
	{
		if (objectMapper == null)
		{
			objectMapper = new ObjectMapper();
			objectMapper.configure(SerializationFeature.INDENT_OUTPUT, false);
			objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
			objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

			objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			objectMapper.registerModule(new JodaModule());
		}
		return objectMapper;
	}
}
