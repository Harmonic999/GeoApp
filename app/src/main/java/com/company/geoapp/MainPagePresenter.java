package com.company.geoapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestOptions;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.concurrent.ExecutionException;

public class MainPagePresenter extends MvpBasePresenter<MainPageView> {

    private static final String[] iconsUrl;

    private Context context;

    public MainPagePresenter(Context context) {
        this.context = context;
    }

    static {
        iconsUrl = new String[]{
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZJiSqfFHrD6BDx1S5aHNsSQvfbnhnkhKWR0YUtIStlJ4I2Xnb",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQUBAqnWzCh7EjnDIRhLWY80LIiwzFsH7WXeYVpOktHJ8I06Wcr",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQc8afXdFtfWl5EPKtMCp-eX9Ky0a4aOUKQfHslQaXnlC0IQjWL",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRewe4H-wDbJRKPqtAfWW9eRhuiBrZ_QxOrZmJz5qblX9G0jiXD-g",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTIe6kxn5WMQpCLEUi0FBJVFG0m3TqqifDAS_3cSHhdy4X0uCZ-",
        };
    }

    public void setRandomIcon() {
        new LoadRandomIconTask().execute();
    }

    private void passImageToView(Bitmap imageBitmap) {
        if (isViewAttached()) {
            getView().showRandomIcon(imageBitmap);
        }
    }

    private class LoadRandomIconTask extends AsyncTask<Void, Void, Bitmap> {

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(context,
                    "Loading image",
                    "wait...",
                    true);
        }

        @Override
        protected Bitmap doInBackground(Void... voids) {
            int randomValue = (int) (Math.random() * iconsUrl.length);

            FutureTarget<Bitmap> futureBitmap = Glide
                    .with(context)
                    .asBitmap()
                    .load(iconsUrl[randomValue])
                    .apply(RequestOptions.circleCropTransform())
                    .submit(300, 300);
            Bitmap bitmap = null;

            try {
                bitmap = futureBitmap.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            passImageToView(bitmap);
            progressDialog.dismiss();
        }
    }

}