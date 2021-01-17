fun main() {
    val commentPropertyModifier = CommentPropertyModifier()
    val comment = Comment("root", false, "This is Root", emptyList())
    val modifiedComment = commentPropertyModifier.modifyCommentVisibility(comment, "root")
    print(modifiedComment)

    val commentTree = buildSampleCommentTree1levelDeep()
    val modifiedCommentTree = commentPropertyModifier.modifyCommentVisibility(commentTree, "Comment No. 3")
    println(modifiedCommentTree)

    val level2commentTree = buildSampleCommentTree2levelDeep()
    val modifiedlevel2commentTree = commentPropertyModifier.modifyCommentVisibility(level2commentTree, "Comment No. 5")
    println(modifiedlevel2commentTree)

    val modifiedlevel2commentTree2 = commentPropertyModifier.modifyCommentVisibility(level2commentTree, "Comment No. 1")
    println(modifiedlevel2commentTree2)
}

fun buildSampleCommentTree1levelDeep(): Comment {
    val mutableCommentList = mutableListOf<Comment>()
    for(i in 1..10) {
        mutableCommentList.add(Comment("Comment No. $i", false, "This is Comment $i", emptyList()))
    }

    return Comment("root", false, "This is Root",
        mutableCommentList.toList())
}

fun buildSampleCommentTree2levelDeep(): Comment {

    val mutableCommentList3 = mutableListOf<Comment>()
    for(i in 7..9) {
        mutableCommentList3.add(Comment("Comment No. $i", false, "This is Comment $i", emptyList()))
    }

    val mutableCommentList2 = mutableListOf<Comment>()
    for(i in 4..6) {
        mutableCommentList2.add(Comment("Comment No. $i", false, "This is Comment $i", emptyList()))
    }

    val mutableCommentList1 = mutableListOf<Comment>()
    for(i in 1..3) {
        mutableCommentList1.add(Comment("Comment No. $i", false, "This is Comment $i", emptyList()))
    }

    mutableCommentList1[0] = mutableCommentList1[0].copy(replies = mutableCommentList2)
    mutableCommentList1[1] = mutableCommentList1[1].copy(replies = mutableCommentList3)

    return Comment("root", false, "This is Root",
        mutableCommentList1.toList())

}



