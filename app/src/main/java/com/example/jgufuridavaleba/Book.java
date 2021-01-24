package com.example.jgufuridavaleba;

public class Book {


     String title;
     String answer;

    public Book() {
    }
    public Book(String title, String answer){
        this.title = title;
        this.answer = answer;

    }

//    public static Class<Book> Class() {
//        return null;
//    }


    public String getTitle(){
        return title;
    }
    public  void setTitle(String title){
        this.title = title;
    }
    public String getAnswer(String answer){
        return answer;

    }
    public  void  setAnswer(String answer){
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}
