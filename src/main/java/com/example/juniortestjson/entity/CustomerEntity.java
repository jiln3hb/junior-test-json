package com.example.juniortestjson.entity;

import com.example.juniortestjson.dto.CustomerEntityDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedNativeQuery(name = "CustomerEntity.findByLastName", query = "SELECT first_name, last_name FROM customer WHERE last_name = :last_name",
        resultSetMapping = "Mapping.CustomerEntityDTO")
@SqlResultSetMapping(name = "Mapping.CustomerEntityDTO", classes = @ConstructorResult(targetClass = CustomerEntityDTO.class,
        columns = {@ColumnResult(name = "first_name"), @ColumnResult(name = "last_name")}))
@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {

    @Id
    @SequenceGenerator(name = "CUSTOMER_ID_GEN", sequenceName = "CUSTOMER_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_ID_GEN")
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Override
    public String toString() {
        return "firstName: " + firstName + ", lastName: " + lastName;
    }
}
