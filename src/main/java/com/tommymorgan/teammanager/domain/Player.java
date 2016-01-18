package com.tommymorgan.teammanager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String email;
    private String firstName;
    private String lastName;

    protected Player() {}

    public Player(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format(
                "Player[id=%d, firstName='%s', lastName='%s', email='%s']",
                id, firstName, lastName, email);
    }

}

