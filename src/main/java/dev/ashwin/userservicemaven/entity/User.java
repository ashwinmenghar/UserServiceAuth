package dev.ashwin.userservicemaven.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "ECOM_USER")
public class User extends BaseModel{
    private String name;
    private String emailId;
    private String password;
    private String token;

    @ManyToMany
    List<Role> roles;
}
