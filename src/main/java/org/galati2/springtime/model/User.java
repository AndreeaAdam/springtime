package org.galati2.springtime.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;  //by default persistance gerenates tabla_id
    private String username;
    private String password;
    private String emailAddress;

    @OneToOne(mappedBy = "user")
    private PendingUser pendingUser;
}
