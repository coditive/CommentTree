class CommentPropertyModifier {

    fun modifyCommentVisibility(comment: Comment, commentId: String): Comment? {
        return when {
            comment.id == commentId -> modifyVisibility(comment)!!
            comment.id != commentId -> {
                val mutableReplyList = comment.replies.toMutableList()
                for (reply in comment.replies) {
                    val modifiedReply = modifyCommentVisibility(reply, commentId)
                    if (modifiedReply != null) {
                        mutableReplyList.remove(reply)
                        mutableReplyList.add(modifiedReply)
                    }
                }
                comment.copy(replies = mutableReplyList)
            }
            else -> null
        }
    }


    private fun modifyVisibility(comment: Comment?): Comment? {
        if(comment != null) {
            val replyList = mutableListOf<Comment>()
            for (reply in comment.replies) {
                val modifiedReply = modifyVisibility(reply)
                if (modifiedReply != null) {
                    replyList.add(modifiedReply.copy(isVisibleInTree = true))
                }
            }
            return comment.copy(isVisibleInTree = true, replies = replyList)
        }
        return null
    }
}