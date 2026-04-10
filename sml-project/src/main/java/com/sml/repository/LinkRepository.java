package com.sml.repository;

import com.sml.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinkRepository extends JpaRepository<Link, Long> {

    List<Link> findByUserId(Long userId);

}