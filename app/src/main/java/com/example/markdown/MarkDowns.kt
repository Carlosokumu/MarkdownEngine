package com.example.markdown

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id


@Entity
data class MarkDowns(
        @Id
        var id: Long = 0,
        var content: String? = null
    )
