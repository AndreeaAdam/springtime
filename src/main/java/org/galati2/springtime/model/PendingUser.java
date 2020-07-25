package org.galati2.springtime.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@Entity
@Table
public class PendingUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;  //by default persistance gerenates tabla_id
    @OneToOne
    @JoinColumn(name = "userId")
    private User user;
    private String username;
    private String emailAddress;
    private Date expireAt;

}
