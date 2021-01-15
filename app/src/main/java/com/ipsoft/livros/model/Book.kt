package com.ipsoft.livros.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import org.parceler.Parcel
import com.ipsoft.livros.BR
import org.parceler.Transient

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Livros
 *  Date:       11/01/2021
 */

@Parcel
 class Book() : Observable {

    @Bindable
    var id : String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.id)
        }
    @Bindable
    var title: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }
    @Bindable
    var author: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.author)
        }
    @Bindable
    var coverUrl: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.coverUrl)
        }
    @Bindable
    var pages : Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.pages)
        }
    @Bindable
    var year : Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.year)
        }
    @Bindable
    var publisher: Publisher? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.publisher)
        }
    @Bindable
    var available: Boolean = false
    set(value) {
        field = value
        notifyPropertyChanged(BR.available)
    }
    @Bindable
    var mediaType: MediaType = MediaType.PAPER
        set(value) {
            field = value
            notifyPropertyChanged(BR.mediaType)
        }
    @Bindable
    var rating: Float = 0.0f
        set(value) {
            field = value
            notifyPropertyChanged(BR.rating)
        }
    var userId: String = ""

    @Transient private var callbacks: PropertyChangeRegistry? = null

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        synchronized(this) {
            if(callbacks == null) {
                callbacks = PropertyChangeRegistry()
            }
        }
        callbacks?.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        synchronized(this) {
            if(callbacks == null) {
                return
            }
        }
        callbacks?.remove(callback)
    }

    fun notifyChange() {
        synchronized(this) {
            if(callbacks == null) {
                return
            }
        }
        callbacks?.notifyCallbacks(this,0,null)


    }
    fun notifyPropertyChanged(fieldId: Int) {
        synchronized(this) {
            if(callbacks == null) {
                return
            }
        }
        callbacks?.notifyCallbacks(this,fieldId,null)
    }
}