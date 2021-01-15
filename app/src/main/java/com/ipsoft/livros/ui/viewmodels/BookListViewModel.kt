package com.ipsoft.livros.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ipsoft.livros.firebase.FbRepository
import com.ipsoft.livros.model.Book

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Livros
 *  Date:       15/01/2021
 */

class BookListViewModel : ViewModel() {
    private val repo = FbRepository()
    private var booksList : LiveData<List<Book>>? = null

    fun getBooks() : LiveData<List<Book>> {
        var list = booksList
        if(list == null) {
            list = repo.loadBooks()
            booksList = list
        }
        return list
    }
    fun remove(book : Book) =repo.remove(book)
}