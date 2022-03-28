package ca.sait.jdbc.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Represents a role
 *
 * @author 744941
 */
@Entity
@Table(name = "role")
@NamedQueries({
@NamedQuery (name = "Role.findAll", query = "SELECT r FROM Role r")})
public class Role implements Serializable {

    private int id;
    private String name;

    public Role() {

    }

    public Role(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
