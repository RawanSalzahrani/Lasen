package lasen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
     @Column(name="dimonds")
     private int dimonds;

     public user() {
    }

    public user(String email, String name, int age, String password, int current_balance, int dimonds) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.password = password;
        this.current_balance = current_balance;
        this.dimonds = dimonds;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getDimonds() {
        return dimonds;
    }

    public void setDimonds(int dimonds) {
        this.dimonds = dimonds;
    }

}

