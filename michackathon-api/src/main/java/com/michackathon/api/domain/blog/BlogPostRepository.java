package com.michackathon.api.domain.blog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tomcy John
 */
@Repository
public interface BlogPostRepository extends CrudRepository<BlogPost, Long> {
}
