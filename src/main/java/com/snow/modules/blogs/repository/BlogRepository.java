package com.snow.modules.blogs.repository;

import com.snow.modules.blogs.model.SBlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Kelvin on 2017/2/9.
 */
@Repository
public interface BlogRepository extends JpaRepository<SBlogEntity, Integer> {
}
