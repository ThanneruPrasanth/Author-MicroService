package com.author.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.author.model.Author;
@Repository
public interface IAuthorRepository  extends JpaRepository<Author, Integer> {

}
