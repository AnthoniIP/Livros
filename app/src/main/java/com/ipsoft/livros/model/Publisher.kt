package com.ipsoft.livros.model

import org.parceler.Parcel

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Livros
 *  Date:       11/01/2021
 */

@Parcel
data class Publisher(
    val id : String = "",
    val name: String = ""
) {
    override fun toString() = "$id - $name"
}