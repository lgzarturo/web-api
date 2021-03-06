package com.alg.boot.webapi.apps.characters

import com.alg.boot.webapi.apps.shared.AuditableEntity
import com.arthurolg.enums.Format
import org.hibernate.validator.constraints.ISBN
import org.hibernate.validator.constraints.URL
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive
import javax.validation.constraints.PositiveOrZero

@Entity
@Table(name = "COMICS")
class Comic(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    var id: Long? = null,

    @Column(name = "TITLE", nullable = false, length = 160)
    @NotBlank
    var title: String,

    @Column(name = "COMIC_NUMBER")
    @NotBlank
    @PositiveOrZero
    var comicNumber: Int,

    @Column(name = "VARIANT_DESCRIPTION", length = 600, columnDefinition = "TEXT")
    var variantDescription: String? = null,

    @Column(name = "DESCRIPTION", length = 600, columnDefinition = "TEXT")
    var description: String? = null,

    @Column(name = "ISBN", nullable = false, length = 24)
    @NotBlank
    @ISBN
    var isbn: String,

    @Column(name = "COMIC_FORMAT")
    @Enumerated(EnumType.STRING)
    @NotBlank
    var format: Format = Format.COMIC,

    @Column(name = "PAGE_COUNT")
    @NotBlank
    @Positive
    var pageCount: Int,

    @Column(name = "THUMBNAIL_URL")
    @URL
    var thumbnail: String? = null,

    @Column(name = "PRICE")
    var price: String? = null,

    @ElementCollection
    @CollectionTable(name = "COMICS_PUBLISHERS", joinColumns = [JoinColumn(name = "COMIC_ID")])
    var publishers: List<String> = mutableListOf(),

    @Column(name = "IS_AVAILABLE")
    var isAvailable: Boolean? = null,

    @Column(name = "PUBLISHED")
    var published: Boolean = false,

    @ElementCollection
    @CollectionTable(name = "COMICS_LANGUAGES", joinColumns = [JoinColumn(name = "COMIC_ID")])
    var languages: List<String> = mutableListOf(),

    @OneToMany(mappedBy = "comics")
    var characters: MutableSet<Character>? = null
): AuditableEntity<String>()
