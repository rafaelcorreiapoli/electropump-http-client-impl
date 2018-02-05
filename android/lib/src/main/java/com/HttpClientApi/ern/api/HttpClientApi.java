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

import android.support.annotation.NonNull;

import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeEventListener;
import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeEvent;
import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeRequestHandler;
import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeResponseListener;
import com.walmartlabs.electrode.reactnative.bridge.None;
import java.util.*;
import java.util.UUID;

import com.HttpClientApi.ern.model.Response;

public final class HttpClientApi {
    private static final Requests REQUESTS;

    static {
        REQUESTS = new HttpClientRequests();
    }

    private HttpClientApi() {
    }

    @NonNull
    public static Requests requests() {
        return REQUESTS;
    }



    public interface Requests {
        String REQUEST_FETCH = "com.HttpClientApi.ern.api.request.fetch";


        void registerFetchRequestHandler(@NonNull final ElectrodeBridgeRequestHandler<FetchData, Response> handler);

        void fetch(FetchData fetchData, @NonNull final ElectrodeBridgeResponseListener<Response> responseListener);

    }
}