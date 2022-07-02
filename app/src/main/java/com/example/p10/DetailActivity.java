package com.example.p10;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.p10.pojo.pojo_movies;

public class DetailActivity extends AppCompatActivity {

    public static String EXTRA_MOVIE = "extra_movie";

    ImageView detailPoster;
    TextView detailJudul, detailDate, detailDesc, detailReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailPoster=findViewById(R.id.detail_poster);
        detailJudul=findViewById(R.id.detail_judul);
        detailDate=findViewById(R.id.detail_release_date);
        detailDesc=findViewById(R.id.detail_deskripsi);
        detailReview=findViewById(R.id.detail_review);

        pojo_movies Movies = getIntent().getParcelableExtra(EXTRA_MOVIE);

        detailJudul.setText(Movies.getTitle());
        detailDate.setText(Movies.getRealease_date());
        detailDesc.setText(Movies.getDesc());
        detailReview.setText(Movies.getReview());

        Glide.with(DetailActivity.this).load(Movies.getPoster())
                .apply(new RequestOptions().override(350,550)).into(detailPoster);
    }
}