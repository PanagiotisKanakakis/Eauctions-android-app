//package com.eauctions.activities;
//
//import android.content.Context;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.RatingBar;
//import android.widget.TextView;
//
//import com.airbnb.Utils.Util;
//import com.airbnb.rest.RestApi;
//import com.airbnb.shared.dto.comment.CommentDto;
//import com.airbnb.shared.dto.entity.Comment;
//import com.airbnb.shared.dto.entity.User;
//import com.airbnb.shared.dto.residence.AddResidenceResponseDto;
//import com.airbnb.shared.dto.residence.SearchResidenceByIdDto;
//import com.airbnb.shared.dto.user.UserUtilsDto;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.MapView;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.gson.Gson;
//import com.sourcey.activities.R;
//import com.squareup.picasso.Picasso;
//
//import org.springframework.http.HttpEntity;
//import org.springframework.web.client.RestTemplate;
//
//import java.io.File;
//import java.io.IOException;
//
//import butterknife.Bind;
//import butterknife.ButterKnife;
//
//public class ResidenceDetailsActivity extends AppCompatActivity implements OnMapReadyCallback {
//
//
//    @Bind(R.id.imgView)
//    ImageView _img;
//    @Bind(R.id.type)
//    TextView _type;
//    @Bind(R.id.ratingBar)
//    RatingBar _bar;
//    @Bind(R.id.num_of_reviews)
//    TextView _num_of_reviews;
//    @Bind(R.id.cost)
//    TextView _cost;
//    @Bind(R.id.hostedBy)
//    TextView _hostedBy;
//    @Bind(R.id.guests)
//    TextView _guests;
//    @Bind(R.id.bedrooms)
//    TextView _bedrooms;
//    @Bind(R.id.rules)
//    TextView _rules;
//    @Bind(R.id.beds)
//    TextView _beds;
//    @Bind(R.id.bath)
//    TextView _bath;
//    @Bind(R.id.description)
//    TextView _description;
//    @Bind(R.id.reviewList)
//    ListView _reviewList;
//    @Bind(R.id.checkAvailability)
//    Button _checkAvailability;
//    private GoogleMap mMap;
//    private String mode;
//    private Bundle extras;
//    private User active_user;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_residence_details);
//        ButterKnife.bind(this);
//
//        MapView mapView = (MapView) findViewById(R.id.map);
//        mapView.onCreate(null);
//        mapView.getMapAsync(this);
//
//        _checkAvailability.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), CalendarActivity.class);
//                intent.putExtras(extras);
//                startActivity(intent);
//            }
//        });
//
//        if(getIntent()!=null && getIntent().getExtras() != null && getIntent().getExtras().get("residenceId")!=null){
//            extras = getIntent().getExtras();
//            final String residenceId = new Gson().fromJson(extras.get("residenceId").toString(), String.class);
//            this.mode = extras.get("mode").toString();
//
//            if(residenceId != null) {
//                new GetResidenceByIdAsyncTask(this).execute(Integer.parseInt(residenceId));
//                new GetCommentsOfResidenceAsyncTask(this).execute(Integer.parseInt(residenceId));
//            }
//
//            if(this.mode.equals("host")) {
//                _checkAvailability.setText("Update");
//                _checkAvailability.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent intent = new Intent(getApplicationContext(), UpdateResidenceActivity.class);
//                        intent.putExtras(extras);
//                        startActivity(intent);
//                    }
//                });
//
//            }
//
//        }
//
//    }
//
//    private class GetResidenceByIdAsyncTask extends AsyncTask<Integer, Void, AddResidenceResponseDto> {
//
//        private RestTemplate restTemplate =  new RestApi().getRestTemplate();
//        private Context context;
//
//        public GetResidenceByIdAsyncTask(Context applicationContext) {
//            this.context = applicationContext;
//        }
//
//        @Override
//        protected AddResidenceResponseDto doInBackground(Integer... params) {
//
//            String uri = "";
//            try {
//                uri = Util.getProperty("baseAddress",getApplicationContext()) + "/searchResidenceById";
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            SearchResidenceByIdDto searchResidenceByIdDto = new SearchResidenceByIdDto();
//            searchResidenceByIdDto.setResidenceId(params[0]);
//
//            AddResidenceResponseDto result = null;
//            try {
//                HttpEntity<SearchResidenceByIdDto> request = new HttpEntity<>(searchResidenceByIdDto);
//                result = restTemplate.postForObject(uri, request,AddResidenceResponseDto.class);
//                return result;
//            } catch (Exception e) {
//                Log.e("tag", e.getMessage());
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(AddResidenceResponseDto residence) {
//           if(residence != null){
//
//               new GetHostInfoAsyncTask(context).execute(residence.getUsername());
//
//               _type.setText(residence.getType());
//               _hostedBy.setText("Hosted by " + residence.getUsername());
//               _guests.setText(String.valueOf(residence.getCapacity()) + " Guest(s)");
//               _cost.setText(String.valueOf(residence.getPrize()) + " per night");
//               _bedrooms.setText(String.valueOf(residence.getBedrooms()) + " Bedroom(s)" );
//               _beds.setText(String.valueOf(residence.getBeds()) + " Bed(s)");
//               _bath.setText(String.valueOf(residence.getBathrooms())+ " Bath(s)");
//               _description.setText(residence.getDescription());
//               _rules.setText(residence.getRules());
//               _num_of_reviews.setText(String.valueOf(residence.getComments().size()));
//
//               int sum = 0;
//               for(Comment c : residence.getComments())
//                    sum += c.getGrade();
//
//               if(residence.getComments().size() > 0)
//                   _bar.setRating(sum / residence.getComments().size());
//               else
//                   _bar.setRating((float) 0.0);
//
//
//               Uri uri = Uri.fromFile(new File(residence.getPhotoPaths().get(0)));
//               Picasso.with(context).load(uri)
//                       .resize(1000, 400)
//                       .centerCrop().into(_img);
//               LatLng latLng = new LatLng(34,32);
//               mMap.addMarker(new MarkerOptions().position(latLng));
//
//
//               String residence_json = new Gson().toJson(residence);
//               extras.putString("residence", residence_json);
//
//           }
//        }
//    }
//
//    private class GetCommentsOfResidenceAsyncTask extends AsyncTask<Integer, Void, CommentDto[]> {
//
//        private RestTemplate restTemplate =  new RestApi().getRestTemplate();
//        private Context context;
//
//        public GetCommentsOfResidenceAsyncTask(Context applicationContext) {
//            this.context = applicationContext;
//        }
//
//        @Override
//        protected CommentDto[] doInBackground(Integer... params) {
//
//            String uri = "";
//            try {
//                uri = Util.getProperty("baseAddress",getApplicationContext()) + "/getCommentsForResidence";
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            SearchResidenceByIdDto searchResidenceByIdDto = new SearchResidenceByIdDto();
//            searchResidenceByIdDto.setResidenceId(params[0]);
//
//            CommentDto[] result = null;
//            try {
//                HttpEntity<SearchResidenceByIdDto> request = new HttpEntity<>(searchResidenceByIdDto);
//                result = restTemplate.postForObject(uri, request,CommentDto[].class);
//                return result;
//            } catch (Exception e) {
//                Log.e("tag", e.getMessage());
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(CommentDto[] comments) {
//            if(comments != null){
//
//            }
//        }
//    }
//
//
//
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//    }
//
//
//    private class GetHostInfoAsyncTask extends AsyncTask<String, Void, User> {
//
//        private RestTemplate restTemplate =  new RestApi().getRestTemplate();
//        private Context context;
//
//        public GetHostInfoAsyncTask(Context applicationContext) {
//            this.context = applicationContext;
//        }
//
//        @Override
//        protected User doInBackground(String... params) {
//
//            String uri = "";
//            try {
//                uri = Util.getProperty("baseAddress",getApplicationContext()) + "/getProfile";
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            UserUtilsDto userUtilsDto = new UserUtilsDto();
//            userUtilsDto.setUsername(params[0]);
//
//            User result = null;
//            try {
//                HttpEntity<UserUtilsDto> request = new HttpEntity<>(userUtilsDto);
//                result = restTemplate.postForObject(uri, request,User.class);
//                return result;
//            } catch (Exception e) {
//                Log.e("tag", e.getMessage());
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(User user) {
//            if(user != null){
//
//                String user_json = new Gson().toJson(user);
//                extras.putString("host_user", user_json);
//
//                ImageView user_image = (ImageView) findViewById(R.id.user_image);
//
//                if(user.getProfilePhoto() != null && user.getProfilePhoto().getPath() != null){
//                    Uri uri = Uri.fromFile(new File(user.getProfilePhoto().getPath()));
//                    Picasso.with(context)
//                            .load(uri)
//                            .transform(new CircleTransform())
//                            .resize(150,150)
//                            .into(user_image);
//
//                    user_image.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            Intent intent = new Intent(getApplicationContext(), ViewProfileActivity.class);
//                            intent.putExtras(extras);
//                            startActivityForResult(intent,1);
//                            finish();
//                            overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
//                        }
//                    });
//                }
//
//
//            }
//        }
//    }
//
//
//
//}
