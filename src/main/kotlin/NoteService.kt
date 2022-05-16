class NoteService<T> {

    private val notesList = mutableListOf<Note>()
    private val commentList = mutableListOf<Note.Comment>()
    private var nextID = 1

    fun addNote(note: Note): Note {
        val newNote = note.copy(noteID = nextID++)
        notesList.add(newNote)
        return notesList.last()
    }

    fun deleteNote(id: Int): Boolean {
        var change = false
        for ((index, value) in notesList.withIndex()) {
            if (id == value.noteID && value.isDeleted == false) {
                notesList[index] = value.copy(isDeleted = true)
                if (commentList.isNotEmpty()) {
                    val commentIsDelete = commentList.get(index)
                    commentList[index] = commentIsDelete.copy(isDeleted = true)
                }
                change = true
                break
            }
        }
        return change
    }

    fun editNote(note: Note): Boolean {
        var change = false
        for ((index, value) in notesList.withIndex()) {
            if (note.noteID == value.noteID && value.isDeleted == false) {
                notesList[index] = value.copy(
                    title = note.title,
                    text = note.text
                )
                change = true
                break
            }
        }
        return change
    }

    fun getByID(id: Int): Note {
        val listByID = mutableListOf<Note>()
        for (note in notesList) {
            if (id == note.noteID && note.isDeleted == false)
                listByID.add(note)
        }
        return if (listByID.isNotEmpty()) listByID.last() else throw CommentExeption("По данному ID записей не найдено")
    }

    fun createComment(comment: Note.Comment) {
        for ((index, value) in notesList.withIndex()) {
            if (value.noteID != comment.commentID && (index < notesList.size - 1)) {
                continue
            } else if (value.noteID == comment.commentID && value.isDeleted == false) {
                commentList.add(comment)
                break
            }
            throw CommentExeption("Этот комментарий к отсутствующей заметке")
        }

    }

    fun deleteComment(id: Int): Boolean {
        var change = false
        for ((index, value) in commentList.withIndex()) {
            when {
                id != value.commentID && (index < commentList.size - 1) -> continue
                id == value.commentID && value.isDeleted == false -> {
                    commentList[index] = value.copy(isDeleted = true)
                    change = true
                    break
                }
                else -> throw CommentExeption("Этот комментарий уже удален, удаление невозможно")
            }
        }
        return change
    }

    fun editComment(comment: Note.Comment): Boolean {
        var change = false
        for ((index, value) in commentList.withIndex()) {
            when {
                comment.commentID != value.commentID && (index < commentList.size - 1) -> continue
                comment.commentID == value.commentID && value.isDeleted == false -> {
                    commentList[index] = value.copy(message = comment.message)
                    change = true
                    break
                }
                else -> throw CommentExeption("Этот комментарий уже удален,редактирование невозможно")
            }
        }
        return change
    }

    fun getComments(id: Int): List<Note.Comment> {
        val listByID = mutableListOf<Note.Comment>()
        for (comment in commentList) {
            if (id == comment.commentID && comment.isDeleted == false)
                listByID.add(comment)
        }
        return if (listByID.isNotEmpty()) listByID else throw CommentExeption("По данному ID комментариев не найдено")
    }

    fun restoreComment(id: Int): Boolean {
        var change = false
        for ((index, value) in commentList.withIndex()) {
            when {
                id != value.commentID && (index < commentList.size - 1) -> continue
                id == value.commentID && value.isDeleted == true -> {
                    commentList[index] = value.copy(isDeleted = false)
                    change = true
                    break
                }
                else -> throw CommentExeption("Невозможно восстановить неудаленный комментарий")
            }
        }
        return change
    }
}

