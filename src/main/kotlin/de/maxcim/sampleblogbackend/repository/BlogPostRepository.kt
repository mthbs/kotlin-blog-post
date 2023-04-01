package de.maxcim.sampleblogbackend.repository

import de.maxcim.sampleblogbackend.model.BlogPost
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface BlogPostRepository : MongoRepository<BlogPost, String>
