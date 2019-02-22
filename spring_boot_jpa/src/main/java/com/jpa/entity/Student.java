package com.jpa.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Description:
 * User: purui_zhang
 * Date: 2019-02-21
 * Time: 18:30
 */
@Getter
@Setter
@Entity
@Table
public class Student implements Serializable{
    @Id
    @GeneratedValue(generator = "faceset_generator")
    @GenericGenerator(name = "faceset_generator", strategy = "uuid")
    private String id;
    @Column
    private String name;
    @Column
    private Integer age;
}
