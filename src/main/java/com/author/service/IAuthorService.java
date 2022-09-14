package com.author.service;

import java.util.List;
import java.util.Optional;

import com.author.model.Author;

public interface IAuthorService {
	
	Integer saveAuthor(Author author);
	
	public List<Author> getAllAuthor();
	
	Optional<Author> getAuthorById(Integer id);
	
	public void deleteAuthorById(Integer id);
	
	//String deleteAllAuthor();
	
	Author updateAuthor(Author author,Integer id);

}
