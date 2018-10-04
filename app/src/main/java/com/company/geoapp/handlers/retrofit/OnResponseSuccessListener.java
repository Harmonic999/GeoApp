package com.company.geoapp.handlers.retrofit;

import retrofit2.Response;

public interface OnResponseSuccessListener<T> {

    void handleResponse(Response<T> response);

}
