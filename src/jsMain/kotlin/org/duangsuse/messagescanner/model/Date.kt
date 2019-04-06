package org.duangsuse.messagescanner.model

typealias JsDate = kotlin.js.Date

actual class Date(val jsDate: JsDate): Comparable<Date> {

}