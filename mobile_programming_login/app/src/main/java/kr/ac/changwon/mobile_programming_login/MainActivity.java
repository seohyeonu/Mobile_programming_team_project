package kr.ac.changwon.mobile_programming_login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText inputID, inputPassword;
    Button loginButton;
    TextView getNewUser, findUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //
        inputID = findViewById(R.id.input_id);
        inputPassword = findViewById(R.id.input_password);

        loginButton = findViewById(R.id.login);

        findUserInfo = findViewById(R.id.find_user_info);
        getNewUser = findViewById(R.id.get_new_user);

        getNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToJoinTheMembershipActivity = new Intent(MainActivity.this, JoinTheMembershipActivity.class);
                //여태까지 등록된 user의 아이디가 적힌 리스트를 보내준다. 그래야 중복확인 가능하기 때문이다.
                startActivity(goToJoinTheMembershipActivity);
            }
        });
        //
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}