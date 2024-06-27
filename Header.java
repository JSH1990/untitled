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
@XmlType(name = "header", propOrder = {
        "timeStamp"
})
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Header {

    @XmlElement(name = "TimeStamp", required = true, nillable = true)
    private String timeStamp;
}