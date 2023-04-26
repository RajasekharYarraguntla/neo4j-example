package com.evoke.repository;

import com.evoke.entity.Post;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PostRepository extends Neo4jRepository<Post, Long> {

    Post findByName(String name);

}
