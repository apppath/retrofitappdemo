# Retrofit Android
Retrofit is a REST Client for Java and Android. It makes it relatively easy to retrieve and upload JSON (or other structured data) via a REST based webservice. In Retrofit you configure which converter is used for the data serialization.

## App Images

<p align="center">

  <img src="https://github.com/apppath/retrofitappdemo/blob/master/retrofit-home-activity.png" width="250"/>
  <img src="https://github.com/apppath/retrofitappdemo/blob/master/retrofit-insert-activity.png" width="250"/>
  <img src="https://github.com/apppath/retrofitappdemo/blob/master/retrofit-valid-image.png" width="250"/>

</p>

## Json 

<p align="center">

  <img src="https://github.com/apppath/retrofitappdemo/blob/master/json-list.png"/>
  
</p>


```java

```

## Refrofit Dependency

```gradle

implementation 'com.google.code.gson:gson:2.8.5'
implementation 'com.squareup.retrofit2:retrofit:2.4.0'
implementation 'com.squareup.retrofit2:converter-gson:2.4.0'

```

## AndroidManifest.xml File

```xml

<uses-permission android:name="android.permission.INTERNET" />

```

## Refrofit Configuration

```java

package com.example.basicprogramming.retrofitappdemo.apiservices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientInstance {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://10.0.3.2";

    public static Retrofit getRetrofitInstance() {

        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

```

## Api Interface 

```java

import com.example.basicprogramming.retrofitappdemo.model.Users;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServices {

    @FormUrlEncoded
    @POST("/userrestapi/v1/addusers")
    Call<Users> createUsers(@FieldMap Map<String, String> params);

    @GET("/userrestapi/v1/users")
    Call<List<Users>> getAllUsers();
}


```

## Retrofit Model

```java 

package com.example.basicprogramming.retrofitappdemo.model;

import com.google.gson.annotations.SerializedName;

public class Users {

    @SerializedName("id")
    private int id;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("email")
    private String emailId;
    @SerializedName("age")
    private int age;

    public Users(String firstName, String lastName, String emailId, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public int getAge() {
        return age;
    }

}


```

# Done Work
