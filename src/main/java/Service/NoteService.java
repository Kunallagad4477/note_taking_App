package Service;

import java.util.List;

import Model.NoteModel;

public interface NoteService {
     public boolean isAddNote(NoteModel nModel);
     public List getAllNotes(int uid);
     public boolean updateNote(NoteModel nModel);
     public boolean isDeleteNote(int nid);
     public List getAllNotesByCategory(int cid,int uid);
}
