package domain.common.message

import androidx.annotation.StringRes
import com.swkang.ex.model.base.redux.State

/**
 * @author kangsungwoo
 * @since 6/19/2020
 */
sealed class MessageState : State

object HandledMessageState : MessageState()

data class ShowToastMessageState(
    @StringRes val messageResId: Int
) : MessageState()