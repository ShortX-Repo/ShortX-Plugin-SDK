package shortx.pluginsdk.demo.evaluator

import android.content.Context
import android.widget.Toast
import androidx.annotation.Keep
import shortx.plugin.ActionEvaluator
import shortx.plugin.ParamsData

@Keep
class DemoActionEvaluator : ActionEvaluator() {
    override fun evaluate(androidContext: Context, paramsData: ParamsData) {
        with(paramsData) {
            Toast.makeText(
                androidContext,
                "Hello, ${getStringDataOrDefault("input", "N/A")}",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}