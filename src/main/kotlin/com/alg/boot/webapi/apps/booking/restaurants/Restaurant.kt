package com.alg.boot.webapi.apps.booking.restaurants

import com.alg.boot.webapi.apps.booking.boards.Board
import com.alg.boot.webapi.apps.booking.reservations.Reservation
import com.alg.boot.webapi.apps.booking.turns.Turn
import com.alg.boot.webapi.apps.shared.AuditableEntity
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(name = "RESTAURANTS")
class Restaurant(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    var id: Long? = null,

    @Column(name = "NAME")
    var name: String? = null,

    @Column(name = "ADDRESS")
    var address: String? = null,

    @Column(name = "DESCRIPTION")
    var description: String? = null,

    @Column(name = "IMAGE")
    var image: String? = null,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "RESTAURANT_ID")
    var reservations: MutableList<Reservation>? = null,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "RESTAURANT_ID")
    var boards: MutableList<Board>? = null,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "RESTAURANT_ID")
    var turns: MutableList<Turn>? = null,
): AuditableEntity<String>()
