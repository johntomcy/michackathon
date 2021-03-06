package com.michackathon.api.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tomcy John
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
