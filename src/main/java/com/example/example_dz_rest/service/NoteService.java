package com.example.example_dz_rest.service;

import com.example.example_dz_rest.domain.Note;
import com.example.example_dz_rest.repository.NoteRepository;
import factory.NoteFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    private NoteFactory noteFactory;

    public NoteService(NoteRepository noteRepository, @Qualifier("noteAFactory") NoteFactory noteFactory) {
        this.noteRepository = noteRepository;
        this.noteFactory = noteFactory;
    }


    public Note addNote(Note note) {
        note.setCreationdate(LocalDateTime.now());
        return noteRepository.save(noteFactory.createNote(note));
        //return noteRepository.save(note);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note updateNote(Long id, Note note) {
        Note existingNote = noteRepository.findById(id).orElseThrow();
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
        return noteRepository.save(existingNote);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    public Optional<Note> findById(Long id) {
        return noteRepository.findById(id);
    }
}
