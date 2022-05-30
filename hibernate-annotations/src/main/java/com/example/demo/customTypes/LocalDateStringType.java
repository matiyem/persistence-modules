package com.example.demo.customTypes;

import org.hibernate.dialect.Dialect;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.DiscriminatorType;
import org.hibernate.type.descriptor.java.LocalDateJavaDescriptor;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

import java.time.LocalDate;

/*
    Create by Atiye Mousavi 
    Date: 5/23/2022
    Time: 2:56 PM
**/
public class LocalDateStringType extends AbstractSingleColumnStandardBasicType<LocalDate> implements DiscriminatorType<LocalDate> {
    public static final LocalDateStringType INSTANCE = new LocalDateStringType();

    public LocalDateStringType() {
        super(VarcharTypeDescriptor.INSTANCE, LocalDateStringJavaDescriptor.INSTANCE);
    }

    @Override
    public String getName() {
        return "LocalDateString";
    }

    @Override
    public LocalDate stringToObject(String xml) throws Exception {
        return fromString(xml);
    }

    @Override
    public String objectToSQLString(LocalDate value, Dialect dialect) throws Exception {
        return '\'' + toString(value) + '\'';
    }
}
