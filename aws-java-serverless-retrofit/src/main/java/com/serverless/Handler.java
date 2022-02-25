package com.serverless;

import RetrofitService.MockApiCallService;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class Handler implements RequestHandler<SQSEvent, Void> {
	static final String BASE_URL
			= "https://jsonplaceholder.typicode.com/";
	@Override
	public Void handleRequest(SQSEvent event, Context context) {
		Gson gson = new GsonBuilder()
			.setLenient()
			.create();

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create(gson))
				.build();
//
//		MockApiCallService callService = retrofit.create(MockApiCallService.class);
//		Call<Object> call = callService.getPostById(1L);
//		try {
//			//Response<Object> resp = call.execute();
//			//System.out.println(resp.body());
//		} catch (Exception ex) {}

		/*for(SQSEvent.SQSMessage msg : event.getRecords()){
			System.out.println(new String(msg.getBody()));
			try {
				if (!"all".equals(msg.getBody())) {
					Call<Object> call = callService.getPostById(Long.parseLong(msg.getBody()));
					// Async call
					call.enqueue(new Callback<Object>() {
						public void onResponse(Call<Object> call, Response<Object> response) {
							if(response.isSuccessful()) {
								Object post = response.body();
								System.out.println(post);
							} else {
								System.out.println(response.errorBody());
							}
						}

						@Override
						public void onFailure(Call<Object> call, Throwable throwable) {
							throwable.printStackTrace();
						}

					});
					// Sync call
					Response<Object> resp = call.execute();
					System.out.println(resp.body());
				} else {
					Call<List<Object>> call = callService.getPosts();
					call.enqueue(new Callback<List<Object>>() {
						public void onResponse(Call<List<Object>> call, Response<List<Object>> response) {
							if(response.isSuccessful()) {
								List<Object> post = response.body();
								System.out.println(post);
							} else {
								System.out.println(response.errorBody());
							}
						}

						@Override
						public void onFailure(Call<List<Object>> call, Throwable throwable) {
							throwable.printStackTrace();
						}

					});
				}
			} catch (Exception ex) {
				System.out.println("Call mock api failed " + ex.getMessage());
			}
		}*/
		return null;
	}
}
