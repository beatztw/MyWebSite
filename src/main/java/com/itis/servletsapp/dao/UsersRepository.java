package com.itis.servletsapp.dao;

import com.itis.servletsapp.dao.base.CrudRepository;
import com.itis.servletsapp.model.User;

public interface UsersRepository extends CrudRepository<User, Long> {
}
