/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author horre
 */


@Entity
@Table(name="USER")
public class user  implements java.io.Serializable {
    @Id
    @Column(name="email")
     private String email;
     @Column(name="name")
     private String name;
     @Column(name="age")
     private int age;
     @Column(name="password")
     private String password;
     @Column(name="current_balance")
     private int current_balance;

     public user() {
    }
     
    public user(String name, String email, int age, String password, int current_balance) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.password = password;
        this.current_balance = current_balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCurrent_balance() {
        return current_balance;
    }

    public void setCurrent_balance(int current_balance) {
        this.current_balance = current_balance;
    }
         
     
    
}

