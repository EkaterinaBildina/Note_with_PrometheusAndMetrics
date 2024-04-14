package factory;

import com.example.example_dz_rest.domain.Note;
import com.example.example_dz_rest.domain.NoteB;

public class NoteBFactory implements NoteFactory{
    @Override
    public Note createNote(Note note) {
        return new NoteB();
    }
}
