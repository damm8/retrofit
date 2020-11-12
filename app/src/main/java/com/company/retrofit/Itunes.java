package com.company.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class Itunes {
    public static Api api = new Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api.class);

    public interface Api {
        @GET("search/")
        Call<Respuesta> buscar(@Query("term") String texto);
    }

    public static class Respuesta {
        public List<Contenido> results;
    }

    public static class Contenido {
        public String artistName;
        public String trackName;
        public String artworkUrl100;
    }
}













//    public static Api api = new Retrofit.Builder()
//            .baseUrl("https://itunes.apple.com/")
//            .client(new OkHttpClient.Builder()
//                    // log interceptor
//                    .addInterceptor(new Interceptor() {
//                        @Override
//                        @NonNull
//                        public Response intercept(@NonNull Chain chain) throws IOException {
//                            Request request = chain.request();
//                            Log.e("INTERCEPTOR", String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()));
//
//                            okhttp3.Response response = chain.proceed(request);
//                            Log.e("INTERCEPTOR---", String.format("Received response for %s %n%s", response.request().url(), response.headers()));
//
//                            return response;
//                        }
//                    })
//                    // api_key interceptor
//                    .addInterceptor(new Interceptor() {
//                        @Override
//                        @NonNull
//                        public okhttp3.Response intercept(@NonNull Chain chain) throws IOException {
//                            Request original = chain.request();
//                            HttpUrl originalHttpUrl = original.url();
//
//                            HttpUrl url = originalHttpUrl.newBuilder()
//                                    .addQueryParameter("api_key", "YOUR_API_KEY")
//                                    .build();
//
//                            Request.Builder requestBuilder = original.newBuilder()
//                                    .url(url);
//
//                            Request request = requestBuilder.build();
//                            return chain.proceed(request);
//                        }
//                    })
//                    .build()
//            )
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(Api.class);

