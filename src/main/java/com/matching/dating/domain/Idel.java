package com.matching.dating.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Idel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "range_start", nullable = false)
    private int rangeStart;

    @Column(name = "range_end", nullable = false)
    private int rangeEnd;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false,
            foreignKey = @ForeignKey(name="FK_MEMBER_TB_IDEL"))
    private Member member;

    public enum Type {
        AGE,
        HEIGHT
    }
}
