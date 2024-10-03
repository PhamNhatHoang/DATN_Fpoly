package com.example.petshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class AuthorityId implements java.io.Serializable {
    private static final long serialVersionUID = 7548344997733274655L;
    @Size(max = 50)
    @NotNull
    @Column(name = "Username", nullable = false, length = 50)
    private String username;

    @Size(max = 50)
    @NotNull
    @Column(name = "Authority", nullable = false, length = 50)
    private String authority;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AuthorityId entity = (AuthorityId) o;
        return Objects.equals(this.authority, entity.authority) &&
                Objects.equals(this.username, entity.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authority, username);
    }
}