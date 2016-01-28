package com.example.hungry.task;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.FacebookSdk;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button signUpButton,SkipButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signUpButton=(Button)findViewById(R.id.signUpButton);
        SkipButton=(Button)findViewById(R.id.skipButton);
        signUpButton.setOnClickListener(this);
        SkipButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
//     /*   switch (v.getId()){
//            case R.id.signUpButton:
//                Intent intent=new Intent(this,HomeAcitivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(intent);
//                break;
//            case R.id.skipButton:
//                Intent intentSkip=new Intent(this,HomeAcitivity.class);
//                intentSkip.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(intentSkip);
//                break;
//        }
// */   }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

}
