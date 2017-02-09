/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.android.mobly.snippet.bundled;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.media.AudioManager;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import com.google.android.mobly.snippet.Snippet;
import com.google.android.mobly.snippet.rpc.Rpc;
import com.google.android.mobly.snippet.util.Log;

public class AudioSnippet implements Snippet {

    private final AudioManager audioManager;

    public AudioSnippet() {
        Context context = InstrumentationRegistry.getContext();
        this.audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    }
  
    @Rpc(description = "Sets the media stream volume.")
    public void setMediaVolume(Integer value) {
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, value, 0);
    }

    @Rpc(description = "Sets the ringer volume.")
    public void setRingVolume(Integer value) {
        audioManager.setStreamVolume(AudioManager.STREAM_RING, value, 0);
    }

    @Rpc(description = "Puts the ringer volume at the lowest setting, but not set it DO NOT DISTURB.")
    public void muteRing() {
      setRingVolume(0);
  }

    @Rpc(description = "Mute media stream.")
    public void muteMedia() {
      setMediaVolume(0);
  }

    @Override
      public void shutdown() {}
}