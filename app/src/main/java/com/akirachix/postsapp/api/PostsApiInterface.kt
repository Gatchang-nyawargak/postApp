package com.akirachix.postsapp.api
import com.akirachix.postsapp.model.Comments
import com.akirachix.postsapp.model.Posts
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PostsApiInterface {
    @GET("/posts")
    suspend fun fetchPosts(): Response<List<Posts>>

    @GET("/posts/{postId}")
    fun fetchPostsById(@Path("postId") postId:Int): Call<Posts>

    @GET("/posts/{postId}/comments")
    fun fetchCommentsByPostId(@Path("postId") postId: Int): Call<List<Comments>>
}
