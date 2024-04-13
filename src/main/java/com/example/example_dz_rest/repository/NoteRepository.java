package com.example.example_dz_rest.repository;

import com.example.example_dz_rest.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {

    Optional<Note> findById(Long id);


}
