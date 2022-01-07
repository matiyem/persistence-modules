package com.example.persistence.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import org.hibernate.envers.Audited;

@NamedNativeQueries({
        //یکی از راه های کال کردن sp روش زیر است
        @NamedNativeQuery(name = "callGetAllFoos", query = "CALL GetAllFoos()", resultClass = Foo.class),
        //برای اس پی هایی ورودی میگیرند
        @NamedNativeQuery(name = "callGetFoosByName", query = "CALL GetFoosByName(:fooName)", resultClass = Foo.class) })
//اس پی ها را هم میتوان به روش زیر هم استفاده کرد
//@NamedStoredProcedureQuery(
//  name="GetFoosByName",
//  procedureName="GetFoosByName",
//  resultClasses = { Foo.class },
//  parameters={
//    @StoredProcedureParameter(name="fooName", type=String.class, mode=ParameterMode.IN)
//  }
//)
@Entity
@Audited
// @Proxy(lazy = false)
public class Foo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(targetEntity = Bar.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "BAR_ID")
    private Bar bar = new Bar();

    public Foo() {
        super();
    }

    public Foo(final String name) {
        super();
        this.name = name;
    }

    //

    public Bar getBar() {
        return bar;
    }

    public void setBar(final Bar bar) {
        this.bar = bar;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    //

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Foo other = (Foo) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Foo [name=").append(name).append("]");
        return builder.toString();
    }

    //از طریق کد زیر میتوان یک sp را کال کرد
    //StoredProcedureQuery spQuery =
    //  entityManager.createNamedStoredProcedureQuery("getAllFoos");
    //میتوانیم بصورت مستقیم متد execute را اجرا کرده و خروجی را دریافت کنیم
}
