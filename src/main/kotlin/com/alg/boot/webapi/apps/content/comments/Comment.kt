package com.alg.boot.webapi.apps.content.comments

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.PositiveOrZero

@Entity
@Table(name = "comments")
class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    var id: Long? = null,

    @Column(name = "SUBJECT", nullable = false, length = 160)
    @NotBlank
    var subject: String? = null,

    @Column(name = "CONTENT", nullable = false, length = 600)
    @NotBlank
    @Lob
    var content: String? = null,

    @Column(name = "IS_APPROVED")
    var isApproved: Boolean? = null,

    @Column(name = "NUMBER_OF_LIKES")
    @PositiveOrZero
    var likes: Int = 0,

    @Column(name = "AUTHOR_NAME")
    var author: String? = null,

    @Column(name = "AUTHOR_EMAIL")
    var email: String? = null,

    @Column(name = "AUTHOR_URL")
    var url: String? = null,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "COMMENT_ID", nullable = false)
    var parent: Comment? = null,

    @Column(name = "CREATED_AT")
    @CreatedDate
    var createdAt: Instant? = null,

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    var updatedAt: Instant? = null,
)