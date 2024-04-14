package com.example.example_dz_rest.controllers;

import com.example.example_dz_rest.domain.Note;
import com.example.example_dz_rest.domain.NoteA;
import com.example.example_dz_rest.domain.NoteB;
import com.example.example_dz_rest.service.FileGateway;
import com.example.example_dz_rest.service.NoteService;

import factory.NoteFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private final NoteService noteService;
    @Autowired
    private final FileGateway fileGateway;
    @Autowired
    private final NoteFactory noteFactory;

    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        Note newNote = noteService.addNote(note);
        return ResponseEntity.ok(newNote);
    }

    @PostMapping("/addnotetofile")
    public ResponseEntity<Note> addNoteToFile(@RequestBody Note note) {
        note.setCreationdate(LocalDateTime.now());
        fileGateway.writeToFile(note.getTitle() + ".txt", note.toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/fabric")
    public Note addNoteByFactory(@RequestBody String type, Note note) {
        if (type.equalsIgnoreCase("A")) {
            return new NoteA();
        } else if (type.equalsIgnoreCase("B")) {
            return new NoteB();
        } else {
            return null;
        }
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteService.getAllNotes();
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/{id}")
    public Optional<Note> getNoteById(@PathVariable Long id) {
        return noteService.findById(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note) {
        Note updatedNote = noteService.updateNote(id, note);
        return ResponseEntity.ok(updatedNote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/test")
    public ResponseEntity<Void> test() {
        return ResponseEntity.ok().build();
    }
}
