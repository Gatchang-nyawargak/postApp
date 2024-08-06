package com.akirachix.postsapp.repository

import com.akirachix.postsapp.api.ApiClient
import com.akirachix.postsapp.api.PostsApiInterface
import com.akirachix.postsapp.model.Posts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostsRepository {
    val apiClient = ApiClient.buildApiClient(PostsApiInterface::class.java)

    suspend fun fetchPosts(): Response<List<Posts>>{
        return withContext(Dispatchers.IO){
            apiClient.fetchPosts()
        }
    }
}