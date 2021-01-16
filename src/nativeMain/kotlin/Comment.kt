data class Comment(
    val id: String,
    val isVisibleInTree:  Boolean = true,
    val comment: String,
    val replies: List<Comment>,
)