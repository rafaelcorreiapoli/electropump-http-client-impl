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

package com.ern.api.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.HttpClientApi.ern.api.HttpClientApi;
import com.HttpClientApi.ern.api.FetchData;
import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeRequestHandler;
import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeResponseListener;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * This class is a generated place holder for your HttpClient implementations.!
 * Feel free to modify this class contents as needed. `ern regen-api-impl` command WILL NOT modify the content of this class.
 * Don't modify the class name as this naming convention is used for container generation.
 */
public class HttpClientApiRequestHandlerProvider extends RequestHandlerProvider<HttpClientApiRequestHandlerProvider.HttpClientApiConfig> implements HttpClientApiRequestHandler {
    private static final String GET = "get";
    private static final String POST = "post";
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * @param requestHandlerConfig : Optional config object that can be passed to an api impl provider.
     */
    HttpClientApiRequestHandlerProvider(@Nullable HttpClientApiRequestHandlerProvider.HttpClientApiConfig requestHandlerConfig) {
        super(requestHandlerConfig);
    }

    @Override
    public void registerFetchRequestHandler() {
        HttpClientApi.requests().registerFetchRequestHandler(new ElectrodeBridgeRequestHandler<FetchData, com.HttpClientApi.ern.model.Response>() {
            @Override
            public void onRequest(@Nullable FetchData payload, @NonNull final ElectrodeBridgeResponseListener<com.HttpClientApi.ern.model.Response> responseListener) {
                assert payload != null;

                final OkHttpClient client = new OkHttpClient();

                Request.Builder builder = new Request.Builder()
                        .url(payload.geturl());
                switch (payload.getmethod().toLowerCase()) {
                    case HttpClientApiRequestHandlerProvider.GET:
                        builder = builder.get();
                        break;
                    case HttpClientApiRequestHandlerProvider.POST:
                        RequestBody body = RequestBody.create(JSON, "");
                        builder = builder.post(body);
                }

                final Request request = builder.build();

                Single.create(new SingleOnSubscribe<String>() {
                    @Override
                    public void subscribe(SingleEmitter<String> emitter) throws Exception {
                        Response response = client.newCall(request).execute();
                        emitter.onSuccess(response.body().string());
                    }
                }).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<String>() {
                            @Override
                            public void accept(String s) throws Exception {
                                com.HttpClientApi.ern.model.Response response = new com.HttpClientApi.ern.model.Response.Builder().body(s).headers("headers...").status(200).build();
                                responseListener.onSuccess(response);
                            }
                        });
            }
        });

        //TODO
    }

    // DO NOT rename this class as this naming convention is used when a container is generated.
    public static class HttpClientApiConfig implements RequestHandlerConfig {

    }
}