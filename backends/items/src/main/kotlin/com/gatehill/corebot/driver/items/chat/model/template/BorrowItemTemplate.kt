package com.gatehill.corebot.driver.items.chat.model.template

import com.gatehill.corebot.action.model.TriggerContext
import com.gatehill.corebot.chat.model.action.ActionType
import com.gatehill.corebot.config.ConfigService
import com.gatehill.corebot.config.model.ActionConfig
import com.gatehill.corebot.driver.items.action.model.ItemsActionType
import java.util.LinkedList
import java.util.regex.Pattern
import javax.inject.Inject

/**
 * Borrow an item.
 */
open class BorrowItemTemplate @Inject constructor(configService: ConfigService) : BaseItemTemplate(configService) {
    override val actionType: ActionType = ItemsActionType.ITEM_BORROW
    override val tokens = LinkedList(listOf("borrow", "{$itemPlaceholder}", "{$subItemPlaceholder}", "for", "{$reasonPlaceholder}"))
    override val templateRegex: Pattern?
        get() = "borrow\\s+(?<itemName>[a-zA-Z0-9]+)\\s*(?<optionalSubItemName>.*)\\s+for\\s+(?<reason>.+)".toPattern()

    override fun buildStartMessage(trigger: TriggerContext, options: Map<String, String>, actionConfig: ActionConfig?) = ""

    companion object {
        val subItemPlaceholder = "optionalSubItemName"
        val reasonPlaceholder = "reason"
    }
}
