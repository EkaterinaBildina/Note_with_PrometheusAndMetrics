package com.example.example_dz_rest;

import com.example.example_dz_rest.domain.Note;
import com.example.example_dz_rest.repository.NoteRepository;
import com.example.example_dz_rest.service.NoteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ModExampleDzRestApplicationTests {
    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    public NoteService noteService;

    @Test
    public void noteReview(){
        // предпосылки
        Note note1 = new Note();
        note1.setId(1L);
        note1.setTitle("Task01");
        note1.setContent("Need to provide money to children");

        Note note2 = new Note();
        note2.setId(2L);
        note2.setTitle("Task02");
        note2.setContent("Call me at the afternoon");

        given(noteRepository.findById(note1.getId())).willReturn(Optional.of(note1));
        //when(noteRepository.findById(note1.getId())).thenReturn(Optional.of(note1));

        // вызов метода
        noteService.findById(note1.getId());

        // проверка note1
        verify(noteRepository).findById(1L);





    }
}
