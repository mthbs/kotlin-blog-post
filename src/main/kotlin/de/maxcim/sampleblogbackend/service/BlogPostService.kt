package de.maxcim.sampleblogbackend.service

import de.maxcim.sampleblogbackend.model.BlogPost
import de.maxcim.sampleblogbackend.repository.BlogPostRepository
import org.springframework.data.domain.Example
import org.springframework.stereotype.Service
import java.util.Date

@Service
class BlogPostService(var repository: BlogPostRepository) {

	fun writeNewBlogPost(blogPost: BlogPost): BlogPost {

		if (blogPost.id != null) {
			throw IllegalArgumentException("A blog post must not have an id in order to be written for the first time")
		}

		blogPost.creationDate = Date()
		return this.repository.save(blogPost)
	}

	fun updateExistingBlogPost(blogPost: BlogPost): BlogPost {

		if(blogPost.id == null) {

			throw IllegalArgumentException("I can update only posts that have an id")
		}

		blogPost.creationDate = Date()
		return this.repository.save(blogPost)
	}

	fun deleteExistingBlogPost(id: String): String {
		try {
			this.repository.deleteById(id)
			return "OK"
		} catch (e: Exception) {
			return "KD"
		}
	}

	fun doSearch(blogPost: BlogPost): List<BlogPost> {

		return this.repository.findAll(Example.of(blogPost))
	}

}
