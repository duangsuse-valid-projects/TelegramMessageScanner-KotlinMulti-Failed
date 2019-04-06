package org.duangsuse.messagescanner.model

import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic

/**
 * Simple date format in Java/JavaScript
 *
 * + year _(since 1900)_/month(0-11)/date(1-31)
 * + hours(0-23)/minutes(0-59)/seconds(0-59)
 * + unix time
 */
expect class Date: Comparable<Date> {
    var year: Int
    var month: Int
    var date: Int
    var hours: Int
    var minutes: Int
    var seconds: Int

    /**
     * Get/set by unix time milliseconds
     */
    var unixTime: Long

    /**
     * Get current system date
     */
    constructor()

    /**
     * Construct with a unix time [unixTime]
     *
     * @param unixTime milliseconds since January 1, 1970, 00:00:00 GMT
     * @see currentTimeMillis
     */
    constructor(unixTime: Long)

    /**
     * Construct with [year], [month] and [date], in the local timezone
     *
     * @see Date full constructor
     */
    constructor(year: Int, month: Int, date: Int)

    /**
     * Construct from target [year], [month], [date] and [hours][hrs]:[minutes][min], in the local timezone
     *
     * @see Date full constructor
     */
    constructor(year: Int, month: Int, date: Int, hrs: Int, min: Int)

    /**
     * Construct with year, month, date, hours, minutes and seconds, in the local timezone
     *
     * @param   year    the year minus 1900.
     * @param   month   the month between 0-11.
     * @param   date    the day of the month between 1-31.
     * @param   hrs     the hours between 0-23.
     * @param   min     the minutes between 0-59.
     * @param   sec     the seconds between 0-59.
     */
    constructor(year: Int, month: Int, date: Int, hrs: Int, min: Int, sec: Int)

    /**
     * Duplicate this date, copying all its field
     *
     * @return cloned object
     */
    fun clone(): Any

    /**
     * Compare two dates for ordering
     *
     * @param other date to be compared.
     * @return int result value
     * + less than 0 if this < other
     * + greater than 0 if this > other
     * + equal to 0 if this == other
     * @throws NullPointerException if other object is null
     */
    override fun compareTo(other: Date): Int

    override fun equals(other: Any?): Boolean

    /**
     * `EEE MMM dd HH:mm:ss zzz yyyy` representation of date
     *
     * @return string representation of this date
     */
    override fun toString(): String

    /**
     * Time clock operation helper
     */
    companion object Clock {
        /**
         * Get current system unix time
         *
         * @return count milliseconds since January 1, 1970, 00:00:00 GMT
         */
        @JvmStatic
        fun currentTimeMillis(): Long

        /**
         * Get unix time of a `Date` object
         *
         * @return unix time
         */
        @JvmStatic
        fun getMillisOf(d: Date): Long

        /**
         * Parse simple date format using platform default date string parser
         *
         * @param str a valid date string in to be parsed using default mechanism in Java/JavaScript
         * @return got date
         * @throws IllegalArgumentException cannot parse the string representation
         */
        @JvmStatic
        fun parseDate(str: String): Date
    }
}
