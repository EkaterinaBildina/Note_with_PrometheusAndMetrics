package com.example.example_dz_rest;

import com.example.example_dz_rest.domain.Note;
import com.example.example_dz_rest.repository.NoteRepository;
import com.example.example_dz_rest.service.NoteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



@SpringBootTest
@ExtendWith(MockitoExtension.class)
class IntExampleDzRestApplicationTests {
	@MockBean
	private NoteRepository noteRepository;

	@Autowired
	public NoteService noteService;

	@Test
	public void noteReview(){
		// предпосылки
		Note note1 = new Note();
		note1.setId(1L);
		note1.setTitle("Task01");
		note1.setContent("Need to provide money to children");

		//given(noteRepository.findById(note1.getId())).willReturn(Optional.of(note1));
		when(noteRepository.findById(note1.getId())).thenReturn(Optional.of(note1));

		// вызов метода
		noteService.findById(note1.getId());

		// проверка note1
		verify(noteRepository).findById(1L);

	}

}
