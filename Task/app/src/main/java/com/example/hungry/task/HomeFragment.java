package com.example.hungry.task;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hungry on 1/17/2016.
 */
public class HomeFragment extends Fragment {
    ListView homeFragmentListView;
    interface DataShare {
        void ShareData(int id);
    }

    DataShare dataShare;

    int[] imageList = new int[]{R.drawable.atm_image, R.drawable.atm_image, R.drawable.atm_image, R.drawable.atm_image
            , R.drawable.atm_image, R.drawable.atm_image,
            R.drawable.hospital_image, R.drawable.hospital_image};
    String[] distanceArray = new String[]{"100", "20", "500", "8", "78", "89", "877", "7000"};
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = null;
        view = inflater.inflate(R.layout.home_fragment, null);
        homeFragmentListView = (ListView) view.findViewById(R.id.mainListView);
        homeFragmentListView.setItemsCanFocus(false);

        return view;
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
         dataShare= (DataShare) activity;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        homeFragmentListView.setAdapter(new CustomListAdaptor(getActivity(), imageList, distanceArray, descriptionArray));
    }

    private class CustomListAdaptor extends BaseAdapter {
        int[] theImageList;
        Context theContext;
        String theDistanceArr[], theDescriptionArray[];

        public CustomListAdaptor(FragmentActivity activity, int[] imageList, String[] distanceArray, String[] descriptionArray) {
            theImageList = imageList;
            theContext = activity;
            theDescriptionArray = descriptionArray;
            theDistanceArr = distanceArray;
        }

        @Override
        public int getCount() {
            return theImageList.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = convertView;
            ImageView theImage = null;
            TextView desText = null, disText = null;
            TextView shareLayout=null;
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) theContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.homelist_fragment, null);
                view.setId(position);
                theImage = (ImageView) view.findViewById(R.id.typeImageShow);
                desText = (TextView) view.findViewById(R.id.descriptionText);
                disText = (TextView) view.findViewById(R.id.distanceText);
                shareLayout=(TextView)view.findViewById(R.id.shareLinearLayout);
                theImage.setImageResource(theImageList[position]);

                desText.setText(Html.fromHtml("<b>" + "Description " + "</b>") + theDescriptionArray[position]);
                disText.setText(Html.fromHtml("<b>"+"Distance "+"</b>")+theDistanceArr[position]+" KM");

                shareLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("Click", "clicked");
                        dataShare.ShareData(position);
                    }
                });

            } else {
                view.setTag(position);
                theImage = (ImageView) view.findViewById(R.id.typeImageShow);
                desText = (TextView) view.findViewById(R.id.descriptionText);
                disText = (TextView) view.findViewById(R.id.distanceText);
                theImage.setImageResource(theImageList[position]);
                desText.setText(Html.fromHtml("<b>"+"Description " + "</b>") + theDescriptionArray[position]);
                disText.setText(Html.fromHtml("<b>"+"Distance "+"</b>")+theDistanceArr[position]+" KM");

                shareLayout=(TextView)view.findViewById(R.id.shareLinearLayout);
                shareLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("Click","clicked");
                        dataShare.ShareData(position);
                    }
                });

            }
            return view;
        }
    }
}
