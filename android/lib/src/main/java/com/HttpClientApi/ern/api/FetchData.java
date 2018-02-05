/*
* Copyright 2017 WalmartLabs
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.HttpClientApi.ern.api;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.List;
import com.walmartlabs.electrode.reactnative.bridge.Bridgeable;

import static com.walmartlabs.electrode.reactnative.bridge.util.BridgeArguments.*;

public class FetchData implements Parcelable, Bridgeable {

    private String url;
    private String method;
    private String data;
    private String headers;

    private FetchData() {}

    private FetchData(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.data = builder.data;
        this.headers = builder.headers;
    }

    private FetchData(Parcel in) {
        this(in.readBundle());
    }

    public FetchData(@NonNull Bundle bundle) {
        if(bundle.get("url") == null){
            throw new IllegalArgumentException("url property is required");
        }
        if(bundle.get("method") == null){
            throw new IllegalArgumentException("method property is required");
        }
        this.url = bundle.getString("url");
        this.method = bundle.getString("method");
        this.data = bundle.getString("data");
        this.headers = bundle.getString("headers");
    }

    public static final Creator<FetchData> CREATOR = new Creator<FetchData>() {
        @Override
        public FetchData createFromParcel(Parcel in) {
            return new FetchData(in);
        }

        @Override
        public FetchData[] newArray(int size) {
            return new FetchData[size];
        }
    };

    @NonNull
    public String geturl() {
        return url;
    }

    /**
    * Method for the fetch (currently supported: get and post)
    *
    * @return String
    */
    @NonNull
    public String getmethod() {
        return method;
    }

    /**
    * Request payload
    *
    * @return String
    */
    @Nullable
    public String getdata() {
        return data;
    }

    /**
    * Request headers
    *
    * @return String
    */
    @Nullable
    public String getheaders() {
        return headers;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeBundle(toBundle());
    }

    @NonNull
    @Override
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        this.url = bundle.getString("url");
        this.method = bundle.getString("method");
        if(data != null) {
            this.data = bundle.getString("data");
        }
        if(headers != null) {
            this.headers = bundle.getString("headers");
        }
        return bundle;
    }

    public static class Builder {
        private final String url;
        private final String method;
        private String data;
        private String headers;

        public Builder(@NonNull String url, @NonNull String method) {
            this.url = url;
            this.method = method;
        }

        @NonNull
        public Builder data(@Nullable String data) {
            this.data = data;
            return this;
        }
        @NonNull
        public Builder headers(@Nullable String headers) {
            this.headers = headers;
            return this;
        }

        @NonNull
        public FetchData build() {
            return new FetchData(this);
        }
    }
}