package userphotograph.student.example.com.pics;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ButtonsFragment extends Fragment implements View.OnClickListener {
    Button bPicasso, bGlide, bFresco;
    Fragment fr;
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.to_picasso:
                fr=new PicassoFragment();
                break;
            case R.id.to_glide:
                fr=new GlideFragment();
                break;

            case R.id.to_fresco:
                 fr=new FrescoFragment();
                break;

        }callFragment(fr);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_buttons, container, false);
        bPicasso=(Button) view.findViewById(R.id.to_picasso);
        bGlide=(Button) view.findViewById(R.id.to_glide);
        bFresco=(Button) view.findViewById(R.id.to_fresco);
        bPicasso.setOnClickListener(this);
        bGlide.setOnClickListener(this);
        bFresco.setOnClickListener(this);

                return view;
    }

void callFragment(Fragment fragment){
    FragmentTransaction tact=getFragmentManager().beginTransaction();
    tact.replace(R.id.fr_place, fragment);
    tact.addToBackStack(null);
    tact.commit();
}
}