package com.example.demo;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringDiscordBotCoatlicueApplication {

	@Autowired
	private static Environment env;

	public static void main(String[] args) {
		SpringApplication.run(SpringDiscordBotCoatlicueApplication.class, args);
	}

	@Bean
	@ConfigurationProperties(value = "discord-api")
	public DiscordApi discordApi() {
		String token = env.getProperty("OTEzOTkyMzAxODU0OTkwMzY2.YaGjqQ.UbcpIOoTEmWkzafpxn9FckSCd3c");
		DiscordApi api = new DiscordApiBuilder().setToken(token)
				.setAllNonPrivilegedIntents()
				.login()
				.join();
		return api;
	}
}
