package com.alg.boot.webapi.apps.ats.jobs

import com.alg.boot.webapi.apps.ats.companies.Company
import com.alg.boot.webapi.apps.ats.companies.Location
import com.alg.boot.webapi.apps.shared.AuditableEntity
import com.arthurolg.enums.Currency
import com.arthurolg.enums.TypeJob
import com.arthurolg.utils.StringUtil
import org.hibernate.validator.constraints.Range
import org.hibernate.validator.constraints.URL
import java.time.LocalDate
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@Entity
@Table(name = "JOBS")
class Job(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    var id: UUID? = null,

    @Column(name = "TITLE", nullable = false, length = 160)
    @NotBlank
    var title: String? = null,

    @Column(name = "SLUG_URI", unique = true)
    var slug: String? = null,

    @Column(name = "DESCRIPTION", length = 600, columnDefinition = "TEXT")
    var description: String? = null,

    @Column(name = "TYPE_JOB", length = 64)
    @Enumerated(EnumType.STRING)
    var type: TypeJob = TypeJob.FULL_TIME,

    @Column(name = "IS_REMOTE")
    var isRemote: Boolean = false,

    @Column(name = "IS_PUBLISHED")
    var isPublised: Boolean = false,

    @Column(name = "IS_PUBLISHED_AT")
    var publishedAt: LocalDate? = null,

    @Column(name = "IS_CLOSED")
    var isClosed: Boolean = false,

    @Column(name = "HIRED_NUMBER")
    @Range(min = 1, max = 100)
    @Positive
    var hiredNumber: Int? = null,

    @OneToOne
    var location: Location? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_ID", nullable = false)
    var company: Company? = null,

    @Column(name = "URL")
    @URL
    var url: String? = null,

    @ElementCollection
    @CollectionTable(name = "JOBS_TAGS", joinColumns = [JoinColumn(name = "JOB_ID")])
    var tags: List<String> = emptyList(),

    @Column(name = "SALARY", length = 160)
    var salary: String? = null,

    @Column(name = "CURRENCY", length = 4)
    var currency: Currency = Currency.MXN,

    @ElementCollection
    @CollectionTable(name = "JOBS_SKILLS", joinColumns = [JoinColumn(name = "JOB_ID")])
    var skills: List<String> = emptyList(),

    @ElementCollection
    @CollectionTable(name = "JOBS_BENEFITS", joinColumns = [JoinColumn(name = "JOB_ID")])
    var benefits: List<String> = emptyList(),

    @Column(name = "RESPONSIBILITIES", length = 1000, columnDefinition = "TEXT")
    var responsibilities: String? = null,

    @Column(name = "COVER_URL")
    @URL
    var cover: String? = null,
): AuditableEntity<String>() {
    @PrePersist
    fun prePersistData() {
        this.slug = StringUtil.slugURI(this.title)
    }
}
