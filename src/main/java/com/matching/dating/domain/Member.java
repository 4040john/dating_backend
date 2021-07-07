package com.matching.dating.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private int height;

    private String job;

    private String location;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String image;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Idel> idels;

    @OneToMany(mappedBy = "fromMember", cascade = CascadeType.REMOVE)
    private List<Dating> responseDate;

    @OneToMany(mappedBy = "toMember", cascade = CascadeType.REMOVE)
    private List<Dating> requestDate;

    public enum Gender {
        MAN,
        WOMAN
    }

    public Member setMember(String nickname, int age, int height, String job, String location, Gender gender, String image) {
        this.nickname = nickname;
        this.age = age;
        this.height = height;
        this.job = job;
        this.location = location;
        this.gender = gender;
        this.image = image;
        return this;
    }
}
