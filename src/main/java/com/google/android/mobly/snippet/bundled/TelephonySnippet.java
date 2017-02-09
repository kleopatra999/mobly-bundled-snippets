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
import android.telephony.TelephonyManager;
import com.google.android.mobly.snippet.Snippet;
import com.google.android.mobly.snippet.rpc.Rpc;

/** Snippet class exposing Android APIs in WifiManager. */
public class TelephonySnippet implements Snippet {

    private final TelephonyManager telephonyManager;

    public TelephonySnippet() {
        Context context = InstrumentationRegistry.getContext();
        this.telephonyManager = (TelephonyManager) context.getSystemService(
                Context.TELEPHONY_SERVICE);
    }

    @Rpc(description = "Gets the line 1 phone number.")
    public String getLine1Number() {
        return telephonyManager.getLine1Number();
    }

    @Rpc(description = "Gets the call state for the default subscription.")
    public int getCallState() {
        return telephonyManager.getCallState();
    }

    @Override
    public void shutdown() {}

}