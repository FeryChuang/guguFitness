package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "chick")
public class Chick implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer chick_id;
    private Integer current_level;
    private Integer current_exp;
    private Integer lifecount;
    private String user_name;
    private String chick_stage;

    public Chick() {
    }

    public Chick(Integer chick_id, Integer current_level, Integer current_exp, Integer lifecount,
                 String user_name, String chick_stage) {
        this.chick_id = chick_id;
        this.current_level = current_level;
        this.current_exp = current_exp;
        this.lifecount = lifecount;
        this.user_name = user_name;
        this.chick_stage = chick_stage;
    }

    public Integer getChick_id() {
        return chick_id;
    }

    public void setChick_id(Integer chick_id) {
        this.chick_id = chick_id;
    }

    public Integer getCurrent_level() {
        return current_level;
    }

    public void setCurrent_level(Integer current_level) {
        this.current_level = current_level;
    }

    public Integer getCurrent_exp() {
        return current_exp;
    }

    public void setCurrent_exp(Integer current_exp) {
        this.current_exp = current_exp;
    }

    public Integer getLifecount() {
        return lifecount;
    }

    public void setLifecount(Integer lifecount) {
        this.lifecount = lifecount;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getChick_stage() {
        return chick_stage;
    }

    public void setChick_stage(String chick_stage) {
        this.chick_stage = chick_stage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chick chick = (Chick) o;
        return Objects.equals(chick_id, chick.chick_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chick_id);
    }

    @Override
    public String toString() {
        return "Chick{" +
                "chick_id=" + chick_id +
                ", current_level=" + current_level +
                ", current_exp=" + current_exp +
                ", lifecount=" + lifecount +
                ", user_name='" + user_name + '\'' +
                ", chick_stage='" + chick_stage + '\'' +
                '}';
    }
}
