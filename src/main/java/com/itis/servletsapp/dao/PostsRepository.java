package com.itis.servletsapp.dao;

import com.itis.servletsapp.dao.base.CrudRepository;
import com.itis.servletsapp.model.Post;

public interface PostsRepository extends CrudRepository<Post, Long> {
}
