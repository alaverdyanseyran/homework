package userphotograph.student.example.com.pics;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import com.facebook.drawee.backends.pipeline.Fresco;
//[MainActivity.java]
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        Fragment fr=new ButtonsFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fr_place, fr).commit();

    }
}
