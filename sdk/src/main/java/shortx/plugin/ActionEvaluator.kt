package shortx.plugin

import android.content.Context
import androidx.annotation.Keep

@Keep
abstract class ActionEvaluator {
    fun invokeEvaluate(androidContext: Context, paramsData: ByteArray) {
        evaluate(androidContext, ParamsData.parseFrom(paramsData))
    }

    abstract fun evaluate(androidContext: Context, paramsData: ParamsData)
}