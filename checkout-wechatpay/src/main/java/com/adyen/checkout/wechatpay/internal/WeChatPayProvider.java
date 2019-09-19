/*
 * Copyright (c) 2017 Adyen N.V.
 *
 * This file is open source and available under the MIT license. See the LICENSE file for more info.
 *
 * Created by ran on 08/05/2018.
 */

package com.adyen.checkout.wechatpay.internal;

import android.app.Activity;
import android.support.annotation.NonNull;

/**
 * Provider for the {@link WeChatPayUtil}.
 */
public final class WeChatPayProvider {

    private String mCallbackActivityName;

    private WeChatPayProvider(Builder builder) {
        mCallbackActivityName = builder.mCallbackActivityName;
    }

    @NonNull
    public String getCallbackActivityName() {
        return mCallbackActivityName;
    }

    public static final class Builder {
        private String mCallbackActivityName;

        public Builder() {
        }

        /**
         * @param clazz The callback {@link Activity}, will be launched with a WeChat Pay payment result intent.
         * @return The {@link Builder}
         */
        @NonNull
        public Builder callbackActivity(@NonNull Class<? extends Activity> clazz) {
            mCallbackActivityName = clazz.getName();
            return this;
        }

        @NonNull
        public WeChatPayProvider build() {
            return new WeChatPayProvider(this);
        }
    }
}
