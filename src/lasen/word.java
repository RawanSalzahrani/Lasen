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
@Table(name="WORD")
public class word  implements java.io.Serializable {
    @Id
     @Column(name="word_id")
     private int word_id;
    @Id
     @Column(name="level_no")
     private int level_no;
     @Column(name="text")
     private String text;
     @Column(name="phoneme")
     private String phoneme;
     @Column(name="img")
     private byte[] img;

     public word() {
    }

    public word(int word_id, int level_no, String text, String phoneme, byte[] img) {
        this.word_id = word_id;
        this.level_no = level_no;
        this.text = text;
        this.phoneme = phoneme;
        this.img = img;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPhoneme() {
        return phoneme;
    }

    public void setPhoneme(String phoneme) {
        this.phoneme = phoneme;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
     
     
}
