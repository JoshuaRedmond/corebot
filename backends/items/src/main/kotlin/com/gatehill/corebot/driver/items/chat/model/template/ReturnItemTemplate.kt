package com.gatehill.corebot.driver.items.chat.model.template

import com.gatehill.corebot.chat.model.action.ActionType
import com.gatehill.corebot.config.ConfigService
import com.gatehill.corebot.config.model.ActionConfig
import com.gatehill.corebot.driver.items.action.model.ItemsActionType
import java.util.*
import javax.inject.Inject

/**
 * Return a borrowed item.
 */
class ReturnItemTemplate @Inject constructor(configService: ConfigService) : BaseItemTemplate(configService) {
    override val actionType: ActionType = ItemsActionType.ITEM_RETURN
    override val tokens = LinkedList(listOf("return", "{$itemPlaceholder}"))
    override fun buildStartMessage(options: Map<String, String>, actionConfig: ActionConfig?) = ""
}