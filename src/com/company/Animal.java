package com.company;

public class Animal implements Talking { //快捷键Ctrl+O（Override）
    private  String name;
    private int age;
    public Animal(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public void say() {
        System.out.println(name + " Animal Say"); //实现接口的函数
    }
}
