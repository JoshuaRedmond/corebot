package com.gatehill.corebot.chat

/**
 * The regular expression to split messages into parts.
 */
private val messagePartRegex = "\"?( |$)(?=(([^\"]*\"){2})*[^\"]*$)\"?".toRegex()

fun splitMessageParts(message: String) = message.trim().split(messagePartRegex).filterNot(String::isBlank)
