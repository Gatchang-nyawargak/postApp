package com.akirachix.postsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.akirachix.postsapp.databinding.ActivityCreateCommentBinding
import android.widget.Toast
import androidx.activity.viewModels
import  androidx.lifecycle.Observer
import android.view.View
import com.akirachix.postsapp.model.CommentRequest

import com.akirachix.postsapp.viewmodel.PostsViewModel


class CreateCommentActivity : AppCompatActivity() {
    private var postId = 0
    val postsViewModel: PostsViewModel by viewModels()
    private lateinit var binding: ActivityCreateCommentBinding

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityCreateCommentBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val extra = intent.extras
//        if (extra != null) {
//            postId = extra.getInt("POST_ID")
//            postsViewModel.fetchPosts()
//        }
//
//        binding.btnSubmitComment.setOnClickListener {
//            val commentText = binding.etComment.text.toString()
//            if (commentText.isNotEmpty()) {
//                postsViewModel.createComment(postId, commentText)
//            } else {
//                Toast.makeText(this, "Comment cannot be empty", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
override fun onResume() {
    super.onResume()

    // Set up click listener for submit comment button
    binding.btnSubmitComment.setOnClickListener {
        validateComment()
    }

    // Observe live data for comment creation status
    postsViewModel.commentCreatedLiveData.observe(this) { message ->
        binding.progressBar.visibility = View.GONE
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    // Observe live data for errors
    postsViewModel.errorLiveData.observe(this) { error ->
        binding.progressBar.visibility = View.GONE
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }
}

    fun validateComment() {
        // Get user input
        val comment = binding.etComment.text.toString()
        var error = false

        // Validate input
        if (comment.isBlank()) {
            binding.etComment.error = "Comment cannot be empty"
            error = true
        }

        // If no error, proceed with comment submission
//        if (!error) {
//            binding.progressBar.visibility = View.VISIBLE
//            val commentRequest = CommentRequest(text = toString())
//
//            // Ensure createComment method is correctly defined in your ViewModel
//            postsViewModel.createComment(commentRequest)
//                .(this) { result ->
//                    binding.progressBar.visibility = View.GONE
//                    if (result.isSuccess) {
//                        Toast.makeText(this, "Comment submitted successfully", Toast.LENGTH_SHORT).show()
//                        clearForm()
//                    } else {
//                        Toast.makeText(this, "Failed to submit comment", Toast.LENGTH_SHORT).show()
//                    }
//                }
//        }
//    }


    fun clearForm() {
        binding.etComment.text.clear()
    }

//    override fun onSupportNavigateUp(): Boolean {
//        finish()
//        return super.onSupportNavigateUp()
//    }





}}
