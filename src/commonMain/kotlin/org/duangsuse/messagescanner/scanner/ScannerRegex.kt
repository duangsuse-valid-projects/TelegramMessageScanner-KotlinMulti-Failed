package org.duangsuse.messagescanner.scanner

/**
 * Regular expressions used by Telegram Message Scanner
 *
 * @see ScannerRegex.Literate textual regular expression
 */
object ScannerRegex {
    /**
     * New message header definition
     * in form `(name), [dd.mm.yy hh:mm]`
     *
     * + `duangsuse::Echo, [24.03.19 11:22]`
     */
    val NEW_MESSAGE = Regex(Literate.PAT_NEW_MESSAGE)

    /**
     * Reply-to message header definition
     *
     * + `[In reply to duangsuse::Echo]`
     */
    val REPLY_TO = Regex(Literate.PAT_REPLY_TO)

    /**
     * Forwarded from _(display name)_
     *
     * + `[Forwarded from 羽毛的小白板]`
     */
    val FORWARD_FROM = Regex(Literate.PAT_FORWARD_FROM)

    /**
     * This message contains a photo collection
     */
    val ALBUM = Regex(Literate.PAT_ALBUM)
    /**
     * This message contains a photo
     */
    val PHOTO = Regex(Literate.PAT_PHOTO)

    /**
     * Sticker picture of character _(.)_
     *
     * + `[ 😋 Sticker ]`
     */
    val STICKER = Regex(Literate.PAT_STICKER)

    /**
     * An uploaded telegram file _(.)_
     *
     * + `[ File : AndroidManifest.xml ]`
     */
    val FILE = Regex(Literate.PAT_FILE)

    /**
     * Bare text links, a newline starting with http|https
     *
     * + `https://github.com/aosp-mirror/platform_frameworks_base/blob/pie-release/tools/aapt2`
     * + `http://localhost:8080`
     */
    val LINK_BARE = Regex(Literate.PAT_BARE_LINK)

    /**
     * Telegram anchor tags
     *
     * Form: _text_ _(url)_
     *
     * + `系统服务 (https://blog.yuuta.moe/2017/11/10/from-vibrator-to-system-service/)`
     */
    val LINK_PAREN = Regex(Literate.PAT_PAREN_LINK)

    /**
     * User inline text URL links
     *
     * + `See: https://github.com/duangsuse/RandomPicture/commit/440b8a1c7d2251b0074c1571c0d07c613628fc54 <3`
     */
    val LINK_INLINE = Regex(Literate.PAT_INLINE_BARE_LINK)

    /**
     * Telegram topic Hash-tags
     *
     * + `Telegram #hashtag`
     * + `#Topic_misc a new topic`
     * + `#offtopic`
     * + `#java 11 released!`
     */
    val HASHTAG = Regex(Literate.PAT_HASHTAG)


    /**
     * Boring regex code strings
     */
    object Literate {
        const val PAT_NEW_MESSAGE = "^(.+), \\[(\\d{2})\\.(\\d{2})\\.(\\d{2}) (\\d{2}):(\\d{2})\\]\$"
        const val PAT_REPLY_TO = "^\\[In reply to (.+)\\]\$"
        const val PAT_FORWARD_FROM = "^\\[Forwarded from (.+)\\]\$"

        const val PAT_ALBUM = "^\\[ Photo \\]\$"
        const val PAT_PHOTO = "^\\[ Album \\]\$"

        const val PAT_STICKER = "^\\[ (.) Sticker \\]\$"
        const val PAT_FILE = "^\\[ File : (.*) \\]\$"

        const val PAT_BARE_LINK = "^(http|https):(\\S+)"
        const val PAT_PAREN_LINK = "\\((\\w+)://(\\S*)\\)"
        const val PAT_INLINE_BARE_LINK = "(?![\\(\\)]).((http|https):(\\S+))"

        const val PAT_HASHTAG = "(^|\\s)#(?!#)((\\S(?<![\\(\\)]))+)"
    }
}
