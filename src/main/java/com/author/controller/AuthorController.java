package com.author.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.author.model.Author;
import com.author.service.IAuthorService;

@RestController
public class AuthorController {

	@Autowired
	public IAuthorService authorService;

	@PostMapping("/addBook")
	public Integer createEmploye(@RequestBody Author author) {
		Integer id = authorService.saveAuthor(author);
		return id;
	}

	@GetMapping("/getAllBooks")
	public List<Author> getAllAuthor() {
		return authorService.getAllAuthor();
	}

	@GetMapping("/book/{id}")
	public Optional<Author> getAuthorById(@PathVariable Integer id) {
		Optional<Author> author = authorService.getAuthorById(id);
		return author;
	}

	// delete the auther using autherid
	@DeleteMapping("/book/{id}")
	public ResponseEntity<Author> deleteAuthorById(@PathVariable Integer id) {
		System.out.println(id);
		ResponseEntity<Author> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			authorService.deleteAuthorById(id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;

	}

	/*
	 * @DeleteMapping("/deleteall") public String deleteAllAuthor() { return
	 * authorService.deleteAllAuthor(); }
	 */

	@PutMapping("/update/{id}")
	public ResponseEntity<Author> updateAuthor(@PathVariable("id") Integer id, @RequestBody Author author) {
		return new ResponseEntity<Author>(authorService.updateAuthor(author, id), HttpStatus.OK);
	}

}
