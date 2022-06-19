package com.salix.GraphSmartDevices.openhab

class Utils {


    companion object {
        @JvmStatic
        fun getItemName(topic: String): String {
            val topicElements = getTopicElements(topic)
            require(topicElements.size >= 4) { "Event creation failed, invalid topic: $topic" }
            return topicElements[2]
        }

        fun getTopicElements(topic: String): Array<String> {
            return topic.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        }
    }
}