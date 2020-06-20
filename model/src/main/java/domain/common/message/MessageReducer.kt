package domain.common.message

import com.swkang.ex.model.base.redux.Action
import com.swkang.ex.model.base.redux.Reducer

/**
 * @author kangsungwoo
 * @since 6/19/2020
 */
class MessageReducer : Reducer<MessageState> {
    override val initializeState: MessageState = HandledMessageState

    override fun reduce(oldState: MessageState, resultAction: Action): MessageState {
        return when (resultAction) {
            is ShowToastMessageAction -> ShowToastMessageState(resultAction.messageResId)

            else -> oldState
        }
    }

}