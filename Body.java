package com.black.jaxb_test;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "body", propOrder = {
        "userJob"
})
@ToString
public class Body {

//    @XmlElement(name = "UserName", required = true, nillable = true)
//    private String userName;
    @XmlElement(name = "UserJob", required = true, nillable = true)
    private String userJob;
}