package com.example.demo;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.source.spi.MetadataSourceProcessor;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.MetadataSource;
import org.hibernate.service.ServiceRegistry;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import static java.util.Objects.requireNonNull;

/*
    Create by Atiye Mousavi 
    Date: 5/29/2022
    Time: 11:50 AM
**/
public class UnsupportedTenancyException extends Exception {

    public UnsupportedTenancyException (String message) {
        super(message);
    }

}
