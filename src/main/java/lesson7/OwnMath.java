package lesson7;

import lesson7.annotation.AfterSuite;
import lesson7.annotation.BeforeSuite;
import lesson7.annotation.Test;

public class OwnMath {
    @BeforeSuite
    public void max(){
        System.out.println("a>=b");
    }
    @Test(priority = 9)
    public void min(){
        System.out.println("a<b");
    }
    @lesson7.annotation.Test(priority = 1)
    public void mul(){
        System.out.println("a*b");
    }
    @lesson7.annotation.Test(priority = 4)
    public void div(){
        System.out.println("a/b");
    }
    @lesson7.annotation.Test(priority = 2)
    public void sum(){
        System.out.println("a+b");
    }
    @lesson7.annotation.Test(priority = 2)
    public void sub(){
        System.out.println("a-b");
    }
    @Test(priority = 10)
    public void total1(){
        System.out.println("a^b");
    }
    @AfterSuite
    public void total(){
        System.out.println("Finish");
    }
}
