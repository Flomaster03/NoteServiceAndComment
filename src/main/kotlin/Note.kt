data class Note(
    val noteID: Int,
    val title: String,
    val text: String,
    val isDeleted: Boolean

) {
    data class Comment(
        val commentID: Int,
        val message: String,
        val isDeleted: Boolean

    )
}
