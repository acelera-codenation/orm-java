package com.challenge.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 100)
    @NotNull
    private String fullName;

    @Size(max = 100)
    @Email
    @NotNull
    private String email;

    @Size(max = 50)
    @NotNull
    private String nickname;

    @Size(max = 255)
    @NotNull
    private String password;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "primaryKey.Submission", fetch = FetchType.EAGER)
    private Set<Submission> submissions;

    @OneToMany(mappedBy = "primaryKey.Candidate", fetch = FetchType.EAGER)
    private Set<Candidate> candidates;
}
