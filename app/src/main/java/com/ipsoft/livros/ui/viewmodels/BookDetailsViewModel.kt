package com.ipsoft.livros.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.ipsoft.livros.firebase.FbRepository
import com.ipsoft.livros.model.Book

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Livros
 *  Date:       15/01/2021
 */

class BookDetailsViewModel : ViewModel() {

    private val repo = FbRepository()
    private val selectedBookId = MutableLiveData<String>()
    private var seletedBook = Transformations.switchMap(selectedBookId) { bookId ->
        repo.loadBook(bookId)

    }

    fun getBook(id: String): LiveData<Book> {
        selectedBookId.value = id
        return seletedBook

    }

}