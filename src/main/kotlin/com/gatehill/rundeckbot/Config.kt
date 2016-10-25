package com.gatehill.rundeckbot

/**
 * @author Pete Cornish {@literal <outofcoffee@gmail.com>}
 */
class Config {
    class Chat {
        val authToken by lazy { System.getenv("SLACK_AUTH_TOKEN") ?: throw IllegalStateException("Slack auth token missing") }
        val channelName by lazy { System.getenv("SLACK_CHANNEL_NAME") ?: "rundeck-slackbot" }
    }
    class Deployment {
        val apiToken by lazy { System.getenv("RUNDECK_API_TOKEN") ?: throw IllegalStateException("Rundeck API token missing") }
        val baseUrl by lazy { System.getenv("RUNDECK_BASE_URL") ?: "http://localhost:4440" }
    }

    val chat = Chat()
    val deployment = Deployment()
    val configDir by lazy { System.getenv("CONFIG_DIR") ?: "/opt/rundeck-slackbot/config" }
}