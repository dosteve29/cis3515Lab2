package edu.temple.signupform;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Button saveButton = findViewById(R.id.saveButton);

        //when the button is pressed
        saveButton.setOnClickListener(steveListener);
    }

    private View.OnClickListener steveListener = new View.OnClickListener(){
        public void onClick(View v){
            //these are the Views variables
            EditText userName = findViewById(R.id.userName);
            EditText userEmail = findViewById(R.id.userEmail);
            EditText userPassword = findViewById(R.id.userPassword);
            EditText userPasswordConfirmation = findViewById(R.id.userPasswordConfirmation);

            //if any of the field in the form is empty
            if (isEmpty(userName) || isEmpty(userEmail) || isEmpty(userPassword) || isEmpty(userPasswordConfirmation)){
                Context context = getApplicationContext();
                CharSequence text = "Please Enter All the Information Required!!!";
                int duration = Toast.LENGTH_SHORT;

                Toast.makeText(context, text, duration).show();
            } else{
                //if the password and password confirmation matches
                if (userPassword.getText().toString().equals(userPasswordConfirmation.getText().toString())){
                    Context context = getApplicationContext();
                    CharSequence text = "Your information has been saved!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast.makeText(context, text, duration).show();
                } else{ //password and password confirmation does not match
                    Context context = getApplicationContext();
                    CharSequence text = "Password and Password Confirmation does not match!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast.makeText(context, text, duration).show();
                }
            }
        }
    };

    private boolean isEmpty(EditText someText){
      if (someText.getText().toString().matches("")){
          return true;
      }
      return false;
    };
}

