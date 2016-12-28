package org.library.entity;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by admin on 2016/12/26.
 */
@Entity
@Table(name="tb_readers")
public class Readers {
    @Id
    @Column(name="name")
    private String name;          //读者姓名
    @Column(name="sex")
    private String sex;           //读者性别
    @Column(name="age")
    private int age;            //读者年龄
    @Column(name="identityCard")
    private String identityCard;  //证件号码
    @Column(name="date")
    private Date date;          //会员证有效日期
    @Column(name="maxNum")
    private int maxNum;         //最大借书量
    @Column(name="tel")
    private String tel;           //电话号码
    @Column(name="keepMoney")
    private double keepMoney;   //押金
    @Column(name="zj")
    private int zj;             //证件类型
    @Column(name="zy")
    private String zy;            //职业
    @Column(name="ISBN")
    private String ISBN;          //读者编号
    @Column(name="bztime")
    private Date bztime;        //办证日期
    @Column(name="password")
    private String password;     //读者密码

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="ver")
    private int ver = 1;        //乐观锁版本控制

    public int getVer() {
        return ver;
    }

    public void setVer(int ver) {
        this.ver = ver;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public double getKeepMoney() {
        return keepMoney;
    }

    public void setKeepMoney(double keepMoney) {
        this.keepMoney = keepMoney;
    }

    public int getZj() {
        return zj;
    }

    public void setZj(int zj) {
        this.zj = zj;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Date getBztime() {
        return bztime;
    }

    public void setBztime(Date bztime) {
        this.bztime = bztime;
    }
}
