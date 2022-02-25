package RetrofitService;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface MockApiCallService {
    @GET("/posts")
    Call<List<Object>> getPosts();

    @GET("/posts/{postId}")
    Call<Object> getPostById(@Path("postId") Long postId);
}
