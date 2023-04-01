package de.maxcim.sampleblogbackend.apis

import de.maxcim.sampleblogbackend.model.BlogPost
import de.maxcim.sampleblogbackend.service.BlogPostService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.ArrayList

// TODO:
// 1 Delete:    "/api/v1/post/{id}"     DELETES a single post by id
// 2 Post:      "/api/v1/post"          UPDATED a single post
// 3 Put:       "/api/v1/post"          It writes a single post
// 4 Post:      "/api/v1/post/search"   It searches for a list of posts matching the query object

@RestController
@RequestMapping(value = ["/api/v1/post"])
class PostController(var blogPostService: BlogPostService) {

	@DeleteMapping(value = ["/{id}"])
	fun deletePost(@PathVariable(name= "id") id: String): String {
		return this.blogPostService.deleteExistingBlogPost(id)
	}

	@PostMapping
	fun updatePost(@RequestBody post: BlogPost): BlogPost {

		return this.blogPostService.updateExistingBlogPost(post)
	}

	@PutMapping
	fun writeNewPost(@RequestBody post: BlogPost): BlogPost {

		return this.blogPostService.writeNewBlogPost(post)
	}

	@PostMapping(value = ["/search"])
	fun doSearch(@RequestBody samplePost: BlogPost): List<BlogPost> {

		return this.blogPostService.doSearch(samplePost)
	}
}