package com.example.book.service;

import com.example.book.model.Role;

public interface RoleService {
    Role save(Role role);

    Role findByName(String name);
}
