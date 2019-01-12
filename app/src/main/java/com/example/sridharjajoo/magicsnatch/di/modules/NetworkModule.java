package com.example.sridharjajoo.magicsnatch.di.modules;

import com.example.sridharjajoo.magicsnatch.MagicSnatchMainApplication;
import com.example.sridharjajoo.magicsnatch.data.LoginApi;
import com.example.sridharjajoo.magicsnatch.data.LoginRequest;
import com.example.sridharjajoo.magicsnatch.data.LoginResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.jasminb.jsonapi.retrofit.JSONAPIConverterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Module(includes = ApiModule.class)
public class NetworkModule {

    @Provides
    @Singleton
    ObjectMapper providesObjectMapper() {
        return new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .setSerializationInclusion(JsonInclude.Include.NON_ABSENT);
    }

    @Provides
    Class[] providesMappedClasses() {
        return new Class[]{LoginResponse.class, LoginRequest.class};
    }

    @Provides
    @Singleton
    @Named("jsonapi")
    Converter.Factory providesJsonApiFactory(ObjectMapper objectMapper, Class... mappedClasses) {
        return new JSONAPIConverterFactory(objectMapper, mappedClasses);
    }

    @Provides
    @Singleton
    @Named("jackson")
    Converter.Factory providesJacksonFactory(ObjectMapper objectMapper) {
        return JacksonConverterFactory.create(objectMapper);
    }

    @Provides
    @Singleton
    Cache providesCache() {
        int cacheSize = 10 * 1024 * 1024; // 10 MB
        return new Cache(MagicSnatchMainApplication.context.getCacheDir(), cacheSize);
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .cache(cache)
                .addNetworkInterceptor(chain -> {
                    Response response = chain.proceed(chain.request());
                    CacheControl cacheControl;
                    cacheControl = new CacheControl.Builder().maxAge(1, TimeUnit.MINUTES).build();
                    return response.newBuilder()
                            .removeHeader("pragma")
                            .removeHeader("Cache-Control")
                            .header("Cache-Control", cacheControl.toString())
                            .build();
                })
                .build();
    }

    @Provides
    @Singleton
    CallAdapter.Factory providesCallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofitBuilder(CallAdapter.Factory callAdapterFactory,
                                     OkHttpClient client, @Named("jackson") Converter.Factory factory) {
        return new Retrofit.Builder()
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(callAdapterFactory)
                .baseUrl("https://blooming-sands-96493.herokuapp.com/")
                .build();
    }
}
