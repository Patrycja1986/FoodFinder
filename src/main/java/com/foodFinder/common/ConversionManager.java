package com.foodFinder.common;

import com.foodFinder.model.customer.Customer;
import com.foodFinder.model.customer.CustomerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.text.ParseException;

public class ConversionManager<Entity,DTO> {

    private Entity entity;
    private DTO dto;
    private ModelMapper modelMapper;

    public ConversionManager(Entity entity, DTO dto) {
        this.entity = entity;
        this.dto = dto;
    }

    public DTO convertToDto(Entity entity) {
       return modelMapper.map(entity, (Type) dto.getClass());
    }

    public Entity convertToEntity(DTO dto) throws ParseException {

        return modelMapper.map(dto, (Type) entity.getClass());
    }
}
