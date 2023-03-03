package com.shakhawat.repository.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shakhawat.model.user.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
