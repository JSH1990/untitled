package com.black.jaxb_test;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.io.File;

/*
        JAXB(Java Architecture for XML Binding)는 자바 클래스를 XML로 표현하는 자바 API
        자바 객체 -> XML (직렬화 - Marshalling)
        XML -> 자바 객체 (역직렬화 - UnMarshalling)
 */

@SpringBootApplication
public class JaxbTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JaxbTestApplication.class, args);

        try {
            File file = new File("C:\\jaxb_test\\test2.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(UserXml.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            jaxbUnmarshaller.setEventHandler(new CustomEventHandler());

            UserXml customer = (UserXml) jaxbUnmarshaller.unmarshal(file);

            System.out.println(customer);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
