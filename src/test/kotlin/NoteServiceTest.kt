import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    @Test
    fun deleteNote_notDeleteIDNotEquals() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = false)
        val note2 = Note(noteID = 3, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        service.addNote(note2)
        val result = service.deleteNote(5)
        assertFalse(result)
    }

    @Test
    fun deleteNote_notDeleteIsDeletedTrue() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = true)
        val note2 = Note(noteID = 3, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        service.addNote(note2)
        val result = service.deleteNote(1)
        assertFalse(result)
    }

    @Test
    fun deleteNote_itIsOK() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = false)
        val note2 = Note(noteID = 3, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        service.addNote(note2)
        val comment1 = Note.Comment(commentID = 1, message = "", isDeleted = false)
        val comment2 = Note.Comment(commentID = 1, message = "", isDeleted = false)
        service.createComment(comment1)
        service.createComment(comment2)
        val result = service.deleteNote(2)
        assertTrue(result)
    }
    @Test
    fun editNote_notEditIDNotEquals() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = false)
        val note2 = Note(noteID = 3, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        service.addNote(note2)
        val control = Note(noteID = 9, title = "", text = "", isDeleted = false)
        val result = service.editNote(control)
        assertFalse(result)
    }

    @Test
    fun editNote_notEditIsDeletedTrue() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = true)
        val note2 = Note(noteID = 3, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        service.addNote(note2)
        val control = Note(noteID = 1, title = "", text = "", isDeleted = false)
        val result = service.editNote(control)
        assertFalse(result)
    }

    @Test
    fun editNote_itIsOK() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = false)
        val note2 = Note(noteID = 3, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        service.addNote(note2)
        val control = Note(noteID = 1, title = "a", text = "b", isDeleted = false)
        val result = service.editNote(control)
        assertTrue(result)
    }

    @Test(expected = CommentExeption::class)
    fun getByID_notListIDNotEquals() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = false)
        val note2 = Note(noteID = 3, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        service.addNote(note2)
        service.getByID(4)
    }

    @Test(expected = CommentExeption::class)
    fun getByID_notListIsDeletedTrue() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = true)
        val note2 = Note(noteID = 3, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        service.addNote(note2)
        service.getByID(1)
    }

    @Test
    fun getByID_itIsOK() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = false)
        val note2 = Note(noteID = 3, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        service.addNote(note2)
        service.getByID(1)
    }

    @Test(expected = CommentExeption::class)
    fun createComment_notCreateIDNotEquals() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = false)
        val note2 = Note(noteID = 3, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        service.addNote(note2)
        val control = Note.Comment(commentID = 9, message = "", isDeleted = false)
        service.createComment(control)
    }

    @Test(expected = CommentExeption::class)
    fun createComment_notCreateIsDeletedTrue() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = true)
        val note2 = Note(noteID = 3, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        service.addNote(note2)
        val control = Note.Comment(commentID = 1, message = "", isDeleted = false)
        service.createComment(control)
    }

    @Test
    fun createComment_itIsOK() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = false)
        val note2 = Note(noteID = 3, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        service.addNote(note2)
        val control = Note.Comment(commentID = 1, message = "", isDeleted = false)
        service.createComment(control)
    }

    @Test(expected = CommentExeption::class)
    fun deleteComment_notDeleteIDNotEquals() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = false)
        val note2 = Note(noteID = 3, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        service.addNote(note2)
        val comment1 = Note.Comment(commentID = 1, message = "", isDeleted = false)
        val comment2 = Note.Comment(commentID = 1, message = "", isDeleted = false)
        service.createComment(comment1)
        service.createComment(comment2)
        service.deleteComment(5)
    }

    @Test(expected = CommentExeption::class)
    fun deleteComment_notDeleteIsDeletedTrue() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = false)
        val note2 = Note(noteID = 3, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        service.addNote(note2)
        val comment1 = Note.Comment(commentID = 1, message = "", isDeleted = false)
        val comment2 = Note.Comment(commentID = 2, message = "", isDeleted = true)
        service.createComment(comment1)
        service.createComment(comment2)
        service.deleteComment(2)
    }

    @Test
    fun deleteComment_itIsOK() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = false)
        val note2 = Note(noteID = 3, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        service.addNote(note2)
        val comment1 = Note.Comment(commentID = 1, message = "", isDeleted = false)
        val comment2 = Note.Comment(commentID = 1, message = "c", isDeleted = false)
        service.createComment(comment1)
        service.createComment(comment2)
        service.deleteComment(1)
    }

    @Test(expected = CommentExeption::class)
    fun editComment_notEditIDNotEquals() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = false)
        val note2 = Note(noteID = 3, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        service.addNote(note2)
        val comment1 = Note.Comment(commentID = 1, message = "", isDeleted = false)
        val comment2 = Note.Comment(commentID = 1, message = "", isDeleted = false)
        service.createComment(comment1)
        service.createComment(comment2)
        val control = Note.Comment(commentID = 49, message = "c", isDeleted = false)
        service.editComment(control)
    }

    @Test(expected = CommentExeption::class)
    fun editComment_notEditIsDeletedTrue() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = false)
        val note2 = Note(noteID = 3, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        service.addNote(note2)
        val comment1 = Note.Comment(commentID = 1, message = "", isDeleted = true)
        val comment2 = Note.Comment(commentID = 1, message = "", isDeleted = false)
        service.createComment(comment1)
        service.createComment(comment2)
        val control = Note.Comment(commentID = 1, message = "c", isDeleted = false)
        service.editComment(control)
    }

    @Test
    fun editComment_itIsOK() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = false)
        val note2 = Note(noteID = 3, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        service.addNote(note2)
        val comment1 = Note.Comment(commentID = 1, message = "", isDeleted = false)
        val comment2 = Note.Comment(commentID = 1, message = "", isDeleted = false)
        service.createComment(comment1)
        service.createComment(comment2)
        val control = Note.Comment(commentID = 1, message = "", isDeleted = false)
        service.editComment(control)
    }

    @Test(expected = CommentExeption::class)
    fun getComments_notGetIDNotEquals() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        val comment1 = Note.Comment(commentID = 1, message = "", isDeleted = false)
        val comment2 = Note.Comment(commentID = 1, message = "", isDeleted = false)
        service.createComment(comment1)
        service.createComment(comment2)
        service.getComments(5)
    }

    @Test(expected = CommentExeption::class)
    fun getComments_notGetIsDeletedTrue() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        val comment1 = Note.Comment(commentID = 1, message = "", isDeleted = true)
        val comment2 = Note.Comment(commentID = 1, message = "", isDeleted = true)
        service.createComment(comment1)
        service.createComment(comment2)
        service.getComments(1)
    }

    @Test
    fun getComments_itIsOK() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        val comment1 = Note.Comment(commentID = 1, message = "", isDeleted = false)
        val comment2 = Note.Comment(commentID = 1, message = "c", isDeleted = false)
        service.createComment(comment1)
        service.createComment(comment2)
        service.getComments(1)
    }

    @Test(expected = CommentExeption::class)
    fun restoreComment_notRestoreIDNotEquals() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = false)
        val note2 = Note(noteID = 3, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        service.addNote(note2)
        val comment1 = Note.Comment(commentID = 1, message = "", isDeleted = false)
        val comment2 = Note.Comment(commentID = 1, message = "", isDeleted = false)
        service.createComment(comment1)
        service.createComment(comment2)
        service.deleteComment(1)
        service.restoreComment(7)
    }

    @Test(expected = CommentExeption::class)
    fun restoreComment_notRestoreIsDeletedTrue() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = false)
        val note2 = Note(noteID = 3, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        service.addNote(note2)
        val comment1 = Note.Comment(commentID = 1, message = "", isDeleted = false)
        val comment2 = Note.Comment(commentID = 1, message = "", isDeleted = false)
        service.createComment(comment1)
        service.createComment(comment2)
        service.restoreComment(1)
    }

    @Test
    fun restoreComment_itIsOK() {
        val service = NoteService<Note>()
        val note1 = Note(noteID = 1, title = "", text = "", isDeleted = false)
        val note2 = Note(noteID = 3, title = "", text = "", isDeleted = false)
        service.addNote(note1)
        service.addNote(note2)
        val comment1 = Note.Comment(commentID = 1, message = "", isDeleted = false)
        val comment2 = Note.Comment(commentID = 1, message = "", isDeleted = false)
        service.createComment(comment1)
        service.createComment(comment2)
        service.deleteComment(1)
        service.restoreComment(1)
    }

}

