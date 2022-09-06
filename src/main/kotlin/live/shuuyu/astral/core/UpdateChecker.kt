package live.shuuyu.astral.core

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object UpdateChecker {
    fun checkUpdate() {
        CoroutineScope(Dispatchers.IO + CoroutineName("Astral-UpdateChecker")).launch {

        }
    }
}