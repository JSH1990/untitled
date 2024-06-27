package com.black.jaxb_test;

import jakarta.xml.bind.annotation.*;
import lombok.*;


@XmlRootElement(name = "User")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserType", propOrder = {
        "header",
        "body"
})
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserXml {

    @XmlElement(name = "Header", required = true, nillable = true)
    private Header header;
    @XmlElement(name = "Body", required = true, nillable = true)
    private Body body;
}


/*
<User>
	<Header>
		<TimeStamp>20230816105312</TimeStamp>
	</Header>
	<Body>
		<UserName>황재원</UserName>
		<UserJob>Developer</UserJob>
		<UserBlog>http://dev-jwblog.tistory.com</UserBlog>
	</Body>
</User>

    @XmlRootElement
    - XML 의 Root Element 명을 정의.
    - ex) @XmlRootElement(name = "header")

    @XmlElement
    - XML 의 Element 명을 정의.
    -ex) @XmlElement(name = "body")

    @XmlType
    - XML Schema 이름과 Namespace 를 정의.
    - propOrder 속성을 사용하여 XML 표현 시 요소들의 표현 순서 정의 가능.
    - ex) @XmlType(propOrder = {"header", "body"}

   @XmlElementWrapper
    - 다른 XML 요소들을 감싸는 역할.
    - List 같은 컬렉션 객체들을 XML 변활할 때 사용.

    @XmlTransient
    - XML에 포함하지 않은 필드에 사용.

    @XmlAttribute
    - ID 필드가 요소 대신 속성으로 매핑되도록 정의.

 */
