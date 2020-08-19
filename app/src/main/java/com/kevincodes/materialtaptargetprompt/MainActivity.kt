package com.kevincodes.materialtaptargetprompt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt
import uk.co.samuelwall.materialtaptargetprompt.extras.backgrounds.RectanglePromptBackground
import uk.co.samuelwall.materialtaptargetprompt.extras.focals.RectanglePromptFocal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // This function's role is to show the prompt at launch
        showFabPrompt()
    }

    private fun showFabPrompt(){
        val prefManager = PreferenceManager.getDefaultSharedPreferences(this)
        // if it's the first time the app is launched, then show the prompt
        if(!prefManager.getBoolean("didShowPrompt",false)){
            // Setting up MaterialTapTargetPrompt to show the prompt
            MaterialTapTargetPrompt.Builder(this)
                .setTarget(fab).setPrimaryText("Click me")
                .setSecondaryText("I'm a floating action button aka FAB")
                .setBackButtonDismissEnabled(true)
                .setPromptStateChangeListener { _, state ->
                    if(state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED
                        || state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED){
                        val prefEditor = prefManager.edit()
                        prefEditor.putBoolean("didShowPrompt",true).apply()
                        showButtonPrompt()
                    }
                }.show()
        }
    }

    private fun showButtonPrompt(){
        MaterialTapTargetPrompt.Builder(this)
            .setTarget(button)
            .setPrimaryText("Press me!")
            .setSecondaryText("I'm a nice and simple button.")
            .setBackButtonDismissEnabled(true)
            .setPromptBackground(RectanglePromptBackground())
            .setPromptFocal(RectanglePromptFocal()).show()
    }
}