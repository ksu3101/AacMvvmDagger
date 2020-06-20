package domain.common.message

import androidx.annotation.StringRes
import com.swkang.ex.model.base.redux.Action

/**
 * @author kangsungwoo
 * @since 6/19/2020
 */
sealed class MessageAction : Action

object HandledMessageAction : MessageAction()

data class ShowToastMessageAction(
    @StringRes val messageResId: Int
) : MessageAction()