package com.restapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.restapi.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
