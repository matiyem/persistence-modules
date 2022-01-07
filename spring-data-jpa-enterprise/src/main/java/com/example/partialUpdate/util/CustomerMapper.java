package com.example.partialUpdate.util;

import com.example.partialUpdate.model.Customer;
import com.example.partialUpdate.model.CustomerDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    //با این کار ، ما می توانیم entity ذخیره شده را load کرده و قبل از فراخوانی متد ذخیره JPA آنها را با DTO ادغام کنیم - در واقع ، ما فقط مقادیر اصلاح شده را به روز می کنیم.
//    اشکال این روش این است که ما نمی توانیم در طول یک به روز رسانی مقادیر null را به پایگاه داده منتقل کنیم.
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCustomerFromDto(CustomerDto dto, @MappingTarget Customer entity);
}
