package Repository;

import java.util.List;

import Model.NoteModel;

public interface NoteRepository {
  public boolean AddNote(NoteModel nModel);
  public List getUsersAllNotes(int uid);
  public boolean isUpdateNote(NoteModel nModel);
  public boolean DeleteNote(int nid);
  public List getCategoryWiseNotes(int cid,int uid);
}
