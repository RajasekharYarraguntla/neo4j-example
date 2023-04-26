package com.evoke;

import com.evoke.entity.Post;
import com.evoke.entity.UploadFile;
import com.evoke.repository.PostRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableNeo4jRepositories
@CommonsLog
public class Neo4jExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(Neo4jExampleApplication.class, args);
    }


    @Bean
    CommandLineRunner demo(PostRepository postRepository) {
        return args -> {

            Post firstPost = new Post("First Post");
            Post secondPost = new Post("Second Post");
            Post thirdPost = new Post("Third Post");

            log.info("Before linking up with Neo4j...");

            postRepository.save(firstPost);
            postRepository.save(secondPost);
            postRepository.save(thirdPost);

            firstPost = postRepository.findByName(firstPost.getName());
            firstPost.setImages(getImages());
            postRepository.save(firstPost);

            secondPost = postRepository.findByName(secondPost.getName());
            secondPost.setImages(getImages());
            postRepository.save(secondPost);

            thirdPost = postRepository.findByName(thirdPost.getName());
            thirdPost.setImages(getImages());
            postRepository.save(thirdPost);

            final List<Post> all = postRepository.findAll();
            all.forEach(log::info);
        };
    }

    private Set<UploadFile> getImages() {
        UploadFile uploadFile = new UploadFile();
        uploadFile.setId(1L);
        uploadFile.setActive(true);
        uploadFile.setUrl("https://svdupdevstorage.blob.core.windows.net/portal/files/main/post/4fca989bae674044a4e5975e4b95d576.jpg");
        uploadFile.setMimeType("image/jpeg");
        uploadFile.setFilesize(125666L);
        uploadFile.setThumbnailUrl("https://svdupdevstorage.blob.core.windows.net/portal/files/main/post/4fca989bae674044a4e5975e4b95d576.jpg");
        return Collections.singleton(uploadFile);

    }

}
