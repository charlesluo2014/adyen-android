/*
 * Copyright (c) 2019 Adyen N.V.
 *
 * This file is open source and available under the MIT license. See the LICENSE file for more info.
 *
 * Created by caiof on 11/7/2019.
 */

package com.adyen.checkout.base.component;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.adyen.checkout.base.Configuration;
import com.adyen.checkout.core.api.Environment;
import com.adyen.checkout.core.util.ParcelUtils;

import java.util.Locale;

public abstract class BaseConfiguration implements Configuration, Parcelable {

    private final Locale mShopperLocale;
    private final Environment mEnvironment;

    protected BaseConfiguration(@NonNull Locale shopperLocale, @NonNull Environment environment) {
        mShopperLocale = shopperLocale;
        mEnvironment = environment;
    }

    protected BaseConfiguration(@NonNull Parcel in) {
        mShopperLocale = (Locale) in.readSerializable();
        mEnvironment = in.readParcelable(Environment.class.getClassLoader());
    }

    @NonNull
    public Environment getEnvironment() {
        return mEnvironment;
    }

    @NonNull
    @Override
    public Locale getShopperLocale() {
        return mShopperLocale;
    }

    @Override
    public int describeContents() {
        return ParcelUtils.NO_FILE_DESCRIPTOR;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeSerializable(mShopperLocale);
        dest.writeParcelable(mEnvironment, flags);
    }
}
