package Service;

import java.util.List;

import Model.NoteModel;
import Repository.NoteRepository;
import Repository.NoteRepositoryImpl;
public class NoteServiceImpl implements NoteService{
     NoteRepository nRepo=new NoteRepositoryImpl();
	@Override
	public boolean isAddNote(NoteModel nModel) {
		return nRepo.AddNote(nModel);
	}
	@Override
	public List getAllNotes(int uid) {
		return nRepo.getUsersAllNotes(uid);
	}
	@Override
	public boolean updateNote(NoteModel nModel) {
	return	nRepo.isUpdateNote(nModel);
	}
	@Override
	public boolean isDeleteNote(int nid) {
		return nRepo.DeleteNote(nid);
	}
	@Override
	public List getAllNotesByCategory(int cid, int uid) {
		return nRepo.getCategoryWiseNotes(cid,uid);
	}

}
