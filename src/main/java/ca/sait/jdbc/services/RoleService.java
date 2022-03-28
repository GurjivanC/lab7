package ca.sait.jdbc.services;

import ca.sait.jdbc.dataaccess.RoleDB;

import ca.sait.jdbc.models.Role;
import java.util.List;

public class RoleService {

    private RoleDB roleDB = new RoleDB();

    public List<Role> getAll() throws Exception {
        List<Role> roles = roleDB.getAll();
        return roles;
    }
}
