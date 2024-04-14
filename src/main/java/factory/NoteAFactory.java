package factory;

import com.example.example_dz_rest.domain.Note;
import com.example.example_dz_rest.domain.NoteA;

public class NoteAFactory implements NoteFactory{
    @Override
    public Note createNote(Note note) {
        return new NoteA();
    }
}
