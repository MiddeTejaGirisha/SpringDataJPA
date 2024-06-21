package com.example.Mapping;

import com.example.Mapping.Model.Comment;
import com.example.Mapping.Model.Post;
import com.example.Mapping.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
import java.util.Optional;


@SpringBootApplication
@EnableJpaAuditing
@EnableCaching
public class MappingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MappingApplication.class, args);
	}

	@Autowired
	private PostRepository postRepository;


	@Override
	public void run(String...args) throws Exception {

		Post post = new Post("one to many mapping using JPA and hibernate", "one to many mapping using JPA and hibernate");

		Comment comment1 = new Comment("Very useful");
		Comment comment2 = new Comment("informative");
		Comment comment3 = new Comment("Great post");

		post.getCommentList().add(comment1);
		post.getCommentList().add(comment2);
		post.getCommentList().add(comment3);

		this.postRepository.save(post);

//		@Bean
//		public AuditorAware<String> auditorProvider() {
//			return () -> Optional.of("System"); // Replace with actual logic to fetch current user
//		}

		int pageNo=0;
		int pageSize=3;


		// Fetching paginated and sorted results
		//Pageable pageable = PageRequest.of(0, 5, Sort.by("title").ascending());


		//Pagenation usage

		Page<Post> postsbykeywords=postRepository.findByDescriptionContaining("hibernate", PageRequest.of(pageNo,pageSize));

        //Query creation using method naming convention
		//postsbykeywords.forEach(p->System.out.println("Found by keyword"+p.getDescription()));
		System.out.println("Total elements: " + postsbykeywords.getTotalElements());
		System.out.println("Total pages: " + postsbykeywords.getTotalPages());
		System.out.println("Current page number: " + postsbykeywords.getNumber());
		System.out.println("Current page size: " + postsbykeywords.getSize());
		System.out.println("Found by keyword '" + "HIBERNATE" + "' in description:");
		postsbykeywords.forEach(p -> System.out.println("Post ID: " + p.getId() + ", Description: " + p.getDescription()));

	}
}


