//  *******************************************
//  * Copyright (c) CRIF - All Right Reserved *
//  *******************************************

package com.designpatterns.demo;

class Products{
    String Attribute1;
    String Attribute2;

    public String getAttribute1() {
        return Attribute1;
    }

    public void setAttribute1(String attribute1) {
        Attribute1 = attribute1;
    }

    public String getAttribute2() {
        return Attribute2;
    }

    public void setAttribute2(String attribute2) {
        Attribute2 = attribute2;
    }

    public String getAttribute3() {
        return Attribute3;
    }

    public void setAttribute3(String attribute3) {
        Attribute3 = attribute3;
    }

    String Attribute3;
}

interface ProcuctBuilder{
    void buildAttribute1(String attribute1);
    void buildAttribute2(String attribute2);
    void buildAttribute3(String attribute3);
    Products getResult();
}

class ConcreteProcuctBuilder implements ProcuctBuilder{
    private Products products;
    public ConcreteProcuctBuilder(){
        products=new Products();
    }
    @Override
    public void buildAttribute1(String attribute1) {
        products.setAttribute1(attribute1);
    }

    @Override
    public void buildAttribute2(String attribute2) {
        products.setAttribute1(attribute2);
    }

    @Override
    public void buildAttribute3(String attribute3) {
        products.setAttribute1(attribute3);
    }

    @Override
    public Products getResult() {
        return products;
    }
}

class ProductsDecorator{
    private ProcuctBuilder procuctBuilder;
    public void setProductBuilder(ProcuctBuilder procuctBuilder){
        this.procuctBuilder=procuctBuilder;
    }

    public Products construct(){
        procuctBuilder.buildAttribute1("1");
        procuctBuilder.buildAttribute2("2");
        procuctBuilder.buildAttribute3("3");
        return procuctBuilder.getResult();
    }
}
public class BuilderPattern {

    public static void main(String[] args) {
        ProcuctBuilder procuctBuilder=new ConcreteProcuctBuilder();
        ProductsDecorator decorator=new ProductsDecorator();
        decorator.setProductBuilder(procuctBuilder);
        Products products= decorator.construct();
        // The product is constructed with the desired attributes

    }
}
