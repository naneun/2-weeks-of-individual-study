package com.naneun.mall.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString(exclude = "orderSheets")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String userId;

    private String name;

    @NotEmpty
    private String refreshToken;

    @NotEmpty
    private String resourceServer;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<OrderSheet> orderSheets;

    @Builder
    private Member(Long id, String userId, String name, String refreshToken, String resourceServer) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.refreshToken = refreshToken;
        this.resourceServer = resourceServer;
        this.orderSheets = new ArrayList<>();
    }
}
