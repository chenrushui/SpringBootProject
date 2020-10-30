package com.demo.www.springbootdemo.crs.jpa;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "AUTH_USE")
public class UserDO  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 32)
    private Long id;

    @Column(length = 32,columnDefinition = "varchar(100) default '' comment '用户名'")
    private String name;

    @Column(length = 32,columnDefinition = "varchar(100) default '' comment '账户'")
    private String account;

    @Column(length = 64,columnDefinition = "varchar(100) default '' comment '密码'")
    private String pwd;

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}