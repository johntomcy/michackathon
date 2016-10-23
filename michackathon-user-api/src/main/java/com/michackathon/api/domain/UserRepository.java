package com.michackathon.api.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tomasz Kucharzyk
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
