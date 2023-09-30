package com.nva.server.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@PropertySource("classpath:mail.properties")
public class MailConfig {
    @Autowired
    private Environment env;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.env.getProperty("mail.host"));
        mailSender.setPort(Integer.parseInt(this.env.getProperty("mail.port")));
        mailSender.setUsername(this.env.getProperty("mail.username"));
        mailSender.setPassword(this.env.getProperty("mail.password"));

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", this.env.getProperty("mail.properties.mail.transport.protocol"));
        props.put("mail.smtp.auth", this.env.getProperty("mail.properties.mail.smtp.auth"));
        props.put("mail.smtp.starttls.enable", this.env.getProperty("mail.properties.mail.smtp.starttls.enable"));
        props.put("mail.smtp.ssl.enable", this.env.getProperty("mail.properties.mail.smtp.ssl.enable"));
        props.put("mail.from", this.env.getProperty("mail.properties.mail.from"));
        props.put("mail.debug", this.env.getProperty("mail.properties.mail.debug"));

        return mailSender;
    }
}
