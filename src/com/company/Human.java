package com.company;

public class Human extends Animal {
    private  String country;
    public Human(String name, int age ,String country){
        super(name,age);
        this.country = country;
    }

    @Override
    public void say() { //此处也可以实现Talking接口中的say函数，此即为多态
//        super.say();
        System.out.println("This is Human from "  + country);
    }
}
