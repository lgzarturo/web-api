package com.alg.boot.webapi.apps.miraeljuego.consoles

import com.alg.boot.webapi.apps.content.galleries.Photo
import com.alg.boot.webapi.apps.shared.AuditableEntity
import org.hibernate.validator.constraints.Range
import org.hibernate.validator.constraints.URL
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.PastOrPresent
import javax.validation.constraints.Positive

@Entity
@Table(name = "CONSOLES")
class Console(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    var id: Long? = null,

    @Column(name = "NAME", unique = true, nullable = false, length = 64)
    @NotBlank
    var name: String? = null,

    @Column(name = "RELEASE_DATE")
    @PastOrPresent
    var releaseDate: LocalDate? = null,

    @Column(name = "DEVELOPER", length = 64)
    var developer: String? = null,

    @Column(name = "LOGO")
    @URL
    var logo: String? = null,

    @Column(name = "DESCRIPTION", length = 600, columnDefinition = "TEXT")
    var description: String? = null,

    @Column(name = "PRICE")
    @Positive
    var price: Double? = null,

    @Column(name = "RATING")
    @Positive
    @Range(min = 0, max = 5)
    var rating: Int = 0,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "console")
    var photos: MutableList<Photo>? = null,
): AuditableEntity<String>()
