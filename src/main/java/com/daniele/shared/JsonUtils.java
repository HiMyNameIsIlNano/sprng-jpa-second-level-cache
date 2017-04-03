package com.daniele.shared;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	public static String prettyJsonString(final Object obj) {
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
