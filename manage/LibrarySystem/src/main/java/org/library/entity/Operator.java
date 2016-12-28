package org.library.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by admin on 2016/12/26.
 */
@Entity
@Table(name="tb_operator")
public class Operator {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;             //操作员编号
    @Column(name="name")
    private String name;          //用户名
    @Column(name="sex")
    private String sex;           //性别
    @Column(name="age")
    private int age;            //年龄
    @Column(name="identityCard")
    private String identityCard;  //证件号码
    @Column(name="worddate")
    private Date worddate;      //工作时间
    @Column(name="tel")
    private String tel;           //电话号码
    @Column(name="admin")
    private int admin;          //是否为管理员
    @Column(name="password")
    private String password;      //密码
    @Column(name="ver")
    private int ver;            //乐观锁版本控制

    public int getVer() {
        return ver;
    }

    public void setVer(int ver) {
        this.ver = ver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public Date getWorddate() {
        return worddate;
    }

    public void setWorddate(Date worddate) {
        this.worddate = worddate;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
