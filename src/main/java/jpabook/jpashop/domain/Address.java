package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address { //내장타입

    private String city;
    private String street;
    private String zipcode;

    protected Address() { //JPA는 기본생성자가 필요하다 @Setter를 뻇으니 기본생성자를 생성해주자.

    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
