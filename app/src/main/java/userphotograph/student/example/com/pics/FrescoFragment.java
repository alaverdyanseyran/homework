package userphotograph.student.example.com.pics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;


public class FrescoFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_fresco, container, false);

        //Uri uri = Uri.parse("https://raw.githubusercontent.com/facebook/fresco/master/docs/static/logo.png");
        SimpleDraweeView draweeView = (SimpleDraweeView) view.findViewById(R.id.myFresco);
        draweeView.setImageURI("https://s-media-cache-ak0.pinimg.com/originals/dc/e4/8b/dce48b66a98ce3d2a4c37f88d1af1e40.png");
        return view;
    }

}