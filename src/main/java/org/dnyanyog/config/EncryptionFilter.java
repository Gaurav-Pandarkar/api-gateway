package org.dnyanyog.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

//@Component
public class EncryptionFilter extends AbstractGatewayFilterFactory<EncryptionFilter.Config> {

	public EncryptionFilter() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		return (exchange, chain) -> {
			// Retrieve the request body
			String requestBody = exchange.getAttribute("cachedRequestBodyObject");

			// Perform encryption logic on the specified fields
			String encryptedRequestBody = performEncryption(requestBody);

			// Set the modified request body
			exchange.getAttributes().put("cachedRequestBodyObject", encryptedRequestBody);

			// Continue with the request chain
			return chain.filter(exchange);
		};
	}

	private String performEncryption(String requestBody) {
		// Implement your encryption logic here
		// Example: Replace this with your actual encryption mechanism
		// For simplicity, let's assume we are just reversing the string
		return new StringBuilder(requestBody).reverse().toString();
	}

	public static class Config {
		// Configuration properties, if needed
	}
}
