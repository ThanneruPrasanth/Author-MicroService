package com.author.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.author.model.Author;
import com.author.service.IAuthorRepository;
import com.author.service.IAuthorService;

@Service
public class AuthorServiceImpl implements IAuthorService {

	@Autowired
	IAuthorRepository authorRepository;

	@Override
	public Integer saveAuthor(Author author) {
		Author savedAuthor = authorRepository.save(author);
		return savedAuthor.getAid();
	}

	@Override
	public List<Author> getAllAuthor() {

		return authorRepository.findAll();
	}

	@Override
	public Optional<Author> getAuthorById(Integer id) {

		return authorRepository.findById(id);
	}

	@Override
	public void deleteAuthorById(Integer id) {
		authorRepository.deleteById(id);
	}

	/*
	 * @Override public String deleteAllAuthor() { authorRepository.deleteAll();
	 * return "Deleted All Records"; }
	 */

	@Override
	public Author updateAuthor(Author author, Integer id) {
		Author existingauthor = authorRepository.findById(id)
				.orElseThrow(() -> new com.author.exception.ResouceNotFoundException("Author", "id", id));

		existingauthor.setTitle(author.getTitle());
		existingauthor.setCategory(author.getCategory());
		existingauthor.setImage(author.getImage());
		existingauthor.setPrice(author.getPrice());
		existingauthor.setPublisher(author.getPublisher());
		existingauthor.setActive(true);

		authorRepository.save(existingauthor);

		return existingauthor;
	}

}
