package de.maxcim.sampleblogbackend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.Date;

@Document(collection = "blog_post")
data class BlogPost(@Id var id: String?, var content: String?, var creationDate: Date?, var isHtml: Boolean?, var author: Author?) {

	data class Author(var name: String?, var surname: String?)
}