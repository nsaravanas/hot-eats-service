package com.hoteats.monitor.common;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

@Component
public class BackendEndpoint implements Endpoint<List<String>> {

	@Override
	public String getId() {
		return "backendEndpoint";
	}

	@Override
	public List<String> invoke() {
		return Arrays.asList("test message 1", "test message 2", "test message 3");
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isSensitive() {
		return true;
	}

}
