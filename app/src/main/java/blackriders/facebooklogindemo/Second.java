package blackriders.facebooklogindemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

/**
 * Created by Sanwal Singh on 19/5/16.
 */
public class Second extends Activity {

    Button postPhotoButton, postStatusUpdateButton;
    String TAG = "second";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CallbackManager callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "LoginManager FacebookCallback onSuccess");

                if (loginResult.getAccessToken() != null) {
                    Log.d(TAG, "Access Token:: " + loginResult.getAccessToken());

                }
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "LoginManager FacebookCallback onCancel");
            }

            @Override
            public void onError(FacebookException e) {
                Log.d(TAG, "LoginManager FacebookCallback onError");
            }
        });

        postPhotoButton = (Button) findViewById(R.id.postPhotoButton);
        postStatusUpdateButton = (Button) findViewById(R.id.postStatusUpdateButton);

        postPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                Intent intent = new Intent(Second.this, MainActivity.class);
                startActivity(intent);
            }
        });

        postStatusUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                Intent intent = new Intent(Second.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean isLoggedIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null;
    }
}
