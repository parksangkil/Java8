package com.company;

public class AbstractConstructorTest {
    public static void main(String args[]) {
        Server server = new Tomcat("Apache Tomcat"); server.start();
    }
}

abstract class Server{
    protected final String name;
    public Server(String name){
        this.name = name;
    }

    public abstract boolean start();
}

class Tomcat extends Server{
    public Tomcat(String name){
        super(name);
    }

    @Override
    public boolean start() {
        System.out.println( this.name + " started successfully");
        return true;
    }
}

