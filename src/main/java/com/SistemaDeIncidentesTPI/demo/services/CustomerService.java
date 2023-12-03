package com.SistemaDeIncidentesTPI.demo.services;

import com.SistemaDeIncidentesTPI.demo.exceptions.CustomerNotExistsException;
import com.SistemaDeIncidentesTPI.demo.mappers.CustomerMapper;
import com.SistemaDeIncidentesTPI.demo.models.dtos.CustomerDto;
import com.SistemaDeIncidentesTPI.demo.models.entities.Customer;
import com.SistemaDeIncidentesTPI.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    //CREAR CLIENTE
    public CustomerDto createCustomer (CustomerDto customerDto){
        Customer customerValidated = validateCustomerByCuit(customerDto);
        if (customerValidated == null){
            Customer customerSaved = repository.save(CustomerMapper.dtoToCustomer(customerDto));
            return CustomerMapper.customerToDto(customerSaved);
        } else{
            throw new CustomerNotExistsException("Cliente con CUIT: " + customerDto.getCuit() + " ya existe");
        }
    }

    //TRAER TODOS LOS CLIENTES

    public List<CustomerDto> getCustomers() {
        List<Customer> customers = repository.findAll();
        List<CustomerDto> customersDtos = customers.stream()
                .map(CustomerMapper::customerToDto)
                .collect(Collectors.toList());
        return customersDtos;
    }

    //TRAER CLIENTE POR ID

    public CustomerDto getCustomerById (Long id){
        Customer entity = repository.findById(id).get();
        return CustomerMapper.customerToDto(entity);
    }

    //ELIMINAR UN CLIENTE
    public String deleteCustomer(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return "El cliente con id: " + id + " ha sido eliminado";
        } else {
            throw new CustomerNotExistsException("El cliente a eliminar elegido no existe");
        }
    }

    //ACTUALIZAR UN CLIENTE

    public CustomerDto updateCustomer(Long id, CustomerDto dto) {
        if (repository.existsById(id)){
            Customer customerToModify = repository.findById(id).get();

            if (dto.getName() != null){
                customerToModify.setName(dto.getName());
            }

            if (dto.getLastName() != null){
                customerToModify.setLastName(dto.getLastName());
            }

            if (dto.getEmail() != null){
                customerToModify.setEmail(dto.getEmail());
            }

            if (dto.getBusinessName() != null){
                customerToModify.setBusinessName(dto.getBusinessName());
            }

            if (dto.getCuit() != null){
                customerToModify.setCuit(dto.getCuit());
            }

            Customer customerModified = repository.save(customerToModify);

            return CustomerMapper.customerToDto(customerModified);
        }
        return null;
    }
    // VALIDAR QUE EXISTEN CLIENTES UNICOS POR CUIT
    public Customer validateCustomerByCuit(CustomerDto dto){
        return repository.findByCuit(dto.getCuit());
    }

}
