package com.example.jpa.stringCast;

import javax.persistence.*;

/*
    Create by Atiye Mousavi 
    Date: 6/18/2022
    Time: 3:25 PM
**/
@SqlResultSetMapping(name = "textQueryMapping", classes = {
        @ConstructorResult(targetClass = Message.class, columns = {
                @ColumnResult(name = "text")
        })
})
@Entity
public class Message {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String text;

        public Message() {

        }

        public Message(String text) {
                this.text = text;
        }

        public String getText() {
                return text;
        }

        public void setText(String text) {
                this.text = text;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

}
