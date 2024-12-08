package com.blannon_network.otp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


 private const val VALID_OTP_CODE = "2433"
class OtpViewModel : ViewModel(){

    private val _state = MutableStateFlow(OtpState())
    val state = _state.asStateFlow()

    fun onAction(action: OtpAction){
        when(action){
            is OtpAction.OnChangeFieldFocused ->
                _state.update { it.copy(
                    isFocusedIndex = action.index
                ) }
            is OtpAction.OnEnterNumber -> {
                enterNumber( action.number, action.index)
            }
            OtpAction.OnkeyboardBack -> {
                val previousIndex = PreviousFocusedIndex(state.value.isFocusedIndex)
                _state.update { it.copy(
                    code = it.code.mapIndexed{index, number ->
                        if (index == previousIndex){
                            null
                        } else{
                            number
                        }
                    },
                    isFocusedIndex = previousIndex
                ) }
            }
        }
    }

    private fun enterNumber(number: Int?, index: Int){
        val newCode = state.value.code.mapIndexed { currentIndex, currentNumber ->
            if (currentIndex == index){
                number
            } else{
                currentNumber
            }
        }

        val isnumberRemoved = number == null
        _state.update { it.copy(
            code = newCode,
            isFocusedIndex = if (isnumberRemoved || it.code.getOrNull(index) != null){
                it.isFocusedIndex
            } else {
                getNextFocusedTxtFieldIndex(
                    currentCode = it.code,
                    currentFocusedIndex =  it.isFocusedIndex
                )
            },
            isvalid = if (newCode.none{ it == null}){
                newCode.joinToString { "" } == VALID_OTP_CODE
            } else null
        ) }
    }

    private fun PreviousFocusedIndex(currentIndex: Int?): Int?{
        return currentIndex?.minus(1)?.coerceAtLeast(0)
    }

    private fun getNextFocusedTxtFieldIndex(
        currentCode: List<Int?>,
        currentFocusedIndex: Int?
    ): Int? {
        if (currentFocusedIndex == null) {
            return null
        }
        if (currentFocusedIndex == 3){
            return currentFocusedIndex
        }

        return FirstEmptyFieldIndexAfterFocusedIndex(
            code = currentCode,
            currentFocusedIndex = currentFocusedIndex
        )
    }


    private fun FirstEmptyFieldIndexAfterFocusedIndex(
        code: List<Int?>,
        currentFocusedIndex: Int
    ): Int{
        code.forEachIndexed{index, number ->
            if (index <= currentFocusedIndex){
                return@forEachIndexed
            }

            if( number == null ){
                return index
            }
        }
        return  currentFocusedIndex
    }
}