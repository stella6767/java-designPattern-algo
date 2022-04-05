package javacore.basic;

public class FactoryPattern {

    public DBConnector connector(){

        return new MysqlConnector();
    }


    public 결제서비스 결제서비스(){

        return new 결제서비스(connector());
    }


}
