package com.ipsoft.livros.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ipsoft.livros.R
import com.ipsoft.livros.databinding.ActivityBookDetailsBinding
import com.ipsoft.livros.model.Book
import com.ipsoft.livros.ui.viewmodels.BookDetailsViewModel
import org.parceler.Parcels

class BookDetailsActivity : BaseActivity() {

    private val viewModel: BookDetailsViewModel by lazy {
        ViewModelProviders.of(this).get(BookDetailsViewModel::class.java)
    }

    private val binding: ActivityBookDetailsBinding by lazy {
        DataBindingUtil.setContentView<ActivityBookDetailsBinding>(
            this, R.layout.activity_book_details
        )
    }

    override fun init() {
       binding.book?.let { book ->
           viewModel.getBook(book.id).observe(this, Observer {
               binding.book = it
           })
       }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.book_details, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item?.itemId == R.id.menu_edit_book) {
            binding.book?.let {
                BookFormActivity.start(this, it)
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        val book = Parcels.unwrap<Book>(intent.getParcelableExtra(EXTRA_BOOK))
        if (book != null) {
            binding.book = book
        }
    }

    companion object {
        private const val EXTRA_BOOK = "book"

        fun start(context: Context, book: Book) {
            context.startActivity(
                Intent(context, BookDetailsActivity::class.java).apply {
                    putExtra(EXTRA_BOOK, Parcels.wrap(book))
                }
            )
        }
    }
}