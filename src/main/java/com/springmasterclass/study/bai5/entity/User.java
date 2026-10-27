package com.springmasterclass.study.bai5.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tl_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // này giúp insert vào dễ hơn 1 table hay class hơn là constructor (vd: sai lệch các vị trí,..)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    // UUID phải là String
    private String id;
    private String name;
    @Column(name="address", length=100)
    private String address;
    @Column(name="phone",length=10)
    private String phone;
    @Column(unique=true)
    private String email;
    private String username;
    private String password;
}
