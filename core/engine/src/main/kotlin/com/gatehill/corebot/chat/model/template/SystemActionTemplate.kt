package com.gatehill.corebot.chat.model.template

import com.gatehill.corebot.action.model.TriggerContext
import com.gatehill.corebot.chat.model.action.Action
import com.gatehill.corebot.chat.model.action.SystemAction
import com.gatehill.corebot.config.model.ActionConfig

/**
 * Represents a system action.
 */
abstract class SystemActionTemplate : BaseActionTemplate() {
    override val builtIn = true
    override val actionConfigs = emptyList<ActionConfig>()

    override fun buildActions(trigger: TriggerContext): List<Action> {
        return listOf(SystemAction(actionType,
                buildShortDescription(),
                if (actionMessageMode == ActionMessageMode.INDIVIDUAL) buildStartMessage(trigger) else null))
    }
}
