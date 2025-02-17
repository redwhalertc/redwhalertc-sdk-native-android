package io.rwrtc.android.sample

import android.app.Application
import io.rwrtc.android.Rwrtc
import io.rwrtc.android.util.LoggingLevel

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Rwrtc.loggingLevel = LoggingLevel.VERBOSE
    }
}
