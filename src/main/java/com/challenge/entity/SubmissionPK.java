package com.challenge.entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class SubmissionPK implements Serializable {

    @ManyToOne
    private User user;

    @ManyToOne
    private Challenge challenge;
}
