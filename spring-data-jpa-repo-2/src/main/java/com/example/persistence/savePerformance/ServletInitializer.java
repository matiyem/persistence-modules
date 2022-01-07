package com.example.persistence.savePerformance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ServletInitializer extends SpringBootServletInitializer {

    @Autowired
    private BookRepository bookRepository;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ServletInitializer.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(ServletInitializer.class, args);
    }
    //وقتی برنامه اومد بالا و آماده بود این متد اجرا میشود
    @EventListener(ApplicationReadyEvent.class)
    public void executePerformanceBenchmark(){
        int bookCount=10000;
        long start=System.currentTimeMillis();
        for (int i=0;i<bookCount;i++){
            bookRepository.save(new Book("Book " + i ,"Author " + i));
        }
        long end=System.currentTimeMillis();
        bookRepository.deleteAll();

        System.out.println("It took " + (end - start) + "ms to execute save() for " + bookCount + " books");

        List<Book> bookList=new ArrayList<>();
        for (int i=0 ; i<bookCount ; i++){
            bookList.add(new Book("Book " + i, "Author " + i));
        }

        start=System.currentTimeMillis();
        bookRepository.saveAll(bookList);
        end=System.currentTimeMillis();
        System.out.println("It took " + (end - start) + "ms to execute saveAll() with " + bookCount + " books\n");



    }
}
