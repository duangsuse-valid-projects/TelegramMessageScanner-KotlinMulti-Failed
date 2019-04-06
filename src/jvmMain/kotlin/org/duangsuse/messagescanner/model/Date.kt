package org.duangsuse.messagescanner.model

import java.io.Serializable
import java.util.*

typealias JavaDate = java.util.Date

actual class Date(private val javaDate: JavaDate): Comparable<Date>, Cloneable by javaDate, Serializable by javaDate {
    // bad practice //
    actual var year: Int
        get() = javaDate.year
        set(value) {
            javaDate.year = value
        }
    actual var month: Int
        get() = javaDate.month
        set(value) {
            javaDate.month = value
        }
    actual var date: Int
        get() = javaDate.date
        set(value) {
            javaDate.date = value
        }
    actual var hours: Int
        get() = javaDate.hours
        set(value) {
            javaDate.hours = value
        }
    actual var minutes: Int
        get() = javaDate.minutes
        set(value) {
            javaDate.minutes = value
        }
    actual var seconds: Int
        get() = javaDate.seconds
        set(value) {
            javaDate.seconds = value
        }

    actual var unixTime: Long
        get() = javaDate.time
        set(value) {
            javaDate.time = value
        }

    actual constructor(): this(JavaDate())
    actual constructor(unixTime: Long): this(JavaDate(unixTime))

    actual constructor(year: Int, month: Int, date: Int): this(year, month, date, hrs = 0, min = 0)
    actual constructor(year: Int, month: Int, date: Int, hrs: Int, min: Int): this(year, month, date, hrs, min, sec = 0)
    actual constructor(year: Int, month: Int, date: Int, hrs: Int, min: Int, sec: Int): this(GregorianCalendar(year + 1900, month, date, hrs, min, sec).time)

    public actual override fun clone(): Any = Date(this.javaDate.time)
    actual override fun compareTo(other: Date): Int = javaDate.compareTo(other.javaDate)

    actual override fun equals(other: Any?): Boolean {
        other?.run {
            if (other !is Date) return false
            return javaDate == other.javaDate
        }
        return false
    }

    override fun hashCode(): Int {
        return javaDate.hashCode()
    }

    actual override fun toString(): String = javaDate.toString()

    actual companion object Clock {
        actual fun currentTimeMillis(): Long = System.currentTimeMillis()
        actual fun getMillisOf(d: Date): Long = d.javaDate.time
        actual fun parseDate(str: String): Date = Date(JavaDate.parse(str))
    }
}
