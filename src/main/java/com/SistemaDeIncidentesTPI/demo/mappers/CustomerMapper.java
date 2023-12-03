package com.SistemaDeIncidentesTPI.demo.mappers;

import com.SistemaDeIncidentesTPI.demo.models.dtos.CustomerDto;
import com.SistemaDeIncidentesTPI.demo.models.entities.Customer;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerMapper {
    public Customer dtoToCustomer (CustomerDto dto) {
        return Customer.builder()
                .name(dto.getName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .businessName(dto.getBusinessName())
                .cuit(dto.getCuit())
                .build();
    }

    public CustomerDto customerToDto (Customer customer){
        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .businessName(customer.getBusinessName())
                .cuit(customer.getCuit())
                .build();
    }
}
