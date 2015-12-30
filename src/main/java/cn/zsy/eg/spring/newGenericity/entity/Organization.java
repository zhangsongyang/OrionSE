package cn.zsy.eg.spring.newGenericity.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class Organization implements Serializable{

    private Long id;
    private String name;

}
