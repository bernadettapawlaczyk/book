package com.example.book.repository;

import com.example.book.model.Copy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.sql.rowset.CachedRowSet;

@Repository
public interface CopyRepository extends CrudRepository<Copy, Long> {
}
