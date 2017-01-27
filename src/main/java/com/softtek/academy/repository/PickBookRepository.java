package com.softtek.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softtek.academy.domain.PickBook;

@Repository
public interface PickBookRepository extends JpaRepository<PickBook, Long>{

}
