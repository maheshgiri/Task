package com.example.hungry.task;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Hungry on 1/18/2016.
 */
public class LocationDetailsActivity extends AppCompatActivity {
ImageView mainImageView;
TextView locationDetails;
TextView noTextView;
    int[] imageList = new int[]{R.drawable.atm_image, R.drawable.atm_image, R.drawable.atm_image, R.drawable.atm_image
            , R.drawable.atm_image, R.drawable.atm_image,
            R.drawable.hospital_image, R.drawable.hospital_image};
    String[] distanceArray = new String[]{"100", "20", "500", "8", "78", "89", "877", "7000"};
    String[] noArray=new String[]{"1111111111","2222222222","3333333330","44444444444","55555555555",
            "66666666666","77777777777","88888888888","9999999999","101010101010"};
    String[] descriptionArray = new String[]{"Location is at 8,kothrud,pune with nice and warm climate",
            "Location is good for hunting ",
            "Kothrud is very famous and shine area in pune",
            "Pune was an important centre in the social and religious reform movements of the late 19th century." +
                    " Prominent social reformers and freedom fighters lived here",
            " memorial to the Chapekar brothers exists at the spot on Ganeshkhind Road " +
                    "(University Road) between the Reserve Bank and the Agricultural College.",
            "Pune serves as the headquarters of the Southern Command of the Indian Army.[28] " +
                    "Industrial development started in the 1950s and '60s in Hadapsar, Bhosari, Pimpri and Parvati",
            "Pune is located 560 m (1,840 ft) above sea level on the western margin of the Deccan plateau. " +
                    "It is situated on the leeward side of the Sahyadri mountain range",
            "Pune lies very close to the seismically active zone around Koyna Dam, about 100 km (62 mi) " +
                    "south of the city, and has been rated in Zone 3 (on a scale of 2 to 5",
            "Deccan Gymkhana, Erandawane, Prabhat Road, Law College Road in the west; Camp, Bund Garden and " +
                    "Koregaon Park in the east; Swargate, Parvati Hill, " +
                    "Sahakarnagar, Mukund Nagar, Maharshi Nagar, Gultekdi and Salisbury Park to the south"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locationdetails);
        int position=getIntent().getIntExtra("position",0);
        mainImageView=(ImageView)findViewById(R.id.locationImage);
        mainImageView.setImageResource(imageList[position]);
        locationDetails=(TextView)findViewById(R.id.locationDetails);
        locationDetails.setText(Html.fromHtml("<b>"+"Location Details "+"</b>")+descriptionArray[position]);
        noTextView=(TextView)findViewById(R.id.contact);
        noTextView.setText(Html.fromHtml("<b>"+"Contact " + "</b>")+noArray[position]);

    }
}
