package com.leal.camilogo1200.data.net;

import androidx.annotation.NonNull;

import com.facebook.flipper.plugins.network.NetworkFlipperPlugin;
import com.leal.camilogo1200.data.net.helpers.GzipRequestInterceptor;
import com.leal.camilogo1200.data.net.interfaces.RetrofitBuilder;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public final class RetrofitServiceBuilder {
    private RetrofitServiceBuilder() {
    }

    public static final class Builder implements RetrofitBuilder {
        private Retrofit.Builder retrofitBuilder;
        private OkHttpClient.Builder okHttpClient;
        private String baseURL;
        private boolean enableLoggingInterceptor;
        private boolean enableGZipCompression;
        private boolean disableSensibleInformation;
        private boolean enableNetEventListeners;
        private boolean enableGsonConverter;
        HttpLoggingInterceptor loggingInterceptor = null;
        private HttpLoggingInterceptor.Level level = null;
        private List<Converter.Factory> converterFactories;
        private List<Interceptor> lInterceptors;
        private List<Interceptor> lNetworkInterceptors;
        private boolean enableScalarConverter;
        private boolean enableStetho;
        private boolean enableFlipper;
        private NetworkFlipperPlugin networkFlipperPlugin;
        private boolean enableRxJava3;

        public Builder() {
            retrofitBuilder = new Retrofit.Builder();
            okHttpClient = new OkHttpClient.Builder();
            converterFactories = new ArrayList<>();
            lInterceptors = new ArrayList<>();
            lNetworkInterceptors = new ArrayList<>();
            level = HttpLoggingInterceptor.Level.BASIC;
            loggingInterceptor = new HttpLoggingInterceptor();
        }

        @Override
        public Builder enableGzipCompression(boolean enable) {
            enableGZipCompression = enable;
            return this;
        }

        @Override
        public Builder enableLoggingInterceptor(boolean enable) {
            enableLoggingInterceptor = enable;
            return this;
        }

        @Override
        public Builder setLoggingLevelInterceptor(HttpLoggingInterceptor.Level level) {
            this.level = level;
            return this;
        }

        @Override
        public Builder disableSensibleInformationfilter(boolean disable) {
            disableSensibleInformation = disable;
            return null;
        }

        @Override
        public Builder enableNetworkEventListeners(boolean enable) {
            enableNetEventListeners = enable;
            return this;
        }

        @Override
        public Builder setBaseUrl(@NonNull String baseUrl) {
            this.baseURL = baseUrl;
            return this;
        }

        @Override
        public Builder addConverterFactory(Converter.Factory factory) {
            converterFactories.add(factory);
            return this;
        }

        @Override
        public Builder enableGsonConverterFactory(boolean enable) {
            enableGsonConverter = enable;
            return this;
        }

        @Override
        public Builder addScalarsConverterFactory(boolean enable) {
            enableScalarConverter = enable;
            return this;
        }

        @Override
        public Builder addInterceptor(Interceptor interceptor) {
            lInterceptors.add(interceptor);
            return this;
        }

        @Override
        public Builder addNetworkInterceptor(Interceptor interceptor) {
            lNetworkInterceptors.add(interceptor);
            return this;
        }

        @Override
        public Builder enableStethoInterceptor(boolean enable) {
            enableStetho = enable;
            return null;
        }

        @Override
        public Builder enableFlipperInterceptor(boolean enable, NetworkFlipperPlugin networkPlugin) {
            enableFlipper = enable;
            networkFlipperPlugin = networkPlugin;
            return null;
        }

        @Override
        public Builder enableRxJava3Converter(boolean enable) {
            enableRxJava3 = enable;
            return this;
        }

        @Override
        public <T> T create(Class<T> serviceClass) {


            if (baseURL == null || baseURL.isEmpty()) {
                throw new IllegalArgumentException("Invalid URL [" + baseURL + "]");
            }
            retrofitBuilder.baseUrl(baseURL);
            loggingInterceptor.setLevel(level);

            if (!disableSensibleInformation) {
                loggingInterceptor.redactHeader("Authorization");
                loggingInterceptor.redactHeader("Cookie");
            }

            addConverters();
            addInterceptors();
            addDebugHelpers();

            Retrofit.Builder builder = retrofitBuilder
                    .client(okHttpClient.build());
            if (enableRxJava3) {
                builder.addCallAdapterFactory(RxJava3CallAdapterFactory.create());
            }
            return builder.build()
                    .create(serviceClass);
        }

        private void addDebugHelpers() {
//            if (BuildConfig.DEBUG) {
//                if (enableStetho) {
//                    okHttpClient.addNetworkInterceptor(new StethoInterceptor());
//                }
//
//                if (enableFlipper) {
//                    okHttpClient.addNetworkInterceptor(new FlipperOkhttpInterceptor(networkFlipperPlugin));
//                }
//
//                if (enableNetEventListeners || BuildConfig.NETWORK_EVENTS_LISTENER) {
//                    okHttpClient.eventListenerFactory(PrintingEventListener.FACTORY);
//                }
//            }
        }

        private void addConverters() {

            if (converterFactories != null) {
                for (Converter.Factory factory : converterFactories) {
                    retrofitBuilder.addConverterFactory(factory);
                }
            }

            if (enableGsonConverter) {
                retrofitBuilder.addConverterFactory(GsonConverterFactory.create());
            }

            if (enableScalarConverter) {
                retrofitBuilder.addConverterFactory(ScalarsConverterFactory.create());
            }
        }

        private void addInterceptors() {
            if (enableGZipCompression) {
                okHttpClient.addNetworkInterceptor(new GzipRequestInterceptor());
            }
            if (lInterceptors != null) {
                for (Interceptor i : lInterceptors) {
                    okHttpClient.addInterceptor(i);
                }
            }

            if (lNetworkInterceptors != null) {
                for (Interceptor i : lNetworkInterceptors) {
                    okHttpClient.addNetworkInterceptor(i);
                }
            }
        }

    }

    public static Builder newBuilder() {
        return new Builder();
    }

}