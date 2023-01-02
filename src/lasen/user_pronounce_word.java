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
@Table(name="USER_PRONOUNCE_WORD")
public class user_pronounce_word  implements java.io.Serializable {
    @Id
    @Column(name="email")
     private String email;
    @Id
    @Column(name="word_id")
     private int word_id;
    @Id
    @Column(name="level_no")
     private int level_no;
    @Column(name="correct_count")
     private int correct_count;
    @Column(name="incorrect_count")
     private int incorrect_count;

     public user_pronounce_word() {
    }

    public user_pronounce_word(String email, int word_id, int level_no, int correct_count, int incorrect_count) {
        this.email = email;
        this.word_id = word_id;
        this.level_no = level_no;
        this.correct_count = correct_count;
        this.incorrect_count = incorrect_count;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getWord_id() {
        return word_id;
    }

    public void setWord_id(int word_id) {
        this.word_id = word_id;
    }

    public int getLevel_no() {
        return level_no;
    }

    public void setLevel_no(int level_no) {
        this.level_no = level_no;
    }

    public int getCorrect_count() {
        return correct_count;
    }

    public void setCorrect_count(int correct_count) {
        this.correct_count = correct_count;
    }

    public int getIncorrect_count() {
        return incorrect_count;
    }

    public void setIncorrect_count(int incorrect_count) {
        this.incorrect_count = incorrect_count;
    }

}
