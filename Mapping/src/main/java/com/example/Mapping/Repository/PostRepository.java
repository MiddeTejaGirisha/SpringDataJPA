package com.example.Mapping.Repository;

import com.example.Mapping.Model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    //Query Creation of type -Method naming convention
    List<Post> findByTitle(String title);//sort specified here

    //Direct sorting by importing Sort cls and can sort by pageable parameter of sort.by("field name i.e Title")
    //List<Post> findByCategoryOrderByTitleDesc(String category, Sort sort); // Sort passed as a parameter
    Page<Post> findByDescriptionContaining(String keyword, Pageable pageable);
    List<Post> findByTitleAndDescription(String title, String content);

    //Pagination
}
