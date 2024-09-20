package vn.edu.usth.chatting;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;


public class ChattingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FragmentContainerView bubbleItemContainer = findViewById(R.id.profile_item);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.profile_item, new BubbleItemFragment()).commit();
    }
}