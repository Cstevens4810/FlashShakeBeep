package com.example.cteve.beepflashshake

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.cteve.flashshakebeep.R
import kotlinx.android.synthetic.main.activity_main.*
import android.hardware.camera2.CameraManager
import android.media.AudioManager
import android.media.ToneGenerator
import android.os.VibrationEffect.DEFAULT_AMPLITUDE
import android.os.VibrationEffect.createOneShot
import android.os.Vibrator
import java.lang.reflect.Array



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickFlash(view:View)
    {
        val camM: CameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager

        val cameras: kotlin.Array<String> = camM.cameraIdList
        camM.setTorchMode(cameras[0],true)
    }

    fun onClickBeep(view:View)
    {
        val tone = ToneGenerator(AudioManager.STREAM_MUSIC, 100)
        tone.startTone(ToneGenerator.TONE_DTMF_3,600) //play specific tone for 600ms
    }

    fun onClickShake(view:View)
    {
        val vibrator: Vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(createOneShot(600, DEFAULT_AMPLITUDE))
    }
}
