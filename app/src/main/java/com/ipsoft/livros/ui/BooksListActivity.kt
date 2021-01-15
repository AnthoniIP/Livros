package com.ipsoft.livros.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ipsoft.livros.R
import com.ipsoft.livros.adapters.BookAdapter
import com.ipsoft.livros.model.Book
import com.ipsoft.livros.model.MediaType
import com.ipsoft.livros.model.Publisher
import kotlinx.android.synthetic.main.activity_book_list.*

class BooksListActivity : BaseActivity() {
    override fun init() {
        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        val books = listOf(
        Book().apply {
            id = "1"
            title = "Dominando android com kotlin"
            author = "Nelson Glauber"
            coverUrl = "https://s3.novatec.com.br/capas-ampliadas/capa-ampliada-9788575227268.jpg"
            pages = 954
            year = 2018
            publisher = Publisher("1","Novatec")
            available = true
            mediaType = MediaType.EBOOK
            rating = 5.0f

        })
        rvBooks.layoutManager = LinearLayoutManager(this)
        rvBooks.adapter = BookAdapter(books) {book ->
            BookDetailsActivity.start(this,book)
        }
    }
}