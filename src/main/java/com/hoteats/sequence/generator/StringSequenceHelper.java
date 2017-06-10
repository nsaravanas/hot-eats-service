package com.hoteats.sequence.generator;

import java.util.HashMap;
import java.util.Map;

public final class StringSequenceHelper {

	private StringSequenceHelper() {
		throw new AssertionError("Can't instantiate");
	}

	private static final Map<String, String> SEQ_MAP = new HashMap<String, String>();
	static {
		SEQ_MAP.put("ORDERS", "ORD");
	}

	public static String getSequence(String claz) {
		return SEQ_MAP.get(claz);
	}

}
