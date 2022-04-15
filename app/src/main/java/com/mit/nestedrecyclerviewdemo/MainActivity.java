package com.mit.nestedrecyclerviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView ParentRecyclerViewItem;
    ParentItemAdapter parentItemAdapter;
    List<ParentModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ParentRecyclerViewItem = findViewById(R.id.parent_recyclerview);



       ParentRecyclerViewItem.setLayoutManager(new LinearLayoutManager(MainActivity.this));

       getrecycleview();

    }



    private void getrecycleview() {



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.pidu.in/mybiz/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiPlaceHolder retrofitAPI = retrofit.create(ApiPlaceHolder.class);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("apikey", "164310030161efb88d2d888");
        jsonObject.addProperty("userid", "1");
        jsonObject.addProperty("storeid", "158");
        jsonObject.addProperty("page", "3");

        Call<ResponseBody> call = retrofitAPI.menulistallitem(jsonObject);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == 200) {
                    if (response.body() != null) {

                        try {
                            JSONObject json = new JSONObject(response.body().string());

                            if (json.getString("status").equals("success")) {


                                JSONObject json1 = new JSONObject(json.getString("data"));

//                                JSONObject json2categorylist = new JSONObject(json1.getString("cagtegorylist"));
//
//                                JSONObject json2itemlist = new JSONObject(json1.getString("itemlist"));

                                Iterator x = json1.keys();

                                list.clear();

                                while (x.hasNext()) {

                                    String key = (String) x.next();

                                    JSONObject json2 = new JSONObject(json1.get(key).toString());
//                                    String catid = json2.getString("id") + "";

                                    List<ChildModel> list2 = new ArrayList<ChildModel>();

                                    JSONObject json3 = new JSONObject(json2.getString("data"));


                                    if (json3.toString().equals("{}")) {


                                    } else {


                                        Iterator y = json3.keys();

                                        while (y.hasNext()) {

                                            String key1 = (String) y.next();
                                            JSONObject json2item = new JSONObject(json3.get(key1).toString());



                                                list2.add(new ChildModel(
                                                        json2item.getString("id") + "",
                                                        json2item.getString("image") + "",
                                                        json2item.getString("title") + "",
                                                        json2item.getString("description") + "",
                                                        json2item.getString("price") + "",
                                                        json2item.getString("validtill") + "",
                                                        json2item.getString("url") + ""


                                                ));





                                        }

                                    }
                                    Log.e("MENUFRAG", "0" + list2.size());

//                                    Toast.makeText(MainActivity.this, list2.get(1).getId()+"", Toast.LENGTH_SHORT).show();
                                    list.add(new ParentModel(
                                            json2.getString("categoryid") + "",
                                            json2.getString("category") + "",
                                            json2.getString("layout") + "",
                                            json2.getString("type") + "",
                                        list2

                                    ));

                                }

                                //set adapter

                                parentItemAdapter = new ParentItemAdapter(list,MainActivity.this);

                                ParentRecyclerViewItem.setAdapter(parentItemAdapter);
                                Log.e("MENUFRAG", "0" );

                                Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();

//                                hideLoading();

                            } else {
//                                showSnackBarRed("No Salary Found");
//                                hideLoading();
                                Toast.makeText(MainActivity.this, "Fail1", Toast.LENGTH_SHORT).show();


                            }

//                            onListLoadSuccess(menuListModelList);


                        } catch (IOException | JSONException e) {
//                            hideLoading();
//                            showSnackBarRed("catch Something Error!!");
                            Toast.makeText(MainActivity.this, "Catch Error", Toast.LENGTH_SHORT).show();


                        }
                    }
                } else {
//                    hideLoading();
//                    shimmerMenuList.stopShimmer();
//                    shimmerMenuList.setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this, "Fail2", Toast.LENGTH_SHORT).show();

//                    showSnackBarRed("Something Error!!");

                }

            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
//                hideLoading();
//                showSnackBarRed("Something Went Wrong");
                Toast.makeText(MainActivity.this, "Fail3", Toast.LENGTH_SHORT).show();


            }
        });

    }


}




